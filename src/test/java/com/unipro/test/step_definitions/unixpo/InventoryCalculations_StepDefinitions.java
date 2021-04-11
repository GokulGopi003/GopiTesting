package com.unipro.test.step_definitions.unixpo;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import java.util.Map;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.google.common.collect.Table;
import com.unipro.test.framework.Globals;
import com.unipro.test.framework.helpers.utils.ApplicationLogger;
import com.unipro.test.framework.helpers.utils.GenericWrappers;
import com.unipro.test.framework.helpers.utils.ReadTestData;
import com.unipro.test.framework.helpers.utils.ReadXLSXFile;
import com.unipro.test.page_objects.unixpro.InventoryCalculationsPage;
import com.unipro.test.page_objects.unixpro.TerminalPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class InventoryCalculations_StepDefinitions {
	InventoryCalculationsPage icp;

	TerminalPage terPage;
	public InventoryCalculations_StepDefinitions(InventoryCalculationsPage icp) {

		this.icp = icp;
		terPage= new TerminalPage();
		
	
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

		Globals.excelSheetData = ReadXLSXFile.getExcelAsMapTable("./testdata/sample mrp.xlsx");

	}

	@Then("I load the inventory sheet data to map")
	public void i_load_the_inventory_sheet_data_to_map() {

		Globals.Inventory.inventorySheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME);

	}

	@Then("I load the rowise inventory data for {string} rowname")
	public void i_load_the_rowise_inventory_data_for_rowname(String row_name) {

		Globals.Inventory.inventoryrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.inventorySheetData, row_name);

		System.out.println(Globals.Inventory.inventoryrowwiseData);

	}

	@Then("I update value to the inventory page global Variables")
	public void i_update_value_to_the_inventory_page_global_Variables() {

		Globals.Inventory.MRP = Globals.Inventory.inventoryrowwiseData.get("MRP");
		Globals.Inventory.BasicCost = Globals.Inventory.inventoryrowwiseData.get("BasicCost");
		Globals.Inventory.DiscountPer1 = Globals.Inventory.inventoryrowwiseData.get("DiscountPer1");
		Globals.Inventory.DiscountPer2 = Globals.Inventory.inventoryrowwiseData.get("DiscountPer2");
		Globals.Inventory.DiscountPer3 = Globals.Inventory.inventoryrowwiseData.get("DiscountPer3");
		Globals.Inventory.GSTPer = Globals.Inventory.inventoryrowwiseData.get("GSTPer");
		Globals.Inventory.NetSellingPrice = Globals.Inventory.inventoryrowwiseData.get("NetSellingPrice");
		Globals.Inventory.spfixing = Globals.Inventory.inventoryrowwiseData.get("s.p.fixing%");
		Globals.Inventory.netcost = Globals.Inventory.inventoryrowwiseData.get("netcost");
		
		Globals.Inventory.DiscountPer = Globals.Inventory.inventoryrowwiseData.get("DiscountPer");
		Globals.Inventory.AddDiscountPer = Globals.Inventory.inventoryrowwiseData.get("AddDiscountPer");
	}

	@Then("I fill inventory calculations page using excel data")
	public void i_fill_inventory_calculations_page_using_excel_data() {

		
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


	}
	
	@Then("I fill inventory calculations page for MRP using excel data")
	public void i_fill_inventory_calculations_page_for_MRP_using_excel_data() {
		
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
		
	}

	@Then("I fill the GST values in the inventory page")
	public void i_fill_the_GST_values_in_the_inventory_page() {
		
		terPage.return_dd_invoke_element("-- Select --", 0).click();
		
		//WebElement dd_element = terPage.waitAndSelectDropDownUsingSerachBox(Globals.Inventory.GSTPer, "IGST");
		GenericWrappers.sleepInSeconds(4);
		
		
		icp.search_dd_value(Globals.Inventory.GSTPer);
	
		
//		dd_element.sendKeys(Keys.SPACE);
//		dd_element.sendKeys(Keys.SPACE);
//		dd_element.sendKeys(Keys.ARROW_DOWN);
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		dd_element.sendKeys(Keys.ENTER);

	}

	@Then("I verify the actual ui values with expected Excel values")
	public void i_verify_the_actual_ui_values_with_expected_Excel_values() {
		
		icp.NetSellingPrice= icp.getTextValue(icp.NetSellingPrice_text);
		

		Assert.assertEquals(icp.NetSellingPrice,Double.parseDouble(Globals.Inventory.NetSellingPrice));

	}
	
	


}
