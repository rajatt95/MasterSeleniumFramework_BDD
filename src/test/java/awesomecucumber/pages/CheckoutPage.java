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

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import awesomecucumber.domainobjects.BillingDetails;

public class CheckoutPage extends BasePage {

	@FindBy(id = "billing_first_name")
	private WebElement billingFirstnameFld;

	@FindBy(id = "billing_last_name")
	private WebElement billingLastNameFld;

	@FindBy(id = "billing_address_1")
	private WebElement billingAddressOneFld;

	@FindBy(id = "billing_city")
	private WebElement billingCityFld;

	@FindBy(id = "billing_state")
	private WebElement billingStateDropDown;

	@FindBy(id = "select2-billing_state-container")
	private WebElement alternateBillingStateDropDown;

	@FindBy(id = "billing_postcode")
	private WebElement billingZipFld;

	@FindBy(id = "billing_email")
	private WebElement billingEmailFld;

	@FindBy(id = "place_order")
	private WebElement placeOrderBtn;

	@FindBy(css = ".woocommerce-notice")
	private WebElement noticeTxt;

	private final By overlay = By.cssSelector(".blockUI.blockOverlay");

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}

	public CheckoutPage enterBillingFirstName(String billingFirstName) {
		clearAndSendKeys(billingFirstnameFld, billingFirstName);
		return this;
	}

	public CheckoutPage enterBillingLastName(String billingLastName) {
		clearAndSendKeys(billingLastNameFld, billingLastName);
		return this;
	}

	public CheckoutPage enterBillingAddressLineOne(String billingAddressLineOne) {
		clearAndSendKeys(billingAddressOneFld, billingAddressLineOne);

		return this;
	}

	public CheckoutPage enterBillingCity(String billingCity) {
		clearAndSendKeys(billingCityFld, billingCity);
		return this;
	}

	public CheckoutPage selectBillingState(String billingStateName) {

		/**
		 * We have commented the code using Select class becauase that does not work
		 * with Firefox browser.
		 * 
		 * There is a issue open for it.
		 * 
		 */
		click(alternateBillingStateDropDown);
//		wait.until(ExpectedConditions.elementToBeClickable(alternateBillingStateDropDown)).click();
		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='" + billingStateName + "']")));

		scrollToElement(element);
		click(element);

		/*
		 * Select select = new
		 * Select(wait.until(ExpectedConditions.visibilityOf(billingStateDropDown)));
		 * select.selectByVisibleText(billingStateName);
		 */
		return this;
	}

	public CheckoutPage enterBillingZip(String billingZip) {
		clearAndSendKeys(billingZipFld, billingZip);
		return this;
	}

	public CheckoutPage enterBillingEmail(String billingEmail) {
		clearAndSendKeys(billingEmailFld, billingEmail);
		return this;
	}

	public CheckoutPage setBillingDetails(BillingDetails billingDetails) {
		return enterBillingFirstName(billingDetails.getBillingFirstName())
				.enterBillingLastName(billingDetails.getBillingLastName())
				.enterBillingAddressLineOne(billingDetails.getBillingAddressOne())
				.enterBillingCity(billingDetails.getBillingCity())
				.selectBillingState(billingDetails.getBillingStateName())
				.enterBillingZip(billingDetails.getBillingZip())
				.enterBillingEmail(billingDetails.getBillingEmail());
	}

	public CheckoutPage placeOrder() {
		waitForOverlaysToDisappear(overlay);
		click(placeOrderBtn);
		return this;
	}

	public String getNotice() {
		return getElementText(noticeTxt);

	}
}
