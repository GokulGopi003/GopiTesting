package com.unipro.test.page_objects.unixpro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.unipro.test.framework.PageObject;
import com.unipro.test.framework.helpers.Props;

public class View_GRN_Maintanence_Page  extends PageObject {

	//input#ContentPlaceHolder1_txtItemCode.form-control-res

	private By code_search = By.cssSelector("input#ContentPlaceHolder1_txtItemCode");
	
	public void enterSearchCodeValue(String string) {
		
		
		waitClearEnterText(code_search, string);
	}
	
}
