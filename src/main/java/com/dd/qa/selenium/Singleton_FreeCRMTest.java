package com.dd.qa.selenium;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.dd.qa.selenium.singleton.Singleton_Webdriver;

//import junit.framework.Assert;

public class Singleton_FreeCRMTest extends Singleton_Webdriver{

	@BeforeMethod
	public void setUp() {
		Singleton_Webdriver.getDriverInstance();
	}
	
	
	@Test
	public void validateLoginPageTitle() {
		 String actualTitle = driver.getTitle();
		 Assert.assertEquals(actualTitle, "#1 Free CRM software in the cloud for sales and service","Titles don't match");
	}
	
	
	@Test
	public void validateLogo() {
		if(driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/a/img")).isDisplayed())  {
			System.out.println("Login Page logo is displayed");
		}
		
		else
			System.out.println("Logo is not displayed");
		
	}	
	
	@AfterMethod
	public void tearDown() {
		Singleton_Webdriver.quitBrowser();
	}
	
	
}
