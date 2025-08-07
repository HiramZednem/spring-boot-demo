package com.codqueto;

import com.codqueto.models.PowerStone;
import com.codqueto.services.GauntletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
public class SpringbootDemoApplication implements CommandLineRunner {

	@Value(value="${spring.not.found:default-value}")
	private String value;

	@Autowired
	private PowerStone powerStone;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(powerStone);
	}
}
