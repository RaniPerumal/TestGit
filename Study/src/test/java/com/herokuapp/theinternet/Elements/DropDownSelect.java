package com.herokuapp.theinternet.Elements;


import java.util.Map;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import baseTest.Reporter;
import baseTest.TestUtilities;
import pages.DropDownPage;
import pages.WelcomePage;

public class DropDownSelect extends TestUtilities 
{
	
	@Test(groups= {"smoke"})
	public void SelectdropDown() throws InterruptedException
	{
		log.info("Starting DropDown Test");
		WelcomePage welcompage=new WelcomePage(driver, log);
		String url = "https://the-internet.herokuapp.com/";
		welcompage.openPage(url);
	
		DropDownPage Dpage = welcompage.clickDropDown();
		
		Dpage.SelectDropDown(2);
		
		String SelectedOptiontext=Dpage.SelectedOptionDropDown();
		
		Assert.assertEquals(SelectedOptiontext, "Option 2");
	}
	
	

}
