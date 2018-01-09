package com.beck.tobias.rockpaperscissor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class RockpaperscissorApplication {

	public static void main(String[] args) {
		SpringApplication.run(RockpaperscissorApplication.class, args);
	}
}
