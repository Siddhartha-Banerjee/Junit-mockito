package com.sid.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.sid.data.api.todoService;
import com.sid.data.api.todoServiceStub;

public class todoBusinessImplMockTest 
{
	@Test
	public void testRetrieveTodosRelatedToSpringMock()
	{
		
		todoService todoService=
				//new todoServiceStub();
				mock(todoService.class);
		System.out.println("xxxx");
		List<String> todoList=Arrays.asList("learn spring","learn angular","laern spring boot");
		when(todoService.retrieveTodo("dummy")).thenReturn(todoList);
		
		todoBusinessImpl tdbi=new todoBusinessImpl(todoService);
		List<String>filteredTodos=tdbi.retrieveTodoRelatedToSpring("dummy");
		
		assertEquals(2,filteredTodos.size());
	}

}
