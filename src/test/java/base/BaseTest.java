package base;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.PS.Utilities.Read_config;
import com.PS.Utilities.WaitHelper;

import io.github.bonigarcia.wdm.WebDriverManager;
import reusable_methods.LoginHelper;

public class BaseTest {

	Read_config config = new Read_config();
	protected String browser = config.getBrowser();
	protected String url = config.getURL();
	protected String username = config.getUserName();
	protected String password = config.getpasswrod();
	
	public static WebDriver driver;
	public static Logger logger = LogManager.getLogger(BaseTest.class);
	
	WaitHelper wait = new WaitHelper(driver);

	@BeforeMethod
	public void setUp() {
		switch (browser.toLowerCase()) {
		case ("chrome"): {
			WebDriverManager.chromedriver().setup();
			logger.info("Chrome Broswer opening");
			driver = new ChromeDriver();
			try {
				BaseTest.driver=driver ;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		case ("firefix"): {
			WebDriverManager.firefoxdriver().setup();
			logger.info("Fire-Fox Broswer Opening");
			driver = new FirefoxDriver();
			BaseTest.driver = driver;
			break;
		}
		}

		logger.info("Loading URL");
		driver.get(url);
		driver.manage().window().maximize();
		LoginHelper loginHelper = new LoginHelper(driver, logger);
		loginHelper.Login();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
	
	

	@AfterMethod
	public void quite() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}


	
	

}
