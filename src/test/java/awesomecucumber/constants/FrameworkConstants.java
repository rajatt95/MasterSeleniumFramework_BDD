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

package awesomecucumber.constants;

public class FrameworkConstants {

	// public static final String STORE = "/store";
	public static final int EXPLICIT_WAIT = 10;

	public static final String YES = "yes";
	public static final String NO = "no";

	public static final String PROJECT_NAME = "Automation Test Suite Report - Master Selenium Framework - BDD Cucumber";

	/* PARAMETERS TO BE USED FROM MAVEN COMMAND LINE */
	public static final String PARAMETER_ENV = "env";
	public static final String PARAMETER_BROWSER = "browser";

	/* SUPPORTED BROWSERS */
	public static final String BROWSER_CHROME = "chrome";
	public static final String BROWSER_FIREFOX = "firefox";
	public static final String BROWSER_SAFARI = "safari";
	public static final String BROWSER_EDGE = "edge";
	public static final String BROWSER_OPERA = "opera";

	public static final String ATTRIBUTE_VALUE = "value";

	/* ENVIRONMENT CONFIGURATION FILES */
	public static final String DIRECTORY_ENV_CONFIG = "src/test/resources/config/";
	public static final String ENV_CONFIG_QA = "qa_config.properties";
	public static final String ENV_CONFIG_INT = "int_config.properties";
	public static final String ENV_CONFIG_STG = "stg_config.properties";
	public static final String ENV_CONFIG_PROD = "prod_config.properties";

	/* CUCUMBER REPORTS */
	public static final String REPORTS_CUCUMBER_LOCATION = "./target/cucumber/";
	public static final String REPORTS_CUCUMBER_LOCAL = REPORTS_CUCUMBER_LOCATION + "cucumber.html";
	public static final String REPORTS_ZIPPED_FILE_NAME = "CucumberReports.zip";

}
