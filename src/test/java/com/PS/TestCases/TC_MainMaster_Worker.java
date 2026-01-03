package com.PS.TestCases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.PS.PageObjects.Home_page;
import com.PS.PageObjects.Workers_page;

import base.BaseTest;

public class TC_MainMaster_Worker extends BaseTest {

	@Test
	public void verified_AddWorker() {
		logger.info(">>>>>>>>>>>>>>> Verifyed Add New Worker Functoinality <<<<<<<<<<<<<<");

		Home_page home = new Home_page(driver);

		logger.info("Navigating to Worker Master");
		home.navigateToWorkerMaster();
		logger.info("Clicking on new Worker Tab");
		home.ClickOnNewWorker();

		Workers_page worker = new Workers_page(driver);

		logger.info("Entering Worker ID");
		worker.enterWorkerID("001");
		logger.info("Entering Worker Name");
		worker.enterWorkerName("Test01");
		logger.info("Seleting Working Type - In-house");
		worker.SelectWorkerType();
		logger.info("Entering Mobile no");
		worker.enterMobileNo("7208670761");
		logger.info("Entring Address");
		worker.enterAddress("Sagar kutir sangh seven bunglow Andheri West");
		logger.info("Clicking on Submit Button");
		worker.ClcikOnCreate();

		logger.info("Verifying Worker is added or not.. ");
		assertEquals(worker.getWorkerName(), "Test01", "worker name mismatch after adding");

	}

	@Test(dependsOnMethods = "verified_AddWorker")
	public void Delet_AddedWorker() {
		
		logger.info(">>>>>>>>>>>>>>> Delete Added Worker Functoinality <<<<<<<<<<<<<<");

		Home_page home = new Home_page(driver);

		logger.info("Navigating to Worker Master");
		home.navigateToWorkerMaster();
		
		Workers_page worker = new Workers_page(driver);

		logger.info("Verifying worker dummy is add or not");
		if(worker.getWorkerName().equals("Test01")) 
		{
			logger.info("verifyed successful: Click on Delete Button");
			worker.ClickOnDeleteBTN();
			logger.info("Click on Confirm Delete Button");
			worker.ConfirmDelete();
		}
		else
		{
			Assert.assertTrue(false,"Verificaiotn Failed: Worker not found in list");
		}
	}
}
