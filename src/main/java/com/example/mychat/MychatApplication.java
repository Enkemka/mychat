package com.example.mychat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.mychat", "user.messages"})
@EnableMongoRepositories(basePackages = {"com.example.mychat", "user.messages"})
public class MychatApplication {

	public static void main(String[] args) {
		SpringApplication.run(MychatApplication.class, args);
	}

}
