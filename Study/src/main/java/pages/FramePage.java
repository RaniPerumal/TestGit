package pages;

import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import baseTest.BasePage;

public class FramePage extends BasePage {
	
	
  	public FramePage(WebDriver driver, Logger log) {
		super(driver, log);
		// TODO Auto-generated constructor stub
	}
	
	public String handlingFrames() throws InterruptedException
	{
		log.info("Switching to frame");
		try {
			switchToFrame("frameElement");
		} catch (InterruptedException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("Getting content from Page source");
		String actualText=getPagesource();
		return actualText;
	}

}
