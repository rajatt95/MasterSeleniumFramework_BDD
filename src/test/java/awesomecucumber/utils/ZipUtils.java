package awesomecucumber.utils;

import java.io.File;
import static awesomecucumber.constants.FrameworkConstants.REPORTS_CUCUMBER_LOCATION;
import static awesomecucumber.constants.FrameworkConstants.REPORTS_ZIPPED_FILE_NAME;
import org.zeroturnaround.zip.ZipUtil;

public class ZipUtils {

	/*
	 * make Zip file of target/cucumber folder in Project Root folder (Name:
	 * CucumberReports.zip)
	 */
	public static void zip() {

		ZipUtil.pack(new File(REPORTS_CUCUMBER_LOCATION), new File(REPORTS_ZIPPED_FILE_NAME));

		System.out.println("Zipped Cucumber reports successfuly");
	}

//	public static void main(String[] args) {
//
//		String reportsLocation = "./target/cucumber/";
//		ZipUtil.pack(new File(reportsLocation), new File("CucumberReports.zip"));
//
//	}

}
