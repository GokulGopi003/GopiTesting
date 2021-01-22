package com.unipro.test.page_objects.unixpro;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.unipro.test.framework.PageObject;

public class Purchase_Order_Page extends PageObject {

	// tr.pshro_GridDgnStyle.tbl_left

	private By purchase_order_items = By.cssSelector("a.dropdown-toggle");

	public void clickOntheElementBytext(String locator, String indextoInvoke) {

		List<WebElement> listofHref = getWebDriver().findElements(By.cssSelector(locator));

		for (WebElement webElement : listofHref) {

			if (webElement.getText().contains(indextoInvoke)) {
				webElement.click();
			}

		}
	}

	public void double_clickOntheElementBytext(String locator, String indextoInvoke) {

		WebDriver driver = getWebDriver();
		
		
//		List<WebElement> listofHref = driver.findElements(By.cssSelector(locator));
//		
//	
//
//		for (WebElement webElement : listofHref) {
//			System.out.println("Double click on the webelement"+ webElement.getText());
//			if (webElement.getText().contains(indextoInvoke)) {
//				System.out.println(webElement.getText());
//				Actions action = new Actions(driver);
//				action.doubleClick(webElement).perform();
//			
//			}
//
//		}
		
		
		
//		
		
	}

}
