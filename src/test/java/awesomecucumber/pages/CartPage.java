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

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

	@FindBy(css = "td[class='product-name'] a")
	private WebElement productNameFld;

	@FindBy(css = "input[type=\"number\"]")
	private WebElement productQuantityFld;

	@FindBy(css = ".checkout-button")
	private WebElement proceedToCheckoutBtn;

	public CartPage(WebDriver driver) {
		super(driver);
	}

	public String getProductName() {
		return getElementText(productNameFld);
	}

	public int getProductQuantity() {
		return Integer.parseInt(getElementElementAttribute_Value(productQuantityFld));
	}

	public void checkout() {
		click(proceedToCheckoutBtn);
	}
}
