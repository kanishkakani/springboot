package com.example.springkafkaproducer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/send")
public class KafkaProducerController {
	
	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;

	@RequestMapping("/{name}")
	public void sendToKafka(@PathVariable("name") String name) {
		kafkaTemplate.send("springbootdemo", "Hello " + name);
	}
}
