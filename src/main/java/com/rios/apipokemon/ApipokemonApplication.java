package com.rios.apipokemon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.rios"})
@EntityScan( basePackages = {"com.rios"} )
@EnableJpaRepositories(basePackages = "com.rios")
public class ApipokemonApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApipokemonApplication.class, args);
	}

}
