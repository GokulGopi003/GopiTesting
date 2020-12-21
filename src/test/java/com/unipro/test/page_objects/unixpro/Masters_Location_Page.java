package com.unipro.test.page_objects.unixpro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.unipro.test.framework.PageObject;


public class Masters_Location_Page extends PageObject {
	private By Location_Code = By.cssSelector("#ContentPlaceHolder1_txtLocCode");
	private By Location_Name = By.cssSelector("#ContentPlaceHolder1_txtLocName");
	private By incharge_Name = By.cssSelector("#ContentPlaceHolder1_txtIncharge");
	private By ShortCode = By.cssSelector("#ContentPlaceHolder1_txtSortCode");
	private By warehouseElement = By.cssSelector("#ContentPlaceHolder1_chkWareHouse");
	private By warehouse_search = By.cssSelector("#ContentPlaceHolder1_ddlWareHouse_chzn");
	private By warehouse_NameElement = By.cssSelector("#ContentPlaceHolder1_ddlWareHouse_chzn_o_2");
	private By save_button = By.cssSelector("#ContentPlaceHolder1_lnkSave");

	public void get_Masters_location_Url(String url) {
		WebDriver driver = getWebDriver();
		driver.navigate().to(url);
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());

	}

	public WebElement Location_Code() {
		return waitForExpectedElement(Location_Code);

	}

	public WebElement Location_Name() {
		return waitForExpectedElement(Location_Name);

	}

	// sendke
	public void type_inchargeName(String inchName) {

		waitClearEnterText(incharge_Name, inchName);
	}

	public void ShortCode(String shortcode) {

		waitClearEnterText(ShortCode, shortcode);
	}

	public WebElement get_warehouse() {

		return waitForExpectedElement(warehouseElement);
	}

	public WebElement get_WarehouseSearch() {

		return waitForExpectedElement(warehouse_search);

	}

	public WebElement get_Warehouse_Search_Name() {

		return waitForExpectedElement(warehouse_NameElement);
	}

	public WebElement get_save_button() {

	   return waitForExpectedElement(save_button);
}
}
