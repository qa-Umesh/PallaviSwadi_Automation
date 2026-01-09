package extent_report;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;

import com.PS.Utilities.Read_config;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import base.BaseTest;

public class ExtentReportManager  {
	
	private static ExtentSparkReporter htmlReport;  // UI/ HTML look
	private static ExtentReports report;   // manage tests
	private static ExtentTest test;       // individual test log
	WebDriver driver;
	
	public static ExtentReports getReports() {
		
		Read_config config= new Read_config();
		
		
		String TimeStamp=new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
		String ReportName="PallaviSwadi_Report_"+TimeStamp+".html";
		htmlReport = new ExtentSparkReporter(System.getProperty("user.dir")+File.separator+"Reports"+File.separator+ReportName);
		
		report= new ExtentReports();
		report.attachReporter(htmlReport);
		
		
		// System Information / Environment Information 
		report.setSystemInfo("user", "Umesh");
		report.setSystemInfo("Operating System", "MacOS");
		report.setSystemInfo("machine", "Mackbook Pro");
		report.setSystemInfo("Browser",config.getBrowser());

		
		if(BaseTest.driver!=null) {
			report.setSystemInfo("Browser Version", ((HasCapabilities)BaseTest.driver).getCapabilities().getBrowserVersion());
		}
		
		report.setSystemInfo("Environment", "QA");
		report.setSystemInfo("Execution Time", new SimpleDateFormat("YYYY-MM-dd_HH-mm-ss").format(new Date()));
		
		
		// Configuration To change look and feel
		
		htmlReport.config().setDocumentTitle("Pallavi Swadi | Automation Test Report");
		htmlReport.config().setReportName("Pallavi Swadi- Test Execution Report");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setTimeStampFormat("YYYY-MM-dd HH-mm-ss");
		
		
		return report;
		
		
		
		
	}
	
	

}
