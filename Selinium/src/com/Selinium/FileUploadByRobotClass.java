package com.Selinium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FileUploadByRobotClass {

	public static void main(String[] args) throws AWTException, InterruptedException 
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramakrishna\\Desktop\\chromedriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://blueimp.github.io/jQuery-File-Upload/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebDriverWait wait;
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn.btn-success.fileinput-button")));
		driver.findElement(By.cssSelector(".btn.btn-success.fileinput-button")).click();
		String filePath = "C:\\Users\\Ramakrishna\\screen.jpg";
		StringSelection selection = new StringSelection(filePath);// Give the path detail to the program and ready for		
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(selection, null);// Transfers the path into clipboard
			Robot robot = new Robot();
			robot.delay(2000);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyPress(KeyEvent.VK_ENTER);
			// Uploading Image
			Thread.sleep(4000);
			driver.findElement(By.cssSelector("tr[class='template-upload fade in'] td:nth-child(4) button:nth-child(2)"))
					.click();
			Thread.sleep(8000);
			//Checking for successful Upload
			if (driver.findElement(By.cssSelector("tr[class='template-download fade in'] td:nth-child(4) button"))
					.isDisplayed()) {
				System.out.println("Upload Success");	
				
			}
	}

}
