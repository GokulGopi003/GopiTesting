package com.unipro.test.page_objects.unixpro;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.unipro.test.framework.PageObject;



public class AddInventoryFormPage extends PageObject{
	private By menu_invoke_element = By.cssSelector("a.dropdown-toggle");
	private By sub_menu_invoke_element = By.cssSelector("a");
	private By td_invoke_element = By.cssSelector("td");
	private By table_element = By.cssSelector("div.search-table");
	private By selling_price_element = By.cssSelector("input#ContentPlaceHolder1_imgPriceChange");
	
	
	public WebElement return_menu_invoke_element(String defaultText) {
		
		//js_typeIntoDropDownSearchBox("a.dropdown-toggle", "Inventory");
		WebElement menu_invoke_ele = null;

		List<WebElement> listofHref = getWebDriver().findElements(menu_invoke_element);
		for(Iterator iter =listofHref.iterator(); iter.hasNext();) {
			WebElement webElement = (WebElement) iter.next();
			if(webElement.getText().equalsIgnoreCase(defaultText)) {
				
			visibilityOf(webElement);
			elementToBeClickable(webElement);
			menu_invoke_ele = webElement;
			//System.out.println("Matching with default Value");
			return menu_invoke_ele;
			} else {
				// System.out.println("Text did not Match with default Value");
			}
		}
		return menu_invoke_ele;
		
	}
	public WebElement return_td_invoke_element(String defaultText) {
		
		//js_typeIntoDropDownSearchBox("a.dropdown-toggle", "Inventory");
		WebElement table_invoke_ele = null;
		List<WebElement> listofHref = getWebDriver().findElements(td_invoke_element);
		for(Iterator iter =listofHref.iterator(); iter.hasNext();) {
			WebElement webElement = (WebElement) iter.next();
			if(webElement.getText().equalsIgnoreCase(defaultText)) {
			visibilityOf(webElement);
			elementToBeClickable(webElement);
			table_invoke_ele = webElement;
			//System.out.println("Matching with default Value");
			return table_invoke_ele;
			} else {
				 //System.out.println("Text did not Match with default Value");
			}
		}
		return table_invoke_ele;
		
	}
	
	//fetch data from search table
	// Grab the table
	//get table 1st data in a table automatically
	
	public WebElement getTableData(String childtable) {
		// WebElement table = getWebDriver().findElement(table_element);
		//WebElement table = getWebDriver()
		//		.findElement(By.cssSelector("table#ContentPlaceHolder1_grdBulkItem.pshro_GridDgn.grdLoad"));
		
		WebElement table;
		
		if (childtable.equalsIgnoreCase("Child")) {
			table = getWebDriver()
					.findElement(By.cssSelector("table#ContentPlaceHolder1_grdChildItem.pshro_GridDgn.grdLoad"));
		} else if(childtable.equalsIgnoreCase("Distribution")){
			
			//not completed
			//not working
			
			//table = getWebDriver().findElement(By.cssSelector("table#ContentPlaceHolder1_grdDistributionlist.pshro_GridDgn"));
			
			table= getWebDriver().findElement(By.xpath("//*[@id="+"ContentPlaceHolder1_grdDistributionlist"+"]/tbody/tr[1]/td[1]/input[type=button]"));
			//*[@id="ContentPlaceHolder1_grdDistributionlist"]/tbody/tr[1]/td[3]/input
			
		} else {
			 table = getWebDriver()
						.findElement(By.cssSelector("table#ContentPlaceHolder1_grdBulkItem.pshro_GridDgn.grdLoad"));
		}

		// Now get all the TR elements from the table
		List<WebElement> allRows = table.findElements(By.tagName("tr"));
		// And iterate over them, getting the cells
		for (WebElement row : allRows) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			for (WebElement cell : cells) {
				// System.out.println("content >> " + cell.getText());
				// cell.getText();
				if (childtable.equalsIgnoreCase("Child")) {
					if (cell.getText() != null) {
						return cell;
					}
				} else {
					return cell;
				}
			}
		}
		return null;
	}
	
	
	public void inventory_waitClearEnterText_css(String webele, String textToEnter) {

		By inventory_by = By.cssSelector(webele);
		waitClearEnterText(inventory_by, textToEnter);

	}
	
	//image menu upload
	public WebElement return_submenu_invoke_element(String defaultText) {

		
		WebElement menu_invoke_ele = null;

		List<WebElement> listofHref = getWebDriver().findElements(sub_menu_invoke_element);
		for (Iterator iter = listofHref.iterator(); iter.hasNext();) {
			WebElement webElement = (WebElement) iter.next();
			if (webElement.getText().equalsIgnoreCase(defaultText)) {
				visibilityOf(webElement);
				elementToBeClickable(webElement);
				menu_invoke_ele = webElement;
				// System.out.println("Matching with default Value");
				return menu_invoke_ele;
			} else {
				// System.out.println("Text did not Match with default Value");
			}
		}
		return menu_invoke_ele;

	}

}
