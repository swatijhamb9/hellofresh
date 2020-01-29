/**
 * 
 */
package com.hellofresh.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

/**
 * @author swajhamb
 *This class has common methods used in the framework
 */
public class Utility {

	public static String captureScreenshots(WebDriver driver) {
		String screenShotPath = System.getProperty("user.dir")+"/Screenshots/"+ getCurrentDateTime()+".png";

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(src, new File("./Screenshots/"+ getCurrentDateTime() +".png"));
		} catch (IOException e) {
			System.out.println("Unable to capture screenshot : " + e.getMessage());
		}
		return screenShotPath;

	}

	public static String getCurrentDateTime() {
		DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate = new Date();
		return customFormat.format(currentDate);

	}
	
	public static String generateString() {
		 String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	        StringBuilder salt = new StringBuilder();
	        Random rnd = new Random();
	        while (salt.length() < 5) { // length of the random string.
	            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
	            salt.append(SALTCHARS.charAt(index));
	        }
	        String saltStr = salt.toString();
	        System.out.println(saltStr);
	        return saltStr;
    } 
	
	public static String generateNumberString() {
		 String SALTCHARS = "0123456789";
	        StringBuilder salt = new StringBuilder();
	        Random rnd = new Random();
	        while (salt.length() < 5) { // length of the random string.
	            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
	            salt.append(SALTCHARS.charAt(index));
	        }
	        String saltStr = salt.toString();
	        System.out.println(saltStr);
	        return saltStr;
   }
	
	public static int generateRandomNo() {
		double randomDouble = Math.random();
		randomDouble = randomDouble * 200 + 1;
		int randomInt = (int) randomDouble;
		System.out.println(randomInt);
		return randomInt;
	   }

}
