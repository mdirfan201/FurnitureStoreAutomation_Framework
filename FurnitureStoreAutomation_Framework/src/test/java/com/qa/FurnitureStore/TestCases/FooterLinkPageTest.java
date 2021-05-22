package com.qa.FurnitureStore.TestCases;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
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
import com.qa.furniture.page.FooterLinkPage;
import com.qa.furniture.page.HomePage;

@Listeners(CustomeListner.class)
public class FooterLinkPageTest extends TestBase{
	
	static HomePage homepage;
	static FooterLinkPage footerlinkpage;
	static ExtentReports extent;
	static ExtentSparkReporter spark;
	static ExtentTest test;

	public FooterLinkPageTest() {
		super();
	}

	@BeforeSuite
	public void setupExtentReport() {
		extent = new ExtentReports();
		spark = new ExtentSparkReporter("D:\\IRFAN---\\java program\\FurnitureStoreAutomation_Framework\\ExtentReports\\FooterPageExtentRepo.html");
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Footer-Page Automation");
		spark.config().setReportName("Mohammed Irfan");
		extent.attachReporter(spark);
		//Setting Environment
		extent.setSystemInfo("Author","Mohammed Irfan");
		extent.setSystemInfo("Environment","QA");
		extent.setSystemInfo("System","Windows10");
		extent.setSystemInfo("Applicatoin","Eclipse");
		extent.setSystemInfo("Tools","Selenium With Java");

	}
	
	@AfterSuite
	public void teraDownExtentReport() {
		extent.flush();
	}
	
	@BeforeMethod
	public void setup() {

		initialization();
		footerlinkpage = new FooterLinkPage();
		homepage= new HomePage();
	}
	
	@Test(priority=1)
	public void validateLinkUnerFooterLinkTest() throws InterruptedException {
		test= extent.createTest("TC_ :Furniture-Store HomePage validate LinkUner Footer Link Test");
		footerlinkpage.scrollUpToInformation();
		footerlinkpage.AboutUSLink.click();
		test.pass("Validate AboutUs Page", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShots()).build());
		Thread.sleep(2000);
		
		footerlinkpage.scrollUpToInformation();
		footerlinkpage.Covid19Link.click();
		test.pass("Validate COVID-19 Page", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShots()).build());
		Thread.sleep(2000);
		
		footerlinkpage.scrollUpToInformation();
		footerlinkpage.DeliveryInfoLink.click();
		test.pass("Validate DeliveryInfoLink Page", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShots()).build());
		Thread.sleep(2000);
		
		footerlinkpage.scrollUpToInformation();
		footerlinkpage.DamagedGoodLink.click();
		test.pass("Validate Damaged-Good Pliocy LinkPage", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShots()).build());
		Thread.sleep(2000);
		
		footerlinkpage.scrollUpToInformation();
		footerlinkpage.ReturnRefundLink.click();
		test.pass("Validate Return & Refund Policy LinkPage", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShots()).build());
		Thread.sleep(2000);
		
		footerlinkpage.scrollUpToInformation();
		footerlinkpage.PrivacyPolicyLink.click();
		test.pass("Validate Privacy Pilicy Page", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShots()).build());
		Thread.sleep(2000);
		
		footerlinkpage.scrollUpToInformation();
		footerlinkpage.TermConditionLink.click();
		test.pass("Validate Term & Conditions Page", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShots()).build());
		Thread.sleep(2000);
		
		footerlinkpage.scrollUpToInformation();
		footerlinkpage.ContactUsFooterLink.click();
		test.pass("Validate ContactUs FooterLink Page", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShots()).build());
		Thread.sleep(2000);
		
		footerlinkpage.scrollUpToInformation();
		footerlinkpage.ReturnPoductLink.click();
		test.pass("Validate Return & Poduct Page", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShots()).build());
		Thread.sleep(2000);
		
		footerlinkpage.scrollUpToInformation();
		footerlinkpage.SiteMapLink.click();
		test.pass("Validate Site Map  Page", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShots()).build());
		Thread.sleep(2000);
		
		footerlinkpage.scrollUpToInformation();
		footerlinkpage.BrandsFooterLink.click();
		test.pass("Validate Under Extras Brands Page", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShots()).build());
		Thread.sleep(2000);
		
		homepage.homePageLogoBtn.click();
	
	}
	
	
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
			test.log(Status.FAIL, "TestCase Failed Method Name ==>" +result.getName());
			test.log(Status.FAIL, "TestCase Failed Error Msg"+result.getThrowable());
			test.log(Status.FAIL, "TestCase Failed", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShots()).build());
		}else if(result.getStatus()==ITestResult.SKIP) {
			test.log(Status.SKIP, "The Test Skiped Method-Name is==>"+result.getName());
			test.log(Status.SKIP, "The Error msg of Skiped Method is==> " +result.getThrowable());
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
