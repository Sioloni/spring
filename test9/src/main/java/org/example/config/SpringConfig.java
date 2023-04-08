package org.example.config;


import org.example.test.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("application.properties")
public class SpringConfig {

    @Bean
    public User user(){
        return new User();
    }
}
