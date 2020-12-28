package com.unipro.test.step_definitions.unixpo;

import org.openqa.selenium.By;

import com.unipro.test.page_objects.unixpro.AddInventoryFormPage;

import cucumber.api.java.en.Then;

public class AddInventoryFormSteps {
	
	AddInventoryFormPage add_inventory;
	
	
	public AddInventoryFormSteps(AddInventoryFormPage add_inventory) {
		this.add_inventory = add_inventory;
	}
	
	@Then("I need to click on Inventory menu with text matching {string}")
	public void i_need_to_click_on_Inventory_menu_with_text_matching(String string) throws InterruptedException {
		
			Thread.sleep(3000);
			add_inventory.return_menu_invoke_element(string).click();
			Thread.sleep(2000);
		    //add_inventory.js_typeIntoDropDownSearchBox(string, int1);
		
	}
	/*@Then("I need to invoke the DropDown by Index {int} if text matching {string}")
	public void i_need_to_invoke_the_DropDown_by_Index_if_text_matching(Integer index, String string) {

		add_inventory.return_dd_invoke_element(string, index).click();
	}*/
	
	
	@Then("I need to click on Category with text matching {string}")
	public void i_need_to_click_on_Category_with_text_matching(String string) throws InterruptedException {
		Thread.sleep(3000);
			add_inventory.return_td_invoke_element(string).click();
			//add_inventory.getTableData().click();
		    //add_inventory.js_typeIntoDropDownSearchBox(string, int1);
		
	}
	@Then("I need to click on Brand with text matching {string}")
	public void i_need_to_click_on_Brand_with_text_matching(String string) throws InterruptedException {
		Thread.sleep(3000);
			add_inventory.return_td_invoke_element(string).click();
			//add_inventory.getTableData().click();
		    //add_inventory.js_typeIntoDropDownSearchBox(string, int1);
		
	}
	@Then("I need to click on Short Name forElement {string}")
	public void i_need_to_click_on_Short_Name_forElement(String string) throws InterruptedException {		
			add_inventory.elementToBeClickable(By.cssSelector(string)).click();
			Thread.sleep(3000);
			//return_td_invoke_element(string).click();
			
		    //add_inventory.js_typeIntoDropDownSearchBox(string, int1);
		
	}
	
	@Then("I need to click on Item Type with text matching {string}")
	public void i_need_to_click_on_Item_Type_with_text_matching(String string) throws InterruptedException {
		Thread.sleep(3000);
			add_inventory.return_td_invoke_element(string).click();
		//get table 1st data in a table automatically 
			//add_inventory.getTableData().click();
			Thread.sleep(2000);
			
		    //add_inventory.js_typeIntoDropDownSearchBox(string, int1);
		
	}
	@Then("I need to click on Vendor with text matching {string}")
	public void i_need_to_click_on_IVendor_with_text_matching(String string) throws InterruptedException {
			add_inventory.return_td_invoke_element(string).click();
			//add_inventory.getTableData().click();
			Thread.sleep(2000);
			
		    //add_inventory.js_typeIntoDropDownSearchBox(string, int1);
	}
	
	@Then("I need to click on Open Selling Detail forElement {string}")
		public void i_need_to_click_on_Open_Selling_Detail_forElement(String string) throws InterruptedException {	
		
		add_inventory.elementToBeClickable(By.cssSelector(string)).click();
		Thread.sleep(3000);		
				//return_td_invoke_element(string).click();
			    //add_inventory.js_typeIntoDropDownSearchBox(string, int1);
			
		}
	@Then("I need to click on IGST DropDown forElement {string}")
	public void i_need_to_click_on_IGST_DropDown_forElement(String string) throws InterruptedException {	
		add_inventory.elementToBeClickable(By.cssSelector(string)).click();
		Thread.sleep(3000);
		}
	@Then("I need to click on IGST search forElement {string}")
	public void i_need_to_click_on_IGST_search_forElement(String string) throws InterruptedException {	
	add_inventory.elementToBeClickable(By.cssSelector(string)).click();
	Thread.sleep(3000);		
		
	}
	@Then("I need to click on IGST value forElement {string}")
	public void i_need_to_click_on_IGST_value_forElement(String string) throws InterruptedException {	
	add_inventory.elementToBeClickable(By.cssSelector(string)).click();
	Thread.sleep(3000);		
	}
	
	@Then("I enter the HSN code forElement {string} as {string}")
	public void i_enter_the_HSN_code_forElement_as(String webele, String textToType) throws InterruptedException {
		Thread.sleep(3000);

		add_inventory.inventory_waitClearEnterText_css(webele, textToType);
		Thread.sleep(2000);
	}
	@Then("I enter the MRP forElement {string} as {string}")
	public void i_enter_the_MRP_forElement_as(String webele, String textToType) throws InterruptedException {
		//add_inventory.elementToBeClickable(By.cssSelector(webele)).click();
		add_inventory.inventory_clearEnterText_css(webele, textToType);
		Thread.sleep(2000);
	}
	@Then("I enter the Basic Cost forElement {string} as {string}")
	public void i_enter_the_Basic_Cost_forElement_as(String webele, String textToType) throws InterruptedException {
		//add_inventory.elementToBeClickable(By.cssSelector(webele)).click();
		add_inventory.inventory_clearEnterText_css(webele, textToType);
		Thread.sleep(2000);
	}
	@Then("I need to click on set price detail forElement {string}")
	public void i_need_to_click_on_set_price_detail_forElement(String string) throws InterruptedException {	
	add_inventory.elementToBeClickable(By.cssSelector(string)).click();
	Thread.sleep(3000);		
	}
}