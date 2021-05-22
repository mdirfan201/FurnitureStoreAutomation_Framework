package com.qa.furniture.page;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.qa.base.TestBase;
import com.qa.util.JavaScriptUtil;

public class HomePage extends TestBase{
	
	static ExtentTest test;
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	//Action to performe--------
	@FindBy(xpath="//img[@alt='Selectfurniturestore.com']")
	public WebElement furnitureLogo;
	@FindBy(xpath="//div[@id='welcome']//a[contains(text(),'login')]")
	public WebElement loginBtn;
	@FindBy(xpath="//div[@id='welcome']//a[contains(text(),'create an account')]")
	public WebElement createaccountBtn;	
	@FindBy(xpath="//div[@id='welcome']//span[contains(text(),'Contact us')]")
	public WebElement contactusBtn;
	@FindBy(xpath="//span[@id='cart-total']")
	public WebElement cartTotalBtn; //AterBox is comming getText() and accept;
	@FindBy(xpath="//div[@id='top-links-switcher']//span[contains(text(),'My Menu')]")
	public WebElement myMenuListBtn;
	@FindBy(xpath="//input[@placeholder='Search']")
	public WebElement txtsearch;
	@FindBy(xpath="//a[@class='menu-home-link']")
	public static WebElement homePageLogoBtn;


	//------------------Social Media Link-------------------------------------
	@FindBy(xpath="//img[@alt='facebook']")
	public WebElement clickFacebook;
	@FindBy(xpath="//img[@alt='twitter']")
	public WebElement clickTwitter;
	@FindBy(xpath="//img[@alt='blogger']")
	public WebElement clickBlog;
	@FindBy(xpath="//img[@alt='youtube']")
	public WebElement clickYoutube;
	//-----SlideShow------------------------------------
	@FindBy(xpath="//div[@class='slideshow']//div[@id='slideshow0']//a[@href='https://selectfurniturestore.com/Living-Room-Furniture/Sofas-and-Couches']")
	public WebElement slideLivingRoom;
	@FindBy(xpath="//div[@class='slideshow']//div[@id='slideshow0']//a[@href='https://selectfurniturestore.com/dining-room-furniture/Kitchen-Dining']")
	public WebElement slideDiningRoom;
	@FindBy(xpath="https://selectfurniturestore.com/Office-Furniture%20/Office-Desks")
	public WebElement slideOfficeFurniture;
	
	
	//------------------Main MenuArea------------------------------------
	@FindBy(xpath="//div[@id='menu']//a[text()='Bedroom & Bathroom Furniture']")
	public static WebElement BedBathDrpDwn;
	@FindBy(xpath="//div[@id='menu']//a[text()='Dining Room']")
	public static WebElement DiningroomDrpDwn;
	@FindBy(xpath="//div[@id='menu']//a[text()='Furniture Zone']")
	public static WebElement FurnitureZoneBtn;
	@FindBy(xpath="//div[@id='menu']//a[text()='Gifts']")
	public static WebElement GiftDrpDwn;
	@FindBy(xpath="//div[@id='menu']//a[text()='Kids Furniture']")
	public static WebElement KidsfurnitureDrpDwn;
	@FindBy(xpath="//div[@id='menu']//a[text()='Living Room']")
	public static WebElement LivingroomDrpDwn;
	@FindBy(xpath="//div[@id='menu']//a[text()='Office Furniture']")
	public static WebElement OfficefurnitureDrpDwn;
	@FindBy(xpath="//div[@id='menu']//a[text()='Outdoor Furniture']")
	public static WebElement OutdoorfurnitureDrpDwn;
	@FindBy(xpath="//div[@id='menu']//a[text()='Pet Furniture']")
	public static WebElement PetfurnitureDrpDwn;
	//-----------------------------------

	public String validateTitle() {
		return driver.getTitle();
	}
	public boolean validateLogo() {
		WebElement ele= driver.findElement(By.xpath("//img[@alt='Selectfurniturestore.com']"));
		JavaScriptUtil.drawBorder(ele, driver);
		return furnitureLogo.isDisplayed();

	}
	public void MyMenuLink() throws InterruptedException {
		Actions act= new Actions(driver);
		act.moveToElement(myMenuListBtn).build().perform();
		driver.findElement(By.xpath("//a[@class='account']")).click();
		WebElement ele1= driver.findElement(By.xpath("//h1[normalize-space()='My Account']"));
		JavaScriptUtil.drawBorder(ele1, driver);
		Thread.sleep(3000);
		homePageLogoBtn.click();

		/*act.moveToElement(myMenuListBtn).build().perform();
		driver.findElement(By.xpath("//a[@class='wishlist']")).click();
		WebElement ele2= driver.findElement(By.xpath(""));
		JavaScriptUtil.drawBorder(ele2, driver);
		Thread.sleep(3000);
		homePageLogoBtn.click();
		Thread.sleep(3000);*/

		act.moveToElement(myMenuListBtn).build().perform();
		driver.findElement(By.xpath("//a[@class='shopping-cart']")).click();
		WebElement ele3= driver.findElement(By.xpath("//h1[normalize-space()='Shopping Cart']"));
		JavaScriptUtil.drawBorder(ele3, driver);
		Thread.sleep(3000);
		homePageLogoBtn.click();

		act.moveToElement(myMenuListBtn).build().perform();
		driver.findElement(By.xpath("//a[@class='checkout']")).click();
		WebElement ele4= driver.findElement(By.xpath("//h1[normalize-space()='Shopping Cart']"));
		JavaScriptUtil.drawBorder(ele4, driver);
		Thread.sleep(3000);
		homePageLogoBtn.click();
	}

	public LoginPage ClickonLoginPageLink() throws InterruptedException {
		loginBtn.click();
		WebElement ele1= driver.findElement(By.xpath("//h2[normalize-space()='Returning Customer']"));
		JavaScriptUtil.drawBorder(ele1, driver);
		return new LoginPage();	
	}
	public RegisterAccountPage ClickonCreateAccountLink() throws InterruptedException {
		createaccountBtn.click();
			
		return new RegisterAccountPage();
	}
	public ContactUsPage ContactUsLink() throws InterruptedException {
		contactusBtn.click();
		WebElement ele1= driver.findElement(By.xpath("//h1[normalize-space()='Contact Us']"));
		JavaScriptUtil.drawBorder(ele1, driver);

		return new ContactUsPage();
	}
	public void searchFurniture(String enterFurnitureName) throws InterruptedException {
		txtsearch.sendKeys(enterFurnitureName, Keys.ENTER);
		Thread.sleep(3000);
		JavaScriptUtil.WindowScrollBy(driver);
		Thread.sleep(2000);
		WebElement ele= driver.findElement(By.xpath("//div[@class='image']"));
		JavaScriptUtil.drawBorder(ele, driver);
		Thread.sleep(2000);

	}

	public void ClickSocialMediaLink() throws InterruptedException {

		String parentWindowID=driver.getWindowHandle();
		System.out.println("Parent Window ID is====>" + parentWindowID);
		clickFacebook.click();

		Set<String> facebookWindows=driver.getWindowHandles();
		int fcount= facebookWindows.size();
		System.out.println("Totla number of windows are==>"+ fcount);
		ArrayList<String>ftabs= new ArrayList<String>(facebookWindows);
		driver.switchTo().window(ftabs.get(1));
		Thread.sleep(3000);
		driver.close();
		driver.switchTo().window(ftabs.get(0));


		clickTwitter.click();
		Set<String> twitterWindows=driver.getWindowHandles();
		int tcount= twitterWindows.size();
		System.out.println("Totla number of windows are==>"+ tcount);
		ArrayList<String>ttabs= new ArrayList<String>(twitterWindows);
		driver.switchTo().window(ttabs.get(1));
		Thread.sleep(3000);
		driver.close();
		driver.switchTo().window(ttabs.get(0));

		//Blog
		clickBlog.click();
		Set<String> blogWindows=driver.getWindowHandles();
		int bcount= blogWindows.size();
		System.out.println("Totla number of windows are==>"+ bcount);
		ArrayList<String>btabs= new ArrayList<String>(blogWindows);
		driver.switchTo().window(btabs.get(1));
		Thread.sleep(3000);
		driver.close();
		driver.switchTo().window(btabs.get(0));

		//Youtube
		clickYoutube.click();
		Set<String> youtubeWindows=driver.getWindowHandles();
		int ycount= youtubeWindows.size();
		System.out.println("Totla number of windows are==>"+ ycount);
		ArrayList<String>ytabs= new ArrayList<String>(youtubeWindows);
		driver.switchTo().window(ytabs.get(1));
		Thread.sleep(3000);
		driver.close();
		driver.switchTo().window(ytabs.get(0));

	}	

	
	
	
	
	public String getHomePageScreenShots() {
		
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
	}
}
