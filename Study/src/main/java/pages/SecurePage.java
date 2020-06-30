package pages;

import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import baseTest.BasePage;

public class SecurePage extends BasePage {
	
	private String expectedUrl = "http://the-internet.herokuapp.com/secure";
	
	
	

	public SecurePage(WebDriver driver, Logger log) 
	
	{
		super(driver,log);
	}
	
	public String getUrl()
	{
		return expectedUrl;
	}
	
	public boolean logoutisdiplayed() throws InterruptedException
	{
		Boolean bool=false;
		try {
			bool= locateElement("logout").isDisplayed();
		} catch (InterruptedException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bool;
	}
	
	public String getSucessMessageText() 
	{
		String Result=null;
		try {
			Result= locateElement("message").getText();
		} catch (InterruptedException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Result;
	}

}
