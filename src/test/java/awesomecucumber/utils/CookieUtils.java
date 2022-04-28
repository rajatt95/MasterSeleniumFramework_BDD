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

import io.restassured.http.Cookies;
import org.openqa.selenium.Cookie;

import java.util.ArrayList;
import java.util.List;

public class CookieUtils {

	/*Convert RestAssured Cookies -> Selenium Cookies*/
	public List<Cookie> convertRestAssuredCookiesToSeleniumCookies(Cookies cookies) {
		
		List<io.restassured.http.Cookie> restAssuredCookies;
		restAssuredCookies = cookies.asList();
		
		List<Cookie> seleniumCookies = new ArrayList<>();
		
		for (io.restassured.http.Cookie restAssuredCookie : restAssuredCookies) {
			seleniumCookies.add(
					new Cookie(restAssuredCookie.getName(), 
							restAssuredCookie.getValue(), 
							restAssuredCookie.getDomain(), 
							restAssuredCookie.getPath(),
							restAssuredCookie.getExpiryDate(), 
							restAssuredCookie.isSecured(), 
							restAssuredCookie.isHttpOnly(), 
							/*Present in Selenium 4.x*/
							restAssuredCookie.getSameSite()));
		}
		return seleniumCookies;
	}
}
