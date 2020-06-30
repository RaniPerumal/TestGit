package pages;

import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import baseTest.BasePage;

public class fileuploadedpage extends BasePage{
	
	

	public fileuploadedpage(WebDriver driver, Logger log) {
		super(driver, log);
		// TODO Auto-generated constructor stub
	}
	
	public String getfileuploadedmessage() throws InterruptedException
	{
		String filedmessage = null;
		try {
			filedmessage = (locateElement("fileuploadedmessage").getText().toString());
		} catch (InterruptedException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filedmessage;
	}

}
