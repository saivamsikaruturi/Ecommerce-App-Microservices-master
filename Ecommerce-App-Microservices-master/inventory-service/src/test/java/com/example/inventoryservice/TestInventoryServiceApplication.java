package com.example.inventoryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration(proxyBeanMethods = false)
public class TestInventoryServiceApplication {

//	@Bean
//	@ServiceConnection
//	PostgreSQLContainer<?> postgresContainer() {
//		return new PostgreSQLContainer<>(DockerImageName.parse("postgres:latest"));
//	}

	public static void main(String[] args) {
		SpringApplication.from(InventoryServiceApplication::main).with(TestInventoryServiceApplication.class).run(args);
	}

}
