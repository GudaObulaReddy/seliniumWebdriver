package com.Selinium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedFrames {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramakrishna\\Desktop\\chromedriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/frames");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("a[href=\"/nested_frames\"]")).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//frameset[@frameborder='1']/frame[@name=\"frame-top\"]")));
		driver.switchTo().frame(driver.findElement(By.xpath("//frameset[@name=\"frameset-middle\"]/frame[1]")));
		
		System.out.println(driver.findElement(By.xpath("/html/body")).getText());
		driver.switchTo().parentFrame();
		driver.switchTo().frame(driver.findElement(By.xpath("//frameset[@name=\"frameset-middle\"]/frame[2]")));
		System.out.println(driver.findElement(By.id("content")).getText());
		driver.switchTo().parentFrame();
		driver.switchTo().frame(driver.findElement(By.xpath("//frameset[@name=\"frameset-middle\"]/frame[3]")));
		System.out.println(driver.findElement(By.xpath("/html/body")).getText());
		driver.switchTo().parentFrame();
		driver.switchTo().parentFrame();
		driver.switchTo().frame(driver.findElement(By.xpath("//frameset[@frameborder='1']/frame[@name=\"frame-bottom\"]")));
		System.out.println(driver.findElement(By.xpath("/html/body")).getText());
		
	}

}
