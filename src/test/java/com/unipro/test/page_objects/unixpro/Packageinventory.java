package com.unipro.test.page_objects.unixpro;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.gk.test.MssqlConnect;
import com.unipro.ExcelWrite;
import com.unipro.test.framework.Globals;
import com.unipro.test.framework.PageObject;
import com.unipro.test.framework.helpers.screenshot_helper.Screenshot;
import com.unipro.test.framework.helpers.utils.GenericWrappers;
import com.unipro.test.framework.helpers.utils.ReadTestData;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.bytebuddy.agent.builder.AgentBuilder.CircularityLock.Global;

public class Packageinventory extends PageObject {
	AddInventoryFormPage Inventorychange;
	PackageinventoryField icp;
	CommonPages cp;
	TerminalPage terpage;
	ExcelWrite pass;
	Screenshot scr;

	public Packageinventory(PackageinventoryField icp, CommonPages cp) {

		this.icp = icp;
		this.cp = cp;
		scr = new Screenshot();
		pass = new ExcelWrite();
		terpage = new TerminalPage();
		Inventorychange = new AddInventoryFormPage();

	}

	@Then("I load the Packageinventory sheet data to map")
	public void I_load_the_Inventorychange_sheet_data_to_map() {
		Globals.Inventory.PackageinventorySheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME48);

	}

	@Then("I load the rowise Packageinventory data for {string} rowname")
	public void i_load_the_rowise_Inventorychange_data_for_rowname(String row_name) {
		Globals.Inventory.PackageinventoryrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.PackageinventorySheetData, row_name);
		System.out.println(Globals.Inventory.PackageinventoryrowwiseData);
	}

	@Then("I update value to the Packageinventory page global Variables")
	public void i_update_value_to_the_ConsolidatedPO_page_global_Variables() {
		Globals.Inventory.PackageInventory = Globals.Inventory.PackageinventoryrowwiseData.get("PackageInventory");
		Globals.Inventory.Qty = Globals.Inventory.PackageinventoryrowwiseData.get("Qty");
		Globals.Inventory.ItemCode = Globals.Inventory.PackageinventoryrowwiseData.get("ItemCode");
		Globals.Inventory.Batchrowno = Globals.Inventory.PackageinventoryrowwiseData.get("Batchrowno");

	}

	@Then("I fill new Packageinventory data page using excel data")
	public void i_fill_new_Inventorychange_data_page_using_excel_data() throws Exception {
		try {

			if (GenericWrappers.isNotEmpty(Globals.Inventory.PackageInventory)) {
				webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_ddlPackageInv_chzn\"]")).click();
				GenericWrappers.sleepInSeconds(1);
				// terPage.terminal_waitClearEnterText_css(icp.Vendor_String,
				// Globals.Inventory.Vendor);
				WebElement itemCodeValue = webDriver.findElement(
						By.cssSelector("#ContentPlaceHolder1_ddlPackageInv_chzn > div > div > input[type=text]"));
				String css_location_dropDownValue = "#ContentPlaceHolder1_ddlPackageInv_chzn > div > div > input[type=text]";
				By ddlocator = By.cssSelector(css_location_dropDownValue);
				waitForExpectedElement(ddlocator);
				js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.PackageInventory);
				GenericWrappers.sleepInSeconds(1);
				itemCodeValue.sendKeys(Keys.SPACE);
				itemCodeValue.sendKeys(Keys.SPACE);
				itemCodeValue.sendKeys(Keys.ARROW_DOWN);
				GenericWrappers.sleepInSeconds(1);
				itemCodeValue.sendKeys(Keys.ENTER);

			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemCode)) {
				terpage.terminal_waitClearEnterText_css(icp.ItemCode_String, Globals.Inventory.ItemCode);
				Inventorychange.clearAndTypeSlowly(Globals.Inventory.ItemCode, "input#txtSearch");
				Inventorychange.return_td_invoke_element(Globals.Inventory.ItemCode).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batchrowno)) {
				//terpage.terminal_waitClearEnterText_css(icp.Batchrowno_String);
				Inventorychange.return_td_invoke_element(Globals.Inventory.Batchrowno).click();
				

			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Qty)) {
				terpage.terminal_waitClearEnterText_css(icp.Qty_String, Globals.Inventory.Qty);
				

			}

			pass.ExcelFourData("InventoryParameter", "Modules", "Actual", "Expected", "Status", 0, 0, 0, 1, 0, 2, 0, 3);
			pass.Excelcreate("InventoryParameter", "MASTERS", "PASS", 1, 0, 1, 3);
		} catch (Exception e) {
			// screen shot
			scr.Screenshots();
			System.out.println("Screen shot taken");
			// Xl sheet write
			pass.ExcelFourData("InventoryParameter", "Modules", "Actual", "Expected", "Status", 0, 0, 0, 1, 0, 2, 0, 3);
			pass.Excelcreate("InventoryParameter", "MASTERS", "FAIL", 1, 0, 1, 3);

		}
	}

	@Then("I close connection  DB for Packageinventory")
	public void I_close_connection_to_DB() throws SQLException {

		mysqlConnect.disconnect();
		System.out.println(" closed succesfully");

		// mysqlConnect.disconnect();

	}

	MssqlConnect mysqlConnect;
	Statement st;

	@Then("I establish connection  DB for Packageinventory")
	public void I_establish_connection_to_DB() throws SQLException {

		mysqlConnect = new MssqlConnect();
		st = mysqlConnect.connect().createStatement();
		System.out.println(" Connected succesfully");

	}

	@Given("I read the values from Packageinventory table {string} in DB")
	public void i_want_to_launch_the(String tablename) throws SQLException, IOException {

		ResultSet rs = st.executeQuery("select * from " + tablename + " where Packageinvcode='000016'");

		System.out.println(rs);
		// ResultSet rs = st.executeQuery("");

		while (rs.next()) {

			switch (tablename) {

			case "tblPackageHeader":
				String Parentcode = "";
				try {
					Parentcode = rs.getString("Packageinvcode");
					System.out.println(Parentcode);
					Assert.assertEquals(Globals.Inventory.PackageInventory.trim(), Parentcode.trim());
					pass.Excelcreate("PackageInventory", "tblPackageHeader", "", 3, 0, 3, 1);
					pass.ExcelFourData("PackageInventory", "PackageInventory", Globals.Inventory.PackageInventory, Parentcode, "Pass", 4, 0, 4,
							1, 4, 2, 4, 3);
				} catch (AssertionError e) {
					pass.Excelcreate("PackageInventory", "tblPackageHeader", "", 3, 0, 3, 1);
					pass.ExcelFourData("PackageInventory", "PackageInventory", Globals.Inventory.PackageInventory, Parentcode, "Fail", 4, 0, 4,
							1, 4, 2, 4, 3);

				} catch (Exception e) {
					System.out.println("null error tblPackageHeader column Packageinvcode");
				}
				String Itemcode = "";
				try {
					Itemcode = rs.getString("TotalQty");
					System.out.println(Itemcode);
					Assert.assertEquals(Globals.Inventory.Qty.trim(), Itemcode.trim());
					pass.ExcelFourData("PackageInventory", "Inventorycode", Globals.Inventory.Qty, Itemcode,
							"Pass", 5, 0, 5, 1, 5, 2, 5, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("PackageInventory", "Inventorycode", Globals.Inventory.Qty, Itemcode,
							"Fail", 5, 0, 5, 1, 5, 2, 5, 3);

				} catch (Exception e) {
					System.out.println("null error tblPackageHeader column TotalQty");
				}
				break;

			case "tblPackageDetail":
				String Parentcode1 = "";
				try {
					Parentcode1 = rs.getString("Packageinvcode");
					System.out.println(Parentcode1);
					Assert.assertEquals(Globals.Inventory.PackageInventory.trim(), Parentcode1.trim());
					pass.Excelcreate("PackageInventory", "tblPackageDetail", "", 7, 0, 7, 1);
					pass.ExcelFourData("PackageInventory", "Qty", Globals.Inventory.PackageInventory, Parentcode1, "Pass", 8, 0, 8,
							1, 8, 2, 8, 3);
				} catch (AssertionError e) {
					pass.Excelcreate("PackageInventory", "tblPackageDetail", "", 7, 0, 7, 1);
					pass.ExcelFourData("PackageInventory", "Qty", Globals.Inventory.PackageInventory, Parentcode1, "Fail", 8, 0, 8,
							1, 8, 2, 8, 3);

				} catch (Exception e) {
					System.out.println("null error tblPackageDetail column Packageinvcode");
				}
				String Itemcode1 = "";
				try {
					Itemcode1 = rs.getString("Inventorycode");
					System.out.println(Itemcode1);
					Assert.assertEquals(Globals.Inventory.ItemCode.trim(), Itemcode1.trim());
					pass.ExcelFourData("PackageInventory", "Inventorycode", Globals.Inventory.ItemCode, Itemcode1,
							"Pass", 9, 0, 9, 1, 9, 2, 9, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("PackageInventory", "Inventorycode", Globals.Inventory.ItemCode, Itemcode1,
							"Fail", 9, 0, 9, 1, 9, 2, 9, 3);

				} catch (Exception e) {
					System.out.println("null error tblparentchild column Inventorycode");
				}
				String Qty = "";
				try {
					Qty = rs.getString("Qty");
					System.out.println(Qty);
					Assert.assertEquals(Globals.Inventory.Qty.trim(), Qty.trim());
					pass.ExcelFourData("PackageInventory", "Qty", Globals.Inventory.Qty, Qty,
							"Pass", 10, 0, 10, 1, 10, 2, 10, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("PackageInventory", "Qty", Globals.Inventory.Qty, Qty,
							"Fail", 10, 0, 10, 1, 10, 2, 10, 3);

				} catch (Exception e) {
					System.out.println("null error tblparentchild column Qty");
				}
				break;
			default:
				break;
			}

		}

	}

}
