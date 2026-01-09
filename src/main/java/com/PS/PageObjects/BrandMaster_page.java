package com.PS.PageObjects;

import java.io.File;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.PS.Utilities.WaitHelper;

public class BrandMaster_page {

	WebDriver driver;
	WaitHelper wait;
	Logger logger;
	
	protected String Brand = "Test Brand";

	public BrandMaster_page(WebDriver rdriver) {
		this.driver = rdriver;
		PageFactory.initElements(rdriver, this);
		wait = new WaitHelper(rdriver);
		logger= LogManager.getLogger(BrandMaster_page.class);
	}

	/*---------- New Brand WebElements ----------- */
	@FindBy(xpath="//a[@href='#tabs-profile-3']")
	WebElement NewBrandTab; // new Brand Tab;

	@FindBy(xpath="//a[@href='#tabs-home-3']")
	WebElement ListTab;  // list tab

	@FindBy(xpath = "//input[@placeholder='Brand Name']")
	WebElement BrandInput;  // brand name input box

	@FindBy(xpath = "//input[@id='image']")
	WebElement FileUpload;   // file upload 

	@FindBy(xpath = "//button[@id='createButton']")
	WebElement createBTN;    // create button field
	
	@FindBy(xpath="//input[@placeholder=\"Search here...\"]")
	WebElement SearchBrand;   // search box for brand
	
	@FindBy(xpath="//table//tbody//tr//td[contains(text(),'Test Brand')]")
	private List<WebElement> brandNameList;


	@FindBy(xpath="//td[contains(text(),'Test Brand')]")
	WebElement addedBrandName;  

	@FindBy(xpath="//tr[td[normalize-space()='Test Brand']]//a[starts-with(@href,'#delete')]")
	WebElement DeleteAddedBrand;

	@FindBy(xpath="//div[contains(@class,'modal') and contains(@class,'show')]//input[@value='Delete']")
	WebElement ConfirmDelete;

	/*---------- perform actions on New Brand WebElements ----------- */
	public void clickOnNewBrandTab() {
		logger.info("Clicking on New Brand Button");
		NewBrandTab.click();
	}

	public void enterBrandName(String name) {
		logger.info("Entering Brand name: "+name);
		wait.VisiblityOfElement(BrandInput, 10);
		BrandInput.sendKeys(name);
	}

	public void uploadBrandLogo(String logoPath) {
		logger.info("uploading Brand logo");
		FileUpload.sendKeys(logoPath);
	}

	public void clickOnCreateBTN() {
		logger.info("Click on Create button");
		createBTN.click();
	}
	

	public void clickOnListTab()
	{
		logger.info("Click on Brand Lists");
		wait.VisiblityOfElement(ListTab, 5);
		ListTab.click();
	}
	public void clickOnDeleteBrand()
	{
		logger.info("Clicking on delete icon");
		wait.VisiblityOfElement(DeleteAddedBrand, 5);
		DeleteAddedBrand.click();
	}
	public void confirmDelete()
	{
		logger.info("clicking on confirm delete");
		wait.VisiblityOfElement(ConfirmDelete, 5);
		ConfirmDelete.click();
	}
	
	public String getPngPath()
	{
		String path=System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator
				+ "resources" + File.separator + "FileUploads" + File.separator + "PallaviSwadiLogo.webp";
		return path;
	}
	public String BrandName()
	{
		return Brand;
	}
	
	public boolean isBrandPresent(String BrandName) {
		logger.info("Searching for Brand: "+BrandName);
		
		wait.VisiblityOfElement(SearchBrand, 5);
		SearchBrand.clear();
		SearchBrand.sendKeys(BrandName);
		
		for(WebElement brand: brandNameList) {
			if((brand.getText().equals(BrandName))) {
				logger.info("Brand found in list: "+BrandName);
				return true;
			}

		}
		logger.info("Brand Not found in list: "+BrandName);
		return false;
		
	}
	
	public String getBrandName(String BrandName) {
		SearchBrand.clear();
		SearchBrand.sendKeys(BrandName);
		
		for(WebElement brand: brandNameList) {
			if(brand.getText().equals(BrandName)) {
				return brand.getText();
			}
		}
		return "";

	}

}
