/**
 * 
 */
package com.codetest.services.userinputserver.controller;


import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codetest.services.userinputserver.dto.UserInputDto;
import com.codetest.services.userinputserver.exception.UserInputServerException;
import com.codetest.services.userinputserver.service.UserInputService;
import com.codetest.services.userinputserver.validation.UserInputValidation;

/**
 * @author jagdish
 *
 */
@RestController
@RequestMapping("userinput")
public class UserInputServerController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserInputServerController.class);
	
	@Autowired
	private UserInputValidation userInputValidation;
	
	@Autowired
	UserInputService userInputService;
	
	@RequestMapping(method = RequestMethod.POST, value = "{operation}", produces = MediaType.APPLICATION_JSON_VALUE )
	public double userAction(@PathVariable("operation")@Valid String operation, 
			@RequestBody UserInputDto userInputDto) throws UserInputServerException{
		
		LOGGER.info("[UserInputServerController] operation =  {}, numbers = {}, threadId= {}", 
				operation, userInputDto.toString(), Thread.currentThread());
		
		userInputValidation.validate(operation, userInputDto);
		return userInputService.performOperation(operation, userInputDto);
		
	}

}
