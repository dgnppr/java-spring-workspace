package me.dgpr.event.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.event.TransactionalEventListenerFactory;

@Configuration
public class CustomAdaptorConfig {

    @Bean
    public TransactionalEventListenerFactory transactionalEventListenerFactory() {
        return new CustomTransactionalEventListenerFactory();
    }
}