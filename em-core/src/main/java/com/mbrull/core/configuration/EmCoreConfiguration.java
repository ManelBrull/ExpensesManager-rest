package com.mbrull.core.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.mbrull.core.EmCore;
import com.mbrull.core.EmCoreImpl;
import com.mbrull.persistence.EmPersistence;

@Configuration
@ComponentScan("com.mbrull.persistence.configuration")
public class EmCoreConfiguration {

    @Bean
    public EmCore emCoreImpl(EmPersistence persistence) {
        return new EmCoreImpl(persistence);
    }

}
