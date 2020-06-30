package baseTest;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;

public class BaseClass  {
	
	public RemoteWebDriver driver;
	protected  Logger log;
	protected String sTestCaseName;
	String nodeUrl;
	//public ExtentReports extent=ReportUtility.getExtent();
//	public static ExtentTest test;
	//public String testName;
	@BeforeTest(alwaysRun = true)
	public void sys()
	{
		System.out.println("I am run");
		 
	}
	
	@BeforeClass(alwaysRun = true)
	public void A(ITestContext ctx)
	{
		sTestCaseName=ctx.getCurrentXmlTest().getName();
		System.out.println("Before Class "+sTestCaseName);
	}

	@Parameters({ "browser","node" })
	@BeforeMethod(alwaysRun = true)
	public void setUp(@Optional("chrome") String browser,String node,ITestContext ctx) {
		
		sTestCaseName=ctx.getCurrentXmlTest().getName();
		//System.out.println("TestName "+ sTestCaseName);
		
		log=LogManager.getLogger(sTestCaseName);
		BrowserDriverFactory factory = new BrowserDriverFactory(browser,log);
	//	driver=factory.CreateWebdriver(node);
	driver=factory.CreateWebdriver();
	//	return testName;
		
	}
	
	
	@DataProvider(name="testData")
	public Object[][] testdata(Method method) throws Exception
	{
		System.out.println("I am executed before");
		ExcelUtilities.setExcelFile("src/main/resources/data/testdata.xlsx", "Sheet1");
		//sTestCaseName=method.getName();
		System.out.println(sTestCaseName);
		System.out.println("TESTCASENAME " + sTestCaseName);
		//sTestCaseName=ExcelUtilities.getTestCaseName(this.toString());
		int itestcaserow=ExcelUtilities.rowContains(sTestCaseName, 0);
		System.out.println("testRow "+itestcaserow);
		Object [][] tabData=ExcelUtilities.exceldata("src/main/resources/data/testdata.xlsx", "Sheet1", itestcaserow);
		System.out.println(tabData);
		return tabData;
		
		
	}
	

	
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		log.info("Close driver");
		// Close browser
		driver.close();
		driver.quit();
	}

}
