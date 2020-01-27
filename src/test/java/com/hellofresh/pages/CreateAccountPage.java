/**
 * 
 */
package com.hellofresh.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.hellofresh.utility.Utility;

/**
 * @author swajhamb 
 * This class will store all the locators and methods of Create
 *         Account Page.
 *
 */
public class CreateAccountPage {

	WebDriver driver;

	public CreateAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "id_gender1")
	private WebElement title_Mr;

	@FindBy(id = "id_gender2")
	private WebElement title_Mrs;

	@FindBy(id = "customer_firstname")
	private WebElement firstName;

	@FindBy(id = "customer_lastname")
	private WebElement lastName;

	@FindBy(id = "passwd")
	private WebElement password;

	@FindBy(id = "company")
	private WebElement company;

	@FindBy(id = "address1")
	private WebElement address1;

	@FindBy(id = "address2")
	private WebElement address2;

	@FindBy(id = "city")
	private WebElement city;

	@FindBy(id = "id_state")
	private WebElement state;

	@FindBy(id = "postcode")
	private WebElement postcode;

	@FindBy(id = "other")
	private WebElement other;

	@FindBy(id = "phone")
	private WebElement phone;

	@FindBy(id = "phone_mobile")
	private WebElement phoneMobile;

	@FindBy(id = "alias")
	private WebElement alias;

	@FindBy(id = "submitAccount")
	private WebElement submitAccount;

	@FindBy(id = "days")
	private WebElement days;

	@FindBy(id = "months")
	private WebElement months;

	@FindBy(id = "years")
	private WebElement years;

	public void selectTitle(String title) {
		if (title.equalsIgnoreCase("Mr")) {
			title_Mr.click();
		} else {
			title_Mrs.click();
		}

	}

	public void enterState(String stateValue) {
		Select sel = new Select(state);
		sel.selectByVisibleText(stateValue);

	}

	public void enterDays(String dayValue) {
		Select sel = new Select(days);
		sel.selectByValue(dayValue);

	}

	public void enterMonth(String monthValue) {
		Select sel = new Select(months);
		sel.selectByValue(monthValue);

	}

	public void enterYear(String yearValue) {
		Select sel = new Select(years);
		sel.selectByValue(yearValue);

	}

	public void clickSubmit() {
		submitAccount.click();

	}

	public void fillFormText(String title, String name, String passwordValue) {
		selectTitle(title);
		firstName.sendKeys(name);
		lastName.sendKeys(name);
		password.sendKeys(passwordValue);
		company.sendKeys(Utility.generateString());
		address1.sendKeys(Utility.generateString());
		address2.sendKeys(Utility.generateString());
		city.sendKeys(Utility.generateString());
		postcode.sendKeys(Utility.generateNumberString());
		other.sendKeys(Utility.generateString());
		phone.sendKeys(Utility.generateNumberString());
		phoneMobile.sendKeys(Utility.generateNumberString());
		alias.sendKeys(Utility.generateString());
	}

	public void fillFormDropdown(String days, String month, String year, String state) {
		enterDays(days);
		enterMonth(month);
		enterYear(year);
		enterState(state);
	}

}
