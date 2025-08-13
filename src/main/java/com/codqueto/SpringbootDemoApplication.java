package com.codqueto;

import com.codqueto.components.Thanos;
import com.codqueto.models.PowerStone;
import com.codqueto.models.Stone;
import com.codqueto.services.GauntletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
public class SpringbootDemoApplication implements CommandLineRunner {

//	@Autowired
//	private Thanos thanos;
//
//	@Value(value="${spring.not.found:default-value}")
//	private String value;
//
//	@Autowired
//	@Qualifier(value="power")
//	private Stone powerStone;
//
//	@Autowired
//	@Qualifier(value="mind")
//	private Stone mindStone;
//
//	@Autowired
//	@Qualifier(value="reality")
//	private Stone realityStone;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		System.out.println(powerStone);
//		System.out.println(mindStone);
//		System.out.println(realityStone);
//		thanos.snap();
	}
}
