package com.qa.FurnitureStore.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.qa.base.TestBase;
import com.qa.furniture.page.ForgotPasswordPage;
import com.qa.furniture.page.HomePage;
import com.qa.furniture.page.LoginPage;

public class ForgotPageTest extends TestBase{
	
	static HomePage homepage;
	static LoginPage loginpage;
	static ForgotPasswordPage forgotpasspage;
	static ExtentReports extent;
	static ExtentSparkReporter spark;
	static ExtentTest test;
	
	public ForgotPageTest() {
		super();
	}
	
	@BeforeSuite
	public void setupExtentReport() {
		extent= new ExtentReports();
		spark= new ExtentSparkReporter("D:\\IRFAN---\\java program\\FurnitureStoreAutomation_Framework\\ExtentReports\\Furniture-ForgotPage.html");
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Furniture-Stores Automation");
		spark.config().setReportName("Mohammed Irfan Ansari");
		extent.attachReporter(spark);

		//Setting Environment
		extent.setSystemInfo("Author","Mohammed Irfan");
		extent.setSystemInfo("Environment","QA");
		extent.setSystemInfo("System","Windows10");
		extent.setSystemInfo("Applicatoin","Eclipse");
		extent.setSystemInfo("Tools","Selenium With Java");
	}

	@AfterSuite
	public void tearExtentReport() {
		extent.flush();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		homepage = new HomePage();
		homepage.loginBtn.click();
		loginpage= new LoginPage();
		loginpage.clickForgotPass.click();
		forgotpasspage =new ForgotPasswordPage();
		
	}

	
	@Test(priority=1)
	public void ValidateFogotPageTitleTest() {
		test=extent.createTest("TC_01 :Furniture-Store Forgot Page Title Test ");
		String expectedTitle="Forgot Your Password?";
		String actualTitle=forgotpasspage.validateTitle();
		Assert.assertEquals(actualTitle, expectedTitle,"Title NotMatched");
		test.info("The Expected and Actual Title matched==>"+driver.getTitle());
		
	}
		
		@Test(priority=2)
		public void validateForgotPageLabeTest() {
			test=extent.createTest("TC_02 :Furniture-Store Forgot Page Lable Test ");
			boolean flag=forgotpasspage.validateForgotLabe();
			Assert.assertTrue(flag);
			test.info("Furniture-Store HomePage Image isDisplayed");
		}
	
	@Test(priority=3)
	public void ClickForgotPageBackBtnLinkTest() throws InterruptedException {
		test=extent.createTest("TC_03 :Furniture-Store Click ForgotPage BackBtn LinkTest ");
		forgotpasspage.validateBackBtn();
		
	}
	
	@Test(priority=4)
	public void ForgotPageEmailEmptyTest() {
		test=extent.createTest("TC_04 :Furniture-Store ForgotPage Email Empty Test ");
		forgotpasspage.clickEmptyEmail();
		test.info("The warning msg is==>"+ driver.findElement(By.xpath("//div[@class='warning']")).getText());
	}
	@Test(priority=5)
	public void ForgotPageWrongEmailTest() {
		test=extent.createTest("TC_05 :Furniture-Store ForgotPage WrongEmail Test ");
		forgotpasspage.wrongEmail(prop.getProperty("WEmail"));
		test.info("The warning msg is==>"+ driver.findElement(By.xpath("//div[@class='warning']")).getText());
	}
	
	@Test(priority=6)
	public void ForgotPageCorrectEmailTest() {
		test=extent.createTest("TC_06 :Furniture-Store ForgotPage Correct Email Test ");
		forgotpasspage.validEmail(prop.getProperty("CEmail"));
		
	}
	
	@AfterMethod
	public void teraDown(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test Case Failed Method Name===>"+ result.getName());
			test.log(Status.FAIL, "The Error msg during failed testcase==>"+ result.getThrowable());
			test.log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShots()).build());
		}else if(result.getStatus()==ITestResult.SKIP) {
			test.log(Status.SKIP, "Test Case Skiped Method Name===>"+ result.getName());
			test.log(Status.SKIP, "The Error msg during failed testcase==>"+ result.getThrowable());	
		}else if(result.getStatus()==ITestResult.SUCCESS) {
			test.log(Status.PASS, "Test Case Passed Method Name===>"+ result.getName());
			test.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShots()).build());	
		}

		driver.close();
	}
	
	public static String getBase64ScreenShots() {

		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
	}
}
