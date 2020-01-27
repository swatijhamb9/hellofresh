/**
 * 
 */
package com.hellofresh.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author swajhamb 
 * This class will store all the locators and methods of SignUp
 *         Page.
 *
 */
public class SignUpPage {

	WebDriver driver;

	public SignUpPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "email_create")
	private WebElement emailTextbox;

	@FindBy(id = "SubmitCreate")
	private WebElement createAccount;

	@FindBy(id = "email")
	private WebElement registeredEmailTextbox;

	@FindBy(id = "passwd")
	private WebElement password;

	@FindBy(id = "SubmitLogin")
	private WebElement signIn;

	public void enterEmail(String email) {
		emailTextbox.click();
		emailTextbox.sendKeys(email);

	}

	public void clickCreateAccount() {
		createAccount.click();

	}

	public void loginExistingEmail(String email, String passwordValue) {
		registeredEmailTextbox.click();
		registeredEmailTextbox.sendKeys(email);
		password.click();
		password.sendKeys(passwordValue);
		signIn.click();
	}

	
}
