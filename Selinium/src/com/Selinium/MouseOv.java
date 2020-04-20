package com.Selinium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseOv {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramakrishna\\Desktop\\chromedriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		Actions act=new Actions(driver);
		WebElement element1=driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/span[2]"));
		WebElement element2=driver.findElement(By.xpath("//*[@id=\"nav-flyout-ya-signin\"]/a/span"));
		//act.moveToElement(element1).build().perform();//mouse over 
		//act.moveToElement(element2).click().build().perform();// mouse over and click
		act.moveToElement(element1).moveToElement(element2).click().build().perform();
	}

}
