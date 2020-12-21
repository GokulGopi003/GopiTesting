package com.unipro.test.page_objects.unixpro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.unipro.test.framework.PageObject;


public class Masters_Sales_SalesMan_Master_Page extends PageObject {
	private By salesman_id = By.cssSelector("#ContentPlaceHolder1_txtSalesManID");
	private By employee_code = By.cssSelector("#ContentPlaceHolder1_txtEmployeeCode");
	private By salesman_name = By.cssSelector("#ContentPlaceHolder1_txtSalesManName");
	private By salesman_commission = By.cssSelector("#ContentPlaceHolder1_txtCommission");

	public void get_Masters_location_Url(String url) {
		WebDriver driver = getWebDriver();
		driver.navigate().to(url);
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
	}

	public WebElement get_SaleMan_ID() {
		return waitForExpectedElement(salesman_id);

	}

	public WebElement get_Employee_Code(String string) {
		return waitForExpectedElement(employee_code);

	}

	public WebElement get_SaleMan_Name(String string) {
		return waitForExpectedElement(salesman_name);

	}

	public WebElement get_SalesMan_Commission(String num) {
		return waitForExpectedElement(salesman_commission);

	}

}
