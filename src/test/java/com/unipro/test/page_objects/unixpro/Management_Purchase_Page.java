package com.unipro.test.page_objects.unixpro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.unipro.test.framework.PageObject;

public class Management_Purchase_Page extends PageObject {

	private By Vendor_Search = By.cssSelector("#txtSearch");

	public By search_box_vendor = By.cssSelector("input#txtSearch");

	public WebElement Management_Vendor_Search() {
		return waitForExpectedElement(Vendor_Search);

	}
	
	

	public WebElement return_search_box_vendor_element() {
		

		return waitForExpectedElement(search_box_vendor);
	}
}
