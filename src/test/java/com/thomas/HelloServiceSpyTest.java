package com.thomas;

import com.thomas.repository.HelloRepository;
import com.thomas.services.HelloService;
import com.thomas.services.HelloServiceImpl;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class HelloServiceSpyTest {

	@SpyBean
    private HelloRepository helloRepository;

    @Autowired
    @InjectMocks
    private HelloService helloService = new HelloServiceImpl();

    @Test
    void testReturnedValueWithoutAnyMockingWithMockito() {
    	//Arrange
    	//  nothing to arrange...
    	//Act
    	String actualValue = helloService.get();
    	//Assert
    	String expectedValue = "Hello from HelloRepository";
        assertEquals(expectedValue, actualValue);
    }
    
    @Test
    void testNumberOfCallsWithMockito() {
    	//Arrange
    	//  nothing to arrange...
    	//Act
    	helloService.get();
    	//Assert
    	Mockito.verify(helloRepository, Mockito.times(1)).get();
    }
}