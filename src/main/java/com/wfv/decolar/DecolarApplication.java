package com.wfv.decolar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class DecolarApplication {

	public static void main(String[] args) {
		SpringApplication.run(DecolarApplication.class, args);
	}

}
