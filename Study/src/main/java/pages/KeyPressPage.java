package pages;

import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import baseTest.BasePage;

public class KeyPressPage extends BasePage{
	
	
	
	public KeyPressPage(WebDriver driver, Logger log) {
		super(driver, log);
		// TODO Auto-generated constructor stub
	}
	
	public void keyPress(Keys ky) throws InterruptedException, IOException
	{
		
		log.info("Pressing Keys");
		pressKey(ky);
	}
    
	public String GetResultMessage() throws InterruptedException
	{
		log.info("Getting the Result Message");
		String strResult=null;
		try {
			System.out.println(locateElement("result").getText());
		} catch (InterruptedException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			strResult=locateElement("result").getText();
		} catch (InterruptedException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return strResult;
	}
	
	
}
