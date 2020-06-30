package pages;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import baseTest.BasePage;

public class CheckBoxPage extends BasePage {
	
	private By chkbox=By.xpath("//input[@type=\"checkbox\"]");

	public CheckBoxPage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	
	
	public void checkBoxClick()
	{
		List<WebElement> lstChkBox=locateElements(chkbox);
		
		for (WebElement chkBox:lstChkBox)
		{
		/*	if(!(chkBox.isSelected()))
			{
			chkBox.click();
				
			}*/
			
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(chkBox.getAttribute("checked") == null)
			{
				chkBox.click();
			}
		}
		log.info("clicking check box in CheckBox Page");
	}
	
	public boolean selectedCheckBox()
	{
		List<WebElement> lstChkBox=locateElements(chkbox);
		
		for (WebElement chkBox:lstChkBox)
		{
			if(!(chkBox.isSelected()))
			{
				log.info("veryfing  all check boxes are clicked in CheckBox Page abc");
			    return false;
			}
		}
		log.info("veryfing  all check boxes are clicked in CheckBox Page");
		return true;
		
	}

}
