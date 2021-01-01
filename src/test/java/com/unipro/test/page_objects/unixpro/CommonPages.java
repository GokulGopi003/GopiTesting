package com.unipro.test.page_objects.unixpro;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.unipro.test.framework.PageObject;

public class CommonPages extends PageObject {

	public void clickonButton(String buttonName) {

		WebElement button = waitForExpectedElement(
				By.cssSelector("a#ContentPlaceHolder1_lnk" + buttonName + ".button-red"));

		button.click();

	}
	
	public void clickonBlueButton(String buttonName) {

		WebElement button = waitForExpectedElement(
				By.cssSelector("input#ContentPlaceHolder1_btn" + buttonName + ".button-blue"));

		button.click();

	}
	
	public void clickonFilterButton(String buttonName) {

		WebElement button = waitForExpectedElement(
				By.cssSelector("a#ContentPlaceHolder1_searchFilterUserControl_lnk" + buttonName + ".button-red"));

		button.click();

	}
	
	public void clickonButton_Dynamic(String buttonName) {

		WebElement button = waitForExpectedElement(
				By.cssSelector("a#ContentPlaceHolder1_lnk" + buttonName));

		button.click();

	}

	public void clickonElement(String element) {

		waitForExpectedElement(By.cssSelector(element)).click();

	}
	
	
	public void clickOnElementByIndex(String ele,int index) {

		List<WebElement> elementslist = elements(By.cssSelector(ele));
		WebElement element = elementslist.get(index);

		visibilityOf(element);
		System.out.println(element.getText());
		element.click();

	}

	public void confirmDelete(String ele) {

		List<WebElement> elementslist = elements(By.cssSelector(ele));
		WebElement element = elementslist.get(7);

		visibilityOf(element);
		System.out.println(element.getText());
		element.click();

	}
	
	
	
	public void clickon_element_inAlertBox(String element) {

		WebElement button = waitForExpectedElement(
				By.cssSelector( element));
		button.click();

	}

	public WebElement js_waitAndTypeTextinsideTextBox(String valueToSearch, String forElement) {

		String css_location_dropDownValue =forElement ;
		By textlocator = By.cssSelector(css_location_dropDownValue);
		waitForExpectedElement(textlocator);
		js_typeIntoDropDownSearchBox(css_location_dropDownValue, valueToSearch);

		return waitForExpectedElement(textlocator);

	}

	public void clickUsingButtonTag(String buttonName) {
		try {
			List<WebElement> weList = getWebDriver().findElements(By.tagName("button"));
			for (Iterator iterator = weList.iterator(); iterator.hasNext();) {
				WebElement button = (WebElement) iterator.next();
				if (button.getText().equalsIgnoreCase(buttonName)) {
					button.click();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


}
