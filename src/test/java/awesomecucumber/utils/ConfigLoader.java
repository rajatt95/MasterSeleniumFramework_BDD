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

package awesomecucumber.utils;

import static awesomecucumber.constants.FrameworkConstants.DIRECTORY_ENV_CONFIG;
import static awesomecucumber.constants.FrameworkConstants.ENV_CONFIG_INT;
import static awesomecucumber.constants.FrameworkConstants.ENV_CONFIG_PROD;
import static awesomecucumber.constants.FrameworkConstants.ENV_CONFIG_QA;
import static awesomecucumber.constants.FrameworkConstants.ENV_CONFIG_STG;
import static awesomecucumber.constants.FrameworkConstants.PARAMETER_ENV;

import java.util.Properties;

import awesomecucumber.enums.EnvType;

/**
 * Singleton Design Pattern is implemented here
 */
public class ConfigLoader {

	private static final String BASE_URL = "baseUrl";
	private static final String SEND_EMAIL_TO_USERS = "send_email_to_users";


	// private final Properties properties;
	private Properties properties;

	private static ConfigLoader configLoader;

	private ConfigLoader() {

		/**
		 * Setting the Environment Parameter here.
		 * 
		 * By default, Stage will be taken
		 */
		// PARAMETER_ENV = "env";
		String env = System.getProperty(PARAMETER_ENV, String.valueOf(EnvType.STG));

		switch (EnvType.valueOf(env)) {

		case QA: {
			properties = PropertyUtils.propertyLoader(DIRECTORY_ENV_CONFIG + ENV_CONFIG_QA);
			break;
		}
		case INT: {
			properties = PropertyUtils.propertyLoader(DIRECTORY_ENV_CONFIG + ENV_CONFIG_INT);
			break;
		}
		case STG: {
			properties = PropertyUtils.propertyLoader(DIRECTORY_ENV_CONFIG + ENV_CONFIG_STG);
			break;
		}
		case PROD: {
			properties = PropertyUtils.propertyLoader(DIRECTORY_ENV_CONFIG + ENV_CONFIG_PROD);
			break;
		}
		default:
			throw new IllegalStateException("INVALID ENV: " + env);
		}
	}

	public static ConfigLoader getInstance() {
		if (configLoader == null) {
			configLoader = new ConfigLoader();
		}
		return configLoader;
	}

	public String getBaseUrl() {
		return getPropertyValue(BASE_URL);
	}

	public String getSendEmailToUsers() {
		return getPropertyValue(SEND_EMAIL_TO_USERS);
	}
	
	private String getPropertyValue(String propertyKey) {
		String prop = properties.getProperty(propertyKey);
		if (prop != null) {
			return prop.trim();
		} else {
			throw new RuntimeException("Property " + propertyKey + " is not specified in the config.properties file");
		}
	}
	
	
}
