package com.Selinium;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.gargoylesoftware.htmlunit.javascript.host.html.Image;

public class TakeScreenShotAnotherWay {

	public static void main(String[] args) throws AWTException, IOException 
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramakrishna\\Desktop\\chromedriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Robot robot1=new Robot();
		Dimension size=Toolkit.getDefaultToolkit().getScreenSize();
		BufferedImage img=robot1.createScreenCapture(new Rectangle(size));
		File path=new File("C:\\Users\\Ramakrishna\\screen.jpg");
		ImageIO.write(img, "JPG", path);
		System.out.println("image captured sucessufflly");
		
	}

}
