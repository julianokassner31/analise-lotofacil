package br.com.jkassner.analise_lotofacil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "br.com.jkassner.analise_lotofacil.repository")
public class AnaliseLotofacilApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnaliseLotofacilApplication.class, args);
	}

}
