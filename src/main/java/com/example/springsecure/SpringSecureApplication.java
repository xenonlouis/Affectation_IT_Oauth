package com.example.springsecure;

import com.example.springsecure.Repository.UserRepository;
import com.example.springsecure.Service.UserDetailsServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
public class SpringSecureApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecureApplication.class, args);
    }

}
