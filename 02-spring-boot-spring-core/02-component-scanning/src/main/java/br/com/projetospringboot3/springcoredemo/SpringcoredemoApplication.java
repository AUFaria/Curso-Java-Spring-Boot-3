package br.com.projetospringboot3.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
@SpringBootApplication(
		scanBasePackages = {"br.com.projetospringboot3.springcoredemo", "br.com.projetospringboot3.util"}
)
*/
@SpringBootApplication
public class SpringcoredemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcoredemoApplication.class, args);
	}

}
