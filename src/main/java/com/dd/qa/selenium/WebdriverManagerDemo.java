package com.dd.qa.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebdriverManagerDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.freecrm.com/index.html");
		System.out.println("FreeCRM site opened");
		
		
		Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Users\\Debarati\\Desktop\\Selenium_Workspace\\Selenium_New_Concepts_Practice\\SeleniumNewFeatures_26thSept\\Screenshots");
		
		driver.quit();
		System.out.println("Driver quitted");

	}

}
