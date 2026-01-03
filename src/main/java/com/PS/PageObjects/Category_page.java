package com.PS.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.PS.Utilities.WaitHelper;

public class Category_page {

	WebDriver driver;
	WaitHelper wait;
	Select select;

	public Category_page(WebDriver rdriver) {
		this.driver = rdriver;
		PageFactory.initElements(rdriver, this);
		wait = new WaitHelper(rdriver);

	}

	// WebElements
	@FindBy(xpath = "//select[@id='brand']")
	WebElement SelectBrand;

	@FindBy(xpath = "//li[contains(text(),'PALLAVI SWADI')]")
	WebElement psdOption;

	@FindBy(xpath = "//select[@id='CategoryType']")
	WebElement SelctCategory;

	@FindBy(xpath = "//li[contains(text(),'Finished')]")
	WebElement FinishedOption;

	@FindBy(xpath = "//input[@id='department_name']")
	WebElement InputDepartmentName;

	@FindBy(xpath = "//input[@id='category_name']")
	WebElement InputCategoryName;

	@FindBy(xpath = "//input[@id='issub_cat']")
	WebElement checkBoxSub;

	@FindBy(xpath = "//input[@name='sub_category[0][sub_category_name]']")
	WebElement InputSub_category;

	@FindBy(xpath = "//button[@id='createButton']")
	WebElement createCategory;
	
	@FindBy(xpath="//tr[td[contains(text(),'pallavi swadi')]]//a[starts-with(@href,'#delete')]")
	WebElement deleteBTN;
	
	@FindBy(xpath="//div[contains(@class,'modal') and contains(@class,'show')]//input[@value='Delete']")
	WebElement confirmDelete;

	// perform actions

	public void selectBrand(String brand) {
		select = new Select(SelectBrand);
		select.selectByVisibleText(brand);
	}

	public void selectCategory(String category) {
		select= new Select(SelctCategory);
		select.selectByVisibleText(category);	
	}

	public void enterDepartmentName(String DepartmentName) {
		InputDepartmentName.sendKeys(DepartmentName);
	}

	public void enterCategoryName(String CategoryName) {
		InputCategoryName.sendKeys(CategoryName);
	}

	public void checkBoxCategory() {
		checkBoxSub.click();
	}

	public void enterSub_Category(String subCategory) {
		InputSub_category.sendKeys(subCategory);
	}

	public void clickOnCreateBTN() {
		createCategory.click();
	}
	
	public void ClickOnDeleteBTN()
	{
		wait.VisiblityOfElement(deleteBTN, 5);
		deleteBTN.click();
	}
	
	public void ConfirmDelete()
	{
		wait.VisiblityOfElement(confirmDelete, 5);
		confirmDelete.click();
	}
}
