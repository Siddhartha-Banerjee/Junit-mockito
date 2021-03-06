package com.sid.business;

import static org.hamcrest.CoreMatchers.is;
//import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;

import com.sid.data.api.todoService;
import com.sid.data.api.todoServiceStub;

public class todoBusinessImplMockBDDTest 
{
	@Captor
	ArgumentCaptor<String> argcap;
	
	@Test
	public void testRetrieveTodosRelatedToSpringMockBDD()
	{
		//given
		todoService todoService=mock(todoService.class);
		System.out.println("xxxx");
		List<String> todoList=Arrays.asList("learn spring","learn angular","laern spring boot");
		given(todoService.retrieveTodo("dummy")).willReturn(todoList);
		
		todoBusinessImpl tdbi=new todoBusinessImpl(todoService);
		
		//when
		List<String>filteredTodos=tdbi.retrieveTodoRelatedToSpring("dummy");
		
		//then
		assertThat(filteredTodos.size(), is(2));
	}
	
	
	@Test
	public void testDeleteTodosNotRelatedToSpringMockBDD()
	{
		//given
		todoService todoService=mock(todoService.class);
		System.out.println("xxxx");
		List<String> todoList=Arrays.asList("learn spring","learn angular","laern spring boot");
		given(todoService.retrieveTodo("dummy")).willReturn(todoList);
		
		todoBusinessImpl tdbi=new todoBusinessImpl(todoService);
		
		//when
		tdbi.deleteTodosNotRelatedToSpring("dummy");
		
		//then
		
		//verify(todoService).deleteTodo("laern spring boot");
		then(todoService).should().deleteTodo("laern spring boot");
		
		//verify(todoService, times(1)).deleteTodo("learn angular");
		verify(todoService, atLeast(1)).deleteTodo("learn angular");
		
		//verify(todoService,never()).deleteTodo("learn spring");
		then(todoService).should(never()).deleteTodo("learn spring");
	}
	
	
	@Test
	public void testDeleteTodosNotRelatedToSpringMockBDD_ArgumentCapture()
	{
		//Declare argument captor
		//ArgumentCaptor<String> argcap=ArgumentCaptor.forClass(String.class);
		
		//given
		todoService todoService=mock(todoService.class);
		System.out.println("xxxx");
		List<String> todoList=Arrays.asList("learn spring","learn angular","laern spring boot");
		given(todoService.retrieveTodo("dummy")).willReturn(todoList);
		
		todoBusinessImpl tdbi=new todoBusinessImpl(todoService);
		
		//when
		tdbi.deleteTodosNotRelatedToSpring("dummy");
		
		//then
		
		//verify(todoService).deleteTodo("laern spring boot");
		then(todoService).should(times(2)).deleteTodo(argcap.capture());
		
		assertThat(argcap.getValue(),is("learn angular"));
		assertThat(argcap.getAllValues().size(),is(2));

		
		
	}

}
