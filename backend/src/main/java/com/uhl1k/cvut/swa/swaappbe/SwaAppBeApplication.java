package com.uhl1k.cvut.swa.swaappbe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SwaAppBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwaAppBeApplication.class, args);
	}
}
