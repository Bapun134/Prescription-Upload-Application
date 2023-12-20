package com.example.SpringDemoProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.SpringDemoProject")
@EnableJpaRepositories(basePackages = "com.example.SpringDemoProject.repository")
@EntityScan(basePackages = "com.example.SpringDemoProject.model")


public class SpringDemoProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDemoProjectApplication.class, args);
    }

}
