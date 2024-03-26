package com.api1.gateway2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Gateway2Application {

	public static void main(String[] args) {
		SpringApplication.run(Gateway2Application.class, args);
		int i = 21;
		System.out.println(i);
	}


}
