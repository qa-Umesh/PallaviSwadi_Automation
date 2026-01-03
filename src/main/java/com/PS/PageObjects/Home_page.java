package com.PS.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.PS.Utilities.WaitHelper;

public class Home_page {

	WebDriver driver;
	WaitHelper wait;

	public Home_page(WebDriver rdriver) {
		this.driver = rdriver;
		PageFactory.initElements(rdriver, this);
		wait = new WaitHelper(rdriver);
	}

	// identified WebElements
	@FindBy(xpath = "//span[contains(text(),'Home')]")
	WebElement homeBTN; // home button

	/********** main master *********/
	@FindBy(xpath = "//span[contains(text(),'Main Master')]")
	WebElement MainMasterDD; // main master drop-down

	@FindBy(xpath = "//a[@href='https://gocodex.com/psd/brandmaster']")
	WebElement BrandMaster; // Brand Master

	@FindBy(xpath = "//span[contains(text(),'Delivery Address')]")
	WebElement DeliveryAddress; // Delivery Master

	@FindBy(xpath = "//a[@href='#tabs-profile-3']")
	WebElement newAddress; // new tab for delivery master

	@FindBy(xpath = "//a[@href='https://gocodex.com/psd/categorymaster']")
	WebElement categoryMaster; // category master

	@FindBy(xpath = "//a[@href='#tabs-profile-3']")
	WebElement newCategory; // new tab for category master

	@FindBy(xpath = "//a[@href='https://gocodex.com/psd/workermaster']")
	WebElement WorkerMaster;

	@FindBy(xpath = "//a[@href='#tabs-profile-3']")
	WebElement newWorker;

	@FindBy(xpath = "//span[contains(text(),'Vendor Master')]")
	WebElement VendorMaster;

	@FindBy(xpath = "//a[@href='#tabs-profile-3']")
	WebElement newVendor;
	
	@FindBy(xpath="//a[@href='https://gocodex.com/psd/customermaster']")
	WebElement CustomerMaster;
	
	@FindBy(xpath="//a[@href='#tabs-profile-3']")
	WebElement newCustomer;


	// Home Dash-board
	public String getDashboard() {
		wait.VisiblityOfElement(homeBTN, 5);
		return homeBTN.getText();
	}

	/******** Navigate to Brand Master Tab **********/
	public void navigateToBrandMaster() {
		wait.VisiblityOfElement(MainMasterDD, 5);
		MainMasterDD.click();
		wait.VisiblityOfElement(BrandMaster, 5);
		BrandMaster.click();
	}

	/******** Navigate to Address Master Tab **********/
	public void navigateToDeliveryAddress() {
		wait.VisiblityOfElement(MainMasterDD, 5);
		MainMasterDD.click();
		wait.VisiblityOfElement(DeliveryAddress, 5);
		DeliveryAddress.click();

	}

	public void ClickonNewAddTab() {
		wait.VisiblityOfElement(newAddress, 5);
		newAddress.click();
	}

	/* Navigate to category Master Tab */
	public void navigateToCategoryMaster() {
		wait.VisiblityOfElement(MainMasterDD, 5);
		MainMasterDD.click();
		wait.VisiblityOfElement(categoryMaster, 5);
		categoryMaster.click();
	}

	public void clickOnNewCategory() {
		newCategory.click();
	}

	/* Navigate to Worker Master Tab */
	public void navigateToWorkerMaster() {
		wait.VisiblityOfElement(MainMasterDD, 5);
		MainMasterDD.click();
		wait.VisiblityOfElement(WorkerMaster, 5);
		WorkerMaster.click();
	}

	public void ClickOnNewWorker() {
		newWorker.click();
	}

	/* Navigate to vendor Master Tab */

	public void navigateToVendorMaster() {
		wait.VisiblityOfElement(MainMasterDD, 5);
		MainMasterDD.click();
		wait.VisiblityOfElement(VendorMaster, 5);
		VendorMaster.click();
	}
	
	public void ClickOnNewVendor()
	{
		newVendor.click();
	}
	
	/* Navigate to Customer Master Tab */
	
	public void navigateToCustomer()
	{
		wait.VisiblityOfElement(MainMasterDD, 5);
		MainMasterDD.click();
		wait.VisiblityOfElement(CustomerMaster, 5);
		CustomerMaster.click();
	}
	public void ClickOnNewCustomer()
	{
		wait.VisiblityOfElement(CustomerMaster, 5);
		newCustomer.click();
	}


}
