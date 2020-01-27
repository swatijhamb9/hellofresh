/**
 * 
 */
package com.hellofresh.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.hellofresh.utility.BrowserFactory;
import com.hellofresh.utility.ConfigDataProvider;
import com.hellofresh.utility.ExcelDataProvider;
import com.hellofresh.utility.Utility;

/**
 * @author swajhamb
 *This class is designed to start the browser and launch the url, quit the browser
 * generating the screenshot on failures. For reading from excel
 */
public class BasePage {

	public WebDriver driver;
	public ExcelDataProvider ex;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;

	@BeforeSuite
	public void readFromExcel() {
		Reporter.log("Setting up reports and test getting ready", true);
		ex = new ExcelDataProvider();
		config = new ConfigDataProvider();
		ExtentHtmlReporter extent = new ExtentHtmlReporter(
				new File(System.getProperty("user.dir") + "/Reports/" + Utility.getCurrentDateTime() + ".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
		Reporter.log("Test Setup done and test can be stated", true);

	}

	@BeforeMethod
	public void setUp() {
		// This will launch the browser and specific URL
		Reporter.log("Getting application ready", true);
		driver = BrowserFactory.startBrowser(driver, config.getDataFromConfig("Browser"),
				config.getDataFromConfig("url"));
		Reporter.log("Browser and application is up and running", true);

	}

//	@AfterClass(alwaysRun = true)
//	public void quitBrowser() {
//		BrowserFactory.quitBrowser(driver);
//	}

	@AfterMethod
	public void tearDownMethod(ITestResult result) {
		Reporter.log("Test is about to end", true);
		if (result.getStatus() == ITestResult.FAILURE) {
			//Utility.captureScreenshots(driver);
			try {
				logger.fail("TestFailed",
						MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshots(driver)).build());
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

		report.flush();
		Reporter.log("Report generated", true);
		BrowserFactory.quitBrowser(driver);

	}
}
