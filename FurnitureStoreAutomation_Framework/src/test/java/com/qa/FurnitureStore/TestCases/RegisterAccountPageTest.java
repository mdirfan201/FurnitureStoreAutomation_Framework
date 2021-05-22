package com.qa.FurnitureStore.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.qa.CustomeListener.CustomeListner;
import com.qa.base.TestBase;
import com.qa.furniture.page.HomePage;
import com.qa.furniture.page.RegisterAccountPage;
import com.qa.util.JavaScriptUtil;
import com.qa.util.TestUtil;


@Listeners(CustomeListner.class)
public class RegisterAccountPageTest extends TestBase{

	static HomePage homepage;
	static RegisterAccountPage registerpage;
	static ExtentReports extent;
	static ExtentSparkReporter spark;
	static ExtentTest test;
	String sheetName="Register";
	public RegisterAccountPageTest() {
		super();
	}

	@BeforeSuite
	public void setupExtentReport() {
		extent= new ExtentReports();
		spark= new ExtentSparkReporter("D:\\IRFAN---\\java program\\FurnitureStoreAutomation_Framework\\ExtentReports\\RegisterPage.html");
		spark.config().setDocumentTitle("FurnitureStore-Automation");
		spark.config().setTheme(Theme.DARK);
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
	public void setup() throws InterruptedException {
		initialization();
		homepage= new HomePage();
		homepage.ClickonCreateAccountLink();
		registerpage = new RegisterAccountPage();
	}
	
	@Test(priority=1)
	public void validateRegisterPageTitleTest() {
		test=extent.createTest("TC_01: Furniture-Store RegisterPage Title Test ");
		String expecteTitle="Register Account";
		String actualTitle=registerpage.validateTitle();
		test.info("The Actual and Expected title are same==>" +driver.getTitle());
		Assert.assertEquals(actualTitle, expecteTitle,"Title not matched");
	}
	@Test(priority=2)
	public void validateRegisterPageLable() {
			test=extent.createTest("TC_02: Furniture-Store RegisterPage Lable Test ");
			boolean flag=registerpage.ValidatePageLable();
			Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void validateRegisrterPageLoginPageBtnTest() throws InterruptedException {
		test=extent.createTest("TC_03: Furniture-Store validate RegisrterPage LoginPage Btn Test ");
		registerpage.clickLoginpageBtn();	
	}
	
	@Test(priority=4)
	public void EnterContinueBtnWithoutAnyDataTest() throws InterruptedException {
		test=extent.createTest("TC_04: Furniture-Store Enter ContinueBtn Without AnyData Test ");
		registerpage.clickContinueWithEmpty();
		Thread.sleep(1000);
		WebElement element=driver.findElement(By.xpath("//h2[normalize-space()='Your Personal Details']"));
		JavaScriptUtil.scrolluptoanelementByJS(element, driver);
		test.info("Your Personal Details SS", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShots()).build());
		
		WebElement element1=driver.findElement(By.xpath("//h2[normalize-space()='Your Address']"));
		JavaScriptUtil.scrolluptoanelementByJS(element1, driver);
		test.info("Your Address SS", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShots()).build());
		WebElement element2=driver.findElement(By.xpath("//h2[normalize-space()='Your Password']"));
		JavaScriptUtil.scrolluptoanelementByJS(element2, driver);
	}
	
	@DataProvider
	public Object[][] getFurnitureTestDate() {
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=5, dataProvider="getFurnitureTestDate")
	public void setRegisterValidData(String FirstName,String LastName,String Email,String Telephone,String Address,String City,String PostCode,String Country,String Region,String Password, String ConfirmPassword) throws InterruptedException {
		//String Address, String City, String PostCode, String Country, String Region, String Password, String ConfirmPassword
		test=extent.createTest("TC_05: Furniture-Store Enter setRegisterValidData Test ");
		registerpage.setRegisterData(FirstName, LastName, Email, Telephone, Address, City, PostCode, Country,Region,Password,ConfirmPassword);
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
	

