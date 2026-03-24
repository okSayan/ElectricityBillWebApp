package com.electricitybill;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// This annotation tells Spring Boot: "This is the starting point of the app"
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        // This launches the web server (runs on http://localhost:8080)
        SpringApplication.run(Main.class, args);
    }
}
