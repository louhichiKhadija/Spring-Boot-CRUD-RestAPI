package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.example.demo.utiles.FileStorageProperties;


@SpringBootApplication()
@EnableConfigurationProperties({ FileStorageProperties.class })
public class FirstProjectApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(FirstProjectApplication.class, args);
	}

}
