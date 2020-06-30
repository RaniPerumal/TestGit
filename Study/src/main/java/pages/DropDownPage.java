package pages;

import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import baseTest.BasePage;

public class DropDownPage extends BasePage{
	
	//By dropDown =By.xpath("//select[@id=\"dropdown\"]");

	public DropDownPage(WebDriver driver, Logger log) 
	{
		super(driver, log);
		// TODO Auto-generated constructor stub
	}
	
	public void SelectDropDown(int i) throws InterruptedException
	{
		log.info("selecting dropdown in DropDown Page");
		WebElement ele = null;
		try {
			ele = locateElement("dropDownSelect");
		} catch (InterruptedException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Select down = new Select(ele);
		down.selectByValue(""+i);
	}
	
	public String SelectedOptionDropDown() throws InterruptedException
	{
		log.info("getting selected option from dropdown in DropDown Page");
		WebElement ele = null;
		try {
			ele = locateElement("dropDownSelect");
		} catch (InterruptedException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Select down = new Select(ele);
		return (down.getFirstSelectedOption().getText());
	}
	
	
	

}
