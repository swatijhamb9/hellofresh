package com.hellofresh.tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.PageFactory;
import com.hellofresh.pages.BasePage;
import com.hellofresh.pages.CreateAccountPage;
import com.hellofresh.pages.HomePage;
import com.hellofresh.pages.MyAccountPage;
import com.hellofresh.pages.SignUpPage;
import com.hellofresh.utility.Utility;

/**
 * @author swajhamb
 * Test class to define the scenarios with help of page objects from page classes
 *
 */
public class VerifySignIn extends BasePage {

	String emailId;
	String password;
	String name;

	@Test(priority=1)
	public void signInTest() {

		logger = report.createTest("Sign Up");
		HomePage homePage = new HomePage(driver);
		SignUpPage signUpPage = new SignUpPage(driver);
		CreateAccountPage createAccountPage = new CreateAccountPage(driver);
		MyAccountPage myAccountPage = new MyAccountPage(driver);
		logger.info("Starting Application");
		homePage.clickSignIn();
		logger.info("Clicked SignIn");
		emailId = Utility.generateString() + "@hf.com";
		signUpPage.enterEmail(emailId);
		logger.info("Entered Email");
		signUpPage.clickCreateAccount();
		logger.info("Start creating account");
		name = Utility.generateString();
		password = Utility.generateString();
		createAccountPage.fillFormText("Mrs", name, password);
		createAccountPage.fillFormDropdown("7", "1", "2011", "Alaska");
		createAccountPage.clickSubmit();
		logger.info("Registeration Done");
		myAccountPage.validateWelcomeText();
		myAccountPage.isLogoutButtonDisplayed();
		assertTrue(driver.getCurrentUrl().contains("controller=my-account"));
		myAccountPage.validateName(name, name);
		logger.info("Validations Done");
		myAccountPage.signOut();
		logger.info("Logout Done");

	}

	@Test(priority=2)
	public void logInTest() {
		logger = report.createTest("Log In");
		HomePage homePage = new HomePage(driver);
		SignUpPage signUpPage = new SignUpPage(driver);
		MyAccountPage myAccountPage = new MyAccountPage(driver);
		logger.info("Starting Application");
		homePage.clickSignIn();
		signUpPage.loginExistingEmail(ex.getData("Cred", 1, 0), ex.getData("Cred", 1, 1));
		logger.info("SignIn Done");
		myAccountPage.isLogoutButtonDisplayed();
		assertTrue(driver.getCurrentUrl().contains("controller=my-account"));
		myAccountPage.validateName(ex.getData("Cred", 1, 2), ex.getData("Cred", 1, 2));
		logger.info("Validations Done");
		myAccountPage.signOut();
		logger.info("Logout Done");
	}

	@Test(priority=3)
	public void checkoutTest() {
		logger = report.createTest("Checkout");
		HomePage homePage = new HomePage(driver);
		SignUpPage signUpPage = new SignUpPage(driver);
		MyAccountPage myAccountPage = new MyAccountPage(driver);
		logger.info("Starting Application");
		homePage.clickSignIn();
		signUpPage.loginExistingEmail(ex.getData("Cred", 1, 0), ex.getData("Cred", 1, 1));
		logger.info("SignIn Done");
		myAccountPage.selectItemAndCheckout(ex.getData("CreateAccount", 1, 0), ex.getData("CreateAccount", 1, 1));
		logger.info("Item Selected and checked out");
		assertTrue(myAccountPage.getConfirmationText().contains("Your order on My Store is complete."));
		assertTrue(driver.getCurrentUrl().contains("?controller=order-confirmation"));
		assertTrue(myAccountPage.getConfirmationPageHeading().equalsIgnoreCase("Order confirmation"));
		logger.info("Validations Done");
	}

}
