package com.test.ecommercespring;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcommerceSpringApplication {

    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.configure().load();  // load the .env file form the root path.
        // this will get the environment variable and set them.
        dotenv.entries().forEach(entries -> System.setProperty(entries.getKey(), entries.getValue()));
        SpringApplication.run(EcommerceSpringApplication.class, args);
    }

}