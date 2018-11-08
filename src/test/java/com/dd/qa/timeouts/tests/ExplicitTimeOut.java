package com.dd.qa.timeouts.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.dd.qa.utilities.BaseTimeouts;

public class ExplicitTimeOut extends BaseTimeouts{

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.setProperty("webdriver.chrome.driver", "F:\\Softwares\\chromedriver_win32\\chromedriver_win32_2ndMarch\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("New driver has been initialized");
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(240, TimeUnit.SECONDS);
//		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		
		driver.get("https://www.freecrm.com/index.html");
		System.out.println("FreeCRM site opened");
		
		WebElement  username = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/input[1]"));
		WebElement password = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/input[2]"));
		WebElement logo = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/a/img"));
		WebElement login_btn = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div/input"));
		
		
		sendKeys(driver, username, 120, "naveenk");
		sendKeys(driver, password,120, "Test@123");
		
		isPresent(driver, logo, 100);
		
		clickOn(driver, login_btn, 100);
		
		System.out.println("Clicked succesfully");
		driver.quit();
		driver = null;
	}

}
