package com.unipro.test.page_objects.unixpro;

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

	public void clickonElement(String element) {

		waitForExpectedElement(By.cssSelector(element)).click();

	}

	public void confirmDelete(String ele) {

		List<WebElement> elementslist = elements(By.cssSelector(ele));
		WebElement element = elementslist.get(7);

		visibilityOf(element);
		System.out.println(element.getText());
		element.click();

	}

}
