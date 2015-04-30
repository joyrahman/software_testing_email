package org.apache.commons.mail;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
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

	/**
	 * Test method for addCc(java.lang.String)}.
	 * @param email A String.
     * @return An Email.
     * @throws EmailException Indicates an invalid email address.
	 */
	@Test(expected=EmailException.class)
	public void testAddCcString() throws EmailException{
		email_obj.addCc("test");
	}

	/**
	 * Test method for {@link org.apache.commons.mail.Email#addCc(java.lang.String[])}.
	 * @param email A String.
     * @return An Email.
     * @throws EmailException Indicates an invalid email address.
	 */
	@Test(expected=EmailException.class)
	public void testAddCcStringArray() throws EmailException{
		String input[] = {"test","test2"};
		email_obj.addCc(input);
	}

	/**
	 * Test method for {@link org.apache.commons.mail.Email#addCc(java.lang.String, java.lang.String)}.
     * @param email A String.
     * @param name A String.
     * @return An Email.
     * @throws EmailException Indicates an invalid email address.
	 */
	@Test(expected=EmailException.class)
	public void testAddCcStringString() throws EmailException{
		email_obj.addCc("test_email","test_name");
	}

	/**
	 * Test method for {@link org.apache.commons.mail.Email#addCc(java.lang.String, java.lang.String, java.lang.String)}.
     * Add a recipient CC to the email using the specified address, personal
     * name, and charset encoding for the name.
     * @param email A String.
     * @param name A String.
     * @param charset The charset to encode the name with.
     * @return An Email.
     * @throws EmailException Indicates an invalid email address or charset.
	*/
	@Test(expected=EmailException.class)
	public void testAddCcStringStringString() throws EmailException {
			email_obj.addCc("test_email","test_name","UTF-16");
	}
	


    /**
    * Test method for {@link org.apache.commons.mail.Email#setCc(java.util.Collection)}.
    * Set a list of "CC" addresses. All elements in the specified
    * <code>Collection</code> are expected to be of type
    * <code>java.mail.internet.InternetAddress</code>.
    * @param aCollection collection of <code>InternetAddress</code> objects.
    * @return An Email.
    * @throws EmailException Indicates an invalid email address. 
	*/
	@Test(expected=EmailException.class)
	public void testSetCc() throws EmailException {
		email_obj.setCc(null);
	}


	/**
	 * Test method for addBcc(java.lang.String)}.
	 * @param email A String.
     * @return An Email.
     * @throws EmailException Indicates an invalid email address.
	 */
	@Test(expected=EmailException.class)
	public void testAddBccString() throws EmailException{
		email_obj.addBcc("test");
	}

	@Test(expected=EmailException.class)
	public void testAddBccStringArray() throws EmailException{
		String input[] = {"test","test2"};
		email_obj.addBcc(input);
	}

	@Test(expected=EmailException.class)
	public void testAddBccStringString() throws EmailException{
		email_obj.addBcc("test_email","test_name");
	}

	@Test(expected=EmailException.class)
	public void testAddBccStringStringString() throws EmailException {
			email_obj.addBcc("test_email","test_name","UTF-16");
	}
	
	
    /**
    * Test method for {@link org.apache.commons.mail.Email#setBcc(java.util.Collection)}.
    * Set a list of "BCC" addresses. All elements in the specified
    * <code>Collection</code> are expected to be of type
    * <code>java.mail.internet.InternetAddress</code>.
    * @param aCollection collection of <code>InternetAddress</code> objects.
    * @return An Email.
    * @throws EmailException Indicates an invalid email address. 
	*/
	@Test(expected=EmailException.class)
	public void testSetBcc() throws EmailException {
		email_obj.setBcc(null);
	}
	/**
	 * Test method for {@link org.apache.commons.mail.Email#addReplyTo(java.lang.String)}.
	 * Add a reply to address to the email. The email
     * address will also be used as the personal name.
     * The name will be encoded by the charset of {@link #setCharset(java.lang.String) setCharset()}.
     * If it is not set, it will be encoded using
     * the Java platform's default charset (UTF-16) if it contains
     * non-ASCII characters; otherwise, it is used as is.
     *
     * @param email A String.
     * @return An Email.
     * @throws EmailException Indicates an invalid email address
 
	 */

	@Test(expected=EmailException.class)
	public void testAddReplyToString() throws EmailException {
		email_obj.addReplyTo("test");
	}
	@Test(expected=EmailException.class)
	public void testAddReplyToStringString() throws EmailException{
		email_obj.addBcc("test_email","test_name");
	}
	@Test(expected=EmailException.class)
	public void testAddReplyToStringStringString() throws EmailException{
		email_obj.addBcc("test_email","test_name","UTF-8");
	}


	/**
	* Test method for {@link org.apache.commons.mail.Email#setReplyTo(java.util.Collection)}.
	* Set a list of reply to addresses. All elements in the specified
    * <code>Collection</code> are expected to be of type
    * <code>java.mail.internet.InternetAddress</code>.
    *
    * @param   aCollection collection of <code>InternetAddress</code> objects
    * @return  An Email.
    * @throws EmailException Indicates an invalid email address
    
	*/
	@Test(expected=EmailException.class)
	public void testSetReplyTo() throws EmailException {
		email_obj.setReplyTo(null);
	}

	/**
	 * Test method for {@link org.apache.commons.mail.Email#setHeaders(java.util.Map)}.
	 * Used to specify the mail headers.  Example:
     *
     * X-Mailer: Sendmail, X-Priority: 1( highest )
     * or  2( high ) 3( normal ) 4( low ) and 5( lowest )
     * Disposition-Notification-To: user@domain.net
     *
     * @param map A Map.
     * @throws IllegalArgumentException if either of the provided header / value is null or empty
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testSetHeaders() {
		Map<String, String> input = new HashMap<String, String>();
		input.put("test1","test1");
		input.put("test2","test2");
		
		email_obj.setHeaders(input);
	}

	/**
	 * Test method for {@link org.apache.commons.mail.Email#addHeader(java.lang.String, java.lang.String)}.
	 * Adds a header ( name, value ) to the headers Map.
     *

     * @param name A String with the name.
     * @param value A String with the value.
     * @since 1.0
     * @throws IllegalArgumentException if either {@code name} or {@code value} is null or empty
   
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testAddHeader() {
		email_obj.addHeader("test", null);
		email_obj.addHeader(null, null);
	}

	/**
	 * Test method for {@link org.apache.commons.mail.Email#setSubject(java.lang.String)}.
    * Set the email subject.
    *
    * @param aSubject A String.
    * @return An Email.
    * @since 1.0
	*/
	
	@Test
	public void testSetSubject() {

		Email test = email_obj.setSubject("test@gmail.com");
		assertTrue(test instanceof Email );
		//asserttEqual(Email.class, test.getClass());
	}

	/**
	 * Test method for {@link org.apache.commons.mail.Email#setBounceAddress(java.lang.String)}.
	 * Set the "bounce address" - the address to which undeliverable messages
     * will be returned.  If this value is never set, then the message will be
     * sent to the address specified with the System property "mail.smtp.from",
     * or if that value is not set, then to the "from" address.
     *
     * @param email A String.
     * @return An Email.
     * @throws IllegalStateException when the mail session is already initialized
     * @since 1.0
	 */
	@Test
	public void testSetBounceAddress() {
		Email test = email_obj.setBounceAddress("test");
		assertTrue(test instanceof Email );
	}


    /**
     * Does the work of actually building the MimeMessage. Please note that
     * a user rarely calls this method directly and only if he/she is
     * interested in the sending the underlying MimeMessage without
     * commons-email.
     *
     * @throws IllegalStateException if the MimeMessage was already built
     * @throws EmailException if there was an error.
     * @since 1.0
     */
	
	@Test(expected=EmailException.class)
	public void testBuildMimeMessage() throws EmailException {
		email_obj.buildMimeMessage();
	}


	/**
	 * Test method for {@link org.apache.commons.mail.Email#getMimeMessage()}.
	 *     /**
     * Returns the internal MimeMessage. Please not that the
     * MimeMessage is build by the buildMimeMessage() method.
     *
     * @return the MimeMessage
	 * @throws EmailException 
     *
	 */
	@Test
	public void testGetMimeMessage() throws EmailException {
		email_obj.buildMimeMessage();
		MimeMessage test = email_obj.getMimeMessage();
		assertTrue(test instanceof MimeMessage);
	}

	/** Test method for setSentDate
     * Expected : Sets the sent date for the email. The sent date will default to the
     * current date if not explicitly set.
     *
     * @param date Date to use as the sent date on the email
     */
	
	@Test 
	public void testSetSentDate(){
		email_obj.setSentDate(null);
		assertTrue(email_obj.sentDate!=null);
		
	}

	/**
	* Test method for {@link org.apache.commons.mail.Email#getSentDate()}.
    * Gets the sent date for the email.
    *
    * @return date to be used as the sent date for the email
    * @since 1.0
	*/
	@Test
	public void testGetSentDate() {
		Date test = email_obj.getSentDate();
		assertTrue(test instanceof Date);
	}

	/* Test method for getHostName()
	 * Gets the host name of the SMTP server,
     *
     * @return host name
     */

	@Test
	public void testGetHostName() {
		String input = "localhost";
		email_obj.hostName=input;
		String result = email_obj.getHostName();
		assertEquals(result, input);
	}

	/**
	 * Test method for getSmtpPort()}.
	 */
	@Test
	public void testGetSmtpPort() {
		String result = email_obj.getSmtpPort();
		assertTrue(result instanceof String);
	}

	/**
	 * Test method for {@link org.apache.commons.mail.Email#getSslSmtpPort()}.
    * Returns the current SSL port used by the SMTP transport.
    *
    * @return the current SSL port used by the SMTP transport
	 */
	@Test
	public void testGetSslSmtpPort() {
		String result = email_obj.getSslSmtpPort();
		assertTrue(result instanceof String);
	}

	/**
	 * Test method for {@link org.apache.commons.mail.Email#createMimeMessage(javax.mail.Session)}.
	 *
     * Factory method to create a customized MimeMessage which can be
     * implemented by a derived class, e.g. to set the message id.
     *
     * @param aSession mail session to be used
     * @return the newly created message
	 */
	@Test
	public void testCreateMimeMessage() {
		//Session aSession = new Session(null, null);
		MimeMessage output = email_obj.createMimeMessage(null);
		assertTrue(output instanceof MimeMessage);
		
	}

//	/**
//	 * Test method for {@link java.lang.Object#Object()}.

//	@Test
//	public void testFinalize() {
//		fail("Not yet implemented"); // TODO
//	}

}
