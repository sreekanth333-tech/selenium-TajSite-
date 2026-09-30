package com.sreekanth.selenium_TajSite;


import org.testng.annotations.Test;

public class MobileLogin extends BaseClass {
	
	

 @Test(dataProvider="logindata", dataProviderClass=PhoneNologinDataProvider.class)
	 public void phoneNumberlogin(String mobileno, String OTP)
	 { 
	 
	 
	 LoginJoinPagePom t1 = new LoginJoinPagePom(getDriver());
	 
	 HomePagePom t2= new HomePagePom(getDriver());
	 
	 t2.LoginClick();
	
	 t1.phoneNoLogin(mobileno, OTP);
	 
	 
     }
 
 
 
}
