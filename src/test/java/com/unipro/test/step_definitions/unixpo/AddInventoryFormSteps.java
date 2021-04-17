package com.unipro.test.step_definitions.unixpo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.unipro.test.page_objects.unixpro.AddInventoryFormPage;

import cucumber.api.java.en.Then;

public class AddInventoryFormSteps {
	
	AddInventoryFormPage add_inventory;
	
	
	public AddInventoryFormSteps(AddInventoryFormPage add_inventory) {
		this.add_inventory = add_inventory;
	}
	
	@Then("I need to click on Inventory menu with text matching {string}")
	public void i_need_to_click_on_Inventory_menu_with_text_matching(String string) throws InterruptedException {
		
			add_inventory.return_menu_invoke_element(string).click();
		    //add_inventory.js_typeIntoDropDownSearchBox(string, int1);
		
	}
	/*@Then("I need to invoke the DropDown by Index {int} if text matching {string}")
	public void i_need_to_invoke_the_DropDown_by_Index_if_text_matching(Integer index, String string) {

		add_inventory.return_dd_invoke_element(string, index).click();
	}*/
	
	
	@Then("I need to click on link with text matching {string}")
	public void i_need_to_click_on_link_with_text_matching(String string) throws InterruptedException {
			add_inventory.return_td_invoke_element(string).click();
			//add_inventory.getTableData().click();
		    //add_inventory.js_typeIntoDropDownSearchBox(string, int1);
		
	}
	@Then("I need to click on Brand with text matching {string}")
	public void i_need_to_click_on_Brand_with_text_matching(String string) throws InterruptedException {
			add_inventory.return_td_invoke_element(string).click();
			//add_inventory.getTableData().click();
		    //add_inventory.js_typeIntoDropDownSearchBox(string, int1);
		
	}
	@Then("I need to click on Short Name forElement {string}")
	public void i_need_to_click_on_Short_Name_forElement(String string) throws InterruptedException {		
			add_inventory.elementToBeClickable(By.cssSelector(string)).click();
			//return_td_invoke_element(string).click();
			
		    //add_inventory.js_typeIntoDropDownSearchBox(string, int1);
		
	}
	
	@Then("I need to click on Item Type with text matching {string}")
	public void i_need_to_click_on_Item_Type_with_text_matching(String string) throws InterruptedException {
			add_inventory.return_td_invoke_element(string).click();
		//get table 1st data in a table automatically 
			//add_inventory.getTableData().click();
			
		    //add_inventory.js_typeIntoDropDownSearchBox(string, int1);
		
	}
	@Then("I need to click on Vendor with text matching {string}")
	public void i_need_to_click_on_IVendor_with_text_matching(String string) throws InterruptedException {
			add_inventory.return_td_invoke_element(string).click();
			//add_inventory.getTableData().click();
			
		    //add_inventory.js_typeIntoDropDownSearchBox(string, int1);
	}
	
	@Then("I need to click on Open Selling Detail forElement {string}")
		public void i_need_to_click_on_Open_Selling_Detail_forElement(String string) throws InterruptedException {	
		
		add_inventory.elementToBeClickable(By.cssSelector(string)).click();
				//return_td_invoke_element(string).click();
			    //add_inventory.js_typeIntoDropDownSearchBox(string, int1);
			
		}
	@Then("I need to click on IGST DropDown forElement {string}")
	public void i_need_to_click_on_IGST_DropDown_forElement(String string) throws InterruptedException {	
		add_inventory.elementToBeClickable(By.cssSelector(string)).click();
		}
	@Then("I need to click on IGST search forElement {string}")
	public void i_need_to_click_on_IGST_search_forElement(String string) throws InterruptedException {	
	add_inventory.elementToBeClickable(By.cssSelector(string)).click();
		
	}
	@Then("I need to click on IGST value forElement {string}")
	public void i_need_to_click_on_IGST_value_forElement(String string) throws InterruptedException {	
	add_inventory.elementToBeClickable(By.cssSelector(string)).click();
	}
	
	@Then("I enter the HSN code forElement {string} as {string}")
	public void i_enter_the_HSN_code_forElement_as(String webele, String textToType) throws InterruptedException {

		add_inventory.inventory_waitClearEnterText_css(webele, textToType);
		
	}
	@Then("I need to click to autopopulate forElement {string}")
	public void i_need_to_click_to_autopopulate_forElement(String string) throws InterruptedException {	
		//WebElement we = add_inventory.waitForExpectedElement((By.cssSelector("div#ContentPlaceHolder1_lstLocation_chzn.chzn-container")),3000);
		//we.click();
		//add_inventory.waitForExpectedElement(By.cssSelector("li#ContentPlaceHolder1_lstLocation_chzn_o_1.active-result"), 2000).click();
		
		//we.sendKeys(Keys.ARROW_DOWN);
		//we.sendKeys(Keys.ARROW_DOWN);
		//we.sendKeys(Keys.ENTER);
		
		add_inventory.elementToBeClickable(By.cssSelector(string)).click();
		//add_inventory.elementToBeClickable(By.cssSelector("div#ContentPlaceHolder1_lstLocation_chzn.chzn-container.chzn-container-multi.chzn-container-active")).click();
	//add_inventory.elementToBeClickable(By.id("ContentPlaceHolder1_lstLocation_chzn_o_1"));

	}
	
	@Then("I need to click on sub menu with text matching {string}")
	public void i_need_to_click_on_sub_menu_with_text_matching(String string) throws InterruptedException {	
	add_inventory.return_submenu_invoke_element(string).click();
	}
	
	//image upload
	@Then("I need to upload file using path {string} forElement {string}")
	public void i_need_to_upload_file_using_path_forElement(String string,String string1) throws InterruptedException {
		
			Thread.sleep(3000);
			add_inventory.return_menu_invoke_element(string).click();
			
			Thread.sleep(2000);
		    //add_inventory.js_typeIntoDropDownSearchBox(string, int1);
		
	}
	@Then("I need to click on td forElement {string}")
	public void i_need_to_click_on_td_forElement(String string) throws InterruptedException {	
	
	//add_inventory.elementToBeClickable(By.cssSelector(string)).click();
		//add_inventory.return_td_invoke_element(string).click();
		add_inventory.getTableData(string).click();
		    //add_inventory.js_typeIntoDropDownSearchBox(string, int1);
		
	}
	
	
	
	@Then("i clear and retype the vlaue {string} for the field {string}")
	public void i_clear_and_retype_the_vlaue_for_the_field(String textValue, String elementString) {
	   
		add_inventory.clearAndTypeSlowly(textValue, elementString);
		
	}

}
