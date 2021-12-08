package com.appsdeveloperblog.rentacar.api.rental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RenACarApiRentalApplication {

    public static void main(String[] args) {
        SpringApplication.run(RenACarApiRentalApplication.class, args);
    }

}
