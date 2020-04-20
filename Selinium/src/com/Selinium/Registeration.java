package com.Selinium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Registeration {

	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramakrishna\\Desktop\\chromedriver\\chromedriver.exe"); WebDriver
		  driver=new ChromeDriver();
		driver.get("http://newtours.demoaut.com/");
		 driver.manage().window().maximize(); driver.manage().deleteAllCookies();
		  driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  driver.findElement(By.xpath("//a[contains(text(),\"SIGN-ON\")]")).click();
		  driver.findElement(By.xpath("//*[@name=\"userName\"]")).clear();
		  driver.findElement(By.xpath("//*[@name=\"userName\"]")).sendKeys("obula reddy");
		  driver.findElement(By.xpath("//*[@name=\"password\"]")).clear();
		  driver.findElement(By.xpath("//*[@name=\"password\"]")).sendKeys("obula123");
		  driver.findElement(By.xpath("//*[@name=\"login\"]")).click();
		  Thread.sleep(10000);
		  driver.close();
		 	

	}

}
