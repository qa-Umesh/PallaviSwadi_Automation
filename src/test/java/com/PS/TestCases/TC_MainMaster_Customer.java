package com.PS.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.PS.PageObjects.Customer_page;
import com.PS.PageObjects.Home_page;

import base.BaseTest;

public class TC_MainMaster_Customer extends BaseTest {
	
	
	@Test
	public void verify_addCustomer() {
		logger.info(">>>>>>>>>>>>>>> Verifyed Add New Venfor Functoinality <<<<<<<<<<<<<<");
		Home_page home = new Home_page(driver);
		logger.info("Navigating to customer Master");
		home.navigateToCustomer();
		logger.info("Click on New Customer");
		home.ClickOnNewCustomer();
		
		Customer_page customer= new Customer_page(driver);
		logger.info("Enter Customer Name");
		customer.enterCustumerName("umesh");
		logger.info("Enter Customer Email");
		customer.enterCustumerEmail("umeshkute453@gmail.com");
		logger.info("Selecting Place of Supply");
		customer.SelectPlaceOfSupply();
		logger.info("Selecting GST Treatment");
        customer.SelectRegistrationType();
        
        logger.info("Clicking on create button");
        customer.ClickOnCreateButton();
        
       //Assert.assertTrue(false);
		
	}

}
