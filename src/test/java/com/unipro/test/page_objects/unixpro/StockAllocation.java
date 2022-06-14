package com.unipro.test.page_objects.unixpro;

import com.unipro.ExcelWrite;
import com.unipro.test.framework.PageObject;
import com.unipro.test.framework.helpers.screenshot_helper.Screenshot;

import cucumber.api.java.en.Then;

public class StockAllocation extends PageObject {
	StockAllocationtypefield icp;
	TerminalPage terPage;
	AddInventoryFormPage Inventorychange;
	ExcelWrite pass;
	Screenshot scr;
	TerminalPage terpage;
	public StockAllocation(StockAllocationtypefield icp) {
		this.icp = icp;
		terPage = new TerminalPage();
		Inventorychange = new AddInventoryFormPage();
		pass = new ExcelWrite();
		terpage=new TerminalPage();
		scr=new Screenshot();
	}
	@Then("I load the StockAllocation sheet data to map")
	public void i_load_the_StockAllocation_sheet_data_to_map() {
	    
	}

	@Then("I load the rowise StockAllocation data for {string} rowname")
	public void i_load_the_rowise_StockAllocation_data_for_rowname(String string) {
	    
	}

	@Then("I update value to the StockAllocation page global Variables")
	public void i_update_value_to_the_StockAllocation_page_global_Variables() {
	    
	}

	@Then("I fill new StockAllocation data page using excel data")
	public void i_fill_new_StockAllocation_data_page_using_excel_data() {
	    
	}


}
