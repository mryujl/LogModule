package com.my.testcase;

import static org.junit.Assert.*;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.google.common.io.Files;

public class OpenUrl {
	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "https://www.sina.com.cn/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}
	
	@Test
	public void openUrl() throws Exception {
		driver.get(baseUrl);
		driver.manage().window().maximize();
		Assert.assertEquals(driver.getCurrentUrl(), baseUrl);
		Thread.sleep(2000);
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}
	
	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	public void keyboardString(final String text) {
	    if (text != null) {
	        try {
	            final Robot robot = new Robot();
	            for (int i = 0; i < text.length(); i++) {
	                final char ch = text.charAt(i);
	                final boolean upperCase = Character.isUpperCase(ch);
	                final int keyCode = KeyEvent.getExtendedKeyCodeForChar(ch);
	                robot.delay(10);
	                if (upperCase) {
	                    robot.keyPress(KeyEvent.VK_SHIFT);
	                }
	                robot.keyPress(keyCode);
	                robot.keyRelease(keyCode);
	                if (upperCase) {
	                    robot.keyRelease(KeyEvent.VK_SHIFT);
	                }
	            }
	} catch (final Exception e) {
	            System.out.println(e);
	        }
	    }
	}
	
	public void cutPic(String imgName, String path, String type){
		File screenshot = ((RemoteWebDriver) driver).getScreenshotAs(OutputType.FILE);
		try {
			Files.copy(screenshot, new File(path + "/" + imgName + "." + type));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void cutPic2(String imgName, String path, String type) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rectangle = new Rectangle(screenSize);
		try {
			Robot robot = new Robot();
			BufferedImage image = robot.createScreenCapture(rectangle);
			ImageIO.write(image, type, new File(path + "/" + imgName + "." + type));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}