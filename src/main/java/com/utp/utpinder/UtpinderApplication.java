package com.utp.utpinder;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application.properties")
public class UtpinderApplication {

	public static void main(String[] args) {
		SpringApplication.run(UtpinderApplication.class, args);
	}

}
