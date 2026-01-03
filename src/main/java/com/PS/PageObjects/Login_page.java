package com.PS.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_page {

	WebDriver driver;

	public Login_page(WebDriver rdriver) {
		this.driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	// Identified WebElements
		@FindBy(xpath="//input[@id='username']")
		WebElement username;

		@FindBy(xpath="//input[@id='password']")
		WebElement password;

		@FindBy(xpath="//button[@type=\"submit\"]")
		WebElement loginBTN;


		// perform actions on WebElements
		public void enterUsername(String UserName)
		{
			username.sendKeys(UserName);
		}

		public void enterPassword(String Password)
		{
			password.sendKeys(Password);
		}

		public void clickOnloginBTN()
		{
			loginBTN.click();
		}

}
