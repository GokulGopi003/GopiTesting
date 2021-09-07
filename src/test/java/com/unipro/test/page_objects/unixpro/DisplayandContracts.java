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

	public class DisplayandContracts  extends PageObject {

		AddInventoryFormPage add_inventory;
		DisplayandContractsField icp;
		CommonPages cp;
		
		

		TerminalPage terPage;
		

		public DisplayandContracts(DisplayandContractsField icp,CommonPages cp) {
			this.icp = icp;
			terPage = new TerminalPage();
			
			this.cp = cp;
			add_inventory = new AddInventoryFormPage();

		}
	
		@Then("I load the DisplayandContracts sheet data to map")
		public void i_load_the_GA_sheet_data_to_map() {

			//Globals.Inventory.inventorySheetData1 = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME_DATA);

			Globals.Inventory.DisplayandContractsSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME28);

		}
		@Then("I load the rowise DisplayandContracts data for {string} rowname")
		public void i_load_the_rowise_GA_data_for_rowname(String row_name) {

			Globals.Inventory.DisplayandContractsrowwiseData = ReadTestData
					.getRowFilteredValueFromTable(Globals.Inventory.DisplayandContractsSheetData, row_name);

			System.out.println(Globals.Inventory.GAcreaterowwiseData);

		}
		@Then("I update value to the DisplayandContracts page global Variables")
		public void i_update_value_to_the_GA_page_global_Variables() {
			Globals.Inventory.Vendor = Globals.Inventory.DisplayandContractsrowwiseData.get("Vendor");
			Globals.Inventory.Department = Globals.Inventory.DisplayandContractsrowwiseData.get("Department");
			Globals.Inventory.Category = Globals.Inventory.DisplayandContractsrowwiseData.get("Category");
			Globals.Inventory.Brand = Globals.Inventory.DisplayandContractsrowwiseData.get("Brand");
			Globals.Inventory.CCode = Globals.Inventory.DisplayandContractsrowwiseData.get("CCode");
			Globals.Inventory.Date = Globals.Inventory.DisplayandContractsrowwiseData.get("Date");
			Globals.Inventory.Billdate = Globals.Inventory.DisplayandContractsrowwiseData.get("Billdate");
			Globals.Inventory.Amount = Globals.Inventory.DisplayandContractsrowwiseData.get("Amount");
			Globals.Inventory.DiscP = Globals.Inventory.DisplayandContractsrowwiseData.get("Remark");
			Globals.Inventory.Discount = Globals.Inventory.DisplayandContractsrowwiseData.get("Discount");
			Globals.Inventory.TotalAmount = Globals.Inventory.DisplayandContractsrowwiseData.get("TotalAmount");
			Globals.Inventory.ItemCode = Globals.Inventory.DisplayandContractsrowwiseData.get("ItemCode");
			Globals.Inventory.Batchrowno = Globals.Inventory.DisplayandContractsrowwiseData.get("Batchrowno");
			Globals.Inventory.Qty = Globals.Inventory.DisplayandContractsrowwiseData.get("Qty");
			Globals.Inventory.Refno = Globals.Inventory.DisplayandContractsrowwiseData.get("Refno");
			Globals.Inventory.PaymentDate = Globals.Inventory.DisplayandContractsrowwiseData.get("PaymentDate");
			Globals.Inventory.RefDate = Globals.Inventory.DisplayandContractsrowwiseData.get("RefDate");
			Globals.Inventory.Remarks = Globals.Inventory.DisplayandContractsrowwiseData.get("Remarks");
		}

		@Then("I fill new DisplayandContracts data page using excel data")
		public void i_fill_new_GA_data_page_using_excel_data() {
			
					if (GenericWrappers.isNotEmpty(Globals.Inventory.Vendor)) {
						terPage.terminal_waitClearEnterText_css(icp.Vendor_String, Globals.Inventory.Vendor);
						add_inventory.clearAndTypeSlowly(Globals.Inventory.Vendor, "input#txtSearch");
						GenericWrappers.sleepInSeconds(1);
						add_inventory.return_td_invoke_element(Globals.Inventory.Vendor).click();

					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.Department)) {
						terPage.terminal_waitClearEnterText_css(icp.Department_String, Globals.Inventory.Department);
						add_inventory.clearAndTypeSlowly(Globals.Inventory.Department, "input#txtSearch");
						add_inventory.return_td_invoke_element(Globals.Inventory.Department).click();

					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.Category)) {
						terPage.terminal_waitClearEnterText_css(icp.Category_String, Globals.Inventory.Category);
						add_inventory.clearAndTypeSlowly(Globals.Inventory.Category, "input#txtSearch");
						add_inventory.return_td_invoke_element(Globals.Inventory.Category).click();

					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.Brand)) {
						terPage.terminal_waitClearEnterText_css(icp.Brand_String, Globals.Inventory.Brand);
						add_inventory.clearAndTypeSlowly(Globals.Inventory.Brand, "input#txtSearch");
						add_inventory.return_td_invoke_element(Globals.Inventory.Brand).click();

					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.CCode)) {
						terPage.terminal_waitClearEnterText_css(icp.CCode_String, Globals.Inventory.CCode);
						add_inventory.clearAndTypeSlowly(Globals.Inventory.CCode, "input#txtSearch");
						GenericWrappers.sleepInSeconds(1);
						add_inventory.return_td_invoke_element(Globals.Inventory.CCode).click();

					}
					
					if (GenericWrappers.isNotEmpty(Globals.Inventory.Date)) {
						terPage.terminal_waitClearEnterText_css(icp.Date_String, Globals.Inventory.Date);
						webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtFromDate")).sendKeys(Keys.RETURN);


					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.Billdate)) {
						terPage.terminal_waitClearEnterText_css(icp.Billdate_String, Globals.Inventory.Billdate);
						webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtToDate")).sendKeys(Keys.RETURN);


					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.Amount)) {
						terPage.terminal_waitClearEnterText_css(icp.Amount_String, Globals.Inventory.Amount);
						webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtamt")).sendKeys(Keys.RETURN);
					

					}	
					if (GenericWrappers.isNotEmpty(Globals.Inventory.DiscP)) {
						terPage.terminal_waitClearEnterText_css(icp.DiscP_String, Globals.Inventory.DiscP);
						webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtxDisPerc")).sendKeys(Keys.RETURN);
					

					}			
					if (GenericWrappers.isNotEmpty(Globals.Inventory.Discount)) {
						terPage.terminal_waitClearEnterText_css(icp.Discount_String, Globals.Inventory.Discount);
						//webDriver.findElement(By.cssSelector("inputinput#ContentPlaceHolder1_txtDisAmt")).sendKeys(Keys.RETURN);
					

					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemCode)) {
						terPage.terminal_waitClearEnterText_css(icp.ItemCode_String, Globals.Inventory.ItemCode);
						webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtInventoryCode")).sendKeys(Keys.RETURN);
						GenericWrappers.sleepInSeconds(1);

					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.Batchrowno)) {
						try {

							webDriver.findElement(By.cssSelector("#dataGridBatchTable_master_row"+ Globals.Inventory.Batchrowno +"> td.BatchNo")).click();
							} catch (Exception e) {
								System.out.println("Element  not found");
							}

					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.Qty)) {
						terPage.terminal_waitClearEnterText_css(icp.Qty_String, Globals.Inventory.Qty);
					

					}
		
					if (GenericWrappers.isNotEmpty(Globals.Inventory.PaymentDate)) {
						terPage.terminal_waitClearEnterText_css(icp.PaymentDate_String, Globals.Inventory.PaymentDate);
						webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtFromDate")).sendKeys(Keys.RETURN);
					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.Refno)) {
				           terPage.terminal_waitClearEnterText_css(icp.Refno_String, Globals.Inventory.Refno);
					       webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtInventoryCode")).sendKeys(Keys.RETURN);
					       GenericWrappers.sleepInSeconds(1);

				    }
					
					if (GenericWrappers.isNotEmpty(Globals.Inventory.RefDate)) {
						terPage.terminal_waitClearEnterText_css(icp.RefDate_String, Globals.Inventory.RefDate);
						webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtFromDate")).sendKeys(Keys.RETURN);
					}
		           if (GenericWrappers.isNotEmpty(Globals.Inventory.Remarks)) {
			           terPage.terminal_waitClearEnterText_css(icp.Remarks_String, Globals.Inventory.Remarks);

			       }
		
		   
		
		}

	}
