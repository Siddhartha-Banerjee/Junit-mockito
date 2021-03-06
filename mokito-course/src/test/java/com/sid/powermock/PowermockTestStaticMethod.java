package com.sid.powermock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.sid.data.api.todoService;
import com.sid.data.api.todoServiceStub;

@RunWith(PowerMockRunner.class)
@PrepareForTest(UtilityClass.class)
public class PowermockTestStaticMethod 
{
	@Mock
	Dependency dependency;
	
	@InjectMocks
	SystemUnderTest systemUnderTest;
	
	
	@Test
	public void testRetrieveTodosRelatedToSpringMockInjection()
	{
		List<Integer> stats=Arrays.asList(1,2,3);
		when(dependency.retrieveAllStats()).thenReturn(stats);
		
		//mocking static method
		PowerMockito.mockStatic(UtilityClass.class);
		
		when(UtilityClass.staticMethod(6)).thenReturn(150);
		
		int result=systemUnderTest.methodCallingAStaticMethod();
		
		assertEquals(150,result);
		
		PowerMockito.verifyStatic();
		UtilityClass.staticMethod(6);
	}

}
