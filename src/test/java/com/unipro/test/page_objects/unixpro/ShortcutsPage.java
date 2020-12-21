package com.unipro.test.page_objects.unixpro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.unipro.test.framework.PageObject;
import com.unipro.test.framework.helpers.Props;

public class ShortcutsPage extends PageObject {

	public void getGRN_URL(String url) {
		getWebDriver().navigate().to(url);
	}

	public WebElement returnnGoButton() {
	

		return elementToBeClickable(By.cssSelector("input#ContentPlaceHolder1_rptrGA_btnGrn_0"));
		
		

	}

}
