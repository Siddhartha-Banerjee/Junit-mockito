package com.sid.business;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.Test;

public class ListTest 
{

	@Test(expected=RuntimeException.class)
	public void letsMockListSizeMethod() 
	{
		List listMock=mock(List.class);
		when(listMock.size()).thenReturn(2).thenReturn(3);
		assertEquals(2,listMock.size());
		assertEquals(3,listMock.size());
		
		//argument matcher
		when(listMock.get(anyInt())).thenReturn("sid");
		System.out.println(listMock.get(0));
		System.out.println(listMock.get(1));
		
		//Exception
		when(listMock.get(0)).thenThrow(new RuntimeException("something"));
		System.out.println(listMock.get(0));

		
	}

}
