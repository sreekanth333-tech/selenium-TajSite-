package com.sreekanth.selenium_TajSite;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
public class BaseClass {
	
	
	
	public static final ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	
	public static WebDriver getDriver()
	{
		return driver.get();
	}
	
	@BeforeMethod
	@Parameters("browser")
	    public  void setup(String browser) 
	    {

	     
	        
	        String url= ConfigReader.get("PREPRODURL");
           //String browser= ConfigReader.get("BROWSER");
	       if(browser.equalsIgnoreCase("chrome"))
	       {
	    	   
	    	   driver.set(new ChromeDriver());
	    	   getDriver().get(url);
	    	   getDriver().manage().window().maximize();
	    	   
	    	   
	       }
	       else if(browser.equalsIgnoreCase("edge"))
	       {
	    	   
	    	   driver.set (new EdgeDriver());
	    	   getDriver().get(url);
	    	   
	    	   getDriver().manage().window().maximize();
	       }

	       
	       else
	       {
	    	   throw new RuntimeException ("un supported brwoser  " + browser);
	       }

	       
	    }
	    
	
	
	@AfterMethod
	        public void tearDown() {

	        if (getDriver() != null) {
	        	getDriver().quit();
	        	driver.remove();
	        	
	        }
	    
	    
	}
}

	


