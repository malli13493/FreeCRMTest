package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPages;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class LoginPageTest extends TestBase {
	LoginPages loginPage;
	HomePage homepage;
	
	public LoginPageTest(){
		super();
	}
	@BeforeMethod
	public void setUp(){
         initialization();
		 loginPage = new LoginPages();
	}
	
	@Test(priority=2,description="verifying login page title test")
//	@Severity(SeverityLevel.NORMAL)
//	@Description("Test Case Description Verify Login Page")
//	@Story("Story name to check login page title")
	public void loginPageTitleTest(){
	String title = loginPage.validationPageTitle();
		Assert.assertEquals(title, "Cogmento CRM");
	}

	@Test(priority=3,description="verifying login page  test")
//	@Severity(SeverityLevel.CRITICAL)
//	@Description("Test Case Description Verify Login Page")
//	@Story("Story name to check sign up link")
	public void crmLoginImageTest(){
		boolean flag = loginPage.validateCRMLogo();
		Assert.assertTrue(flag);
	}
	
	
	@Test(priority=1,description="verifying login page enter username and password")
//	@Severity(SeverityLevel.NORMAL)
//	@Description("Test Case Description Verify valid creditials")
//	@Story("Story name to check valid creditials")
	public void loginTest(){
		homepage  =	loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown(){
		//driver.quit();
	}

}
