package com.sid.data.api;

import java.util.Arrays;
import java.util.List;

public class todoServiceStub implements todoService 
{

	public List<String> retrieveTodo(String user)
	{
		return Arrays.asList("learn spring","learn angular","laern spring boot");
	}

	public void deleteTodo(String Todo) {
		// TODO Auto-generated method stub
		
	}
}
