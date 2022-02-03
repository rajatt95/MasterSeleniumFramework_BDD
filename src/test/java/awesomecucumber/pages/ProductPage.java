package awesomecucumber.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
		WebElement quantityInputFld = wait.until(ExpectedConditions.elementToBeClickable(this.quantityInputFld));
		quantityInputFld.clear();
		quantityInputFld.sendKeys(Integer.toString(quantity));
	}

	public int getQuantity() {
		return Integer.parseInt(
				wait.until(ExpectedConditions.elementToBeClickable(this.quantityInputFld)).getAttribute("value"));
	}

	public void addToCart() {
		wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(viewCartBtn)).click();
	}

	public void pressAddToCartBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();
	}

	public String getValidationMsg() {
		return wait.until(ExpectedConditions.elementToBeClickable(this.quantityInputFld))
				.getAttribute("validationMessage");
	}

	public String getBannerTxt() {
		return wait.until(ExpectedConditions.visibilityOf(bannerTxt)).getText();
	}

	public int updateQuantityUsingArrows(String direction) {
		switch (direction) {

		case "up": {
			wait.until(ExpectedConditions.elementToBeClickable(this.quantityInputFld)).sendKeys(Keys.ARROW_UP);
			break;
		}
		case "down": {
			wait.until(ExpectedConditions.elementToBeClickable(this.quantityInputFld)).sendKeys(Keys.ARROW_DOWN);
			break;
		}
		default:
			throw new IllegalStateException("INVALID ARROW DIRECTION" + direction);
		}
		System.out.println("QUANTITY: " + getQuantity());
		return getQuantity();
	}
}
