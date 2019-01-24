package it.objectmethod.leggixml;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("it")
public class LeggixmlApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeggixmlApplication.class, args);
	}

}

