package me.dgpr.event.config;

import java.lang.reflect.Method;
import org.springframework.context.ApplicationListener;
import org.springframework.transaction.event.TransactionalEventListenerFactory;

public class CustomTransactionalEventListenerFactory extends TransactionalEventListenerFactory {

    @Override
    public ApplicationListener<?> createApplicationListener(
            String beanName,
            Class<?> type,
            Method method
    ) {
        return new CustomTransactionalApplicationListenerMethodAdapter(beanName, type, method);
    }
}
