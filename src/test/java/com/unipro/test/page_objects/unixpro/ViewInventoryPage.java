package com.unipro.test.page_objects.unixpro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.unipro.test.framework.PageObject;
import com.unipro.test.framework.helpers.Props;

public class ViewInventoryPage extends PageObject {

	private By searchelement_viewInventory = By.cssSelector("input#ContentPlaceHolder1_txtSearch.TextboxSize");
	private By searchButtonElement_viewInventory = By.cssSelector("a#ContentPlaceHolder1_lnkSearchGrid.button-blue");
	private By editIcon_viewInventory = By.cssSelector("input#ContentPlaceHolder1_grdInventoryList_imgbtnEdit_0");




	public void search_viewInventory(String searchText) {

		waitClearEnterText(searchelement_viewInventory, searchText);

	}

	public WebElement retrun_searchButton_viewInventory() {

		return elementToBeClickable(searchButtonElement_viewInventory);

	}
	
	public WebElement retrun_editIcon_viewInventory() {

		return elementToBeClickable(editIcon_viewInventory);
		

	}
	
	public String get_Current_Tile() {
		
			return getCurrentPageTitle();
	}

}
