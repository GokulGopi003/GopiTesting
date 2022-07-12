package com.unipro.test.page_objects.unixpro;

import com.unipro.ExcelWrite;
import com.unipro.test.framework.PageObject;
import com.unipro.test.framework.helpers.screenshot_helper.Screenshot;

public class StockAdj extends PageObject {

	AddInventoryFormPage add_inventory;
	StockAdjTypefield icp;
	

	TerminalPage terPage;
	ExcelWrite pass;
	Screenshot scr;

	public StockAdj(StockAdjTypefield icp) {
		this.icp = icp;
		terPage = new TerminalPage();

		
		add_inventory = new AddInventoryFormPage();
		pass = new ExcelWrite();
		scr = new Screenshot();
	}

}
