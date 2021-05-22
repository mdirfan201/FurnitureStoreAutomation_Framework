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
import com.qa.furniture.page.HomePage;
import com.qa.furniture.page.LoginPage;

public class LoginPageTest extends TestBase{
	static HomePage homepage;
	static LoginPage loginpage;

	static ExtentReports extent;
	static ExtentSparkReporter spark;
	static ExtentTest test;

	public LoginPageTest() {
		super();
	}


	@BeforeSuite
	public void setupExtentReport() {
		extent= new ExtentReports();
		spark= new ExtentSparkReporter("D:\\IRFAN---\\java program\\FurnitureStoreAutomation_Framework\\ExtentReports\\Furniture-LoginPage.html");
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
		loginpage = new LoginPage();
	}

	@Test(priority=1)
	public void ValidateLoginPageTitleTest() {

		test=extent.createTest("TC_01 :Furniture-Store LoginPage Page Title Test ");
		String expectedTitle="Account Login";
		String actuTitle= loginpage.validateTitle();
		Assert.assertEquals(actuTitle, expectedTitle,"Title notMatched");
		test.info("The Expected and Actual Tile are same==>" + driver.getTitle());
	}

	@Test(priority=2)
	public void validateLoginPageLableTitle() {
		test= extent.createTest("TC_02: Furniture-Store validate LoginPage Lable Title Test");
		boolean flag=loginpage.validateLoginPageLable();
		Assert.assertTrue(flag);
	}

	@Test(priority=3)
	public void ClickContinueBtnLoginPageTest() throws InterruptedException {
		test=extent.createTest("TC_03:urniture-Store Click ContinueBtn LoginPage Test ");
		loginpage.clickContinueBtn();

		Thread.sleep(2000);
		test.info("RegisterPage SS", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShots()).build());
		driver.navigate().back();
	}
	@Test(priority=4)
	public void ClickForgotPasswordBtnLoginPageTest() throws InterruptedException {
		test=extent.createTest("TC_03:urniture-Store Click ForgotPasswordBtn LoginPage Test ");
		loginpage.clickForgotPassword();

		Thread.sleep(2000);
		test.info("ForgotPasswordBtn SS", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShots()).build());
		driver.navigate().back();
	}

	@Test(priority=5)
	public void LogingWithEmptyDataPageTest() {
		test= extent.createTest("TC_05: Furniture-Store Loging With Empty Data Page Test");
		loginpage.loginWithEmptyData();
		test.info("The wrning msg is ====>" + driver.findElement(By.xpath("//div[@class='warning']")).getText());
	}

	@Test(priority=6)
	public void LogingWithInvalidDataPageTest() {
		test= extent.createTest("TC_06: Furniture-Store Loging With InValid Data Page Test");
		loginpage.loginWithIvalidData("irfam@gmail.com", "123456");
		test.info("The wrning msg is ====>" + driver.findElement(By.xpath("//div[@class='warning']")).getText());
	}

	@Test(priority=7)
	public void LogingWithValidDataPageTest() {
		test= extent.createTest("TC_07: Furniture-Store Loging With InValid Data Page  Test");
		loginpage.loginWithvalidData("irfanullah.a@ergode.com", "ergode123");
		test.info("The wrning msg is ====>" + driver.findElement(By.xpath("//div[@class='warning']")).getText());
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
