package com.selenium.hybrid.genericrepo;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	String repName;
	ScreenShotHandler ss;

	public void onStart(ITestContext testContext) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp
		repName = "Test-Report-" + timeStamp + ".html";
		sparkReporter = new ExtentSparkReporter(".\\reports\\" + repName);// specify location of the report
		sparkReporter.config().setDocumentTitle("AutomationProject"); // Title of report
		sparkReporter.config().setReportName("Functional Testing"); // name of the report
		sparkReporter.config().setTheme(Theme.STANDARD);

		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "Trescnties Demo Tosca");
		extent.setSystemInfo("Operating System", System.getProperty("os.name"));
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		extent.setSystemInfo("Environemnt", "QA");
		extent.setSystemInfo("user", "ganesh");
	}

	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.createNode(result.getName());
		test.log(Status.PASS, "Test Passed");
		
	}

	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName());
		test.createNode(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL, "Test Failed");
		test.log(Status.FAIL, result.getThrowable().getMessage());
		try {
		    ss = new ScreenShotHandler();
			String screenshotPath = ss.takeScreenshot(result.getName());
			test.addScreenCaptureFromPath(screenshotPath); // attaching screenshot to report
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getName());
		test.createNode(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, "Test Skipped");
		test.log(Status.SKIP, result.getThrowable().getMessage());
		
	}

	public void onFinish(ITestContext testContext) {
		
		extent.flush();

//		String pathOfExtentReport = System.getProperty("user.dir")+"\\reports\\"+repName;
//		File extentReport = new File(pathOfExtentReport);
//
//		try {
//		    Desktop.getDesktop().browse(extentReport.toURI());
//		} catch (IOException e) {
//		    e.printStackTrace();
//		}

		/*
		try {
		    URL url = new URL("file:///"+System.getProperty("user.dir")+"\\reports\\"+repName);

		    // Create the email message
		    ImageHtmlEmail email = new ImageHtmlEmail();
		    email.setDataSourceResolver(new DataSourceUrlResolver(url));
		    email.setHostName("smtp.googlemail.com");
		    email.setSmtpPort(465);
		    email.setAuthenticator(new DefaultAuthenticator("pavanoltraining@gmail.com", "password"));
		    email.setSSLOnConnect(true);
		    email.setFrom("pavanoltraining@gmail.com");
		    email.setSubject("Test Results");
		    email.setMsg("Please find Attached Report...");
		    email.addTo("pavamkumar.busyqa@gmail.com"); // Receiver email
		    email.attach(url, "extent report", "please check report...");
		    email.send(); // send the email
		} catch (Exception e) {
		    e.printStackTrace();
		}
		*/

		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
