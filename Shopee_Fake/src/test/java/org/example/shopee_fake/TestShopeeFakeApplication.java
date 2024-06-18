package org.example.shopee_fake;

import org.springframework.boot.SpringApplication;

public class TestShopeeFakeApplication {

	public static void main(String[] args) {
		SpringApplication.from(ShopeeFakeApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
