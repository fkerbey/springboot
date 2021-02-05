package com.w.springboot;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(SpringbootApplication.class, args);
		int i = System.in.read();
		System.out.println(i);
	}
}
