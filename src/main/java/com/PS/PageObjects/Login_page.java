package com.PS.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.PS.Utilities.WaitHelper;

public class Login_page {

	WebDriver driver;
	WaitHelper wait;

	public Login_page(WebDriver rdriver) {
		this.driver = rdriver;
		PageFactory.initElements(rdriver, this);
		wait=new WaitHelper(rdriver);
	}

	// Identified WebElements
		@FindBy(xpath="//input[@id='username']")
		WebElement username;

		@FindBy(xpath="//input[@id='password']")
		WebElement password;

		@FindBy(xpath="//button[@type=\"submit\"]")
		WebElement loginBTN;
		
		//By errorMessage=By.xpath("//p[normalize-space()='Invalid Username or Password']");
		@FindBy(xpath="//p[normalize-space()='Invalid Username or Password']")
		WebElement errorMessage;



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
		
		public boolean isErrorMessageDisplayed() {
			WebElement errorElement=wait.VisiblityOfElement(errorMessage, 5);
			return errorElement.isDisplayed();
			
		}

}
