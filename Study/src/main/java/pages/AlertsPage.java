package pages;

import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import baseTest.BasePage;

public class AlertsPage extends BasePage{
	
	
	

	public AlertsPage(WebDriver driver, Logger log) 
	{
		super(driver, log);
		// TODO Auto-generated constructor stub
	}
	
	public void acceptingJSAlertButton() 
	{
		log.info("Accepting the alert");
		try {
			click("JSAlertBtn");
		} catch (InterruptedException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AlertSwitch();
		driver.switchTo().alert().accept();
	}
	
	public void acceptingJSConfirmAlertButton() 
	{
		log.info("Accepting the confirm alert");
		try {
			click("JSConfirmBtn");
		} catch (InterruptedException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AlertSwitch();
		driver.switchTo().alert().accept();
	}
	
	public void dismissingJSAlertButton() throws InterruptedException
	{
		log.info("Dismissing the confirm alert");
		try {
			click("JSConfirmBtn");
		} catch (InterruptedException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AlertSwitch();
		driver.switchTo().alert().dismiss();
	}
	
	public void HandlingJSPromptButton() throws InterruptedException
	{
		log.info("handling the prompt alert");
		try {
			click("JSpromptBtn");
		} catch (InterruptedException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AlertSwitch();
		driver.switchTo().alert().sendKeys("I am Rani");
		driver.switchTo().alert().accept();
		
	}
	
	
	
	

}
