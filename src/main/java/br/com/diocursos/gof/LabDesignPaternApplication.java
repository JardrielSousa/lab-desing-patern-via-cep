package br.com.diocursos.gof;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class LabDesignPaternApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabDesignPaternApplication.class, args);
	}

}
