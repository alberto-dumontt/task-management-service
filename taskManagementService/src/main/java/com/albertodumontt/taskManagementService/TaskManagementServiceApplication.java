package com.albertodumontt.taskManagementService;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.mongodb.autoconfigure.MongoAutoConfiguration;

@OpenAPIDefinition(
		info = @Info(
				title = "Task Management API",
				description = "API for managing tasks with creation, update, completion and expiration dates",
				version = "1.0.0",
				contact = @Contact(
						name = "Alberto Dumontt",
						email = "albertodumonttdev@outlook.com",
						url = "https://www.linkedin.com/in/alberto-dumontt"
				)
		)
)
@SpringBootApplication
@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class})
public class TaskManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskManagementServiceApplication.class, args);
	}

}