package com.fibospiralmatrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan({ "com.fibospiralmatrix"})
public class FiboSpiralMatrixApplication {

	public static void main(String[] args) {
		SpringApplication.run(FiboSpiralMatrixApplication.class, args);
	}

}
