package awesomecucumber.java_Mail_API;

import static awesomecucumber.constants.FrameworkConstants.PROJECT_NAME;

/**
 * Data for Sending EMail after execution
 */
public class EmailConfig {

	public static final String SERVER = "smtp.gmail.com";
	public static final String PORT = "587";

	public static final String FROM = "*****@gmail.com";
	public static final String PASSWORD = "******8";

	/* "**********@gmail.com", */
	public static final String[] TO = { "****@gmail.com" };
	public static final String SUBJECT = PROJECT_NAME;
}