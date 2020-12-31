package com.unipro.test.page_objects.unixpro;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.unipro.test.framework.PageObject;



public class AddInventoryForm extends PageObject{
	private By menu_invoke_element = By.cssSelector("a.dropdown-toggle");
	
	public WebElement return_dd_invoke_element(String defaultText, int indextoInvoke) {

		List<WebElement> listofHref = getWebDriver().findElements(menu_invoke_element);
		WebElement menu_invoke_ele = listofHref.get(indextoInvoke);
		System.out.println();
		if (menu_invoke_ele.getAttribute("text").equalsIgnoreCase(defaultText)) {
			// System.out.println(" Matching with default Value");
		}
		// textToBePresentInElementValue(menu_invoke_ele,defaultText );
		return menu_invoke_ele;
	}

}
