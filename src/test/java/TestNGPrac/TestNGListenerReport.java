/**
 * 
 */
package TestNGPrac;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * @author Narendra_P02
 * @usage : TestNG Listener class that listens to test case flow and prints
 *        log4j info messages.
 *
 */
public class TestNGListenerReport implements ITestListener {

	static Logger log = Logger.getLogger(TestNGListenerReport.class.getName());

	ExtentReports extentRep = new ExtentReports(System.getProperty("user.dir")
			+ "\\extent-report\\extent_report_listner" + ".html", true);

	ExtentTest testRep;

	public void onFinish(ITestContext result) {
		log.info("***FROM LISTNER REPORT: Inside : \"onFinish\" function of TestNGListnerReport.java");
		// writing everything to document
		extentRep.flush();

		extentRep.close();
		
		System.out.println("------------------------- END OF TEST from Listner-------------------------");

	}

	public void onStart(ITestContext result) {
		log.info("***FROM LISTNER REPORT: Inside \"onStart\" function of TestNGListnerReport.java.");
		

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// log.info("Inside : "+result.getClass()+":"+result.getClass().getEnclosingMethod().getName());

	}

	public void onTestFailure(ITestResult result) {
		log.info("***FROM LISTNER REPORT: Inside \"onTestFailure\" function of TestNGListnerReport.java.");
		System.out.println("getTestName=" + result.getTestName());
		System.out.println("getInstanceName=" + result.getInstanceName());
		System.out.println("getName=" + result.getName());
		System.out.println("getStatus=" + result.getStatus());
		System.out.println("getMethod=" + result.getMethod());
		System.out.println("getTestClass=" + result.getTestClass());
		System.out.println("isSuccess=" + result.isSuccess());
		System.out.println("getThrowable=" + result.getThrowable());
		String MethodName = "Method Name : " + result.getMethod();
		Throwable excption = result.getThrowable();
		testRep.log(LogStatus.FAIL, MethodName, excption);
		// log.info("Inside : "+result.getClass().getName()+":"+result.getClass().getEnclosingMethod().getName());
		// ending test
		
		testRep.log(LogStatus.INFO, "TEST EXECUTION ENDED");
				extentRep.endTest(testRep);
				
	}

	public void onTestSkipped(ITestResult result) {
		// log.info("Inside : "+result.getClass()+":"+result.getClass().getEnclosingMethod().getName());

	}

	public void onTestStart(ITestResult result) {
		log.info("***FROM LISTNER REPORT: Inside \"onTestStart\" onFinish function of TestNGListnerReport.java.");

		testRep = extentRep
				.startTest(
						"TestNG Test Report for test case : " + result.getName(),
						"Includes testing of MAVEN - build tool , TESTNG - testing framework , LOG4J - logging framework and "
								+ "EXTENT REPORTS - reporting framework.");
		testRep.log(LogStatus.INFO, "TEST EXECUTION STARTED");
	}

	public void onTestSuccess(ITestResult result) {
		log.info("***FROM LISTNER REPORT: Inside \"onTestSuccess\" function of TestNGListnerReport.java.");
		System.out.println("getTestName=" + result.getTestName());
		System.out.println("getInstanceName=" + result.getInstanceName());
		System.out.println("getName=" + result.getName());
		System.out.println("getStatus=" + result.getStatus());
		System.out.println("getMethod=" + result.getMethod());
		System.out.println("getTestClass=" + result.getTestClass());
		System.out.println("isSuccess=" + result.isSuccess());
		System.out.println("getThrowable=" + result.getThrowable());
		String MethodName = "Method Name : " + result.getMethod();
		String excption = "NO ERRORS ! THE TEST CASE IS A PASS ";
		testRep.log(LogStatus.PASS, MethodName, excption);
		// ending test
		testRep.log(LogStatus.INFO, "TEST EXECUTION ENDED");
				extentRep.endTest(testRep);
				
		// log.info("Inside : "+result.getClass()+":"+result.getClass().getEnclosingMethod().getName());

	}

}
