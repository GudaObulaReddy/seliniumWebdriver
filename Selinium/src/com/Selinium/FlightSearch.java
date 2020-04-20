package com.Selinium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FlightSearch {

	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramakrishna\\Desktop\\chromedriver\\chromedriver.exe"); 
		WebDriver driver=new ChromeDriver();
		driver.get("http://newtours.demoaut.com/");
		 driver.manage().window().maximize(); driver.manage().deleteAllCookies();
		  driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//a[contains(text(),\"SIGN-ON\")]")).click();
		  driver.findElement(By.xpath("//*[@name=\"userName\"]")).clear();
		  driver.findElement(By.xpath("//*[@name=\"userName\"]")).sendKeys("obula reddy");
		  driver.findElement(By.xpath("//*[@name=\"password\"]")).clear();
		  driver.findElement(By.xpath("//*[@name=\"password\"]")).sendKeys("obula123");
		  driver.findElement(By.xpath("//*[@name=\"login\"]")).click();
		  Thread.sleep(10000);
		  driver.findElement(By.xpath("//*[@value=\"oneway\"]")).click();
		  WebElement element1=driver.findElement(By.xpath("//*[@name=\"passCount\"]"));
		  Select selectPassengers=new Select(element1);
		  selectPassengers.selectByVisibleText("1");
		/*
		 * List<WebElement>
		 * list=driver.findElements(By.xpath("//*[@name=\"fromPort\"]")); //String
		 * s="London"; // selecting from one for(WebElement element:list) { String
		 * k=element.getText(); if(k.equals("Paris")) { System.out.println("hi");
		 * element.click(); break; } }
		 */
	Thread.sleep(2000);
	 WebElement element2=driver.findElement(By.xpath("//*[@name=\"fromPort\"]"));
	  Select selectFrom=new Select(element2);
	  selectFrom.selectByVisibleText("London");
	  WebElement element3=driver.findElement(By.xpath("//*[@name=\"fromMonth\"]"));
	  Select selectmonth=new Select(element3);
	  selectmonth.selectByVisibleText("June");
	  
	  WebElement element4=driver.findElement(By.xpath("//*[@name=\"fromDay\"]"));
	  Select selectDay=new Select(element4);
	  selectDay.selectByVisibleText("1");
	  
	  WebElement element5=driver.findElement(By.xpath("//*[@name=\"toPort\"]"));
	  Select toport=new Select(element5);
	  toport.selectByVisibleText("Paris");
	  
	  WebElement element6=driver.findElement(By.xpath("//*[@name=\"toMonth\"]"));
	  Select tomonth=new Select(element6);
	  tomonth.selectByVisibleText("July");
	  
	  WebElement element7=driver.findElement(By.xpath("//*[@name=\"toDay\"]"));
	  Select toDay=new Select(element7);
	  toDay.selectByVisibleText("1");
	  
	
	  driver.findElement(By.xpath("//*[@value=\"Business\"]")).click();
	  WebElement element8=driver.findElement(By.xpath("//*[@name=\"airline\"]"));
	  Select Air=new Select(element8);
	  Air.selectByVisibleText("Blue Skies Airlines");
	
		  //driver.close();
	}

}
