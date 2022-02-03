package awesomecucumber.stepdefinitions;

import awesomecucumber.context.TestContext;
import awesomecucumber.domainobjects.Product;
import awesomecucumber.enums.EndPoint;
import awesomecucumber.factory.PageFactoryManager;
import awesomecucumber.pages.StorePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class StoreStepDefinitions {
    private final StorePage storePage;
    private final TestContext context;

    public StoreStepDefinitions(TestContext context){
        this.context = context;
        storePage = PageFactoryManager.getStorePage(context.driver);
    }

    @Given("I'm on the Store Page")
    public void iMOnTheStorePage() {
        storePage.load(EndPoint.STORE.url);
    }

    @When("I add it again")
    public void iAddItAgain() {
        storePage.addToCart(context.product.getName());
    }

    @When("I add a {product} to the cart")
    public void iAddAToTheCart(Product product) {
        storePage.addToCart(product.getName());
    }
}
