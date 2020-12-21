package com.unipro.test.page_objects.unixpro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.unipro.test.framework.PageObject;
import com.unipro.test.framework.helpers.Props;

public class Masters_CategoryAtttributeMapping_Page extends PageObject {
	private By clearButton = By.cssSelector("a#ContentPlaceHolder1_lnkClear.button-red");
	private By product_NameElement = By.cssSelector("#ContentPlaceHolder1_ddlCategory_chzn > a > span");

	
	
	private By search_producttypeElement = By.cssSelector("li#ContentPlaceHolder1_ddlCategory_chzn_o_6.active-result");
	private By productCost = By.cssSelector("input#ContentPlaceHolder1_txtProductCost.form-control-res");
	private By micileaniousCost = By.cssSelector("input#ContentPlaceHolder1_txtMiscelenious.form-control-res");

	
	
	private By margin = By.cssSelector("input#ContentPlaceHolder1_txtMargin.form-control-res");
	private By inputSize = By.cssSelector("input#SIZE");
	private By inputColor = By.cssSelector("input#COLOR");
	private By inputDesign = By.cssSelector("input#DESIGN");
	private By inputStyle = By.cssSelector("input#STYLE");

	public void get_Masters_CategoryAtttributeMapping_Url(String url) {
		WebDriver driver = getWebDriver();
		driver.navigate().to(url);
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());

	}

	public WebElement get_clearButton() {

		return waitForExpectedElement(clearButton);
	}

	public WebElement product_NameElement() {

		return waitForExpectedElement(product_NameElement);

	}

	public WebElement get_DropDownSearchValue() {

		return waitForExpectedElement(search_producttypeElement);

	}

	public void get_productCost(String string) {
		waitClearEnterText(productCost, string);
	}

	public void get_Miscelanious(String string) {
		waitClearEnterText(micileaniousCost, string);
	}

	public void get_Margin(String string) {
		waitClearEnterText(margin, string);
	}

	public void select_AttributeName(String string) {
		// SIZE|COLOR|DESIGN

		String[] arrtribute_array = string.split("-");

		for (int i = 0; i < arrtribute_array.length; i++) {
			
			
			switch (arrtribute_array[i]) {

			case "SIZE":

				elementToBeClickable(inputSize).click();

				break;
			case "COLOR":

				elementToBeClickable(inputColor).click();

				break;
				
			case "DESIGN":

				elementToBeClickable(inputDesign).click();

				break;
				
			case "STYLE":

				elementToBeClickable(inputStyle).click();

				break;

			default:
				System.out.println(" we are not selecting any attribute" +arrtribute_array[i]);
				break;
			}

		}

	}

}
