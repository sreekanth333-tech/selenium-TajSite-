package com.sreekanth.selenium_TajSite;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginJoinPagePom {
 WebDriver driver;
 ReusableMethods reusable;
 
 @FindBy(id="simple-tab-2")
 private WebElement membershipButton;
 
@FindBy(xpath="//div[normalize-space()='NeuPass']/div/div")
private WebElement MembershipSdropdwonbutton;
 
@FindBy(xpath="//li[text()='The Chambers']")
private WebElement chambersText; 
 
@FindBy(css="input[placeholder=\"Enter your mobile number\"]")
private WebElement phoneNoFeild;
  
@FindBy(css="input[type=\"checkbox\"]")
private WebElement checkBox;
 
@FindBy(xpath="//button[text()=\"CONTINUE\"]")
private WebElement continueButton;
 
@FindBy(xpath="//input[@placeholder=\"Enter your membership number\"]")
private WebElement NeupassmembershipEnterFeild;

@FindBy(css="input[placeholder=\"Enter four-digit membership number\"]")
private WebElement chambersMembershipEnterFeild;

@FindBy(css="input[type=\"tel\"]") 
private List<WebElement> otpPopup;

@FindBy(id=":rf:")
private WebElement NeupasPasswordFeild;

 @FindBy(xpath="//a[text()=\"LOGIN\"]")
 private WebElement LoginButton;






 public LoginJoinPagePom(WebDriver driver)
 {
	 
	  this.driver= driver;
	   this.reusable= new ReusableMethods(driver);
	PageFactory.initElements(driver, this); 		
	 
 }
 
 
 
 

 
 
 public void phoneNoLogin(String phoneNumber,String OTP) 
 {
	 reusable.WaitAndClick(phoneNoFeild);
	 
	 
	 phoneNoFeild.clear();
	 phoneNoFeild.sendKeys(phoneNumber);
	 checkBox.click();
	 continueButton.click();
	 reusable.waittillVisible(otpPopup);
	 try {
		    Thread.sleep(10000);
		} catch (InterruptedException e) {
		    Thread.currentThread().interrupt();
		}
	 
	 otpPopup.get(0).sendKeys(OTP);
	 
	 
	 
 }
 
 public void neupassmembershipLogin(String membershipNumber, String password)
 {
	 
	 membershipButton.click();
	 membershipButton.clear();
	 NeupassmembershipEnterFeild.sendKeys(membershipNumber);
	 checkBox.click();
	 continueButton.click();
	 NeupasPasswordFeild.sendKeys(password);
	 LoginButton.click();
	 
 }
 
 public void ChambersLogin(String chambersNo, String OTP)
 {
	 
	 reusable.WaitAndClick(membershipButton);
	 
	 reusable.WaitAndClick(MembershipSdropdwonbutton);
	 
	 chambersText.click();
	 
	 reusable.WaitAndClick(chambersMembershipEnterFeild);
	 
	
	 
	 chambersMembershipEnterFeild.sendKeys(chambersNo);
	 checkBox.click();
	 continueButton.click();
	 reusable.waittillVisible(otpPopup);
	 otpPopup.get(0).sendKeys(OTP);
	 
	 
	 
 }
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
}
