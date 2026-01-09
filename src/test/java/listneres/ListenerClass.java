package listneres;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.PS.Utilities.ScreenShotUtils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import base.BaseTest;
import extent_report.ExtentReportManager;

public class ListenerClass implements ITestListener {

	private ExtentReports reports;

	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>(); // use thread local for parall execution

	public void onStart(ITestContext context) {

		reports = ExtentReportManager.getReports(); // extent report start
		reports.setSystemInfo("Suite Name", context.getSuite().getName());
		System.out.println("=========== Test Execution Started ===========");

	}

	public void onFinish(ITestContext context) {
		System.out.println("=========== Test Execution Finished ===========");
		reports.flush();
	}

	public void onTestStart(ITestResult result) {

		String testName = result.getMethod().getMethodName();

		Object[] params = result.getParameters();

		if (params != null && params.length >= 3) {
			testName = testName + " | " + params[2];

		}

		ExtentTest extentTest = reports.createTest(testName);
		test.set(extentTest);

	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test PASSED: " + result.getName());
		test.get().log(Status.PASS,
				MarkupHelper.createLabel("Test Case PASSED: " + result.getName(), ExtentColor.GREEN));
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Test FAILED:" + result.getName());
		test.get().log(Status.FAIL,
				MarkupHelper.createLabel("Test Case FAILED:" + result.getThrowable(), ExtentColor.RED));

		// capture screenshot and store in reports
		WebDriver driver = BaseTest.driver;

		if (driver == null) {
			System.out.println("Driver is null, screenshot not captured");
			return;
		}

		String screenshotPath = ScreenShotUtils.captureScreenshot(driver, result.getName());

		test.get().fail("Test Failed: " + result.getName());

		if (screenshotPath != null) {
			test.get().addScreenCaptureFromPath(screenshotPath);
		}

	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Test SKIPPED: " + result.getName());
		test.get().log(Status.SKIP,
				MarkupHelper.createLabel("Test Case SKIPPED: " + result.getName(), ExtentColor.YELLOW));
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// leave empty
	}

}
