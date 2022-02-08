package com.unipro.test.page_objects.unixpro;

import java.awt.RenderingHints.Key;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import com.gk.test.MssqlConnect;
import com.unipro.ExcelWrite;
import com.unipro.test.framework.Globals;
import com.unipro.test.framework.PageObject;
import com.unipro.test.framework.helpers.screenshot_helper.Screenshot;
import com.unipro.test.framework.helpers.utils.GenericWrappers;
import com.unipro.test.framework.helpers.utils.ReadTestData;
import com.unipro.test.framework.helpers.utils.ReadXLSXFile;
import com.unipro.test.step_definitions.unixpo.Unipro_Common_StepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Purchasereturn extends PageObject {

	AddInventoryFormPage add_inventory;
	Purchasereturn1 icp;
	CommonPages cp;

	TerminalPage terPage;
	ExcelWrite pass;
	Screenshot scr;
	public Purchasereturn(Purchasereturn1 icp, CommonPages cp) {
		this.icp = icp;
		terPage = new TerminalPage();

		this.cp = cp;
		add_inventory = new AddInventoryFormPage();
		pass = new ExcelWrite();
		scr = new Screenshot();
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
		Globals.Inventory.Reason = Globals.Inventory.PurchasereturnrowwiseData.get("Reason");
	}

	@Then("I fill new PR data page using excel data")
	public void i_fill_new_PR_data_page_using_excel_data() throws Exception {
		try {
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
			GenericWrappers.sleepInSeconds(1);
			terPage.terminal_waitClearEnterText_css(icp.ItemName_String, Globals.Inventory.ItemName);
			GenericWrappers.sleepInSeconds(1);

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
			webDriver.findElement(By.cssSelector("#ContentPlaceHolder1_ddlGIDNo_chzn")).click();
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
			webDriver
			.findElement(By.cssSelector("input#ContentPlaceHolder1_txtWQty"))
			.sendKeys(Keys.SHIFT, Keys.LEFT);
	
	GenericWrappers.sleepInSeconds(1);
	webDriver
			.findElement(By.cssSelector("input#ContentPlaceHolder1_txtWQty"))
			.sendKeys(Keys.DELETE);
	terPage.terminal_waitClearEnterText_css(icp.InvQty_String, Globals.Inventory.InvQty);
			webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtWQty")).sendKeys(Keys.RETURN);
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.RecvQty)) {
			webDriver
			.findElement(By.cssSelector("input#ContentPlaceHolder1_txtLQty"))
			.sendKeys(Keys.SHIFT, Keys.LEFT);
			GenericWrappers.sleepInSeconds(1);
			webDriver
					.findElement(By.cssSelector("input#ContentPlaceHolder1_txtLQty"))
					.sendKeys(Keys.DELETE);
			terPage.terminal_waitClearEnterText_css(icp.RecvQty_String, Globals.Inventory.RecvQty);
			webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtLQty")).sendKeys(Keys.RETURN);
			
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.foc)) {
			webDriver
			.findElement(By.cssSelector("input#ContentPlaceHolder1_txtFOC"))
			.sendKeys(Keys.SHIFT, Keys.LEFT);
			GenericWrappers.sleepInSeconds(1);
			webDriver
					.findElement(By.cssSelector("input#ContentPlaceHolder1_txtFOC"))
					.sendKeys(Keys.DELETE);
			terPage.terminal_waitClearEnterText_css(icp.foc_String, Globals.Inventory.foc);
			webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtFoc")).sendKeys(Keys.RETURN);
		}

		if (GenericWrappers.isNotEmpty(Globals.Inventory.BasicCost)) {
			webDriver
			.findElement(By.cssSelector("input#ContentPlaceHolder1_txtBasicCost"))
			.sendKeys(Keys.SHIFT, Keys.LEFT);
	webDriver
	.findElement(By.cssSelector("input#ContentPlaceHolder1_txtBasicCost"))
	.sendKeys(Keys.SHIFT, Keys.LEFT);
    webDriver
	.findElement(By.cssSelector("input#ContentPlaceHolder1_txtBasicCost"))
	.sendKeys(Keys.SHIFT, Keys.LEFT);
    webDriver
	.findElement(By.cssSelector("input#ContentPlaceHolder1_txtBasicCost"))
	.sendKeys(Keys.SHIFT, Keys.LEFT);
webDriver
.findElement(By.cssSelector("input#ContentPlaceHolder1_txtBasicCost"))
.sendKeys(Keys.SHIFT, Keys.LEFT);
webDriver
.findElement(By.cssSelector("input#ContentPlaceHolder1_txtBasicCost"))
.sendKeys(Keys.SHIFT, Keys.LEFT);
webDriver
.findElement(By.cssSelector("input#ContentPlaceHolder1_txtBasicCost"))
.sendKeys(Keys.DELETE);
terPage.terminal_waitClearEnterText_css(icp.BasicCost_String, Globals.Inventory.BasicCost);
			webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtBasicCost")).sendKeys(Keys.RETURN);
			webDriver.findElement(By.cssSelector("a#ContentPlaceHolder1_lnkAdd")).click();
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
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Reason)) {
			webDriver.findElement(By.cssSelector("div#ContentPlaceHolder1_ddlRemarks_chzn")).click();
			GenericWrappers.sleepInSeconds(1);
			//terPage.terminal_waitClearEnterText_css(icp.Vendor_String, Globals.Inventory.Vendor);
			WebElement itemCodeValue = webDriver.findElement(By.cssSelector("#ContentPlaceHolder1_ddlRemarks_chzn > div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_ddlRemarks_chzn > div > div > input[type=text]";
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
		pass.ExcelFourData("PR","Modules", "Actual", "Expected", "Status",
				0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
		pass.Excelcreate("PR", "Filters", "Pass", 1, 0, 1, 3);
}
catch(Exception e) {
// screen shot
scr.Screenshots();
System.out.println("Screen shot taken");
// Xl sheet write
pass.ExcelFourData("PR","Filters", "Actual", "Expected", "Status",
		0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
pass.Excelcreate("PR", "Filters", "FAIL", 1, 0, 1, 3);
 
}
	}
	@Then("I close connection  DB for PR")
	public void I_close_connection_to_DB() throws SQLException {

		mysqlConnect.disconnect();
		System.out.println(" closed succesfully");

		// mysqlConnect.disconnect();

	}

	MssqlConnect mysqlConnect;
	Statement st;
	@Then("I establish connection  DB for PR")
	public void I_establish_connection_to_DB() throws SQLException {

		mysqlConnect = new MssqlConnect();
		st = mysqlConnect.connect().createStatement();
		System.out.println(" Connected succesfully");

	}
	@Given("I read the values from PR table {string} in DB")
	public void i_want_to_launch_the(String tablename ) throws SQLException, IOException {
		
		
		ResultSet rs = st.executeQuery("select * from "+tablename+" where Vendorcode='V00750'");
		
		System.out.println(rs);
		//ResultSet rs = st.executeQuery("");

		while (rs.next()) {

			switch (tablename) {
			
			case "tblPurchaseReturnHeader":
					
				String Sellingprice="";
				try {
					Sellingprice = rs.getString("VendorCode");
					System.out.println(Sellingprice);
					Assert.assertEquals(Globals.Inventory.Vendor.trim(), Sellingprice.trim());
					pass.Excelcreate("PR", "tblPurchaseReturnHeader", "", 3, 0, 3, 1);
					pass.ExcelFourData("PR", "VendorCode", Globals.Inventory.Vendor, Sellingprice, "Pass",
							5, 0, 5, 1, 5, 2, 5, 3);
				} catch (AssertionError e) {
					pass.Excelcreate("PR", "tblPurchaseReturnHeader", "", 3, 0, 3, 1);
					pass.ExcelFourData("PR", "VendorCode", Globals.Inventory.Vendor, Sellingprice, "Fail",
							5, 0, 5, 1, 5, 2, 5, 3);
				}
				catch(Exception e) {
					System.out.println("null error tblPurchaseReturnHeader column VendorCode");
				}
				String ReturnDate="";
				try {
					ReturnDate = rs.getString("ReturnDate");
					System.out.println(ReturnDate);
					Assert.assertEquals(Globals.Inventory.Date.trim(), ReturnDate.trim());
					pass.ExcelFourData("PR", "Date", Globals.Inventory.Date, ReturnDate, "Pass",
							6, 0, 6, 1, 6, 2, 6, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("PR", "Date", Globals.Inventory.Date, ReturnDate, "Fail",
							6, 0, 6, 1, 6, 2, 6, 3);
				}
				catch(Exception e) {
					System.out.println("null error tblPurchaseReturnHeader column ReturnDate");
				}
				String ReturnDate1="";
				try {
					ReturnDate1 = rs.getString("ReturnRemark");
					System.out.println(ReturnDate1);
					Assert.assertEquals(Globals.Inventory.Reason.trim(), ReturnDate1.trim());
					pass.ExcelFourData("PR", "Reason", Globals.Inventory.Reason, ReturnDate1, "Pass",
							7, 0, 7, 1, 7, 2, 7, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("PR", "Reason", Globals.Inventory.Reason, ReturnDate1, "Fail",
							7, 0, 7, 1, 7, 2, 7, 3);
				}
				catch(Exception e) {
					System.out.println("null error tblPurchaseReturnHeader column Reason");
				}
				String Basiccost="";
				try {
					Basiccost = rs.getString("TotalBasiccost");
					System.out.println(Basiccost);
					Assert.assertEquals(Globals.Inventory.BasicCost.trim(), Basiccost.trim());
					pass.ExcelFourData("PR", "BasicCost", Globals.Inventory.BasicCost, Basiccost, "Pass",
							8, 0, 8, 1, 8, 2, 8, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("PR", "BasicCost", Globals.Inventory.BasicCost, Basiccost, "Fail",
							8, 0, 8, 1, 8, 2, 8, 3);
				}
				catch(Exception e) {
					System.out.println("null error tblPurchaseReturnHeader column BasicCost");
				}
				
				
				break;
				
			case "tblAPtransaction":
				String Vendor="";
				try
				{
					Vendor = rs.getString("VendorCode");
					System.out.println(Vendor);
					Assert.assertEquals(Globals.Inventory.Vendor.trim(), Vendor.trim());
					pass.Excelcreate("PR", "tblAPtransaction", "", 10, 0, 10, 1);
					pass.ExcelFourData("PR", "Vendor", Globals.Inventory.Vendor, Vendor, "Pass",
							11, 0, 11, 1, 11, 2, 11, 3);
				} catch (AssertionError e) {
					pass.Excelcreate("PR", "tblAPtransaction", "", 10, 0, 10, 1);
					pass.ExcelFourData("PR", "Vendor", Globals.Inventory.Vendor, Vendor, "Fail",
							11, 0, 11, 1, 11, 2, 11, 3);
				}
				catch(Exception e) {
					System.out.println("null error tblAPtransaction column VendorCode");
				}
				String Promotiontodate="";
				try
				{
					Promotiontodate = rs.getString("Remarks");
					System.out.println(Promotiontodate);
					Assert.assertEquals(Globals.Inventory.Reason.trim(), Promotiontodate.trim());
					pass.ExcelFourData("PR", "Reason", Globals.Inventory.Reason, Promotiontodate, "Pass",
							12, 0, 12, 1, 12, 2, 12, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("PR", "Reason", Globals.Inventory.Reason, Promotiontodate, "Fail",
							12, 0, 12, 1, 12, 2, 12, 3);
				}
				catch(Exception e) {
					System.out.println("null error tblAPtransaction column Reason");
				}
				break;
			case "tblVendorBalance":
				String Promotionfromtime="";
				try
				{
					Promotionfromtime = rs.getString("BillDate");
					System.out.println(Promotionfromtime);
					Assert.assertEquals(Globals.Inventory.Date.trim(), Promotionfromtime.trim());
					pass.Excelcreate("PR", "tblVendorBalance", "", 14, 0, 14, 1);
					pass.ExcelFourData("PR", "Date", Globals.Inventory.Date, Promotionfromtime, "Pass",
							15, 0, 15, 1, 15, 2,15, 3);
				} catch (AssertionError e) {
					pass.Excelcreate("PR", "tblVendorBalance", "", 14, 0, 14, 1);
					pass.ExcelFourData("PR", "Date", Globals.Inventory.Date, Promotionfromtime, "Fail",
							15, 0, 15, 1, 15, 2,15, 3);
				}
				catch(Exception e) {
					System.out.println("null error tblVendorBalance column Date");
				}
				String WQty="";
				try
				{
					WQty = rs.getString("Vendorcode");
					System.out.println(WQty);
					Assert.assertEquals(Globals.Inventory.Vendor.trim(), WQty.trim());
					pass.ExcelFourData("PR", "InvQty", Globals.Inventory.Vendor, WQty, "Pass",
							16, 0, 16, 1, 16, 2,16, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("PR", "InvQty", Globals.Inventory.Vendor, WQty, "Fail",
							16, 0, 16, 1, 16, 2,16, 3);
				}
				catch(Exception e) {
					System.out.println("null error tblVendorBalance column Vendor");
				}
				break;
			case "tblPurchaseReturnDetail":
				String Foc="";
				try
				{
					Foc = rs.getString("inventorycode");
					System.out.println(Foc);
					Assert.assertEquals(Globals.Inventory.ItemCode.trim(), Foc.trim());
					pass.Excelcreate("PR", "tblPurchaseReturnDetail", "", 18, 0, 18, 1);
					pass.ExcelFourData("PR", "ItemCode", Globals.Inventory.ItemCode, Foc, "Pass",
							19, 0, 19, 1, 19, 2,19, 3);
				} catch (AssertionError e) {
					pass.Excelcreate("PR", "tblPurchaseReturnDetail", "", 18, 0, 18, 1);
					pass.ExcelFourData("PR", "ItemCode", Globals.Inventory.ItemCode, Foc, "Fail",
							19, 0, 19, 1, 19, 2,19, 3);
				}
				catch(Exception e) {
					System.out.println("null error tblPurchaseReturnDetail column ItemCode");
				}
				String UnitCost="";
				try
				{
					UnitCost = rs.getString("LreturnQty");
					System.out.println(UnitCost);
					Assert.assertEquals(Globals.Inventory.InvQty.trim(), UnitCost.trim());
					pass.ExcelFourData("PR", "foc", Globals.Inventory.InvQty, UnitCost, "Pass",
							20, 0, 20, 1, 20, 2,20, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("PR", "foc", Globals.Inventory.InvQty, UnitCost, "Fail",
							20, 0, 20, 1, 20, 2,20, 3);
				}
				catch(Exception e) {
					System.out.println("null error tblPurchaseReturnDetail column InvQty");
				}
				String SellingPrice="";
				try
				{
					SellingPrice = rs.getString("NreturnQty");
					System.out.println(SellingPrice);
					Assert.assertEquals(Globals.Inventory.RecvQty.trim(), SellingPrice.trim());
					pass.ExcelFourData("PR", "foc", Globals.Inventory.RecvQty, SellingPrice, "Pass",
							12, 0, 12, 1, 12, 2,12, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("PR", "foc", Globals.Inventory.RecvQty, SellingPrice, "Fail",
							12, 0, 12, 1, 12, 2,12, 3);
				}
				catch(Exception e) {
					System.out.println("null error tblPurchaseReturnDetail column InvQty");
				}
				String Foc1="";
				try
				{
					Foc1 = rs.getString("Foc");
					System.out.println(Foc1);
					Assert.assertEquals(Globals.Inventory.foc.trim(), Foc1.trim());
					pass.ExcelFourData("PO", "foc", Globals.Inventory.foc, Foc1, "Pass",
							13, 0, 13, 1, 13, 2,13, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("PO", "foc", Globals.Inventory.foc, Foc1, "Fail",
							13, 0, 13, 1, 13, 2,13, 3);
				}
				catch(Exception e) {
					System.out.println("null error tblpoDetail column foc");
				}
				String BasicCost="";
				try
				{
					BasicCost = rs.getString("BasicCost");
					System.out.println(BasicCost);
					Assert.assertEquals(Globals.Inventory.BasicCost.trim(), BasicCost.trim());
					pass.ExcelFourData("PO", "foc", Globals.Inventory.BasicCost, BasicCost, "Pass",
							14, 0, 14, 1, 14, 2,14, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("PO", "foc", Globals.Inventory.BasicCost, BasicCost, "Fail",
							14, 0, 14, 1, 14, 2,14, 3);
				}
				catch(Exception e) {
					System.out.println("null error tblpoDetail column BasicCost");
				}
				break;
			default:
				break;
			}
		
		}
	}

}
