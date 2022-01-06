package com.unipro.test.step_definitions.unixpo;

import static org.testng.Assert.assertEquals;


import static org.testng.Assert.assertNotEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.gk.test.MssqlConnect;
import com.google.common.collect.Table;
import com.unipro.ExcelWrite;
import com.unipro.test.framework.Globals;
import com.unipro.test.framework.PageObject;
import com.unipro.test.framework.helpers.screenshot_helper.Screenshot;
import com.unipro.test.framework.helpers.utils.ApplicationLogger;
import com.unipro.test.framework.helpers.utils.GenericWrappers;
import com.unipro.test.framework.helpers.utils.RandomGenerator;
import com.unipro.test.framework.helpers.utils.ReadTestData;
import com.unipro.test.framework.helpers.utils.ReadXLSXFile;
import com.unipro.test.page_objects.unixpro.AddInventoryFormPage;
import com.unipro.test.page_objects.unixpro.InventoryCalculationsPage;
import com.unipro.test.page_objects.unixpro.InventoryCreationPage;
import com.unipro.test.page_objects.unixpro.LoginPage;
import com.unipro.test.page_objects.unixpro.TerminalPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.dependency.difflib.myers.MyersDiff;
import net.bytebuddy.agent.builder.AgentBuilder.CircularityLock.Global;

public class InventoryCalculations_StepDefinitions extends PageObject {

	AddInventoryFormPage add_inventory;
	InventoryCalculationsPage icp;
	Screenshot scr;
	TerminalPage terPage;
	ExcelWrite pass;

	public InventoryCalculations_StepDefinitions(InventoryCalculationsPage icp) throws IOException {
		this.icp = icp;
		terPage = new TerminalPage();
		scr = new Screenshot();
		add_inventory = new AddInventoryFormPage();
		pass = new ExcelWrite();

	}

	@Then("I verify default values of selling price calcualtion page for {string} as BasicCost")
	public void i_verify_default_values_of_selling_price_calcualtion_page_for_as_BasicCost(String basicCostInput) {

		// setting Basic cost price
		icp.setTextValue(icp.Basic_Cost_String, basicCostInput);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Getting the updated price
		icp.Basic_Cost = icp.getTextValue(icp.Basic_Cost_text);
		icp.Basic_Selling = icp.getTextValue(icp.Basic_Selling_text);
		icp.Net_Cost = icp.getTextValue(icp.Net_Cost_text);
		icp.WPrice1 = icp.getTextValue(icp.WPrice1_text);
		icp.WPrice2 = icp.getTextValue(icp.WPrice2_text);
		icp.WPrice3 = icp.getTextValue(icp.WPrice3_text);

		System.out
				.println("Verifying Basic cost and Basic selling price " + icp.Basic_Cost + " = " + icp.Basic_Selling);

		// Verifying with the Basic cost price
		assertEquals(icp.Basic_Cost, icp.Basic_Selling);
		assertEquals(icp.Basic_Cost, icp.Net_Cost);
		assertEquals(icp.Basic_Cost, icp.WPrice1);
		assertEquals(icp.Basic_Cost, icp.WPrice2);
		assertEquals(icp.Basic_Cost, icp.WPrice3);
		assertEquals(icp.Basic_Cost, icp.WPrice3);
		// Calculating the round off value

		icp.roundingOff(basicCostInput);

		// getting the NetSellingPrice

		double actual_NetSellingPrice_text = icp.getTextValue(icp.NetSellingPrice_text);
		// assertEquals(actual_NetSellingPrice_text, icp.NetSellingPrice);

		System.out.println("Verifying Selling price after - RoundOff  " + actual_NetSellingPrice_text + " = "
				+ icp.NetSellingPrice);

	}

	@When("I enter the discout as {string} percent and i verify the GrossCost value is updated as expected")
	public void i_enter_the_discout_as_percent_and_i_verify_the_GrossCost_value_is_updated_as_expected(
			String discount1) {

		// set discount price

		icp.setTextValue(icp.Discount1_String, discount1);
		icp.setTextValue(icp.Discount2_String, discount1);
		icp.setTextValue(icp.Discount3_String, discount1);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Getting the updated price
		icp.Basic_Cost = icp.getTextValue(icp.Basic_Cost_text);
		icp.Basic_Selling = icp.getTextValue(icp.Basic_Selling_text);
		icp.Gross_Cost = icp.getTextValue(icp.Gross_Cost_text);
		icp.Net_Cost = icp.getTextValue(icp.Net_Cost_text);
		icp.WPrice1 = icp.getTextValue(icp.WPrice1_text);
		icp.WPrice2 = icp.getTextValue(icp.WPrice2_text);
		icp.WPrice3 = icp.getTextValue(icp.WPrice3_text);

		System.out
				.println("Verifying Basic cost and Basic selling price " + icp.Basic_Cost + " = " + icp.Basic_Selling);

		// Verifying with the Basic cost price
		assertNotEquals(icp.Basic_Cost, icp.Basic_Selling);

		// assertEquals(icp.Basic_Cost, icp.Net_Cost);
		// assertEquals(icp.Basic_Cost, icp.WPrice1);
		assertEquals(icp.Gross_Cost, icp.WPrice2);
		assertEquals(icp.Gross_Cost, icp.WPrice3);
		assertEquals(icp.Gross_Cost, icp.WPrice3);
		// Calculating the round off value
	}

	@Then("I verify the total discount offerd percentage")
	public void i_verify_the_total_discount_offerd_percentage() {

		float percentage;
		float Basic_Cost;
		float Gross_Cost;

		// System.out.println("Enter Gross Cost ::");
		Gross_Cost = (float) icp.Gross_Cost;

		// System.out.println("Enter Basic Cost ::");
		Basic_Cost = (float) icp.Basic_Cost;

		percentage = (float) ((Gross_Cost / Basic_Cost) * 100);
		System.out.println("Percentage ::" + percentage);

		float ActualdiscountOffered = 100 - percentage;
		System.out.println("ActualdiscountOffered ::" + Math.round(ActualdiscountOffered));

		float ExpectedtotalDiscount = (float) (icp.getTextValue(icp.Discount1_text)
				+ icp.getTextValue(icp.Discount2_text) + icp.getTextValue(icp.Discount3_text));
		System.out.println("ExpectedtotalDiscount ::" + Math.round(ExpectedtotalDiscount));

		assertEquals(Math.round(ActualdiscountOffered), Math.round(ExpectedtotalDiscount));

	}

	@Then("I load the testdata form excel")
	public void i_load_the_testdata_form_excel() {

		Globals.excelSheetData = ReadXLSXFile.getExcelAsMapTable("./testdata/sample mrp.xlsx");
		System.out.println(Globals.excelSheetData);
		Globals.Inventory.inventorySheetData = Globals.excelSheetData.get("Inventory");
		System.out.println(Globals.Inventory.inventorySheetData);

		Globals.Inventory.inventoryrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.inventorySheetData, "cost");

		Globals.Inventory.MRP = Globals.Inventory.inventoryrowwiseData.get("MRP");
		Globals.Inventory.BasicCost = Globals.Inventory.inventoryrowwiseData.get("BasicCost");
		Globals.Inventory.DiscountPer1 = Globals.Inventory.inventoryrowwiseData.get("DiscountPer1");
		Globals.Inventory.DiscountPer2 = Globals.Inventory.inventoryrowwiseData.get("DiscountPer2");
		Globals.Inventory.DiscountPer3 = Globals.Inventory.inventoryrowwiseData.get("DiscountPer3");
		Globals.Inventory.GSTPer = Globals.Inventory.inventoryrowwiseData.get("GSTPer");
		Globals.Inventory.NetSellingPrice = Globals.Inventory.inventoryrowwiseData.get("NetSellingPrice");
		Globals.Inventory.spfixing = Globals.Inventory.inventoryrowwiseData.get("spfixing");
		Globals.Inventory.netcost = Globals.Inventory.inventoryrowwiseData.get("netcost");

	}

	@Then("I load the testdata form excel to table")
	public void i_load_the_testdata_form_excel_to_table() {

		// Globals.excelSheetData = ReadXLSXFile.getExcelAsMapTable("./testdata/sample
		// mrp.xlsx");
		Globals.excelSheetData = ReadXLSXFile.getExcelAsMapTable("./testdata/sample inventory all.xlsx");

	}

	@Then("I load the inventory sheet data to map")
	public void i_load_the_inventory_sheet_data_to_map() {

		// Globals.Inventory.inventorySheetData1 =
		// Globals.excelSheetData.get(Globals.Inventory.SHEETNAME_DATA);

		Globals.Inventory.inventorySheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME);

	}

	@Then("I load the rowise inventory data for {string} rowname")
	public void i_load_the_rowise_inventory_data_for_rowname(String row_name) {

		Globals.Inventory.inventoryrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.inventorySheetData, row_name);

		System.out.println(Globals.Inventory.inventoryrowwiseData);

	}

	@Then("I check the purchased by radio button for {string}")
	public void i_check_the_purchased_by_radio_button_for(String row_name) {

		icp.clickPurchasedByRadioButton(row_name);

	}

	@Then("I update value to the inventory page global Variables")
	public void i_update_value_to_the_inventory_page_global_Variables() {

		Globals.Inventory.MRP = Globals.Inventory.inventoryrowwiseData.get("MRP");
		Globals.Inventory.BasicCost = Globals.Inventory.inventoryrowwiseData.get("BasicCost");
		Globals.Inventory.DiscountPer1 = Globals.Inventory.inventoryrowwiseData.get("DiscountPer1");
		Globals.Inventory.DiscountPer2 = Globals.Inventory.inventoryrowwiseData.get("DiscountPer2");
		Globals.Inventory.DiscountPer3 = Globals.Inventory.inventoryrowwiseData.get("DiscountPer3");
		Globals.Inventory.GSTPer = Globals.Inventory.inventoryrowwiseData.get("GSTPer");

		Globals.Inventory.Cess = Globals.Inventory.inventoryrowwiseData.get("Cess");
		Globals.Inventory.AdlCsAmt = Globals.Inventory.inventoryrowwiseData.get("AdlCsAmt");

		Globals.Inventory.NetSellingPrice = Globals.Inventory.inventoryrowwiseData.get("NetSellingPrice");
		Globals.Inventory.spfixing = Globals.Inventory.inventoryrowwiseData.get("s.p.fixing%");
		Globals.Inventory.netcost = Globals.Inventory.inventoryrowwiseData.get("netcost");
		Globals.Inventory.WPrice1 = Globals.Inventory.inventoryrowwiseData.get("WPrice1");
		Globals.Inventory.WPrice2 = Globals.Inventory.inventoryrowwiseData.get("WPrice2");
		Globals.Inventory.WPrice3 = Globals.Inventory.inventoryrowwiseData.get("WPrice3");
		Globals.Inventory.WAPrice1 = Globals.Inventory.inventoryrowwiseData.get("WAPrice1");
		Globals.Inventory.WAPrice2 = Globals.Inventory.inventoryrowwiseData.get("WAPrice2");
		Globals.Inventory.WAPrice3 = Globals.Inventory.inventoryrowwiseData.get("WAPrice3");

		Globals.Inventory.DiscountPer = Globals.Inventory.inventoryrowwiseData.get("DiscountPer");
		Globals.Inventory.AddDiscountPer = Globals.Inventory.inventoryrowwiseData.get("AddDiscountPer");

		// data for inventory creation

		Globals.Inventory.Category = Globals.Inventory.inventoryrowwiseData.get("Category");
		Globals.Inventory.Department = Globals.Inventory.inventoryrowwiseData.get("Department");
		Globals.Inventory.Brand = Globals.Inventory.inventoryrowwiseData.get("Brand");
		Globals.Inventory.ItemName = Globals.Inventory.inventoryrowwiseData.get("ItemName");
		Globals.Inventory.ShortName = Globals.Inventory.inventoryrowwiseData.get("ShortName");
		Globals.Inventory.ItemType = Globals.Inventory.inventoryrowwiseData.get("ItemType");
		Globals.Inventory.Vendor = Globals.Inventory.inventoryrowwiseData.get("Vendor");
		Globals.Inventory.UOMPurchase = Globals.Inventory.inventoryrowwiseData.get("UOMPurchase");
		Globals.Inventory.SalesUOM = Globals.Inventory.inventoryrowwiseData.get("SalesUOM");
		Globals.Inventory.StockType = Globals.Inventory.inventoryrowwiseData.get("StockType");
		Globals.Inventory.Batch = Globals.Inventory.inventoryrowwiseData.get("Batch");

		// non mandatory fields update
		Globals.Inventory.Remarks = Globals.Inventory.inventoryrowwiseData.get("Remarks");
		Globals.Inventory.WareHouse = Globals.Inventory.inventoryrowwiseData.get("WareHouse");
		Globals.Inventory.Manufacture = Globals.Inventory.inventoryrowwiseData.get("Manufacture");
		Globals.Inventory.Merchandise = Globals.Inventory.inventoryrowwiseData.get("Merchandise");
		Globals.Inventory.Style = Globals.Inventory.inventoryrowwiseData.get("Style");
		Globals.Inventory.Size = Globals.Inventory.inventoryrowwiseData.get("Size");
		Globals.Inventory.ModelNo = Globals.Inventory.inventoryrowwiseData.get("ModelNo");
		Globals.Inventory.Origin = Globals.Inventory.inventoryrowwiseData.get("Origin");
		Globals.Inventory.SubCategory = Globals.Inventory.inventoryrowwiseData.get("SubCategory");
		Globals.Inventory.Package = Globals.Inventory.inventoryrowwiseData.get("Package");
		Globals.Inventory.CCode = Globals.Inventory.inventoryrowwiseData.get("CCode");
		Globals.Inventory.Class = Globals.Inventory.inventoryrowwiseData.get("Class");
		Globals.Inventory.SubClass = Globals.Inventory.inventoryrowwiseData.get("SubClass");
		Globals.Inventory.Bin = Globals.Inventory.inventoryrowwiseData.get("Bin");
		Globals.Inventory.Section = Globals.Inventory.inventoryrowwiseData.get("Section");
		Globals.Inventory.Shelf = Globals.Inventory.inventoryrowwiseData.get("Shelf");
		Globals.Inventory.Weight = Globals.Inventory.inventoryrowwiseData.get("Weight");
		Globals.Inventory.Height = Globals.Inventory.inventoryrowwiseData.get("Height");
		Globals.Inventory.Width = Globals.Inventory.inventoryrowwiseData.get("Width");
		Globals.Inventory.Length = Globals.Inventory.inventoryrowwiseData.get("Length");
		Globals.Inventory.Purchasetype = Globals.Inventory.inventoryrowwiseData.get("Purchasetype");
		Globals.Inventory.ItemCode = Globals.Inventory.inventoryrowwiseData.get("ItemCode");
		Globals.Inventory.Barcode = Globals.Inventory.inventoryrowwiseData.get("Barcode");
		Globals.Inventory.MinQty = Globals.Inventory.inventoryrowwiseData.get("MinQty");
		Globals.Inventory.MaxQty = Globals.Inventory.inventoryrowwiseData.get("MaxQty");
		Globals.Inventory.ReorderQty = Globals.Inventory.inventoryrowwiseData.get("ReorderQty");
		Globals.Inventory.Cycledays = Globals.Inventory.inventoryrowwiseData.get("Cycledays");
		Globals.Inventory.Orderby = Globals.Inventory.inventoryrowwiseData.get("Orderby");
		Globals.Inventory.CheckBox1 = Globals.Inventory.inventoryrowwiseData.get("CheckBox1");
		Globals.Inventory.CheckBox2 = Globals.Inventory.inventoryrowwiseData.get("CheckBox2");
		Globals.Inventory.Batch1 = Globals.Inventory.inventoryrowwiseData.get("Batch1");
		Globals.Inventory.Expireddate = Globals.Inventory.inventoryrowwiseData.get("Expireddate");
		Globals.Inventory.SerialnoEntry = Globals.Inventory.inventoryrowwiseData.get("SerialnoEntry");
		Globals.Inventory.AutoPO = Globals.Inventory.inventoryrowwiseData.get("AutoPO");
		Globals.Inventory.Packageitem = Globals.Inventory.inventoryrowwiseData.get("Packageitem");
		Globals.Inventory.Loyality = Globals.Inventory.inventoryrowwiseData.get("Loyality");
		Globals.Inventory.Special = Globals.Inventory.inventoryrowwiseData.get("Special");
		Globals.Inventory.ShelfStorage = Globals.Inventory.inventoryrowwiseData.get("ShelfStorage");
		Globals.Inventory.HideDataOnBarcode = Globals.Inventory.inventoryrowwiseData.get("HideDataOnBarcode");
		Globals.Inventory.Markingitem = Globals.Inventory.inventoryrowwiseData.get("Markingitem");
		Globals.Inventory.NeedBarcodePrint = Globals.Inventory.inventoryrowwiseData.get("NeedBarcodePrint");
		Globals.Inventory.AllowCostEditinGRN = Globals.Inventory.inventoryrowwiseData.get("AllowCostEditinGRN");
		Globals.Inventory.Weightbased = Globals.Inventory.inventoryrowwiseData.get("Weightbased");
		Globals.Inventory.PurchaseOrder = Globals.Inventory.inventoryrowwiseData.get("PurchaseOrder");
		Globals.Inventory.GRNPurchase = Globals.Inventory.inventoryrowwiseData.get("GRNPurchase");
		Globals.Inventory.PointOfSale = Globals.Inventory.inventoryrowwiseData.get("PointOfSale");
		Globals.Inventory.AllowNegative = Globals.Inventory.inventoryrowwiseData.get("AllowNegative");
		Globals.Inventory.TransferDC = Globals.Inventory.inventoryrowwiseData.get("TransferDC");
		Globals.Inventory.SalesReturn = Globals.Inventory.inventoryrowwiseData.get("SalesReturn");
		Globals.Inventory.OrderBooking = Globals.Inventory.inventoryrowwiseData.get("OrderBooking");
		Globals.Inventory.Estimation = Globals.Inventory.inventoryrowwiseData.get("Estimation");
		Globals.Inventory.Quatation = Globals.Inventory.inventoryrowwiseData.get("Quatation");
		Globals.Inventory.OnlineOrder = Globals.Inventory.inventoryrowwiseData.get("OnlineOrder");
		Globals.Inventory.Purchasereturn = Globals.Inventory.inventoryrowwiseData.get("Purcasereturn");
		Globals.Inventory.inventorysearch = Globals.Inventory.inventoryrowwiseData.get("inventorysearch");
		Globals.Inventory.Batchno = Globals.Inventory.inventoryrowwiseData.get("Batchno");
	}

	@Then("I Search Inventory")
	public void i_Search_inventory() {
		if (GenericWrappers.isNotEmpty(Globals.Inventory.inventorysearch)) {
			terPage.terminal_waitClearEnterText_css(icp.inventorysearch_String, Globals.Inventory.inventorysearch);
			webDriver
					.findElement(By.xpath(
							"//a[@href=\"javascript:__doPostBack('ctl00$ContentPlaceHolder1$lnkSearchGrid','')\"]"))
					.click();
			GenericWrappers.sleepInSeconds(1);
			webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_grdInventoryList_imgbtnEdit_0")).click();

		}
	}

	@Then("I fill new inventory data page using excel data")
	public void i_fill_new_inventory_data_page_using_excel_data() throws Exception {
		try {

			// category
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Category)) {
				terPage.terminal_waitClearEnterText_css(icp.Category_String, Globals.Inventory.Category);
				add_inventory.clearAndTypeSlowly(Globals.Inventory.Category, "input#txtSearch");
				add_inventory.return_td_invoke_element(Globals.Inventory.Category).click();

			}
			// Department
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Department)) {
				terPage.terminal_waitClearEnterText_css(icp.Department_String, Globals.Inventory.Department);
				add_inventory.clearAndTypeSlowly(Globals.Inventory.Department, "input#txtSearch");
				add_inventory.return_td_invoke_element(Globals.Inventory.Department).click();
			}
			// Brand
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Brand)) {
				terPage.terminal_waitClearEnterText_css(icp.Brand_String, Globals.Inventory.Brand);
				add_inventory.clearAndTypeSlowly(Globals.Inventory.Brand, "input#txtSearch");
				add_inventory.return_td_invoke_element(Globals.Inventory.Brand).click();
			}

			// Item Name
			if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemName)) {

				terPage.terminal_waitClearEnterText_css(icp.ItemName_String,
						Globals.Inventory.ItemName + RandomGenerator.randomAlphabetic(5));
			}

			// Short Name
			if (GenericWrappers.isNotEmpty(Globals.Inventory.ShortName)) {
				terPage.terminal_waitClearEnterText_css(icp.ShortName_String, Globals.Inventory.ShortName);
			}

			// Item Type

			if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemType)) {

				terPage.terminal_waitClearEnterText_css(icp.ItemType_String, Globals.Inventory.ItemType);

				add_inventory.clearAndTypeSlowly(Globals.Inventory.ItemType, "input#txtSearch");

				GenericWrappers.sleepInSeconds(1);
				add_inventory.return_td_invoke_element(Globals.Inventory.ItemType).click();
			}
			// UOMPurchase
			if (GenericWrappers.isNotEmpty(Globals.Inventory.UOMPurchase)) {
				terPage.terminal_waitClearEnterText_css(icp.UOMPurchase_String, Globals.Inventory.UOMPurchase);

				add_inventory.clearAndTypeSlowly(Globals.Inventory.UOMPurchase, "input#txtSearch");
				add_inventory.return_td_invoke_element(Globals.Inventory.UOMPurchase).click();
			}
			// StockType
			if (GenericWrappers.isNotEmpty(Globals.Inventory.StockType)) {
				terPage.terminal_waitClearEnterText_css(icp.StockType_String, Globals.Inventory.StockType);
				add_inventory.clearAndTypeSlowly(Globals.Inventory.StockType, "input#txtSearch");
				add_inventory.return_td_invoke_element(Globals.Inventory.StockType).click();
			}
			// SalesUOM
			if (GenericWrappers.isNotEmpty(Globals.Inventory.SalesUOM)) {
				terPage.terminal_waitClearEnterText_css(icp.SalesUOM_String, Globals.Inventory.SalesUOM);
				add_inventory.clearAndTypeSlowly(Globals.Inventory.SalesUOM, "input#txtSearch");
				add_inventory.return_td_invoke_element(Globals.Inventory.SalesUOM).click();
			}
			// Batch
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch)) {
				terPage.get_checkBox_element(icp.Batch_String).click();

			}

			// vendor
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Vendor)) {
				terPage.terminal_waitClearEnterText_css(icp.Vendor_String, Globals.Inventory.Vendor);
				add_inventory.clearAndTypeSlowly(Globals.Inventory.Vendor, "input#txtSearch");
				add_inventory.return_td_invoke_element(Globals.Inventory.Vendor).click();
			}

			// Non mandatory fields
			// Remarks
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Remarks)) {
				terPage.terminal_waitClearEnterText_css(icp.Remarks_String, Globals.Inventory.Remarks);
			}

			// WareHouse
			if (GenericWrappers.isNotEmpty(Globals.Inventory.WareHouse)) {
				terPage.terminal_waitClearEnterText_css(icp.WareHouse_String, Globals.Inventory.WareHouse);
				add_inventory.clearAndTypeSlowly(Globals.Inventory.WareHouse, "input#txtSearch");
				add_inventory.return_td_invoke_element(Globals.Inventory.WareHouse).click();
			}

			// Manufacture
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Manufacture)) {
				terPage.terminal_waitClearEnterText_css(icp.Manufacture_String, Globals.Inventory.Manufacture);
				add_inventory.clearAndTypeSlowly(Globals.Inventory.Manufacture, "input#txtSearch");
				add_inventory.return_td_invoke_element(Globals.Inventory.Manufacture).click();
			}
			// Merchandise
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Merchandise)) {
				terPage.terminal_waitClearEnterText_css(icp.Merchandise_String, Globals.Inventory.Merchandise);
				add_inventory.clearAndTypeSlowly(Globals.Inventory.Merchandise, "input#txtSearch");
				add_inventory.return_td_invoke_element(Globals.Inventory.Merchandise).click();
			}
			// Style
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Style)) {
				terPage.terminal_waitClearEnterText_css(icp.Style_String, Globals.Inventory.Style);
				add_inventory.clearAndTypeSlowly(Globals.Inventory.Style, "input#txtSearch");
				add_inventory.return_td_invoke_element(Globals.Inventory.Style).click();
			}
			// Size
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Size)) {
				terPage.terminal_waitClearEnterText_css(icp.Size_String, Globals.Inventory.Size);
				add_inventory.clearAndTypeSlowly(Globals.Inventory.Size, "input#txtSearch");
				add_inventory.return_td_invoke_element(Globals.Inventory.Size).click();
			}
			// c.code
			if (GenericWrappers.isNotEmpty(Globals.Inventory.CCode)) {
				terPage.terminal_waitClearEnterText_css(icp.CCode_String, Globals.Inventory.CCode);
				add_inventory.clearAndTypeSlowly(Globals.Inventory.CCode, "input#txtSearch");
				add_inventory.return_td_invoke_element(Globals.Inventory.CCode).click();
			}
			// ModelNo
			if (GenericWrappers.isNotEmpty(Globals.Inventory.ModelNo)) {
				terPage.terminal_waitClearEnterText_css(icp.ModelNo_String, Globals.Inventory.ModelNo);
			}
			// Origin
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Origin)) {
				terPage.terminal_waitClearEnterText_css(icp.Origin_String, Globals.Inventory.Origin);
				add_inventory.clearAndTypeSlowly(Globals.Inventory.Origin, "input#txtSearch");
				add_inventory.return_td_invoke_element(Globals.Inventory.Origin).click();
			}
			// Sub Category
			if (GenericWrappers.isNotEmpty(Globals.Inventory.SubCategory)) {
				terPage.terminal_waitClearEnterText_css(icp.SubCategory_String, Globals.Inventory.SubCategory);
				add_inventory.clearAndTypeSlowly(Globals.Inventory.SubCategory, "input#txtSearch");
				try {
					add_inventory.return_td_invoke_element(Globals.Inventory.SubCategory).click();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();

					add_inventory.return_td_invoke_element(Globals.Inventory.SubCategory).click();
				}
			}
			// Package
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Package)) {
				terPage.terminal_waitClearEnterText_css(icp.Package_String, Globals.Inventory.Package);
				add_inventory.clearAndTypeSlowly(Globals.Inventory.Package, "input#txtSearch");
				try {
					add_inventory.return_td_invoke_element(Globals.Inventory.Package).click();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();

					add_inventory.return_td_invoke_element(Globals.Inventory.Package).click();
				}
			}
			// Class
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Class)) {
				terPage.terminal_waitClearEnterText_css(icp.Class_String, Globals.Inventory.Class);
				add_inventory.clearAndTypeSlowly(Globals.Inventory.Class, "input#txtSearch");
				add_inventory.return_td_invoke_element(Globals.Inventory.Class).click();
			}
			// SubClass
			if (GenericWrappers.isNotEmpty(Globals.Inventory.SubClass)) {
				terPage.terminal_waitClearEnterText_css(icp.SubClass_String, Globals.Inventory.SubClass);
				add_inventory.clearAndTypeSlowly(Globals.Inventory.SubClass, "input#txtSearch");
				add_inventory.return_td_invoke_element(Globals.Inventory.SubClass).click();
			}
			// Bin
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Bin)) {
				terPage.terminal_waitClearEnterText_css(icp.Bin_String, Globals.Inventory.Bin);
				add_inventory.clearAndTypeSlowly(Globals.Inventory.Bin, "input#txtSearch");
				add_inventory.return_td_invoke_element(Globals.Inventory.Bin).click();
			}
			// Section
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Section)) {
				terPage.terminal_waitClearEnterText_css(icp.Section_String, Globals.Inventory.Section);
				add_inventory.clearAndTypeSlowly(Globals.Inventory.Section, "input#txtSearch");
				add_inventory.return_td_invoke_element(Globals.Inventory.Section).click();
			}
			// Shelf
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Shelf)) {
				terPage.terminal_waitClearEnterText_css(icp.Shelf_String, Globals.Inventory.Shelf);
				add_inventory.clearAndTypeSlowly(Globals.Inventory.Shelf, "input#txtSearch");
				add_inventory.return_td_invoke_element(Globals.Inventory.Shelf).click();
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtShelf.form-control-res"))
						.sendKeys(Keys.RETURN);
			}
			// Weight
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Weight)) {
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtWeight.form-control-res-right"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtWeight.form-control-res-right"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtWeight.form-control-res-right"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtWeight.form-control-res-right"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtWeight.form-control-res-right"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtWeight.form-control-res-right"))
						.sendKeys(Keys.DELETE);
				terPage.terminal_waitClearEnterText_css(icp.Weight_String, Globals.Inventory.Weight);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtWeight.form-control-res-right"))
						.sendKeys(Keys.RETURN);
				// GenericWrappers.sleepInSeconds(1);
				// if (Globals.Inventory.Weight.contains(".")) {
				// icp.setTextValue_Decimal(icp.Weight_String, Globals.Inventory.Weight);
				// } else {
				// icp.setTextValue(icp.Weight_String, Globals.Inventory.Weight);
				// }
			}
			// Height
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Height)) {
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtHeight.form-control-res-right"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtHeight.form-control-res-right"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtHeight.form-control-res-right"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtHeight.form-control-res-right"))
						.sendKeys(Keys.DELETE);
				terPage.terminal_waitClearEnterText_css(icp.Height_String, Globals.Inventory.Height);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtHeight.form-control-res-right"))
						.sendKeys(Keys.RETURN);
				// if (Globals.Inventory.Height.contains(".")) {
				// icp.setTextValue_Decimal(icp.Height_String, Globals.Inventory.Height);
				// } else {
				// icp.setTextValue(icp.Height_String, Globals.Inventory.Height);
				// }
			}
			// Width
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Width)) {
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtWidth.form-control-res-right"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtWidth.form-control-res-right"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtWidth.form-control-res-right"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtWidth.form-control-res-right"))
						.sendKeys(Keys.DELETE);
				terPage.terminal_waitClearEnterText_css(icp.Width_String, Globals.Inventory.Width);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtWidth.form-control-res-right"))
						.sendKeys(Keys.RETURN);
				// if (Globals.Inventory.Width.contains(".")) {
				// icp.setTextValue_Decimal(icp.Width_String, Globals.Inventory.Width);
				// } else {
				// icp.setTextValue(icp.Width_String, Globals.Inventory.Width);
				// }
			}
			// Length
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Length)) {
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtLength.form-control-res-right"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtLength.form-control-res-right"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtLength.form-control-res-right"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtLength.form-control-res-right"))
						.sendKeys(Keys.DELETE);
				GenericWrappers.sleepInSeconds(1);
				terPage.terminal_waitClearEnterText_css(icp.Length_String, Globals.Inventory.Length);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtLength.form-control-res-right"))
						.sendKeys(Keys.RETURN);
				// if (Globals.Inventory.Length.contains(".")) {
				// icp.setTextValue_Decimal(icp.Length_String, Globals.Inventory.Length);
				// } else {
				// icp.setTextValue(icp.Length_String, Globals.Inventory.Length);
				// }
			}
			pass.ExcelFourData("Inventory","Modules", "Actual", "Expected", "Status",
					0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
			pass.Excelcreate("Inventory", "MASTERS", "PASS", 1, 0, 1, 3);
		} catch (Exception e) {
			// screen shot
			scr.Screenshots();
			System.out.println("Screen shot taken");
			// Xl sheet write
			pass.ExcelFourData("Inventory","Modules", "Actual", "Expected", "Status",
					0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
			pass.Excelcreate("Inventory", "MASTERS", "FAIL", 1, 0, 1, 3);

		}
	}

	@Then("I fill inventory calculations page using excel data")
	public void i_fill_inventory_calculations_page_using_excel_data() throws Exception {
		try {
			// cess
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Cess) && !(Globals.Inventory.GSTPer).matches("0")) {
				webDriver
						.findElement(By.cssSelector("input#ContentPlaceHolder1_txtCESSPrc.form-control-res.text-right"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver
						.findElement(By.cssSelector("input#ContentPlaceHolder1_txtCESSPrc.form-control-res.text-right"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver
						.findElement(By.cssSelector("input#ContentPlaceHolder1_txtCESSPrc.form-control-res.text-right"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver
						.findElement(By.cssSelector("input#ContentPlaceHolder1_txtCESSPrc.form-control-res.text-right"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				GenericWrappers.sleepInSeconds(1);
				webDriver
						.findElement(By.cssSelector("input#ContentPlaceHolder1_txtCESSPrc.form-control-res.text-right"))
						.sendKeys(Keys.DELETE);
				terPage.terminal_waitClearEnterText_css(icp.Cess_String, Globals.Inventory.Cess);
				webDriver
						.findElement(By.cssSelector("input#ContentPlaceHolder1_txtCESSPrc.form-control-res.text-right"))
						.sendKeys(Keys.RETURN);
				// if (Globals.Inventory.Cess.contains(".")) {
				// icp.setTextValue_Decimal(icp.Cess_String, Globals.Inventory.Cess);
				// } else {
				// icp.setTextValue(icp.Cess_String, Globals.Inventory.Cess);
				// }
			}

			// Additional cess amount
			if (GenericWrappers.isNotEmpty(Globals.Inventory.AdlCsAmt) && !(Globals.Inventory.GSTPer).matches("0")) {
				webDriver
						.findElement(
								By.cssSelector("input#ContentPlaceHolder1_txtAddCessAmt.form-control-res.text-right"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver
						.findElement(
								By.cssSelector("input#ContentPlaceHolder1_txtAddCessAmt.form-control-res.text-right"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver
						.findElement(
								By.cssSelector("input#ContentPlaceHolder1_txtAddCessAmt.form-control-res.text-right"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver
						.findElement(
								By.cssSelector("input#ContentPlaceHolder1_txtAddCessAmt.form-control-res.text-right"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				GenericWrappers.sleepInSeconds(1);
				webDriver
						.findElement(
								By.cssSelector("input#ContentPlaceHolder1_txtAddCessAmt.form-control-res.text-right"))
						.sendKeys(Keys.DELETE);
				terPage.terminal_waitClearEnterText_css(icp.AdlCsAmt_String, Globals.Inventory.AdlCsAmt);
				webDriver
						.findElement(
								By.cssSelector("input#ContentPlaceHolder1_txtAddCessAmt.form-control-res.text-right"))
						.sendKeys(Keys.RETURN);
				// if (Globals.Inventory.AdlCsAmt.contains(".")) {
				// icp.setTextValue_Decimal(icp.AdlCsAmt_String, Globals.Inventory.AdlCsAmt);
				// } else {
				// icp.setTextValue(icp.AdlCsAmt_String, Globals.Inventory.AdlCsAmt);
				// }
			}

			// MRP
			if (GenericWrappers.isNotEmpty(Globals.Inventory.MRP)) {
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtMRP")).sendKeys(Keys.CONTROL, "a");
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtMRP")).sendKeys(Keys.SHIFT,
						Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtMRP")).sendKeys(Keys.SHIFT,
						Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtMRP")).sendKeys(Keys.SHIFT,
						Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtMRP")).sendKeys(Keys.SHIFT,
						Keys.LEFT);
				GenericWrappers.sleepInSeconds(1);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtMRP")).sendKeys(Keys.DELETE);
				terPage.terminal_waitClearEnterText_css(icp.MRP_String, Globals.Inventory.MRP);
				// webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtMRP")).sendKeys(Keys.RETURN);
				// if (Globals.Inventory.MRP.contains(".")) {
				// icp.setTextValue_Decimal(icp.MRP_String, Globals.Inventory.MRP);
				// } else {
				// icp.setTextValue(icp.MRP_String, Globals.Inventory.MRP);
				// }
			}

			// Basic cost
			if (GenericWrappers.isNotEmpty(Globals.Inventory.BasicCost)) {
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtBasicCost")).sendKeys(Keys.SHIFT,
						Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtBasicCost")).sendKeys(Keys.SHIFT,
						Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtBasicCost")).sendKeys(Keys.SHIFT,
						Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtBasicCost")).sendKeys(Keys.SHIFT,
						Keys.LEFT);
				GenericWrappers.sleepInSeconds(1);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtBasicCost")).sendKeys(Keys.DELETE);
				terPage.terminal_waitClearEnterText_css(icp.Basic_Cost_String, Globals.Inventory.BasicCost);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtBasicCost")).sendKeys(Keys.RETURN);

				// if (Globals.Inventory.BasicCost.contains(".")) {
				// icp.setTextValue_Decimal(icp.Basic_Cost_String, Globals.Inventory.BasicCost);

				// } else {

				// icp.setTextValue(icp.Basic_Cost_String, Globals.Inventory.BasicCost);
				// }

			}

			// Discount per 1
			if (GenericWrappers.isNotEmpty(Globals.Inventory.DiscountPer1)) {
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtDiscountPrc1")).sendKeys(Keys.SHIFT,
						Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtDiscountPrc1")).sendKeys(Keys.SHIFT,
						Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtDiscountPrc1")).sendKeys(Keys.SHIFT,
						Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtDiscountPrc1")).sendKeys(Keys.SHIFT,
						Keys.LEFT);
				GenericWrappers.sleepInSeconds(1);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtDiscountPrc1"))
						.sendKeys(Keys.DELETE);
				terPage.terminal_waitClearEnterText_css(icp.Discount1_String, Globals.Inventory.DiscountPer1);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtDiscountPrc1"))
						.sendKeys(Keys.RETURN);

				// if (Globals.Inventory.DiscountPer1.contains(".")) {
				// icp.setTextValue_Decimal(icp.Discount1_String,
				// Globals.Inventory.DiscountPer1);

				// } else {

				// icp.setTextValue(icp.Discount1_String, Globals.Inventory.DiscountPer1);
				// }

			}

			// Discount per 2
			if (GenericWrappers.isNotEmpty(Globals.Inventory.DiscountPer2)) {
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtDiscountPrc2")).sendKeys(Keys.SHIFT,
						Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtDiscountPrc2")).sendKeys(Keys.SHIFT,
						Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtDiscountPrc2")).sendKeys(Keys.SHIFT,
						Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtDiscountPrc2")).sendKeys(Keys.SHIFT,
						Keys.LEFT);
				GenericWrappers.sleepInSeconds(1);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtDiscountPrc2"))
						.sendKeys(Keys.DELETE);
				terPage.terminal_waitClearEnterText_css(icp.Discount2_String, Globals.Inventory.DiscountPer2);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtDiscountPrc2"))
						.sendKeys(Keys.RETURN);

				// if (Globals.Inventory.DiscountPer2.contains(".")) {
				// icp.setTextValue_Decimal(icp.Discount2_String,
				// Globals.Inventory.DiscountPer2);

				// } else {

				// icp.setTextValue(icp.Discount2_String, Globals.Inventory.DiscountPer2);
				// }

			}
			// Discount per 3
			if (GenericWrappers.isNotEmpty(Globals.Inventory.DiscountPer3)) {
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtDiscountPrc3")).sendKeys(Keys.SHIFT,
						Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtDiscountPrc3")).sendKeys(Keys.SHIFT,
						Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtDiscountPrc3")).sendKeys(Keys.SHIFT,
						Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtDiscountPrc3")).sendKeys(Keys.SHIFT,
						Keys.LEFT);
				GenericWrappers.sleepInSeconds(1);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtDiscountPrc3"))
						.sendKeys(Keys.DELETE);
				terPage.terminal_waitClearEnterText_css(icp.Discount3_String, Globals.Inventory.DiscountPer3);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtDiscountPrc3"))
						.sendKeys(Keys.RETURN);

				// if (Globals.Inventory.DiscountPer3.contains(".")) {

				// icp.setTextValue_Decimal(icp.Discount3_String,
				// Globals.Inventory.DiscountPer3);

				// } else {

				// icp.setTextValue(icp.Discount3_String, Globals.Inventory.DiscountPer3);
				// }

			}

			// sp fixing %
			if (GenericWrappers.isNotEmpty(Globals.Inventory.spfixing)) {
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtFixedMargin")).sendKeys(Keys.SHIFT,
						Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtFixedMargin")).sendKeys(Keys.SHIFT,
						Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtFixedMargin")).sendKeys(Keys.SHIFT,
						Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtFixedMargin")).sendKeys(Keys.SHIFT,
						Keys.LEFT);
				GenericWrappers.sleepInSeconds(1);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtFixedMargin")).sendKeys(Keys.DELETE);
				terPage.terminal_waitClearEnterText_css(icp.SP_String, Globals.Inventory.spfixing);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtFixedMargin")).sendKeys(Keys.RETURN);

				// if (Globals.Inventory.spfixing.contains(".")) {
				// icp.setTextValue_Decimal(icp.SP_String, Globals.Inventory.spfixing);

				// } else {

				// icp.setTextValue(icp.SP_String, Globals.Inventory.spfixing);
				// }

			}

			// WPrice1
			if (GenericWrappers.isNotEmpty(Globals.Inventory.WPrice1)) {
				webDriver
						.findElement(By
								.cssSelector("input#ContentPlaceHolder1_txtMarginWPrice1.form-control-res.text_right"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver
						.findElement(By
								.cssSelector("input#ContentPlaceHolder1_txtMarginWPrice1.form-control-res.text_right"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver
						.findElement(By
								.cssSelector("input#ContentPlaceHolder1_txtMarginWPrice1.form-control-res.text_right"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver
						.findElement(By
								.cssSelector("input#ContentPlaceHolder1_txtMarginWPrice1.form-control-res.text_right"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				GenericWrappers.sleepInSeconds(1);
				webDriver
						.findElement(By
								.cssSelector("input#ContentPlaceHolder1_txtMarginWPrice1.form-control-res.text_right"))
						.sendKeys(Keys.DELETE);
				terPage.terminal_waitClearEnterText_css(icp.WPrice1_String, Globals.Inventory.WPrice1);
				webDriver
						.findElement(By
								.cssSelector("input#ContentPlaceHolder1_txtMarginWPrice1.form-control-res.text_right"))
						.sendKeys(Keys.RETURN);

				// if (Globals.Inventory.WPrice1.contains(".")) {
				// icp.setTextValue_Decimal(icp.WPrice1_String, Globals.Inventory.WPrice1);

				// } else {

				// icp.setTextValue(icp.WPrice1_String, Globals.Inventory.WPrice1);
				// }

			}

			// WPrice2
			if (GenericWrappers.isNotEmpty(Globals.Inventory.WPrice2)) {
				webDriver
						.findElement(By
								.cssSelector("input#ContentPlaceHolder1_txtMarginWPrice2.form-control-res.text_right"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver
						.findElement(By
								.cssSelector("input#ContentPlaceHolder1_txtMarginWPrice2.form-control-res.text_right"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver
						.findElement(By
								.cssSelector("input#ContentPlaceHolder1_txtMarginWPrice2.form-control-res.text_right"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver
						.findElement(By
								.cssSelector("input#ContentPlaceHolder1_txtMarginWPrice2.form-control-res.text_right"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				GenericWrappers.sleepInSeconds(1);
				webDriver
						.findElement(By
								.cssSelector("input#ContentPlaceHolder1_txtMarginWPrice2.form-control-res.text_right"))
						.sendKeys(Keys.DELETE);
				terPage.terminal_waitClearEnterText_css(icp.WPrice2_String, Globals.Inventory.WPrice2);
				webDriver
						.findElement(By
								.cssSelector("input#ContentPlaceHolder1_txtMarginWPrice2.form-control-res.text_right"))
						.sendKeys(Keys.RETURN);

				// if (Globals.Inventory.WPrice2.contains(".")) {
				// icp.setTextValue_Decimal(icp.WPrice2_String, Globals.Inventory.WPrice2);

				// } else {

				// icp.setTextValue(icp.WPrice2_String, Globals.Inventory.WPrice2);
				// }

			}
			// WPrice3
			if (GenericWrappers.isNotEmpty(Globals.Inventory.WPrice3)) {
				webDriver
						.findElement(By
								.cssSelector("input#ContentPlaceHolder1_txtMarginWPrice3.form-control-res.text_right"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver
						.findElement(By
								.cssSelector("input#ContentPlaceHolder1_txtMarginWPrice3.form-control-res.text_right"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver
						.findElement(By
								.cssSelector("input#ContentPlaceHolder1_txtMarginWPrice3.form-control-res.text_right"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver
						.findElement(By
								.cssSelector("input#ContentPlaceHolder1_txtMarginWPrice3.form-control-res.text_right"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				GenericWrappers.sleepInSeconds(1);
				webDriver
						.findElement(By
								.cssSelector("input#ContentPlaceHolder1_txtMarginWPrice3.form-control-res.text_right"))
						.sendKeys(Keys.DELETE);
				terPage.terminal_waitClearEnterText_css(icp.WPrice3_String, Globals.Inventory.WPrice3);
				webDriver
						.findElement(By
								.cssSelector("input#ContentPlaceHolder1_txtMarginWPrice3.form-control-res.text_right"))
						.sendKeys(Keys.RETURN);

				// if (Globals.Inventory.WPrice3.contains(".")) {
				// icp.setTextValue_Decimal(icp.WPrice3_String, Globals.Inventory.WPrice3);

				// } else {

				// icp.setTextValue(icp.WPrice3_String, Globals.Inventory.WPrice3);
				// }

			}
			pass.Excelcreate("Inventory", "Calculation", "Pass", 3, 0, 3, 3);

		} catch (Exception e) {
			// screen shot
			scr.Screenshots();
			System.out.println("Screen shot taken");
			// Xl sheet write
			pass.Excelcreate("Inventory", "Calculation", "FAIL", 3, 0, 3, 3);

		}

	}

	@Then("I fill Order and break price")
	public void i_fill_order_and_break_price() throws Exception {
		try {
			if (GenericWrappers.isNotEmpty(Globals.Inventory.MinQty)) {
				terPage.terminal_waitClearEnterText_css(icp.MinQty_String, Globals.Inventory.MinQty);
				if (GenericWrappers.isNotEmpty(Globals.Inventory.MaxQty)) {
					terPage.terminal_waitClearEnterText_css(icp.MaxQty_String, Globals.Inventory.MaxQty);
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.ReorderQty)) {
					terPage.terminal_waitClearEnterText_css(icp.ReorderQty_String, Globals.Inventory.ReorderQty);
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Orderby)) {
					Select checkbox = new Select(webDriver.findElement((By.id("ContentPlaceHolder1_ddlOrderBy"))));
					checkbox.selectByVisibleText(Globals.Inventory.Orderby);

				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Cycledays)) {
					terPage.terminal_waitClearEnterText_css(icp.Cycledays_String, Globals.Inventory.Cycledays);
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.CheckBox1)) {
					Select checkbox = new Select(webDriver.findElement((By.id("ContentPlaceHolder1_ddlMiniBy"))));
					checkbox.selectByVisibleText(Globals.Inventory.CheckBox1);
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.CheckBox2)) {
					Select checkbox = new Select(webDriver.findElement((By.id("ContentPlaceHolder1_ddlByReOrder"))));
					checkbox.selectByVisibleText(Globals.Inventory.CheckBox2);
				}
			}

			pass.Excelcreate("Inventory", "Breakprice", "Pass", 5, 0, 5, 3);
		} catch (Exception e) {
			// screen shot
			scr.Screenshots();
			System.out.println("Screen shot ");
			// Xl sheet write
			pass.Excelcreate("Inventory", "Breakprice", "FAIL", 5, 0, 5, 3);

		}

	}

	@Then("I fill Activationsettings")
	public void i_fill_Activationsettings_price() throws Exception {
		try {
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch1)) {
				terPage.get_checkBox_element(icp.Batch1_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Expireddate)) {
				terPage.get_checkBox_element(icp.Expireddate_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.SerialnoEntry)) {
				terPage.get_checkBox_element(icp.SerialnoEntry_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.AutoPO)) {
				terPage.get_checkBox_element(icp.AutoPO_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Packageitem)) {
				terPage.get_checkBox_element(icp.Packageitem_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Loyality)) {
				terPage.get_checkBox_element(icp.Loyality_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Special)) {
				terPage.get_checkBox_element(icp.Special_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.ShelfStorage)) {
				terPage.get_checkBox_element(icp.ShelfStorage_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.HideDataOnBarcode)) {
				terPage.get_checkBox_element(icp.HideDataOnBarcode_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Markingitem)) {
				terPage.get_checkBox_element(icp.Markingitem_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.NeedBarcodePrint)) {
				terPage.get_checkBox_element(icp.NeedBarcodePrint_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.AllowCostEditinGRN)) {
				terPage.get_checkBox_element(icp.AllowCostEditinGRN_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Weightbased)) {
				terPage.get_checkBox_element(icp.Weightbased_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.PurchaseOrder)) {
				terPage.get_checkBox_element(icp.PurchaseOrder_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.GRNPurchase)) {
				terPage.get_checkBox_element(icp.GRNPurchase_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Purchasereturn)) {
				terPage.get_checkBox_element(icp.PurchaseReturn_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.PointOfSale)) {
				terPage.get_checkBox_element(icp.PointOfSale_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.AllowNegative)) {
				terPage.get_checkBox_element(icp.AllowNegative_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.TransferDC)) {
				terPage.get_checkBox_element(icp.TransferDC_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.SalesReturn)) {
				terPage.get_checkBox_element(icp.SalesReturn_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.OrderBooking)) {
				terPage.get_checkBox_element(icp.OrderBooking_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Estimation)) {
				terPage.get_checkBox_element(icp.Estimation_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Quatation)) {
				terPage.get_checkBox_element(icp.Quatation_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.OnlineOrder)) {
				terPage.get_checkBox_element(icp.OnlineOrder_String).click();
			}

			pass.Excelcreate("Inventory", "Activationsettings", "Pass", 6, 0, 6, 3);
		} catch (Exception e) {
			// screen shot
			scr.Screenshots();
			System.out.println("Screen shot ");
			// Xl sheet write
			pass.Excelcreate("Inventory", "Activationsettings", "Fail", 6, 0, 6, 3);

		}

	}

	@Then("I fill inventory calculations MRP page using excel data")
	public void i_fill_inventory_calculations_page_MRP_using_excel_data() throws Exception {
		try {
			// cess
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Cess) && !(Globals.Inventory.GSTPer).matches("0")) {

				webDriver
						.findElement(By.cssSelector("input#ContentPlaceHolder1_txtCESSPrc.form-control-res.text-right"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver
						.findElement(By.cssSelector("input#ContentPlaceHolder1_txtCESSPrc.form-control-res.text-right"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver
						.findElement(By.cssSelector("input#ContentPlaceHolder1_txtCESSPrc.form-control-res.text-right"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver
						.findElement(By.cssSelector("input#ContentPlaceHolder1_txtCESSPrc.form-control-res.text-right"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				GenericWrappers.sleepInSeconds(1);
				webDriver
						.findElement(By.cssSelector("input#ContentPlaceHolder1_txtCESSPrc.form-control-res.text-right"))
						.sendKeys(Keys.DELETE);
				terPage.terminal_waitClearEnterText_css(icp.Cess_String, Globals.Inventory.Cess);
				webDriver
						.findElement(By.cssSelector("input#ContentPlaceHolder1_txtCESSPrc.form-control-res.text-right"))
						.sendKeys(Keys.RETURN);
				// if (Globals.Inventory.Cess.contains(".")) {
				// icp.setTextValue_Decimal(icp.Cess_String, Globals.Inventory.Cess);
				// } else {
				// icp.setTextValue(icp.Cess_String, Globals.Inventory.Cess);
				// }
			}

			// Additional cess amount
			if (GenericWrappers.isNotEmpty(Globals.Inventory.AdlCsAmt) && !(Globals.Inventory.GSTPer).matches("0")) {
				webDriver
						.findElement(
								By.cssSelector("input#ContentPlaceHolder1_txtAddCessAmt.form-control-res.text-right"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver
						.findElement(
								By.cssSelector("input#ContentPlaceHolder1_txtAddCessAmt.form-control-res.text-right"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver
						.findElement(
								By.cssSelector("input#ContentPlaceHolder1_txtAddCessAmt.form-control-res.text-right"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver
						.findElement(
								By.cssSelector("input#ContentPlaceHolder1_txtAddCessAmt.form-control-res.text-right"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				GenericWrappers.sleepInSeconds(1);
				webDriver
						.findElement(
								By.cssSelector("input#ContentPlaceHolder1_txtAddCessAmt.form-control-res.text-right"))
						.sendKeys(Keys.DELETE);
				terPage.terminal_waitClearEnterText_css(icp.AdlCsAmt_String, Globals.Inventory.AdlCsAmt);
				webDriver
						.findElement(
								By.cssSelector("input#ContentPlaceHolder1_txtAddCessAmt.form-control-res.text-right"))
						.sendKeys(Keys.RETURN);
				// if (Globals.Inventory.AdlCsAmt.contains(".")) {
				// icp.setTextValue_Decimal(icp.AdlCsAmt_String, Globals.Inventory.AdlCsAmt);
				// } else {
				// icp.setTextValue(icp.AdlCsAmt_String, Globals.Inventory.AdlCsAmt);
				// }
			}

			// MRP
			if (GenericWrappers.isNotEmpty(Globals.Inventory.MRP)) {
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtMRP")).sendKeys(Keys.CONTROL, "a");
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtMRP")).sendKeys(Keys.SHIFT,
						Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtMRP")).sendKeys(Keys.SHIFT,
						Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtMRP")).sendKeys(Keys.SHIFT,
						Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtMRP")).sendKeys(Keys.SHIFT,
						Keys.LEFT);
				GenericWrappers.sleepInSeconds(1);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtMRP")).sendKeys(Keys.DELETE);
				terPage.terminal_waitClearEnterText_css(icp.MRP_String, Globals.Inventory.MRP);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtMRP")).sendKeys(Keys.RETURN);
				// if (Globals.Inventory.MRP.contains(".")) {
				// icp.setTextValue_Decimal(icp.MRP_String, Globals.Inventory.MRP);
				// } else {
				// icp.setTextValue(icp.MRP_String, Globals.Inventory.MRP);
				// }
			}

			// Discount per
			if (GenericWrappers.isNotEmpty(Globals.Inventory.DiscountPer)) {
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtMRPMarkDown")).sendKeys(Keys.SHIFT,
						Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtMRPMarkDown")).sendKeys(Keys.SHIFT,
						Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtMRPMarkDown")).sendKeys(Keys.SHIFT,
						Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtMRPMarkDown")).sendKeys(Keys.SHIFT,
						Keys.LEFT);
				GenericWrappers.sleepInSeconds(1);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtMRPMarkDown")).sendKeys(Keys.DELETE);
				terPage.terminal_waitClearEnterText_css(icp.Discount_String, Globals.Inventory.DiscountPer);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtMRPMarkDown")).sendKeys(Keys.RETURN);
				// if (Globals.Inventory.DiscountPer.contains(".")) {
				// icp.setTextValue_Decimal(icp.Discount_String, Globals.Inventory.DiscountPer);

				// } else {

				// icp.setTextValue(icp.Discount_String, Globals.Inventory.DiscountPer);
				// }

			}

			// Additional Discount per
			if (GenericWrappers.isNotEmpty(Globals.Inventory.AddDiscountPer)) {
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtAdDiscount")).sendKeys(Keys.SHIFT,
						Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtAdDiscount")).sendKeys(Keys.SHIFT,
						Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtAdDiscount")).sendKeys(Keys.SHIFT,
						Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtAdDiscount")).sendKeys(Keys.SHIFT,
						Keys.LEFT);
				GenericWrappers.sleepInSeconds(1);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtAdDiscount")).sendKeys(Keys.DELETE);
				terPage.terminal_waitClearEnterText_css(icp.AddDiscountPer_String, Globals.Inventory.AddDiscountPer);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtAdDiscount")).sendKeys(Keys.RETURN);

				// if (Globals.Inventory.AddDiscountPer.contains(".")) {
				// icp.setTextValue_Decimal(icp.AddDiscountPer_String,
				// Globals.Inventory.AddDiscountPer);

				// } else {

				// icp.setTextValue(icp.AddDiscountPer_String,
				// Globals.Inventory.AddDiscountPer);
				// }

			}

			// sp fixing %
			if (GenericWrappers.isNotEmpty(Globals.Inventory.spfixing)) {
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtFixedMargin")).sendKeys(Keys.SHIFT,
						Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtFixedMargin")).sendKeys(Keys.SHIFT,
						Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtFixedMargin")).sendKeys(Keys.SHIFT,
						Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtFixedMargin")).sendKeys(Keys.SHIFT,
						Keys.LEFT);
				GenericWrappers.sleepInSeconds(1);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtFixedMargin")).sendKeys(Keys.DELETE);
				terPage.terminal_waitClearEnterText_css(icp.SP_String, Globals.Inventory.spfixing);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtFixedMargin")).sendKeys(Keys.RETURN);

				// if (Globals.Inventory.spfixing.contains(".")) {
				// icp.setTextValue_Decimal(icp.SP_String, Globals.Inventory.spfixing);

				// } else {

				// icp.setTextValue(icp.SP_String, Globals.Inventory.spfixing);
				// }

			}

			// WPrice1
			if (GenericWrappers.isNotEmpty(Globals.Inventory.WPrice1)) {
				webDriver
						.findElement(By
								.cssSelector("input#ContentPlaceHolder1_txtMarginWPrice1.form-control-res.text_right"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver
						.findElement(By
								.cssSelector("input#ContentPlaceHolder1_txtMarginWPrice1.form-control-res.text_right"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver
						.findElement(By
								.cssSelector("input#ContentPlaceHolder1_txtMarginWPrice1.form-control-res.text_right"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver
						.findElement(By
								.cssSelector("input#ContentPlaceHolder1_txtMarginWPrice1.form-control-res.text_right"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				GenericWrappers.sleepInSeconds(1);
				webDriver
						.findElement(By
								.cssSelector("input#ContentPlaceHolder1_txtMarginWPrice1.form-control-res.text_right"))
						.sendKeys(Keys.DELETE);
				terPage.terminal_waitClearEnterText_css(icp.WPrice1_String, Globals.Inventory.WPrice1);
				webDriver
						.findElement(By
								.cssSelector("input#ContentPlaceHolder1_txtMarginWPrice1.form-control-res.text_right"))
						.sendKeys(Keys.RETURN);

				// if (Globals.Inventory.WPrice1.contains(".")) {
				// icp.setTextValue_Decimal(icp.WPrice1_String, Globals.Inventory.WPrice1);

				// } else {

				// icp.setTextValue(icp.WPrice1_String, Globals.Inventory.WPrice1);
				// }

			}

			// WPrice2
			if (GenericWrappers.isNotEmpty(Globals.Inventory.WPrice2)) {
				webDriver
						.findElement(By
								.cssSelector("input#ContentPlaceHolder1_txtMarginWPrice2.form-control-res.text_right"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver
						.findElement(By
								.cssSelector("input#ContentPlaceHolder1_txtMarginWPrice2.form-control-res.text_right"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver
						.findElement(By
								.cssSelector("input#ContentPlaceHolder1_txtMarginWPrice2.form-control-res.text_right"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver
						.findElement(By
								.cssSelector("input#ContentPlaceHolder1_txtMarginWPrice2.form-control-res.text_right"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				GenericWrappers.sleepInSeconds(1);
				webDriver
						.findElement(By
								.cssSelector("input#ContentPlaceHolder1_txtMarginWPrice2.form-control-res.text_right"))
						.sendKeys(Keys.DELETE);
				terPage.terminal_waitClearEnterText_css(icp.WPrice2_String, Globals.Inventory.WPrice2);
				webDriver
						.findElement(By
								.cssSelector("input#ContentPlaceHolder1_txtMarginWPrice2.form-control-res.text_right"))
						.sendKeys(Keys.RETURN);

				// if (Globals.Inventory.WPrice2.contains(".")) {
				// icp.setTextValue_Decimal(icp.WPrice2_String, Globals.Inventory.WPrice2);

				// } else {

				// icp.setTextValue(icp.WPrice2_String, Globals.Inventory.WPrice2);
				// }

			}
			// WPrice3
			if (GenericWrappers.isNotEmpty(Globals.Inventory.WPrice3)) {
				webDriver
						.findElement(By
								.cssSelector("input#ContentPlaceHolder1_txtMarginWPrice3.form-control-res.text_right"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver
						.findElement(By
								.cssSelector("input#ContentPlaceHolder1_txtMarginWPrice3.form-control-res.text_right"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver
						.findElement(By
								.cssSelector("input#ContentPlaceHolder1_txtMarginWPrice3.form-control-res.text_right"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver
						.findElement(By
								.cssSelector("input#ContentPlaceHolder1_txtMarginWPrice3.form-control-res.text_right"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				GenericWrappers.sleepInSeconds(1);
				webDriver
						.findElement(By
								.cssSelector("input#ContentPlaceHolder1_txtMarginWPrice3.form-control-res.text_right"))
						.sendKeys(Keys.DELETE);
				terPage.terminal_waitClearEnterText_css(icp.WPrice3_String, Globals.Inventory.WPrice3);
				webDriver
						.findElement(By
								.cssSelector("input#ContentPlaceHolder1_txtMarginWPrice3.form-control-res.text_right"))
						.sendKeys(Keys.RETURN);
				// if (Globals.Inventory.WPrice3.contains(".")) {
				// icp.setTextValue_Decimal(icp.WPrice3_String, Globals.Inventory.WPrice3);

				// } else {

				// icp.setTextValue(icp.WPrice3_String, Globals.Inventory.WPrice3);
				// }

				// driver.findElement(By.id("lst-ib")).sendKeys(Keys.RETURN);

			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Barcode)) {
				terPage.terminal_waitClearEnterText_css(icp.Barcode_String, Globals.Inventory.Barcode);
			}
			pass.Excelcreate("Inventory", "MRP", "Fail", 1, 0, 1, 1);
		} catch (Exception e) {
			// screen shot
			scr.Screenshots();
			System.out.println("Screen shot ");
			// Xl sheet write
			pass.Excelcreate("Inventory", "MRP", "Fail", 1, 0, 1, 1);

		}

	}

	private WebElement findElement(SearchContext id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Then("I fill the GST values in the inventory page")
	public void i_fill_the_GST_values_in_the_inventory_page() throws IOException {
		try {

			try {
				terPage.return_dd_invoke_element("-- Select --", 0).click();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				terPage.return_dd_invoke_element("-- Select --", 0).click();

			}

			// WebElement dd_element =
			// terPage.waitAndSelectDropDownUsingSerachBox(Globals.Inventory.GSTPer,
			// "IGST");
			GenericWrappers.sleepInSeconds(4);

			icp.search_dd_value(Globals.Inventory.GSTPer);
			pass.Excelcreate("Inventory", "GST", "Pass", 2, 0, 2, 3);
			// dd_element.sendKeys(Keys.SPACE);
			// dd_element.sendKeys(Keys.SPACE);
			// dd_element.sendKeys(Keys.ARROW_DOWN);
			// try {
			// Thread.sleep(1000);
			// } catch (InterruptedException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }
			//
			// dd_element.sendKeys(Keys.ENTER);
		} catch (Exception e) {
			pass.Excelcreate("Inventory", "GST", "Fail",2, 0, 2, 3);
		}
	}

	@Then("I close connection to DB")
	public void I_close_connection_to_DB() throws SQLException {

		mysqlConnect.disconnect();
		System.out.println(" closed succesfully");

		// mysqlConnect.disconnect();

	}

	MssqlConnect mysqlConnect;
	Statement st;

	@Then("I establish connection to DB")
	public void I_establish_connection_to_DB() throws SQLException {

		mysqlConnect = new MssqlConnect();
		st = mysqlConnect.connect().createStatement();
		System.out.println(" Connected succesfully");

	}

	@Given("I read the values from table {string} in DB")
	public void i_want_to_launch_the(String tablename) throws SQLException, IOException {

		System.out.println(tablename);
		// ResultSet rs =st.executeQuery("select * from "+tablename+" where
		// DeptCode='Gopi'");

		ResultSet rs = st.executeQuery("select * from " + tablename + " where inventorycode='859607'");

		// ResultSet rs = st.executeQuery("");

		while (rs.next()) {

			switch (tablename) {

			case "tbldepartment":
				String DepartmentCode = "";
				try {
					DepartmentCode = rs.getString("DeptCode");
					System.out.println(DepartmentCode);
					Assert.assertEquals(Globals.Inventory.Department.trim(), DepartmentCode.trim());
					pass.Excelcreate("Inventory", "tbldepartment", "", 7, 0, 7, 1);
					pass.ExcelFourData("Inventory", "Department", Globals.Inventory.Department, DepartmentCode,
							"Pass", 8, 0, 8, 1, 8, 2, 8, 3);

				} catch (AssertionError e) {
					pass.Excelcreate("Inventory", "tbldepartment", "", 7, 0, 7, 1);
					pass.ExcelFourData("Inventory", "Department", Globals.Inventory.Department, DepartmentCode,
							"Fail", 8, 0, 8, 1, 8, 2, 8, 3);

				}

				break;

			case "tblinventory":
				String CategoryCode = "";
				try {
					CategoryCode = rs.getString("CategoryCode");
					System.out.println(CategoryCode);
					Assert.assertEquals(Globals.Inventory.Category.trim(), CategoryCode.trim());
					pass.Excelcreate("Inventory", "tblinventory", "", 9, 0, 9, 1);
					pass.ExcelFourData("Inventory", "CategoryCode", Globals.Inventory.Category, CategoryCode, "Pass",
							10, 0, 10, 1, 10, 2, 10, 3);
				} catch (AssertionError e) {
					pass.Excelcreate("Inventory", "tblinventory", "", 9, 0, 9, 1);
					pass.ExcelFourData("Inventory", "CategoryCode", Globals.Inventory.Category, CategoryCode, "Fail",
							10, 0, 10, 1, 10, 2, 10, 3);

				}
				catch(Exception e) {
					System.out.println("null error tblinventory column CategoryCode");
					}
				String Departmentcode = "";
				try {
					Departmentcode = rs.getString("Departmentcode");
					System.out.println(Departmentcode);
					Assert.assertEquals(Globals.Inventory.Department.trim(), Departmentcode.trim());
					pass.ExcelFourData("Inventory", "Departmentcode", Globals.Inventory.Department, Departmentcode, "Pass",
							11, 0, 11, 1, 11, 2, 11, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("Inventory", "Departmentcode", Globals.Inventory.Department, Departmentcode, "Fail",
							11, 0, 11, 1, 11, 2, 11, 3);
				}
				catch(Exception e) {
					System.out.println("null error tblinventory column Departmentcode");
					}
				String Brandcode = "";
				try {
					Brandcode = rs.getString("BrandCode");
					System.out.println(Brandcode);
					Assert.assertEquals(Globals.Inventory.Brand.trim(), Brandcode.trim());
					pass.ExcelFourData("Inventory", "BrandCode", Globals.Inventory.Brand, Brandcode, "Fail",
							12, 0, 12, 1, 12, 2, 12, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("Inventory", "BrandCode", Globals.Inventory.Brand, Brandcode, "Fail",
							12, 0, 12, 1, 12, 2, 12, 3);
				}
				catch(Exception e) {
					System.out.println("null error tblinventory column BrandCode");
					}
				String Barcode = "";
				try {
					Barcode = rs.getString("Barcode");
					System.out.println(Barcode);
					Assert.assertEquals(Globals.Inventory.Barcode.trim(), Barcode.trim());
					pass.ExcelFourData("Inventory", "Barcode", Globals.Inventory.Barcode, Barcode, "Pass",
							13, 0, 13, 1, 13, 2, 13, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("Inventory", "Barcode", Globals.Inventory.Barcode, Barcode, "Fail",
							13, 0, 13, 1, 13, 2, 13, 3);
				}
				catch(Exception e) {
					System.out.println("null error tblinventory column Barcode");
					}
				String Subcategory = "";
				try {
					Subcategory = rs.getString("Subcategorycode");
					System.out.println(Subcategory);
					Assert.assertEquals(Globals.Inventory.SubCategory.trim(), Subcategory.trim());
					pass.ExcelFourData("Inventory", "Subcategory", Globals.Inventory.SubCategory, Subcategory, "Pass",
							14, 0, 14, 1, 14, 2, 14, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("Inventory", "Subcategory", Globals.Inventory.SubCategory, Subcategory, "Fail",
							14, 0, 14, 1, 14, 2, 14, 3);
				}
				catch(Exception e) {
					System.out.println("null error tblinventory column Subcategorycode");
					}
				String Class = "";
				try {

					Class = rs.getString("Class");
					System.out.println(Class);
					Assert.assertEquals(Globals.Inventory.Class.trim(), Class.trim());
					pass.ExcelFourData("Inventory", "Class", Globals.Inventory.Class, Class, "Pass",
							15, 0, 15, 1, 15, 2,15, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("Inventory", "Class", Globals.Inventory.Class, Class, "Fail",
							15, 0, 15, 1, 15, 2,15, 3);
				}
				catch(Exception e) {
					System.out.println("null error tblinventory column Class");
					}
				
				String SubClass = "";
				try {
					SubClass = rs.getString("SubClass");
					System.out.println(SubClass);
					Assert.assertEquals(Globals.Inventory.SubClass.trim(), SubClass.trim());
					pass.ExcelFourData("Inventory", "SubClass", Globals.Inventory.SubClass, SubClass, "Pass",
							16, 0, 16, 1, 16, 2, 16, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("Inventory", "Actual,Expected", Globals.Inventory.SubClass, SubClass, "Fail",
							16, 0, 16, 1, 16, 2, 16, 3);
				}
				catch(Exception e) {
					System.out.println("null error tblinventory column SubClass");
					}
				String Origion="";
				try
				{
			    Origion = rs.getString("Origin");
				System.out.println(Origion);
				Assert.assertEquals(Globals.Inventory.Origin.trim(), Origion.trim());
				pass.ExcelFourData("Inventory", "Origin", Globals.Inventory.Origin, Origion, "Pass",
						17, 0, 17, 1, 17, 2, 17, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory", "Origin", Globals.Inventory.Origin, Origion, "Fail",
						17, 0, 17, 1, 17, 2, 17, 3);
			}
				catch(Exception e) {
					System.out.println("null error tblinventory column Origin");
					}
				String Warehouse="";
				try
				{
			    Warehouse = rs.getString("Warehouse");
				System.out.println(Warehouse);
				Assert.assertEquals(Globals.Inventory.WareHouse.trim(), Warehouse.trim());
				pass.ExcelFourData("Inventory", "Warehouse", Globals.Inventory.WareHouse, Warehouse, "Pass",
						18, 0, 18, 1, 18, 2, 18, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory", "Warehouse", Globals.Inventory.WareHouse, Warehouse, "Fail",
						18, 0, 18, 1, 18, 2, 18, 3);
			}
				catch(Exception e) {
					System.out.println("null error tblinventory column Warehouse");
					}
				String UOM="";
				try {
			    UOM = rs.getString("UOM");
				System.out.println(UOM);
				Assert.assertEquals(Globals.Inventory.UOMPurchase.trim(), UOM.trim());
				pass.ExcelFourData("Inventory", "UOM", Globals.Inventory.UOMPurchase, UOM, "Pass",
						19, 0, 19, 1, 19, 2, 19, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory", "UOM", Globals.Inventory.UOMPurchase, UOM, "Fail",
						19, 0, 19, 1, 19, 2, 19, 3);
			}
				catch(Exception e) {
					System.out.println("null error tblinventory column UOM");
					}
				String Manufacture="";
			try {
					
				Manufacture = rs.getString("Manufacturer");
				System.out.println(Manufacture);
				Assert.assertEquals(Globals.Inventory.Manufacture.trim(), Manufacture.trim());
				pass.ExcelFourData("Inventory", "Manufacturer", Globals.Inventory.Manufacture, Manufacture, "Pass",
						20, 0, 20, 1, 20, 2, 20, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory", "Manufacturer", Globals.Inventory.Manufacture, Manufacture, "Fail",
						20, 0, 20, 1, 20, 2, 20, 3);
			}
			catch(Exception e) {
				System.out.println("null error tblinventory column Manufacturer");
				}
			String ItemType="";
			try {
				
			    ItemType = rs.getString("ItemType");
				System.out.println(ItemType);
				Assert.assertEquals(Globals.Inventory.ItemType.trim(), ItemType.trim());
				pass.ExcelFourData("Inventory", "ItemType", Globals.Inventory.ItemType, ItemType, "Pass",
						21, 0, 21, 1, 21, 2, 21, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory", "ItemType", Globals.Inventory.ItemType, ItemType, "Fail",
						21, 0, 21, 1, 21, 2, 21, 3);
			}
			catch(Exception e) {
				System.out.println("null error tblinventory column ItemType");
				}
			String Weight="";
			try {
				Weight = rs.getString("Weight");
				System.out.println(Weight);
				Assert.assertEquals(Globals.Inventory.Weight.trim(), Weight.trim());
				pass.ExcelFourData("Inventory", "Weight", Globals.Inventory.Weight, Weight, "Pass",
						22, 0, 22, 1, 22, 2, 22, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory", "Weight", Globals.Inventory.Weight, Weight, "Fail",
						22, 0, 22, 1, 22, 2, 22, 3);
			}
			catch(Exception e) {
				System.out.println("null error tblinventory column Weight");
				}
			String Width="";
			try {
			    Width = rs.getString("Width");
			    System.out.println(Width);
			    Assert.assertEquals(Globals.Inventory.Width.trim(), Width.trim());
			    pass.ExcelFourData("Inventory", "Width", Globals.Inventory.Width, Width, "Pass",
						23, 0, 23, 1, 23, 2, 23, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory", "Width", Globals.Inventory.Width, Width, "Fail",
						23, 0, 23, 1, 23, 2, 23, 3);
			}
			catch(Exception e) {
			System.out.println("null error tblinventory column Width");
			}
			String Height="";
			try {
				Height = rs.getString("Height");
				System.out.println(Height);
				Assert.assertEquals(Globals.Inventory.Height.trim(), Height.trim());
				pass.ExcelFourData("Inventory", "Height", Globals.Inventory.Height, Height, "Pass",
						24, 0, 24, 1, 24, 2, 24, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory", "Height", Globals.Inventory.Height, Height, "Fail",
						24, 0, 24, 1, 24, 2, 24, 3);
			}
			catch(Exception e) {
				System.out.println("null error tblinventory column Height");
			}
			String Length="";
			try {
			    Length = rs.getString("Length");
				System.out.println(Length);
				Assert.assertEquals(Globals.Inventory.Length.trim(), Length.trim());
				pass.ExcelFourData("Inventory", "Length", Globals.Inventory.Length, Length, "Pass",
						25, 0, 25, 1, 25, 2, 25, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory", "Length", Globals.Inventory.Length, Length, "Fail",
						25, 0, 25, 1, 25, 2, 25, 3);
			}
			catch(Exception e) {
				System.out.println("null error tblinventory column Length");
			}
			String Vendorcode="";
			try {
				Vendorcode = rs.getString("VendorCode");
				System.out.println(Vendorcode);
				Assert.assertEquals(Globals.Inventory.Vendor.trim(), Vendorcode.trim());
				pass.ExcelFourData("Inventory", "VendorCode", Globals.Inventory.Vendor, Vendorcode, "Pass",
						26, 0, 26, 1, 26, 2, 26, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory", "VendorCode", Globals.Inventory.Vendor, Vendorcode, "Fail",
						26, 0, 26, 1, 26, 2, 26, 3);
			}
			catch(Exception e) {
				System.out.println("null error tblinventory column VendorCode");
			}
			String Basicost ="";
			try {
				Basicost = rs.getString("UnitCost");
				System.out.println(Basicost);
				Assert.assertEquals(Globals.Inventory.BasicCost.trim(), Basicost.trim());
				pass.ExcelFourData("Inventory", "BasicCost", Globals.Inventory.BasicCost, Basicost, "Pass",
						27, 0, 27, 1, 27, 2, 27, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory", "BasicCost", Globals.Inventory.BasicCost, Basicost, "Fail",
						27, 0, 27, 1, 27, 2, 27, 3);
			}
			catch(Exception e) {
				System.out.println("null error tblinventory column UnitCost");
			}
			String Sellingprice="";
			try {
				Sellingprice = rs.getString("SellingPrice");
				System.out.println(Sellingprice);
				Assert.assertEquals(Globals.Inventory.NetSellingPrice.trim(), Sellingprice.trim());
				pass.ExcelFourData("Inventory", "SellingPrice", Globals.Inventory.NetSellingPrice, Sellingprice, "Pass",
						28, 0, 28, 1, 28, 2, 28, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory", "SellingPrice", Globals.Inventory.NetSellingPrice, Sellingprice, "Fail",
						28, 0, 28, 1, 28, 2, 28, 3);
			}
			catch(Exception e) {
				System.out.println("null error tblinventory column SellingPrice");
			}
			String MRP="";
			try
			{
				MRP = rs.getString("MRP");
				System.out.println(MRP);
				Assert.assertEquals(Globals.Inventory.MRP.trim(), MRP.trim());
				pass.ExcelFourData("Inventory", "MRP", Globals.Inventory.MRP, MRP, "Pass",
						29, 0, 29, 1, 29, 2, 29, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory", "MRP", Globals.Inventory.MRP, MRP, "Fail",
						29, 0, 29, 1, 29, 2, 29, 3);
			}
			catch(Exception e) {
				System.out.println("null error tblinventory column MRP");
			}
			String MinQty="";
			try
			{
				MinQty = rs.getString("MinimumQtyLevel");
				System.out.println(MinQty);
				Assert.assertEquals(Globals.Inventory.MinQty.trim(), MinQty.trim());
				pass.ExcelFourData("Inventory", "MinQty", Globals.Inventory.MinQty, MinQty, "Pass",
						30, 0, 30, 1, 30, 2, 30, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory", "MinQty", Globals.Inventory.MinQty, MinQty, "Fail",
						30, 0, 30, 1, 30, 2, 30, 3);
			}
			catch(Exception e) {
				System.out.println("null error tblinventory column MinimumQtyLevel");
			}
			String MaxQty="";
			try {
				MaxQty = rs.getString("MaximumQtyLevel");
				System.out.println(MaxQty);
				Assert.assertEquals(Globals.Inventory.MaxQty.trim(), MaxQty.trim());
				pass.ExcelFourData("Inventory", "MaxQty", Globals.Inventory.MaxQty, MaxQty, "Pass",
						31, 0, 31, 1, 31, 2, 31, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory", "MaxQty", Globals.Inventory.MaxQty, MaxQty, "Fail",
						31, 0, 31, 1, 31, 2, 31, 3);
			}
			catch(Exception e) {
				System.out.println("null error tblinventory column MaximumQtyLevel");
			}
			String ReorderQty="";
			try {
				ReorderQty = rs.getString("ReOrderLevel");
				System.out.println(ReorderQty);
				Assert.assertEquals(Globals.Inventory.ReorderQty.trim(), ReorderQty.trim());
				pass.ExcelFourData("Inventory", "ReorderQty", Globals.Inventory.ReorderQty, ReorderQty, "Pass",
						32, 0, 32, 1, 32, 2, 32, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory", "ReorderQty", Globals.Inventory.ReorderQty, ReorderQty, "Fail",
						32, 0, 32, 1, 32, 2, 32, 3);
			}
			catch(Exception e) {
				System.out.println("null error tblinventory column ReOrderLevel");
			}
			String Cycledays="";
			try {
				Cycledays = rs.getString("ReOrderDays");
				System.out.println(Cycledays);
				Assert.assertEquals(Globals.Inventory.Cycledays.trim(), Cycledays.trim());
				pass.ExcelFourData("Inventory", "Cycledays", Globals.Inventory.Cycledays, Cycledays, "Pass",
						33, 0, 33, 1, 33, 2, 33, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory", "Cycledays", Globals.Inventory.Cycledays, Cycledays, "Fail",
						33, 0, 33, 1, 33, 2, 33, 3);
			}
			catch(Exception e) {
				System.out.println("null error tblinventory column ReOrderDays");
			}
			String Orderby="";
			try {
				Orderby = rs.getString("AutoPOReqBy");
				System.out.println(Orderby);
				Assert.assertEquals(Globals.Inventory.Orderby.trim(), Orderby.trim());
				pass.ExcelFourData("Inventory", "Orderby", Globals.Inventory.Orderby, Orderby, "Pass",
						34, 0, 34, 1, 34, 2, 34, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory", "Orderby", Globals.Inventory.Orderby, Orderby, "Fail",
						34, 0, 34, 1, 34, 2, 34, 3);
			}
			catch(Exception e) {
				System.out.println("null error tblinventory column AutoPOReqBy");
			}
			String CheckBox1="";
			try {
			    CheckBox1 = rs.getString("MinQtycalBy");
				System.out.println(CheckBox1);
				Assert.assertEquals(Globals.Inventory.CheckBox1.trim(), CheckBox1.trim());
				pass.ExcelFourData("Inventory", "MinQtycalBy", Globals.Inventory.CheckBox1, CheckBox1, "Pass",
						35, 0, 35, 1, 35, 2, 35, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory", "MinQtycalBy", Globals.Inventory.CheckBox1, CheckBox1, "Fail",
						35, 0, 35, 1, 35, 2, 35, 3);
			}
			catch(Exception e) {
				System.out.println("null error tblinventory column MinQtycalBy");
			}
			String CheckBox2="";
			try {
				CheckBox2 = rs.getString("ReOrderBy");
				System.out.println(CheckBox2);
				Assert.assertEquals(Globals.Inventory.CheckBox2.trim(), CheckBox2.trim());
				pass.ExcelFourData("Inventory", "ReOrderBy", Globals.Inventory.CheckBox2, CheckBox2, "Pass",
						36, 0, 36, 1, 36, 2, 36, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory", "ReOrderBy", Globals.Inventory.CheckBox2, CheckBox2, "Fail",
						36, 0, 36, 1, 36, 2, 36, 3);
			}
			catch(Exception e) {
				System.out.println("null error tblinventory column ReOrderBy");
			}
				break;

			case "tblinventorypricing":
				String BasicSelling ="";
				try {
				BasicSelling = rs.getString("NetSellingPrice");
				System.out.println(BasicSelling);
				Assert.assertEquals(Globals.Inventory.NetSellingPrice.trim(), BasicSelling.trim());
				pass.Excelcreate("Inventory", "tblinventorypricing", "", 38, 0, 38, 1);
				pass.ExcelFourData("Inventory", "NetSellingPrice", Globals.Inventory.NetSellingPrice, BasicSelling, "Pass",
						39, 0, 39, 1, 39, 2, 39, 3);
			} catch (AssertionError e) {
				pass.Excelcreate("Inventory", "tblinventorypricing", "", 38, 0, 38, 1);
				pass.ExcelFourData("Inventory", "NetSellingPrice", Globals.Inventory.NetSellingPrice, BasicSelling, "Fail",
						39, 0, 39, 1, 39, 2, 39, 3);
			}
				catch(Exception e) {
					System.out.println("null error tblinventorypricing column NetSellingPrice");
				}
				String Purchasetype="";
				try {
			    Purchasetype = rs.getString("PurchasedBy");
				System.out.println(Purchasetype);
				Assert.assertEquals(Globals.Inventory.Purchasetype.trim(), Purchasetype.trim());
				pass.ExcelFourData("Inventory", "Purchasetype", Globals.Inventory.Purchasetype, Purchasetype, "Pass",
						40, 0, 40, 1, 40, 2, 40, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory", "Purchasetype", Globals.Inventory.Purchasetype, Purchasetype, "Fail",
						40, 0, 40, 1, 40, 2, 40, 3);
			}
				catch(Exception e) {
					System.out.println("null error tblinventorypricing column PurchasedBy");
				}
				String MRP1 ="";
				try {
				MRP1 = rs.getString("MRP");
				System.out.println(MRP1);
				Assert.assertEquals(Globals.Inventory.MRP.trim(), MRP1.trim());
				pass.ExcelFourData("Inventory", "MRP", Globals.Inventory.MRP, MRP1, "Pass",
						41, 0, 41, 1, 41, 2, 41, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory", "MRP", Globals.Inventory.MRP, MRP1, "Fail",
						41, 0, 41, 1, 41, 2, 41, 3);
			}
				catch(Exception e) {
					System.out.println("null error tblinventorypricing column MRP");
				}
				String Basicost1="";
				try {
				Basicost1 = rs.getString("BasicCost");
				System.out.println(Basicost1);
				Assert.assertEquals(Globals.Inventory.BasicCost.trim(), Basicost1.trim());
				pass.ExcelFourData("Inventory", "BasicCost", Globals.Inventory.BasicCost, Basicost1, "Pass",
						42, 0, 42, 1, 42, 2, 42, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory", "BasicCost", Globals.Inventory.BasicCost, Basicost1, "Fail",
						42, 0, 42, 1, 42, 2, 42, 3);
			}
				catch(Exception e) {
					System.out.println("null error tblinventorypricing column BasicCost");
				}
				String DiscountPer1="";
				try {
				DiscountPer1 = rs.getString("DiscountBasicPer");
				System.out.println(DiscountPer1);
				Assert.assertEquals(Globals.Inventory.DiscountPer1.trim(), DiscountPer1.trim());
				pass.ExcelFourData("Inventory", "DiscountPer1", Globals.Inventory.DiscountPer1, DiscountPer1, "Pass",
						43, 0, 43, 1, 43, 2, 43, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory", "DiscountPer1", Globals.Inventory.DiscountPer1, DiscountPer1, "Fail",
						43, 0, 43, 1, 43, 2, 43, 3);
			}
				catch(Exception e) {
					System.out.println("null error tblinventorypricing column DiscountBasicPer");
				}
				String DiscountPer2 ="";
				try {
				DiscountPer2 = rs.getString("DiscountBasicPer2");
				System.out.println(DiscountPer2);
				Assert.assertEquals(Globals.Inventory.DiscountPer2.trim(), DiscountPer2.trim());
				pass.ExcelFourData("Inventory", "DiscountPer2", Globals.Inventory.DiscountPer2, DiscountPer2, "Pass",
						44, 0, 44, 1, 44, 2, 44, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory", "DiscountPer2", Globals.Inventory.DiscountPer2, DiscountPer2, "Fail",
						44, 0, 44, 1, 44, 2, 44, 3);
			}
				catch(Exception e) {
					System.out.println("null error tblinventorypricing column DiscountBasicPer2");
				}
				String DiscountPer3="";
				try {
				DiscountPer3 = rs.getString("DiscountBasicPer3");
				System.out.println(DiscountPer3);
				Assert.assertEquals(Globals.Inventory.DiscountPer3.trim(), DiscountPer3.trim());
				pass.ExcelFourData("Inventory", "DiscountPer3", Globals.Inventory.DiscountPer3, DiscountPer3, "Pass",
						45, 0, 45, 1, 45, 2, 45, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory", "DiscountPer3", Globals.Inventory.DiscountPer3, DiscountPer3, "Fail",
						45, 0, 45, 1, 45, 2, 45, 3);
			}
				catch(Exception e) {
					System.out.println("null error tblinventorypricing column DiscountBasicPer3");
				}
		
				String W3 ="";
				try {
				W3 = rs.getString("MPWPrice3");
				System.out.println(W3);
				Assert.assertEquals(Globals.Inventory.WPrice3.trim(), W3.trim());
				pass.ExcelFourData("Inventory", "WPrice3", Globals.Inventory.WPrice3, W3, "Pass",
						46, 0, 46, 1, 46, 2, 46, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory", "WPrice3", Globals.Inventory.WPrice3, W3, "Fail",
						46, 0, 46, 1, 46, 2, 46, 3);
			}
				catch(Exception e) {
					System.out.println("null error tblinventorypricing column MPWPrice3");
				}
			
				String GST1 ="";
				try {
				GST1 = rs.getString("OTaxPer3");
				System.out.println(GST1);
				Assert.assertEquals(Globals.Inventory.GSTPer.trim(), GST1.trim());
				pass.ExcelFourData("Inventory", "OTaxPer3", Globals.Inventory.GSTPer, GST1, "Pass",
						47, 0, 47, 1, 47, 2, 47, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory", "OTaxPer3", Globals.Inventory.GSTPer, GST1, "Fail",
						47, 0, 47, 1, 47, 2, 47, 3);
			}
				catch(Exception e) {
					System.out.println("null error tblinventorypricing column OTaxPer3");
				}
				String Cess="";
				try {
				Cess = rs.getString("ITaxPer4");
				System.out.println(Cess);
				Assert.assertEquals(Globals.Inventory.Cess.trim(), Cess.trim());
				pass.ExcelFourData("Inventory", "ITaxPer4", Globals.Inventory.Cess, Cess, "Pass",
						48, 0, 48, 1, 48, 2, 48, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory", "ITaxPer4", Globals.Inventory.Cess, Cess, "Fail",
						48, 0, 48, 1, 48, 2, 48, 3);
			}
				catch(Exception e) {
					System.out.println("null error tblinventorypricing column OTaxPer4");
				}
				String Cess1="";
				try {
				Cess1 = rs.getString("OTaxPer4");
				System.out.println(Cess1);
				Assert.assertEquals(Globals.Inventory.Cess.trim(), Cess1.trim());
				pass.ExcelFourData("Inventory", "OTaxPer4", Globals.Inventory.Cess, Cess1, "Pass",
						49, 0, 49, 1, 49, 2, 49, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory", "OTaxPer4", Globals.Inventory.Cess, Cess1, "Fail",
						49, 0, 49, 1, 49, 2, 49, 3);
			}
				catch(Exception e) {
					System.out.println("null error tblinventorypricing column OTaxPer4");
				}
				String AdlCsAmt="";
				try {
				AdlCsAmt = rs.getString("ITaxamt5");
				System.out.println(AdlCsAmt);
				Assert.assertEquals(Globals.Inventory.AdlCsAmt.trim(), AdlCsAmt.trim());
				pass.ExcelFourData("Inventory", "ITaxamt5", Globals.Inventory.AdlCsAmt, AdlCsAmt, "Pass",
						50, 0, 50, 1, 50, 2, 50, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory", "ITaxamt5", Globals.Inventory.AdlCsAmt, AdlCsAmt, "Fail",
						50, 0, 50, 1, 50, 2, 50, 3);
			}
				catch(Exception e) {
					System.out.println("null error tblinventorypricing column ITaxamt5");
				}
				String AdlCsAmt1="";
				try {
				AdlCsAmt1 = rs.getString("ITaxamt5");
				System.out.println(AdlCsAmt1);
				Assert.assertEquals(Globals.Inventory.AdlCsAmt.trim(), AdlCsAmt1.trim());
				pass.ExcelFourData("Inventory", "OTaxamt5", Globals.Inventory.AdlCsAmt, AdlCsAmt, "Pass",
						51, 0, 51, 1, 51, 2, 51, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory", "OTaxamt5", Globals.Inventory.AdlCsAmt, AdlCsAmt, "Fail",
						51, 0, 51, 1, 51, 2, 51, 3);
			}
				catch(Exception e) {
					System.out.println("null error tblinventorypricing column OTaxamt5");
				}
				String GST="";
				try {
				GST = rs.getString("ITaxPer3");
				System.out.println(GST);
				Assert.assertEquals(Globals.Inventory.GSTPer.trim(), GST.trim());
				pass.ExcelFourData("Inventory", "ITaxPer3", Globals.Inventory.GSTPer, GST, "Pass",
						52, 0, 52, 1, 52, 2, 52, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory", "ITaxPer3", Globals.Inventory.GSTPer, GST, "Fail",
						52, 0, 52, 1, 52, 2, 52, 3);
			}
				catch(Exception e) {
					System.out.println("null error tblinventorypricing column ITaxPer3");
				}
				String W1="";
				try {
			    W1 = rs.getString("MPWPrice1");
				System.out.println(W1);
				Assert.assertEquals(Globals.Inventory.WPrice1.trim(), W1.trim());
				pass.ExcelFourData("Inventory", "WPrice1", Globals.Inventory.WPrice1, W1, "Pass",
						53, 0, 53, 1, 53, 2, 53, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory", "Actual,Expected", Globals.Inventory.WPrice1, W1, "Fail",
						53, 0, 53, 1, 53, 2, 53, 3);
			}
				catch(Exception e) {
					System.out.println("null error tblinventorypricing column MPWPrice1");
				}
				String W2="";
				try {
			 W2 = rs.getString("MPWPrice2");
				System.out.println(W2);
				Assert.assertEquals(Globals.Inventory.WPrice2.trim(), W2.trim());
				pass.ExcelFourData("Inventory", "WPrice2", Globals.Inventory.WPrice2, W2, "Pass",
						54, 0, 54, 1, 54, 2, 54, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory", "WPrice2", Globals.Inventory.WPrice2, W2, "Fail",
						54, 0, 54, 1, 54, 2, 54, 3);
			}
				catch(Exception e) {
					System.out.println("null error tblinventorypricing column MPWPrice2");
				}

				break;

			case "TBLBATCHINVENTORYCONTROL":
				String SellingPrice="";
				try {
				SellingPrice = rs.getString("SellingPrice");
				System.out.println(SellingPrice);
				Assert.assertEquals(Globals.Inventory.NetSellingPrice.trim(), SellingPrice.trim());
				pass.Excelcreate("Inventory", "TBLBATCHINVENTORYCONTROL", "", 56, 0, 56, 1);
				pass.ExcelFourData("Inventory", "NetSellingPrice", Globals.Inventory.NetSellingPrice, SellingPrice, "Pass",
						57, 0, 57, 1, 57, 2, 57, 3);
			} catch (AssertionError e) {
				pass.Excelcreate("Inventory", "TBLBATCHINVENTORYCONTROL", "",56, 0, 56, 1);
				pass.ExcelFourData("Inventory", "NetSellingPrice", Globals.Inventory.NetSellingPrice, SellingPrice, "Fail",
						57, 0, 57, 1, 57, 2, 57, 3);
			}
				catch(Exception e) {
					System.out.println("null error TBLBATCHINVENTORYCONTROL column SellingPrice");
				}
				String MRP2="";
				try {
				MRP2 = rs.getString("MRP");
				System.out.println(MRP2);
				Assert.assertEquals(Globals.Inventory.MRP.trim(), MRP2.trim());
				pass.ExcelFourData("Inventory", "MRP", Globals.Inventory.MRP, MRP2, "Pass",
						58, 0, 58, 1, 58, 2, 58, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory", "MRP", Globals.Inventory.MRP, MRP2, "Fail",
						58, 0, 58, 1, 58, 2, 58, 3);
			}
				catch(Exception e) {
					System.out.println("null error TBLBATCHINVENTORYCONTROL column MRP");
				}
				String Basicost2="";
				try {
				Basicost2 = rs.getString("Unitcost");
				System.out.println(Basicost2);
				Assert.assertEquals(Globals.Inventory.BasicCost.trim(), Basicost2.trim());
				pass.ExcelFourData("Inventory", "Unitcost", Globals.Inventory.BasicCost, Basicost2, "Pass",
						59, 0, 59, 1, 59, 2, 59, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory", "Unitcost", Globals.Inventory.BasicCost, Basicost2, "Fail",
						59, 0, 59, 1, 59, 2, 59, 3);
			}
				catch(Exception e) {
					System.out.println("null error TBLBATCHINVENTORYCONTROL column Unitcost");
				}
				String W11="";
				try {
				W11 = rs.getString("WPrice1");
				System.out.println(W11);
				Assert.assertEquals(Globals.Inventory.WAPrice1.trim(), W11.trim());
				pass.ExcelFourData("Inventory", "WPrice1", Globals.Inventory.WAPrice1, W11, "Pass",
						60, 0, 60, 1, 60, 2, 60, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory", "WPrice1", Globals.Inventory.WAPrice1, W11, "Fail",
						60, 0, 60, 1, 60, 2, 60, 3);
			}
				catch(Exception e) {
					System.out.println("null error TBLBATCHINVENTORYCONTROL column WPrice1");
				}
				String W22="";
				try {
			    W22 = rs.getString("WPrice2");
				System.out.println(W22);
				Assert.assertEquals(Globals.Inventory.WAPrice2.trim(), W22.trim());
				pass.ExcelFourData("Inventory", "WAPrice2", Globals.Inventory.WAPrice2, W22, "Pass",
						61, 0, 61, 1, 61, 2, 61, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory", "WAPrice2", Globals.Inventory.WAPrice2, W22, "Fail",
						61, 0, 61, 1, 61, 2, 61, 3);
			}
				catch(Exception e) {
					System.out.println("null error TBLBATCHINVENTORYCONTROL column WPrice2");
				}
				String W33="";
				try {
					
				W33 = rs.getString("WPrice3");
				System.out.println(W33);
				Assert.assertEquals(Globals.Inventory.WAPrice3.trim(), W33.trim());
				pass.ExcelFourData("Inventory", "WAPrice3", Globals.Inventory.WAPrice3, W33, "Pass",
						62, 0, 62, 1, 62, 2, 62, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory", "WAPrice3", Globals.Inventory.WAPrice3, W33, "Fail",
						62, 0, 62, 1, 62, 2, 62, 3);
			}
				catch(Exception e) {
					System.out.println("null error TBLBATCHINVENTORYCONTROL column WPrice3");
				}
				String Batchno="";
				try {
				Batchno = rs.getString("BatchNo");
				System.out.println(Batchno);
				Assert.assertEquals(Globals.Inventory.Batchno.trim(), Batchno.trim());
				pass.ExcelFourData("Inventory", "Batchno", Globals.Inventory.Batchno, Batchno, "Pass",
						63, 0, 63, 1, 63, 2, 63, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory", "Batchno", Globals.Inventory.Batchno, Batchno, "Fail",
						63, 0, 63, 1, 63, 2, 63, 3);
			}
				catch(Exception e) {
					System.out.println("null error TBLBATCHINVENTORYCONTROL column BatchNo");
				}	
				break;
				
			case "tblInventoryShelfQty":
				String Inventorycode="";
				try {
				Inventorycode = rs.getString("InventoryCode");
				System.out.println(Inventorycode);
				Assert.assertEquals(Globals.Inventory.ItemCode.trim(), Inventorycode.trim());
				pass.Excelcreate("Inventory", "tblInventoryShelfQty", "", 64, 0, 64, 1);
				pass.ExcelFourData("Inventory", "ItemCode", Globals.Inventory.ItemCode, Inventorycode, "Pass",
						65, 0, 65, 1, 65, 2, 65, 3);
			} catch (AssertionError e) {
				pass.Excelcreate("Inventory", "tblInventoryShelfQty", "", 64, 0, 64, 1);
				pass.ExcelFourData("Inventory", "ItemCode", Globals.Inventory.ItemCode, Inventorycode, "Fail",
						65, 0, 65, 1, 65, 2, 65, 3);
			}
				catch(Exception e) {
					System.out.println("null error tblinventorystock column InventoryCode");
				}	
				break;

			case "tblinventorystock":
				// String SellingPrice1 = rs.getString("Price");
				// System.out.println(SellingPrice1);
				// Assert.assertEquals(Globals.Inventory.NetSellingPrice.trim(),
				// SellingPrice1.trim());
				String Inventorycode1="";
				try {
					
				Inventorycode1 = rs.getString("InventoryCode");
				System.out.println(Inventorycode1);
				Assert.assertEquals(Globals.Inventory.ItemCode.trim(), Inventorycode1.trim());
				pass.Excelcreate("Inventory", "tblinventorystock", "", 67, 0, 67, 1);
				pass.ExcelFourData("Inventory", "ItemCode", Globals.Inventory.ItemCode, Inventorycode1, "Pass",
						68, 0, 68, 1, 68, 2, 68, 3);
			} catch (AssertionError e) {
				pass.Excelcreate("Inventory", "tblinventorystock", "", 67, 0, 67, 1);
				pass.ExcelFourData("Inventory", "ItemCode", Globals.Inventory.ItemCode, Inventorycode1, "Fail",
						68, 0, 68, 1, 68, 2, 68, 3);
			}
				catch(Exception e) {
					System.out.println("null error tblinventorystock column InventoryCode");
				}
				break;
			case "tblbarcode":
				String Brandcode1="";
				try {
				Brandcode1 = rs.getString("BarCode");
				System.out.println(Brandcode1);
				Assert.assertEquals(Globals.Inventory.Barcode.trim(), Brandcode1.trim());
				pass.Excelcreate("Inventory", "tblbarcode", "", 70, 0, 70, 1);
				pass.ExcelFourData("Inventory", "BarCode", Globals.Inventory.Barcode, Brandcode1, "Pass",
						71, 0, 71, 1, 71, 2, 71, 3);
			} catch (AssertionError e) {
				pass.Excelcreate("Inventory", "tblbarcode", "",  70, 0, 70, 1);
				pass.ExcelFourData("Inventory", "BarCode", Globals.Inventory.Barcode, Brandcode1, "Fail",
						71, 0, 71, 1, 71, 2, 71, 3);
			}
				catch(Exception e) {
					System.out.println("null error tblbarcode column BarCode");
				}
				String Inventorycode11="";
				try {
				Inventorycode11 = rs.getString("InventoryCode");
				System.out.println(Inventorycode11);
				Assert.assertEquals(Globals.Inventory.ItemCode.trim(), Inventorycode11.trim());
				pass.ExcelFourData("Inventory", "InventoryCode", Globals.Inventory.ItemCode, Inventorycode11, "Pass",
						72, 0, 72, 1, 72, 2, 72, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory", "InventoryCode", Globals.Inventory.ItemCode, Inventorycode11, "Fail",
						72, 0, 72, 1, 72, 2, 72, 3);
			}
				catch(Exception e) {
					System.out.println("null error tblbarcode column InventoryCode");
				}
				
				break;
				

			default:
				break;
			}

		}

	}

	@Given("I read the values from table MRP {string} in DB")
	public void i_want_to_launch_the_MRP1(String tablename) throws SQLException, IOException {

		System.out.println(tablename);
		// ResultSet rs =st.executeQuery("select * from "+tablename+" where
		// DeptCode='Gopi'");

		ResultSet rs = st.executeQuery("select * from " + tablename + " where inventorycode='859601'");

		// ResultSet rs = st.executeQuery("");

		while (rs.next()) {

			switch (tablename) {

			case "tbldepartment":
				String DepartmentCode = "";
				try {
					DepartmentCode = rs.getString("DeptCode");
					System.out.println(DepartmentCode);
					Assert.assertEquals(Globals.Inventory.Department.trim(), DepartmentCode.trim());
					pass.Excelcreate("Inventory MRP", "tbldepartment", "", 7, 0, 7, 1);
					pass.ExcelFourData("Inventory MRP", "Department", Globals.Inventory.Department, DepartmentCode,
							"Pass", 8, 0, 8, 1, 8, 2, 8, 3);

				} catch (AssertionError e) {
					pass.Excelcreate("Inventory MRP", "tbldepartment", "", 7, 0, 7, 1);
					pass.ExcelFourData("Inventory MRP", "Department", Globals.Inventory.Department, DepartmentCode,
							"Fail", 8, 0, 8, 1, 8, 2, 8, 3);

				}

				break;

			case "tblinventory":
				String CategoryCode = "";
				try {
					CategoryCode = rs.getString("CategoryCode");
					System.out.println(CategoryCode);
					Assert.assertEquals(Globals.Inventory.Category.trim(), CategoryCode.trim());
					pass.Excelcreate("Inventory MRP", "tblinventory", "", 9, 0, 9, 1);
					pass.ExcelFourData("Inventory MRP", "CategoryCode", Globals.Inventory.Category, CategoryCode, "Pass",
							10, 0, 10, 1, 10, 2, 10, 3);
				} catch (AssertionError e) {
					pass.Excelcreate("Inventory MRP", "tblinventory", "", 9, 0, 9, 1);
					pass.ExcelFourData("Inventory MRP", "CategoryCode", Globals.Inventory.Category, CategoryCode, "Fail",
							10, 0, 10, 1, 10, 2, 10, 3);

				}
				String Departmentcode = "";
				try {
					Departmentcode = rs.getString("Departmentcode");
					System.out.println(Departmentcode);
					Assert.assertEquals(Globals.Inventory.Department.trim(), Departmentcode.trim());
					pass.ExcelFourData("Inventory MRP", "Departmentcode", Globals.Inventory.Department, Departmentcode, "Pass",
							11, 0, 11, 1, 11, 2, 11, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("Inventory MRP", "Departmentcode", Globals.Inventory.Department, Departmentcode, "Fail",
							11, 0, 11, 1, 11, 2, 11, 3);
				}
				String Brandcode = "";
				try {
					Brandcode = rs.getString("BrandCode");
					System.out.println(Brandcode);
					Assert.assertEquals(Globals.Inventory.Brand.trim(), Brandcode.trim());
					pass.ExcelFourData("Inventory MRP", "BrandCode", Globals.Inventory.Brand, Brandcode, "Fail",
							12, 0, 12, 1, 12, 2, 12, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("Inventory MRP", "BrandCode", Globals.Inventory.Brand, Brandcode, "Fail",
							12, 0, 12, 1, 12, 2, 12, 3);
				}
				String Barcode = "";
				try {
					Barcode = rs.getString("Barcode");
					System.out.println(Barcode);
					Assert.assertEquals(Globals.Inventory.Barcode.trim(), Barcode.trim());
					pass.ExcelFourData("Inventory MRP", "Barcode", Globals.Inventory.Barcode, Barcode, "Pass",
							13, 0, 13, 1, 13, 2, 13, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("Inventory MRP", "Barcode", Globals.Inventory.Barcode, Barcode, "Fail",
							13, 0, 13, 1, 13, 2, 13, 3);
				}
				String Subcategory = "";
				try {
					Subcategory = rs.getString("Subcategorycode");
					System.out.println(Subcategory);
					Assert.assertEquals(Globals.Inventory.SubCategory.trim(), Subcategory.trim());
					pass.ExcelFourData("Inventory MRP", "Subcategory", Globals.Inventory.SubCategory, Subcategory, "Pass",
							14, 0, 14, 1, 14, 2, 14, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("Inventory MRP", "Subcategory", Globals.Inventory.SubCategory, Subcategory, "Fail",
							14, 0, 14, 1, 14, 2, 14, 3);
				}
				String Class = "";
				try {

					Class = rs.getString("Class");
					System.out.println(Class);
					Assert.assertEquals(Globals.Inventory.Class.trim(), Class.trim());
					pass.ExcelFourData("Inventory MRP", "Class", Globals.Inventory.Class, Class, "Pass",
							15, 0, 15, 1, 15, 2,15, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("Inventory MRP", "Class", Globals.Inventory.Class, Class, "Fail",
							15, 0, 15, 1, 15, 2,15, 3);
				}
				String SubClass = "";
				try {
					SubClass = rs.getString("SubClass");
					System.out.println(SubClass);
					Assert.assertEquals(Globals.Inventory.SubClass.trim(), SubClass.trim());
					pass.ExcelFourData("Inventory MRP", "SubClass", Globals.Inventory.SubClass, SubClass, "Pass",
							16, 0, 16, 1, 16, 2, 16, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("Inventory MRP", "Actual,Expected", Globals.Inventory.SubClass, SubClass, "Fail",
							16, 0, 16, 1, 16, 2, 16, 3);
				}
				String Origion="";
				try
				{
			    Origion = rs.getString("Origin");
				System.out.println(Origion);
				Assert.assertEquals(Globals.Inventory.Origin.trim(), Origion.trim());
				pass.ExcelFourData("Inventory MRP", "Origin", Globals.Inventory.Origin, Origion, "Pass",
						17, 0, 17, 1, 17, 2, 17, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory MRP", "Origin", Globals.Inventory.Origin, Origion, "Fail",
						17, 0, 17, 1, 17, 2, 17, 3);
			}
				String Warehouse="";
				try
				{
			    Warehouse = rs.getString("Warehouse");
				System.out.println(Warehouse);
				Assert.assertEquals(Globals.Inventory.WareHouse.trim(), Warehouse.trim());
				pass.ExcelFourData("Inventory MRP", "Warehouse", Globals.Inventory.WareHouse, Warehouse, "Pass",
						18, 0, 18, 1, 18, 2, 18, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory MRP", "Warehouse", Globals.Inventory.WareHouse, Warehouse, "Fail",
						18, 0, 18, 1, 18, 2, 18, 3);
			}
				String UOM="";
				try {
			    UOM = rs.getString("UOM");
				System.out.println(UOM);
				Assert.assertEquals(Globals.Inventory.UOMPurchase.trim(), UOM.trim());
				pass.ExcelFourData("Inventory MRP", "UOM", Globals.Inventory.UOMPurchase, UOM, "Pass",
						19, 0, 19, 1, 19, 2, 19, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory MRP", "UOM", Globals.Inventory.UOMPurchase, UOM, "Fail",
						19, 0, 19, 1, 19, 2, 19, 3);
			}
				String Manufacture="";
			try {
					
				Manufacture = rs.getString("Manufacturer");
				System.out.println(Manufacture);
				Assert.assertEquals(Globals.Inventory.Manufacture.trim(), Manufacture.trim());
				pass.ExcelFourData("Inventory MRP", "Manufacturer", Globals.Inventory.Manufacture, Manufacture, "Pass",
						20, 0, 20, 1, 20, 2, 20, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory MRP", "Manufacturer", Globals.Inventory.Manufacture, Manufacture, "Fail",
						20, 0, 20, 1, 20, 2, 20, 3);
			}
			String ItemType="";
			try {
				
			    ItemType = rs.getString("ItemType");
				System.out.println(ItemType);
				Assert.assertEquals(Globals.Inventory.ItemType.trim(), ItemType.trim());
				pass.ExcelFourData("Inventory MRP", "ItemType", Globals.Inventory.ItemType, ItemType, "Pass",
						21, 0, 21, 1, 21, 2, 21, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory MRP", "ItemType", Globals.Inventory.ItemType, ItemType, "Fail",
						21, 0, 21, 1, 21, 2, 21, 3);
			}
			String Weight="";
			try {
				Weight = rs.getString("Weight");
				System.out.println(Weight);
				Assert.assertEquals(Globals.Inventory.Weight.trim(), Weight.trim());
				pass.ExcelFourData("Inventory MRP", "Weight", Globals.Inventory.Weight, Weight, "Pass",
						22, 0, 22, 1, 22, 2, 22, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory MRP", "Weight", Globals.Inventory.Weight, Weight, "Fail",
						22, 0, 22, 1, 22, 2, 22, 3);
			}
			String Width="";
			try {
			    Width = rs.getString("Width");
			    System.out.println(Width);
			    Assert.assertEquals(Globals.Inventory.Width.trim(), Width.trim());
			    pass.ExcelFourData("Inventory MRP", "Actual,Expected", Globals.Inventory.Width, Width, "Pass",
						23, 0, 23, 1, 23, 2, 23, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory MRP", "Actual,Expected", Globals.Inventory.Width, Width, "Fail",
						23, 0, 23, 1, 23, 2, 23, 3);
			}
			String Height="";
			try {
				Height = rs.getString("Height");
				System.out.println(Height);
				Assert.assertEquals(Globals.Inventory.Height.trim(), Height.trim());
				pass.ExcelFourData("Inventory MRP", "Height", Globals.Inventory.Height, Height, "Pass",
						24, 0, 24, 1, 24, 2, 24, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory MRP", "Height", Globals.Inventory.Height, Height, "Fail",
						24, 0, 24, 1, 24, 2, 24, 3);
			}
			String Length="";
			try {
			    Length = rs.getString("Length");
				System.out.println(Length);
				Assert.assertEquals(Globals.Inventory.Length.trim(), Length.trim());
				pass.ExcelFourData("Inventory MRP", "Length", Globals.Inventory.Length, Length, "Pass",
						25, 0, 25, 1, 25, 2, 25, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory MRP", "Length", Globals.Inventory.Length, Length, "Fail",
						25, 0, 25, 1, 25, 2, 25, 3);
			}
			String Vendorcode="";
			try {
				Vendorcode = rs.getString("VendorCode");
				System.out.println(Vendorcode);
				Assert.assertEquals(Globals.Inventory.Vendor.trim(), Vendorcode.trim());
				pass.ExcelFourData("Inventory MRP", "VendorCode", Globals.Inventory.Vendor, Vendorcode, "Pass",
						26, 0, 26, 1, 26, 2, 26, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory MRP", "VendorCode", Globals.Inventory.Vendor, Vendorcode, "Fail",
						26, 0, 26, 1, 26, 2, 26, 3);
			}
			String Basicost ="";
			try {
				Basicost = rs.getString("UnitCost");
				System.out.println(Basicost);
				Assert.assertEquals(Globals.Inventory.BasicCost.trim(), Basicost.trim());
				pass.ExcelFourData("Inventory MRP", "BasicCost", Globals.Inventory.BasicCost, Basicost, "Pass",
						27, 0, 27, 1, 27, 2, 27, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory MRP", "BasicCost", Globals.Inventory.BasicCost, Basicost, "Fail",
						27, 0, 27, 1, 27, 2, 27, 3);
			}
			String Sellingprice="";
			try {
				Sellingprice = rs.getString("SellingPrice");
				System.out.println(Sellingprice);
				Assert.assertEquals(Globals.Inventory.NetSellingPrice.trim(), Sellingprice.trim());
				pass.ExcelFourData("Inventory MRP", "SellingPrice", Globals.Inventory.NetSellingPrice, Sellingprice, "Pass",
						28, 0, 28, 1, 28, 2, 28, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory MRP", "SellingPrice", Globals.Inventory.NetSellingPrice, Sellingprice, "Fail",
						28, 0, 28, 1, 28, 2, 28, 3);
			}
			String MRP="";
			try
			{
				MRP = rs.getString("MRP");
				System.out.println(MRP);
				Assert.assertEquals(Globals.Inventory.MRP.trim(), MRP.trim());
				pass.ExcelFourData("Inventory MRP", "MRP", Globals.Inventory.MRP, MRP, "Pass",
						29, 0, 29, 1, 29, 2, 29, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory MRP", "MRP", Globals.Inventory.MRP, MRP, "Fail",
						29, 0, 29, 1, 29, 2, 29, 3);
			}
			String MinQty="";
			try
			{
				MinQty = rs.getString("MinimumQtyLevel");
				System.out.println(MinQty);
				Assert.assertEquals(Globals.Inventory.MinQty.trim(), MinQty.trim());
				pass.ExcelFourData("Inventory MRP", "MinQty", Globals.Inventory.MinQty, MinQty, "Pass",
						30, 0, 30, 1, 30, 2, 30, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory MRP", "MinQty", Globals.Inventory.MinQty, MinQty, "Fail",
						30, 0, 30, 1, 30, 2, 30, 3);
			}
			String MaxQty="";
			try {
				MaxQty = rs.getString("MaximumQtyLevel");
				System.out.println(MaxQty);
				Assert.assertEquals(Globals.Inventory.MaxQty.trim(), MaxQty.trim());
				pass.ExcelFourData("Inventory MRP", "MaxQty", Globals.Inventory.MaxQty, MaxQty, "Pass",
						31, 0, 31, 1, 31, 2, 31, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory MRP", "MaxQty", Globals.Inventory.MaxQty, MaxQty, "Fail",
						31, 0, 31, 1, 31, 2, 31, 3);
			}
			String ReorderQty="";
			try {
				ReorderQty = rs.getString("ReOrderLevel");
				System.out.println(ReorderQty);
				Assert.assertEquals(Globals.Inventory.ReorderQty.trim(), ReorderQty.trim());
				pass.ExcelFourData("Inventory MRP", "ReorderQty", Globals.Inventory.ReorderQty, ReorderQty, "Pass",
						32, 0, 32, 1, 32, 2, 32, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory MRP", "ReorderQty", Globals.Inventory.ReorderQty, ReorderQty, "Fail",
						32, 0, 32, 1, 32, 2, 32, 3);
			}
			String Cycledays="";
			try {
				Cycledays = rs.getString("ReOrderDays");
				System.out.println(Cycledays);
				Assert.assertEquals(Globals.Inventory.Cycledays.trim(), Cycledays.trim());
				pass.ExcelFourData("Inventory MRP", "Cycledays", Globals.Inventory.Cycledays, Cycledays, "Pass",
						33, 0, 33, 1, 33, 2, 33, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory MRP", "Cycledays", Globals.Inventory.Cycledays, Cycledays, "Fail",
						33, 0, 33, 1, 33, 2, 33, 3);
			}
			String Orderby="";
			try {
				Orderby = rs.getString("AutoPOReqBy");
				System.out.println(Orderby);
				Assert.assertEquals(Globals.Inventory.Orderby.trim(), Orderby.trim());
				pass.ExcelFourData("Inventory MRP", "Orderby", Globals.Inventory.Orderby, Orderby, "Pass",
						34, 0, 34, 1, 34, 2, 34, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory MRP", "Orderby", Globals.Inventory.Orderby, Orderby, "Fail",
						34, 0, 34, 1, 34, 2, 34, 3);
			}
			catch(Exception e) {
				
			}
			String CheckBox1="";
			try {
			    CheckBox1 = rs.getString("MinQtycalBy");
				System.out.println(CheckBox1);
				Assert.assertEquals(Globals.Inventory.CheckBox1.trim(), CheckBox1.trim());
				pass.ExcelFourData("Inventory MRP", "MinQtycalBy", Globals.Inventory.CheckBox1, CheckBox1, "Pass",
						35, 0, 35, 1, 35, 2, 35, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory MRP", "MinQtycalBy", Globals.Inventory.CheckBox1, CheckBox1, "Fail",
						35, 0, 35, 1, 35, 2, 35, 3);
			}
			String CheckBox2="";
			try {
				CheckBox2 = rs.getString("ReOrderBy");
				System.out.println(CheckBox2);
				Assert.assertEquals(Globals.Inventory.CheckBox2.trim(), CheckBox2.trim());
				pass.ExcelFourData("Inventory MRP", "ReOrderBy", Globals.Inventory.CheckBox2, CheckBox2, "Pass",
						36, 0, 36, 1, 36, 2, 36, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory MRP", "ReOrderBy", Globals.Inventory.CheckBox2, CheckBox2, "Fail",
						36, 0, 36, 1, 36, 2, 36, 3);
			}
				break;

			case "tblinventorypricing":
				String BasicSelling ="";
				try {
				BasicSelling = rs.getString("NetSellingPrice");
				System.out.println(BasicSelling);
				Assert.assertEquals(Globals.Inventory.NetSellingPrice.trim(), BasicSelling.trim());
				pass.Excelcreate("Inventory MRP", "tblinventorypricing", "", 37, 0, 37, 1);
				pass.ExcelFourData("Inventory MRP", "NetSellingPrice", Globals.Inventory.NetSellingPrice, BasicSelling, "Pass",
						37, 0, 37, 1, 37, 2, 37, 3);
			} catch (AssertionError e) {
				pass.Excelcreate("Inventory MRP", "tblinventorypricing", "", 37, 0, 37, 1);
				pass.ExcelFourData("Inventory MRP", "NetSellingPrice", Globals.Inventory.NetSellingPrice, BasicSelling, "Fail",
						37, 0, 37, 1, 37, 2, 37, 3);
			}
				String Purchasetype="";
				try {
			    Purchasetype = rs.getString("PurchasedBy");
				System.out.println(Purchasetype);
				Assert.assertEquals(Globals.Inventory.Purchasetype.trim(), Purchasetype.trim());
				pass.ExcelFourData("Inventory MRP", "Purchasetype", Globals.Inventory.Purchasetype, Purchasetype, "Pass",
						38, 0, 38, 1, 38, 2, 38, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory MRP", "Purchasetype", Globals.Inventory.Purchasetype, Purchasetype, "Fail",
						38, 0, 38, 1, 38, 2, 38, 3);
			}
				String MRP1 ="";
				try {
				MRP1 = rs.getString("MRP");
				System.out.println(MRP1);
				Assert.assertEquals(Globals.Inventory.MRP.trim(), MRP1.trim());
				pass.ExcelFourData("Inventory MRP", "MRP", Globals.Inventory.MRP, MRP1, "Pass",
						39, 0, 39, 1, 39, 2, 39, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory MRP", "MRP", Globals.Inventory.MRP, MRP1, "Fail",
						39, 0, 39, 1, 39, 2, 39, 3);
			}
				String Basicost1="";
				try {
				Basicost1 = rs.getString("BasicCost");
				System.out.println(Basicost1);
				Assert.assertEquals(Globals.Inventory.BasicCost.trim(), Basicost1.trim());
				pass.ExcelFourData("Inventory MRP", "BasicCost", Globals.Inventory.BasicCost, Basicost1, "Pass",
						40, 0, 40, 1, 40, 2, 40, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory MRP", "BasicCost", Globals.Inventory.BasicCost, Basicost1, "Fail",
						40, 0, 40, 1, 40, 2, 40, 3);
			}
				String DiscountPer1="";
				try {
				DiscountPer1 = rs.getString("DiscountBasicPer");
				System.out.println(DiscountPer1);
				Assert.assertEquals(Globals.Inventory.DiscountPer1.trim(), DiscountPer1.trim());
				pass.ExcelFourData("Inventory MRP", "DiscountPer1", Globals.Inventory.DiscountPer1, DiscountPer1, "Pass",
						41, 0, 41, 1, 41, 2, 41, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory MRP", "DiscountPer1", Globals.Inventory.DiscountPer1, DiscountPer1, "Fail",
						41, 0, 41, 1, 41, 2, 41, 3);
			}
				String DiscountPer2 ="";
				try {
				DiscountPer2 = rs.getString("DiscountBasicPer2");
				System.out.println(DiscountPer2);
				Assert.assertEquals(Globals.Inventory.DiscountPer2.trim(), DiscountPer2.trim());
				pass.ExcelFourData("Inventory MRP", "DiscountPer2", Globals.Inventory.DiscountPer2, DiscountPer2, "Pass",
						42, 0, 42, 1, 42, 2, 42, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory MRP", "DiscountPer2", Globals.Inventory.DiscountPer2, DiscountPer2, "Fail",
						42, 0, 42, 1, 42, 2, 42, 3);
			}
				String DiscountPer3="";
				try {
				DiscountPer3 = rs.getString("DiscountBasicPer3");
				System.out.println(DiscountPer3);
				Assert.assertEquals(Globals.Inventory.DiscountPer3.trim(), DiscountPer3.trim());
				pass.ExcelFourData("Inventory MRP", "DiscountPer3", Globals.Inventory.DiscountPer3, DiscountPer3, "Pass",
						43, 0, 43, 1, 43, 2, 43, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory MRP", "DiscountPer3", Globals.Inventory.DiscountPer3, DiscountPer3, "Fail",
						43, 0, 43, 1, 43, 2, 43, 3);
			}
				String W1="";
				try {
			    W1 = rs.getString("MPWPrice1");
				System.out.println(W1);
				Assert.assertEquals(Globals.Inventory.WPrice1.trim(), W1.trim());
				pass.ExcelFourData("Inventory MRP", "WPrice1", Globals.Inventory.WPrice1, W1, "Pass",
						44, 0, 44, 1, 44, 2, 44, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory MRP", "Actual,Expected", Globals.Inventory.WPrice1, W1, "Fail",
						44, 0, 44, 1, 44, 2, 44, 3);
			}
				String W2="";
				try {
			 W2 = rs.getString("MPWPrice2");
				System.out.println(W2);
				Assert.assertEquals(Globals.Inventory.WPrice2.trim(), W2.trim());
				pass.ExcelFourData("Inventory MRP", "WPrice2", Globals.Inventory.WPrice2, W2, "Pass",
						44, 0, 44, 1, 44, 2,44, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory MRP", "WPrice2", Globals.Inventory.WPrice2, W2, "Fail",
						44, 0, 44, 1, 44, 2,44, 3);
			}
				String W3 ="";
				try {
				W3 = rs.getString("MPWPrice3");
				System.out.println(W3);
				Assert.assertEquals(Globals.Inventory.WPrice3.trim(), W3.trim());
				pass.ExcelFourData("Inventory MRP", "WPrice3", Globals.Inventory.WPrice3, W3, "Pass",
						45, 0, 45, 1, 45, 2, 45, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory MRP", "WPrice3", Globals.Inventory.WPrice3, W3, "Fail",
						45, 0, 45, 1, 45, 2, 45, 3);
			}
				String GST="";
				try {
				GST = rs.getString("ITaxPer3");
				System.out.println(GST);
				Assert.assertEquals(Globals.Inventory.GSTPer.trim(), GST.trim());
				pass.ExcelFourData("Inventory MRP", "ITaxPer3", Globals.Inventory.GSTPer, GST, "Pass",
						46, 0, 46, 1, 46, 2, 46, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory MRP", "ITaxPer3", Globals.Inventory.GSTPer, GST, "Fail",
						46, 0, 46, 1, 46, 2, 46, 3);
			}
				String GST1 ="";
				try {
				GST1 = rs.getString("OTaxPer3");
				System.out.println(GST1);
				Assert.assertEquals(Globals.Inventory.GSTPer.trim(), GST1.trim());
				pass.ExcelFourData("Inventory MRP", "OTaxPer3", Globals.Inventory.GSTPer, GST1, "Pass",
						47, 0, 47, 1, 47, 2, 47, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory MRP", "OTaxPer3", Globals.Inventory.GSTPer, GST1, "Fail",
						47, 0, 47, 1, 47, 2, 47, 3);
			}
				String Cess="";
				try {
				Cess = rs.getString("ITaxPer4");
				System.out.println(Cess);
				Assert.assertEquals(Globals.Inventory.Cess.trim(), Cess.trim());
				pass.ExcelFourData("Inventory MRP", "ITaxPer4", Globals.Inventory.Cess, Cess, "Pass",
						48, 0, 48, 1, 48, 2, 48, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory MRP", "ITaxPer4", Globals.Inventory.Cess, Cess, "Fail",
						48, 0, 48, 1, 48, 2, 48, 3);
			}
				String Cess1="";
				try {
				Cess1 = rs.getString("OTaxPer4");
				System.out.println(Cess1);
				Assert.assertEquals(Globals.Inventory.Cess.trim(), Cess1.trim());
				pass.ExcelFourData("Inventory MRP", "OTaxPer4", Globals.Inventory.Cess, Cess1, "Pass",
						49, 0, 49, 1, 49, 2, 49, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory MRP", "OTaxPer4", Globals.Inventory.Cess, Cess1, "Fail",
						49, 0, 49, 1, 49, 2, 49, 3);
			}
				String AdlCsAmt="";
				try {
				AdlCsAmt = rs.getString("ITaxamt5");
				System.out.println(AdlCsAmt);
				Assert.assertEquals(Globals.Inventory.AdlCsAmt.trim(), AdlCsAmt.trim());
				pass.ExcelFourData("Inventory MRP", "ITaxamt5", Globals.Inventory.AdlCsAmt, AdlCsAmt, "Pass",
						50, 0, 50, 1, 50, 2, 50, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory MRP", "ITaxamt5", Globals.Inventory.AdlCsAmt, AdlCsAmt, "Fail",
						50, 0, 50, 1, 50, 2, 50, 3);
			}
				String AdlCsAmt1="";
				try {
				AdlCsAmt1 = rs.getString("OTaxamt5");
				System.out.println(AdlCsAmt1);
				Assert.assertEquals(Globals.Inventory.AdlCsAmt.trim(), AdlCsAmt1.trim());
				pass.ExcelFourData("Inventory MRP", "OTaxamt5", Globals.Inventory.AdlCsAmt, AdlCsAmt, "Pass",
						51, 0, 51, 1, 51, 2, 51, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory MRP", "OTaxamt5", Globals.Inventory.AdlCsAmt, AdlCsAmt, "Fail",
						51, 0, 51, 1, 51, 2, 51, 3);
			}
					
				break;

			case "TBLBATCHINVENTORYCONTROL":
				String SellingPrice="";
				try {
				SellingPrice = rs.getString("SellingPrice");
				System.out.println(SellingPrice);
				Assert.assertEquals(Globals.Inventory.NetSellingPrice.trim(), SellingPrice.trim());
				pass.Excelcreate("Inventory MRP", "TBLBATCHINVENTORYCONTROL", "", 52, 0, 52, 1);
				pass.ExcelFourData("Inventory MRP", "NetSellingPrice", Globals.Inventory.NetSellingPrice, SellingPrice, "Pass",
						53, 0, 53, 1, 53, 2, 53, 3);
			} catch (AssertionError e) {
				pass.Excelcreate("Inventory MRP", "TBLBATCHINVENTORYCONTROL", "", 52, 0, 52, 1);
				pass.ExcelFourData("Inventory MRP", "NetSellingPrice", Globals.Inventory.NetSellingPrice, SellingPrice, "Fail",
						53, 0, 53, 1, 53, 2, 53, 3);
			}
				String MRP2="";
				try {
				MRP2 = rs.getString("MRP");
				System.out.println(MRP2);
				Assert.assertEquals(Globals.Inventory.MRP.trim(), MRP2.trim());
				pass.ExcelFourData("Inventory MRP", "MRP", Globals.Inventory.MRP, MRP2, "Pass",
						54, 0, 54, 1, 54, 2, 54, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory MRP", "MRP", Globals.Inventory.MRP, MRP2, "Fail",
						54, 0, 54, 1, 54, 2, 54, 3);
			}
				String Basicost2="";
				try {
				Basicost2 = rs.getString("Unitcost");
				System.out.println(Basicost2);
				Assert.assertEquals(Globals.Inventory.BasicCost.trim(), Basicost2.trim());
				pass.ExcelFourData("Inventory MRP", "Unitcost", Globals.Inventory.BasicCost, Basicost2, "Pass",
						55, 0, 55, 1, 55, 2, 55, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory MRP", "Unitcost", Globals.Inventory.BasicCost, Basicost2, "Fail",
						55, 0, 55, 1, 55, 2, 55, 3);
			}
				String W11="";
				try {
				W11 = rs.getString("WPrice1");
				System.out.println(W11);
				Assert.assertEquals(Globals.Inventory.WAPrice1.trim(), W11.trim());
				pass.ExcelFourData("Inventory MRP", "WPrice1", Globals.Inventory.WAPrice1, W11, "Pass",
						56, 0, 56, 1, 56, 2, 56, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory MRP", "WPrice1", Globals.Inventory.WAPrice1, W11, "Fail",
						56, 0, 56, 1, 56, 2, 56, 3);
			}
				String W22="";
				try {
			    W22 = rs.getString("WPrice2");
				System.out.println(W22);
				Assert.assertEquals(Globals.Inventory.WAPrice2.trim(), W22.trim());
				pass.ExcelFourData("Inventory MRP", "WAPrice2", Globals.Inventory.WAPrice2, W22, "Pass",
						57, 0, 57, 1, 57, 2, 57, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory MRP", "WAPrice2", Globals.Inventory.WAPrice2, W22, "Fail",
						57, 0, 57, 1, 57, 2, 57, 3);
			}
				String W33="";
				try {
					
				W33 = rs.getString("WPrice3");
				System.out.println(W33);
				Assert.assertEquals(Globals.Inventory.WAPrice3.trim(), W33.trim());
				pass.ExcelFourData("Inventory MRP", "WAPrice3", Globals.Inventory.WAPrice3, W33, "Pass",
						58, 0, 58, 1, 58, 2, 58, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory MRP", "WAPrice3", Globals.Inventory.WAPrice3, W33, "Fail",
						58, 0, 58, 1, 58, 2, 58, 3);
			}
				String Batchno="";
				try {
				Batchno = rs.getString("BatchNo");
				System.out.println(Batchno);
				Assert.assertEquals(Globals.Inventory.Batchno.trim(), Batchno.trim());
				pass.ExcelFourData("Inventory MRP", "Batchno", Globals.Inventory.Batchno, Batchno, "Pass",
						59, 0, 59, 1, 59, 2, 59, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory MRP", "Batchno", Globals.Inventory.Batchno, Batchno, "Fail",
						59, 0, 59, 1, 59, 2, 59, 3);
			}
			
				break;
				
			case "tblInventoryShelfQty":
				String Inventorycode="";
				try {
				Inventorycode = rs.getString("InventoryCode");
				System.out.println(Inventorycode);
				Assert.assertEquals(Globals.Inventory.ItemCode.trim(), Inventorycode.trim());
				pass.Excelcreate("Inventory MRP", "tblInventoryShelfQty", "", 60, 0, 60, 1);
				pass.ExcelFourData("Inventory MRP", "ItemCode", Globals.Inventory.ItemCode, Inventorycode, "Pass",
						61, 0, 61, 1, 61, 2, 61, 3);
			} catch (AssertionError e) {
				pass.Excelcreate("Inventory MRP", "tblInventoryShelfQty", "", 60, 0, 60, 1);
				pass.ExcelFourData("Inventory MRP", "ItemCode", Globals.Inventory.ItemCode, Inventorycode, "Fail",
						61, 0, 61, 1, 61, 2, 61, 3);
			}
				break;

			case "tblinventorystock":
				// String SellingPrice1 = rs.getString("Price");
				// System.out.println(SellingPrice1);
				// Assert.assertEquals(Globals.Inventory.NetSellingPrice.trim(),
				// SellingPrice1.trim());
				String Inventorycode1="";
				try {
					
				Inventorycode1 = rs.getString("InventoryCode");
				System.out.println(Inventorycode1);
				Assert.assertEquals(Globals.Inventory.ItemCode.trim(), Inventorycode1.trim());
				pass.Excelcreate("Inventory MRP", "tblinventorystock", "", 62, 0, 62, 1);
				pass.ExcelFourData("Inventory MRP", "ItemCode", Globals.Inventory.ItemCode, Inventorycode1, "Pass",
						63, 0, 63, 1, 63, 2, 63, 3);
			} catch (AssertionError e) {
				pass.Excelcreate("Inventory MRP", "tblinventorystock", "", 62, 0, 62, 1);
				pass.ExcelFourData("Inventory MRP", "ItemCode", Globals.Inventory.ItemCode, Inventorycode1, "Fail",
						63, 0, 63, 1, 63, 2, 63, 3);
			}
				break;

			case "tblbarcode":
				String Brandcode1="";
				try {
				Brandcode1 = rs.getString("BarCode");
				System.out.println(Brandcode1);
				Assert.assertEquals(Globals.Inventory.Barcode.trim(), Brandcode1.trim());
				pass.Excelcreate("Inventory MRP", "tblbarcode", "", 63, 0, 63, 1);
				pass.ExcelFourData("Inventory MRP", "BarCode", Globals.Inventory.Barcode, Brandcode1, "Pass",
						64, 0, 64, 1, 64, 2, 64, 3);
			} catch (AssertionError e) {
				pass.Excelcreate("Inventory MRP", "tblbarcode", "", 63, 0, 63, 1);
				pass.ExcelFourData("Inventory MRP", "BarCode", Globals.Inventory.Barcode, Brandcode1, "Fail",
						64, 0, 64, 1, 64, 2, 64, 3);
			}
				String Inventorycode11="";
				try {
				Inventorycode11 = rs.getString("InventoryCode");
				System.out.println(Inventorycode11);
				Assert.assertEquals(Globals.Inventory.ItemCode.trim(), Inventorycode11.trim());
				pass.ExcelFourData("Inventory MRP", "InventoryCode", Globals.Inventory.ItemCode, Inventorycode11, "Pass",
						65, 0, 65, 1, 65, 2, 65, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory MRP", "InventoryCode", Globals.Inventory.ItemCode, Inventorycode11, "Fail",
						65, 0, 65, 1, 65, 2, 65, 3);
			}
				break;

			default:
				break;
			}

		}

	}

	@Then("I verify the actual ui values with expected Excel values")
	public void i_verify_the_actual_ui_values_with_expected_Excel_values() throws IOException {
		try {
			icp.NetSellingPrice = icp.getTextValue(icp.NetSellingPrice_text);
			Assert.assertEquals(icp.NetSellingPrice, Double.parseDouble(Globals.Inventory.NetSellingPrice));
			// if
			// (icp.NetSellingPrice==Double.parseDouble(Globals.Inventory.NetSellingPrice))
			// {

			// pass.ExcelFourData("Inventory","Actual,Expected",Globals.Inventory.NetSellingPrice,icp.NetSellingPrice,"Pass",5,0,5,1,5,2,5,3);
			// }
			// else {
			// throw new Exception();
			// }
			pass.ExcelDouble("Inventory", "Expected selling price", Globals.Inventory.NetSellingPrice, icp.NetSellingPrice,
					"Pass", 4, 0, 4, 1, 4, 2, 4, 3);

		} catch (AssertionError e) {
			pass.ExcelDouble("Inventory", "Expected selling price", Globals.Inventory.NetSellingPrice, icp.NetSellingPrice,
					"Fail",4, 0, 4, 1, 4, 2, 4, 3);

		}

	}

	@Then("I verify mrp and selling price")
	public void i_verify_mrp_and_selling_price() {

		icp.NetSellingPrice = icp.getTextValue(icp.NetSellingPrice_text);

		try {
			WebDriverWait wait = new WebDriverWait(icp.getWebDriver(), 2);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = icp.getWebDriver().switchTo().alert();
			System.out.println(alert.getText());
			alert.accept();
			Assert.assertTrue(alert.getText().contains("Selling Price should be less than MRP"));
		} catch (Exception e) {
			System.out.println("Exception occured" + e);
		}

	}

}
