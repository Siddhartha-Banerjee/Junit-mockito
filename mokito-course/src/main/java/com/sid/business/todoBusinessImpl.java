package com.sid.business;

import java.util.ArrayList;
import java.util.List;

import com.sid.data.api.todoService;

public class todoBusinessImpl 
{
	private todoService todoService;

	public todoBusinessImpl(todoService todoService) 
	{
		//super();
		this.todoService = todoService;
	}
	
	public List<String> retrieveTodoRelatedToSpring(String user)
	{
		List<String> filteredTodos= new ArrayList<String>();
		List<String> todos=todoService.retrieveTodo(user);
		
		for(String todo:todos)
		{
			if(todo.contains("spring"))
			{
				filteredTodos.add(todo);
			}
		}
		return filteredTodos;
	}
	
	
	public void deleteTodosNotRelatedToSpring(String user)
	{
		List<String> filteredTodos= new ArrayList<String>();
		List<String> todos=todoService.retrieveTodo(user);
		
		for(String todo:todos)
		{
			if(!todo.contains("spring"))
			{
				todoService.deleteTodo(todo);
			}
		}
	}
}
