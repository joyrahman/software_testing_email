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
	
    /**
     * Set the charset of the message. Please note that you should set the charset before
     * adding the message content.
     *
     * @param newCharset A String.
     * @throws java.nio.charset.IllegalCharsetNameException if the charset name is invalid
     * @throws java.nio.charset.UnsupportedCharsetException if no support for the named charset
     * exists in the current JVM
     * @since 1.0
     * */
 
	/*@Test(expected=IndexOutOfBoundsException.class)
		public void testIndexOutOfBoundsException() {
    			ArrayList emptyList = new ArrayList();
    			Object o = emptyList.get(0);
			}
	 * */
	
	@Test(expected=java.nio.charset.IllegalCharsetNameException.class)
	public void testSetCharset_throwsIllegalCharset() throws EmailException{
		//boolean expected = java.nio.charset.IllegalCharsetNameException.class; 
		String input = "ascii";
		email_obj.setCharset(input);
		
		
		
	}
	@Test(expected=java.nio.charset.UnsupportedCharsetException.class)
	public void testSetCharset_throwsUnsupportedCharset() throws EmailException{
		//boolean expected = java.nio.charset.IllegalCharsetNameException.class; 
		String input = "ascii";
		email_obj.setCharset(input);
		
		
		
	}
	/* Valid TCP Port number for SMTP is between 0 to 65535
	 * The code seems like only checking anything below 1 without checking zero and 
	 * the upper limit to 65535
	 * IllegalArgumentException 
	 * */
	@Test(expected=IllegalArgumentException.class)
	 public void testSetSmtpPort()
	 {
		int[] input = {1,65570};
		for (int i :input){
			email_obj.setSmtpPort(i);
		}
		
		 
	 }
	/*SendMimeMessage*/
	@Test(expected=IllegalArgumentException.class)
	public void testSendMimeMessage() throws EmailException{
		//email_obj.message="";
		email_obj.sendMimeMessage();
	}

}
