package com.springyapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringyApiApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringyApiApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(SpringyApiApplication.class, args);
		log.info("\n\n****************************\n\nSpringyAPI started!\n\n****************************\n\n");
	}

}
