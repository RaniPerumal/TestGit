package baseTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;


import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	protected WebDriver driver;
	//protected Logger log;
	protected  Logger log;
	private By body=By.xpath("//input[@id=\"target\"]");
	
	private String fileName="src\\main\\resources\\properties\\Config.properties";
	
	public BasePage(WebDriver driver,Logger log)
	{
		this.driver=driver;
		this.log=log;
	}
	
	protected void openUrl(String url)
	{
		driver.get(url);
	}
	
    public String configFileName(String key) throws IOException
    {
    	//System.out.println("objectfileName"+key);
    	 File file = new File("src\\main\\resources\\properties\\Config.properties");
    	// System.out.println("objectfileName"+key);
    	FileInputStream fis=new FileInputStream(file);
		Properties prop= new Properties();
		prop.load(fis);
		String objectprop=prop.getProperty(key);
		//System.out.println(objectprop);
		return objectprop;
    }
	
	public By readproperty(String key) 
	{
		By element = null;
		String filename = "src\\main\\resources\\properties\\OR.properties";
		FileInputStream fisRead=null;
		try {
			filename = configFileName("ObjectfileName");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Congig file exception");
			log.info("Congig file exception");
			e.printStackTrace();
		}
		 File file = new File(filename);
		System.out.println(filename);
	//	FileInputStream fisRead;
		try {
			fisRead = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File processing error");
			log.info("File processing error");
		}
		Properties prop= new Properties();
		try {
			prop.load(fisRead);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("properties failed");
			e.printStackTrace();
		}
		String objectprop=prop.getProperty(key);
		System.out.println(objectprop);
		String[] proper=objectprop.split(":");
		System.out.println(proper[0]);
		System.out.println(proper[1]);
		
		if (proper[0].equals("linkText"))
		{  System.out.println(proper[1]);
			element=By.linkText(proper[1]);
		}
		else if (proper[0].equals("xpath")) 
		{
			System.out.println(proper[1]);
			element=By.xpath(proper[1]);
		}
		else if (proper[0].equals("id")) 
		{
			element=By.id(proper[1]);
		}
		else if (proper[0].equals("partialLinkText")) 
		{
			element=By.linkText(proper[1]);
		}
		else if (proper[0].equals("tagName")) 
		{
			element=By.linkText(proper[1]);
		}
		else if (proper[0].equals("className")) 
		{
			element=By.className(proper[1]);
		}
		
		return element;
	}
	

	
	protected WebElement locateElement(String Key) throws InterruptedException, IOException
	{
		Thread.sleep(1000);
		System.out.println("Locate Element"+Key);
		By element=readproperty( Key);
		return driver.findElement(element);
	}
	
	protected List<WebElement> locateElements(By element)
	{
		return driver.findElements(element);
	}
	
	protected void click(String Key) throws InterruptedException, IOException
	{
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Click function -" +Key);
		locateElement(Key).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void type(String Key,String keysToSend) throws InterruptedException, IOException
	
	{
		locateElement(Key).sendKeys(keysToSend);
	}
	
	protected void waitFor(ExpectedCondition<WebElement> condition,Integer timeout)
	{
		timeout=(timeout != null)?timeout:30;
		WebDriverWait wait=new WebDriverWait(driver, timeout);
		wait.until(condition);
		
	}

	protected void waitforVisibility(By locator,Integer timeout)
	{
		try {
			waitFor(ExpectedConditions.visibilityOfElementLocated(locator), timeout);
		} 
		
		catch (StaleElementReferenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String getCurrentUrl()
	{
		return driver.getCurrentUrl();
	}

	protected boolean AlertSwitch()
	{
		
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent());
		
		try 
		{
			driver.switchTo().alert();
			return true;
		} 
		catch (NoAlertPresentException e) 
		{
			// TODO Auto-generated catch block
			return false;
		}
		
		
	}
	
	protected String getPageTitle()
	{
		return driver.getTitle();
		
	}
	
	protected String getPagesource()
	{
		return driver.getPageSource();
		
	}
	
	protected void WindowHandle(String expectedTitle)
	{
		String FirstWindow=driver.getWindowHandle();
		Set<String> AllWindows=driver.getWindowHandles();
		
		//Iterator<String> iteration = AllWindows.iterator();
		
		for (String iteration:AllWindows)
		
		{
			if(!(iteration.equals(FirstWindow)))
			{
				driver.switchTo().window(iteration);
				if(driver.getTitle().equals(expectedTitle))
				{
					break;
				}
			}
		}
		
		/*while(iteration.hasNext())
		{
			if(!((iteration.next().toString()).equals(FirstWindow)))
			{
				driver.switchTo().window(iteration.next());
				
				if(driver.getTitle().equals(expectedTitle))
				{
					System.out.println("correct");
					break;
				}
				
			}
		}*/
		
	}
	
	protected void switchToFrame(String Key) throws InterruptedException, IOException
	{
		driver.switchTo().frame(locateElement(Key));
		
	}
	
	protected void pressKey(Keys key) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		driver.findElement(By.xpath("//*")).sendKeys(key);
		//return key;
		
	}
	
	public String GetResultMessage() throws InterruptedException, IOException
	{
		log.info("Getting the Result Message");
		System.out.println(locateElement("result").getText());
		return (locateElement("result").getText());
		
		
	}

	
}
