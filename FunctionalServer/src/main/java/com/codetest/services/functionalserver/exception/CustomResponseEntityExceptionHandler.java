package com.codetest.services.functionalserver.exception;
import java.time.Instant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomResponseEntityExceptionHandler.class);
	

	
    @ExceptionHandler(FunctionalServerException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ErrorDetails handleException(FunctionalServerException exception)
    {
    	LOGGER.error(exception.getMessage());

        //for overriding the default Spring handler and use our own format
        return new ErrorDetails.ErrorDetailsBuilder()
                .message(exception.getMessage())
                .status(HttpStatus.BAD_REQUEST.value())
                .timestamp(Instant.now().toEpochMilli())
                .build();
    }
    
    
}
