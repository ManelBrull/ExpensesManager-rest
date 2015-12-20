package com.mbrull;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmPersistenceConfiguration {

    @Bean
    public EmPersistence emPersistenceImpl() {
        return new EmPersistenceImpl();
    }

}
