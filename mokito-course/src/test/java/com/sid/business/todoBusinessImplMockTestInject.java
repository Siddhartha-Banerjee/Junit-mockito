package com.sid.business;

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

import com.sid.data.api.todoService;
import com.sid.data.api.todoServiceStub;

//@RunWith(MockitoJUnitRunner.class)
public class todoBusinessImplMockTestInject 
{
	@Rule
	public MockitoRule mockitorule=MockitoJUnit.rule();
	//runwith only 1 time but rule multiple times like springrule, junitrule etc
	
	@Mock
	todoService todoService;
	
	@InjectMocks
	todoBusinessImpl tdbi;
	
	@Captor
	ArgumentCaptor<String> strargcap;
	
	@Test
	public void testRetrieveTodosRelatedToSpringMockInjection()
	{
		System.out.println("xxxx");
		List<String> todoList=Arrays.asList("learn spring","learn angular","laern spring boot");
		when(todoService.retrieveTodo("dummy")).thenReturn(todoList);
		
		List<String>filteredTodos=tdbi.retrieveTodoRelatedToSpring("dummy");
		
		assertEquals(2,filteredTodos.size());
	}

}
