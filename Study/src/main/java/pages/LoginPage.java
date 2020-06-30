package pages;

import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import baseTest.BasePage;

public class LoginPage extends BasePage {
	
	
	
	private By userName=By.id("username");
	private By passWord=By.id("password");
	private By login= By.className("radius");
	private By errormessage=By.xpath("//div[@class=\"flash error\"]");

	public LoginPage(WebDriver driver, Logger log) 
	{
		super(driver,log);
	}
	
	public SecurePage login(String username,String password) throws InterruptedException
	{
		log.info("Logging into the application");
		log.info("type username");
		try {
			type("userName", username);
		} catch (InterruptedException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		log.info("type password");
		try {
			type("passWord", password);
		} catch (InterruptedException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		try {
			click("login");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
		return new SecurePage(driver,log);
	}
	
	public void negativelogin(String username,String password) throws InterruptedException
	{
		log.info("Logging into the application");
		log.info("type user name");
		try {
			type("userName", username);
		} catch (InterruptedException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		log.info("type password");
		try {
			type("passWord", password);
		} catch (InterruptedException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			click("login");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public String getErrorMessageText() 
	{
		log.info("getting error message");
		String strErrorMessage=null;
		try {
			strErrorMessage= locateElement("errormessage").getText();
		} catch (InterruptedException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return strErrorMessage;
	}

}
