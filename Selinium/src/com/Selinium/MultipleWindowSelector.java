package com.Selinium;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindowSelector {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//a[href="/windows"]
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramakrishna\\Desktop\\chromedriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("a[href=\"/windows\"]")).click();
		driver.findElement(By.cssSelector("a[href=\"/windows/new\"]")).click();
		Set<String> s=driver.getWindowHandles();
		Iterator<String> it= s.iterator();
		String parentWindow=it.next();
		String childWindow=it.next();
		System.out.println("now i am in parent window/n"+driver.findElement(By.cssSelector("div[class='example'] h3")).getText());
		driver.switchTo().window(childWindow);
		System.out.println("now i am in child window/n"+driver.findElement(By.cssSelector("div[class='example'] h3")).getText());
		
		driver.switchTo().window(parentWindow);
		System.out.println("now i am in parent window/n"+driver.findElement(By.cssSelector("div[class='example'] h3")).getText());
	}

}
