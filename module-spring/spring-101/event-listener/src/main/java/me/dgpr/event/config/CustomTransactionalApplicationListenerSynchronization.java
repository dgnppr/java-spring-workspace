package me.dgpr.event.config;

import java.util.List;
import org.springframework.context.ApplicationEvent;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalApplicationListener;
import org.springframework.transaction.support.TransactionSynchronization;

public class CustomTransactionalApplicationListenerSynchronization<E extends ApplicationEvent>
        implements TransactionSynchronization {

    private E event;
    private TransactionalApplicationListener<E> listener;
    private List<TransactionalApplicationListener.SynchronizationCallback> callbacks;

    public CustomTransactionalApplicationListenerSynchronization(E event,
            TransactionalApplicationListener<E> listener,
            List<TransactionalApplicationListener.SynchronizationCallback> callbacks) {
        this.event = event;
        this.listener = listener;
        this.callbacks = callbacks;
    }

    @Override
    public int getOrder() {
        return listener.getOrder();
    }

    @Override
    public void beforeCommit(boolean readOnly) {
        if (listener.getTransactionPhase() == TransactionPhase.BEFORE_COMMIT) {
            processEventWithCallbacks();
        }
    }

    // 커스텀하게 설정
    @Override
    public void afterCommit() {
        if (listener.getTransactionPhase() == TransactionPhase.AFTER_COMMIT) {
            processEventWithCallbacks();
        }
    }

    @Override
    public void afterCompletion(int status) {
        if (listener.getTransactionPhase() == TransactionPhase.AFTER_ROLLBACK
                && status == STATUS_ROLLED_BACK) {
            processEventWithCallbacks();
        } else if (listener.getTransactionPhase() == TransactionPhase.AFTER_COMPLETION) {
            processEventWithCallbacks();
        }
    }

    private void processEventWithCallbacks() {
        callbacks.forEach(callback -> callback.preProcessEvent(event));
        try {
            listener.onApplicationEvent(event);
        } catch (RuntimeException | Error ex) {
            callbacks.forEach(callback -> callback.postProcessEvent(event, ex));
            throw ex;
        }
        callbacks.forEach(callback -> callback.postProcessEvent(event, null));
    }
}
