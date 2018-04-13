/**
 * 
 */
package com.codetest.services.userinputserver.main;

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
@ComponentScan(basePackages = {"com.codetest.services.userinputserver.controller", "com.codetest.services.userinputserver.validation",
								"com.codetest.services.userinputserver.dto", "com.codetest.services.userinputserver.service",
								"com.codetest.services.userinputserver.config", "com.codetest.services.userinputserver.exception"})
public class UserInputServerApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserInputServerApplication.class);
	
	
	
	public static void main(String[] args) {
		LOGGER.info("[UserInputServerApplication] main method of UserInputServerApplication");
		SpringApplication.run(UserInputServerApplication.class, args);
	}
	
	
}
