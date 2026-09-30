package com.sreekanth.selenium_TajSite;

import org.testng.annotations.Test;

public class ChambersLoginT2 extends BaseClass {


	
	@Test( groups= {"smoke"})
	public void chambersLogin()
	{
	
		String chambers="5792";
		String OTP="254265";
		LoginJoinPagePom t2= new LoginJoinPagePom(getDriver());	
		
				HomePagePom t1=new HomePagePom(getDriver());
		
		t1.LoginClick();
		
		t2.ChambersLogin(chambers,OTP);	
		
		
				
		
	}
	
	
	
	
}
