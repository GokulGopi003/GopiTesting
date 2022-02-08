package com.unipro.test.page_objects.unixpro;

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

	public class Purchaseorder  extends PageObject {

		AddInventoryFormPage add_inventory;
		Purchaseorder1 icp;
		CommonPages cp;
		ExcelWrite pass;
		Screenshot scr;
		

		TerminalPage terPage;
		
		

		public Purchaseorder(Purchaseorder1 icp,CommonPages cp) {
			this.icp = icp;
			terPage = new TerminalPage();
			
			this.cp = cp;
			add_inventory = new AddInventoryFormPage();
			pass = new ExcelWrite();
			scr = new Screenshot();

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
		public void i_fill_new_GA_data_page_using_excel_data() throws Exception {
			try {
				
					if (GenericWrappers.isNotEmpty(Globals.Inventory.Vendor)) {
						terPage.terminal_waitClearEnterText_css(icp.Vendor_String, Globals.Inventory.Vendor);
						add_inventory.clearAndTypeSlowly(Globals.Inventory.Vendor, "input#txtSearch");
						add_inventory.return_td_invoke_element(Globals.Inventory.Vendor).click();
					    webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtItemCodeAdd")).sendKeys(Keys.F3);
						//webDriver.findElement(By.cssSelector("//*[@id=\"ContentPlaceHolder1_lnkAddInv\"]")).click();						

						}
					
					if (GenericWrappers.isNotEmpty(Globals.Inventory.Brand)) {
						terPage.terminal_waitClearEnterText_css(icp.Brand_String, Globals.Inventory.Brand);
						add_inventory.clearAndTypeSlowly(Globals.Inventory.Brand, "input#txtSearch");
						add_inventory.return_td_invoke_element(Globals.Inventory.Brand).click();
						
					}
				    if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch)) {
				    	GenericWrappers.sleepInSeconds(1);
				        terPage.get_checkBox_element(icp.Batch_String).click();
				        GenericWrappers.sleepInSeconds(1);
				        //webDriver.findElement(By.cssSelector("//*[@id=\"ContentPlaceHolder1_chkVendorItems\"]")).click();

			        }
					if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemName)) {
						terPage.terminal_waitClearEnterText_css(icp.ItemName_String, Globals.Inventory.ItemName);
						

					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemCode)) {
						terPage.terminal_waitClearEnterText_css(icp.ItemCode_String, Globals.Inventory.ItemCode);
						webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtItemCodeAdd")).sendKeys(Keys.RETURN);
						

					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.InvQty)) {
						terPage.terminal_waitClearEnterText_css(icp.InvQty_String, Globals.Inventory.InvQty);
						webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtWQty")).sendKeys(Keys.RETURN    );
					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.RecvQty)) {
						terPage.terminal_waitClearEnterText_css(icp.RecvQty_String, Globals.Inventory.RecvQty);
						webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtLQty")).sendKeys(Keys.RETURN);
						webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtItemCodeAdd")).sendKeys(Keys.RETURN);
					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.foc)) {
						webDriver
						.findElement(By.cssSelector("input#ContentPlaceHolder1_txtFoc"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver
						.findElement(By.cssSelector("input#ContentPlaceHolder1_txtFoc"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver
						.findElement(By.cssSelector("input#ContentPlaceHolder1_txtFoc"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver
						.findElement(By.cssSelector("input#ContentPlaceHolder1_txtFoc"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver
				.findElement(By.cssSelector("input#ContentPlaceHolder1_txtFoc"))
				.sendKeys(Keys.SHIFT, Keys.LEFT);
				GenericWrappers.sleepInSeconds(1);
				webDriver
						.findElement(By.cssSelector("input#ContentPlaceHolder1_txtFoc"))
						.sendKeys(Keys.DELETE);
						terPage.terminal_waitClearEnterText_css(icp.foc_String, Globals.Inventory.foc);
						webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtFoc")).sendKeys(Keys.RETURN);
					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.MRP)) {
						webDriver
						.findElement(By.cssSelector("input#ContentPlaceHolder1_txtMrp"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver
						.findElement(By.cssSelector("input#ContentPlaceHolder1_txtMrp"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver
						.findElement(By.cssSelector("input#ContentPlaceHolder1_txtMrp"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver
						.findElement(By.cssSelector("input#ContentPlaceHolder1_txtMrp"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				GenericWrappers.sleepInSeconds(1);
				webDriver
						.findElement(By.cssSelector("input#ContentPlaceHolder1_txtMrp"))
						.sendKeys(Keys.DELETE);
						terPage.terminal_waitClearEnterText_css(icp.MRP_String, Globals.Inventory.MRP);
						webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtMrp")).sendKeys(Keys.RETURN);
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
				GenericWrappers.sleepInSeconds(1);
				webDriver
						.findElement(By.cssSelector("input#ContentPlaceHolder1_txtBasicCost"))
						.sendKeys(Keys.DELETE);
						terPage.terminal_waitClearEnterText_css(icp.BasicCost_String, Globals.Inventory.BasicCost);
						webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtBasicCost")).sendKeys(Keys.RETURN);
					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.SDP)) {
						webDriver
						.findElement(By.cssSelector("input#ContentPlaceHolder1_txtSDPrc"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver
						.findElement(By.cssSelector("input#ContentPlaceHolder1_txtSDPrc"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver
						.findElement(By.cssSelector("input#ContentPlaceHolder1_txtSDPrc"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver
						.findElement(By.cssSelector("input#ContentPlaceHolder1_txtSDPrc"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				GenericWrappers.sleepInSeconds(1);
				webDriver
						.findElement(By.cssSelector("input#ContentPlaceHolder1_txtSDPrc"))
						.sendKeys(Keys.DELETE);
						terPage.terminal_waitClearEnterText_css(icp.SDP_String, Globals.Inventory.SDP);
						webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtSDPrc")).sendKeys(Keys.RETURN);
					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.AddDed)) {
						 {
							
							 terPage.terminal_waitClearEnterText_css(icp.AddDed_String, Globals.Inventory.AddDed);
						}
						 webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtAddCess")).sendKeys(Keys.RETURN);
					}
					pass.ExcelFourData("PO","Modules", "Actual", "Expected", "Status",
							0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
					pass.Excelcreate("PO", "Filters", "Pass", 1, 0, 1, 3);
		}
		catch(Exception e) {
			// screen shot
			scr.Screenshots();
			System.out.println("Screen shot taken");
			// Xl sheet write
			pass.ExcelFourData("PO","Filters", "Actual", "Expected", "Status",
					0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
			pass.Excelcreate("PO", "Filters", "FAIL", 1, 0, 1, 3);
			 
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

		@Then("I close connection  DB for PO")
		public void I_close_connection_to_DB() throws SQLException {

			mysqlConnect.disconnect();
			System.out.println(" closed succesfully");

			// mysqlConnect.disconnect();

		}

		MssqlConnect mysqlConnect;
		Statement st;
		@Then("I establish connection  DB for PO")
		public void I_establish_connection_to_DB() throws SQLException {

			mysqlConnect = new MssqlConnect();
			st = mysqlConnect.connect().createStatement();
			System.out.println(" Connected succesfully");

		}
		@Given("I read the values from PO table {string} in DB")
		public void i_want_to_launch_the(String tablename ) throws SQLException, IOException {
			
			
			ResultSet rs = st.executeQuery("select * from "+tablename+" where Vendorcode='V00246'");
			
			System.out.println(rs);
			//ResultSet rs = st.executeQuery("");

			while (rs.next()) {

				switch (tablename) {
				
				case "tblpoheader":
						
					String Sellingprice="";
					try {
						Sellingprice = rs.getString("VendorCode");
						System.out.println(Sellingprice);
						Assert.assertEquals(Globals.Inventory.Vendor.trim(), Sellingprice.trim());
						pass.Excelcreate("PO", "tblpoheader", "", 3, 0, 3, 1);
						pass.ExcelFourData("PO", "VendorCode", Globals.Inventory.Vendor, Sellingprice, "Pass",
								5, 0, 5, 1, 5, 2, 5, 3);
					} catch (AssertionError e) {
						pass.Excelcreate("PO", "tblpoheader", "", 3, 0, 3, 1);
						pass.ExcelFourData("PO", "VendorCode", Globals.Inventory.Vendor, Sellingprice, "Fail",
								5, 0, 5, 1, 5, 2, 5, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblpoheader column VendorCode");
					}
					
					
					break;
					
				case "tblpoDetail":
					String Promotionfromdate="";
					try
					{
						Promotionfromdate = rs.getString("ItemCode");
						System.out.println(Promotionfromdate);
						Assert.assertEquals(Globals.Inventory.ItemCode.trim(), Promotionfromdate.trim());
						pass.Excelcreate("PO", "tblpoDetail", "", 7, 0, 7, 1);
						pass.ExcelFourData("PO", "RangeFrom", Globals.Inventory.ItemCode, Promotionfromdate, "Pass",
								8, 0, 8, 1, 8, 2, 8, 3);
					} catch (AssertionError e) {
						pass.Excelcreate("PO", "tblpoDetail", "", 7, 0, 7, 1);
						pass.ExcelFourData("PO", "RangeFrom", Globals.Inventory.ItemCode, Promotionfromdate, "Fail",
								8, 0, 8, 1, 8, 2, 8, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblpoDetail column ItemCode");
					}
					String Promotiontodate="";
					try
					{
						Promotiontodate = rs.getString("VendorCode");
						System.out.println(Promotiontodate);
						Assert.assertEquals(Globals.Inventory.Vendor.trim(), Promotiontodate.trim());
						pass.ExcelFourData("PO", "VendorCode", Globals.Inventory.Vendor, Promotiontodate, "Pass",
								9, 0, 9, 1, 9, 2, 9, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("PO", "VendorCode", Globals.Inventory.Vendor, Promotiontodate, "Fail",
								9, 0, 9, 1, 9, 2, 9, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblpoDetail column VendorCode");
					}
					String Promotionfromtime="";
					try
					{
						Promotionfromtime = rs.getString("LQty");
						System.out.println(Promotionfromtime);
						Assert.assertEquals(Globals.Inventory.InvQty.trim(), Promotionfromtime.trim());
						pass.ExcelFourData("PO", "InvQty", Globals.Inventory.InvQty, Promotionfromtime, "Pass",
								10, 0, 10, 1, 10, 2,10, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("PO", "InvQty", Globals.Inventory.InvQty, Promotionfromtime, "Fail",
								10, 0, 10, 1, 10, 2,10, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblpoDetail column InvQty");
					}
					String WQty="";
					try
					{
						WQty = rs.getString("WQty");
						System.out.println(WQty);
						Assert.assertEquals(Globals.Inventory.InvQty.trim(), WQty.trim());
						pass.ExcelFourData("PO", "InvQty", Globals.Inventory.InvQty, WQty, "Pass",
								11, 0, 11, 1, 11, 2,11, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("PO", "InvQty", Globals.Inventory.InvQty, WQty, "Fail",
								11, 0, 11, 1, 11, 2,11, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblpoDetail column WQty");
					}
					String Foc="";
					try
					{
						Foc = rs.getString("FocQty");
						System.out.println(Foc);
						Assert.assertEquals(Globals.Inventory.foc.trim(), Foc.trim());
						pass.ExcelFourData("PO", "foc", Globals.Inventory.foc, Foc, "Pass",
								11, 0, 11, 1, 11, 2,11, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("PO", "foc", Globals.Inventory.foc, Foc, "Fail",
								11, 0, 11, 1, 11, 2,11, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblpoDetail column foc");
					}
					String UnitCost="";
					try
					{
						UnitCost = rs.getString("UnitCost");
						System.out.println(UnitCost);
						Assert.assertEquals(Globals.Inventory.foc.trim(), UnitCost.trim());
						pass.ExcelFourData("PO", "foc", Globals.Inventory.foc, UnitCost, "Pass",
								11, 0, 11, 1, 11, 2,11, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("PO", "foc", Globals.Inventory.foc, UnitCost, "Fail",
								11, 0, 11, 1, 11, 2,11, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblpoDetail column foc");
					}
					String SellingPrice="";
					try
					{
						SellingPrice = rs.getString("Disc1Per");
						System.out.println(SellingPrice);
						Assert.assertEquals(Globals.Inventory.SDP.trim(), SellingPrice.trim());
						pass.ExcelFourData("PO", "foc", Globals.Inventory.SDP, SellingPrice, "Pass",
								12, 0, 12, 1, 12, 2,12, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("PO", "foc", Globals.Inventory.SDP, SellingPrice, "Fail",
								12, 0, 12, 1, 12, 2,12, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblpoDetail column SDP");
					}
					
				default:
					break;
				}
			
				}
			
		}
		}



