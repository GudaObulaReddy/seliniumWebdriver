package com.Selinium;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinksInNewTab {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.silentOutput", "true");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramakrishna\\Desktop\\chromedriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebElement pageHead=driver.findElement(By.xpath("//*[@id=\"navFooter\"]/div[4]"));
		int footerLinksSize=pageHead.findElements(By.tagName("a")).size();
		
		 WebElement element=driver.findElement(By.xpath("//*[@id=\"navFooter\"]/div[4]"));
		 
		 pageScroll(element, driver);
		 
		System.out.println(footerLinksSize);
		for (int i = 0; i <footerLinksSize; i++) 
		{
			pageHead.findElements(By.tagName("a")).get(i).sendKeys(Keys.chord(Keys.CONTROL,Keys.ENTER));
		}
		Set<String>  winHan=driver.getWindowHandles();
		Iterator<String> it=winHan.iterator();
		while (it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
			
		}
	}
	public static void pageScroll(WebElement element,WebDriver driver) {
		 JavascriptExecutor js=((JavascriptExecutor)driver);
		  js.executeScript("arguments[0].scrollIntoView();", element);
		  
		 }
	

}
