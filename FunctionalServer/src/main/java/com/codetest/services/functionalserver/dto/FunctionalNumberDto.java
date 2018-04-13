/**
 * 
 */
package com.codetest.services.functionalserver.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jagdish
 *
 */
public class FunctionalNumberDto {

	private static final long serialVersionUID = 1L;
	//A default constructor required for serialization
	private FunctionalNumberDto() {}
	
	private List<Double> numbers;
	
	
	public List<Double> getNumbers() {
		if (numbers == null)
        {
            return new ArrayList<>();
        }
        return numbers;
	}
	public FunctionalNumberDto(List<Double> numbers) {
		this.numbers = numbers;
	}
	
	
	@Override
    public String toString()
    {
        return Arrays.toString(getNumbers().toArray());
    }
	

}
