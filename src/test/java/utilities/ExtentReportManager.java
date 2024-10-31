package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportManager implements ITestListener {

	ExtentSparkReporter sparkReporter;
	ExtentReports extent;
	ExtentTest test;
	String repname;
	public void onStart(ITestContext testContext)
	{
		String timestamp=new SimpleDateFormat("YYYY.MM.DD.HH.MM.SS").format(new Date());
		repname="Test-Report"+timestamp+".html";
		
		sparkReporter=new ExtentSparkReporter(".\\reports\\"+repname);
		sparkReporter.config().setDocumentTitle("Automation project");
		sparkReporter.config().setReportName("");
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application","OpenCart");
		extent.setSystemInfo("Environment", "QA");
		String os=testContext.getCurrentXmlTest().getParameter("OS");
		extent.setSystemInfo("Operating System", os);
		String browser=testContext.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser", browser);
		
		List<String> includedGroups=testContext.getCurrentXmlTest().getIncludedGroups();
		if(!includedGroups.isEmpty())
		{
			extent.setSystemInfo("Groups",includedGroups.toString());
		}
		
	}
	public void onTestSuccess(ITestResult result)
	{
		test=extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS,result.getName());
		test.log(Status.INFO,result.getThrowable().getMessage());
		
		
	}
	public void onTestFailure(ITestResult result)
	{
		test=extent.createTest(result.getTestClass().getName());	
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL,result.getName());
		test.log(Status.INFO,result.getThrowable().getMessage());
		try
		{
			String	imgpath=new BaseClass().captureScreen(result.getName());
			test.addScreenCaptureFromPath(imgpath);
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
		}
	}
	
	public void onTestSkipped(ITestResult result)
	{
		test=extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP,result.getName());
		test.log(Status.INFO,result.getThrowable().getMessage());
		
	}
	public void onFinish(ITestContext testcontext)
	{
		extent.flush();
	
		
		String pathOfExtentReport=System.getProperty("user.dir")+"\\reports\\"+repname;
		File extentReport=new File(pathOfExtentReport);
		try
		{
			Desktop.getDesktop().browse(extentReport.toURI());
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
}
