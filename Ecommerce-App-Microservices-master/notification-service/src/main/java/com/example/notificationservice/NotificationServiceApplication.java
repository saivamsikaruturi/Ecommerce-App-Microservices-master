package com.example.notificationservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;

@SpringBootApplication
@Slf4j
@EnableDiscoveryClient
public class NotificationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationServiceApplication.class, args);
	}

	@RetryableTopic(attempts = "4")
	@KafkaListener(topics = "notificationTopic")
     public void handleNotification(OrderPlacedEvent orderPlacedEvent){
		System.out.println("Notification received :: "+ orderPlacedEvent.getOrderNumber());
	}

	@DltHandler
	public void listenDLT(OrderPlacedEvent orderPlacedEvent) {
		System.out.println("DLT Received : {} , from {} , offset {}"+ orderPlacedEvent );
	}

}
