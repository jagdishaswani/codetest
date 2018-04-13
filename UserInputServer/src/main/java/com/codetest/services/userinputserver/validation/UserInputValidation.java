/**
 * 
 */
package com.codetest.services.userinputserver.validation;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import com.codetest.services.userinputserver.dto.UserInputDto;
import com.codetest.services.userinputserver.exception.UserInputServerException;


/**
 * @author jagdish
 *
 */

@Component
public class UserInputValidation {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserInputValidation.class);
	
	public enum ValidOperations {add, subtract, divide, multiply};

	public boolean validate(String operation, UserInputDto userInputDto) 
    {
        if (userInputDto.getNumbers().isEmpty())
        {	
        	LOGGER.info("[UserInputValidation], validation failed --> userinputDto {} is empty",
        			userInputDto.getNumbers().isEmpty());
        	
        	throw new UserInputServerException("UIS-01: Atleast One number required");
        }	
        else if(!(Arrays.stream(ValidOperations.values()).anyMatch((t) -> t.name().equals(operation))))
        {
        	LOGGER.info("[UserInputValidation] validation failed --> operation {} does not match to any valid opeations",
        			operation);
         	throw new UserInputServerException("UIS-02: Operation is not supported");
        }	
        
        LOGGER.info("[UserInputValidation] Request has been validated");        
        return true;
        
    }
}