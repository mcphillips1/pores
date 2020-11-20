package com.osaebros.configuration;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
@Slf4j
@RequiredArgsConstructor
@Service
public class AsynConfig {

    final ThreadPoolTaskExecutor executor;

//    @Bean(name = "taskExecutor")
    public Executor taskExecutor() {
        log.debug("Creating Async Task Executor");
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(2);
        executor.setQueueCapacity(100);
        executor.setThreadNamePrefix("FibThread-");
        executor.initialize();
        return executor;
    }
}