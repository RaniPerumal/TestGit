package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import baseTest.BasePage;
import baseTest.Reporter;

public class WelcomePage extends BasePage

{
	
	public WelcomePage(WebDriver driver,Logger log)
	{
		super(driver,log);
	}
	
	public void openPage(String string)
	{
		log.info("Opening Welcome Page");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		openUrl(string);
		log.info("PageOpened");
	}
	
	public LoginPage clickFormAuthLink()

	{
		log.info("clicking formauth link in Welcome Page");
		try {
			click("formAuthLink");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new LoginPage(driver,log);
		
	}
	
	public CheckBoxPage clickCheckBox()

	{
		log.info("clicking CheckBoxes link in Welcome Page");
		try {
			
			Thread.sleep(2000);
			click("checkBox");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new CheckBoxPage(driver,log);
		
	}
	
	public DropDownPage clickDropDown()

	{
		log.info("clicking DropDown link in Welcome Page");
		try {
			click("dropDown");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new DropDownPage(driver,log);
		
	}
	
	public AlertsPage clickAlertLink()

	{
		log.info("clicking Alert link in Welcome Page");
		try {
			click("AlertLink");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new AlertsPage(driver,log);
		
	}
	
	public WindowsPage clickMultipleWindowsLink()

	{
		log.info("clicking Windows link in Welcome Page");
		try {
			click("WindowsLink");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new WindowsPage(driver,log);
		
	}
	
	public FramePage clickFramesLink()

	{
		log.info("clicking Frames link in Welcome Page");
		try {
			click("frameLink");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new FramePage(driver,log);
		
	}
	
	public KeyPressPage clickKeyPressLink()

	{
		log.info("clicking KeyPress link in Welcome Page");
		try {
			click("keyPressLink");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new KeyPressPage(driver,log);
		
	}
	
	public FileUploadPage clickFileUploadLink()

	{
		log.info("clicking KeyPress link in Welcome Page");
		try {
			click("fileuploadLink");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new FileUploadPage(driver,log);
		
	}
}
