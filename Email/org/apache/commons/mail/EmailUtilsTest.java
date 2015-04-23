package org.apache.commons.mail;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EmailUtilsTest {
	@Before
	public void create(){
		//EmailUtils email;
		System.out.println("Running the test");
	}
	@Test
	public void testIsEmpty() {
		boolean expected = true;
		boolean result = true;
		String[] input = {"abcdefghijklmnop","test",""};
		for (String i : input)
		{
			result = EmailUtils.isEmpty(i);
			assertEquals(result,expected);	
			
		}
		//fail("Not yet implemented");
		//assertEquals(result,expected);
	}

	@Test
	public void testIsNotEmpty() {
		boolean expected = true;
		boolean result = true;
		String[] input = {"abcdefghijklmnopqrst","test",""};
		for (String i : input)
		{
			result = EmailUtils.isNotEmpty(i);
			assertEquals(result,expected);	
			/*
			if (result==false){
				break;
			}
			*/
		}
		//assertEquals(result,expected);	

		//boolean result = EmailUtils.isNotEmpty(input[]);
		//assertEquals(result, expected);
	}

	@Test
	public void testNotNull() {
		fail("Not yet implemented");
	}

	@Test
	public void testRandomAlphabetic() {
		fail("Not yet implemented");
	}

	@Test
	public void testEncodeUrl() {
		fail("Not yet implemented");
	}

	@Test
	public void testWriteMimeMessage() {
		fail("Not yet implemented");
	}

}
