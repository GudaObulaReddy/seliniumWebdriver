package com.Selinium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckSorted {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramakrishna\\Desktop\\chromedriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		List<WebElement> list=driver.findElements(By.cssSelector("tr td:nth-child(2)"));
		int size=list.size();
		
		
		//Clicks which will help sort the list
		driver.findElement(By.cssSelector("tr th:nth-child(2)")).click();
		Thread.sleep(2000);
     //  driver.findElement(By.cssSelector("tr th:nth-child(2)")).click();
//		Thread.sleep(3000);
		//Array for holding all the values from web page
		ArrayList<String> name=new ArrayList<String>();
		
		for(int i=0;i<size;i++)
		{
			name.add(list.get(i).getText());
		}
		
		//Array for storing the sorted list of values
		ArrayList<String> sortName=new ArrayList<String>();
		
		for(int i=0;i<size;i++)
		{
			sortName.add(name.get(i));
		}
		Collections.sort(sortName); //Sorting the values here
		Collections.reverse(sortName);//Making reverse of the sorted list
		
		if(name.equals(sortName))//checking the original list vs the sorted list 
		{
			System.out.println("Column is reverse sorted");
		}
		else
		{
			System.out.println("Column is NOT sorted");
		}
		
	
	

	}

}
