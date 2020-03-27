package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//*[@id='ui']/div/div[2]/div[2]/div/div/div[2]/div[1]/div/div[1]/div")
	WebElement homeLinks;
	
	@FindBy(xpath="//*[@id='main-nav']/a[3]")
	WebElement contactsLink;
	
	@FindBy(xpath="//*[@id='main-nav']/a[5]")
	WebElement dealsLink;
	
	@FindBy(xpath="//*[@id='main-nav']/a[6]")
	WebElement tasksLink;
	
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	  
	public String verifyHomePageTitle(){
		return driver.getTitle();
		
	}
	
	public boolean verifyHomeLink(){
		return homeLinks.isDisplayed();
	}
	
	public ContactsPage  clickOnContactLink(){
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage  clickOnDealsLink(){
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage  clickOnTasksLink(){
		tasksLink.click();
		return new TasksPage();
	}

}
