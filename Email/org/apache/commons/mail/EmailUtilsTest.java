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
		boolean result = EmailUtils.isEmpty("abcdefghijklmnopqr");
		//fail("Not yet implemented");
		assertEquals(result,true);
	}

	@Test
	public void testIsNotEmpty() {
		fail("Not yet implemented");
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
