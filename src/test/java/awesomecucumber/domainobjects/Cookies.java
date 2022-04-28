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

package awesomecucumber.domainobjects;

import awesomecucumber.utils.CookieUtils;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class Cookies {

	private io.restassured.http.Cookies cookies;

	public io.restassured.http.Cookies getCookies() {
		return cookies;
	}

	public void setCookies(io.restassured.http.Cookies cookies) {
		this.cookies = cookies;
	}

	public void injectCookiesToBrowser(WebDriver driver) {
		List<Cookie> seleniumCookies = new CookieUtils().convertRestAssuredCookiesToSeleniumCookies(cookies);

		int index = 0;
		for (Cookie seleniumCookie : seleniumCookies) {
			System.out.println("COUNTER " + index + ": " + seleniumCookie.toString());
			driver.manage().addCookie(seleniumCookie);
			index++;
		}
		driver.navigate().refresh();
	}

}
