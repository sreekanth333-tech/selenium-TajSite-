package com.sreekanth.selenium_TajSite;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class practise2 {
	
	public static void t4() throws InterruptedException {
		
		

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.tajhotels.com/en-in");
        
        driver.manage().window().maximize();
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        
        

  driver.findElement(By.cssSelector("span[class='MuiTypography-root MuiTypography-body-m css-pdfan1']")).click();
     
 

  
 
Thread.sleep(5000);
driver.findElement(By.id("simple-tab-2")).click();
Thread.sleep(5000);

// driver.findElement(By.xpath("//div[text()='NeuPass']")).click();

//driver.findElement(By.xpath("//li[text()='The Chambers']")).click();



WebElement ele=driver.findElement(By.cssSelector("input[placeholder=\"Enter your membership number\"]"));
ele.click();
ele.sendKeys("6029230123816420");
//JavascriptExecutor jse = (JavascriptExecutor)driver;
//
//jse.executeScript("arguments[0].click(),ele);
driver.findElement(By.cssSelector("input[type=\"checkbox\"]")).click();
driver.findElement(By.xpath("//button[text()=\"CONTINUE\"]")).click();


driver.findElement(By.id(":rf:")).sendKeys("Techouts@123");

driver.findElement(By.xpath("//a[text()=\"LOGIN\"]")).click();
Thread.sleep(5000);

driver.findElement(By.xpath("//a[normalize-space()='MY ACCOUNT']")).click();

Thread.sleep(3000);

WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));

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
