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

public class TransferReport extends PageObject {
	TransferReporttypefield icp;
	TerminalPage terPage;
	AddInventoryFormPage Inventorychange;
	ExcelWrite pass;
	Screenshot scr;
	TerminalPage terpage;
	public TransferReport(TransferReporttypefield icp) {
		this.icp = icp;
		terPage = new TerminalPage();
		Inventorychange = new AddInventoryFormPage();
		pass = new ExcelWrite();
		terpage=new TerminalPage();
		scr=new Screenshot();
	}
	@Then("I load the TransferReport sheet data to map")
	public void i_load_the_TransferReport_sheet_data_to_map() {
		Globals.Inventory.TransferReportSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME132);
	}

	@Then("I load the rowise TransferReport data for {string} rowname")
	public void i_load_the_rowise_TransferReport_data_for_rowname(String row_name) {
		Globals.Inventory.TransferReportrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.TransferReportSheetData, row_name);

		System.out.println(Globals.Inventory.TransferReportrowwiseData);
	}

	@Then("I update value to the TransferReport page global Variables")
	public void i_update_value_to_the_TransferReport_page_global_Variables() {
        Globals.Inventory.FromDate = Globals.Inventory.TransferReportrowwiseData.get("FromDate");
		Globals.Inventory.ToDate = Globals.Inventory.TransferReportrowwiseData.get("ToDate");
		Globals.Inventory.FromLocation = Globals.Inventory.TransferReportrowwiseData.get("FromLocation");
		Globals.Inventory.ToLocation = Globals.Inventory.TransferReportrowwiseData.get("ToLocation");
		Globals.Inventory.Batch1 = Globals.Inventory.TransferReportrowwiseData.get("SectionWiseTransferReport");
		Globals.Inventory.Batch2 = Globals.Inventory.TransferReportrowwiseData.get("VehicleWise");
		Globals.Inventory.Batch3 = Globals.Inventory.TransferReportrowwiseData.get("RevokedTransfer");
		Globals.Inventory.Batch4 = Globals.Inventory.TransferReportrowwiseData.get("NotTransferdInventory");
		Globals.Inventory.Batch5 = Globals.Inventory.TransferReportrowwiseData.get("ItemWiseTransferOut");
		Globals.Inventory.Batch6 = Globals.Inventory.TransferReportrowwiseData.get("ClassWiseTransferOut");
		Globals.Inventory.Batch7 = Globals.Inventory.TransferReportrowwiseData.get("SubClassWiseTransferOut");
		Globals.Inventory.Batch8 = Globals.Inventory.TransferReportrowwiseData.get("TranseferOutLog");
		
		Globals.Inventory.Batch9 = Globals.Inventory.TransferReportrowwiseData.get("TransferIn");
		Globals.Inventory.Batch10 = Globals.Inventory.TransferReportrowwiseData.get("PartiallyTransferIn");
		
		Globals.Inventory.Department = Globals.Inventory.TransferReportrowwiseData.get("Department");
		Globals.Inventory.Category = Globals.Inventory.TransferReportrowwiseData.get("Category");		
		Globals.Inventory.Brand = Globals.Inventory.TransferReportrowwiseData.get("Brand");
		Globals.Inventory.Section = Globals.Inventory.TransferReportrowwiseData.get("Section");
		Globals.Inventory.Class = Globals.Inventory.TransferReportrowwiseData.get("Class");
		Globals.Inventory.SubClass = Globals.Inventory.TransferReportrowwiseData.get("SubClass");		
		Globals.Inventory.WareHouse = Globals.Inventory.TransferReportrowwiseData.get("WareHouse");
		Globals.Inventory.SubCategory = Globals.Inventory.TransferReportrowwiseData.get("TransferType");
		Globals.Inventory.Vendor = Globals.Inventory.TransferReportrowwiseData.get("Vendor");
		Globals.Inventory.Terminal = Globals.Inventory.TransferReportrowwiseData.get("Vehicle");
		Globals.Inventory.ItemCode = Globals.Inventory.TransferReportrowwiseData.get("ItemCode");
		
		
		Globals.Inventory.Batch11 = Globals.Inventory.TransferReportrowwiseData.get("Summary");
		Globals.Inventory.Batch12 = Globals.Inventory.TransferReportrowwiseData.get("Detail");
		
		
		
		
		
	}

	@Then("I fill new TransferReport data page using excel data")
	public void i_fill_new_TransferReport_data_page_using_excel_data() {
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.FromDate)) {
			terpage.terminal_waitClearEnterText_css(icp.FromDate_String, Globals.Inventory.FromDate);
			
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtFromDate\"]")).sendKeys(Keys.TAB);
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.ToDate)) {
			terpage.terminal_waitClearEnterText_css(icp.ToDate_String, Globals.Inventory.ToDate);
			
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtToDate\"]")).sendKeys(Keys.TAB);
			
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.FromLocation)) {
			terpage.terminal_waitClearEnterText_css(icp.FromLocation_String, Globals.Inventory.FromLocation);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.FromLocation, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.FromLocation).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.ToLocation)) {
			terpage.terminal_waitClearEnterText_css(icp.ToLocation_String, Globals.Inventory.ToLocation);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.ToLocation, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.ToLocation).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch1)) {
			terPage.get_radioButton_element(icp.SectionWiseTransferOut_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch2)) {
			terPage.get_radioButton_element(icp.VehicleWiseTransferOut_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch3)) {
			terPage.get_radioButton_element(icp.RevokedTransfer_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch4)) {
			terPage.get_radioButton_element(icp.NotTransferedInventory_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch5)) {
			terPage.get_radioButton_element(icp.ItemWiseTransferOut_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch6)) {
			terPage.get_radioButton_element(icp.ClassWiseTransferOut_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch7)) {
			terPage.get_radioButton_element(icp.SubClassWiseTransferOut_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch8)) {
			terPage.get_radioButton_element(icp.TransferOutLog_String).click();
		} 
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch9)) {
			terPage.get_radioButton_element(icp.Transferin_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch10)) {
			terPage.get_radioButton_element(icp.Partially_TransferIn).click();
		} 
		
		
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Department)) {
			terpage.terminal_waitClearEnterText_css(icp.Department_String, Globals.Inventory.Department);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Department, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Department).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Category)) {
			terpage.terminal_waitClearEnterText_css(icp.Category_String, Globals.Inventory.Category);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Category, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Category).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Brand)) {
			terpage.terminal_waitClearEnterText_css(icp.Brand_String, Globals.Inventory.Brand);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Brand, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Brand).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Section)) {
			terpage.terminal_waitClearEnterText_css(icp.Section_String, Globals.Inventory.Section);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Section, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Section).click();
		}
		
		
		
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Class)) {
			terpage.terminal_waitClearEnterText_css(icp.Class_String, Globals.Inventory.Class);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Class, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Class).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.SubClass)) {
			terpage.terminal_waitClearEnterText_css(icp.SubClass_String, Globals.Inventory.SubClass);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.SubClass, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.SubClass).click();
		}
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.WareHouse)) {
			terpage.terminal_waitClearEnterText_css(icp.Warehouse_String, Globals.Inventory.WareHouse);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.WareHouse, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.WareHouse).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.SubCategory)) {
			terpage.terminal_waitClearEnterText_css(icp.TransferType_String, Globals.Inventory.SubCategory);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.SubCategory, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.SubCategory).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Vendor)) {
			terpage.terminal_waitClearEnterText_css(icp.Vendor_String, Globals.Inventory.Vendor);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Vendor, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Vendor).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Terminal)) {
			terpage.terminal_waitClearEnterText_css(icp.Vehicle_String, Globals.Inventory.Terminal);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Terminal, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Terminal).click();
		}
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemCode)) {
			terpage.terminal_waitClearEnterText_css(icp.ItemSearch_String, Globals.Inventory.ItemCode);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.ItemCode, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.ItemCode).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch11)) {
			terPage.get_radioButton_element(icp.Summary_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch12)) {
			terPage.get_radioButton_element(icp.Detail_String).click();
		} 
	}


}
