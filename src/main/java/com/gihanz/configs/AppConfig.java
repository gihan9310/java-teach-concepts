package com.gihanz.configs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration

@EnableAsync
@Slf4j
public class AppConfig {

    @Bean(name = "taskExecutor")
    public Executor taskExecutor() {
        log.info("Thread pool initializing..............");
        final ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(4);
        executor.setMaxPoolSize(4);
        executor.setQueueCapacity(100);
        executor.setThreadNamePrefix("thread EGB : ");
        executor.initialize();
        return executor;
    }

}
