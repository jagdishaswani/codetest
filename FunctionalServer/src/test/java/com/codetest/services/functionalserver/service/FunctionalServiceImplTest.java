/**
 * 
 */
package com.codetest.services.functionalserver.service;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.codetest.services.functionalserver.dto.FunctionalNumberDto;

/**
 * @author jagdish
 *
 */
public class FunctionalServiceImplTest {


    private FunctionalService functionalService;

    @Before
    public void setUp() throws Exception
    {
    	functionalService = new FunctionalServiceImpl();
    }


    @Test
    public void performOperation() throws Exception
    {
        final FunctionalNumberDto functiobalNumberDto = new FunctionalNumberDto(Arrays.asList(30.0 + 20.0));
        final double result = functionalService.performOperation("add", functiobalNumberDto);

      //verifications
        assertEquals(50.0, result, 0);
    }
}
