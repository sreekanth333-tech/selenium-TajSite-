package com.sreekanth.selenium_TajSite;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlanYourStayPagePom {
	
	WebDriver driver;
	
	
	@FindBy(xpath="//div[@class=\\\"MuiStack-root css-9tq2nt\\\"]/following-sibling::div")
	WebElement calendarClick;
	
	@FindBy(xpath="//button[contains(@class,'react-calendar__tile')]")
	List<WebElement> dates;
	
	
	
	public PlanYourStayPagePom(WebDriver driver)
	{
		
	this.driver=driver;
	PageFactory.initElements( driver,this);
				
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
