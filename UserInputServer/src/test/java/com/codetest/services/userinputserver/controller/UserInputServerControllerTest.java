/**
 * 
 */
package com.codetest.services.userinputserver.controller;

/**
 * @author jagdish.kumar
 *
 */



import com.codetest.services.userinputserver.dto.UserInputDto;
import com.codetest.services.userinputserver.exception.UserInputServerException;
import com.codetest.services.userinputserver.service.UserInputServiceImpl;
import com.codetest.services.userinputserver.validation.UserInputValidation;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class UserInputServerControllerTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Mock
    private UserInputServiceImpl userInputService;
    
    @Mock
    private UserInputValidation userInputValidation;

    @InjectMocks
    private UserInputServerController controller;

    @Test
    public void testuserAction() throws UserInputServerException
    {
    	double expected = 25.0;
        final UserInputDto userInputDto = new UserInputDto(Arrays.asList(5.0, 5.0));

        //expectations
        when(userInputValidation.validate("multiply", userInputDto)).thenReturn(true);
        when(userInputService.performOperation("multiply", userInputDto)).thenReturn(25.0);
        
        

        final double result = controller.userAction("multiply", userInputDto);

        //verifications
        assertEquals(expected, result, 0);
    }
    
    

  
}
