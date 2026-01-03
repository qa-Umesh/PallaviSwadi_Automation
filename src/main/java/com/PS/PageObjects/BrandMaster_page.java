package com.PS.PageObjects;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.PS.Utilities.WaitHelper;

public class BrandMaster_page {

	WebDriver driver;
	WaitHelper wait;
	
	protected String Brand = "Pallavi Swadi";

	public BrandMaster_page(WebDriver rdriver) {
		this.driver = rdriver;
		PageFactory.initElements(rdriver, this);
		wait = new WaitHelper(rdriver);
	}

	/*---------- New Brand WebElements ----------- */
	@FindBy(xpath="//a[@href='#tabs-profile-3']")
	WebElement NewBrandTab; // new Brand Tab;

	@FindBy(xpath="//a[@href='#tabs-home-3']")
	WebElement ListTab;

	@FindBy(xpath = "//input[@placeholder='Brand Name']")
	WebElement BrandInput;

	@FindBy(xpath = "//input[@id='image']")
	WebElement FileUpload;

	@FindBy(xpath = "//button[@id='createButton']")
	WebElement createBTN;


	@FindBy(xpath="//td[contains(text(),'Pallavi Swadi')]")
	WebElement addedBrandName;

	@FindBy(xpath="//tr[td[normalize-space()='Pallavi Swadi']]//a[starts-with(@href,'#delete')]")
	WebElement DeleteAddedBrand;

	@FindBy(xpath="//div[contains(@class,'modal') and contains(@class,'show')]//input[@value='Delete']")
	WebElement ConfirmDelete;

	/*---------- perform actions on New Brand WebElements ----------- */
	public void clickOnNewBrandTab() {
		NewBrandTab.click();
	}

	public void enterBrandName(String name) {
		wait.VisiblityOfElement(BrandInput, 10);
		BrandInput.sendKeys(name);
	}

	public void uploadBrandLogo(String logoPath) {
		FileUpload.sendKeys(logoPath);
	}

	public void clickOnCreateBTN() {
		createBTN.click();
	}
	public String getBrandName()
	{
		wait.VisiblityOfElement(addedBrandName, 5);
		return addedBrandName.getText();
	}

	public void clickOnListTab()
	{
		wait.VisiblityOfElement(ListTab, 5);
		ListTab.click();
	}
	public void clickOnDeleteBrand()
	{
		wait.VisiblityOfElement(DeleteAddedBrand, 5);
		DeleteAddedBrand.click();
	}
	public void confirmDelete()
	{
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

}
