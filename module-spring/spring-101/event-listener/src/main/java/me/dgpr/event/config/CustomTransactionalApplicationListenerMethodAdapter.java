package me.dgpr.event.config;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalApplicationListener;
import org.springframework.transaction.event.TransactionalApplicationListenerMethodAdapter;
import org.springframework.transaction.event.TransactionalEventListener;
import org.springframework.transaction.support.TransactionSynchronizationManager;

public class CustomTransactionalApplicationListenerMethodAdapter
        extends TransactionalApplicationListenerMethodAdapter {

    private static final Logger logger = LoggerFactory.getLogger(
            CustomTransactionalApplicationListenerMethodAdapter.class);

    public CustomTransactionalApplicationListenerMethodAdapter(String beanName,
            Class<?> targetClass, Method method) {
        super(beanName, targetClass, method);
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        try {
            Field callbacksField = this.getClass().getSuperclass().getDeclaredField("callbacks");
            callbacksField.setAccessible(true);
            List<TransactionalApplicationListener.SynchronizationCallback> superClassCallback =
                    (List<TransactionalApplicationListener.SynchronizationCallback>) callbacksField.get(
                            this);

            Field annotationField = this.getClass().getSuperclass().getDeclaredField("annotation");
            annotationField.setAccessible(true);
            TransactionalEventListener superClassAnnotation =
                    (TransactionalEventListener) annotationField.get(this);

            if (TransactionSynchronizationManager.isSynchronizationActive() &&
                    TransactionSynchronizationManager.isActualTransactionActive()) {
                TransactionSynchronizationManager.registerSynchronization(
                        new CustomTransactionalApplicationListenerSynchronization<>(event, this,
                                superClassCallback)
                );
            } else if (superClassAnnotation.fallbackExecution()) {
                if (superClassAnnotation.phase() == TransactionPhase.AFTER_ROLLBACK
                        && logger.isWarnEnabled()) {
                    logger.warn("Processing {} as a fallback execution on AFTER_ROLLBACK phase",
                            event);
                }
                processEvent(event);
            } else {
                if (logger.isDebugEnabled()) {
                    logger.debug("No transaction is active - skipping {}", event);
                }
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            logger.error("Error accessing superclass fields", e);
        }
    }
}

