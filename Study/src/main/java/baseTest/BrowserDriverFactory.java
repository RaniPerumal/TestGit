package baseTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserDriverFactory {
	
	private ThreadLocal<RemoteWebDriver> driver=new ThreadLocal<RemoteWebDriver>();
	private String browser;
	private  Logger log;
	//String nodeUrl;
//	 DesiredCapabilities capability;
	// ChromeOptions options;
	
	
	
	
	public BrowserDriverFactory(String browser,Logger log)
	{
		this.browser=browser.toLowerCase();
		this.log=log;
	}
	
//public RemoteWebDriver CreateWebdriver(String node)
	public RemoteWebDriver CreateWebdriver()
	{
	
		log.info("Create driver: " + browser);
	//nodeUrl=node;

		switch (browser) {
		case "chrome":
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			driver.set(new ChromeDriver());
		/*	 options = new ChromeOptions();
			try {
				driver.set(new RemoteWebDriver(new URL(nodeUrl),options));
				//driver.set(new ChromeDriver());
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			break;

		case "firefox":
		System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
		driver.set(new FirefoxDriver());
		/* capability=DesiredCapabilities.firefox();
				try {
					driver.set(new RemoteWebDriver(new URL(nodeUrl),capability));
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
			break;

		default:
			System.out.println("Do not know how to start: " + browser + ", starting chrome.");
	System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver.set(new ChromeDriver());
		/*	 options = new ChromeOptions();
				try {
					driver.set(new RemoteWebDriver(new URL(nodeUrl),options));
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
			break;
		}
		
		return driver.get();
		
	}
	
	
}
