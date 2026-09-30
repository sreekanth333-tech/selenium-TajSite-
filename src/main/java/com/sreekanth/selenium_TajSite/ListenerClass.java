package com.sreekanth.selenium_TajSite;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ListenerClass implements ITestListener{
	
	
	
	@Override
	public void onTestStart(ITestResult result)
	{
	
		Reporter.log(" test started   ", true);
	}
	
	
	@Override
	public void onTestSuccess(ITestResult result)
	{
	
		Reporter.log(" testcase  is success   " + result.getName(), true);
	}
	
	
	@Override
	public void onTestFailure(ITestResult result)
	{
	
		Reporter.log(" testcase is  Failed     " + result.getName(), true);
		
		
		WebDriver driver = BaseClass.getDriver();
		
		TakesScreenshot sh= (TakesScreenshot)driver;
		
		File source=   sh.getScreenshotAs(OutputType.FILE);
		
		File screenshotFolder= new File(System.getProperty("user.dir") + "/screenshots");
		
		 if (!screenshotFolder.exists()) {
             screenshotFolder.mkdirs();
         }
		 
		 String fileName =
                 result.getTestClass().getRealClass().getSimpleName()
                 + "_"
                 + result.getName()
                 + ".png";
		 
		 
		 File destination =
                 new File(screenshotFolder, fileName);
		 
		 
		   try {
			Files.copy(
			           source.toPath(),
			           destination.toPath(),
			           StandardCopyOption.REPLACE_EXISTING
			   );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
		
	}
	
	
	@Override
	public void onTestSkipped(ITestResult result)
	{
	
		Reporter.log(" testcase is  Skipped     " + result.getName(), true);
	}
	
	@Override
    public void onFinish(org.testng.ITestContext context) {
        System.out.println("Test Execution Finished");
    }
	
	
	

}
