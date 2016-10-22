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
 * @usage result is TestNG Listener class that listens to test case flow and
 *
 */
public class TestNGListner implements ITestNGListener  {

	static Logger log = Logger.getLogger(TestngAnnotation1.class.getName());

	public void onFinish(ITestContext result) {
		log.info("Inside : "+result.getClass()+":"+result.getClass().getEnclosingMethod().getName());

	}

	public void onStart(ITestContext result) {
		log.info("Inside : "+result.getClass()+":"+result.getClass().getEnclosingMethod().getName());

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		log.info("Inside : "+result.getClass()+":"+result.getClass().getEnclosingMethod().getName());

	}

	public void onTestFailure(ITestResult result) {
		log.info("Inside : "+result.getClass()+":"+result.getClass().getEnclosingMethod().getName());

	}

	public void onTestSkipped(ITestResult result) {
		log.info("Inside : "+result.getClass()+":"+result.getClass().getEnclosingMethod().getName());

	}

	public void onTestStart(ITestResult result) {
		log.info("Inside : "+result.getClass()+":"+result.getClass().getEnclosingMethod().getName());

	}

	public void onTestSuccess(ITestResult result) {
		log.info("Inside : "+result.getClass()+":"+result.getClass().getEnclosingMethod().getName());

	}

}
