package com.unipro.test.page_objects.unixpro;

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

	public class Purchaseorder  extends PageObject {

		AddInventoryFormPage add_inventory;
		Purchaseorder1 icp;
		CommonPages cp;
		
		

		TerminalPage terPage;
		
		

		public Purchaseorder(Purchaseorder1 icp,CommonPages cp) {
			this.icp = icp;
			terPage = new TerminalPage();
			
			this.cp = cp;
			add_inventory = new AddInventoryFormPage();

		}
		

		@Then("I load the PO sheet data to map")
		public void i_load_the_GA_sheet_data_to_map() {

			//Globals.Inventory.inventorySheetData1 = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME_DATA);

			Globals.Inventory.PurchaseorderSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME8);

		}
		@Then("I load the rowise PO data for {string} rowname")
		public void i_load_the_rowise_GA_data_for_rowname(String row_name) {

			Globals.Inventory.PurchaseorderrowwiseData = ReadTestData
					.getRowFilteredValueFromTable(Globals.Inventory.PurchaseorderSheetData, row_name);

			System.out.println(Globals.Inventory.PurchaseorderrowwiseData);

		}
		@Then("I update value to the PO page global Variables")
		public void i_update_value_to_the_GA_page_global_Variables() {
			Globals.Inventory.Vendor = Globals.Inventory.PurchaseorderrowwiseData.get("Vendor");
			Globals.Inventory.Brand = Globals.Inventory.PurchaseorderrowwiseData.get("Brand");
			Globals.Inventory.Batch = Globals.Inventory.PurchaseorderrowwiseData.get("Batch");
			Globals.Inventory.ItemName = Globals.Inventory.PurchaseorderrowwiseData.get("ItemName");
			Globals.Inventory.ItemCode = Globals.Inventory.PurchaseorderrowwiseData.get("ItemCode");
			Globals.Inventory.InvQty = Globals.Inventory.PurchaseorderrowwiseData.get("InvQty");
			Globals.Inventory.RecvQty = Globals.Inventory.PurchaseorderrowwiseData.get("RecvQty");
			Globals.Inventory.foc = Globals.Inventory.PurchaseorderrowwiseData.get("foc");
			Globals.Inventory.MRP = Globals.Inventory.PurchaseorderrowwiseData.get("MRP");
			Globals.Inventory.BasicCost = Globals.Inventory.PurchaseorderrowwiseData.get("BasicCost");
			Globals.Inventory.SDP = Globals.Inventory.PurchaseorderrowwiseData.get("SDP");
			Globals.Inventory.AddDed = Globals.Inventory.PurchaseorderrowwiseData.get("AddDed");
		}

		@Then("I fill new PO data page using excel data")
		public void i_fill_new_GA_data_page_using_excel_data() {
			
					if (GenericWrappers.isNotEmpty(Globals.Inventory.Vendor)) {
						terPage.terminal_waitClearEnterText_css(icp.Vendor_String, Globals.Inventory.Vendor);
						add_inventory.clearAndTypeSlowly(Globals.Inventory.Vendor, "input#txtSearch");
						add_inventory.return_td_invoke_element(Globals.Inventory.Vendor).click();
						//webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtItemCodeAdd")).sendKeys(Keys.F3);
						//webDriver.findElement(By.cssSelector("//*[@id=\"ContentPlaceHolder1_lnkAddInv\"]")).click();						

						}
					
					if (GenericWrappers.isNotEmpty(Globals.Inventory.Brand)) {
						terPage.terminal_waitClearEnterText_css(icp.Brand_String, Globals.Inventory.Brand);
						add_inventory.clearAndTypeSlowly(Globals.Inventory.Brand, "input#txtSearch");
						add_inventory.return_td_invoke_element(Globals.Inventory.Brand).click();
						
					}
				    if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch)) {
				        terPage.get_checkBox_element(icp.Batch_String).click();

			        }
					if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemName)) {
						terPage.terminal_waitClearEnterText_css(icp.ItemName_String, Globals.Inventory.ItemName);
						

					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemCode)) {
						terPage.terminal_waitClearEnterText_css(icp.ItemCode_String, Globals.Inventory.ItemCode);
						webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtItemCodeAdd")).sendKeys(Keys.RETURN);
						

					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.InvQty)) {
						if (Globals.Inventory.InvQty.contains(".")) {
							icp.setTextValue_Decimal(icp.InvQty_String, Globals.Inventory.InvQty);
						} else {
							icp.setTextValue(icp.InvQty_String, Globals.Inventory.InvQty);
						}
						webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtWQty")).sendKeys(Keys.RETURN    );
					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.RecvQty)) {
						if (Globals.Inventory.RecvQty.contains(".")) {
							icp.setTextValue_Decimal(icp.RecvQty_String, Globals.Inventory.RecvQty);
						} else {
							icp.setTextValue(icp.RecvQty_String, Globals.Inventory.RecvQty);
						}
						webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtLQty")).sendKeys(Keys.RETURN);
						webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtItemCodeAdd")).sendKeys(Keys.RETURN);
					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.foc)) {
						if (Globals.Inventory.foc.contains(".")) {
							icp.setTextValue_Decimal(icp.foc_String, Globals.Inventory.foc);
						} else {
							icp.setTextValue(icp.foc_String, Globals.Inventory.foc);
						}
						webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtFoc")).sendKeys(Keys.RETURN);
					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.MRP)) {
						if (Globals.Inventory.MRP.contains(".")) {
							icp.setTextValue_Decimal(icp.MRP_String, Globals.Inventory.MRP);
						} else {
							icp.setTextValue(icp.MRP_String, Globals.Inventory.MRP);
						}
						webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtMrp")).sendKeys(Keys.RETURN);
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
					if (GenericWrappers.isNotEmpty(Globals.Inventory.AddDed)) {
						 {
							
							 terPage.terminal_waitClearEnterText_css(icp.AddDed_String, Globals.Inventory.AddDed);
						}
						 webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtAddCess")).sendKeys(Keys.RETURN);
					}
			 
		   }
		   
		@Then("I need to search vendor")
		public void i_fill_new_PO_data_page_using_excel_data() {
			
					if (GenericWrappers.isNotEmpty(Globals.Inventory.Vendor)) {
						terPage.terminal_waitClearEnterText_css(icp.Vendor_String, Globals.Inventory.Vendor);
						add_inventory.clearAndTypeSlowly(Globals.Inventory.Vendor, "input#txtSearch");
						add_inventory.return_td_invoke_element(Globals.Inventory.Vendor).click();
					}
		}
		}



