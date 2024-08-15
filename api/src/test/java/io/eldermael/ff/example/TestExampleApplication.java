package io.eldermael.ff.example;

import org.springframework.boot.SpringApplication;

public class TestExampleApplication {

	public static void main(String[] args) {
		SpringApplication.from(ExampleApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
