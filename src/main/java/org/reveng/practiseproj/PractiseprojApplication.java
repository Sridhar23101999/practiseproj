package org.reveng.practiseproj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class PractiseprojApplication {

	public static void main(String[] args) {
		SpringApplication.run(PractiseprojApplication.class, args);
	}

}
