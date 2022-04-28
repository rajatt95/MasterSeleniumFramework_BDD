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

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

	@FindBy(css = "input[type='number']")
	private WebElement quantityInputFld;

	@FindBy(css = "button[type='submit']")
	private WebElement addToCartBtn;

	@FindBy(css = "[role='alert'] .button")
	private WebElement viewCartBtn;

	@FindBy(css = "div[role='alert']")
	private WebElement bannerTxt;

	public ProductPage(WebDriver driver) {
		super(driver);
	}

	public void enterQuantity(int quantity) {
		clearAndSendKeys(quantityInputFld, Integer.toString(quantity));
	}

	public int getQuantity() {
		return Integer.parseInt(getElementElementAttribute_Value(quantityInputFld));
	}

	public void addToCart() {
		click(addToCartBtn);
		click(viewCartBtn);
	}

	public void pressAddToCartBtn() {
		click(addToCartBtn);
	}

	public String getValidationMsg() {
		return getElementElementCustomAttribute(quantityInputFld, "validationMessage");
	}

	public String getBannerTxt() {
		return getElementText(bannerTxt);
	}

	public int updateQuantityUsingArrows(String direction) {
		switch (direction) {
		case "up": {
			waitForElementToBeClickable(quantityInputFld).sendKeys(Keys.ARROW_UP);
			break;
		}
		case "down": {
			waitForElementToBeClickable(quantityInputFld).sendKeys(Keys.ARROW_DOWN);
			break;
		}
		default:
			throw new IllegalStateException("INVALID ARROW DIRECTION" + direction);
		}
		System.out.println("QUANTITY: " + getQuantity());
		return getQuantity();
	}
}
