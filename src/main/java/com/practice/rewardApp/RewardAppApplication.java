package com.practice.rewardApp;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
        info = @Info(
                title = "Reward microservice REST API Documentation",
                description = "Reward microservice REST API Documentation",
                version = "v1",
                contact = @Contact(
                        name = "Asit bhakat",
                        email = "test@gmail.com",
                        url = "https://www.testurl.com"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.testurl.com"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "Bank microservice REST API Documentation",
                url = "https://www.testurl.com/swagger-ui.html"

        )
)
public class RewardAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(RewardAppApplication.class, args);
    }

}
