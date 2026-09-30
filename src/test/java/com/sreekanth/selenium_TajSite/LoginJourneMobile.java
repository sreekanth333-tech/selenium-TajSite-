package com.sreekanth.selenium_TajSite;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginJourneMobile {
	
	
	public static void t2() throws InterruptedException
	{
		
		WebDriver driver = new ChromeDriver();
		
		
		
		driver.get("https://web-preprod1-528v2.tajhotels.com/en-in");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		 driver.findElement(By.cssSelector("span[class='MuiTypography-root MuiTypography-body-m css-pdfan1']")).click();
		 
		WebElement phoneNoFeild = driver.findElement(By.cssSelector("input[placeholder=\"Enter your mobile number\"]"));
		
		phoneNoFeild.click();
		phoneNoFeild.clear();
		phoneNoFeild.sendKeys("9390925077");
		
		
		
		driver.findElement(By.cssSelector("input[type=\"checkbox\"]")).click();
		
		
		driver.findElement(By.xpath("//button[text()=\"CONTINUE\"]")).click();
		 
		Thread.sleep(10);
		
		List<WebElement> otpBox =driver.findElements(By.id(":rd:"));
	
		String otp="254265";
		
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.visibilityOf(otpBox.get(0)));
		
		otpBox.get(0).sendKeys(otp);
		
		
		driver.findElement(By.xpath("//a[normalize-space()='MY ACCOUNT']")).click();
		
		Thread.sleep(3000);
		
	WebElement claimneucoinsTab=	driver.findElement(By.xpath("//div[normalize-space()='CLAIM NEUCOINS']"));
		
	wait.until(ExpectedConditions.visibilityOf(claimneucoinsTab));
	((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",claimneucoinsTab);
	
	((JavascriptExecutor)driver).executeScript("arguments[0].click();",claimneucoinsTab);
	
	Thread.sleep(3000);
	
WebElement calender=	driver.findElement(By.xpath("//span[normalize-space()='Check in*']"));
	
wait.until(ExpectedConditions.visibilityOfAllElements(calender));

	((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView({block:'center', inline:'nearest'});",calender);
	
	
	Thread.sleep(2000);
	//calender.click();
	
		//driver.findElement(By.cssSelector("svg[data-testid=\"ArrowBackIosRoundedIcon\"]")).click();
		
		//List<WebElement> Dates= driver.findElements(By.xpath("//div[@class=\"react-calendar__month-view__days\"]/button"));
		 
		//Dates.get(0).click();
		//Dates.get(1).click();
		
		driver.findElement(By.cssSelector("input[type=\"file\"]")).sendKeys("D:\\Downloads\\C.Pedda Raju- resume.pdf");
		
		
		
	}

}
