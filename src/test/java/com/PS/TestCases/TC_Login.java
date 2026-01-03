package com.PS.TestCases;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;


import com.PS.PageObjects.Home_page;
import com.PS.PageObjects.Login_page;

import base.BaseTest;

public class TC_Login extends BaseTest{

	@Test (enabled=true)
	public void verifiedLogin()
	{
		logger.info("<<<<<<<<<<<<<<<< Verifiy Login Functionaity >>>>>>>>>>>>>>>>");
		Login_page login = new Login_page(driver);

		logger.info("Entering Username");
		login.enterUsername(username);
		logger.info("Entering Password");
		login.enterPassword(password);
		logger.info("clicking on login Button");
		login.clickOnloginBTN();

		Home_page dashboard= new Home_page(driver);
		String actualDashboard=dashboard.getDashboard();
		logger.info("Verifying login is successfull");
		if(actualDashboard.contains("Home"))
		{
			logger.info("Login Successfull: Logo Verified..");
			AssertJUnit.assertTrue(true);
		}
		else
		{
			logger.info("Login Failed: Logo not found");
			Assert.fail("Login Failed due to logo not found");
		}

	}

}
