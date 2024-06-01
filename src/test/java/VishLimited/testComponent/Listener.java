package VishLimited.testComponent;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import VishLimited.resources.ExtentReporter;
import VishLimited.testComponent.*;


public class Listener extends BaseTest implements ITestListener {

	ExtentReports extent = ExtentReporter.getReportObject();
	ExtentTest test;
	static int count = 0;
	
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	
	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
		extent.flush();
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
		
		extentTest.get().log(Status.FAIL, "Test Failed");
		extentTest.get().fail(result.getThrowable());
		
//		String filePath = null;
//		try {
//			WebDriver driver = (WebDriver) result.getTestContext().getAttribute("driver");
//			WebDriver driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
//			filePath = getScreenShot(driver, result.getMethod().getMethodName());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		extentTest.get().fail(result.getThrowable());
//		extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
		
		
		String filePath = null;
		try {
			WebDriver driver = ((BaseTest)result.getInstance()).driver;
//			System.out.println(driver);
			filePath = getScreenShot(driver, result.getMethod().getMethodName()+count++);
		} catch (Exception e) {
			e.printStackTrace();
		}
		extentTest.get().fail(result.getThrowable());
		extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		
		System.out.println("In Success Class");
		System.out.println(result.getName());
		
		extentTest.get().log(Status.PASS, "Test Passed");
		
	}

}
//
//<listeners>
//<listener class-name="VishLimited.testComponent.Listener"></listener>
//</listeners>
