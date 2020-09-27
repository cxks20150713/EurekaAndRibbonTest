package com.icepoint.eurekaclientribbonalone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaClientRibbonAloneApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientRibbonAloneApplication.class, args);
    }

}
