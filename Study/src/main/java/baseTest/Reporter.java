package baseTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.relevantcodes.extentreports.LogStatus;

public class Reporter  {
     
	
/*	@Override
	public void onTestStart(ITestResult result) {
		
		System.out.println(" Starting test: " + result.getName());
		//ExtentManager.startTest(TestName);
		extent.startTest(sTestCaseName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(" Test passed: " + result.getTestName());
		test.log(LogStatus.PASS, result.getName().toUpperCase()+"passed");
		extent.endTest(test);
		extent.flush();
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(" Test failed: " + result.getTestName());
	
		test.log(LogStatus.FAIL, result.getName().toUpperCase()+"failed");
		extent.endTest(test);
		extent.flush();
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println(" Test skipped: " + result.getTestName());
		test.log(LogStatus.SKIP, result.getName().toUpperCase()+"skipped");
		extent.endTest(test);
		extent.flush();
		
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("+Begin test: " + context.getCurrentXmlTest().getName());
		//ExtentManager.startTest(context.getCurrentXmlTest().getName());
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("-End test: " + context.getCurrentXmlTest().getName());
	//	ExtentManager.endTest();
		
	}*/
	
	
	
	
	

}
