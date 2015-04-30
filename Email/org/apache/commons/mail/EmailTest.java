package org.apache.commons.mail;

import static org.junit.Assert.*;

import java.util.Properties;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

import sun.security.krb5.internal.Authenticator;

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
	
	/**
	 * Test method for {@link org.apache.commons.mail.Email#setDebug(boolean)}.
	 */
	@Test
	public void testSetDebug() {
		email_obj.setDebug(true);
		assertEquals(true,email_obj.debug);
	}

	/**
	 * Test method That tests the creation of the instance of DefaultAuthenicator.
	 */
	@Test
	public void testSetAuthentication() {
		email_obj.setAuthentication("test", "test");
		assertTrue(email_obj.authenticator instanceof DefaultAuthenticator);
	}

	/**
	 * Test method for {@link org.apache.commons.mail.Email#setAuthenticator(javax.mail.Authenticator)}.
	 */
//	@Test
//	public void testSetAuthenticator() {
//		byte[] test_seed = new byte[12];
//		Authenticator test_auth = new Authenticator(test_seed);
//		email_obj.setAuthenticator(test_auth);
//	}


//	/**
//	 * Test method for {@link org.apache.commons.mail.Email#setContent(javax.mail.internet.MimeMultipart)}.
//	 */
//	@Test
//	public void testSetContentMimeMultipart() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	/**
//	 * Test method for {@link org.apache.commons.mail.Email#setContent(java.lang.Object, java.lang.String)}.
//	 */
//	@Test
//	public void testSetContentObjectString() {
//		fail("Not yet implemented"); // TODO
//	}

	/**
	 * Test method for {@link org.apache.commons.mail.Email#updateContentType(java.lang.String)}.
	 */
	@Test
	public void testUpdateContentType() {

		String[] input = {"text/plain"};
		for (String i : input)
		{
			email_obj.updateContentType(i);
			assertEquals(i,email_obj.contentType);	
			
		}
		
	}

//	/**
//	 * Test method for {@link org.apache.commons.mail.Email#setHostName(java.lang.String)}.
//	 */
//	@Test
//	public void testSetHostName() {
//		fail("Not yet implemented"); // TODO
//	}

//	/**
//	 * Test method for {@link org.apache.commons.mail.Email#setTLS(boolean)}.
//	 */
//	@Test
//	public void testSetTLS() {
//		fail("Not yet implemented"); // TODO
//	}

	/**
	 * Test method for {@link org.apache.commons.mail.Email#setStartTLSEnabled(boolean)}.
	 */
	@Test
	public void testSetStartTLSEnabled() {
		
		assertTrue(email_obj.setStartTLSEnabled(true) instanceof Email);
	}

	/**
	 * Test method for {@link org.apache.commons.mail.Email#setStartTLSRequired(boolean)}.
	 */
	@Test
	public void testSetStartTLSRequired() {
		assertTrue(email_obj.setStartTLSRequired(true) instanceof Email);
	}



	/**
     * Supply a mail Session object to use. Please note that passing
     * a user name and password (in the case of mail authentication) will
     * create a new mail session with a DefaultAuthenticator. This is a
     * convenience but might come unexpected.
     *
     * If mail authentication is used but NO username and password
     * is supplied the implementation assumes that you have set a
     * authenticator and will use the existing mail session (as expected).
     *
     * @param aSession mail session to be used
     * @throws IllegalArgumentException if the session is {@code null}
     * @since 1.0
     */
	
	@Test(expected=IllegalArgumentException.class)
	public void testSetMailSession() {
		Properties props = new Properties();
		//Override props with any customized data
		PasswordAuthentication auth = new PasswordAuthentication("test_user", "test_password");
		Session session = Session.getDefaultInstance(props);
		
		//Session test = new Session(null, new Authenticator(null));
		email_obj.setMailSession(session);
		
		
	}

	/**
	 * Test method for {@link org.apache.commons.mail.Email#setMailSessionFromJNDI(java.lang.String)}.
	 * @throws NamingException 
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testSetMailSessionFromJNDI_illegalException() throws Exception {
		//fail("Not yet implemented"); // TODO
		email_obj.setMailSessionFromJNDI(null);
		
	}
	@Test(expected=NamingException.class)
	public void testSetMailSessionFromJNDI_namingException() throws Exception{
		email_obj.setMailSessionFromJNDI("java:localhost");
		
	}

	/**
	 * Test method for getMailSession()}
	 * returns EmailException.
	 * @throws EmailException 
	 */
	@Test(expected=EmailException.class)
	public void testGetMailSession() throws EmailException {
		email_obj.getMailSession();
	}

	/**
	 * Test method for {@link org.apache.commons.mail.Email#setFrom(java.lang.String)}.
	 * @throws EmailException 
	 */
	@Test(expected=EmailException.class)
	public void testSetFromString() throws EmailException {
		email_obj.setFrom("test email");
	}

	/**
	 * Test method for setFrom(java.lang.String, java.lang.String)}.
	 * @throws EmailException 
	 */
	@Test(expected=EmailException.class)
	public void testSetFromStringString() throws EmailException {
		email_obj.setFrom("test email", "test name");
	}

	/**
	 * Test method for setFrom(java.lang.String, java.lang.String, java.lang.String)}.
	 * @throws EmailException
	 */
	
	@Test(expected=EmailException.class)
	public void testSetFromStringStringString() throws EmailException {
		email_obj.setFrom("test_email", "test_name", "en");
	}

	/**
	 * Test method for {@link org.apache.commons.mail.Email#addTo(java.lang.String)}.
	 * @throws EmailException 
	 */
	@Test(expected=EmailException.class)
	public void testAddToString() throws EmailException {
		email_obj.addTo("test email");
	}

	/**
	 * Test method for {@link org.apache.commons.mail.Email#addTo(java.lang.String[])}.
	 * @throws EmailException 
	 */
	@Test(expected=EmailException.class)
	public void testAddToStringArray() throws EmailException {
		String[] input = {"test2","test1","test2"};
		email_obj.addTo(input);
	}

	/**
	 * Test method for {@link org.apache.commons.mail.Email#addTo(java.lang.String, java.lang.String)}.
	 *
     * Add a recipient TO to the email using the specified address and the
     * specified personal name.
     * The name will be encoded by the charset of
     * {@link #setCharset(java.lang.String) setCharset()}.
     * If it is not set, it will be encoded using
     * the Java platform's default charset (UTF-16) if it contains
     * non-ASCII characters; otherwise, it is used as is.
     *
     * @param email A String.
     * @param name A String.
     * @return An Email.
     * @throws EmailException Indicates an invalid email address.
     * @since 1.0
     */
	@Test(expected=EmailException.class)
	public void testAddToStringString() throws EmailException {
		email_obj.addTo("test","test");
	}

	/**
	 * Test method for {@link org.apache.commons.mail.Email#addTo(java.lang.String, java.lang.String, java.lang.String)}.
	 * @throws EmailException 
	 */
	@Test(expected=EmailException.class)
	public void testAddToStringStringString() throws EmailException {
		email_obj.addTo("test","test","UTF-8");
	}
//
	/**
	 * Test method for {@link org.apache.commons.mail.Email#setTo(java.util.Collection)}.
	 * @throws EmailException 
	 */
	@Test(expected=EmailException.class)
	public void testSetTo() throws EmailException {
		email_obj.setTo(null);
	}
//
//	/**
//	 * Test method for {@link org.apache.commons.mail.Email#addCc(java.lang.String)}.
//	 */
//	@Test
//	public void testAddCcString() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	/**
//	 * Test method for {@link org.apache.commons.mail.Email#addCc(java.lang.String[])}.
//	 */
//	@Test
//	public void testAddCcStringArray() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	/**
//	 * Test method for {@link org.apache.commons.mail.Email#addCc(java.lang.String, java.lang.String)}.
//	 */
//	@Test
//	public void testAddCcStringString() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	/**
//	 * Test method for {@link org.apache.commons.mail.Email#addCc(java.lang.String, java.lang.String, java.lang.String)}.
//	 */
//	@Test
//	public void testAddCcStringStringString() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	/**
//	 * Test method for {@link org.apache.commons.mail.Email#setCc(java.util.Collection)}.
//	 */
//	@Test
//	public void testSetCc() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	/**
//	 * Test method for {@link org.apache.commons.mail.Email#addBcc(java.lang.String)}.
//	 */
//	@Test
//	public void testAddBccString() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	/**
//	 * Test method for {@link org.apache.commons.mail.Email#addBcc(java.lang.String[])}.
//	 */
//	@Test
//	public void testAddBccStringArray() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	/**
//	 * Test method for {@link org.apache.commons.mail.Email#addBcc(java.lang.String, java.lang.String)}.
//	 */
//	@Test
//	public void testAddBccStringString() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	/**
//	 * Test method for {@link org.apache.commons.mail.Email#addBcc(java.lang.String, java.lang.String, java.lang.String)}.
//	 */
//	@Test
//	public void testAddBccStringStringString() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	/**
//	 * Test method for {@link org.apache.commons.mail.Email#setBcc(java.util.Collection)}.
//	 */
//	@Test
//	public void testSetBcc() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	/**
//	 * Test method for {@link org.apache.commons.mail.Email#addReplyTo(java.lang.String)}.
//	 */
//	@Test
//	public void testAddReplyToString() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	/**
//	 * Test method for {@link org.apache.commons.mail.Email#addReplyTo(java.lang.String, java.lang.String)}.
//	 */
//	@Test
//	public void testAddReplyToStringString() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	/**
//	 * Test method for {@link org.apache.commons.mail.Email#addReplyTo(java.lang.String, java.lang.String, java.lang.String)}.
//	 */
//	@Test
//	public void testAddReplyToStringStringString() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	/**
//	 * Test method for {@link org.apache.commons.mail.Email#setReplyTo(java.util.Collection)}.
//	 */
//	@Test
//	public void testSetReplyTo() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	/**
//	 * Test method for {@link org.apache.commons.mail.Email#setHeaders(java.util.Map)}.
//	 */
//	@Test
//	public void testSetHeaders() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	/**
//	 * Test method for {@link org.apache.commons.mail.Email#addHeader(java.lang.String, java.lang.String)}.
//	 */
//	@Test
//	public void testAddHeader() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	/**
//	 * Test method for {@link org.apache.commons.mail.Email#setSubject(java.lang.String)}.
//	 */
//	@Test
//	public void testSetSubject() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	/**
//	 * Test method for {@link org.apache.commons.mail.Email#setBounceAddress(java.lang.String)}.
//	 */
//	@Test
//	public void testSetBounceAddress() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	/**
//	 * Test method for {@link org.apache.commons.mail.Email#setMsg(java.lang.String)}.
//	 */
//	@Test
//	public void testSetMsg() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	/**
//	 * Test method for {@link org.apache.commons.mail.Email#buildMimeMessage()}.
//	 */
//	@Test
//	public void testBuildMimeMessage() {
//		fail("Not yet implemented"); // TODO
//	}
//
//
//	/**
//	 * Test method for {@link org.apache.commons.mail.Email#getMimeMessage()}.
//	 */
//	@Test
//	public void testGetMimeMessage() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	/**
//	 * Test method for {@link org.apache.commons.mail.Email#send()}.
//	 */
//
//
//	/**
//	 * Test method for {@link org.apache.commons.mail.Email#setSentDate(java.util.Date)}.
//	 */
//	@Test
//	public void testSetSentDate() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	/**
//	 * Test method for {@link org.apache.commons.mail.Email#getSentDate()}.
//	 */
//	@Test
//	public void testGetSentDate() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	/**
//	 * Test method for {@link org.apache.commons.mail.Email#getSubject()}.
//	 */
//	@Test
//	public void testGetSubject() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	/**
//	 * Test method for {@link org.apache.commons.mail.Email#getFromAddress()}.
//	 */
//	@Test
//	public void testGetFromAddress() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	/**
//	 * Test method for {@link org.apache.commons.mail.Email#getHostName()}.
//	 */
//	@Test
//	public void testGetHostName() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	/**
//	 * Test method for {@link org.apache.commons.mail.Email#getSmtpPort()}.
//	 */
//	@Test
//	public void testGetSmtpPort() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	/**
//	 * Test method for {@link org.apache.commons.mail.Email#isStartTLSRequired()}.
//	 */
//	@Test
//	public void testIsStartTLSRequired() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	/**
//	 * Test method for {@link org.apache.commons.mail.Email#isStartTLSEnabled()}.
//	 */
//	@Test
//	public void testIsStartTLSEnabled() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	/**
//	 * Test method for {@link org.apache.commons.mail.Email#isTLS()}.
//	 */
//	@Test
//	public void testIsTLS() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	/**
//	 * Test method for {@link org.apache.commons.mail.Email#toInternetAddressArray(java.util.List)}.
//	 */
//	@Test
//	public void testToInternetAddressArray() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	/**
//	 * Test method for {@link org.apache.commons.mail.Email#setPopBeforeSmtp(boolean, java.lang.String, java.lang.String, java.lang.String)}.
//	 */
//	@Test
//	public void testSetPopBeforeSmtp() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	/**
//	 * Test method for {@link org.apache.commons.mail.Email#isSSL()}.
//	 */
//	@Test
//	public void testIsSSL() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	/**
//	 * Test method for {@link org.apache.commons.mail.Email#isSSLOnConnect()}.
//	 */
//	@Test
//	public void testIsSSLOnConnect() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	/**
//	 * Test method for {@link org.apache.commons.mail.Email#setSSL(boolean)}.
//	 */
//	@Test
//	public void testSetSSL() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	/**
//	 * Test method for {@link org.apache.commons.mail.Email#setSSLOnConnect(boolean)}.
//	 */
//	@Test
//	public void testSetSSLOnConnect() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	/**
//	 * Test method for {@link org.apache.commons.mail.Email#isSSLCheckServerIdentity()}.
//	 */
//	@Test
//	public void testIsSSLCheckServerIdentity() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	/**
//	 * Test method for {@link org.apache.commons.mail.Email#setSSLCheckServerIdentity(boolean)}.
//	 */
//	@Test
//	public void testSetSSLCheckServerIdentity() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	/**
//	 * Test method for {@link org.apache.commons.mail.Email#getSslSmtpPort()}.
//	 */
//	@Test
//	public void testGetSslSmtpPort() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	/**
//	 * Test method for {@link org.apache.commons.mail.Email#setSslSmtpPort(java.lang.String)}.
//	 */
//	@Test
//	public void testSetSslSmtpPort() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	/**
//	 * Test method for {@link org.apache.commons.mail.Email#isSendPartial()}.
//	 */
//	@Test
//	public void testIsSendPartial() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	/**
//	 * Test method for {@link org.apache.commons.mail.Email#setSendPartial(boolean)}.
//	 */
//	@Test
//	public void testSetSendPartial() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	/**
//	 * Test method for {@link org.apache.commons.mail.Email#getToAddresses()}.
//	 */
//	@Test
//	public void testGetToAddresses() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	/**
//	 * Test method for {@link org.apache.commons.mail.Email#getCcAddresses()}.
//	 */
//	@Test
//	public void testGetCcAddresses() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	/**
//	 * Test method for {@link org.apache.commons.mail.Email#getBccAddresses()}.
//	 */
//	@Test
//	public void testGetBccAddresses() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	/**
//	 * Test method for {@link org.apache.commons.mail.Email#getReplyToAddresses()}.
//	 */
//	@Test
//	public void testGetReplyToAddresses() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	/**
//	 * Test method for {@link org.apache.commons.mail.Email#getSocketConnectionTimeout()}.
//	 */
//	@Test
//	public void testGetSocketConnectionTimeout() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	/**
//	 * Test method for {@link org.apache.commons.mail.Email#setSocketConnectionTimeout(int)}.
//	 */
//	@Test
//	public void testSetSocketConnectionTimeout() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	/**
//	 * Test method for {@link org.apache.commons.mail.Email#getSocketTimeout()}.
//	 */
//	@Test
//	public void testGetSocketTimeout() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	/**
//	 * Test method for {@link org.apache.commons.mail.Email#setSocketTimeout(int)}.
//	 */
//	@Test
//	public void testSetSocketTimeout() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	/**
//	 * Test method for {@link org.apache.commons.mail.Email#createMimeMessage(javax.mail.Session)}.
//	 */
//	@Test
//	public void testCreateMimeMessage() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	/**
//	 * Test method for {@link java.lang.Object#Object()}.
//	 */
//	@Test
//	public void testObject() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	/**
//	 * Test method for {@link java.lang.Object#getClass()}.
//	 */
//	@Test
//	public void testGetClass() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	/**
//	 * Test method for {@link java.lang.Object#hashCode()}.
//	 */
//	@Test
//	public void testHashCode() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	/**
//	 * Test method for {@link java.lang.Object#equals(java.lang.Object)}.
//	 */
//	@Test
//	public void testEquals() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	/**
//	 * Test method for {@link java.lang.Object#clone()}.
//	 */
//	@Test
//	public void testClone() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	/**
//	 * Test method for {@link java.lang.Object#toString()}.
//	 */
//	@Test
//	public void testToString() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	/**
//	 * Test method for {@link java.lang.Object#notify()}.
//	 */
//	@Test
//	public void testNotify() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	/**
//	 * Test method for {@link java.lang.Object#notifyAll()}.
//	 */
//	@Test
//	public void testNotifyAll() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	/**
//	 * Test method for {@link java.lang.Object#wait(long)}.
//	 */
//	@Test
//	public void testWaitLong() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	/**
//	 * Test method for {@link java.lang.Object#wait(long, int)}.
//	 */
//	@Test
//	public void testWaitLongInt() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	/**
//	 * Test method for {@link java.lang.Object#wait()}.
//	 */
//	@Test
//	public void testWait() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	/**
//	 * Test method for {@link java.lang.Object#finalize()}.
//	 */
//	@Test
//	public void testFinalize() {
//		fail("Not yet implemented"); // TODO
//	}

}
