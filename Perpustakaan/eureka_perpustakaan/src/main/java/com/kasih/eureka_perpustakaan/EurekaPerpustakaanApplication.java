package com.kasih.eureka_perpustakaan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaPerpustakaanApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaPerpustakaanApplication.class, args);
	}

}
