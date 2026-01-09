package com.PS.TestCases;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.io.File;

import com.PS.PageObjects.Home_page;
import com.PS.PageObjects.Login_page;
import com.PS.Utilities.Excelutils;

import base.BaseTest;

public class TC_Login extends BaseTest {

	@Test(dataProvider = "LoginDataProvider")
	public void VerifyLoginFunctionality(String UserName, String Password, String testType) {
		logger.info("Executing Login Test Case With '{}' | Username: '{}' | Password: '{}'", testType, UserName,maskPassword(Password));
		
		
		
		Login_page login = new Login_page(driver);

		logger.debug("Entering username: {}", UserName);
		login.enterUsername(UserName);

		logger.debug("Entering password: {}", maskPassword(Password));
		login.enterPassword(Password);

		logger.info("Clicking on Login button");
		login.clickOnloginBTN();

		if (testType.equalsIgnoreCase("Valid credentials")) {
			Home_page home = new Home_page(driver);
			// assertion for successful login
			Assert.assertTrue(home.isDashboarDisplayed(), "Dashboard is not displayed for valid login"+testType);

		} else {

			// assertion for invalid login
			Assert.assertTrue(login.isErrorMessageDisplayed(),
					"Error Message is not displayed for Invalid " + testType);

		}
		logger.info("{} login test completed.",testType);
		
		

	}
	
	private String maskPassword(String password) {
		if(password==null) {
			return "Null password";
		}
		return password.length()>0 ?"*****":"empty password";
	}

//

	@DataProvider(name = "LoginDataProvider")
	public String[][] DataProvider() {
		String LoginPath = System.getProperty("user.dir") + File.separator + "TestData" + File.separator + "LoginData"
				+ File.separator + "LoginData.xlsx";

		int ttRows = Excelutils.getRowCount(LoginPath, "Login");
		int ttCols = Excelutils.getCellCount(LoginPath, "Login");

		if (ttRows <= 1) {
			throw new RuntimeException("Excel sheet has no data rows!");
		}

		if (ttCols <= 0) {
			throw new RuntimeException("Excel sheet has no columns!");
		}

		String[][] data = new String[ttRows - 1][ttCols]; // exclude header

		for (int i = 1; i < ttRows; i++) { // start from row 1 (skip header)
			for (int j = 0; j < ttCols; j++) { // start from column 0
				data[i - 1][j] = Excelutils.getCellValue(LoginPath, "Login", i, j);
			}
		}
		return data;

	}

}
