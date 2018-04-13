/**
 * 
 */
package com.codetest.services.functionalserver.controller;

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

import com.codetest.services.functionalserver.dto.FunctionalNumberDto;
import com.codetest.services.functionalserver.exception.FunctionalServerException;
import com.codetest.services.functionalserver.service.FunctionalService;
import com.codetest.services.functionalserver.validation.FunctionalRequestValidation;





/**
 * @author jagdish
 *
 */
@RestController
@RequestMapping("functional")
public class FunctionalServerController {
	private static final Logger LOGGER = LoggerFactory.getLogger(FunctionalServerController.class);
		@Autowired
		private FunctionalRequestValidation functionalRequestValidation;
		@Autowired
		private FunctionalService functionalService;
		@RequestMapping(method = RequestMethod.POST, value = "{operation}", produces = MediaType.APPLICATION_JSON_VALUE)
		public Double functionalOperation(@PathVariable("operation")@Valid String operation,
											@RequestBody FunctionalNumberDto functionalNumberDto) throws FunctionalServerException
		{
			LOGGER.info("[c.c.s.functionalserver.FunctionalServerController] operation =  {}, numbers = {}, threadId= {}", 
					operation, functionalNumberDto.toString(), Thread.currentThread());
			
			functionalRequestValidation.validate(operation, functionalNumberDto);	
			return functionalService.performOperation(operation, functionalNumberDto);
			
		}

}

