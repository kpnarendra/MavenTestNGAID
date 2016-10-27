/**
 * @author  : Narendra_P02
 * @Purpose : TestNG file has all the annotations - @BEFORESUITE @BEFORETEST @BEFORECLASS @BEFOREMETHOD @TEST 
 * 			:  @AFTERMETHOD @AFTERCLASS @AFTERTEST @AFTERSUITE
 * 			: Implements Extent reports and log4j
 * @Run     : Run the file as a testng 
 *
 */
package TestNGPrac;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

//@Listeners(TestNGPrac.TestNGListner.class)
public class TestngAnnotation3 {

	static Logger log = Logger.getLogger(TestngAnnotation3.class.getName());

	// starting test
	public ExtentTest testRep = TestngAnnotation1.extent
			.startTest(
					"TestNG Test Report from" + this.getClass(),
					"Includes testing of MAVEN - build tool , TESTNG - testing framework , LOG4J - logging framework and "
							+ "EXTENT REPORTS - reporting framework.");

	// test case 1
	@Test
	public void TestMethod1Class3() {
		log.info(" File 3, Func:"+this.getClass().getName());
		System.out.println("in TestMethod1Class3");
		Assert.assertEquals("String for Test", "String for Test");
		testRep.log(LogStatus.PASS, "Func:"+this.getClass().getName());

	}

	// test case 2
	@Test
	public void TestMethod2Class3() {
		log.info("File 3, Func:" + this.getClass().getName());
		System.out.println("in TestMethod1Class3");
		Assert.assertEquals("String for Test", "String for Test");
		testRep.log(LogStatus.PASS, "Func:"+this.getClass().getName());
	}

	@BeforeMethod
	public void beforeMethod() {
		log.info("File 3, Func:beforeMethod");
		System.out.println("in beforeMethod");
	}

	@AfterMethod
	public void afterMethod(ITestResult testStatus) {
		log.info("File 3 , Func:afterMethod");
		System.out.println("in afterMethod");
		if(testStatus.getStatus()==ITestResult.FAILURE){
			testRep.log(LogStatus.FAIL, "Assersion failed method : " + testStatus.getName() + " in class : " + this.getClass(), testStatus.getThrowable());
			log.error("Assersion failed in method : " + testStatus.getName() + " in class : " + this.getClass());
		}
		
		
	}
	
	
	

	@BeforeClass
	public void beforeClass() {
		log.info("File 3, Func:beforeClass");
		System.out.println("in beforeClass");
	}

	@AfterClass
	public void afterClass() {
		log.info("File 3, Func:afterClass");
		System.out.println("in afterClass");
	}

	@BeforeTest
	public void beforeTest() {
		log.info("File 3, Func:beforeTest");
		System.out.println("in beforeTest");
	}

	@AfterTest
	public void afterTest() {
		log.info("File 3, Func:afterTest");
		System.out.println("in afterTest");
	}

	@BeforeSuite
	public void beforeSuite() {
		log.info("File 3 , Func:beforeSuite");
	}
	
	@AfterSuite
	public void afterSuite() {
		log.info("File 3 , Func:afterSuite");
		TestngAnnotation1.extent.endTest(testRep);
		// writing everything to document
		TestngAnnotation1.extent.flush();
	
		TestngAnnotation1.extent.close();
		
		System.out.println("------------------------- END OF TEST -------------------------");

	}
}
