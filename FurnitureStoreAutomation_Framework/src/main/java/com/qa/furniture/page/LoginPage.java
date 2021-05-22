package com.qa.furniture.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;
import com.qa.util.JavaScriptUtil;

public class LoginPage extends TestBase {

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//h1[text()='My Account']")
	public WebElement myAccountLable;

	@FindBy(xpath="//a[text()='Continue']")
	public WebElement clickOnContinueBtn;
	
	@FindBy(xpath="//input[@name='email']")
	public WebElement txtEmailID;
	@FindBy(xpath="//input[@name='password']")
	public WebElement txtPassword;
	@FindBy(xpath="//input[@type='submit']")
	public WebElement LoginBtn;
	
	//--ForgotBtn--
	@FindBy(xpath="//div[@class='content']//a[text()='Forgot Your Password?']")
	public WebElement clickForgotPass;
	
	@FindBy(xpath="//a[normalize-space()='Back']")
	public WebElement backBtn;
	
	@FindBy(xpath="//div[@class='warning']")
	public WebElement txtWarning;
	
	//Action
	public String validateTitle() {
		return driver.getTitle();
	}
	
	public boolean validateLoginPageLable() {
		JavaScriptUtil.drawBorder(myAccountLable, driver);
		return myAccountLable.isDisplayed();
	}
	
	public RegisterAccountPage clickContinueBtn() throws InterruptedException {
		clickOnContinueBtn.click();
		Thread.sleep(2000);
		
		return new RegisterAccountPage();
		
	}
	
	public ForgotPasswordPage clickForgotPassword() throws InterruptedException {
		clickForgotPass.click();
		Thread.sleep(2000);
		//backBtn.click();
		return new ForgotPasswordPage();
	}
	
	public void loginWithEmptyData() {
		LoginBtn.click();
		
	}
	
	public void loginWithIvalidData(String email, String pwd) {
		txtEmailID.sendKeys(email, Keys.ENTER);
		txtPassword.sendKeys(pwd,Keys.ENTER);
		LoginBtn.click();
		
	}
	
	public void loginWithvalidData(String email, String pwd) {
		txtEmailID.sendKeys(email, Keys.ENTER);
		txtPassword.sendKeys(pwd,Keys.ENTER);
		LoginBtn.click();
		
	}
}
