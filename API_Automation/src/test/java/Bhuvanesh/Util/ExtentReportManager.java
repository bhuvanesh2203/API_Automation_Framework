package Bhuvanesh.Util;

import org.apache.logging.log4j.util.Strings;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.ExtentTest;

import java.text.*;
import java.util.Date;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {
	
	public ExtentSparkReporter sparkReporter;

	public ExtentReports extent;

	public ExtentTest test;

	String repName;
	Date date=new Date();

	public void onStart(ITestContext testContext) {

	String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(date);//time stamp repName"Test Report "+timeStamp+".html";
	repName="Test Report "+timeStamp+".html";

	sparkReporter=new ExtentSparkReporter(".\\Reports\\"+repName);//specify location of the report 
	sparkReporter.config().setDocumentTitle("RestAssuredAutomationProject"); // Title of report 
	sparkReporter.config().setReportName("Pet Store Users API"); // name of the report 
	sparkReporter.config().setTheme (Theme.DARK);

	extent=new ExtentReports();

	extent.attachReporter ( sparkReporter);

	extent.setSystemInfo("Application", "Pest Store Users API");

	extent.setSystemInfo("Operating System", System.getProperty("os.name"));

	extent.setSystemInfo("User Name", System.getProperty("user.name")); 
	extent.setSystemInfo("Environemnt","QA");

	extent.setSystemInfo("user", "Bhuvanesh");
}
	public void onTestSuccess(ITestResult result)

	{

	test=extent.createTest(result.getName());


	test.assignCategory(result.getMethod().getGroups());

	test.createNode(result.getName()); test.log(Status.PASS, "Test Passed");

	}

	public void onTestFailure (ITestResult result)

	{

	test=extent.createTest(result.getName());


	test.assignCategory(result.getMethod().getGroups());

	test.log(Status. FAIL, "Test Failed");

	}
	
	public void onFinish(ITestContext result) {
		extent.flush();
	}
}

