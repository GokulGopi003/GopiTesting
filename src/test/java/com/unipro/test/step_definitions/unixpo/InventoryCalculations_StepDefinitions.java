package com.unipro.test.step_definitions.unixpo;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import java.util.Map;
import java.util.Scanner;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.common.collect.Table;
import com.unipro.test.framework.Globals;
import com.unipro.test.framework.helpers.utils.ApplicationLogger;
import com.unipro.test.framework.helpers.utils.GenericWrappers;
import com.unipro.test.framework.helpers.utils.RandomGenerator;
import com.unipro.test.framework.helpers.utils.ReadTestData;
import com.unipro.test.framework.helpers.utils.ReadXLSXFile;
import com.unipro.test.page_objects.unixpro.AddInventoryFormPage;
import com.unipro.test.page_objects.unixpro.InventoryCalculationsPage;
import com.unipro.test.page_objects.unixpro.InventoryCreationPage;
import com.unipro.test.page_objects.unixpro.TerminalPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.bytebuddy.agent.builder.AgentBuilder.CircularityLock.Global;

public class InventoryCalculations_StepDefinitions {
	
	AddInventoryFormPage add_inventory;
	InventoryCalculationsPage icp;

	TerminalPage terPage;

	public InventoryCalculations_StepDefinitions(InventoryCalculationsPage icp) {
		this.icp = icp;
		terPage = new TerminalPage();

		add_inventory = new AddInventoryFormPage();

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

		//Globals.Inventory.inventorySheetData1 = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME_DATA);

		Globals.Inventory.inventorySheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME);

	}

	@Then("I load the rowise inventory data for {string} rowname")
	public void i_load_the_rowise_inventory_data_for_rowname(String row_name) {

		Globals.Inventory.inventoryrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.inventorySheetData, row_name);

		System.out.println(Globals.Inventory.inventoryrowwiseData);

	}
	
	@Then("I check the purchased by radio button for {string}")
	public void i_check_the_purchased_by_radio_button_for (String row_name) {

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
	}

	@Then("I fill new inventory data page using excel data")
	public void i_fill_new_inventory_data_page_using_excel_data() {

		// category
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Category)) {
			terPage.terminal_waitClearEnterText_css(icp.Category_String, Globals.Inventory.Category);
			add_inventory.clearAndTypeSlowly(Globals.Inventory.Category, "input#txtSearch");
			add_inventory.return_td_invoke_element(Globals.Inventory.Category).click();

		}
		//Department
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

			GenericWrappers.sleepInSeconds(3);
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
		//c.code
		if (GenericWrappers.isNotEmpty(Globals.Inventory.CCode)) {
			terPage.terminal_waitClearEnterText_css(icp.CCode_String, Globals.Inventory.Size);
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
		}
		// Weight
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Weight)) {
			if (Globals.Inventory.Weight.contains(".")) {
				icp.setTextValue_Decimal(icp.Weight_String, Globals.Inventory.Weight);
			} else {
				icp.setTextValue(icp.Weight_String, Globals.Inventory.Weight);
			}
		}
		// Height
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Height)) {
			if (Globals.Inventory.Height.contains(".")) {
				icp.setTextValue_Decimal(icp.Height_String, Globals.Inventory.Height);
			} else {
				icp.setTextValue(icp.Height_String, Globals.Inventory.Height);
			}
		}
		// Width
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Width)) {
			if (Globals.Inventory.Width.contains(".")) {
				icp.setTextValue_Decimal(icp.Width_String, Globals.Inventory.Width);
			} else {
				icp.setTextValue(icp.Width_String, Globals.Inventory.Width);
			}
		}
		// Length
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Length)) {
			if (Globals.Inventory.Length.contains(".")) {
				icp.setTextValue_Decimal(icp.Length_String, Globals.Inventory.Length);
			} else {
				icp.setTextValue(icp.Length_String, Globals.Inventory.Length);
			}
		}

	}

	@Then("I fill inventory calculations page using excel data")
	public void i_fill_inventory_calculations_page_using_excel_data() {
		
		// cess
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Cess) && !(Globals.Inventory.GSTPer).matches("0")) {
			if (Globals.Inventory.Cess.contains(".")) {
				icp.setTextValue_Decimal(icp.Cess_String, Globals.Inventory.Cess);
			} else {
				icp.setTextValue(icp.Cess_String, Globals.Inventory.Cess);
			}
		}
		
		// Additional cess amount
		if (GenericWrappers.isNotEmpty(Globals.Inventory.AdlCsAmt) && !(Globals.Inventory.GSTPer).matches("0")) {
			if (Globals.Inventory.AdlCsAmt.contains(".")) {
				icp.setTextValue_Decimal(icp.AdlCsAmt_String, Globals.Inventory.AdlCsAmt);
			} else {
				icp.setTextValue(icp.AdlCsAmt_String, Globals.Inventory.AdlCsAmt);
			}
		}

		// MRP
		if (GenericWrappers.isNotEmpty(Globals.Inventory.MRP)) {
			if (Globals.Inventory.MRP.contains(".")) {
				icp.setTextValue_Decimal(icp.MRP_String, Globals.Inventory.MRP);
			} else {
				icp.setTextValue(icp.MRP_String, Globals.Inventory.MRP);
			}
		}

		// Basic cost
		if (GenericWrappers.isNotEmpty(Globals.Inventory.BasicCost)) {

			if (Globals.Inventory.BasicCost.contains(".")) {
				icp.setTextValue_Decimal(icp.Basic_Cost_String, Globals.Inventory.BasicCost);

			} else {

				icp.setTextValue(icp.Basic_Cost_String, Globals.Inventory.BasicCost);
			}

		}

		// Discount per 1
		if (GenericWrappers.isNotEmpty(Globals.Inventory.DiscountPer1)) {

			if (Globals.Inventory.DiscountPer1.contains(".")) {
				icp.setTextValue_Decimal(icp.Discount1_String, Globals.Inventory.DiscountPer1);

			} else {

				icp.setTextValue(icp.Discount1_String, Globals.Inventory.DiscountPer1);
			}

		}

		// Discount per 2
		if (GenericWrappers.isNotEmpty(Globals.Inventory.DiscountPer2)) {

			if (Globals.Inventory.DiscountPer2.contains(".")) {
				icp.setTextValue_Decimal(icp.Discount2_String, Globals.Inventory.DiscountPer2);

			} else {

				icp.setTextValue(icp.Discount2_String, Globals.Inventory.DiscountPer2);
			}

		}
		// Discount per 3
		if (GenericWrappers.isNotEmpty(Globals.Inventory.DiscountPer3)) {

			if (Globals.Inventory.DiscountPer3.contains(".")) {
				icp.setTextValue_Decimal(icp.Discount3_String, Globals.Inventory.DiscountPer3);

			} else {

				icp.setTextValue(icp.Discount3_String, Globals.Inventory.DiscountPer3);
			}

		}

		// sp fixing %
		if (GenericWrappers.isNotEmpty(Globals.Inventory.spfixing)) {

			if (Globals.Inventory.spfixing.contains(".")) {
				icp.setTextValue_Decimal(icp.SP_String, Globals.Inventory.spfixing);

			} else {

				icp.setTextValue(icp.SP_String, Globals.Inventory.spfixing);
			}

		}

		// WPrice1
				if (GenericWrappers.isNotEmpty(Globals.Inventory.WPrice1)) {

					if (Globals.Inventory.WPrice1.contains(".")) {
						icp.setTextValue_Decimal(icp.WPrice1_String, Globals.Inventory.WPrice1);

					} else {

						icp.setTextValue(icp.WPrice1_String, Globals.Inventory.WPrice1);
					}

				}
				
				// WPrice2
				if (GenericWrappers.isNotEmpty(Globals.Inventory.WPrice2)) {

					if (Globals.Inventory.WPrice2.contains(".")) {
						icp.setTextValue_Decimal(icp.WPrice2_String, Globals.Inventory.WPrice2);

					} else {

						icp.setTextValue(icp.WPrice2_String, Globals.Inventory.WPrice2);
					}

				}
				// WPrice3
				if (GenericWrappers.isNotEmpty(Globals.Inventory.WPrice3)) {

					if (Globals.Inventory.WPrice3.contains(".")) {
						icp.setTextValue_Decimal(icp.WPrice3_String, Globals.Inventory.WPrice3);

					} else {

						icp.setTextValue(icp.WPrice3_String, Globals.Inventory.WPrice3);
					}

				}

	}

	@Then("I fill inventory calculations page for MRP using excel data")
	public void i_fill_inventory_calculations_page_for_MRP_using_excel_data(Object driver) {
		
		// cess
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Cess) && !(Globals.Inventory.GSTPer).matches("0")) {
			if (Globals.Inventory.Cess.contains(".")) {
				icp.setTextValue_Decimal(icp.Cess_String, Globals.Inventory.Cess);
			} else {
				icp.setTextValue(icp.Cess_String, Globals.Inventory.Cess);
			}
		}
		
		// Additional cess amount
		if (GenericWrappers.isNotEmpty(Globals.Inventory.AdlCsAmt) && !(Globals.Inventory.GSTPer).matches("0")) {
			if (Globals.Inventory.AdlCsAmt.contains(".")) {
				icp.setTextValue_Decimal(icp.AdlCsAmt_String, Globals.Inventory.AdlCsAmt);
			} else {
				icp.setTextValue(icp.AdlCsAmt_String, Globals.Inventory.AdlCsAmt);
			}
		}
		
		

		// MRP
		if (GenericWrappers.isNotEmpty(Globals.Inventory.MRP)) {
			if (Globals.Inventory.MRP.contains(".")) {
				icp.setTextValue_Decimal(icp.MRP_String, Globals.Inventory.MRP);
			} else {
				icp.setTextValue(icp.MRP_String, Globals.Inventory.MRP);
			}
		}

		// Discount per
		if (GenericWrappers.isNotEmpty(Globals.Inventory.DiscountPer)) {

			if (Globals.Inventory.DiscountPer.contains(".")) {
				icp.setTextValue_Decimal(icp.Discount_String, Globals.Inventory.DiscountPer);

			} else {

				icp.setTextValue(icp.Discount_String, Globals.Inventory.DiscountPer);
			}

		}

		// Additional Discount per
		if (GenericWrappers.isNotEmpty(Globals.Inventory.AddDiscountPer)) {

			if (Globals.Inventory.AddDiscountPer.contains(".")) {
				icp.setTextValue_Decimal(icp.AddDiscountPer_String, Globals.Inventory.AddDiscountPer);

			} else {

				icp.setTextValue(icp.AddDiscountPer_String, Globals.Inventory.AddDiscountPer);
			}

		}

		// sp fixing %
		if (GenericWrappers.isNotEmpty(Globals.Inventory.spfixing)) {

			if (Globals.Inventory.spfixing.contains(".")) {
				icp.setTextValue_Decimal(icp.SP_String, Globals.Inventory.spfixing);

			} else {

				icp.setTextValue(icp.SP_String, Globals.Inventory.spfixing);
			}

		}
		
		// WPrice1
		if (GenericWrappers.isNotEmpty(Globals.Inventory.WPrice1)) {

			if (Globals.Inventory.WPrice1.contains(".")) {
				icp.setTextValue_Decimal(icp.WPrice1_String, Globals.Inventory.WPrice1);

			} else {

				icp.setTextValue(icp.WPrice1_String, Globals.Inventory.WPrice1);
			}

		}
		
		// WPrice2
		if (GenericWrappers.isNotEmpty(Globals.Inventory.WPrice2)) {

			if (Globals.Inventory.WPrice2.contains(".")) {
				icp.setTextValue_Decimal(icp.WPrice2_String, Globals.Inventory.WPrice2);

			} else {

				icp.setTextValue(icp.WPrice2_String, Globals.Inventory.WPrice2);
			}

		}
		// WPrice3
		if (GenericWrappers.isNotEmpty(Globals.Inventory.WPrice3)) {

			if (Globals.Inventory.WPrice3.contains(".")) {
				icp.setTextValue_Decimal(icp.WPrice3_String, Globals.Inventory.WPrice3);

			} else {

				icp.setTextValue(icp.WPrice3_String, Globals.Inventory.WPrice3);
			}
			
			//driver.findElement(By.id("lst-ib")).sendKeys(Keys.RETURN);


		}
		
	}

	private WebElement findElement(SearchContext id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Then("I fill the GST values in the inventory page")
	public void i_fill_the_GST_values_in_the_inventory_page() {

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

	}

	@Then("I verify the actual ui values with expected Excel values")
	public void i_verify_the_actual_ui_values_with_expected_Excel_values() {
		
		icp.NetSellingPrice = icp.getTextValue(icp.NetSellingPrice_text);
	
		Assert.assertEquals(icp.NetSellingPrice, Double.parseDouble(Globals.Inventory.NetSellingPrice));

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
			System.out.println("Exception occured"+ e);
		}
	}

}
