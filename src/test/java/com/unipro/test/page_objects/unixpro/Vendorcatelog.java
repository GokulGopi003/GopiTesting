package com.unipro.test.page_objects.unixpro;


	import java.io.FileNotFoundException;
	import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.NoSuchElementException;

	import org.openqa.selenium.By;

	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.remote.server.handler.SendKeys;
	import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.gk.test.MssqlConnect;
import com.unipro.ExcelWrite;
import com.unipro.test.framework.Globals;
	import com.unipro.test.framework.PageObject;
import com.unipro.test.framework.helpers.screenshot_helper.Screenshot;
import com.unipro.test.framework.helpers.utils.GenericWrappers;
	import com.unipro.test.framework.helpers.utils.ReadTestData;
	import com.unipro.test.framework.helpers.utils.ReadXLSXFile;
	import com.unipro.test.page_objects.unixpro.AddInventoryFormPage;
	import com.unipro.test.page_objects.unixpro.CommonPages;
	import com.unipro.test.page_objects.unixpro.CreateGRN;
	import com.unipro.test.page_objects.unixpro.TerminalPage;
	import com.unipro.test.step_definitions.unixpo.Unipro_Common_StepDefinitions;

	import bsh.Console;
	import cucumber.api.java.en.Then;

	public class Vendorcatelog extends PageObject {

		AddInventoryFormPage add_inventory;
		VendorcatelogField icp;
		CommonPages cp;
         ExcelWrite pass;
		TerminalPage terPage;
		Screenshot scr;
		public Vendorcatelog(VendorcatelogField icp, CommonPages cp) {
			this.icp = icp;
			terPage = new TerminalPage();
            pass=new ExcelWrite();
			this.cp = cp;
			add_inventory = new AddInventoryFormPage();
			scr = new Screenshot();
		}

		@Then("I load the Vendorcatelog sheet data to map")
		public void i_load_the_GA_sheet_data_to_map() {

			// Globals.Inventory.inventorySheetData1 =
			// Globals.excelSheetData.get(Globals.Inventory.SHEETNAME_DATA);

			Globals.Inventory.VendorcatelogSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME35);

		}

		@Then("I load the rowise Vendorcatelog data for {string} rowname")
		public void i_load_the_rowise_GA_data_for_rowname(String row_name) {

			Globals.Inventory.VendorcatelogrowwiseData = ReadTestData
					.getRowFilteredValueFromTable(Globals.Inventory.VendorcatelogSheetData, row_name);

			System.out.println(Globals.Inventory.VendorcatelogrowwiseData);

		}

		@Then("I update value to the Vendorcatelog page global Variables")
		public void i_update_value_to_the_GA_page_global_Variables() {
			Globals.Inventory.Vendor = Globals.Inventory.VendorcatelogrowwiseData.get("Vendor");
			Globals.Inventory.Department = Globals.Inventory.VendorcatelogrowwiseData.get("Department");
			Globals.Inventory.Category = Globals.Inventory.VendorcatelogrowwiseData.get("Category");
			Globals.Inventory.Brand = Globals.Inventory.VendorcatelogrowwiseData.get("Brand");
			Globals.Inventory.SubCategory = Globals.Inventory.VendorcatelogrowwiseData.get("SubCategory");
			Globals.Inventory.Merchandise = Globals.Inventory.VendorcatelogrowwiseData.get("Merchandise");
			Globals.Inventory.Manufacture = Globals.Inventory.VendorcatelogrowwiseData.get("Manufacture");
			Globals.Inventory.Floorcode = Globals.Inventory.VendorcatelogrowwiseData.get("Floorcode");
			Globals.Inventory.Section = Globals.Inventory.VendorcatelogrowwiseData.get("Section");
			Globals.Inventory.Bin = Globals.Inventory.VendorcatelogrowwiseData.get("Bin");
			Globals.Inventory.ShelfCode = Globals.Inventory.VendorcatelogrowwiseData.get("ShelfCode");
			Globals.Inventory.WarehouseCode = Globals.Inventory.VendorcatelogrowwiseData.get("WarehouseCode");
			Globals.Inventory.Barcode = Globals.Inventory.VendorcatelogrowwiseData.get("Barcode");
			Globals.Inventory.Batchrowno = Globals.Inventory.VendorcatelogrowwiseData.get("Batchrowno");
			Globals.Inventory.ItemCode = Globals.Inventory.VendorcatelogrowwiseData.get("ItemCode");
			Globals.Inventory.ItemName = Globals.Inventory.VendorcatelogrowwiseData.get("ItemName");
			Globals.Inventory.MRP = Globals.Inventory.VendorcatelogrowwiseData.get("MRP");
			Globals.Inventory.BasicCost = Globals.Inventory.VendorcatelogrowwiseData.get("BasicCost");
			Globals.Inventory.Discount = Globals.Inventory.VendorcatelogrowwiseData.get("Discount");
			Globals.Inventory.DiscountPer = Globals.Inventory.VendorcatelogrowwiseData.get("DiscountPer");
			Globals.Inventory.DiscountPer3 = Globals.Inventory.VendorcatelogrowwiseData.get("DiscountPer3");
            Globals.Inventory.NetSellingPrice= Globals.Inventory.VendorcatelogrowwiseData.get("NetSellingPrice");

		}

		@Then("I fill new Vendorcatelog data page using excel data")
		public void i_fill_new_GA_data_page_using_excel_data() throws Exception {
			try {
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Vendor)) {
				terPage.terminal_waitClearEnterText_css(icp.Vendor_String, Globals.Inventory.Vendor);
				add_inventory.clearAndTypeSlowly(Globals.Inventory.Vendor, "input#txtSearch");
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
			if (GenericWrappers.isNotEmpty(Globals.Inventory.SubCategory)) {
				terPage.terminal_waitClearEnterText_css(icp.SubCategory_String, Globals.Inventory.SubCategory);
				add_inventory.clearAndTypeSlowly(Globals.Inventory.SubCategory, "input#txtSearch");
				add_inventory.return_td_invoke_element(Globals.Inventory.SubCategory).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Merchandise)) {
				terPage.terminal_waitClearEnterText_css(icp.Merchandise_String, Globals.Inventory.Merchandise);
				add_inventory.clearAndTypeSlowly(Globals.Inventory.Merchandise, "input#txtSearch");
				add_inventory.return_td_invoke_element(Globals.Inventory.Merchandise).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Manufacture)) {
				terPage.terminal_waitClearEnterText_css(icp.Manufacture_String, Globals.Inventory.Manufacture);
				add_inventory.clearAndTypeSlowly(Globals.Inventory.Manufacture, "input#txtSearch");
				add_inventory.return_td_invoke_element(Globals.Inventory.Manufacture).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Floorcode)) {
				terPage.terminal_waitClearEnterText_css(icp.Floorcode_String, Globals.Inventory.Floorcode);
				add_inventory.clearAndTypeSlowly(Globals.Inventory.Floorcode, "input#txtSearch");
				add_inventory.return_td_invoke_element(Globals.Inventory.Floorcode).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Section)) {
				terPage.terminal_waitClearEnterText_css(icp.Section_String, Globals.Inventory.Section);
				add_inventory.clearAndTypeSlowly(Globals.Inventory.Section, "input#txtSearch");
				add_inventory.return_td_invoke_element(Globals.Inventory.Section).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Bin)) {
				terPage.terminal_waitClearEnterText_css(icp.Bin_String, Globals.Inventory.Bin);
				add_inventory.clearAndTypeSlowly(Globals.Inventory.Bin, "input#txtSearch");
				add_inventory.return_td_invoke_element(Globals.Inventory.Bin).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.ShelfCode)) {
				terPage.terminal_waitClearEnterText_css(icp.ShelfCode_String, Globals.Inventory.ShelfCode);
				add_inventory.clearAndTypeSlowly(Globals.Inventory.ShelfCode, "input#txtSearch");
				add_inventory.return_td_invoke_element(Globals.Inventory.ShelfCode).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.WarehouseCode)) {
				terPage.terminal_waitClearEnterText_css(icp.WarehouseCode_String, Globals.Inventory.WarehouseCode);
				add_inventory.clearAndTypeSlowly(Globals.Inventory.WarehouseCode, "input#txtSearch");
				add_inventory.return_td_invoke_element(Globals.Inventory.WarehouseCode).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Barcode)) {
				terPage.terminal_waitClearEnterText_css(icp.Barcode_String, Globals.Inventory.Barcode);
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batchrowno)) {
				terPage.terminal_waitClearEnterText_css(icp.Batchrowno_String, Globals.Inventory.Batchrowno);

			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemCode)) {
				terPage.terminal_waitClearEnterText_css(icp.ItemCode_String, Globals.Inventory.ItemCode);
		
			}

			if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemName)) {
				terPage.terminal_waitClearEnterText_css(icp.ItemName_String, Globals.Inventory.ItemName);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_searchFilterUserControl_txtItemName")).sendKeys(Keys.RETURN);

			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.MRP)) {
				terPage.terminal_waitClearEnterText_css(icp.MRP_String, Globals.Inventory.MRP);
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.BasicCost)) {
				terPage.terminal_waitClearEnterText_css(icp.BasicCost_String, Globals.Inventory.BasicCost);

			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Discount)) {
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_gvVendorCat_txtDiscountBasicPerNew_0")).sendKeys(Keys.CONTROL, "a");
				GenericWrappers.sleepInSeconds(2);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_gvVendorCat_txtDiscountBasicPerNew_0")).sendKeys(Keys.DELETE);
				terPage.terminal_waitClearEnterText_css(icp.Discount_String, Globals.Inventory.Discount);
		
			}

			if (GenericWrappers.isNotEmpty(Globals.Inventory.DiscountPer)) {
				terPage.terminal_waitClearEnterText_css(icp.Discount1_String, Globals.Inventory.DiscountPer);
				//webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_searchFilterUserControl_txtItemName")).sendKeys(Keys.RETURN);

			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.DiscountPer3)) {
				terPage.terminal_waitClearEnterText_css(icp.Discount2_String, Globals.Inventory.DiscountPer3);
		
			}

			if (GenericWrappers.isNotEmpty(Globals.Inventory.NetSellingPrice)) {
				terPage.terminal_waitClearEnterText_css(icp.NetSellingPrice_String, Globals.Inventory.NetSellingPrice);
				//webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_searchFilterUserControl_txtItemName")).sendKeys(Keys.RETURN);

			}
			pass.ExcelFourData("VendorCatelog", "Filters", "Actual", "Expected", "Status", 0, 0, 0, 1, 0, 2, 0, 3);
			pass.Excelcreate("VendorCatelog", "Filters", "FAIL", 1, 0, 1, 3);

			}
			catch (Exception e) {
				// screen shot
							scr.Screenshots();
							System.out.println("Screen shot taken");
				// Xl sheet write
							pass.ExcelFourData("VendorCatelog", "Filters", "Actual", "Expected", "Status", 0, 0, 0, 1, 0, 2, 0, 3);
							pass.Excelcreate("VendorCatelog", "Filters", "FAIL", 1, 0, 1, 3);

						}

			

		}
		@Then("I close connection  DB for Vendorcatelog")
		public void i_close_connection_DB_for_Vendorcatelog() {
			mysqlConnect.disconnect();
			System.out.println(" closed succesfully");

			// mysqlConnect.disconnect();

		}

		MssqlConnect mysqlConnect;
		Statement st;

		

		@Then("I establish connection  DB for Vendorcatelog")
		public void i_establish_connection_DB_for_Vendorcatelog() throws SQLException 
		{
			mysqlConnect = new MssqlConnect();
			st = mysqlConnect.connect().createStatement();
			System.out.println(" Connected succesfully");

		}
		@Then("I read the values from Vendorcatelog table {string} in DB")
		public void i_read_the_values_from_Vendorcatelog_table_in_DB(String tablename) throws IOException, SQLException {
			ResultSet rs = st.executeQuery("select * from " + tablename + " where InventoryCode='854173'");

			System.out.println(rs);
			// ResultSet rs = st.executeQuery("");

			while (rs.next()) {

				switch (tablename) {

				case "tblvendorcatlog":

					String Vendor = "";
					try {
						Vendor = rs.getString("VendorCode");
						System.out.println(Vendor);
						Assert.assertEquals(Globals.Inventory.Vendor.trim(), Vendor.trim());
						pass.Excelcreate("VendorCatelog", "tblvendorcatlog", "", 3, 0, 3, 1);
						pass.ExcelFourData("VendorCatelog", "VendorCode", Globals.Inventory.Vendor, Vendor, "Pass", 5, 0, 5, 1,
								5, 2, 5, 3);
					} catch (AssertionError e) {
						pass.Excelcreate("VendorCatelog", "tblvendorcatlog", "", 3, 0, 3, 1);
						pass.ExcelFourData("VendorCatelog", "VendorCode", Globals.Inventory.Vendor, Vendor, "Fail", 5, 0, 5, 1,
								5, 2, 5, 3);
					} catch (Exception e) {
						System.out.println("null error tblPaymentHeader column PaymentDate");
					}
					String ItemCode = "";
					try {
						ItemCode = rs.getString("InventoryCode");
						System.out.println(ItemCode);
						Assert.assertEquals(Globals.Inventory.ItemCode.trim(), ItemCode.trim());
						pass.ExcelFourData("VendorCatelog", "ItemCode", Globals.Inventory.ItemCode, ItemCode, "Pass", 6, 0, 6, 1, 6, 2, 6,
								3);
					} catch (AssertionError e) {
						pass.ExcelFourData("VendorCatelog", "ItemCode", Globals.Inventory.ItemCode, ItemCode, "Fail", 6, 0, 6, 1, 6, 2, 6,
								3);
					} catch (Exception e) {
						System.out.println("null error tblPaymentHeader column VoucherRef");
					}
					String MRP = "";
					try {
						MRP = rs.getString("MRP");
						System.out.println(MRP);
						Assert.assertEquals(Globals.Inventory.MRP.trim(), MRP.trim());
						pass.ExcelFourData("VendorCatelog", "MRP", Globals.Inventory.MRP, MRP, "Pass", 7, 0, 7, 1, 7, 2,
								7, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("VendorCatelog", "MRP", Globals.Inventory.MRP, MRP, "Fail", 7, 0, 7, 1, 7, 2,
								7, 3);
					} catch (Exception e) {
						System.out.println("null error tblPaymentHeader column RefDate");
					}
					String Basiccost = "";
					try {
						Basiccost = rs.getString("BasicCost");
						System.out.println(Basiccost);
						Assert.assertEquals(Globals.Inventory.BasicCost.trim(), Basiccost.trim());
						pass.ExcelFourData("VendorCatelog", "Basiccost", Globals.Inventory.BasicCost, Basiccost, "Pass", 8, 0, 8, 1, 8,
								2, 8, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("VendorCatelog", "Basiccost", Globals.Inventory.BasicCost, Basiccost, "Fail", 8, 0, 8, 1, 8,
								2, 8, 3);
					} catch (Exception e) {
						System.out.println("null error tblPaymentHeader column Vendor");
					}
					String Discount = "";
					try {
						Discount = rs.getString("DiscountBasicPer");
						System.out.println(Discount);
						Assert.assertEquals(Globals.Inventory.Discount.trim(), Discount.trim());
						pass.ExcelFourData("VendorCatelog", "Discount", Globals.Inventory.Discount, Discount, "Pass", 9, 0, 9, 1, 9,
								2, 9, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("VendorCatelog", "Discount", Globals.Inventory.Discount, Discount, "Fail", 9, 0, 9, 1, 9,
								2, 9, 3);
					} catch (Exception e) {
						System.out.println("null error tblPaymentHeader column TotalAmount");
					}
					String DiscountBasicPer = "";
					try {
						DiscountBasicPer = rs.getString("DiscountBasicPer2");
						System.out.println(DiscountBasicPer);
						Assert.assertEquals(Globals.Inventory.DiscountPer.trim(), DiscountBasicPer.trim());
						pass.ExcelFourData("VendorCatelog", "DiscountBasicPer", Globals.Inventory.DiscountPer, DiscountBasicPer, "Pass", 10, 0, 10, 1, 10,
								2, 10, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("VendorCatelog", "DiscountBasicPer", Globals.Inventory.DiscountPer, DiscountBasicPer, "Fail", 10, 0, 10, 1, 10,
								2, 10, 3);
					} catch (Exception e) {
						System.out.println("null error tblPaymentHeader column Paymode");
					}

					//break;

				//case "tblPaymentDetail":
					String DiscountBasicPer3= "";
					try {
						DiscountBasicPer3 = rs.getString("DiscountBasicPer3");
						System.out.println(DiscountBasicPer3);
						Assert.assertEquals(Globals.Inventory.DiscountPer3.trim(), DiscountBasicPer3.trim());
						//pass.Excelcreate("Payments", "tblPaymentDetail", "", 10, 0, 10, 1);
						pass.ExcelFourData("VendorCatelog", "DiscountBasicPer3", Globals.Inventory.DiscountPer3, DiscountBasicPer3, "Pass", 11, 0, 11, 1, 11, 2,
								11, 3);
					} catch (AssertionError e) {
						//pass.Excelcreate("Payments", "tblPaymentDetail", "", 10, 0, 10, 1);
						pass.ExcelFourData("VendorCatelog", "DiscountBasicPer3", Globals.Inventory.DiscountPer3, DiscountBasicPer3, "Fail", 11, 0, 11, 1, 11, 2,
								11, 3);
					} catch (Exception e) {
						System.out.println("null error tblPaymentDetail column Createdate");
					}
					String NetSellingPrice = "";
					try {
						NetSellingPrice = rs.getString("NetSellingPrice");
						System.out.println(NetSellingPrice);
						Assert.assertEquals(Globals.Inventory.NetSellingPrice.trim(), NetSellingPrice.trim());
						pass.ExcelFourData("VendorCatelog", "NetSellingPrice", Globals.Inventory.NetSellingPrice, NetSellingPrice, "Pass", 12, 0, 12, 1,
								12, 2, 12, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("VendorCatelog", "NetSellingPrice", Globals.Inventory.NetSellingPrice, NetSellingPrice, "Fail", 12, 0, 12, 1,
								12, 2, 12, 3);
					} catch (Exception e) {
						System.out.println("null error tblPaymentDetail column Referanceno");
					}
					break;
				   case "tblInventoryPricing":
					   String ItemCode1 = "";
						try {
							ItemCode1 = rs.getString("InventoryCode");
							System.out.println(ItemCode1);
							Assert.assertEquals(Globals.Inventory.ItemCode.trim(), ItemCode1.trim());
							pass.Excelcreate("VendorCatelog", "tblInventoryPricing", "", 15, 0, 15, 1);
							pass.ExcelFourData("VendorCatelog", "ItemCode", Globals.Inventory.ItemCode, ItemCode1, "Pass", 16, 0, 16, 1, 16, 2, 16,
									3);
						} catch (AssertionError e) {
							pass.Excelcreate("VendorCatelog", "tblInventoryPricing", "", 15, 0, 15, 1);
							pass.ExcelFourData("VendorCatelog", "ItemCode", Globals.Inventory.ItemCode, ItemCode1, "Fail", 16, 0, 16, 1, 16, 2, 16,
									3);
						} catch (Exception e) {
							System.out.println("null error tblPaymentHeader column VoucherRef");
						}
						String MRP1 = "";
						try {
							MRP1 = rs.getString("MRP");
							System.out.println(MRP1);
							Assert.assertEquals(Globals.Inventory.MRP.trim(), MRP1.trim());
							pass.ExcelFourData("VendorCatelog", "MRP", Globals.Inventory.MRP, MRP1, "Pass", 17, 0, 17, 1, 17, 2,
									17, 3);
						} catch (AssertionError e) {
							pass.ExcelFourData("VendorCatelog", "MRP", Globals.Inventory.MRP, MRP1, "Fail", 17, 0, 17, 1, 17, 2,
									17, 3);
						} catch (Exception e) {
							System.out.println("null error tblPaymentHeader column RefDate");
						}
						String Basiccost1 = "";
						try {
							Basiccost1 = rs.getString("BasicCost");
							System.out.println(Basiccost1);
							Assert.assertEquals(Globals.Inventory.BasicCost.trim(), Basiccost1.trim());
							pass.ExcelFourData("VendorCatelog", "Basiccost", Globals.Inventory.BasicCost, Basiccost1, "Pass", 18, 0, 18, 1, 18,
									2, 18, 3);
						} catch (AssertionError e) {
							pass.ExcelFourData("VendorCatelog", "Basiccost", Globals.Inventory.BasicCost, Basiccost1, "Fail", 18, 0, 18, 1, 18,
									2, 18, 3);
						} catch (Exception e) {
							System.out.println("null error tblPaymentHeader column Vendor");
						}
						String Discount1 = "";
						try {
							Discount1 = rs.getString("DiscountBasicPer");
							System.out.println(Discount1);
							Assert.assertEquals(Globals.Inventory.Discount.trim(), Discount1.trim());
							pass.ExcelFourData("VendorCatelog", "Discount", Globals.Inventory.Discount, Discount1, "Pass", 19, 0, 19, 1, 19,
									2, 19, 3);
						} catch (AssertionError e) {
							pass.ExcelFourData("VendorCatelog", "Discount", Globals.Inventory.Discount, Discount1, "Fail", 19, 0, 19, 1, 19,
									2, 19, 3);
						} catch (Exception e) {
							System.out.println("null error tblPaymentHeader column TotalAmount");
						}
						String DiscountBasicPer2 = "";
						try {
							DiscountBasicPer2 = rs.getString("DiscountBasicPer2");
							System.out.println(DiscountBasicPer2);
							Assert.assertEquals(Globals.Inventory.DiscountPer.trim(), DiscountBasicPer2.trim());
							pass.ExcelFourData("VendorCatelog", "DiscountBasicPer", Globals.Inventory.DiscountPer, DiscountBasicPer2, "Pass", 20, 0, 20, 1, 20,
									2, 20, 3);
						} catch (AssertionError e) {
							pass.ExcelFourData("VendorCatelog", "DiscountBasicPer", Globals.Inventory.DiscountPer, DiscountBasicPer2, "Fail", 20, 0, 20, 1, 20,
									2, 20, 3);
						} catch (Exception e) {
							System.out.println("null error tblPaymentHeader column Paymode");
						}

						//break;

					//case "tblPaymentDetail":
						String DiscountBasicPer3a= "";
						try {
							DiscountBasicPer3a = rs.getString("DiscountBasicPer3");
							System.out.println(DiscountBasicPer3a);
							Assert.assertEquals(Globals.Inventory.DiscountPer3.trim(), DiscountBasicPer3a.trim());
							//pass.Excelcreate("Payments", "tblPaymentDetail", "", 10, 0, 10, 1);
							pass.ExcelFourData("VendorCatelog", "DiscountBasicPer3", Globals.Inventory.DiscountPer3, DiscountBasicPer3a, "Pass", 21, 0, 21, 1, 21, 2,
									21, 3);
						} catch (AssertionError e) {
							//pass.Excelcreate("Payments", "tblPaymentDetail", "", 10, 0, 10, 1);
							pass.ExcelFourData("VendorCatelog", "DiscountBasicPer3", Globals.Inventory.DiscountPer3, DiscountBasicPer3a, "Fail", 21, 0, 21, 1, 21, 2,
									21, 3);
						} catch (Exception e) {
							System.out.println("null error tblPaymentDetail column Createdate");
						}
						String NetSellingPrice1 = "";
						try {
							NetSellingPrice1 = rs.getString("NetSellingPrice");
							System.out.println(NetSellingPrice1);
							Assert.assertEquals(Globals.Inventory.NetSellingPrice.trim(), NetSellingPrice1.trim());
							pass.ExcelFourData("VendorCatelog", "NetSellingPrice", Globals.Inventory.NetSellingPrice, NetSellingPrice1, "Pass", 22, 0, 22, 1,
									22, 2, 22, 3);
						} catch (AssertionError e) {
							pass.ExcelFourData("VendorCatelog", "NetSellingPrice", Globals.Inventory.NetSellingPrice, NetSellingPrice1, "Fail", 22, 0, 22, 1,
									22, 2, 22, 3);
						} catch (Exception e) {
							System.out.println("null error tblPaymentDetail column Referanceno");
						}
		}

			}
		}}


