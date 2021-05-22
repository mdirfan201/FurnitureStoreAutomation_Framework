package com.qa.furniture.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;
import com.qa.util.JavaScriptUtil;

public class ContactUsPage extends TestBase {
	
	public ContactUsPage() {
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1[text()='Contact Us']")
	WebElement ContactUsLable;
	@FindBy(xpath="//h2[normalize-space()='Our Location']")
	WebElement OurLocation;
	@FindBy(xpath="//div[@class='left']")
	WebElement addresstext;
	@FindBy(xpath="//input[@name='name']")
	WebElement txtName;
	@FindBy(xpath="//input[@name='email']")
	WebElement txtEmail;
	@FindBy(xpath="//textarea[@name='enquiry']")
	WebElement txtEnquiry;
	@FindBy(xpath="//input[@name='captcha']")
	WebElement txtCaptcha;
	@FindBy(xpath="//input[@value='Submit']")
	WebElement clickSubmitBtn;
	
	//Actions:
	public String validateTitle() {
		return driver.getTitle();
	}
	public boolean validateLable() {
		return ContactUsLable.isDisplayed(); 
	}
	public String getAddressText() {
		JavaScriptUtil.scrolluptoanelementByJS(OurLocation, driver);
		return addresstext.getText();
	}
	
	public void setEmptyData() throws InterruptedException {
		txtName.sendKeys("",Keys.TAB);
		txtEmail.sendKeys("",Keys.TAB);
		txtEnquiry.sendKeys("",Keys.TAB);
		txtCaptcha.sendKeys("",Keys.TAB);
		Thread.sleep(2000);
		clickSubmitBtn.click();
	}
	
	public void setContactusData(String name, String email, String enq) throws InterruptedException {
		txtName.sendKeys(name,Keys.TAB);
		txtEmail.sendKeys(email,Keys.TAB);
		txtEnquiry.sendKeys(enq,Keys.TAB);
		Thread.sleep(2000);
		clickSubmitBtn.click();
		
	}
	
	public void scrollupto() {
		WebElement element= driver.findElement(By.xpath("//h2[normalize-space()='Enquiry Form']"));
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
	}

}
