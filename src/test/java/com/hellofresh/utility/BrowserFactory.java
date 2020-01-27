/**
 * 
 */
package com.hellofresh.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author swajhamb
 * This class is designed to create a method to start and quit the browser
 *
 */
public class BrowserFactory {

	public static WebDriver startBrowser(WebDriver driver, String browserName, String url) {

		if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver");
			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
			driver = new ChromeDriver();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		}
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;

	}

	public static void quitBrowser(WebDriver driver) {
		driver.quit();
	}

}
