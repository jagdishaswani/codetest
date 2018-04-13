/**
 * 
 */
package com.codetest.services.functionalserver.service;

import com.codetest.services.functionalserver.dto.FunctionalNumberDto;


/**
 * @author jagdish
 *
 */
public interface FunctionalService {

	double performOperation(String operation, FunctionalNumberDto functionalNumberDto);
}
