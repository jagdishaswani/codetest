/**
 * 
 */
package com.codetest.services.functionalserver.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.codetest.services.functionalserver.controller.FunctionalServerController;
import com.codetest.services.functionalserver.dto.FunctionalNumberDto;
import com.codetest.services.functionalserver.exception.FunctionalServerException;

/**
 * @author jagdish
 *
 */

//Abstract class for different operators.
abstract class MathOperator {

    public abstract Double operate(List<Double> list);
}

class AddOperator extends MathOperator {

    public Double operate(List<Double> al) {
        return al.stream().reduce((a,b) -> (a + b)).get();
    }
}

class SubtractOperator extends MathOperator {

    public Double operate(List<Double> al) {
        return al.stream().reduce((a,b) -> (a  - b)).get();
    }
}

class MultiplyOperator extends MathOperator {

    public Double operate(List<Double> al) {
        return al.stream().reduce((a,b) -> (a * b)).get();
    }
}

class DivideOperator extends MathOperator {

    public Double operate(List<Double> al) {
        return al.stream().reduce((a,b) -> (a / b)).get();
    }
}
@Service
public class FunctionalServiceImpl implements FunctionalService{
	public Map<String, MathOperator> mathListOperator;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FunctionalServerController.class);

    public FunctionalServiceImpl() {
        mathListOperator = new HashMap<>();
        mathListOperator.put("add", new AddOperator());
        mathListOperator.put("subtract", new SubtractOperator());
        mathListOperator.put("multiply", new MultiplyOperator());
        mathListOperator.put("divide", new DivideOperator());
    }

	@Override
	public double performOperation(String operation, FunctionalNumberDto functionalNumberDto) throws FunctionalServerException {
		LOGGER.info("[FunctionalServiceImpl] perfoming operation =  {}, on following numbers = {}", 
				operation, functionalNumberDto.getNumbers().toString());
		return mathListOperator.get(operation).operate(functionalNumberDto.getNumbers());

	}
    
}
