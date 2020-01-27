/**
 * 
 */
package com.hellofresh.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * @author swajhamb
 *This class will store all the locators and methods of My
 *         Account Page.
 */
public class MyAccountPage {

	WebDriver driver;

	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "account")
	private WebElement account;

	@FindBy(className = "info-account")
	private WebElement infoAccount;

	@FindBy(className = "logout")
	private WebElement signout;

	@FindBy(linkText = "Women")
	private WebElement women;

	@FindBy(xpath = "//a[@title='Faded Short Sleeve T-shirts']/ancestor::li")
	private WebElement fadedShirt;

	@FindBy(name = "Submit")
	private WebElement addToCart;

	@FindBy(xpath = "//*[@id='layer_cart']//a[@class and @title='Proceed to checkout']")
	private WebElement proceedToCheckoutPopUp;

	@FindBy(xpath = "//*[contains(@class,'cart_navigation')]/a[@title='Proceed to checkout']")
	private WebElement proceedToCheckout;

	@FindBy(name = "processAddress")
	private WebElement addressProceedToCheckout;

	@FindBy(id = "uniform-cgv")
	private WebElement shippingTerms;

	@FindBy(name = "processCarrier")
	private WebElement shippingProceedToCheckout;

	@FindBy(className = "bankwire")
	private WebElement bankWire;

	@FindBy(xpath = "//*[@id='cart_navigation']/button")
	private WebElement confirmOrder;
	
	@FindBy(id = "quantity_wanted")
	private WebElement qty;
	
	@FindBy(id = "group_1")
	private WebElement size;
	
	@FindBy(xpath="//p[@class='cheque-indent']")
	private WebElement confirmation;
	
	@FindBy(xpath="//h1[@class=\"page-heading\"]")
	private WebElement pageHeading;

	public void validateName(String firstNameValue, String lastNameValue) {
		assert account.getText().equals(firstNameValue + " " + lastNameValue);
	}

	public void validateWelcomeText() {
		assert infoAccount.getText().contains("Welcome to your account.");
	}

	public void isLogoutButtonDisplayed() {
		assert signout.isDisplayed();
	}

	public void signOut() {
		signout.click();
	}
	
	public void selectSize(String sizeSelected) {
		Select sel = new Select(size);
		sel.selectByVisibleText(sizeSelected);
	}

	public String getConfirmationText() {
		return confirmation.getText();
	}
	public String getConfirmationPageHeading() {
		return pageHeading.getText();
	}
	
	public void selectItemAndCheckout(String quantity, String size) {
		women.click();
		fadedShirt.click();
		fadedShirt.click();
		qty.clear();
		qty.sendKeys(quantity);
		selectSize(size);
		addToCart.click();
		proceedToCheckoutPopUp.click();
		proceedToCheckout.click();
		addressProceedToCheckout.click();
		shippingTerms.click();
		shippingProceedToCheckout.click();
		bankWire.click();
		confirmOrder.click();

	}

}
