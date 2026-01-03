package com.PS.Utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {

	WebDriver driver;
	public WaitHelper(WebDriver rdriver)
	{
		this.driver=rdriver;
	}

	public WebElement VisiblityOfElement(WebElement element, int timeout)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOf(element));
	}


}
