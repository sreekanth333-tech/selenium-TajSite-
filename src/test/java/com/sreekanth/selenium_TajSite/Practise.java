package com.sreekanth.selenium_TajSite;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import javax.swing.text.DateFormatter;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Practise {
	
	public static void t3() throws InterruptedException {
		
			

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
// JavascriptExecutor jse = (JavascriptExecutor)driver;
// 
// jse.executeScript("arguments[0].click(),ele);
 driver.findElement(By.cssSelector("input[type=\"checkbox\"]")).click();
 driver.findElement(By.xpath("//button[text()=\"CONTINUE\"]")).click();
 
 
 driver.findElement(By.id(":rf:")).sendKeys("Techouts@123");
 
 driver.findElement(By.xpath("//a[text()=\"LOGIN\"]")).click();
 Thread.sleep(5000);
 
 //WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
 //WebElement bookAStay=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=\"BOOK A STAY\"]")));
 
// bookAStay.click();
 
 driver.findElement(By.xpath("//button[text()=\"BOOK A STAY\"]")).click();
 
 Thread.sleep(5000);
 //JavascriptExecutor jse= (JavascriptExecutor)driver;
 WebElement el3=driver.findElement(By.xpath("//input[@type=\"text\"]"));
 el3.click();
 el3.clear();
 el3.sendKeys("taj lands end");
 //jse.executeScript("arguments[0].value='taj lands end  ';",el3);
 
 
 //Thread.sleep(5000);
 
 //driver.findElement(By.cssSelector("input[type=\"text\"]")).sendKeys("taj lands");
 
 driver.findElement(By.xpath("//span[text()=\"Taj Lands End, Mumbai\"]")).click();
 Thread.sleep(5000);	
 driver.findElement(By.xpath("//button[text()=' Check rates']")).click();
 
 Thread.sleep(5000);
 driver.findElement(By.xpath("//div[@class=\"MuiStack-root css-9tq2nt\"]/following-sibling::div")).click();
 
 
 List<WebElement> dates = driver.findElements(
		    By.xpath("//button[contains(@class,'react-calendar__tile')]")); 
        
 
 
 LocalDate targetDate = LocalDate.of(2026, 9, 25);
 
 DateTimeFormatter df= DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
		 
		 
		 while(true)
		 {
			 String dateName= targetDate.format(df);
			 
			 
			  System.out.println("Checking: " + dateName);
			 
			  
			  WebElement date = driver.findElement(By.xpath("//abbr[@aria-label='" + dateName + "']/parent::button"));
				        
			  
			  List<WebElement> xMark = date.findElements(By.xpath(".//span[normalize-space()='✖']"));
			  List<WebElement> rate = date.findElements(By.xpath(".//p[contains(normalize-space(),'₹')]")); 
				
			  

			    if (!xMark.isEmpty()) {

			        System.out.println(dateName + " → NOT AVAILABLE");

			        // Move to next date
			        targetDate = targetDate.plusDays(1);

			    } else if (!rate.isEmpty()) {

			        System.out.println(
			            dateName + " → AVAILABLE → " + rate.get(0).getText()
			        );

			        date.click();

			        System.out.println("Selected date: " + dateName);

			        break;
			    }
			    
			   
			    
			    
			     
			}
			  
			  
		 driver.findElement(By.xpath("//button[normalize-space()='SEARCH']")).click();
		 
		 
List<WebElement> allMemberRetes = driver.findElements(By.xpath("//span[text()='MEMBER RATE']/following-sibling::div/span"));
		
List<WebElement> allStandardRetes = driver.findElements(By.xpath("//span[normalize-space()='STANDARD RATE']"));


if(!allMemberRetes.isEmpty())
{
	
	
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	
WebElement selectbutton=	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()=\"SELECT\"]")));

	((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",selectbutton);
	
	
	((JavascriptExecutor)driver).executeScript("arguments[0].click();",selectbutton);
	
}
	
else if(!allStandardRetes.isEmpty())
{
	driver.findElement(By.xpath("//button[text()=\"SELECT\"]")).click();

	
}



WebElement proceedButton= driver.findElement(By.xpath("//button[normalize-space()='PROCEED']"));

if(proceedButton.isEnabled())
		{
	proceedButton.click();
	
	}


Thread.sleep(3000);


WebElement checkbox =driver.findElement(By.cssSelector("input[type=\"checkbox\"]"));

((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",checkbox);

((JavascriptExecutor)driver).executeScript("arguments[0].click();",checkbox);


driver.findElement(By.xpath("//button[normalize-space()='CONTINUE TO CONFIRM']")).click();











	 
 }
 
 
 
 
 
 
	}


