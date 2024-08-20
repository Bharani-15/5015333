package com.example.BookstoreAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//New Features in Spring Boot 3:
//Java 17+ Support: Spring Boot 3.x supports Java 17 and newer features.
//Improved Native Image Support: Enhanced support for building native images using GraalVM.
//Observability Enhancements: Built-in observability support with Micrometer.
//New AOT Engine: Ahead-of-time (AOT) compilation for improved startup time.
//Improved Dependency Management: Better control and management of dependencies.

@SpringBootApplication
public class BookstoreApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApiApplication.class, args);
	}

}
