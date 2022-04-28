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

package awesomecucumber.hooks;

import static awesomecucumber.constants.FrameworkConstants.BROWSER_FIREFOX;
import static awesomecucumber.constants.FrameworkConstants.PARAMETER_BROWSER;

import awesomecucumber.context.TestContext;
import awesomecucumber.factory.DriverFactory;
import awesomecucumber.utils.ZipUtils;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

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

		// ExtentReport.createTest(scenario.getName());

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
		// driver = DriverFactory.initializeDriver(System.getProperty(PARAMETER_BROWSER,
		// BROWSER_CHROME));
		driver = DriverFactory.initializeDriver(System.getProperty(PARAMETER_BROWSER, BROWSER_FIREFOX));
//		driver = DriverFactory.initializeDriver(System.getProperty(PARAMETER_BROWSER, BROWSER_EDGE));
		// driver = DriverFactory.initializeDriver(System.getProperty(PARAMETER_BROWSER,
		// BROWSER_OPERA));
		// driver = DriverFactory.initializeDriver(System.getProperty(PARAMETER_BROWSER,
		// BROWSER_SAFARI));

		context.driver = driver;
	}

	@After
	public void after(Scenario scenario) {
		System.out.println(
				"AFTER: THREAD ID : " + Thread.currentThread().getId() + "," + "SCENARIO NAME: " + scenario.getName());

		/* If Scenario fails */
		/* This is for attaching the screenshot in Cucumber report */
		if (scenario.isFailed()) {
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}

		// doExtentReportWork(scenario);

		driver.quit();
	}

//	private void doExtentReportWork(Scenario scenario) {
//
//		if (scenario.getStatus().toString().equals("PASSED")) {
//			ExtentLogger.pass("<b><i>" + scenario.getName() + "</i></b>");
//			ExtentLogger.pass("<b><i>" + scenario.getStatus().PASSED + "</i></b>");
//		}
//
//		if (scenario.getStatus().toString().equals("SKIPPED")) {
//			ExtentLogger.skip("<b><i>" + scenario.getName() + "</i></b>");
//			ExtentLogger.skip("<b><i>" + scenario.getStatus().SKIPPED + "</i></b>");
//		}
//
//		if (scenario.isFailed()) {
//			ExtentLogger.fail("<b><i>" + scenario.getName() + "</i></b>");
//			ExtentLogger.fail("<b><i>" + scenario.getStatus().FAILED + "</i></b>");
//		}
//
//	}

//	@BeforeStep
//	public static void beforeStep() {
//		ExtentLogger.pass("<b><i>" + "BEFORE STEP" + "</i></b>");
//	}

	@BeforeAll
	public static void beforeAll() {
		// ExtentReport.initReports();
	}

	@AfterAll
	public static void afterAll() {
		// ExtentReport.flushReports();
		ZipUtils.zip();
		// EmailSendUtils.sendEmail();

	}

}
