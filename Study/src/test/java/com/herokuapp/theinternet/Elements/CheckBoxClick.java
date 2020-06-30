package com.herokuapp.theinternet.Elements;


import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baseTest.Reporter;
import baseTest.TestUtilities;
import pages.CheckBoxPage;
import pages.WelcomePage;


public class CheckBoxClick extends TestUtilities

{	
	
	@Test(priority=1,groups = {"smoke","regression"})
	public void clickCheckBox() 
	{
		log.info("Starting CheckBox Test");
	    WelcomePage welcomePage=new WelcomePage(driver,log);
	   String url = "https://the-internet.herokuapp.com/";
	    welcomePage.openPage(url);
	    CheckBoxPage chkboxes=welcomePage.clickCheckBox();
	    try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    chkboxes.checkBoxClick();
	    //chkboxes.selectedCheckBox(chkbox);
	    Assert.assertTrue(chkboxes.selectedCheckBox(),"Not all checkboxes selected");
	   
	   
	    
	}

}
