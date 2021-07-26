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

public class CreateGA extends PageObject {

	AddInventoryFormPage add_inventory;
	GAcreate icp;
	CommonPages cp;
	
	

	TerminalPage terPage;
	

	public CreateGA(GAcreate icp,CommonPages cp) {
		this.icp = icp;
		terPage = new TerminalPage();
		
		this.cp = cp;
		add_inventory = new AddInventoryFormPage();

	}
	
	
	
	@Then("I load the testdatas form excel to table")
	public void i_load_the_testdata_form_excel_to_table() {

		// Globals.excelSheetData = ReadXLSXFile.getExcelAsMapTable("./testdata/sample
		// mrp.xlsx");
		Globals.excelSheetData = ReadXLSXFile.getExcelAsMapTable("./testdata/sample inventory all.xlsx");

	}
	@Then("I load the GA sheet data to map")
	public void i_load_the_GA_sheet_data_to_map() {

		//Globals.Inventory.inventorySheetData1 = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME_DATA);

		Globals.Inventory.GAcreateSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME3);

	}
	@Then("I load the rowise GA data for {string} rowname")
	public void i_load_the_rowise_GA_data_for_rowname(String row_name) {

		Globals.Inventory.GAcreaterowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.GAcreateSheetData, row_name);

		System.out.println(Globals.Inventory.GAcreaterowwiseData);

	}
	@Then("I update value to the GA page global Variables")
	public void i_update_value_to_the_GA_page_global_Variables() {
		Globals.Inventory.Vendor = Globals.Inventory.GAcreaterowwiseData.get("Vendor");
		Globals.Inventory.Billno = Globals.Inventory.GAcreaterowwiseData.get("Billno");
		Globals.Inventory.Billdate = Globals.Inventory.GAcreaterowwiseData.get("Billdate");
		Globals.Inventory.GrossAmount = Globals.Inventory.GAcreaterowwiseData.get("GrossAmount");
		Globals.Inventory.GST = Globals.Inventory.GAcreaterowwiseData.get("GST");
		Globals.Inventory.TotalAmount = Globals.Inventory.GAcreaterowwiseData.get("TotalAmount");
		Globals.Inventory.AddDed = Globals.Inventory.GAcreaterowwiseData.get("AddDed");
		Globals.Inventory.TotalPayable = Globals.Inventory.GAcreaterowwiseData.get("TotalPayable");
		Globals.Inventory.Remark = Globals.Inventory.GAcreaterowwiseData.get("Remark");
		Globals.Inventory.Batch = Globals.Inventory.GAcreaterowwiseData.get("Batch");
		Globals.Inventory.search = Globals.Inventory.GAcreaterowwiseData.get("search");
	}

	@Then("I fill new GA data page using excel data")
	public void i_fill_new_GA_data_page_using_excel_data() {
		
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


				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.GrossAmount)) {
					if (Globals.Inventory.GrossAmount.contains(".")) {
						icp.setTextValue_Decimal(icp.GrossAmount_String, Globals.Inventory.GrossAmount);
					} else {
						icp.setTextValue(icp.GrossAmount_String, Globals.Inventory.GrossAmount);
					}
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.GST)) {
					if (Globals.Inventory.GST.contains(".")) {
						icp.setTextValue_Decimal(icp.GST_String, Globals.Inventory.GST);
					} else {
						icp.setTextValue(icp.GST_String, Globals.Inventory.GST);
					}
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.TotalAmount)) {
					if (Globals.Inventory.TotalAmount.contains(".")) {
						icp.setTextValue_Decimal(icp.TotalAmount_String, Globals.Inventory.TotalAmount);
					} else {
						icp.setTextValue(icp.TotalAmount_String, Globals.Inventory.TotalAmount);
					}
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.AddDed)) {
					 {
						
						 terPage.terminal_waitClearEnterText_css(icp.AddDed_String, Globals.Inventory.AddDed);
					}
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.TotalPayable)) {
					if (Globals.Inventory.TotalPayable.contains(".")) {
						icp.setTextValue_Decimal(icp.TotalPayable_String, Globals.Inventory.TotalPayable);
					} else {
						icp.setTextValue(icp.TotalPayable_String, Globals.Inventory.TotalPayable);
					}
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Remark)) {
					terPage.terminal_waitClearEnterText_css(icp.Remark_String, Globals.Inventory.Remark);
				

				}			
				if (GenericWrappers.isNotEmpty(Globals.Inventory.search)) {
					terPage.terminal_waitClearEnterText_css(icp.search_String, Globals.Inventory.search);
					add_inventory.clearAndTypeSlowly(Globals.Inventory.search, "input#txtSearch");
					add_inventory.return_td_invoke_element(Globals.Inventory.search).click();

				}
	}
	
	   @Then("I want to click purchase order")
	   public void I_want_to_click_purchase_order() {
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch)) {
				terPage.get_checkBox_element(icp.Batch_String).click();

			}
			
		   
	   }
	   @Then ("I need to click on the page")
	   public void I_need_to_click_on_the_page() {
		   //webDriver.findElement(By.xpath("//*[@id=\"Tabs\"]/ul/li[3]/a")).click();
		   
		   //webDriver.findElement(By.xpath("//*[@id=\"Tabs\"]/ul/li[4]/a")).click();
		   //webDriver.findElement(By.xpath("//*[@id=\"Tabs\"]/ul/li[2]/a")).click();
		   webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_lnkAddInv\"]")).click();
		 
		 
	   }
	   
	
	}

