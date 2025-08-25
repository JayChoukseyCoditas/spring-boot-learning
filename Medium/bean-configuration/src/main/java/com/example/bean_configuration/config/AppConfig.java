package com.example.bean_configuration.config;

import com.example.bean_configuration.repository.UserRepository;
import com.example.bean_configuration.service.UserService;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    // Configure a basic UserService bean
    @Bean
    public UserService userService(){
        System.out.println("userService() bean");
        return new UserService();
    }

    // Configure UserService bean with constructor injection
    @Bean
    public UserService userServiceWithConstructor(UserRepository userRepository){
        System.out.println("userServiceWithConstructor() bean");
        return new UserService(userRepository);
    }

    // Configure UserService bean with custom configuration
    @Bean
    public UserService userServiceWithCustomConfig(){
        UserService userService = new UserService();
        userService.setMaxUsersAllowed(100);
        System.out.println("userServiceWithCustomConfig() bean");
        return userService;
    }

    // Configure UserService bean using a factory method
    @Bean
    public UserService userServiceFactory(){
        System.out.println("userServiceFactory() bean");
        return UserService.createServiceWithCustomConfig();
    }

    // Configuring a custom BeanPostProcessor to customize beans
    @Bean
    public BeanPostProcessor customBeanPostProcessor(){
        System.out.println("customBeanPostProcessor() bean");
        return new CustomBeanPostProcessor();
    }

    // Configure UserService bean conditionally based on a property
    @Bean
    @ConditionalOnProperty(prefix = "spring", name = "feature.enabled", havingValue = "true", matchIfMissing = true)
    public UserService conditionalUserService() {
        System.out.println("conditionalUserService() bean");
        return new UserService();
    }
}
