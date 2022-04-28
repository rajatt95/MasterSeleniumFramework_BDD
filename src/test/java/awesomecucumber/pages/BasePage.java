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

import awesomecucumber.utils.ConfigLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static awesomecucumber.constants.FrameworkConstants.ATTRIBUTE_VALUE;
import static awesomecucumber.constants.FrameworkConstants.EXPLICIT_WAIT;

import java.time.Duration;
import java.util.List;

public class BasePage {
	protected WebDriver driver;
	protected WebDriverWait wait;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		PageFactory.initElements(driver, this);
	}

	public void load(String endPoint) {
		driver.get(ConfigLoader.getInstance().getBaseUrl() + endPoint);
	}

	public void waitForOverlaysToDisappear(By overlay) {
		List<WebElement> overlays = driver.findElements(overlay);
		System.out.println("OVERLAY SIZE" + overlays.size());
		if (overlays.size() > 0) {
			wait.until(ExpectedConditions.invisibilityOfAllElements(overlays));
			System.out.println("OVERLAYS INVISIBLE");
		} else {
			System.out.println("OVERLAY NOT FOUND");
		}
	}

	public void clearAndSendKeys(WebElement element, String value) {
		element = waitForElementVisibility(element);
		element.clear();
		element.sendKeys(value);
	}

	public void click(WebElement element) {
		waitForElementToBeClickable(element).click();
	}

	public void click(By by) {
		waitForElementToBeClickable(by).click();
	}

	public WebElement waitForElementVisibility(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	public WebElement waitForElementToBeClickable(WebElement element) {
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public WebElement waitForElementToBeClickable(By by) {
		return wait.until(ExpectedConditions.elementToBeClickable(by));
	}

	public void scrollToElement(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public String getElementText(WebElement element) {
		return waitForElementVisibility(element).getText();
	}

	public String getElementElementAttribute_Value(WebElement element) {
		return waitForElementVisibility(element).getAttribute(ATTRIBUTE_VALUE);
	}

	public String getElementElementCustomAttribute(WebElement element, String customAttribute) {
		return waitForElementVisibility(element).getAttribute(customAttribute);
	}

}
