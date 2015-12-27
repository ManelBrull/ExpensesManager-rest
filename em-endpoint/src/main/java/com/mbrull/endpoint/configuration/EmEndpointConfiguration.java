package com.mbrull.endpoint.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.mbrull.core.EmCore;
import com.mbrull.endpoint.EmEndpoint;
import com.mbrull.endpoint.EmEndpointImpl;

@Configuration
@ComponentScan("com.mbrull.core.configuration")
public class EmEndpointConfiguration {
    
    @Bean
    public EmEndpoint emEndpointImpl(EmCore core) {
        return new EmEndpointImpl(core);
    }

}
