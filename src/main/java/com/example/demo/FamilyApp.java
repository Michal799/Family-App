package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.example.demo.dto")
@EntityScan("com.example.demo.dto")
@SpringBootApplication
public class FamilyApp {
    public static void main(String[] args) {
        SpringApplication.run(FamilyApp.class, args);
    }
}