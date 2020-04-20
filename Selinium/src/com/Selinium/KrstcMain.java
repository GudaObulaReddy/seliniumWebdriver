package com.Selinium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KrstcMain {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramakrishna\\Desktop\\chromedriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://ksrtc.in/oprs-web/");
		driver.manage().window().maximize();
		
		WebElement element1 =driver.findElement(By.cssSelector("#fromPlaceName"));
		element1.sendKeys("BEN");
		Thread.sleep(3000);
		element1.sendKeys(Keys.ENTER);
		
		WebElement element2 = driver.findElement(By.cssSelector("#toPlaceName"));
		element2.sendKeys("MYS");
		Thread.sleep(2000);
		
		Actions act1=new Actions(driver);
		Thread.sleep(2000);
		act1.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		String check = "MYSORE";
		
		if(element2.getAttribute("value").equalsIgnoreCase(check))
		{
			System.out.println("Pass");
		}
		else
			System.out.println("Fail");
		/*
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		Actions act2= new Actions(driver);
		WebElement element1=driver.findElement(By.cssSelector("#nav-link-accountList"));
		WebElement element2=driver.findElement(By.cssSelector(".nav-action-inner"));
		act2.moveToElement(element1).moveToElement(element2).click().build().perform();
		
*/
	}

}
