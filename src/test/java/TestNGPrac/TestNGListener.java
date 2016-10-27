/**
 * 
 */
package TestNGPrac;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

/**
 * @author Narendra_P02
 * @usage : TestNG Listener class that listens to test case flow and prints log4j info messages.
 *
 */
public class TestNGListener implements ITestListener  {

	static Logger log = Logger.getLogger(TestngAnnotation1.class.getName());

	public void onFinish(ITestContext result) {
		log.info("***FROM LISTNER : Inside : \"onFinish\" function of TestNGListener.java");
	}

	public void onStart(ITestContext result) {
		log.info("***FROM LISTNER : Inside \"onStart\" function of TestNGListner.java.");

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	//	log.info("Inside : "+result.getClass()+":"+result.getClass().getEnclosingMethod().getName());

	}

	public void onTestFailure(ITestResult result) {
		log.info("***FROM LISTNER : Inside \"onTestFailure\" function of TestNGListner.java.");
		System.out.println("getTestName="+result.getTestName());
		System.out.println("getInstanceName="+result.getInstanceName());
		System.out.println("getName="+result.getName());
		System.out.println("getStatus="+result.getStatus());
		System.out.println("getMethod="+result.getMethod());
		System.out.println("getTestClass="+result.getTestClass());
		System.out.println("isSuccess="+result.isSuccess());
		System.out.println("getThrowable="+result.getThrowable());
		//log.info("Inside : "+result.getClass().getName()+":"+result.getClass().getEnclosingMethod().getName());

	}

	public void onTestSkipped(ITestResult result) {
//		log.info("Inside : "+result.getClass()+":"+result.getClass().getEnclosingMethod().getName());

	}

	public void onTestStart(ITestResult result) {
		log.info("***FROM LISTNER : Inside \"onTestStart\" onFinish function of TestNGListener.java.");

	}

	public void onTestSuccess(ITestResult result) {
		log.info("***FROM LISTNER : Inside \"onTestSuccess\" function of TestNGListner.java.");
		System.out.println("getTestName="+result.getTestName());
		System.out.println("getInstanceName="+result.getInstanceName());
		System.out.println("getName="+result.getName());
		System.out.println("getStatus="+result.getStatus());
		System.out.println("getMethod="+result.getMethod());
		System.out.println("getTestClass="+result.getTestClass());
		System.out.println("isSuccess="+result.isSuccess());
		System.out.println("getThrowable="+result.getThrowable());

		//log.info("Inside : "+result.getClass()+":"+result.getClass().getEnclosingMethod().getName());

	}

}
