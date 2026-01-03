package com.PS.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.PS.Utilities.WaitHelper;

public class DeliveryAddress_page {
	
	WebDriver driver;
	WaitHelper wait;
	
	public DeliveryAddress_page(WebDriver rdriver){
		this.driver=driver;
		PageFactory.initElements(rdriver, this);
		wait = new WaitHelper(rdriver);
	
	}
	
	// identify WebElements
	@FindBy(xpath="//input[@id='warehouse_name']")
	WebElement inputWarehouseName;
	
	@FindBy(xpath="//input[@id='address']")
	WebElement inputAddress;
	
	@FindBy(xpath="//input[@id='pincode_no']")
	WebElement inputpincode;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement inputEmail;
	
	@FindBy(xpath="//input[@id='phone_no']")
	WebElement inputPhoneNo;
	
	@FindBy(xpath="//input[@id='gst_in_no']")
	WebElement inputGSTNo;
	
	@FindBy(xpath="//button[@id='createButton']")
	WebElement createBTN;
	
	@FindBy(xpath="//td[normalize-space()='GoCodeX Pvt.Ltd.']")
	WebElement WarehouseText;
	
	@FindBy(xpath="//tr[td[normalize-space()='GoCodeX Pvt.Ltd.']]//a[starts-with(@href,'#delete')]")
	WebElement deleteBTN;
	@FindBy(xpath="//div[contains(@class,'modal') and contains(@class,'show')]//input[@value=\"Delete\"]")
	WebElement confirmDelete;
	
	
	// perform Actions 
	
	public void enterWarehouseName(String warehouseName)
	{
		inputWarehouseName.sendKeys(warehouseName);
	}
	
	public void enterAddress(String Address)
	{
		inputAddress.sendKeys(Address);
	}
	
	public void enterPinCode(String pincode)
	{
		inputpincode.sendKeys(pincode);
	}
	
	public void enterEmail(String email)
	{
		inputEmail.sendKeys(email);
	}
	
	public void enterPhoneNo(String phoneNo)
	{
		inputPhoneNo.sendKeys(phoneNo);
	}
	
	public void enterGSTNo(String gstNo)
	{
		inputGSTNo.sendKeys(gstNo);
	}
	
	public void clickOnCreateBTN()
	{
		createBTN.click();
	}
	
	public String getWharehouseName()
	{
		wait.VisiblityOfElement(WarehouseText, 5);
		return WarehouseText.getText();
	}
	
	public void clickOnDeleteBTN()
	{
		deleteBTN.click();
	}
	
	public void ClickOnConfirmDelete()
	{
		wait.VisiblityOfElement(confirmDelete, 5);
		confirmDelete.click();
	
	}

	

}
