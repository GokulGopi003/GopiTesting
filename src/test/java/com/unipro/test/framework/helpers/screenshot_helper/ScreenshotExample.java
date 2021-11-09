package com.unipro.test.framework.helpers.screenshot_helper;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.assertj.core.api.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver.SystemProperty;

import com.unipro.test.framework.PageObject;
import com.unipro.test.framework.helpers.WebDriverHelper;

public class ScreenshotExample extends PageObject {
	

		public static void main(String[] args){
		
		   System.setProperty("webdriver.chrome.driver",
					"tools/chromedriver/mac64/chromedriver 3");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.in/");
		String title=driver.getTitle();
		System.out.println("title"+title);
		

		String screenshotname = title;
		try {
			TakesScreenshot tsc = (TakesScreenshot) driver;

			File source = tsc.getScreenshotAs(OutputType.FILE);
			

			FileUtils.copyFile(source, new File("./Screenshots/" + screenshotname + ".png"));

			System.out.println("Screenshot captured  " + screenshotname.getBytes());
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
		

		}

}