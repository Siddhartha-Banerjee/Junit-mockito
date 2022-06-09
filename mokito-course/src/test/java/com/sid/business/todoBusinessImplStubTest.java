package com.sid.business;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.sid.data.api.todoService;
import com.sid.data.api.todoServiceStub;

public class todoBusinessImplStubTest 
{
	@Test
	public void test()
	{
		todoService tds=new todoServiceStub();
		todoBusinessImpl tdbi=new todoBusinessImpl(tds);
		List<String>filteredTodos=tdbi.retrieveTodoRelatedToSpring("dummy");
		assertEquals(2,filteredTodos.size());
	}

}
