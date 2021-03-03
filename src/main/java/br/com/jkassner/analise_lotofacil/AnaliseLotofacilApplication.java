package br.com.jkassner.analise_lotofacil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "br.com.jkassner.analise_lotofacil.repository")
@ComponentScan(basePackages={"br.com.jkassner.*"})
@EntityScan("br.com.jkassner.*")
public class AnaliseLotofacilApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnaliseLotofacilApplication.class, args);
	}

}
