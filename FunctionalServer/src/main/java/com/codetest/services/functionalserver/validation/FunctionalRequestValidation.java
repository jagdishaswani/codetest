/**
 * 
 */
package com.codetest.services.functionalserver.validation;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


import java.util.Arrays;

import com.codetest.services.functionalserver.dto.FunctionalNumberDto;
import com.codetest.services.functionalserver.exception.FunctionalServerException;



/**
 * @author jagdish
 *
 */

@Component
public class FunctionalRequestValidation {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FunctionalRequestValidation.class);
	
	public enum ValidOperations {add, subtract, divide, multiply};

	public boolean validate(String operation, FunctionalNumberDto functionalNumberDto) 
    {
        if (functionalNumberDto.getNumbers().isEmpty())
        {	
        	LOGGER.info("[FunctionalRequestValidation], validation failed --> functionalDto {} is empty",
        			functionalNumberDto.getNumbers().isEmpty());        	
        			throw new FunctionalServerException("FRS-01: Atleast One number required");
        }	
        else if(!(Arrays.stream(ValidOperations.values()).anyMatch((t) -> t.name().equals(operation))))
        {
        	LOGGER.info("[FunctionalRequestValidation] validation failed --> operation {} does not match to any valid opeations",
        			operation);
        	throw new FunctionalServerException("FRS-02: Operation is not supported");
        }	
        
        LOGGER.info("[FunctionalRequestValidation] Request has been validated");        
        return true;
        
    }
}