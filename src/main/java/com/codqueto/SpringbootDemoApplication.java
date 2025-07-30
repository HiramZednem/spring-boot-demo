package com.codqueto;

import com.codqueto.services.GauntletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootDemoApplication implements CommandLineRunner {

	@Autowired
	GauntletService gauntletService;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		gauntletService.useFullPower();
	}
}
