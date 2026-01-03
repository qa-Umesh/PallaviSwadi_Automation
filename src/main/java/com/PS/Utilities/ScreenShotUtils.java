package com.PS.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotUtils {

	public static String captureScreenshot(WebDriver driver,String testName)
	{
		
		if (driver == null) {
            System.out.println("Driver is null, screenshot not captured");
            return null;
        }

		String timestamp=new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
		String reportName=testName+"_"+timestamp+".png";
		String screenshotPath=System.getProperty("user.dir")+File.separator+"ScreenShots"+File.separator+reportName;

		TakesScreenshot ts =(TakesScreenshot) driver;

		File source=ts.getScreenshotAs(OutputType.FILE);
		File destination=new File(screenshotPath);

		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("File not found ");
		}
		return screenshotPath;
	}


}
