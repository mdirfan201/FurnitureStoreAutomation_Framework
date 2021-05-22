package com.qa.FurnitureStore.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import com.qa.furniture.page.ContactUsPage;
import com.qa.furniture.page.HomePage;
import com.qa.util.TestUtil;

@Listeners(CustomeListner.class)
public class ContactUsPageTest extends TestBase{
	
	static HomePage homepage;
	static ContactUsPage contactuspage;
	static ExtentReports extent;
	static ExtentSparkReporter spark;
	static ExtentTest test;
	String sheetName="ContausUs";
	
	@BeforeSuite
	public void setupExtentReport() {
		extent= new ExtentReports();
		spark= new ExtentSparkReporter("D:\\IRFAN---\\java program\\FurnitureStoreAutomation_Framework\\ExtentReports\\ContactUsPage.html");
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
		homepage.contactusBtn.click();
		contactuspage = new ContactUsPage();
	}
	@Test(priority=1)
	public void validateContactUsPageTitleTest() {
		test=extent.createTest("TC_01: Furniture-Store ContactUsPage Title Test ");
		String expecteTitle="Contact Us";
		String actualTitle=contactuspage.validateTitle();
		test.info("The Actual and Expected title are same==>" +driver.getTitle());
		Assert.assertEquals(actualTitle, expecteTitle,"Title not matched");
	}
	
	@Test(priority=2)
	public void verfiyContactUspageLableTest() {
		test=extent.createTest("TC_02: Furniture-Store ContactUsPage Lable Test ");	
		boolean flag=contactuspage.validateLable();
		Assert.assertTrue(flag);
		
	}
	@Test(priority=3)
	public void validategetAddressTextTest() {
		test=extent.createTest("TC_03: Furniture-Store ContactUsPage Adress Test ");
		String address=contactuspage.getAddressText();
		test.info("The Actual Address is==>" + driver.findElement(By.xpath("//div[@class='left']")).getText());
	}
	
	@Test(priority=4)
	public void enterSubmitBtnWithEmptyDataTest() throws InterruptedException {
		test=extent.createTest("TC_04: Furniture-Store ContactUsPage enter SubmitBtn With Empty Data Test ");
		contactuspage.setEmptyData();
		contactuspage.scrollupto();
		
	}
	
		@DataProvider
		public Object[][] getContactUsData() {
			Object data[][]=TestUtil.getTestData(sheetName);
			return data;
		}
		@Test(priority=5, dataProvider="getContactUsData")
		public void enterSubmitBtnWithValidDataTest(String CName, String CEmail, String CEnquiry) throws InterruptedException {
			test=extent.createTest("TC_05: Furniture-Store ContactUSPage Enter Valid Data Test");
			contactuspage.setContactusData(CName, CEmail, CEnquiry);
			contactuspage.scrollupto();
		}

	@AfterMethod
	public void tearDown(ITestResult result) {
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
	
	public String getBase64ScreenShots() {
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);	
	}
}
