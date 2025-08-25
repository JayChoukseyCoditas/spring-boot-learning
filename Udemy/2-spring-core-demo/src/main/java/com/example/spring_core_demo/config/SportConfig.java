package com.example.spring_core_demo.config;

import com.example.spring_core_demo.common.Coach.Coach;
import com.example.spring_core_demo.common.Coach.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("aquatic")
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
