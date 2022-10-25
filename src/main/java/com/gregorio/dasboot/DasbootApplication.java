package com.gregorio.dasboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class DasbootApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DasbootApplication.class, args);
		//context.getEnvironment().getSystemProperties().forEach((k, v) -> System.out.println("Key: " + k + " Value: " + v));
	}

	@Bean
	WebClient webClient() {
		return WebClient.create("http://localhost:8081");
	}

}

