package com.PS.TestCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.File;

import org.testng.Assert;

import com.PS.PageObjects.BrandMaster_page;
import com.PS.PageObjects.Home_page;
import com.PS.Utilities.Excelutils;

import base.BaseTest;

public class TC_MainMaster_Brand extends BaseTest {

	@Test 
	public void Verify_addnewBrand() {
		logger.info(">>>>>>>>>>> Verify Add New Brand Funcitonaoity <<<<<<<<<<<<<< ");

		// click on Main Master
		Home_page home = new Home_page(driver);

		logger.info("Clicking to Brand Master");
		home.navigateToBrandMaster();

		// Brand Master
		BrandMaster_page Brand = new BrandMaster_page(driver);

		logger.info("Clicking on New Brand");
		Brand.clickOnNewBrandTab();

		logger.info("Entering Brand Name");
	   Brand.enterBrandName(Brand.BrandName());
		//Brand.enterBrandName(brandName);
		

		logger.info("Uploding Brand Logo");
		Brand.uploadBrandLogo(Brand.getPngPath());
		//Brand.uploadBrandLogo(PNG);
		
		logger.info("Clicking on Create Button");
		Brand.clickOnCreateBTN();

		// verifying brand is created.
		logger.info("Checking is Brand created ");
		Assert.assertEquals(Brand.getBrandName(), "Pallavi Swadi", "Brand Name mismatch after creation.");

	}

	@Test(dependsOnMethods = "Verify_addnewBrand")
	public void deleteCreatedBrand() {

		// click on Main Master
		Home_page home = new Home_page(driver);

		logger.info("Navigating to Brand Master");
		home.navigateToBrandMaster();

		BrandMaster_page brand = new BrandMaster_page(driver);

		logger.info("Navigate to List of Brand");
		brand.clickOnListTab();

		// if brand is created then we delete
		logger.info("Finding recently Added Brand...");
		if (brand.getBrandName().equals("Pallavi Swadi")) {
			logger.info("Brand Found");
			logger.info("clicking on Delete button");
			brand.clickOnDeleteBrand();
			logger.info("Clicking Confirm Delete button..");
			brand.confirmDelete();
			logger.info("Brand Deleted Successfully: Pallavi Swadi");
			AssertJUnit.assertTrue(true);
		} else {
			logger.error("Brand not found in List");
			AssertJUnit.assertTrue(false);
		}
	}
	
	


}
