package com.example.springkafkaconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class SpringkafkaconsumerApplication {
	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;
	public static void main(String[] args) {
		SpringApplication.run(SpringkafkaconsumerApplication.class, args);
	}

	@KafkaListener(topics = "springbootdemo", groupId = "group1")
	public void listen(String message) {
		System.out.println("Message received - " + message);
	}

}
