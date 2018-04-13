/**
 * 
 */
package com.codetest.services.functionalserver.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.codetest.services.functionalserver.controller.FunctionalServerController;
import com.codetest.services.functionalserver.dto.FunctionalNumberDto;
import com.codetest.services.functionalserver.exception.FunctionalServerException;
import com.codetest.services.functionalserver.service.FunctionalServiceImpl;
import com.codetest.services.functionalserver.validation.FunctionalRequestValidation;

/**
 * @author jagdish
 *
 */
	@RunWith(MockitoJUnitRunner.class)
	public class FunctionalServerControllerTest {

	    @Rule
	    public ExpectedException thrown = ExpectedException.none();

	    @Mock
	    private FunctionalServiceImpl functionalService;
	    
	    @Mock
	    private FunctionalRequestValidation functionalRequestValidation;

	    @InjectMocks
	    private FunctionalServerController functionalController;

	    @Test
	    public void testuserAction() throws FunctionalServerException
	    {
	    	double expected = 50.0;
	        final FunctionalNumberDto functionalNumberDto = new FunctionalNumberDto(Arrays.asList(25.0, 25.0));

	        //expectations
	        when(functionalRequestValidation.validate("add", functionalNumberDto)).thenReturn(true);
	        when(functionalService.performOperation("add", functionalNumberDto)).thenReturn(50.0);
	        
	       
	        final double result = functionalController.functionalOperation("add", functionalNumberDto);

	        //verifications
	        assertEquals(expected, result, 0);
	    }
	}
	    
	    

