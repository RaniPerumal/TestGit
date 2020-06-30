package com.herokuapp.theinternet.Elements;


import java.io.IOException;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import baseTest.Reporter;
import baseTest.TestUtilities;
import pages.AlertsPage;
import pages.WelcomePage;


public class AlertsTypes extends TestUtilities 

{
	private String Result;
	@Test(groups = {"regression"})
	public void handlingDifferentAlerts() throws InterruptedException
	
	{
		WelcomePage Wpage = new WelcomePage(driver, log);
		String url = "https://the-internet.herokuapp.com/";
		Wpage.openPage(url);
		
		AlertsPage apage=Wpage.clickAlertLink();
		
		apage.acceptingJSAlertButton();
		try {
			Result=apage.GetResultMessage();
		} catch (InterruptedException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(Result, "You successfuly clicked an alert");
		
		apage.acceptingJSConfirmAlertButton();
		try {
			Result=apage.GetResultMessage();
		} catch (InterruptedException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(Result, "You clicked: Ok");
		
		apage.dismissingJSAlertButton();
		try {
			Result=apage.GetResultMessage();
		} catch (InterruptedException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(Result, "You clicked: Cancel");
		
		apage.HandlingJSPromptButton();
		try {
			Result=apage.GetResultMessage();
		} catch (InterruptedException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(Result, "You entered: I am Rani");
		
		
	}

}
