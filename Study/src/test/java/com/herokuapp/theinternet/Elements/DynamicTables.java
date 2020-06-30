package com.herokuapp.theinternet.Elements;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import baseTest.TestUtilities;

public class DynamicTables extends TestUtilities {
	
	@Test
	public void dynamicTableMethod()
	{
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Challenging DOM")).click();
		
		
		WebElement table=driver.findElement(By.xpath("//div[@class=\"row\"]/following::table"));
		
		List<WebElement> rows=driver.findElements(By.xpath("//div[@class=\"row\"]/following::table/tbody/tr"));
		System.out.println(rows.size());
		
		
		List<WebElement> cols=driver.findElements(By.xpath("//div[@class=\"row\"]/following::table/thead/tr/th"));
		System.out.println(cols.size());
		
		for(int i=1;i<=rows.size();i++)
		{
			System.out.println("The rows for what values will be printed is "+i);
			for(int j=1;j<=cols.size();j++)
			{
				WebElement ele=driver.findElement(By.xpath("//div[@class=\"row\"]/following::table/tbody/tr["+i+"]/td["+j+"]"));
				String value =ele.getText();
				System.out.println("The  valuesrinted are "+ value);
			/*	if(ele.getText().equals("Definiebas4"))
				{
					System.out.println("Row is"+ i);
					System.out.println("Column is"+ j);
					//String value =ele.getText();
					//String colhead=driver.findElement(By.xpath("//div[@class=\"row\"]/following::table/thead/tr[1]/th["+j+"]")).getText();
					//System.out.println("Column header"+ colhead);
					List<WebElement> lst=driver.findElements(By.xpath("//div[@class=\"row\"]/following::table/tbody/tr["+i+"]/td[7]/a"));
					
					if(i == 4)
					{
						lst.get(1).click();
					}
					else if(i==5)
					{
						lst.get(0).click();
					}
					
				}*/
				
				
			}
			i=i+1;
		}
		
	}

}
