package com.icepoint.eurekaclientribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaClientRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientRibbonApplication.class, args);
    }

}
