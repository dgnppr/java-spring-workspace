package me.dgpr.config;

import java.util.concurrent.Executor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@EnableAsync
@Configuration
public class AsyncConfig implements AsyncConfigurer {

    private static final Logger log = LoggerFactory.getLogger(AsyncConfig.class);
    private final int processors = Runtime.getRuntime().availableProcessors();

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

        log.info("Initializing async executor");
        log.info("Available processors count: {}", processors);

        executor.setCorePoolSize(processors);
        log.info("Setting core pool size: {}", processors);

        executor.setMaxPoolSize(processors * 2);
        log.info("Setting max pool size: {}", processors * 2);

        executor.setQueueCapacity(50);
        log.info("Setting queue capacity: 50");

        executor.setKeepAliveSeconds(60);
        log.info("Setting keep alive seconds: 60");

        executor.setThreadNamePrefix("AsyncExecutor-");
        log.info("Setting thread name prefix: AsyncExecutor-");

        executor.initialize();
        log.info("Async executor initialized");

        return executor;
    }

    @Bean(name = "taskExecutor")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        int processors = Runtime.getRuntime().availableProcessors();

        log.info("Setting up custom task executor with {} processors", processors);

        executor.setCorePoolSize(processors);
        executor.setMaxPoolSize(processors * 2);
        executor.setQueueCapacity(100);
        executor.setThreadNamePrefix("CustomExecutor-");
        executor.setKeepAliveSeconds(60);
        executor.initialize();

        return executor;
    }
}
