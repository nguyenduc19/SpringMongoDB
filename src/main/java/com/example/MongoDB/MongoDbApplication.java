package com.example.MongoDB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class MongoDbApplication {

	public static void main(String[] args) {

		SpringApplication.run(MongoDbApplication.class, args);
	}

}
