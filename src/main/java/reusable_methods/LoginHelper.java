package reusable_methods;


import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.PS.PageObjects.Login_page;
import com.PS.Utilities.Read_config;

public class LoginHelper {

	WebDriver driver;
	Logger logger;

	public LoginHelper(WebDriver driver,Logger logger)
	{
		this.driver=driver;
		this.logger=logger;
	}



	public void Login()
	{
		logger.info("------------- Login: Pallavi Swadi -------------");
		Read_config config = new Read_config();


		Login_page login= new Login_page(driver);
		logger.info("Entering Username");
		login.enterUsername(config.getUserName());
		logger.info("Entering Password");
		login.enterPassword(config.getpasswrod());
		logger.info("clicking on Loging button");
		login.clickOnloginBTN();
	}

}
