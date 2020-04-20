package com.Selinium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RightClic {

	public static void main(String[] args)
	{
		//div[@class='contextmenu']
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramakrishna\\Desktop\\chromedriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://techterms.com/definition/rightclick");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		Actions act=new Actions(driver);
		WebDriverWait wait1=new WebDriverWait(driver, 10);
		wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"apa\"]"))));
		act.contextClick(driver.findElement(By.xpath("//*[@id=\"apa\"]"))).build().perform();

	}

}
