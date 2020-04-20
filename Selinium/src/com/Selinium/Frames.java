package com.Selinium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames 
{
public static void main(String[] args) 
{
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramakrishna\\Desktop\\chromedriver\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("https://the-internet.herokuapp.com/frames");
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.findElement(By.cssSelector("a[href=\"/iframe\"]")).click();
	driver.switchTo().frame(driver.findElement(By.id("mce_0_ifr")));
	WebElement element=driver.findElement(By.id("tinymce"));
	element.clear();
	element.sendKeys("hi ra h r u");
	driver.switchTo().parentFrame();
	System.out.println(driver.findElement(By.cssSelector(".example h3")).getText());
	driver.findElement(By.id("mceu_15-open")).click();
   
}
}
