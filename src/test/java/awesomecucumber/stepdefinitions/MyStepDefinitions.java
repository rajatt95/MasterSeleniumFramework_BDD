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
