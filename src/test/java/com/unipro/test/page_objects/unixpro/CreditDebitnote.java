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

	public class CreditDebitnote  extends PageObject {

		AddInventoryFormPage add_inventory;
		CreditDebitnotefield icp;
		CommonPages cp;
		
		

		TerminalPage terPage;
		

		public CreditDebitnote(CreditDebitnotefield icp,CommonPages cp) {
			this.icp = icp;
			terPage = new TerminalPage();
			
			this.cp = cp;
			add_inventory = new AddInventoryFormPage();

		}
		
		@Then("I load the CreditDebitnote sheet data to map")
		public void i_load_the_GA_sheet_data_to_map() {

			//Globals.Inventory.inventorySheetData1 = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME_DATA);

			Globals.Inventory.CreditDebitnoteSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME23);

		}
		@Then("I load the rowise CreditDebitnote data for {string} rowname")
		public void i_load_the_rowise_GA_data_for_rowname(String row_name) {

			Globals.Inventory.CreditDebitnoterowwiseData = ReadTestData
					.getRowFilteredValueFromTable(Globals.Inventory.CreditDebitnoteSheetData, row_name);

			System.out.println(Globals.Inventory.CreditDebitnoterowwiseData);

		}
		@Then("I update value to the CreditDebitnote page global Variables")
		public void i_update_value_to_the_GA_page_global_Variables() {
			Globals.Inventory.Batch = Globals.Inventory.CreditDebitnoterowwiseData.get("Batch");
			Globals.Inventory.Batch1 = Globals.Inventory.CreditDebitnoterowwiseData.get("Batch1");
			Globals.Inventory.Batch2 = Globals.Inventory.CreditDebitnoterowwiseData.get("Batch2");
			Globals.Inventory.LocationCode = Globals.Inventory.CreditDebitnoterowwiseData.get("LocationCode");
			Globals.Inventory.Vendor = Globals.Inventory.CreditDebitnoterowwiseData.get("Vendor");
			Globals.Inventory.Billno = Globals.Inventory.CreditDebitnoterowwiseData.get("Billno");
			Globals.Inventory.Billdate = Globals.Inventory.CreditDebitnoterowwiseData.get("Billdate");
			Globals.Inventory.Vendorno = Globals.Inventory.CreditDebitnoterowwiseData.get("Vendorno");
			Globals.Inventory.Date = Globals.Inventory.CreditDebitnoterowwiseData.get("Date");
			Globals.Inventory.Description = Globals.Inventory.CreditDebitnoterowwiseData.get("Description");
			Globals.Inventory.TotalAmount = Globals.Inventory.CreditDebitnoterowwiseData.get("TotalAmount");
			Globals.Inventory.GST = Globals.Inventory.CreditDebitnoterowwiseData.get("GST");
			Globals.Inventory.Reason = Globals.Inventory.CreditDebitnoterowwiseData.get("Reason");
		}

		@Then("I fill new CreditDebitnote data page using excel data")
		public void i_fill_new_GA_data_page_using_excel_data() {
			
				
				    if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch)) {
					terPage.get_checkBox_element(icp.Batch_String).click();

				    }
				    if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch1)) {
						terPage.get_checkBox_element(icp.Batch1_String).click();

					}
				    if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch2)) {
						terPage.get_checkBox_element(icp.Batch2_String).click();

					}
				    if (GenericWrappers.isNotEmpty(Globals.Inventory.LocationCode)) {
						webDriver.findElement(By.cssSelector("div#ContentPlaceHolder1_ddlCDLocationCode_chzn")).click();
						GenericWrappers.sleepInSeconds(1);
						//terPage.terminal_waitClearEnterText_css(icp.Vendor_String, Globals.Inventory.Vendor);
						WebElement itemCodeValue = webDriver.findElement(By.cssSelector("#ContentPlaceHolder1_ddlCDLocationCode_chzn > div > div > input[type=text]"));
						String css_location_dropDownValue = "#ContentPlaceHolder1_ddlCDLocationCode_chzn > div > div > input[type=text]";
						By ddlocator = By.cssSelector(css_location_dropDownValue);
						waitForExpectedElement(ddlocator);
						js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.LocationCode);
						GenericWrappers.sleepInSeconds(1);
						itemCodeValue.sendKeys(Keys.SPACE);
						itemCodeValue.sendKeys(Keys.SPACE);
						itemCodeValue.sendKeys(Keys.ARROW_DOWN);
						GenericWrappers.sleepInSeconds(1);
						itemCodeValue.sendKeys(Keys.ENTER);
		               
					}
			
					if (GenericWrappers.isNotEmpty(Globals.Inventory.Vendor)) {
						terPage.terminal_waitClearEnterText_css(icp.Vendor_String, Globals.Inventory.Vendor);
						add_inventory.clearAndTypeSlowly(Globals.Inventory.Vendor, "input#txtSearch");
						add_inventory.return_td_invoke_element(Globals.Inventory.Vendor).click();

					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.Billno)) {
						terPage.terminal_waitClearEnterText_css(icp.Billno_String, Globals.Inventory.Billno);
						

					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.Billdate)) {
						terPage.terminal_waitClearEnterText_css(icp.Billdate_String, Globals.Inventory.Billdate);
						webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtRefInvDate")).sendKeys(Keys.RETURN);


					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.Vendorno)) {
						terPage.terminal_waitClearEnterText_css(icp.Vendorno_String, Globals.Inventory.Vendorno);


					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.Date)) {
						terPage.terminal_waitClearEnterText_css(icp.Date_String, Globals.Inventory.Date);
						webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtVendorCDDate")).sendKeys(Keys.RETURN);


					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.Description)) {
						terPage.terminal_waitClearEnterText_css(icp.Description_String, Globals.Inventory.Date);


					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.TotalAmount)) {
						terPage.terminal_waitClearEnterText_css(icp.TotalAmount_String, Globals.Inventory.TotalAmount);


					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.GST)) {
						webDriver.findElement(By.cssSelector("div#ContentPlaceHolder1_ddlTaxPerc_chzn")).click();
						GenericWrappers.sleepInSeconds(1);
						//terPage.terminal_waitClearEnterText_css(icp.Vendor_String, Globals.Inventory.Vendor);
						WebElement itemCodeValue = webDriver.findElement(By.cssSelector("#ContentPlaceHolder1_ddlTaxPerc_chzn > div > div > input[type=text]"));
						String css_location_dropDownValue = "#ContentPlaceHolder1_ddlTaxPerc_chzn > div > div > input[type=text]";
						By ddlocator = By.cssSelector(css_location_dropDownValue);
						waitForExpectedElement(ddlocator);
						js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.GST);
						GenericWrappers.sleepInSeconds(1);
						itemCodeValue.sendKeys(Keys.SPACE);
						itemCodeValue.sendKeys(Keys.SPACE);
						itemCodeValue.sendKeys(Keys.ARROW_DOWN);
						GenericWrappers.sleepInSeconds(1);
						itemCodeValue.sendKeys(Keys.ENTER);
		               
					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.Reason)) {
						webDriver.findElement(By.cssSelector("div#ContentPlaceHolder1_ddlReason_chzn")).click();
						GenericWrappers.sleepInSeconds(1);
						//terPage.terminal_waitClearEnterText_css(icp.Vendor_String, Globals.Inventory.Vendor);
						WebElement itemCodeValue = webDriver.findElement(By.cssSelector("#ContentPlaceHolder1_ddlReason_chzn > div > div > input[type=text]"));
						String css_location_dropDownValue = "#ContentPlaceHolder1_ddlReason_chzn > div > div > input[type=text]";
						By ddlocator = By.cssSelector(css_location_dropDownValue);
						waitForExpectedElement(ddlocator);
						js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.Reason);
						GenericWrappers.sleepInSeconds(1);
						itemCodeValue.sendKeys(Keys.SPACE);
						itemCodeValue.sendKeys(Keys.SPACE);
						itemCodeValue.sendKeys(Keys.ARROW_DOWN);
						GenericWrappers.sleepInSeconds(1);
						itemCodeValue.sendKeys(Keys.ENTER);
		               
					}		
					
		}
		@Then("I need to click on the  print")
		public void i_update_value_to_the_CreditDebitnote_page_global_Variables() {
			WebElement ele = cp.waitForExpectedElement(By.xpath("//*[@id=\"tblSupplierNote\"]/tbody/tr/td[3]/input"), 3);
			ele.click();
			
		}
		@Then("I need to click on the  Delete")
		public void i_update_value_to_the_Delete() {
			WebElement ele = cp.waitForExpectedElement(By.xpath("//*[@id=\"tblSupplierNote\"]/tbody/tr/td[4]/input"), 3);
			ele.click();
		}
		   
		
	}




