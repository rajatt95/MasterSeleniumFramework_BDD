package awesomecucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static awesomecucumber.constants.FrameworkConstants.ATTRIBUTE_VALUE;

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
		return wait.until(ExpectedConditions.visibilityOf(productNameFld)).getText();
	}

	public int getProductQuantity() {
		return Integer.parseInt(
				wait.until(ExpectedConditions.visibilityOf(productQuantityFld)).getAttribute(ATTRIBUTE_VALUE));
	}

	public void checkout() {
		wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutBtn)).click();
	}
}
