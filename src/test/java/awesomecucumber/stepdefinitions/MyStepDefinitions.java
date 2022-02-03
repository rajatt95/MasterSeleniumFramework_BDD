package awesomecucumber.stepdefinitions;

import org.openqa.selenium.WebDriver;

import awesomecucumber.context.TestContext;
import awesomecucumber.domainobjects.BillingDetails;

public class MyStepDefinitions {
    private final WebDriver driver;
    private BillingDetails billingDetails;

    public MyStepDefinitions(TestContext context){
        driver = context.driver;
    }
}
