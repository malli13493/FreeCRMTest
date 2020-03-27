package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

import io.qameta.allure.Step;

public class LoginPages extends TestBase{
	
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//*[@id='ui']/div/div/form/div/div[3]")
	WebElement submitbtn;
	
	@FindBy(xpath="//*[@id='ui']/div/div/div[2]/a")
	WebElement crmLogo;
	
	public LoginPages(){
		PageFactory.initElements(driver, this);
	}
	@Step("getting login page title step...")
	public String validationPageTitle(){
		return driver.getTitle();
 	}
	@Step("verifying sign up link is displayed step...")
	public boolean validateCRMLogo(){
		return crmLogo.isDisplayed();
	}
	@Step("login with username: {0} and password: {1} step...")
	public HomePage login(String un,String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		submitbtn.click();
		return new HomePage();
	}

}
