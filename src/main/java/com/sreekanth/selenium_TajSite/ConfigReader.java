package com.sreekanth.selenium_TajSite;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	private static Properties properties;
	
	
	static
	{	
		
		String path= System.getProperty("user.dir")+"//src//test//resource//QA.properties";
		
		
		properties = 	new Properties();
		
		
		try(FileInputStream fis = new FileInputStream(path))
		{
			
			properties.load(fis);
			
		}
		catch(IOException e)
		{
			throw new RuntimeException("Failed to load QA Properites"+ e.getMessage());
		}
			
}
	
	
	
	public static String get(String key)
	
	{
		
		String value= properties.getProperty(key);
		
		if(value ==null)
		{
			throw new RuntimeException("properies"+ key+"is not vailable in qa properies file");	
			
		}
		
		return value;
		
	}
	
	
	
	
	
	
	
	
	
}
