package awesomecucumber.hooks;

import static awesomecucumber.constants.FrameworkConstants.BROWSER_EDGE;
import static awesomecucumber.constants.FrameworkConstants.PARAMETER_BROWSER;

import org.openqa.selenium.WebDriver;

import awesomecucumber.context.TestContext;
import awesomecucumber.factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class MyHooks {

	private WebDriver driver;
	private final TestContext context;

	/**
	 * Dependency Injection using Pico container
	 */
	public MyHooks(TestContext context) {
		this.context = context;
	}

	@Before
	public void before(Scenario scenario) {
		
		System.out.println(
				"BEFORE: THREAD ID : " + Thread.currentThread().getId() + "," + "SCENARIO NAME: " + scenario.getName());

		/*
		 * System.getProperty("browser" -> This is for test execution using Maven
		 * Command Line file
		 */
		/*
		 * Setting Edge browser as default
		 */
//		driver = DriverFactory.initializeDriver(System.getProperty("browser", "edge"));
		driver = DriverFactory.initializeDriver(System.getProperty(PARAMETER_BROWSER, BROWSER_EDGE));

		context.driver = driver;
	}

	@After
	public void after(Scenario scenario) {
		System.out.println(
				"AFTER: THREAD ID : " + Thread.currentThread().getId() + "," + "SCENARIO NAME: " + scenario.getName());
		driver.quit();
	}
}
