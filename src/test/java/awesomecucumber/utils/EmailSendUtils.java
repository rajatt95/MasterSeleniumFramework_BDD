/**
 * @author Rajat Verma
 * https://www.linkedin.com/in/rajat-v-3b0685128/
 * https://github.com/rajatt95
 * https://rajatt95.github.io/
 *
 * Course: Cucumber BDD Masterclass with Selenium 4 & Java + Framework (https://www.udemy.com/course/cucumber-bdd-masterclass/)
 * Tutor: Omprakash Chavan (https://www.udemy.com/user/omprakash-chavan/)
 */

/***************************************************/

package awesomecucumber.utils;

import static awesomecucumber.constants.FrameworkConstants.PROJECT_NAME;
import static awesomecucumber.constants.FrameworkConstants.REPORTS_CUCUMBER_LOCAL;
import static awesomecucumber.constants.FrameworkConstants.YES;
import static awesomecucumber.java_Mail_API.EmailConfig.FROM;
import static awesomecucumber.java_Mail_API.EmailConfig.PASSWORD;
import static awesomecucumber.java_Mail_API.EmailConfig.PORT;
import static awesomecucumber.java_Mail_API.EmailConfig.SERVER;
import static awesomecucumber.java_Mail_API.EmailConfig.SUBJECT;
import static awesomecucumber.java_Mail_API.EmailConfig.TO;

import javax.mail.MessagingException;

import awesomecucumber.java_Mail_API.EmailAttachmentsSender;

public class EmailSendUtils {

	/**
	 * sendEmail_WithAttachmentsAndFormattedBodyText_ToManyUsersRajat
	 */
	public static void sendEmail() {
		System.out.println("****************************************");
		System.out.println("Email send - START");
		System.out.println("****************************************");

		if (ConfigLoader.getInstance().getSendEmailToUsers().equalsIgnoreCase(YES)) {
			System.out.println("File name: " + REPORTS_CUCUMBER_LOCAL);

			String messageBody = getTestCasesCountInFormat();
			System.out.println(messageBody);

			try {
				EmailAttachmentsSender.sendEmailWithAttachments(SERVER, PORT, FROM, PASSWORD, TO, SUBJECT, messageBody,
						REPORTS_CUCUMBER_LOCAL);

				System.out.println("****************************************");
				System.out.println("Email sent successfully.");
				System.out.println("****************************************");
			} catch (MessagingException e) {
				e.printStackTrace();
			}

		}

	}

	private static String getTestCasesCountInFormat() {

		return "<html>\r\n" + "\r\n" + " \r\n" + "\r\n"
				+ "        <body> \r\n<table class=\"container\" align=\"center\" style=\"padding-top:20px\">\r\n<tr align=\"center\"><td colspan=\"4\"><h2>"
				+ PROJECT_NAME + "</h2></td></tr>\r\n<tr><td>\r\n\r\n"
				+ "       <table style=\"background:#67c2ef;width:120px\" >\r\n"
				+ "                     <tr><td style=\"font-size: 36px\" class=\"value\" align=\"center\">"
				+ "</td></tr>\r\n" + "                     <tr><td align=\"center\">Total</td></tr>\r\n" + "       \r\n"
				+ "                </table>\r\n" + "                </td>\r\n" + "                <td>\r\n"
				+ "               \r\n" + "                 <table style=\"background:#79c447;width:120px\">\r\n"
				+ "                     <tr><td style=\"font-size: 36px\" class=\"value\" align=\"center\">"
				+ "</td></tr>\r\n" + "                     <tr><td align=\"center\">Passed</td></tr>\r\n"
				+ "       \r\n" + "                </table>\r\n" + "                </td>\r\n"
				+ "                <td>\r\n" + "                <table style=\"background:#ff5454;width:120px\">\r\n"
				+ "                     <tr><td style=\"font-size: 36px\" class=\"value\" align=\"center\">"
				+ "</td></tr>\r\n" + "                     <tr><td align=\"center\">Failed</td></tr>\r\n"
				+ "       \r\n" + "                </table>\r\n" + "                \r\n" + "                </td>\r\n"
				+ "                <td>\r\n" + "                <table style=\"background:#fabb3d;width:120px\">\r\n"
				+ "                     <tr><td style=\"font-size: 36px\" class=\"value\" align=\"center\">"
				+ "</td></tr>\r\n" + "                     <tr><td align=\"center\">Skipped</td></tr>\r\n"
				+ "       \r\n" + "                </table>\r\n" + "                \r\n" + "                </td>\r\n"
				+ "                </tr>\r\n" + "               \r\n" + "                \r\n"
				+ "            </table>\r\n" + "       \r\n" + "    </body>\r\n" + "</html>";
	}

}
