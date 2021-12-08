package com.appsdeveloperblog.rentacar.discovery.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class RentACarDiscoveryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RentACarDiscoveryServiceApplication.class, args);
    }

}
