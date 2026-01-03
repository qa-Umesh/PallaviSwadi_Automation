package com.PS.PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.PS.Utilities.WaitHelper;

public class Customer_page {

	WebDriver driver;
	WaitHelper wait;
	Select select;
	JavascriptExecutor js;

	public Customer_page(WebDriver rdriver) {
		this.driver = rdriver;
		PageFactory.initElements(rdriver, this);
		wait = new WaitHelper(rdriver);
		js = (JavascriptExecutor) driver;
	}

	// identifying WebElements
	@FindBy(xpath = "//input[@id='customer_name']")
	WebElement customerName;

	@FindBy(xpath = "//input[@id='customer_email']")
	WebElement customerEmail;

	@FindBy(xpath = "//input[@id='contact_info']")
	WebElement customerPhoneNo;

	@FindBy(xpath = "//select[@id='place_of_supply']")
	WebElement DDPlaceOfSupply;

	@FindBy(xpath = "//select[@id='registration_type']")
	WebElement DDGSTtreatment;

	@FindBy(xpath = "//button[@id='createButton']")
	WebElement CreateBTN;
	@FindBy(css = "tab-content")
	WebElement customerFormContainer;

	public void enterCustumerName(String name) {
		customerName.sendKeys(name);
	}

	public void enterCustumerEmail(String email) {
		customerEmail.sendKeys(email);
	}

	public void SelectPlaceOfSupply() {
		select = new Select(DDPlaceOfSupply);
		select.selectByVisibleText("Maharashtra");
	}

	public void SelectRegistrationType() {
		select = new Select(DDGSTtreatment);
		select.selectByVisibleText("Consumer");
	}

	public void ClickOnCreateButton() {


		js.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight;", customerFormContainer);

		CreateBTN.click();
	}

}
