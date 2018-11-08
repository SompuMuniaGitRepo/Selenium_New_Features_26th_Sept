package com.dd.qa.selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;
import com.dd.qa.utilities.Xls_Reader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WriteWebtableValuestoExcel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//full table xpath
		//table[@id='customers']
		
		
		//Col 1 All rows
		//*[@id="customers"]/tbody/tr[2]/td[1]
		//*[@id="customers"]/tbody/tr[3]/td[1]
		
		//Col 2 All rows
		//*[@id="customers"]/tbody/tr[2]/td[2]
		//*[@id="customers"]/tbody/tr[3]/td[2]
		
        WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(140, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		
		
		
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		System.out.println("Webtable site opened");
		
		
		Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("C:\\Users\\Debarati\\Desktop\\Selenium_Workspace\\"+
		                                     "Selenium_New_Concepts_Practice\\SeleniumNewFeatures_26thSept\\Screenshots");

		List <WebElement> rows = driver.findElements(By.xpath("//table[@id='customers']//tr"));
		int tot_rows = rows.size();
		int data_rows = tot_rows -1;
		
		String before_xpath_company = "//*[@id=\"customers\"]/tbody/tr[";
		String after_xpath_company = "]/td[1]";
		
		String before_xpath_contact = "//*[@id=\"customers\"]/tbody/tr[";
		String after_xpath_contact ="]/td[2]";
		
		String before_xpath_country ="//*[@id=\"customers\"]/tbody/tr[";
		String after_xpath_country = "]/td[3]";
		
		
		Xls_Reader reader = new Xls_Reader("C:\\Users\\Debarati\\Desktop\\Selenium_Workspace\\Selenium_New_Concepts_Practice\\"+
		                                           "SeleniumNewFeatures_26thSept\\src\\test\\java\\com\\dd\\qa\\testdata\\WebTable Values.xlsx");
		
		if(reader.addSheet("Customer_Details"))  {
		reader.addColumn("Customer_Details", "Company");
		reader.addColumn("Customer_Details", "Contact");
		reader.addColumn("Customer_Details", "Country");
		
		}
		
		
		for(int i=2; i<=tot_rows;i++) {
			
			String actual_xpath_company = before_xpath_company + i +after_xpath_company;
			String company_name = driver.findElement(By.xpath(actual_xpath_company)).getText();
			System.out.println(company_name);
			reader.setCellData("Customer_Details", "Company", i, company_name);
			
			
			String actual_xpath_contact = before_xpath_contact + i +after_xpath_contact;
			String contact_name = driver.findElement(By.xpath(actual_xpath_contact)).getText();
			System.out.println(contact_name);
			reader.setCellData("Customer_Details", "Contact", i, contact_name);
			
			String actual_xpath_country = before_xpath_country + i +after_xpath_country;
			String country_name = driver.findElement(By.xpath(actual_xpath_country)).getText();
			System.out.println(country_name);
			reader.setCellData("Customer_Details", "Country", i, country_name);

			
			
			
			
			
		}

	}

}
