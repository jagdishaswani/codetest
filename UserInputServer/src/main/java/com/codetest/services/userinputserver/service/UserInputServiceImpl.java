/**
 * 
 */
package com.codetest.services.userinputserver.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.codetest.services.userinputserver.dto.UserInputDto;
import com.codetest.services.userinputserver.exception.UserInputServerException;

/**
 * @author jagdish
 *
 */


@Service
public class UserInputServiceImpl implements UserInputService{
	private static final Logger LOGGER = LoggerFactory.getLogger(UserInputServiceImpl.class);
	
	@Value("${functionalserver.base.url}")
	private String functionalServerBaseUrl;
	
	@Autowired
    private RestTemplate restTemplate;
	
	@Override
	public double performOperation(String operation, UserInputDto userInputDto) throws UserInputServerException{
		LOGGER.info("[UserInputSerrviceImpl] sending  request to Functional Server with operation =  {}, numbers = {}", 
				operation, userInputDto.getNumbers().toString());
        final ResponseEntity<Double> response = restTemplate.postForEntity(functionalServerBaseUrl + "/" + operation, userInputDto, Double.class, operation);
        return response.getBody();
		
	}

}
