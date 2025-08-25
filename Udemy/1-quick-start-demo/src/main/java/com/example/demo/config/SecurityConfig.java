package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/actuator/**").authenticated() // Secure Actuator
                        .anyRequest().permitAll() // Open all other endpoints
                )
                .httpBasic(Customizer.withDefaults()) // Basic auth for Actuator
                .csrf(csrf -> csrf.disable()); // Disable CSRF for simplicity (customize as needed)

        return http.build();
    }
}


