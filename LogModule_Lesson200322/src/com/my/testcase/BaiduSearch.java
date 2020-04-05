package com.my.testcase;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BaiduSearch {
	private WebDriver driver;
	// HtmlFile hf = null;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		// hf = new HtmlFile();
		// hf.createLog("D:/testBaidu_log.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}

	@Test
	public void baiduSearchTest() throws Exception {
		driver.get("https://www.baidu.com/");
		driver.findElement(By.id("kw")).click();
		driver.findElement(By.id("kw")).clear();
		driver.findElement(By.id("kw")).sendKeys("selenium");
		driver.findElement(By.id("su")).click();
		Thread.sleep(2000);
		String resultText = driver.findElement(By.xpath("//span[@class='nums_text']")).getAttribute("textContent");
		// String resultText =
		// driver.findElement(By.xpath("//span[@class='nums_text']")).getText();
		System.out.println(resultText);
		// 检查点：验证是否搜索出结果
		isContainsText(By.xpath("//span[@class='nums_text']"), "百度为您找到相关结果约");
		// hf.write("百度搜索测试", true,
		// isContainsText(By.xpath("//span[@class='nums_text']"), "百度为您找到相关结果约"));
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		// hf.closeLog();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isContainsText(By by, String expectText) {
		try {
			WebElement element = driver.findElement(by);
			String actualText = element.getAttribute("textContent");
			if (actualText.contains(expectText)) {
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
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

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}