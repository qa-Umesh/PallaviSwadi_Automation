package com.PS.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.PS.PageObjects.DeliveryAddress_page;
import com.PS.PageObjects.Home_page;

import base.BaseTest;

public class TC_MainMaster_DeliveryAddress extends BaseTest {

	@Test 
	public void verify_DeliveryAddress() {
		logger.info(">>>>>>>>>>>>>>> Verifyed Delivery Address Functoinality <<<<<<<<<<<<<");
		Home_page home = new Home_page(driver);
		logger.info("Navigating to Delivery Address ");
		home.navigateToDeliveryAddress();

		logger.info("Click on new Address tab");
		home.ClickonNewAddTab();

		DeliveryAddress_page delivery = new DeliveryAddress_page(driver);
		logger.info("Entering Warehous Name");
		delivery.enterWarehouseName("GoCodeX Pvt.Ltd.");
		logger.info("Entering Address");
		delivery.enterAddress("Malad West");
		logger.info("Entering PinCode Number");
		delivery.enterPinCode("400061");
		logger.info("Entering Email id");
		delivery.enterEmail("Testing@Gocodex.com");
		logger.info("Entering Phone No");
		delivery.enterPhoneNo("7208670761");
		logger.info("Entering GST No");
		delivery.enterGSTNo("27AAACM3025E1ZZ.");
		logger.info("clicking on create button");
		delivery.clickOnCreateBTN();

		Assert.assertEquals(delivery.getWharehouseName(), "GoCodeX Pvt.Ltd.",
				"Test PASS: Delivery Address Address Successfuly");

	}

	@Test(dependsOnMethods = "verify_DeliveryAddress")
	public void verify_DeleteDeliveryAddress() {
		logger.info(">>>>>>>>>>>>>>> Verifyed Delete Delivery Address Functoinality <<<<<<<<<<<<<");
		Home_page home = new Home_page(driver);
		logger.info("Navigating to Delivery Address ");
		home.navigateToDeliveryAddress();

		DeliveryAddress_page delivery = new DeliveryAddress_page(driver);
		if (delivery.getWharehouseName().contains("GoCodeX Pvt.Ltd.")) {

			delivery.clickOnDeleteBTN();
			delivery.ClickOnConfirmDelete();
			Assert.assertTrue(true);
		} else {
			logger.info("Recent Added Warehouse not found!!");
			Assert.assertTrue(false);
		}
	}

}
