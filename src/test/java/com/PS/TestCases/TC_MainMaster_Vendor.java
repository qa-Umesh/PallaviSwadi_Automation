package com.PS.TestCases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.PS.PageObjects.Home_page;
import com.PS.PageObjects.Vendor_page;

import base.BaseTest;

public class TC_MainMaster_Vendor extends BaseTest {

	@Test
	public void verify_AddNewVendor() {
		logger.info(">>>>>>>>>>>>>>> Verifyed Add New Venfor Functoinality <<<<<<<<<<<<<<");
		Home_page home = new Home_page(driver);
		logger.info("Navigating to Vendor Master");
		home.navigateToVendorMaster();
		logger.info("CLicking on New Vendor");
		home.ClickOnNewVendor();

		Vendor_page vendor = new Vendor_page(driver);
		logger.info("Selecting Salutation");
		vendor.SelectSalutation();
		logger.info("Entering First Name");
		vendor.EnterFirstName("umesh");
		logger.info("Entering last name");
		vendor.EnterLastName("kute");
		logger.info("Entering Company Name");
		vendor.EnterCompanyName("GoCodeX InfoTech Pvt. LTD. ");
		logger.info("Entering Vendor Displayed Name");
		vendor.EnterVendorName("Test-01");
		logger.info("Entering Vendor Email");
		vendor.EnterEmail("umeshkute453@gmail.com");
		logger.info("Selecting GST Yes..");
		vendor.CheckGST();
		logger.info("Entering GST No");
		vendor.EnterGSTNo("27ABCDE1234F1Z5");
		logger.info("Entering Pan No");
		vendor.EnterPanNo("AAACH2702H");
		logger.info("Clicking on create Button");
		vendor.ClickOnCreateBTN();
		assertEquals(vendor.getVendorName(),"umesh","Vendor not found");

	}
	
	@Test(dependsOnMethods = "verify_AddNewVendor")
	public void verify_ConfirmDelete()
	{
		logger.info(">>>>>>>>>>>>>>> Verifyed delete Venfor Functoinality <<<<<<<<<<<<<<");
		Home_page home = new Home_page(driver);
		logger.info("Navigating to Vendor Master");
		home.navigateToVendorMaster();
		
		Vendor_page vendor = new Vendor_page(driver);
		if(vendor.getVendorName().equals("umesh")) {
			logger.info("CLicking on delete Vendor buton");
			vendor.ClickOnDeleteButton();
			logger.info("Click on Confirm Delete");
			vendor.ClickOnConfirmDelete();
		}
		else {
			logger.info("Vendor not found");
			Assert.assertTrue(false);
		}

		
		
		
	}

}
