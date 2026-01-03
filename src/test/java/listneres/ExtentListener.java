package listneres;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.PS.Utilities.Read_config;
import com.PS.Utilities.ScreenShotUtils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import base.BaseTest;

public class ExtentListener implements ITestListener {

	ExtentSparkReporter htmlReport;
	ExtentReports reports;
	ExtentTest test;
	
	//public static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	

	public void ConfigureReport()
	{
		Read_config config =  new Read_config();
		String TimeStamp=new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
		String ReportName="PallaviSwadi_Report_"+TimeStamp+".html";
		htmlReport= new ExtentSparkReporter(System.getProperty("user.dir")+File.separator+"Reports"+File.separator+ReportName);
		reports = new ExtentReports();
		reports.attachReporter(htmlReport);


		// System Information / Environment Information
		reports.setSystemInfo("User:", "Umesh");
		reports.setSystemInfo("Operating System:", "MacOS");
		reports.setSystemInfo("Machine", "Mackbook Pro");
		reports.setSystemInfo("browser", config.getBrowser());
		if (BaseTest.driver != null) {
		    reports.setSystemInfo("Browser Version",
		        ((HasCapabilities) BaseTest.driver)
		        .getCapabilities().getBrowserVersion());
		}
		reports.setSystemInfo("Environment", "QA");
		reports.setSystemInfo("Execution Time", new SimpleDateFormat("dd-MM-YYYY HH:MM:SS").format(new Date()));


		// configuration to change look and feel
		htmlReport.config().setDocumentTitle("Pallavi Swadi | Automation Test Report");
		htmlReport.config().setReportName("Pallavi Swadi - Test Execution Report");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setTimeStampFormat("dd-MMM-YYYY HH:MM:SS");

	}

	public void onStart(ITestContext context)
	{
		ConfigureReport(); // create extends report object

		reports.setSystemInfo("Suite Name", context.getSuite().getName());
		reports.setSystemInfo("Environment", "QA");

		System.out.println("=========== Test Execution Started ===========");

	}
	public void onFinish(ITestContext context)
	{
		System.out.println("=========== Test Execution Finished ===========");
		reports.flush();
	}
	public void onTestStart(ITestResult result)
	{
		test=reports.createTest(result.getMethod().getMethodName());  // this will print in console that which method is executed

	}
	public void onTestSuccess(ITestResult result)
	{
		System.out.println("Test PASSED: "+result.getName());
	//test=reports.createTest(result.getName());		
	test.log(Status.PASS, MarkupHelper.createLabel("Test Case PASSED: "+result.getName(), ExtentColor.GREEN));
	}
	public void onTestFailure(ITestResult result)
	{
		System.out.println("Test FAILED:"+result.getName());
	//	test=reports.createTest(result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel("Test Case FAILED:"+result.getThrowable(), ExtentColor.RED));
		
		
		
		WebDriver driver = BaseTest.driver;

	    if (driver == null) {
	        System.out.println("Driver is null, screenshot not captured");
	        return;
	    }

	    String screenshotPath =
	            ScreenShotUtils.captureScreenshot(driver, result.getName());

	    test.fail("Test Failed: " + result.getName());

	    if (screenshotPath != null) {
	        test.addScreenCaptureFromPath(screenshotPath);
	    }
	
	}
	public void onTestSkipped(ITestResult result)
	{
		System.out.println("Test SKIPPED: "+result.getName());
		//test=reports.createTest(result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel("Test Case SKIPPED: "+result.getName(), ExtentColor.YELLOW));
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
		// leave empty
	}
	

   
}
