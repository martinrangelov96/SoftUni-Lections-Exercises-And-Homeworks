package org.softuni.productshop.config;

import org.modelmapper.ModelMapper;
import org.softuni.productshop.domain.entities.Order;
import org.softuni.productshop.domain.models.service.OrderServiceModel;
import org.softuni.productshop.mappings.MappingsInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class ApplicationBeanConfiguration {

    private static ModelMapper modelMapper;

    static {
        modelMapper = new ModelMapper();
        MappingsInitializer.initMappings(modelMapper);
    }

    @Bean
    public ModelMapper modelMapper() {
        return modelMapper;
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
