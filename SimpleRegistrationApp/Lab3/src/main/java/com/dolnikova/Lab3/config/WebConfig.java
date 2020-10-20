package com.dolnikova.Lab3.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.dolnikova.Lab3.mapper.StringToEnumMapper;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToEnumMapper());
    }

    @Bean
    public ModelMapper generateModelMapper() {
        return new ModelMapper();
    }

}
