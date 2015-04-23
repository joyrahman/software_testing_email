package org.apache.commons.mail;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EmailTest {
	SimpleEmail email_obj;
	@Before
	public void setup() throws EmailException{
		email_obj = new SimpleEmail();
		email_obj.setMsg("Sending some text message");
		//email_obj.send()
	}
	@Test
	public void testSend() throws EmailException {
		boolean result = false;
		if (email_obj.send() instanceof String)
			result = true;
		assertEquals(result, true);
		
		//assertEquals(type("abc"), instanceof(email_obj.send()));//fail("Not yet implemented");
	}

}
