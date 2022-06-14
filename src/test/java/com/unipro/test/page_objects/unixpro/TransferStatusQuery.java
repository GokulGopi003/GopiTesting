package com.unipro.test.page_objects.unixpro;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.unipro.ExcelWrite;
import com.unipro.test.framework.Globals;
import com.unipro.test.framework.PageObject;
import com.unipro.test.framework.helpers.screenshot_helper.Screenshot;
import com.unipro.test.framework.helpers.utils.GenericWrappers;
import com.unipro.test.framework.helpers.utils.ReadTestData;

import cucumber.api.java.en.Then;

public class TransferStatusQuery extends PageObject {
	TransferStatusQuerytypefield icp;
	TerminalPage terPage;
	AddInventoryFormPage Inventorychange;
	ExcelWrite pass;
	Screenshot scr;
	TerminalPage terpage;
	public TransferStatusQuery(TransferStatusQuerytypefield icp) {
		this.icp = icp;
		terPage = new TerminalPage();
		Inventorychange = new AddInventoryFormPage();
		pass = new ExcelWrite();
		terpage=new TerminalPage();
		scr=new Screenshot();
	}
	@Then("I load the TransferStatusQuery sheet data to map")
	public void i_load_the_TransferStatusQuery_sheet_data_to_map() {
		Globals.Inventory.TransferStatusQuerySheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME135);
	}

	@Then("I load the rowise TransferStatusQuery data for {string} rowname")
	public void i_load_the_rowise_TransferStatusQuery_data_for_rowname(String row_name) {
		Globals.Inventory.TransferStatusQueryrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.TransferStatusQuerySheetData, row_name);

		System.out.println(Globals.Inventory.TransferStatusQueryrowwiseData);
	   	}

	@Then("I update value to the TransferStatusQuery page global Variables")
	public void i_update_value_to_the_TransferStatusQuery_page_global_Variables() {
		Globals.Inventory.Location = Globals.Inventory.TransferStatusQueryrowwiseData.get("Location");
		Globals.Inventory.Batch1 = Globals.Inventory.TransferStatusQueryrowwiseData.get("TransferOut");
		Globals.Inventory.Batch2 = Globals.Inventory.TransferStatusQueryrowwiseData.get("TransferIn");
		Globals.Inventory.ItemCode = Globals.Inventory.TransferStatusQueryrowwiseData.get("ItemCode");
		Globals.Inventory.Vehicle = Globals.Inventory.TransferStatusQueryrowwiseData.get("Vehicle");
		Globals.Inventory.ToLocation = Globals.Inventory.TransferStatusQueryrowwiseData.get("ToLocation");
		Globals.Inventory.GidNo = Globals.Inventory.TransferStatusQueryrowwiseData.get("GidNo");
		Globals.Inventory.WareHouse = Globals.Inventory.TransferStatusQueryrowwiseData.get("WareHouse");
		Globals.Inventory.BatchNo = Globals.Inventory.TransferStatusQueryrowwiseData.get("BatchNo");
		Globals.Inventory.Department = Globals.Inventory.TransferStatusQueryrowwiseData.get("Stock");
		Globals.Inventory.WQty = Globals.Inventory.TransferStatusQueryrowwiseData.get("WQty");
		Globals.Inventory.LQty = Globals.Inventory.TransferStatusQueryrowwiseData.get("LQty");
	}

	@Then("I fill new TransferStatusQuery data page using excel data")
	public void i_fill_new_TransferStatusQuery_data_page_using_excel_data() {
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Location)) {
			terpage.terminal_waitClearEnterText_css(icp.Location_String, Globals.Inventory.Location);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Location, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Location).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch1)) {
			terPage.get_radioButton_element(icp.TransferOut_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch2)) {
			terPage.get_radioButton_element(icp.TransferIn_String).click();
		}
	   webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_LinkButton6\"]")).click();
	   GenericWrappers.sleepInSeconds(1);
	   webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_gvTransferList\"]/tbody/tr[2]/td[1]/a")).click();
	   
	}
	@Then("I fill TransferDetails")
	   public void i_fill_TransferDetails() {
	       
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Vehicle)) {
			terpage.terminal_waitClearEnterText_css(icp.Vehicle_String, Globals.Inventory.Vehicle);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Vehicle, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Vehicle).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.ToLocation)) {
			terpage.terminal_waitClearEnterText_css(icp.ToLocation_String, Globals.Inventory.ToLocation);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.ToLocation, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.ToLocation).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.GidNo)) {
			terpage.terminal_waitClearEnterText_css(icp.GidNo_String, Globals.Inventory.GidNo);
			//Inventorychange.clearAndTypeSlowly(Globals.Inventory.GidNo, "input#txtSearch");
			//Inventorychange.return_td_invoke_element(Globals.Inventory.GidNo).click();
			webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtGidNo")).sendKeys(Keys.TAB);
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.WareHouse)) {
			terpage.terminal_waitClearEnterText_css(icp.WareHouse_String, Globals.Inventory.WareHouse);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.WareHouse, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.WareHouse).click();
		}
	if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemCode)) {
		terpage.terminal_waitClearEnterText_css(icp.ItemSearch_String, Globals.Inventory.ItemCode);
		
		webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtInventoryCode\"]")).sendKeys(Keys.ENTER);
		
	}
	
	if (GenericWrappers.isNotEmpty(Globals.Inventory.BatchNo)) {
		terpage.terminal_waitClearEnterText_css(icp.BatchNo_String, Globals.Inventory.BatchNo);
		
		webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtBatchNo\"]")).sendKeys(Keys.TAB);
	}
	if (GenericWrappers.isNotEmpty(Globals.Inventory.Department)) {
		webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtStock")).sendKeys(Keys.CONTROL, "a");
		
		GenericWrappers.sleepInSeconds(1);
		webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtStock")).sendKeys(Keys.DELETE);
		
		terpage.terminal_waitClearEnterText_css(icp.Stock_String, Globals.Inventory.Department);
		
		webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtStock\"]")).sendKeys(Keys.TAB);
	}
	if (GenericWrappers.isNotEmpty(Globals.Inventory.WQty)) {
		
		terpage.terminal_waitClearEnterText_css(icp.WQty_String, Globals.Inventory.WQty);
		
		webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtWQty\"]")).sendKeys(Keys.TAB);
	}
	if (GenericWrappers.isNotEmpty(Globals.Inventory.LQty)) {
       //webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtLQty")).sendKeys(Keys.CONTROL, "a");
		
		//GenericWrappers.sleepInSeconds(1);
		//webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtLQty")).sendKeys(Keys.DELETE);
		terpage.terminal_waitClearEnterText_css(icp.LQty_String, Globals.Inventory.LQty);
		
		webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtLQty\"]")).sendKeys(Keys.TAB);
	}

}
}