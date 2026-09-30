package com.sreekanth.selenium_TajSite;

import java.time.Duration;

import java.time.LocalDate;
import org.openqa.selenium.TimeoutException;
import java.util.List;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookingJourneySelectedDates {

	
	
	
		public void t1() throws InterruptedException
		{
		 WebDriver driver = new ChromeDriver();

	        driver.get("url");
	        
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
ele.sendKeys("6912369907667391");
//JavascriptExecutor jse = (JavascriptExecutor)driver;
//
//jse.executeScript("arguments[0].click(),ele);
driver.findElement(By.cssSelector("input[type=\"checkbox\"]")).click();
driver.findElement(By.xpath("//button[text()=\"CONTINUE\"]")).click();


driver.findElement(By.id(":rf:")).sendKeys("rathodenayak12@N");

driver.findElement(By.xpath("//a[text()=\"LOGIN\"]")).click();
Thread.sleep(5000);

WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
WebElement bookAStay=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=\"BOOK A STAY\"]")));

bookAStay.click();

//driver.findElement(By.xpath("//button[text()=\"BOOK A STAY\"]")).click();
Thread.sleep(5000);
JavascriptExecutor jse= (JavascriptExecutor)driver;
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


List< WebElement> closePopupp=driver.findElements(By.xpath("//span[text()=\"CLOSE\"]"));
 
if(!closePopupp.isEmpty())
 {
  closePopupp.get(0).click();
 }
 Thread.sleep(5000);
	 WebElement calendarChevron= driver.findElement(By.xpath("//div[@class=\"MuiStack-root css-9tq2nt\"]/following-sibling::div"));
	 
	 jse.executeScript("arguments[0].click();",calendarChevron);

//driver.findElement(By.xpath("//div[@class=\"MuiStack-root css-9tq2nt\"]/following-sibling::div")).click();

//WebElement previousmonthChevron=driver.findElement(By.cssSelector("//div[@class=\"react-calendar react-calendar--doubleView\"]/div/button"));
		
//previousmonthChevron.click();	
		
//WebElement NextmonthChevron=driver.findElement(By.cssSelector("//div[@class=\"react-calendar react-calendar--doubleView\"]/div/button[3]"));
//NextmonthChevron.click();

LocalDate todayDate=  LocalDate.now();



      List<WebElement> Dates=driver.findElements(By.xpath("//button[@class=\"react-calendar__tile react-calendar__month-view__days__day\"]"));
      
     for(WebElement date:Dates)
     {
    	 
    	 String dateText= date.findElement(By.xpath(".//abbr[@aria-label]")).getAttribute("aria-label");
    	 
    	 String rate= date.findElement(By.xpath(".//div//p[contains(text(),'₹')]")).getText();
    	   
    	 DateTimeFormatter formatter=DateTimeFormatter.ofPattern("MMMM d, yyyy");
    	 
    	 LocalDate CalendarDate= LocalDate.parse(dateText,formatter) ;
    	 
    	 if(CalendarDate.isAfter(todayDate))
    	 {
    		Thread.sleep(5000);
    		WebElement rateElement =date.findElement(By.xpath(".//div//p[contains(text(),'₹')]"));
    		
    		rateElement.click();
    		
    		break;
    	 }
    	 
    	 
    	 
    	 
     }
     
     driver.findElement(By.xpath("//button[normalize-space()='SEARCH']")).click();
     
     List<WebElement> allMemberRetes = driver.findElements(By.xpath("//span[text()='MEMBER RATE']/following-sibling::div/span"));
		
     List<WebElement> allStandardRetes = driver.findElements(By.xpath("//span[normalize-space()='STANDARD RATE']"));


     if(!allMemberRetes.isEmpty())
     {
     	
     	
     	
     	
     WebElement selectbutton=	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()=\"SELECT\"]")));

     	((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",selectbutton);
     	
     	
     	((JavascriptExecutor)driver).executeScript("arguments[0].click();",selectbutton);
     	
     }
     	
     else if(!allStandardRetes.isEmpty())
     {
     	driver.findElement(By.xpath("//button[text()=\"SELECT\"]")).click();

     	
     }


By proceedLocator = By.xpath("//button[normalize-space()='PROCEED']");
    List <WebElement> proceedButton= driver.findElements(proceedLocator);

    
   
     if(!proceedButton.isEmpty() )
     		{
    	 
    	 try
    	 {
    	 
    	 System.out.println("proceed button enabled");
    	 
    	 
     	 wait.until(ExpectedConditions.elementToBeClickable(proceedLocator)).click();
     	 
     	 
     	 
    	 }
    	 catch(TimeoutException e)
    	 {
    		 
    		 System.out.println("proceed button not enabled");
    	 }
    	 
     	}

	
     Thread.sleep(3000);
    
     By JoinPopupstale= By.xpath("//div[@class=\"MuiBox-root css-he7789\"]/span");
     
     
     
	
     

    		List<WebElement> joinPopUp = driver.findElements(JoinPopupstale);

    		if (!joinPopUp.isEmpty()) {
    		    System.out.println("JOIN popup found");
    		    joinPopUp.get(0).click();
    		} else {
    		    System.out.println("JOIN popup not found ");
    		}
	
	

     
     
     
     
     
    
     
     //non logged in journey:
     
    /* WebElement salutationFeild= driver.findElement(By.xpath("//input[@name=\"salutation\"]/./preceding-sibling::div"));
     
wait.until(ExpectedConditions.visibilityOf(salutationFeild));
jse.executeScript("arguments[0].click();",salutationFeild);


     WebElement mrOption= driver.findElement(By.xpath("//li[text()='Mr']"));
     wait.until(ExpectedConditions.visibilityOf(mrOption));
     jse.executeScript("arguments[0].click();",mrOption);
     
     WebElement FirstnameFeild= driver.findElement(By.id(":rh:"));
     FirstnameFeild.click();
     FirstnameFeild.sendKeys("testUser",Keys.TAB,"IOO",Keys.TAB,"testuser@32.com",Keys.TAB,Keys.TAB,"9505553333");
     
     
     */
     
    
     
     By checkbox= By.cssSelector("input[type='checkbox']");
     
     
//getting stale element reference exception for check box
     //WebElement checkbox =driver.findElement(By.cssSelector("input[type=\"checkbox\"]"));
     WebElement Checkboxoption=   wait.until(ExpectedConditions.presenceOfElementLocated(checkbox));
     ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",Checkboxoption);

     ((JavascriptExecutor)driver).executeScript("arguments[0].click();",Checkboxoption);

    List <WebElement> paylaterOption= driver.findElements(By.xpath("//span[normalize-space()=\"PAY LATER\"]/../following-sibling::span/input"));

if(!paylaterOption.isEmpty())
{
	System.out.println("proceed button enabled");
	Thread.sleep(5000);
	
	WebElement payemntFrame= driver.findElement(By.name("HyperServices"));
	
driver.switchTo().frame(payemntFrame);


By  creditOptionLocator= By.xpath("//article[text()=\"Credit / Debit Card\"]");
  
    WebElement  creditOption= wait.until(ExpectedConditions.presenceOfElementLocated(creditOptionLocator));
     jse.executeScript("arguments[0].click();",creditOption);
	
     
     
	By creditcardNumberEnterLocator= By.cssSelector("input[placeholder=\"Enter card number here\"]");

WebElement creditcardNumberEnter= wait.until(ExpectedConditions.presenceOfElementLocated(creditcardNumberEnterLocator));
jse.executeScript("arguments[0].click();",creditcardNumberEnter);


	creditcardNumberEnter.sendKeys("4854987152613227",Keys.TAB,Keys.TAB,"01/39");
	
	
	
	
	By cvvlocator = By.id("10000113");
	
	
	
	WebElement cvv=driver.findElement(cvvlocator);
	cvv.sendKeys("100");
	
	
	By rbiCheckBoxLocator= By.id("10000153");
	WebElement rbiCheckBox= wait.until(ExpectedConditions.presenceOfElementLocated(rbiCheckBoxLocator));
	
	jse.executeScript("arguments[0].click();",rbiCheckBox);
	
	
	By proceedToPayButtonLocator= By.xpath("//article[text()='PROCEED TO PAY ']");
	WebElement proceedToPayButton= wait.until(ExpectedConditions.presenceOfElementLocated(proceedToPayButtonLocator));
	
	jse.executeScript("arguments[0].click()",proceedToPayButton);

	
}
}
}


		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	


