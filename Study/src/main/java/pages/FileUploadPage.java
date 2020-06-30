package pages;

import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import baseTest.BasePage;

public class FileUploadPage extends BasePage{
	
	
	
	//input[@id=""]

	public FileUploadPage(WebDriver driver, Logger log) {
		
		super(driver, log);
	}
	
	public void selectfile(String filename) throws InterruptedException 
	{
		//click(fileuploadpath);
		log.info("selecting file" +filename+"from files folder");
		//String userdir=System
		String filepath=System.getProperty("user.dir")+"\\src\\main\\resources\\files\\"+filename;
		System.out.println(filepath);
		try {
			type("fileuploadpath", filepath);
		} catch (InterruptedException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public fileuploadedpage pushuploadbutton() throws InterruptedException 
	{
		log.info("click upload button");
		try {
			click("fileuploadbutton");
		} catch (InterruptedException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new fileuploadedpage(driver, log);
		
	}

}
