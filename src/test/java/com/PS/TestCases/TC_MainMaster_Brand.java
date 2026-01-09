package com.PS.TestCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.SkipException;

import java.io.File;

import org.testng.Assert;

import com.PS.PageObjects.BrandMaster_page;
import com.PS.PageObjects.Home_page;
import com.PS.Utilities.Excelutils;

import base.BaseTest;

public class TC_MainMaster_Brand extends BaseTest {

	@Test (dataProvider = "Branddata", enabled=false)
	public void VerifyAddNewBrand(String BrandName) {
		logger.info(">>>>>>>>>>> Verify Add New Brand Funcitonaoity <<<<<<<<<<<<<< ");

		// click on Main Master
		Home_page home = new Home_page(driver);
		home.navigateToBrandMaster();

		// Brand Master
		BrandMaster_page Brand = new BrandMaster_page(driver);
		Brand.clickOnNewBrandTab();
		Brand.enterBrandName(BrandName);
		Brand.uploadBrandLogo(Brand.getPngPath());
		Brand.clickOnCreateBTN();

		// verifying brand is created.
		logger.info("Verifying Brand Creation ");
		Assert.assertEquals(Brand.getBrandName(BrandName), BrandName,"Verification Failed not found brand in List");

	}

	@Test(dataProvider = "Branddata")
	public void deleteCreatedBrand(String BrandName) {
		
		logger.info(">>>>>>>>>>> Verify delete Brand Functionality <<<<<<<<<<<<<< ");

		// click on Main Master
		Home_page home = new Home_page(driver);
		home.navigateToBrandMaster();

		BrandMaster_page brand = new BrandMaster_page(driver);
		brand.clickOnListTab();

		// if brand is created then we delete
		logger.info("Checking if brand exists before deletion: "+BrandName);
		if(brand.isBrandPresent(BrandName)) {
			if(BrandName.startsWith("Test") || BrandName.endsWith("Brand")) {
				logger.info("Safe to Delete Automation Brand :"+BrandName);
				brand.clickOnDeleteBrand();
				brand.confirmDelete();
				
				logger.info("Verifying Brand is deleted");
				Assert.assertFalse(brand.isBrandPresent(BrandName),"Brand is still visible after deletion");
				logger.info("Brand is deleted Successfully: "+BrandName);
			}
			else {
				logger.warn("Skipped deletion: Test persent not found in excel");
				throw new SkipException("Skipping deletion to protected client data");
			}
				
		}
		else {
			logger.warn("Bran not found Skipped deletion "+BrandName);
			throw new SkipException("Brand not availale to delete");
		}
		
	}
	
	
	@DataProvider(name="Branddata")
	public String[][] BrandData(){
		
		String Filepath=System.getProperty("user.dir")+File.separator+"TestData"+File.separator+"BrandData"+File.separator+"PallaviSwadi_TestData.xlsx";
		
		int ttRows=Excelutils.getRowCount(Filepath, "AddBrand");
		int ttCols = Excelutils.getCellCount(Filepath, "AddBrand");
		
		if(ttRows<1) {
			throw new RuntimeException("Excel sheet has no data");
		}
		
		String[][] data= new String[ttRows-1][ttCols];
		for(int i=1;i<ttRows;i++) {
			for(int j=0;j<ttCols;j++) {
				data[i-1][j]=Excelutils.getCellValue(Filepath, "AddBrand", i, j);
			}
		}
		return data;
		
	}
	


}
