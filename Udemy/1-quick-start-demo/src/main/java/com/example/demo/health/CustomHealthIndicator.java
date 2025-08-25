package com.example.demo.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        boolean isHealthy = checkCustomHealth();
        if(isHealthy){
            return Health.up().withDetail("Custom Health", "All Systems are operational").build();
        }else{
            return Health.down().withDetail("Custom Health", "Some systems are down").build();
        }
    }

    private boolean checkCustomHealth(){
        return false;
    }
}
