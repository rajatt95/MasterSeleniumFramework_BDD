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

package awesomecucumber.factory;

import org.openqa.selenium.WebDriver;

import awesomecucumber.pages.CartPage;
import awesomecucumber.pages.CheckoutPage;
import awesomecucumber.pages.ProductPage;
import awesomecucumber.pages.StorePage;

public class PageFactoryManager {

    private static StorePage storePage;
    private static CartPage cartPage;
    private static CheckoutPage checkoutPage;
    private static ProductPage productPage;

	public static StorePage getStorePage(WebDriver driver) {
		/**
		 * Using Ternary Operator: Checking for storePage as null.
		 * 
		 * If it is null, then, create new object and return
		 *
		 * If it is not null, then, return storePage
		 */
		return storePage == null ? new StorePage(driver) : storePage;
	}

	public static CartPage getCartPage(WebDriver driver) {
		return cartPage == null ? new CartPage(driver) : cartPage;
	}

	public static CheckoutPage getCheckoutPage(WebDriver driver) {
		return checkoutPage == null ? new CheckoutPage(driver) : checkoutPage;
	}

	public static ProductPage getProductPage(WebDriver driver) {
		return productPage == null ? new ProductPage(driver) : productPage;
	}
}
