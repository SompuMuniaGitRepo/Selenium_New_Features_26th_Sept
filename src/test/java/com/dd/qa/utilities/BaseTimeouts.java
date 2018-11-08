package com.dd.qa.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTimeouts {

	
	public static WebDriver driver ;
	public static void  sendKeys(WebDriver driver, WebElement element, int time, String data )  {
		
		 new WebDriverWait(driver,time).until(ExpectedConditions.visibilityOf(element));
		 element.sendKeys(data);
		
	}
	
	
	public static void  clickOn(WebDriver driver, WebElement element, int time)  {
		
		 new WebDriverWait(driver,time).until(ExpectedConditions.elementToBeClickable(element));
		 element.click();
		
	}
	
	
	public static void  isPresent(WebDriver driver, WebElement element, int time)  {
		
		 new WebDriverWait(driver,time).until(ExpectedConditions.presenceOfElementLocated((By) element));
		 element.isDisplayed();
		
	}
	
}
