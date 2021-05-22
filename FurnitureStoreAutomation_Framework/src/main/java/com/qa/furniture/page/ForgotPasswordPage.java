package com.qa.furniture.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;
import com.qa.util.JavaScriptUtil;

public class ForgotPasswordPage extends TestBase{

	public ForgotPasswordPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//h1[normalize-space()='Forgot Your Password?']")
	public WebElement ForgotPageLable;
	
	@FindBy(xpath="//div[@class='warning']")
	public WebElement txtforgotPagewarning;
	
	@FindBy(xpath="//input[@name='email']")
	public WebElement txtEmailAdd;
	
	@FindBy(xpath="//input[@value='Continue']")
	public WebElement clickContBtn;
	
	@FindBy(xpath="//a[normalize-space()='Back']")
	public WebElement clickBackBtn;
	
	public String validateTitle() {
		return driver.getTitle();
	}
	
	public boolean validateForgotLabe() {
		JavaScriptUtil.drawBorder(ForgotPageLable, driver);
		return ForgotPageLable.isDisplayed();
	}
	
	public void validateBackBtn() throws InterruptedException {
		clickBackBtn.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='content']//a[normalize-space()='Forgot Your Password?']")).click();
	}
	
	public void clickEmptyEmail() {
		clickContBtn.click();
		txtforgotPagewarning.getText();
		
	}
	
	public void wrongEmail(String wrongEmail) {
		txtEmailAdd.sendKeys(wrongEmail,Keys.ENTER);
		txtforgotPagewarning.getText();
	}
	
	public void validEmail(String correctEmail) {
		txtEmailAdd.sendKeys(correctEmail,Keys.ENTER);
		
	}
}
