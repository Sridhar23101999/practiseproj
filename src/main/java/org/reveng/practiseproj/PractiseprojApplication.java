package org.reveng.practiseproj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("org.reveng.practiseproj.entity")
@EnableJpaRepositories("org.reveng.practiseproj.repository")
public class PractiseprojApplication {

	public static void main(String[] args) {
		SpringApplication.run(PractiseprojApplication.class, args);
	}

}
