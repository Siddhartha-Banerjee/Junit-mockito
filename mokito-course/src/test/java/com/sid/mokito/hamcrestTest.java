package com.sid.mokito;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matcher.*;

import org.junit.Test;

public class hamcrestTest {

	@Test
	public void test() 
	{
		List<Integer> scores=Arrays.asList(99,100,108,55);
		//assertThat(scores, hasSize(4));
		assertThat(scores, hasItems(99,100));
		//assertThat(scores, everyItem(lessThan(50)));
		//assertThat(scores, everyItem(greaterThan(50)));
		
		//assertThat("",isEmptyString());
		//assertThat(null,isEmptyOrNullString());
		
//		Integer[] marks= {1,2,3,4};
//		assertThat(marks,arrayContaining(1,2,3));
//		assertThat(marks,arrayContainingInAnyOrder(2,1,3));
//		assertThat(marks,arrayWithSize(3));
		
	}

}
