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

package awesomecucumber.pages;

import java.nio.charset.StandardCharsets;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StorePage extends BasePage {

	@FindBy(css = "a[title='View cart']")
	private WebElement viewCartLink;

	@FindBy(xpath = "//h1[normalize-space()='Store']")
	private WebElement titleTxt;

	@FindBy(xpath = "//img")
	private List<WebElement> images;

	public StorePage(WebDriver driver) {
		super(driver);
	}

	public void addToCart(String productName) {
		String raw = "a[aria-label='Add “" + productName + "” to your cart']";
		byte[] bytes = raw.getBytes(StandardCharsets.UTF_8);
		String utf8Encoded = new String(bytes, StandardCharsets.UTF_8);
		By addToCartBtn = By.cssSelector(utf8Encoded);
		waitForElementVisibility(titleTxt);
		click(addToCartBtn);
		click(viewCartLink);
	}
}
