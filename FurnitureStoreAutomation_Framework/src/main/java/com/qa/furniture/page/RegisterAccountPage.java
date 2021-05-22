package com.qa.furniture.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.TestBase;
import com.qa.util.JavaScriptUtil;

public class RegisterAccountPage extends TestBase {
	
	
	public RegisterAccountPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Title=Register Account
	@FindBy(xpath="//h1[normalize-space()='Register Account']")
	public WebElement registerLable;
	
	@FindBy(xpath="//a[normalize-space()='login page']")
	public WebElement loginpagetxt;
	
	@FindBy(xpath="//input[@name='agree']")
	public WebElement clickCheckBoxBtn;
	@FindBy(xpath="//input[@value='Continue']")
	public WebElement clickContinueBtn;
	
	//-----Your Personal Details
	@FindBy(xpath="//h2[normalize-space()='Your Personal Details']")
	public WebElement YourPerDetails;
	@FindBy(xpath="//input[@name='firstname']")
	public WebElement txtFirstName;
	//span[text()='First Name must be between 3 and 32 characters!']
	@FindBy(xpath="//input[@name='lastname']")
	public WebElement txtLastName;
	//span[text()='Last Name must be between 3 and 32 characters!']
	@FindBy(xpath="//input[@name='email']")
	public WebElement txtEmail;
	//span[normalize-space()='E-Mail Address does not appear to be valid!']
	@FindBy(xpath="//input[@name='telephone']")
	public WebElement txtTelephone;
	//span[normalize-space()='Telephone must be between 10 and 15 numbers!']
	@FindBy(xpath="//input[@name='fax']")
	public WebElement txtFax;
	
	//------------Your Address---------
	//h2[normalize-space()='Your Address']
	@FindBy(xpath="//input[@name='address_1']")
	public WebElement txtAddress1;
	//span[normalize-space()='Address 1 must be between 3 and 128 characters!']
	@FindBy(xpath="//input[@name='city']")
	public WebElement txtCity;
	//span[normalize-space()='City must be between 2 and 128 characters!']
	@FindBy(xpath="//input[@name='postcode']")
	public WebElement txtpostcopde;
	//span[normalize-space()='Invalid zip code']    
	//span[normalize-space()='Please select a region / state!']
	@FindBy(xpath="//input[@name='password']")
	public WebElement txtpassword;
	@FindBy(xpath="//input[@name='confirm']")
	public WebElement txtconfirmpassword;
	
	
	
	
	public String validateTitle() {
		WebElement ele1= driver.findElement(By.xpath("//h1[normalize-space()='Register Account']"));
		JavaScriptUtil.drawBorder(ele1, driver);
		return driver.getTitle();
		
	}
	
	public boolean ValidatePageLable() {

		JavaScriptUtil.drawBorder(registerLable, driver);
		return registerLable.isDisplayed();
	}
	
	public void clickLoginpageBtn() throws InterruptedException {
		Thread.sleep(2000);
		loginpagetxt.click();
		driver.navigate().back();
	}
	
	public void clickContinueWithEmpty() throws InterruptedException {
		WebElement element= driver.findElement(By.xpath("//h2[normalize-space()='Newsletter']"));
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
		Thread.sleep(1000);
		clickCheckBoxBtn.click();
		clickContinueBtn.click();
	}
	
	public void setRegisterData(String fname, String lname, String email,String tele, String add,String city,String post,String cntry,String region,String pwd,String cnfpwd) throws InterruptedException {
		
		txtFirstName.sendKeys(fname,Keys.TAB);
		txtLastName.sendKeys(lname,Keys.TAB);
		txtEmail.sendKeys(email, Keys.TAB);
		txtTelephone.sendKeys("7718942434", Keys.TAB);
	
		txtAddress1.sendKeys(add, Keys.TAB);
		txtCity.sendKeys(city,Keys.TAB);
		txtpostcopde.sendKeys(post, Keys.TAB);
		Thread.sleep(3000);
		//Select Country
		Select selcountry= new Select(driver.findElement(By.xpath("//select[@name='country_id']")));
		selcountry.selectByVisibleText(cntry);
		
		//Select State
		
		Select selstate= new Select(driver.findElement(By.xpath("//select[@name='zone_id']")));
		Thread.sleep(1000);
		selstate.selectByVisibleText(region);;
//		
		txtpassword.sendKeys(pwd,Keys.TAB);
		txtconfirmpassword.sendKeys(cnfpwd, Keys.TAB);
		clickCheckBoxBtn.click();
		clickContinueBtn.click();
	}
	
}
