package com.w.springboot;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@RestController
@SpringBootApplication
public class SpringbootApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(SpringbootApplication.class, args);
		int i = System.in.read();
		System.out.println(i);
	}
	
	/*@RequestMapping("/")
    public String greeting() {
        return "Hello World!";
    }*/
}
