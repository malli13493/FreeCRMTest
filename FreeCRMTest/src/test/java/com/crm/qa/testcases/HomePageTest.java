package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPages;

public class HomePageTest extends TestBase {
	LoginPages loginPage;
	HomePage homepage;
	ContactsPage contactspage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPages();
		contactspage = new ContactsPage();
		homepage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
	String title = homepage.verifyHomePageTitle();
		Assert.assertEquals(title, "Cogmento CRM","Home Page title not matched");
	}
	@Test(priority=2)
	public void verifyHomePageLink(){
		Assert.assertTrue(homepage.verifyHomeLink());
	}
	@Test(priority=3)
	public ContactsPage verifyContactsLinksTest(){
		contactspage= homepage.clickOnContactLink();
		return new ContactsPage();
		
	}
	
	
	@AfterMethod
	public void tearDown(){
		//driver.quit();
	}

}
