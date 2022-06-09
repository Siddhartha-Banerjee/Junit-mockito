package com.sid.data.api;

import java.util.List;

public interface todoService 
{
	public List<String> retrieveTodo(String user);
	
	public void deleteTodo(String Todo);
}
