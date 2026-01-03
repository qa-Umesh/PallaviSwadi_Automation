package com.PS.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.PS.Utilities.WaitHelper;

public class Workers_page {
	
	WebDriver driver;
	Select select;
	WaitHelper wait;
	
	public Workers_page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait=new WaitHelper(driver);
	}
	
	// WebElements 
	
	@FindBy(xpath="//input[@id='worker_Id']")
	WebElement workerID;
	
	@FindBy(xpath="//input[@id='worker_name']")
	WebElement workerName;
	
	@FindBy(xpath="//select[@id='worker_type']")
	WebElement DDWorkerType;
	
	@FindBy(xpath="//input[@id='contact_no']")
	WebElement MobileNo;
	
	@FindBy(xpath="//textarea[@id='address']")
	WebElement address;
	
	@FindBy(xpath="//button[@id='createButton']")
	WebElement createBTN;
	
	@FindBy(xpath="//td[normalize-space()='Test01']")
	WebElement List_WorkerName;
	
	@FindBy(xpath="//tr[td[contains(text(),'Test01')]]//a[starts-with(@href,'#delete')]")
	WebElement deleteBTN;
	
	@FindBy(xpath="//div[contains(@class,'modal') and contains(@class,'show')]//input[@value='Delete']")
	WebElement ConfirmDelete;
	
	
	// perform action on WebElement 
	
	public void enterWorkerID(String workerid)
	{
		workerID.sendKeys(workerid);
	}
	
	public void enterWorkerName(String Wokername)
	{
		workerName.sendKeys(Wokername);
	}

	public void SelectWorkerType()
	{
		select= new Select(DDWorkerType);
		select.selectByVisibleText("In-House");
	}
	public void enterMobileNo(String mobileNo)
	{
		MobileNo.sendKeys(mobileNo);
	}
	
	public void enterAddress(String worker_address)
	{
		address.sendKeys(worker_address);
	}
	public void ClcikOnCreate()
	{
		createBTN.click();
	}
	
	public String getWorkerName()
	{
		return List_WorkerName.getText();
	}
	public void ClickOnDeleteBTN()
	{
		deleteBTN.click();
	}
	public void ConfirmDelete() {
		wait.VisiblityOfElement(ConfirmDelete, 5);
		ConfirmDelete.click();
	}
	
}
