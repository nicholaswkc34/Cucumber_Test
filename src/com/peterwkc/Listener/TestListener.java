package com.peterwkc.Listener;

import java.io.IOException;
import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.peterwkc.Manager.ExtentManager;
import com.peterwkc.Manager.LogManager;
import com.peterwkc.Utils.CaptureScreenshot;

public class TestListener implements ITestListener {

	//Extent Report Declarations
    private ExtentReports extent = ExtentManager.createInstance();
    private ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    // =====================================================================================================================
	public TestListener() {
	}

	@Override
	public synchronized void onTestStart(ITestResult result) {
		String className = result.getMethod().getRealClass().getName();
		int lastIndex = className.lastIndexOf('.');
		String feature = className.substring(lastIndex + 1) + " : " + result.getMethod().getMethodName();
        ExtentTest extentTest = extent.createTest(feature, result.getMethod().getDescription());
        extentTest.assignCategory("Regression");
        test.set(extentTest);
	}

	@Override
	public synchronized void onTestSuccess(ITestResult result) {
	    test.get().pass("Test passed");
	}  

	@Override
	public synchronized void onTestFailure(ITestResult result) {
		test.get().fail("Exception: " + result.getThrowable());

		WebDriver driver = (WebDriver) result.getTestContext().getAttribute("driver");
		
        String feature = getClass().getName();
        String screenShot;
		try {
			screenShot = CaptureScreenshot.captureScreen(driver, CaptureScreenshot.generateFileName(feature));
			test.get().addScreenCaptureFromPath(screenShot);
			test.get().log(Status.FAIL, screenShot);
		} catch (IOException ex) {    
			LogManager.logger.log(Level.INFO, "Exception: " + ex.getMessage());
		}
        
		
		/*
		 *  System.out.println("Method " + getTestMethodName(testResult) + " failed");
        watch.reset();
        try {
            String path = TakeScreenshot.takeScreenshot(eDriver, testResult.getMethod().getMethodName());
            test.addScreenCaptureFromPath(path).fail("<b>"
                    + testResult.getMethod().getMethodName().replaceAll("(\\p{Ll})(\\p{Lu})", "$1 $2").toUpperCase()
                    + "</b>" + " failed <br>"+testResult.getThrowable());

        } catch (IOException e) {
            e.printStackTrace();
        }
		 */
		
	}

	@Override
	public synchronized void onTestSkipped(ITestResult result) {
		test.get().fail("Test skipped");
		test.get().skip("Exceptiopn: \n" + result.getThrowable());
	}

	@Override
	public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public synchronized void onStart(ITestContext context) {
	}

	@Override
	public synchronized void onFinish(ITestContext context) {
		extent.flush();
	}

}
