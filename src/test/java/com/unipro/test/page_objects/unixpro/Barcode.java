package com.unipro.test.page_objects.unixpro;

	import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebElement;
	import com.unipro.test.framework.Globals;
	import com.unipro.test.framework.PageObject;
	import com.unipro.test.framework.helpers.utils.GenericWrappers;
	import com.unipro.test.framework.helpers.utils.ReadTestData;
import com.unipro.test.page_objects.unixpro.AddInventoryFormPage;
import com.unipro.test.page_objects.unixpro.Origionfield;
import com.unipro.test.page_objects.unixpro.TerminalPage;

import cucumber.api.java.en.Then;

public class Barcode  extends PageObject {
		AddInventoryFormPage Category;
		Barcodefield icp;
		TerminalPage terPage;

		public Barcode(Barcodefield icp) {
			this.icp = icp;
			terPage = new TerminalPage();
			Category = new AddInventoryFormPage();
		}

		@Then("I load the Barcode sheet data to map")
		public void i_load_the_Subcategory_sheet_data_to_map() {
			Globals.Inventory.BarcodeSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME42);
		}

		@Then("I load the rowise Barcode data for {string} rowname")
		public void i_load_the_rowise_Category_data_for_rowname(String row_name) {

			Globals.Inventory.BarcoderowwiseData = ReadTestData
					.getRowFilteredValueFromTable(Globals.Inventory.BarcodeSheetData, row_name);

			System.out.println(Globals.Inventory.BarcodeSheetData);

		}

		@Then("I update value to the Barcode page global Variables")
		public void i_update_value_to_the_Subcategory_page_global_Variables() {
			Globals.Inventory.ItemCode = Globals.Inventory.BarcoderowwiseData.get("ItemCode");
			Globals.Inventory.Batchrowno = Globals.Inventory.BarcoderowwiseData.get("Batchrowno");
			Globals.Inventory.Remarks = Globals.Inventory.BarcoderowwiseData.get("Remarks");
			Globals.Inventory.Reorderbynoofdays = Globals.Inventory.BarcoderowwiseData.get("Reorderbynoofdays");
			Globals.Inventory.Qty = Globals.Inventory.BarcoderowwiseData.get("Qty");
			Globals.Inventory.Batch = Globals.Inventory.BarcoderowwiseData.get("Batch");
			Globals.Inventory.Batch1 = Globals.Inventory.BarcoderowwiseData.get("Batch1");
			Globals.Inventory.Batch2 = Globals.Inventory.BarcoderowwiseData.get("Batch2");
			Globals.Inventory.Batch3 = Globals.Inventory.BarcoderowwiseData.get("Batch3");
			Globals.Inventory.Batch4 = Globals.Inventory.BarcoderowwiseData.get("Batch4");
			Globals.Inventory.Date = Globals.Inventory.BarcoderowwiseData.get("Date");
			Globals.Inventory.Dateformat = Globals.Inventory.BarcoderowwiseData.get("Dateformat");
			Globals.Inventory.Template = Globals.Inventory.BarcoderowwiseData.get("Template");
			Globals.Inventory.Printername = Globals.Inventory.BarcoderowwiseData.get("Printername");
			
		}

		@Then("I fill new Barcode data page using excel data")
		public void i_fill_new_Subcategory_data_page_using_excel_data() {

		
		//if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemCode)) {
			//terPage.terminal_waitClearEnterText_Xpath(icp.ItemCode_String, Globals.Inventory.ItemCode);
			//webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtInventoryCode\"]")).sendKeys(Keys.RETURN);
			

		//}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemCode)) {
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtInventoryCode\"]")).sendKeys(Keys.F1);
			Category.clearAndTypeSlowly(Globals.Inventory.ItemCode, "input#txtSearch");
			Category.return_td_invoke_element(Globals.Inventory.ItemCode).click();

		}
		
			    
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batchrowno)) {
			try {
				GenericWrappers.sleepInSeconds(1);
				webDriver.findElement(By.xpath("//*[@id=\"dataGridBatchTable_master_row"+ Globals.Inventory.Batchrowno+"\"]")).click();
				
				} catch (Exception e) {
					System.out.println("Element  not found");
				}

		}
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Remarks)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Remarks_String, Globals.Inventory.Remarks);


		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Qty)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Qty_String, Globals.Inventory.Qty);


		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Reorderbynoofdays)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Reorderbynoofdays_String, Globals.Inventory.Reorderbynoofdays);


		}
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Date)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Date_String, Globals.Inventory.Date);
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtPkdData\"]")).sendKeys(Keys.RETURN);


		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Dateformat)) {
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_ddlDateformat_chzn\"]")).click();
			GenericWrappers.sleepInSeconds(1);
			//terPage.terminal_waitClearEnterText_css(icp.Vendor_String, Globals.Inventory.Vendor);
			WebElement itemCodeValue = webDriver.findElement(By.cssSelector("#ContentPlaceHolder1_ddlDateformat_chzn > div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_ddlDateformat_chzn > div > div > input[type=text]";
			By ddlocator = By.cssSelector(css_location_dropDownValue);
			waitForExpectedElement(ddlocator);
			js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.Dateformat);
			GenericWrappers.sleepInSeconds(1);
			itemCodeValue.sendKeys(Keys.SPACE);
			itemCodeValue.sendKeys(Keys.SPACE);
			itemCodeValue.sendKeys(Keys.ARROW_DOWN);
			GenericWrappers.sleepInSeconds(1);
			itemCodeValue.sendKeys(Keys.ENTER);
           
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch)) {
			terPage.get_checkBox_element_Xpath(icp.Batch_String).click();

		    }
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch1)) {
			terPage.get_checkBox_element_Xpath(icp.Batch1_String).click();

		    }
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch2)) {
			terPage.get_checkBox_element_Xpath(icp.Batch2_String).click();

		    }
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch3)) {
			terPage.get_checkBox_element_Xpath(icp.Batch3_String).click();

		    }
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch4)) {
			terPage.get_checkBox_element_Xpath(icp.Batch4_String).click();

		    }
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Template)) {
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_ddlTemplate_chzn\"]")).click();
			GenericWrappers.sleepInSeconds(1);
			//terPage.terminal_waitClearEnterText_css(icp.Vendor_String, Globals.Inventory.Vendor);
			WebElement itemCodeValue = webDriver.findElement(By.cssSelector("#ContentPlaceHolder1_ddlTemplate_chzn > div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_ddlTemplate_chzn > div > div > input[type=text]";
			By ddlocator = By.cssSelector(css_location_dropDownValue);
			waitForExpectedElement(ddlocator);
			js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.Template);
			GenericWrappers.sleepInSeconds(1);
			itemCodeValue.sendKeys(Keys.SPACE);
			itemCodeValue.sendKeys(Keys.SPACE);
			itemCodeValue.sendKeys(Keys.ARROW_DOWN);
			GenericWrappers.sleepInSeconds(1);
			itemCodeValue.sendKeys(Keys.ENTER);
           
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Printername)) {
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_ddlPrinterName_chzn\"]")).click();
			GenericWrappers.sleepInSeconds(1);
			//terPage.terminal_waitClearEnterText_css(icp.Vendor_String, Globals.Inventory.Vendor);
			WebElement itemCodeValue = webDriver.findElement(By.cssSelector("#ContentPlaceHolder1_ddlPrinterName_chzn > div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_ddlPrinterName_chzn > div > div > input[type=text]";
			By ddlocator = By.cssSelector(css_location_dropDownValue);
			waitForExpectedElement(ddlocator);
			js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.Printername);
			GenericWrappers.sleepInSeconds(1);
			itemCodeValue.sendKeys(Keys.SPACE);
			itemCodeValue.sendKeys(Keys.SPACE);
			itemCodeValue.sendKeys(Keys.ARROW_DOWN);
			GenericWrappers.sleepInSeconds(1);
			itemCodeValue.sendKeys(Keys.ENTER);
           
		}
}
}






