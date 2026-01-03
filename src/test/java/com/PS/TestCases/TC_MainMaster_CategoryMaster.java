package com.PS.TestCases;

import org.testng.annotations.Test;

import com.PS.PageObjects.Category_page;
import com.PS.PageObjects.Home_page;

import base.BaseTest;

public class TC_MainMaster_CategoryMaster extends BaseTest {

	@Test (enabled=false)
	public void verify_AddCategory() {
		logger.info(">>>>>>>>>>>>>>> Verifyed Add New Category Functoinality <<<<<<<<<<<<<");
		
		Home_page home = new Home_page(driver);
		
		logger.info("Navigate to Category Master");
		home.navigateToCategoryMaster();
		
		logger.info("click on new Category Master");
		home.clickOnNewCategory();

		Category_page category = new Category_page(driver);
		
		logger.info("Select Brand");
		category.selectBrand("PALLAVI_SWADI");
		
		logger.info("Selecting category");
		category.selectCategory("Finished");
		
		logger.info("Entering Department Name");
		category.enterDepartmentName("Test Department");
		
		logger.info("Entering Category Name");
		category.enterCategoryName("test");
		
		logger.info("Clicking on Check box");
		category.checkBoxCategory();
		
		logger.info("Entering Sub Category ");
		category.enterSub_Category("test-1");
		
		logger.info("clicking on Create Button");
		category.clickOnCreateBTN();

	}
	
	@Test(dependsOnMethods = "verify_AddCategory")
	public void deleteCreatedCategory()
	{
		logger.info(">>>>>>>>>>>>>>> Verifyed Delete Category Functoinality <<<<<<<<<<<<<");

		Home_page home = new Home_page(driver);
		logger.info("Navigate to Category Master");
		home.navigateToCategoryMaster();
		
		Category_page category = new Category_page(driver);

		
	}

}
