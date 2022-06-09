package com.sid.mokito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.stub;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class spyTest 
{

	@Test
	public void test() 
	{
		List arrayListSpy=spy(ArrayList.class);
		assertEquals(0,arrayListSpy.size());
		stub(arrayListSpy.size()).toReturn(5);
		assertEquals(5,arrayListSpy.size());
		arrayListSpy.add("dummy");
		verify(arrayListSpy).add("dummy");
		verify(arrayListSpy,never()).clear();
	}

}
