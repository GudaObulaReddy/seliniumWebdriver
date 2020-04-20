package com.Selinium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Calenders {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramakrishna\\Desktop\\chromedriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Clicking on round Trip
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		Thread.sleep(3000);
	// Clicking back to One Way
	driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
	Thread.sleep(3000);
	//click on from box
	driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click();
	// taking list of all from list
	List<WebElement> list=driver.findElements(By.cssSelector(".dropdownDiv ul li a"));
	String s="Ajmer (KQH)";
	// selecting from one
	for(WebElement element:list)
	{
		System.out.println(element.getText());
		if(element.getText().trim().equals(s))
		{
			
	         element.click();
	         break;
		}
	}
		Thread.sleep(2000);
	// selecting to one
	List<WebElement> list1=driver.findElements(By.cssSelector(".dropdownDiv ul li a"));
	String s1="Delhi (DEL)";
	for(WebElement element:list1)
	{
		System.out.println(element.getText());
		if(element.getText().trim().equals(s1))
		{
			
	         element.click();
	         break;
		}
	}
	Thread.sleep(2000);
	// taking month picker
	List<WebElement> months=driver.findElements(By.cssSelector(".ui-datepicker-month"));
	String month11="December";
	String date="15";
	//taking all dates of first table
	List<WebElement> date1=driver.findElements(By.xpath("//div[@class=\"ui-datepicker-group ui-datepicker-group-first\"]//td[@data-handler=\"selectDay\"]"));
	int size2=date1.size();
	// taking dates of second table
	List<WebElement> date2=driver.findElements(By.xpath("//div[@class=\"ui-datepicker-group ui-datepicker-group-last\"]//td[@data-handler=\"selectDay\"]"));
	int size3=date2.size();
	// checking first table side month and selecting the particular date
	if(months.get(0).getText().contains(month11))
	{
		for(int i=0;i<size2;i++)
		{
			if(date1.get(i).getText().equalsIgnoreCase(date))
			{
				date1.get(i).click();
				break;
			}
		}
	}
	// checking second table side month and selecting the particular date
	else if(months.get(1).getText().contains(month11))
	{
		for(int i=0;i<size3;i++)
		{
			if(date2.get(i).getText().equalsIgnoreCase(date))
			{
				date2.get(i).click();
				break;
			}
		}
	}
	// checking any month and selecting the particular date
	else
	{
		while (!driver.findElements(By.cssSelector(".ui-datepicker-month")).get(1).getText()
				.contains(month11)) {
			driver.findElement(By.cssSelector(".ui-icon.ui-icon-circle-triangle-e")).click();
			Thread.sleep(3000);
		}
		List<WebElement> date4=driver.findElements(By.xpath("//div[@class=\"ui-datepicker-group ui-datepicker-group-last\"]//td[@data-handler=\"selectDay\"]"));
		int size4=date2.size();
		for(int i=0;i<size4;i++)
		{
			if(date4.get(i).getText().equalsIgnoreCase(date))
			{
				date4.get(i).click();
				break;
			}
		
	}}
	Thread.sleep(2000);
	// clicking on search
	driver.findElement(By.xpath("//input[@name=\"ctl00$mainContent$btn_FindFlights\"]")).click();
	}
}
