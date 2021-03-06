package com.sid.powermock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
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
import org.powermock.reflect.Whitebox;

import com.sid.data.api.todoService;
import com.sid.data.api.todoServiceStub;

@RunWith(PowerMockRunner.class)
@PrepareForTest(SystemUnderTest.class)
public class PowermockTestConstructorMethod 
{
	@InjectMocks
	SystemUnderTest systemUnderTest;
	
	@Mock
	ArrayList mockList;
	
	@Test
	public void testRetrieveTodosRelatedToSpringMockInjection() throws Exception
	{		
		when(mockList.size()).thenReturn(10);
		
		PowerMockito.whenNew(ArrayList.class).withAnyArguments().thenReturn(mockList);
		int size=systemUnderTest.methodUsingAnArrayListConstructor();
		
		assertEquals(10,size);
	}
}
