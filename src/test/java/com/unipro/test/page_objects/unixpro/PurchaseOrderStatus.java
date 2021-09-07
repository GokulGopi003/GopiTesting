package com.unipro.test.page_objects.unixpro;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import com.unipro.test.framework.Globals;
import com.unipro.test.framework.PageObject;
import com.unipro.test.framework.helpers.utils.GenericWrappers;
import com.unipro.test.framework.helpers.utils.ReadTestData;
import cucumber.api.java.en.Then;

public class PurchaseOrderStatus extends PageObject {
	AddInventoryFormPage add_inventory;
	PurchaseOrderStatusfield icp;
	TerminalPage terPage;
	CommonPages cp;

	public PurchaseOrderStatus(PurchaseOrderStatusfield icp,CommonPages cp) {
		this.icp = icp;
		terPage = new TerminalPage();
		add_inventory = new AddInventoryFormPage();
		this.cp = cp;
	}

	@Then("I load the PurchaseOrderStatus sheet data to map")
	public void i_load_the_Subcategory_sheet_data_to_map() {
		Globals.Inventory.PurchaseOrderStatusSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME32);
	}

	@Then("I load the rowise PurchaseOrderStatus data for {string} rowname")
	public void i_load_the_rowise_Category_data_for_rowname(String row_name) {

		Globals.Inventory.PurchaseOrderStatusrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.PurchaseOrderStatusSheetData, row_name);

		System.out.println(Globals.Inventory.PurchaseOrderStatusSheetData);

	}

	@Then("I update value to the PurchaseOrderStatus page global Variables")
	public void i_update_value_to_the_Subcategory_page_global_Variables() {
		Globals.Inventory.Vendor = Globals.Inventory.PurchaseOrderStatusrowwiseData.get("Vendor");
		Globals.Inventory.Status = Globals.Inventory.PurchaseOrderStatusrowwiseData.get("Status");
		Globals.Inventory.NewVendornum = Globals.Inventory.PurchaseOrderStatusrowwiseData.get("NewVendornum");
	

	}

	@Then("I fill new PurchaseOrderStatus data page using excel data")
	public void i_fill_new_Subcategory_data_page_using_excel_data() {

		if (GenericWrappers.isNotEmpty(Globals.Inventory.Vendor)) {
			terPage.terminal_waitClearEnterText_css(icp.Vendor_String, Globals.Inventory.Vendor);
			add_inventory.clearAndTypeSlowly(Globals.Inventory.Vendor, "input#txtSearch");
			GenericWrappers.sleepInSeconds(2);
			webDriver.findElement(By.cssSelector("#table-Search > tbody > tr > td:nth-child(1)")).click();
			add_inventory.return_td_invoke_element(Globals.Inventory.Vendor).click();
			
			

		}
		 if (GenericWrappers.isNotEmpty(Globals.Inventory.Status)) {
				webDriver.findElement(By.cssSelector("div#ContentPlaceHolder1_ddlStatus_chzn")).click();
				GenericWrappers.sleepInSeconds(1);
				//terPage.terminal_waitClearEnterText_css(icp.Vendor_String, Globals.Inventory.Vendor);
				WebElement itemCodeValue = webDriver.findElement(By.cssSelector("#ContentPlaceHolder1_ddlStatus_chzn > div > div > input[type=text]"));
				String css_location_dropDownValue = "#ContentPlaceHolder1_ddlStatus_chzn > div > div > input[type=text]";
				By ddlocator = By.cssSelector(css_location_dropDownValue);
				waitForExpectedElement(ddlocator);
				js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.Status);
				GenericWrappers.sleepInSeconds(1);
				itemCodeValue.sendKeys(Keys.SPACE);
				itemCodeValue.sendKeys(Keys.SPACE);
				itemCodeValue.sendKeys(Keys.ARROW_DOWN);
				GenericWrappers.sleepInSeconds(1);
				itemCodeValue.sendKeys(Keys.ENTER);
            
			}
		 if (GenericWrappers.isNotEmpty(Globals.Inventory.NewVendornum)) {
				webDriver.findElement(By.cssSelector("div#ContentPlaceHolder1_ddlNewVendorName_chzn")).click();
				GenericWrappers.sleepInSeconds(1);
				//terPage.terminal_waitClearEnterText_css(icp.Vendor_String, Globals.Inventory.Vendor);
				WebElement itemCodeValue = webDriver.findElement(By.cssSelector("#ContentPlaceHolder1_ddlNewVendorName_chzn > div > div > input[type=text]"));
				String css_location_dropDownValue = "#ContentPlaceHolder1_ddlNewVendorName_chzn > div > div > input[type=text]";
				By ddlocator = By.cssSelector(css_location_dropDownValue);
				waitForExpectedElement(ddlocator);
				js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.NewVendornum);
				GenericWrappers.sleepInSeconds(1);
				itemCodeValue.sendKeys(Keys.SPACE);
				itemCodeValue.sendKeys(Keys.SPACE);
				itemCodeValue.sendKeys(Keys.ARROW_DOWN);
				GenericWrappers.sleepInSeconds(1);
				itemCodeValue.sendKeys(Keys.ENTER);
            
			}

	}

}


