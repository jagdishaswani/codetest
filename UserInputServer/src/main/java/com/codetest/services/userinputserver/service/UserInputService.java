/**
 * 
 */
package com.codetest.services.userinputserver.service;

import com.codetest.services.userinputserver.dto.UserInputDto;

/**
 * @author jagdish
 *
 */
public interface UserInputService {
	double performOperation(String operation, UserInputDto userInputDto);

}
