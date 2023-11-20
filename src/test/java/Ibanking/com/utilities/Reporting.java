package Ibanking.com.utilities;
//listener class used to generate extent report
import org.testng.TestListenerAdapter;

	import com.aventstack.extentreports.ExtentReports;
	import com.aventstack.extentreports.ExtentTest;
	import com.aventstack.extentreports.Status;
	import org.testng.ITestResult;
	import org.apache.log4j.Logger;
	import org.apache.log4j.PropertyConfigurator;

	public class Reporting extends TestListenerAdapter {

	    private ExtentReports extent;
	    private ExtentTest test;
	    private Logger logger;

	    public Reporting() {
	        extent = new ExtentReports();
	        logger = Logger.getLogger(getClass().getName());
	        PropertyConfigurator.configure("log4j.properties"); // Configure Log4j
	    }

	    @Override
	    public void onTestStart(ITestResult result) {
	        test = extent.createTest(result.getName());
	        logger.info("Test Started: " + result.getName());
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        test.log(Status.PASS, "Test Passed");
	        logger.info("Test Passed: " + result.getName());
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	        test.log(Status.FAIL, "Test Failed");
	        logger.error("Test Failed: " + result.getName());
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	        test.log(Status.SKIP, "Test Skipped");
	        logger.warn("Test Skipped: " + result.getName());
	    }
	}
	
	


