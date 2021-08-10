package com.unipro.test.page_objects.unixpro;


	import java.util.List;

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

	public class PurchaseReturnReq  extends PageObject {

		AddInventoryFormPage add_inventory;
		PurchasereturnReqfield icp;
		CommonPages cp;
		
		

		TerminalPage terPage;
		
		

		public PurchaseReturnReq(PurchasereturnReqfield icp,CommonPages cp) {
			this.icp = icp;
			terPage = new TerminalPage();
			
			this.cp = cp;
			add_inventory = new AddInventoryFormPage();

		}
		

		@Then("I load the PRR sheet data to map")
		public void i_load_the_PR_sheet_data_to_map() {

			//Globals.Inventory.inventorySheetData1 = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME_DATA);

			Globals.Inventory.PurchasereturnReqSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME17);

		}
		@Then("I load the rowise PRR data for {string} rowname")
		public void i_load_the_rowise_PR_data_for_rowname(String row_name) {

			Globals.Inventory.PurchasereturnReqrowwiseData = ReadTestData
					.getRowFilteredValueFromTable(Globals.Inventory.PurchasereturnReqSheetData, row_name);

			System.out.println(Globals.Inventory.PurchasereturnReqrowwiseData);

		}
		@Then("I update value to the PRR page global Variables")
		public void i_update_value_to_the_PR_page_global_Variables() {
			Globals.Inventory.ItemCode = Globals.Inventory.PurchasereturnReqrowwiseData.get("ItemCode");
			Globals.Inventory.InvQty = Globals.Inventory.PurchasereturnReqrowwiseData.get("InvQty");
			Globals.Inventory.Remark = Globals.Inventory.PurchasereturnReqrowwiseData.get("Remark");
			Globals.Inventory.LocationCode = Globals.Inventory.PurchasereturnReqrowwiseData.get("LocationCode");
			Globals.Inventory.Vendor = Globals.Inventory.PurchasereturnReqrowwiseData.get("Vendor");
		}

		@Then("I fill new PRR data page using excel data")
		public void i_fill_new_PR_data_page_using_excel_data() {
			 
			        if (GenericWrappers.isNotEmpty(Globals.Inventory.LocationCode)) {
					terPage.terminal_waitClearEnterText_css(icp.LocationCode_String, Globals.Inventory.LocationCode);
					add_inventory.clearAndTypeSlowly(Globals.Inventory.LocationCode, "input#txtSearch");
					add_inventory.return_td_invoke_element(Globals.Inventory.LocationCode).click();
					
                    
				       }
			       if (GenericWrappers.isNotEmpty(Globals.Inventory.Remark)) {
				   terPage.terminal_waitClearEnterText_css(icp.Remark_String, Globals.Inventory.Remark);
			

			        }
			
					if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemCode)) {
						terPage.terminal_waitClearEnterText_css(icp.ItemCode_String, Globals.Inventory.ItemCode);				
						webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtInventoryCode")).sendKeys(Keys.ENTER);
						webDriver.findElement(By.cssSelector("#dataGridBatchTable_master_row0 > td.BatchNo")).click();
						}
					
					
					if (GenericWrappers.isNotEmpty(Globals.Inventory.InvQty)) {
						if (Globals.Inventory.InvQty.contains(".")) {
							icp.setTextValue_Decimal(icp.InvQty_String, Globals.Inventory.InvQty);
						} else {
							icp.setTextValue(icp.InvQty_String, Globals.Inventory.InvQty);
						}
						
					}
					
					if (GenericWrappers.isNotEmpty(Globals.Inventory.Vendor)) {
						webDriver.findElement(By.cssSelector("div#ContentPlaceHolder1_DropDownVendor_chzn.chzn-container.chzn-container-single.chzn-container-single-nosearch")).click();
						terPage.terminal_waitClearEnterText_css(icp.Vendor_String, Globals.Inventory.Vendor);
						//webDriver.findElement(By.cssSelector("//*[@id=\"ContentPlaceHolder1_lnkAddInv\"]")).click();						

						}
					
					
				
		   }
		   





}


