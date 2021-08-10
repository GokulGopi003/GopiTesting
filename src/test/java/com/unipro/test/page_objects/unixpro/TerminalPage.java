package com.unipro.test.page_objects.unixpro;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.unipro.test.framework.PageObject;

public class TerminalPage extends PageObject {

	private By new_button = By.cssSelector("a#ContentPlaceHolder1_lnkNew.button-blue");

	private String css_location_dropDownValue = "#ContentPlaceHolder1_ddlLocation_chzn > div > div > input[type=text]";

	private By location_dropDownValue = By
			.cssSelector("#ContentPlaceHolder1_ddlLocation_chzn > div > div > input[type=text]");
	private By ddlFloor = By.cssSelector("#ContentPlaceHolder1_ddlFloor_chzn > div > div > input[type=text]");

	private By dd_invoke_element = By.cssSelector("a.chzn-single");

	private By terminal_System_name = By.cssSelector("input#ContentPlaceHolder1_txtSysName.form-control-res");

	public WebElement return_new_button() {

		getWebDriver().manage().window().maximize();

		return waitForExpectedElement(new_button);
	}

	public WebElement return_dd_invoke_element(String defaultText, int indextoInvoke) {

		List<WebElement> listofDD = getWebDriver().findElements(dd_invoke_element);
		WebElement dd_invoke_ele = listofDD.get(indextoInvoke);
		System.out.println();
		if (dd_invoke_ele.getAttribute("text").equalsIgnoreCase(defaultText)) {
			// System.out.println(" Matching with default Value");
		}
		// textToBePresentInElementValue(dd_invoke_ele,defaultText );
		return dd_invoke_ele;
	}

	public WebElement waitAndSelectDropDownUsingSerachBox(String valueToSearch, String forLabel) {

		String css_location_dropDownValue = "#ContentPlaceHolder1_ddl" + forLabel
				+ "_chzn > div > div > input[type=text]";
		By ddlocator = By.cssSelector(css_location_dropDownValue);
		waitForExpectedElement(ddlocator);
		js_typeIntoDropDownSearchBox(css_location_dropDownValue, valueToSearch);

		return waitForExpectedElement(ddlocator);

	}

	public WebElement SelectDropDownUsingSerachBox(String valueToSearch, String forLabel) {

		String css_location_dropDownValue = "#ContentPlaceHolder1_DropDown" + forLabel
				+ "_chzn > div > div > input[type=text]";
		By ddlocator = By.cssSelector(css_location_dropDownValue);
		waitForExpectedElement(ddlocator);
		js_typeIntoDropDownSearchBox(css_location_dropDownValue, valueToSearch);

		return waitForExpectedElement(ddlocator);

	}
	public WebElement waitAndSelectDropDownUsingSerachBox_Dynamic(String valueToSearch, String forElement) {

		By ddlocator = By.cssSelector(forElement);
		waitForExpectedElement(ddlocator);
		js_typeIntoDropDownSearchBox(forElement, valueToSearch);

		return waitForExpectedElement(ddlocator);

	}

	public void selectingDropDownUsingSerachBox(String valueToSearch) {

		waitForExpectedElement(location_dropDownValue);

		js_typeIntoDropDownSearchBox(css_location_dropDownValue, valueToSearch);

	}

	public WebElement retrun_location_dropDownValue() {

		return waitForExpectedElement(location_dropDownValue);

	}

	public void type_terminal_system_name(String name) {

		waitClearEnterText(terminal_System_name, name);

	}

	public WebElement terminal_waitClearEnterText_css(String webele, String textToEnter) {

		By terminal_System_name = By.cssSelector(webele);
		//waitForExpectedElement(By.cssSelector(webele));
		 waitClearEnterText(terminal_System_name, textToEnter);
		//setTypeAheadValueOnElement(waitForExpectedElement(By.cssSelector(webele)), textToEnter);
		return null;

	}
	public WebElement terminal_waitClearEnterKey(String webele, String textToEnter) {

		By terminal_System_name = By.cssSelector(webele);
		//waitForExpectedElement(By.cssSelector(webele));
		webDriver.findElement(By.cssSelector(webele)).sendKeys(Keys.valueOf(textToEnter));
		
		//setTypeAheadValueOnElement(waitForExpectedElement(By.cssSelector(webele)), textToEnter);
		return null;

	}

	public WebElement get_checkBox_element(String webele) {

		By checkBoxElement = By.cssSelector(webele);

		return waitForExpectedElement(checkBoxElement);

	}

	public WebElement get_radioButton_element(String webele) {

		By radioButtonElement = By.cssSelector(webele);

		return waitForExpectedElement(radioButtonElement);

	}

}
