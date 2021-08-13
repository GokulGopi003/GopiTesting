package com.unipro.test.page_objects.unixpro;

import java.awt.RenderingHints.Key;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.unipro.test.framework.Globals;
import com.unipro.test.framework.PageObject;
import com.unipro.test.framework.helpers.utils.GenericWrappers;
import com.unipro.test.framework.helpers.utils.ReadTestData;
import com.unipro.test.framework.helpers.utils.ReadXLSXFile;
import com.unipro.test.step_definitions.unixpo.Unipro_Common_StepDefinitions;

import cucumber.api.java.en.Then;

public class Purchasereturn extends PageObject {

	AddInventoryFormPage add_inventory;
	Purchasereturn1 icp;
	CommonPages cp;

	TerminalPage terPage;

	public Purchasereturn(Purchasereturn1 icp, CommonPages cp) {
		this.icp = icp;
		terPage = new TerminalPage();

		this.cp = cp;
		add_inventory = new AddInventoryFormPage();

	}

	@Then("I load the PR sheet data to map")
	public void i_load_the_PR_sheet_data_to_map() {

		// Globals.Inventory.inventorySheetData1 =
		// Globals.excelSheetData.get(Globals.Inventory.SHEETNAME_DATA);

		Globals.Inventory.PurchasereturnSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME12);

	}

	@Then("I load the rowise PR data for {string} rowname")
	public void i_load_the_rowise_PR_data_for_rowname(String row_name) {

		Globals.Inventory.PurchasereturnrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.PurchasereturnSheetData, row_name);

		System.out.println(Globals.Inventory.PurchasereturnrowwiseData);

	}

	@Then("I update value to the PR page global Variables")
	public void i_update_value_to_the_PR_page_global_Variables() {
		Globals.Inventory.Vendor = Globals.Inventory.PurchasereturnrowwiseData.get("Vendor");
		Globals.Inventory.Date = Globals.Inventory.PurchasereturnrowwiseData.get("Date");
		Globals.Inventory.Batch = Globals.Inventory.PurchasereturnrowwiseData.get("Batch");
		Globals.Inventory.ItemName = Globals.Inventory.PurchasereturnrowwiseData.get("ItemName");
		Globals.Inventory.ItemCode = Globals.Inventory.PurchasereturnrowwiseData.get("ItemCode");
		Globals.Inventory.InvQty = Globals.Inventory.PurchasereturnrowwiseData.get("InvQty");
		Globals.Inventory.RecvQty = Globals.Inventory.PurchasereturnrowwiseData.get("RecvQty");
		Globals.Inventory.foc = Globals.Inventory.PurchasereturnrowwiseData.get("foc");
		Globals.Inventory.BasicCost = Globals.Inventory.PurchasereturnrowwiseData.get("BasicCost");
		Globals.Inventory.SDP = Globals.Inventory.PurchasereturnrowwiseData.get("SDP");
		Globals.Inventory.SDA = Globals.Inventory.PurchasereturnrowwiseData.get("SDA");
		Globals.Inventory.Batchrowno = Globals.Inventory.PurchasereturnrowwiseData.get("Batchrowno");
		Globals.Inventory.LocationCode = Globals.Inventory.PurchasereturnrowwiseData.get("LocationCode");
		Globals.Inventory.Vendorbillno = Globals.Inventory.PurchasereturnrowwiseData.get("Vendorbillno");
		Globals.Inventory.Gidno = Globals.Inventory.PurchasereturnrowwiseData.get("Gidno");
	}

	@Then("I fill new PR data page using excel data")
	public void i_fill_new_PR_data_page_using_excel_data() {
		  if (GenericWrappers.isNotEmpty(Globals.Inventory.LocationCode)) {
				terPage.terminal_waitClearEnterText_css(icp.LocationCode_String, Globals.Inventory.LocationCode);
				add_inventory.clearAndTypeSlowly(Globals.Inventory.LocationCode, "input#txtSearch");
				add_inventory.return_td_invoke_element(Globals.Inventory.LocationCode).click();
				
              
		}

		if (GenericWrappers.isNotEmpty(Globals.Inventory.Vendor)) {
			terPage.terminal_waitClearEnterText_css(icp.Vendor_String, Globals.Inventory.Vendor);
			add_inventory.clearAndTypeSlowly(Globals.Inventory.Vendor, "input#txtSearch");
			GenericWrappers.sleepInSeconds(1);
			add_inventory.return_td_invoke_element(Globals.Inventory.Vendor).click();
			//webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtVendor")).sendKeys(Keys.F3);
			// webDriver.findElement(By.cssSelector("//*[@id=\"ContentPlaceHolder1_lnkAddInv\"]")).click();

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemName)) {
			terPage.terminal_waitClearEnterText_css(icp.ItemName_String, Globals.Inventory.ItemName);
			

	    }
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Vendorbillno)) {
			webDriver.findElement(By.cssSelector("div#ContentPlaceHolder1_ddlVendorBillNo_chzn")).click();
			GenericWrappers.sleepInSeconds(1);
			//terPage.terminal_waitClearEnterText_css(icp.Vendor_String, Globals.Inventory.Vendor);
			WebElement itemCodeValue = webDriver.findElement(By.cssSelector("#ContentPlaceHolder1_ddlVendorBillNo_chzn > div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_ddlVendorBillNo_chzn > div > div > input[type=text]";
			By ddlocator = By.cssSelector(css_location_dropDownValue);
			waitForExpectedElement(ddlocator);
			js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.Vendorbillno);
			GenericWrappers.sleepInSeconds(1);
			itemCodeValue.sendKeys(Keys.SPACE);
			itemCodeValue.sendKeys(Keys.SPACE);
			itemCodeValue.sendKeys(Keys.ARROW_DOWN);
			GenericWrappers.sleepInSeconds(1);
			itemCodeValue.sendKeys(Keys.ENTER);
           
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Gidno)) {
			GenericWrappers.sleepInSeconds(1);
			webDriver.findElement(By.cssSelector("div#ContentPlaceHolder1_ddlGIDNo_chzn")).click();
			GenericWrappers.sleepInSeconds(1);
			//terPage.terminal_waitClearEnterText_css(icp.Vendor_String, Globals.Inventory.Vendor);
			WebElement itemCodeValue = webDriver.findElement(By.cssSelector("#ContentPlaceHolder1_ddlGIDNo_chzn > div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_ddlGIDNo_chzn > div > div > input[type=text]";
			By ddlocator = By.cssSelector(css_location_dropDownValue);
			waitForExpectedElement(ddlocator);
			js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.Gidno);
			GenericWrappers.sleepInSeconds(1);
			itemCodeValue.sendKeys(Keys.SPACE);
			itemCodeValue.sendKeys(Keys.SPACE);
			itemCodeValue.sendKeys(Keys.ARROW_DOWN);
			GenericWrappers.sleepInSeconds(1);
			itemCodeValue.sendKeys(Keys.ENTER);
           
		}

		if (GenericWrappers.isNotEmpty(Globals.Inventory.Date)) {
			terPage.terminal_waitClearEnterText_css(icp.Date_String, Globals.Inventory.Date);
			webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtReturnDate")).sendKeys(Keys.ENTER);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch)) {
			terPage.get_checkBox_element(icp.Batch_String).click();
			

		}
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemCode)) {
			terPage.terminal_waitClearEnterText_css(icp.ItemCode_String, Globals.Inventory.ItemCode);
			webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtItemCodeAdd")).sendKeys(Keys.ENTER);
			//WebElement itemCodeValue = webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtItemCodeAdd"));
			//itemCodeValue.click();
			
			//GenericWrappers.sleepInSeconds(1);
			//itemCodeValue.sendKeys(Keys.NUMPAD0);
			//GenericWrappers.sleepInSeconds(1);
			//itemCodeValue.sendKeys(Keys.BACK_SPACE);
			//itemCodeValue.sendKeys(Keys.ENTER);
			GenericWrappers.sleepInSeconds(1);
			
			
		     

			}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batchrowno)) {
			try {

				webDriver.findElement(By.cssSelector("#dataGridBatchTable_master_row"+ Globals.Inventory.Batchrowno +"> td.BatchNo")).click();
				} catch (Exception e) {
					System.out.println("Element  not found");
				}

		}
			
		if (GenericWrappers.isNotEmpty(Globals.Inventory.InvQty)) {
			if (Globals.Inventory.InvQty.contains(".")) {
				icp.setTextValue_Decimal(icp.InvQty_String, Globals.Inventory.InvQty);
			} else {
				icp.setTextValue(icp.InvQty_String, Globals.Inventory.InvQty);
			}
			webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtWQty")).sendKeys(Keys.RETURN);
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.RecvQty)) {
			if (Globals.Inventory.RecvQty.contains(".")) {
				icp.setTextValue_Decimal(icp.RecvQty_String, Globals.Inventory.RecvQty);
			} else {
				icp.setTextValue(icp.RecvQty_String, Globals.Inventory.RecvQty);
			}
			webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtLQty")).sendKeys(Keys.RETURN);
			
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.foc)) {
			if (Globals.Inventory.foc.contains(".")) {
				icp.setTextValue_Decimal(icp.foc_String, Globals.Inventory.foc);
			} else {
				icp.setTextValue(icp.foc_String, Globals.Inventory.foc);
			}
			webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtFoc")).sendKeys(Keys.RETURN);
		}

		if (GenericWrappers.isNotEmpty(Globals.Inventory.BasicCost)) {
			if (Globals.Inventory.BasicCost.contains(".")) {
				icp.setTextValue_Decimal(icp.BasicCost_String, Globals.Inventory.BasicCost);
			} else {
				icp.setTextValue(icp.BasicCost_String, Globals.Inventory.BasicCost);
			}
			webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtBasicCost")).sendKeys(Keys.RETURN);
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.SDP)) {
			if (Globals.Inventory.SDP.contains(".")) {
				icp.setTextValue_Decimal(icp.SDP_String, Globals.Inventory.SDP);
			} else {
				icp.setTextValue(icp.SDP_String, Globals.Inventory.SDP);
			}
			webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtSDPrc")).sendKeys(Keys.RETURN);
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.SDA)) {
			if (Globals.Inventory.SDA.contains(".")) {
				icp.setTextValue_Decimal(icp.SDA_String, Globals.Inventory.SDA);
			} else {
				icp.setTextValue(icp.SDA_String, Globals.Inventory.SDA);
			}
			webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtSDPrc")).sendKeys(Keys.RETURN);
		}

	}

}
