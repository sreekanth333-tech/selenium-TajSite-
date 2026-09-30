package com.sreekanth.selenium_TajSite;

import org.testng.annotations.DataProvider;

public class PhoneNologinDataProvider {

	
	
	@DataProvider(name ="logindata")
	public Object[][] getloginData()
	{
		
		String path= System.getProperty("user.dir")+"\\src\\test\\resource\\TestData.xlsx";
		
		String sheetName= "LoginTestData";
		
		UtilityClass excel= new UtilityClass(path,sheetName);
		
		
		
		int rowCount= excel.getRowCount();
		
		
		Object[][] data= new Object[rowCount][2];
		
		
		for(int i=1; i<=rowCount; i++)
		{
			data[i-1][0]=excel.getCellData(i,0);  //mobile no
			data[i-1][1]=excel.getCellData(i,1);   //OTP
			
			
			
		}
		
		excel.closeWorkbook();
		return data;
		
		
	}
}
