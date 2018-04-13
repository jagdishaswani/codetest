/**
 * 
 */
package com.codetest.services.userinputserver.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jagdish
 *
 */

public class UserInputDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//A defulat constructor required for serialization
	private UserInputDto() {}
	
	private List<Double> numbers;
	
	
	public List<Double> getNumbers() {
		if (numbers == null)
        {
            return new ArrayList<>();
        }
        return numbers;
	}
	public UserInputDto(List<Double> numbers) {
		this.numbers = numbers;
	}
	
	
	@Override
    public String toString()
    {
        return Arrays.toString(getNumbers().toArray());
    }
	
	

}
