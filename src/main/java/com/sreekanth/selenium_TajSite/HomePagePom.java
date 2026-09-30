package com.sreekanth.selenium_TajSite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePagePom {
	
	WebDriver driver;
	ReusableMethods reusable;
	
	@FindBy(xpath="//span[normalize-space()=\"LOGIN / JOIN\"]")
	 private WebElement loginButton;
	
	@FindBy(xpath="//a[normalize-space()='MY ACCOUNT']")
	private WebElement myAccountButton;
	
	
	@FindBy(xpath="//button[text()=\\\"BOOK A STAY\\\"]")
	private WebElement BookAStayButton;
	
	@FindBy(xpath="//input[@type=\\\"text\\\"]")
	private WebElement searchInputFeild;
	
	@FindBy(xpath="//span[text()=\\\"Taj Lands End, Mumbai\\\"]")
	private WebElement hotelSuggestion;
	
	@FindBy(xpath="//button[text()=' Check rates']")
	private WebElement checkRatesButton;
	
	
	
	public HomePagePom(WebDriver driver)
	{
		
		this.driver= driver;
		
		this.reusable= new ReusableMethods(driver);
		PageFactory.initElements( driver, this);	
		
	}
	
	
	public void LoginClick()
	{
		reusable.WaitAndClick(loginButton);
	}
	
	public void myAccountButtonClick()
	{
		myAccountButton.click();
		
	}
	
	
	public void selectHotel( String hote1name)
	{
		
		BookAStayButton.click();
		reusable.WaitAndClick(searchInputFeild);
		searchInputFeild.clear();
		searchInputFeild.sendKeys(hote1name);
		hotelSuggestion.click();
		reusable.WaitAndClick(checkRatesButton);
		
		
	}
	
		
			

}
