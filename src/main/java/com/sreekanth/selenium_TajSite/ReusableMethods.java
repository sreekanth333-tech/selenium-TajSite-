package com.sreekanth.selenium_TajSite;

import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusableMethods{

	WebDriver driver;
	WebDriverWait wait;
	Actions act;
	JavascriptExecutor jse;
	
	
	
	public ReusableMethods(WebDriver driver)
	{
		this.driver= driver;
		this.wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		this.act= new Actions(driver);
		this.jse= (JavascriptExecutor)driver;
		
	}
	
	
	
	public void WaitAndClick(WebElement element)
	{
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	
	public void waittillVisible (WebElement element)
	{
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waittillVisible ( List<WebElement> element)
	{
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
		
		
		
	}
	
	
	
	
	
	public void waitAndClickLocator (By locator)
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	
		
	}
	
	
	public void waitTillAllElements(WebElement element)
	{
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
	}
	
	 public void implicitwait()
	 {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
	 }
	 
	 public void ActionsClick(WebElement element)
	 {
		
		 act.click(element).perform();
	 }
	 
	 
	 
	 
	 
	 public void ActionsScrollAndCick(WebElement element)
	 {
		
		 act.scrollToElement(element).perform();
		 element.click();
		 
	 }
	 
	 public void ActionsSendkeys(WebElement element, String Text)
	 {
		
		 act.sendKeys(element, Text).perform();
	 }
	 
	 
	 public void javascriptClick(WebElement element)
	 {
		
		 jse.executeScript("arguments[0].click();",element);
	 }
	
	 public void javascriptScroll(WebElement element)
	 {
		
		 jse.executeScript("arguments[0].scrollIntoView(true);",element);
	 }
	
	 public void javascriptScrollBlock(WebElement element)
	 {
		
		 jse.executeScript("arguments[0].scrollIntoView({block : 'center',inline:'nearest')};",element);
	 }
	 public void javascriptSendkeys(WebElement element, String input)
	 {
		
		 jse.executeScript("arguments[0].value= arguments[1];",element, input);
	 }
	
	 public void dateFormatter() 
	 {
		DateTimeFormatter formatter= DateTimeFormatter.ofPattern("MMMM d, yyyy");
		 
		 
	 }
	
}
