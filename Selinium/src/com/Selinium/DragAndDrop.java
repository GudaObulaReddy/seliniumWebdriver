package com.Selinium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) 
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramakrishna\\Desktop\\chromedriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		Actions act=new Actions(driver);
		
		List l=driver.findElements(By.xpath("//div[@class='dragableBoxRight']"));
		for(int i=1;i<=l.size();i++)
		{
			System.out.println("//div[@id='box"+i+"']");
		//act.clickAndHold(driver.findElement(By.xpath("//div[@id='box"+i+"']"))).moveToElement(driver.findElement(By.xpath("//div[@id='box10"+i+"']"))).release().build().perform();
		act.dragAndDrop(driver.findElement(By.xpath("//div[@id='box"+i+"']")), driver.findElement(By.xpath("//div[@id='box10"+i+"']"))).release().build().perform();
		}
	}

}
