package com.qa.furniture.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;
import com.qa.util.JavaScriptUtil;

public class FooterLinkPage extends TestBase{
	
	public FooterLinkPage() {
		PageFactory.initElements(driver, this);
	}
	
	//scrollDownto Information
	@FindBy(xpath="//div[@class='column1']//h3[contains(text(),'Information')]")
	WebElement Information;
	
	//Link at Information List
	@FindBy(xpath="//div[@class='column1']//a[normalize-space()='About Us']")
	public WebElement AboutUSLink;
	@FindBy(xpath="//div[@class='column1']//a[contains(text(),'COVID-19')]")
	public WebElement Covid19Link;
	@FindBy(xpath="//div[@class='column1']//a[contains(text(),'Delivery Information')]")
	public WebElement DeliveryInfoLink;
	@FindBy(xpath="//div[@class='column1']//a[contains(text(),'Damaged Goods Policy')]")
	public WebElement DamagedGoodLink;
	@FindBy(xpath="//div[@class='column1']//a[normalize-space()='Return & Refund Policy']")
	public WebElement ReturnRefundLink;
	@FindBy(xpath="//div[@class='column1']//a[contains(text(),'Privacy Policy')]")
	public WebElement PrivacyPolicyLink;
	@FindBy(xpath="//div[@class='column1']//a[contains(text(),'Terms & Conditions')]")
	public WebElement TermConditionLink;
	
	//Link under CUSTOMER SERVICE
	@FindBy(xpath="//div[@class='column2']//a[normalize-space()='Contact Us']")
	public WebElement ContactUsFooterLink;
	@FindBy(xpath="//div[@class='column2']//a[normalize-space()='Return Product']")
	public WebElement ReturnPoductLink;
	@FindBy(xpath="//div[@class='column2']//a[normalize-space()='Site Map']")
	public WebElement SiteMapLink;
	
	//Link under EXTRAS
	@FindBy(xpath="//div[@class='column4']//a[normalize-space()='Brands']")
	public WebElement BrandsFooterLink;
	
	
	public void scrollUpToInformation() {
		JavaScriptUtil.scrolluptoanelementByJS(Information, driver);
	}
	
	

}
