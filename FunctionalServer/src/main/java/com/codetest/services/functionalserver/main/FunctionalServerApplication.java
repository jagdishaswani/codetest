package com.codetest.services.functionalserver.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author jagdish
 *
 */


@SpringBootApplication
@ComponentScan(basePackages = {"com.codetest.services.functionalserver.controller", "com.codetest.services.functionalserver.service",
								"com.codetest.services.functionalserver.dto", "com.codetest.services.functionalserver.validation",
								"com.codetest.services.functionalserver.exception"})
public class FunctionalServerApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(FunctionalServerApplication.class);
	
	public static void main(String[] args) {
		LOGGER.info("[FunctionalServerApplication] main method of FunctionalServerApplication");
		SpringApplication.run(FunctionalServerApplication.class, args);
	}
}
