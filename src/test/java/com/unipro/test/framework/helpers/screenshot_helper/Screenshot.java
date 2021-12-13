package com.unipro.test.framework.helpers.screenshot_helper;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.unipro.test.framework.PageObject;

public class Screenshot extends PageObject {
	public void Screenshots() throws Exception {
	TakesScreenshot tsc = (TakesScreenshot) webDriver;
	File source = tsc.getScreenshotAs(OutputType.FILE);
	String screenshotname = webDriver.getCurrentUrl();
	File DestFile=new File("./Screenshots/" + screenshotname + ".png");
	FileUtils.copyFile (source,DestFile);
	//System.out.println("Screenshot captured  " + screenshotname.getBytes());
	}

}
