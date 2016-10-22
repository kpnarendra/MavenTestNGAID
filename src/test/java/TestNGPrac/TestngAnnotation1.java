/**
 * @author  : Narendra_P02
 * @Purpose : Learn and practice TestNG annotations.
 * @Run     : Run the file as a testng 
 *
 */
package TestNGPrac;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestngAnnotation1 {
	static Logger log = Logger.getLogger(TestngAnnotation1.class.getName());

	// new instance
	public static ExtentReports extent = new ExtentReports(
			System.getProperty("user.dir") + "\\extent-report\\extent_report"
					+ ".html", true);

	// starting test
	ExtentTest testRep = extent
			.startTest(
					"TestNG Test Report from" + this.getClass(),
					"Includes testing of MAVEN - build tool , TESTNG - testing framework , LOG4J - logging framework and "
							+ "EXTENT REPORTS - reporting framework.");

	// Pass test case where assertion stands pass.
	@Test
	public void testCasePass() {
		log.info("File 1 , Func:testCasePass");
		testRep.log(LogStatus.INFO, "Method : "
				+ this.getClass().getName(),"inside testCasePass");
		System.out.println("in testCasePass");
		Assert.assertEquals("String for Test", "String for Test");
		testRep.log(LogStatus.PASS, this.getClass().getName(),
				"The test case stands PASS");
		

	}

	// Fail test case where assertion stands fail.
	@Test
	public void testCaseFail() {
		log.info("File 1 , Func:testCaseFail");
		testRep.log(LogStatus.INFO, "inside testCaseFail");
		System.out.println("in test case 2");
		Assert.assertEquals("Check String", "Check  String"); // Line having
																// error in
																// assertion.
		System.out.println("This line will not be printed");

	}

	@BeforeMethod
	public void beforeMethod() {
		log.info("File 1 , Func:beforeMethod");
		System.out.println("in beforeMethod");
	}

	@AfterMethod
	public void afterMethod(ITestResult testStatus) {
		log.info("File 1 , Func:afterMethod");
		System.out.println("in afterMethod");
		if (testStatus.getStatus()==ITestResult.FAILURE) {
			testRep.log(LogStatus.FAIL, "Assersion failed Method : " + testStatus.getName()+" in class : " + this.getClass(),testStatus.getThrowable());
			log.error("Assersion failed in method : " + testStatus.getName() +" in class : "+ this.getClass());
		}

	}

	
	
	
	
	
	@BeforeClass
	public void beforeClass() {
		log.info("File 1 , Func:beforeClass");
		System.out.println("in beforeClass");
	}

	@AfterClass
	public void afterClass() {
		log.info("File 1 , Func:afterClass");
		System.out.println("in afterClass");
	}

	/*
	 * @BeforeTest public void beforeTest() {
	 * log.info("_info_start , Func:beforeTest");
	 * System.out.println("in beforeTest"); log.info("end , Func:beforeTest"); }
	 * 
	 * @AfterTest public void afterTest() {
	 * log.info("_info_start , Func:afterTest");
	 * System.out.println("in afterTest"); log.info("end , Func:afterTest"); }
	 */

	@BeforeSuite
	public void beforeSuite() {
		log.info("File 1 , Func:beforeSuite");
		System.out.println("in beforeSuite");
		extent.addSystemInfo("User name", System.getProperty("user.name"));
		extent.addSystemInfo("Operating System", System.getProperty("os.name")
				+ " V." + System.getProperty("os.version"));
		extent.addSystemInfo("Java Home", System.getProperty("java.home"));
		extent.addSystemInfo("Java Version", System.getProperty("java.version"));
	}

	@AfterSuite
	public void afterSuite() {
		log.info("File 1 , Func:afterSuite");
		System.out.println("in afterSuite");
		// ending test
		extent.endTest(testRep);
		
		
		
	}

}
