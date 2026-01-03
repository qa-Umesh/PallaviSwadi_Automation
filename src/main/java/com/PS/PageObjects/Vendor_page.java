package com.PS.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.PS.Utilities.WaitHelper;

public class Vendor_page {

	WebDriver driver;
	WaitHelper wait;
	Select select;

	public Vendor_page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WaitHelper(driver);
	}

	// identify WebElements
	@FindBy(xpath = "//select[@id='salute_id']")
	WebElement DDSalutation;

	@FindBy(xpath = "//input[@id='first_name']")
	WebElement FirstName;

	@FindBy(xpath = "//input[@id='last_name']")
	WebElement LastName;

	@FindBy(xpath = "//input[@id='company_name']")
	WebElement CompanyName;

	@FindBy(xpath = "//input[@id='vendor_name']")
	WebElement VendorDisplayName;

	@FindBy(xpath = "//input[@id='vendor_email']")
	WebElement VendorEmail;

	@FindBy(xpath = "//input[@id='yes']")
	WebElement GSTYes;
	
	@FindBy(xpath="//input[@id='gst_no']")
	WebElement GSTNo;

	@FindBy(xpath = "//input[@id='pan_no']")
	WebElement PanNo;

	@FindBy(xpath = "//a[@href='#Vendor-address']")
	WebElement VendorAddress;

	@FindBy(xpath = "//input[@id='attention']")
	WebElement InputAttention;

	@FindBy(xpath = "//textarea[@id='address']")
	WebElement textArea;

	@FindBy(xpath = "//select[@id='country_id']")
	WebElement DDCountry;

	@FindBy(xpath = "//select[@id='state_id']")
	WebElement DDState;

	@FindBy(xpath = "//select[@id='city']")
	WebElement DDCity;

	@FindBy(xpath = "//input[@id='pincode']")
	WebElement InputPinCode;

	@FindBy(xpath = "//input[@id='phone_no']")
	WebElement InputPhone;

	@FindBy(xpath = "//input[@id='same_as_bill']")
	WebElement CheckBillDetails;

	@FindBy(xpath = "//button[@id='VendorSubmit']")
	WebElement createBTN;
	
	@FindBy(xpath="//td[contains(text(),'umesh')]")
	WebElement getVendorName;
	
	@FindBy(xpath="//tr[td[contains(text(),'umesh') ]]//a[starts-with(@href,'#delete')]")
	WebElement deleteBTn;
	
	@FindBy(xpath="//div[contains(@class,'modal') and contains(@class,'show')]//input[@value='Delete']")
	WebElement ConfirmDelete;

	public void SelectSalutation() {
		select = new Select(DDSalutation);
		select.selectByVisibleText("Mr.");
	}

	public void EnterFirstName(String name) {
		FirstName.sendKeys(name);
	}

	public void EnterLastName(String lastName) {
		LastName.sendKeys(lastName);
	}

	public void EnterCompanyName(String companyName) {
		CompanyName.sendKeys(companyName);
	}

	public void EnterVendorName(String vendorName) {
		VendorDisplayName.sendKeys(vendorName);
	}

	public void EnterEmail(String email) {
		VendorEmail.sendKeys(email);
	}

	public void CheckGST() {
		GSTYes.click();
	}
	public void EnterGSTNo(String gstNo)
	{
		GSTNo.sendKeys(gstNo);
	}

	public void EnterPanNo(String Pan) {
		PanNo.sendKeys(Pan);
	}

	public void ClickVendorAddress() {
		VendorAddress.click();
	}

	public void EnterAttention(String attention) {
		wait.VisiblityOfElement(InputAttention, 5);
		InputAttention.sendKeys(attention);
	}

	public void EnterAddress(String Address) {
		textArea.sendKeys(Address);
	}

	public void SelectCountry() {
		select = new Select(DDCountry);
		select.selectByVisibleText("India");
	}

	public void SelectState() {
		select = new Select(DDState);
		select.selectByVisibleText("Maharashtra");
	}

	public void SelectCity() {
		select = new Select(DDCity);
		select.selectByVisibleText("MUMBAI");
	}

	public void EnterpinCode(String pinCode) {
		InputPinCode.sendKeys(pinCode);
	}

	public void EnterPhone(String Phone) {
		InputPhone.sendKeys(Phone);
	}

	public void CheckBillingAddress() {
		CheckBillDetails.click();
	}
	
	public void ClickOnCreateBTN()
	{
		wait.VisiblityOfElement(createBTN, 5);
		createBTN.click();
	}
	
	public String getVendorName()
	{
		wait.VisiblityOfElement(getVendorName, 5);
		return getVendorName.getText();
	}
	
	public void ClickOnDeleteButton()
	{
		deleteBTn.click();
	}
	public void ClickOnConfirmDelete()
	{
		wait.VisiblityOfElement(ConfirmDelete, 5);
		ConfirmDelete.click();
	}

}
