package pages;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import baseTest.BasePage;

public class WindowsPage extends BasePage {
	
	//private By clickHere=By.linkText("Click Here");

	public WindowsPage(WebDriver driver, Logger log) {
		super(driver, log);
		// TODO Auto-generated constructor stub
	}
	
	public String handlingWindows(String expectedTitle) throws InterruptedException
	{
		log.info("Handling multiple windows");
		try {
			click("clickHere");
		} catch (InterruptedException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("hello");
		WindowHandle("New Window");
		System.out.println("hello1");
		return getPagesource();
		
	}
	

}
