package com.juniorsfredo.xtreme_management_api.core;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper mapperConfig() {
        return new ModelMapper();
    }
}
