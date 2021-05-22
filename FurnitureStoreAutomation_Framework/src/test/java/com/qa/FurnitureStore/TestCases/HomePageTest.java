package com.qa.FurnitureStore.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
import com.qa.util.JavaScriptUtil;

public class HomePageTest extends TestBase{

	static HomePage homepage;
	static ExtentReports extent;
	static ExtentSparkReporter spark;
	static ExtentTest test;

	public HomePageTest() {
		super();
	}

	@BeforeSuite
	public void setupExtentReport() {
		extent= new ExtentReports();
		spark= new ExtentSparkReporter("D:\\IRFAN---\\java program\\FurnitureStoreAutomation_Framework\\ExtentReports\\Furniture-HomePage.html");
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
	}

	@Test(priority=1)
	public void ValidateHomePageTitleTest() {
		test=extent.createTest("TC_01 :Furniture-Store HomePage Title Test ");
		String expectedTitle="Buy Bedroom Furniture, Dining Room Furniture, Kids Furniture, Living Room Furniture, Office Furniture, Pet Furniture - selectfurniturestore.com";
		String actualTitle=homepage.validateTitle();
		Assert.assertEquals(actualTitle, expectedTitle," Title Not Matched");
		test.info("The Expected and Actual Title matched==>"+driver.getTitle());
	}
	@Test(priority=2)
	public void ValidateHomePageImageTest() {
		test=extent.createTest("TC_02 :Furniture-Store HomePage Image Test ");
		boolean flag=homepage.validateLogo();
		Assert.assertTrue(flag);
		test.info("Furniture-Store HomePage Image isDisplayed");
	}
	
	@Test(priority=3)
	public void ClickMyMenuHomePageTest() throws InterruptedException {
		test=extent.createTest("TC_03 :Furniture-Store HomePage My Menue Test ");
		homepage.MyMenuLink();

	}

	@Test(priority=4)
	public void ClickHomePageLoginBtnTest() throws InterruptedException {
		test=extent.createTest("TC_04 :Furniture-Store HomePage Click-LoginBtn Test ");
		homepage.ClickonLoginPageLink();
	}

	@Test(priority=5)
	public void ClickHomePageCreateAccountBtnTest() throws InterruptedException {
		test=extent.createTest("TC_05 :Furniture-Store HomePage Click-Create AccounBtn Test ");
		homepage.ClickonCreateAccountLink();
	}

	@Test(priority=6)
	public void ClickHomePageContactUsBtnTest() throws InterruptedException {
		test=extent.createTest("TC_06 :Furniture-Store HomePage Click-ContactUsBtn Test ");
		homepage.ContactUsLink();
	}

	@Test(priority=7)
	public void ClickHomePageSearchBoxTest() throws InterruptedException {
		test=extent.createTest("TC_07 :Furniture-Store HomePage SearchBox Test ");
		homepage.searchFurniture("Bed");
	}

	@Test(priority = 8)
	public void validateSocialMediaLinkTest() throws InterruptedException {
		test=extent.createTest("TC_08:Furniture-Store HomePage SocialMedia Link Test" )	;
		homepage.ClickSocialMediaLink();

	}
	@Test(priority=9)
	public void clickMenuAreaLinkTest() throws InterruptedException {
		test=extent.createTest("TC_09:Furniture-Store HomePage click MenuArea Link Test" )	;
		menuareaLink();
	}

	@Test(priority=10)
	public void ClickYouMightAlsoLikePageTest() throws InterruptedException {
		test=extent.createTest("TC_09:Furniture-Store HomePage Click YouMightAlsoLike page Test" );
		clickYouMightAlsoLikeProductLink();
	}
	
	@Test(priority=11)
	public void ClickMostPopularProductLinkpageTest() throws InterruptedException {
		test=extent.createTest("TC_09:Furniture-Store HomePage Click MostPopular ProductLink page Test" );
		clickMostPopularProductLink();
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

	public void scrollupToYouMightAlsoLike() {
		WebElement element=driver.findElement(By.xpath("//span[normalize-space()='You might also like']"));
		//JavaScriptUtil.scrolluptoanelementByJS(element, driver);
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
										
	}
	
	public void clickYouMightAlsoLikeProductLink() throws InterruptedException {
		scrollupToYouMightAlsoLike();
		WebElement product= driver.findElement(By.xpath("//img[@alt='C and F Enterprises Plaid Squirrel Pillow (85145039)']"));
		Actions action = new Actions(driver);
		action.moveToElement(product).build().perform();
		driver.findElement(By.xpath("//a[@href='https://selectfurniturestore.com/60-flower-table-maple-green-chunky-(pack-of-1)-ECRK-ELR14102MGNC-53442' and @oldtitle='View More']")).click();
		Thread.sleep(1000);
		test.info("The View More Page", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShots()).build());
		driver.navigate().back();

		//AddToWishList
		driver.findElement(By.xpath("//a[@onclick=\"addToWishList('53442');\"]")).click();
		test.info("The Add To Wish", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShots()).build());
		Thread.sleep(1000);
		//AddTocompare
		scrollupToYouMightAlsoLike();
		driver.findElement(By.xpath("//div[@class='compare']//a[ @onclick=\"addToCompare('53442');\"]")).click();
		test.info("The Add to Compare", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShots()).build());
		Thread.sleep(1000);

		scrollupToYouMightAlsoLike();
		driver.findElement(By.xpath("//*[@id=\"carousel300\"]/div/div/div[1]/ul/li[1]/div/div/div[1]/div[2]/div/div[2]/input")).click();
		Thread.sleep(3000);
		test.info("The Add to cart Page", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShots()).build());
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[normalize-space()='Continue Shopping']")).click();

	}
	
	public void scrollupToMostPopular() {
		WebElement element=driver.findElement(By.xpath("//span[normalize-space()='Most Popular']"));
		//JavaScriptUtil.scrolluptoanelementByJS(element, driver);
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", element);	
	}
	
	public void clickMostPopularProductLink() throws InterruptedException {
		
		scrollupToMostPopular();
		WebElement product= driver.findElement(By.xpath("//img[@alt='Small Denim Kids Bean Bag Chair']"));
		Actions action = new Actions(driver);
		action.moveToElement(product).build().perform();
		driver.findElement(By.xpath("//a[@href='https://selectfurniturestore.com/hastings-table-STEI-13402-39587' and @oldtitle='View More']")).click();
		Thread.sleep(1000);
		test.info("The View More Page", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShots()).build());
		driver.navigate().back();

		//AddToWishList
		driver.findElement(By.xpath("//a[@onclick=\"addToWishList('39587');\"]")).click();
		test.info("The Add To Wish", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShots()).build());
		Thread.sleep(1000);
		//AddTocompare
		scrollupToMostPopular();
		driver.findElement(By.xpath("//a[@onclick=\"addToCompare('39587');\"]")).click();
		test.info("The Add to Compare", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShots()).build());
		Thread.sleep(1000);

		scrollupToMostPopular();
		driver.findElement(By.xpath("//*[@id=\"container\"]/div[5]/div[2]/div/div[1]/div[1]/div[2]/div/div[4]/a")).click();
		Thread.sleep(3000);
		test.info("The Add to cart Page", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShots()).build());
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[normalize-space()='Continue Shopping']")).click();

	}
	
	public void menuareaLink() throws InterruptedException {

		homepage.BedBathDrpDwn.click();
		Thread.sleep(1000);
		test.pass("The BedRoom and BathRoom Page", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShots()).build());
		homepage.homePageLogoBtn.click();

		homepage.DiningroomDrpDwn.click();
		Thread.sleep(1000);
		test.pass("The Diningroom Page", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShots()).build());
		homepage.homePageLogoBtn.click();

		homepage.FurnitureZoneBtn.click();
		Thread.sleep(1000);
		test.pass("The FurnitureZone Page", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShots()).build());
		homepage.homePageLogoBtn.click();

		homepage.GiftDrpDwn.click();
		Thread.sleep(1000);
		test.pass("The GiftDrp Page", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShots()).build());
		homepage.homePageLogoBtn.click();

		homepage.KidsfurnitureDrpDwn.click();
		Thread.sleep(1000);
		test.pass("The Kidsfurniture Page", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShots()).build());
		homepage.homePageLogoBtn.click();

		homepage.LivingroomDrpDwn.click();
		Thread.sleep(1000);
		test.pass("The Livingroom Page", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShots()).build());
		homepage.homePageLogoBtn.click();

		homepage.OfficefurnitureDrpDwn.click();
		Thread.sleep(1000);
		test.pass("The Officefurniture Page", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShots()).build());
		homepage.homePageLogoBtn.click();

		homepage.OutdoorfurnitureDrpDwn.click();
		Thread.sleep(1000);
		test.pass("The Outdoorfurniture Page", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShots()).build());
		homepage.homePageLogoBtn.click();

		homepage.PetfurnitureDrpDwn.click();
		Thread.sleep(1000);
		test.pass("The Petfurniture	 Page", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShots()).build());
		homepage.homePageLogoBtn.click();

	}




}
