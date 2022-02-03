package awesomecucumber.stepdefinitions;

import org.testng.Assert;

import awesomecucumber.context.TestContext;
import awesomecucumber.enums.EndPoint;
import awesomecucumber.factory.PageFactoryManager;
import awesomecucumber.pages.CheckoutPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutStepDefinitions {
    private final TestContext context;
    private final CheckoutPage checkoutPage;

    public CheckoutStepDefinitions(TestContext context){
        this.context = context;
        checkoutPage = PageFactoryManager.getCheckoutPage(context.driver);
    }

    @When("I provide billing details")
    public void iProvideBillingDetails() {
    	/*
		 * context.billingDetails -> We are using the same billing details set in
		 * CustomerStepDefinitions (Method: myBillingDetailsAre())
		 */
        checkoutPage.setBillingDetails(context.billingDetails);
    }

    @And("I place an order")
    public void iPlaceAnOrder() {
        checkoutPage.placeOrder();
    }

    @Then("the order should be placed successfully")
    public void theOrderShouldBePlacedSuccessfully() {
        Assert.assertEquals("Thank you. Your order has been received.", checkoutPage.getNotice());
    }

    @And("I'm on the Checkout page")
    public void iMOnTheCheckoutPage() {
        checkoutPage.load(EndPoint.CHECKOUT.url);
    }
}
