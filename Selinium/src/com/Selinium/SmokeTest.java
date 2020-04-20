package com.Selinium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SmokeTest {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramakrishna\\Desktop\\chromedriver\\chromedriver.exe"); 
		WebDriver driver=new ChromeDriver();
		driver.get("http://newtours.demoaut.com/");
		 driver.manage().window().maximize(); driver.manage().deleteAllCookies();
		  driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  driver.findElement(By.xpath("//a[contains(text(),\"SIGN-ON\")]")).click();
		  driver.navigate().back();
		  
		  driver.findElement(By.xpath("//a[contains(text(),\"REGISTER\")]")).click();
		  driver.navigate().back();
		  
		  driver.findElement(By.xpath("//a[contains(text(),\"SUPPORT\")]")).click();
		  driver.navigate().back();
		  
		  driver.findElement(By.xpath("//a[contains(text(),\"CONTACT\")]")).click();
		 
		  

	}

}
