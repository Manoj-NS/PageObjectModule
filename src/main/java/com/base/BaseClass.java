package com.base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.utilities.ReadExcel;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static RemoteWebDriver driver;
	public String excelFileName;
	
	public static ExtentReports extent;
	public static ExtentTest test, node;
	public String testName, testDescription, testAurthor, testCategory;
	
	@BeforeSuite
	public void startReport() {
		
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./reports/result.html");		
		reporter.setAppendExisting(false);	 
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}
	
	@BeforeClass
	public void testcaseDetails() {
		test= extent.createTest(testName,testDescription);
		test.assignCategory(testCategory);
		test.assignAuthor(testAurthor);
	}
	
	public int takeSnap() throws IOException {
		
		// to get the random number for image
		int ranNum = (int) (Math.random()*9999999+10000000);
		
		File source = driver.getScreenshotAs(OutputType.FILE);
		File target = new File("./snaps/img"+ranNum+".jpg");
		FileUtils.copyFile(source, target);
		return ranNum;
	}
	
	// 2 inputs 1->stepDesc 2-> status of the test case (pass/fail)
	public void reportStep(String stepDesc, String status) throws IOException {
		
		if (status.equalsIgnoreCase("Pass")) {
			int ranNum = takeSnap();
			node.pass(stepDesc, MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/img"+ranNum+".jpg").build());
		
		} else if (status.equalsIgnoreCase("Fail")) {
			int ranNum2 = takeSnap();
			node.fail(stepDesc,MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/img"+ranNum2+".jpg").build());
//to stop when test case fails, normally it show message for failed part and run the remaining
			throw new RuntimeException("Please check the report for more details");

			
		}
		
	}
	
	
	@AfterSuite
	public void stopReport() {
		extent.flush();
	}
	
	@Parameters ({"browserName","URL"})
	@BeforeMethod
	
	public void BeforeMethod(String browserName, String url) throws InterruptedException {
		
		node = test.createNode(testName);
		
		if (browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			
		} else {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();

		}
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Thread.sleep(3000);
	}
	
	@AfterMethod
	public void AfterMethod() {
		
		driver.close();
		
	}
	

	@DataProvider //(indices=0)         //to rum the only one row(data) from the Excel (indices=0)
	public String[][] loginValidation() throws IOException{
		return ReadExcel.getData(excelFileName);
		
		
	}

}
	

