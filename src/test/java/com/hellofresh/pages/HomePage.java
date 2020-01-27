package com.hellofresh.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author swajhamb
 * This class will store all the locators and methods of Home Page.
 *
 */
public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "login")
	private WebElement signInButton;
	
	
	public void clickSignIn() {
		signInButton.click();
		
	}

}
