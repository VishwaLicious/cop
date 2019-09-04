package in.licious.util;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.PropertyConfigurator;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class CustomListeners implements ITestListener{

	private static File dir;
	//private static Logger log = Logger.getLogger(testListener.class.getName());

	public static ExtentReports Extent;
	public static ExtentTest ExtentTest;

	 public static String getDate() {
	        DateFormat dateFormat = new SimpleDateFormat("YYYY_MM_dd_HH_mm_");
	        Date date = new Date();
	        return dateFormat.format(date);
	    }

	    public static File getDateFolder() {
	        DateFormat dateFromat = new SimpleDateFormat("YYYY_MM_dd");
	        Date date = new Date();
	        String dateString = dateFromat.format(date);
	        dir = new File("/ExtentReports/" + dateString);
	        if (!dir.exists())
	            dir.mkdir();
	        return dir;
	    }
	
	public void onFinish(ITestContext result) {
		
	}

	public void onStart(ITestContext result) {
		PropertyConfigurator.configure(System.getProperty("user.dir") +"/src/test/java/log4j.properties");
		
		String createfolder = getDateFolder() + "/" + "LiciousWebAutomationReport" + getDate() ;
		
		
		
		Extent = new ExtentReports(System.getProperty("user.dir") + createfolder+".html", false);
		Extent.assignProject("Licious Web Automation Testing");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		Extent.flush();
		Extent.close();
		
	}

	public void onTestFailure(ITestResult result) {
		//String Filepath= ScreenShot.TakescreenShots(result,driver);
		ExtentTest = Extent.startTest(result.getName());
		ExtentTest.log(LogStatus.FAIL, " Test Case Fail" );
		ExtentTest.log(LogStatus.FAIL, result.getThrowable() );
		ExtentTest.log(LogStatus.FAIL, ExtentTest.addScreenCapture(Helper.takeScreenShot(result.getName())));
		Extent.endTest(ExtentTest);
		Extent.flush();
	}

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestStart(ITestResult result) {
		
		
	}

	public void onTestSuccess(ITestResult result) {
		ExtentTest = Extent.startTest(result.getName());
		ExtentTest.log(LogStatus.PASS, " Test Case Pass" );
		Extent.endTest(ExtentTest);
		Extent.flush();
		
	}

}
