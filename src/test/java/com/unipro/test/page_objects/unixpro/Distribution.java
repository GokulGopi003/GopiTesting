package com.unipro.test.page_objects.unixpro;


	import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
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

	public class Distribution extends PageObject{
		AddInventoryFormPage Inventorychange;
		DistributionField icp;
		CommonPages cp;
		TerminalPage terpage;
		ExcelWrite pass;
		Screenshot scr;
		public Distribution(DistributionField icp, CommonPages cp) {

			this.icp = icp;
			this.cp = cp;
			scr = new Screenshot();
			pass = new ExcelWrite();
			terpage = new TerminalPage();
			Inventorychange = new AddInventoryFormPage();

		}
		

		@Then("I load the Distribution sheet data to map")
		public void I_load_the_Inventorychange_sheet_data_to_map() {
			Globals.Inventory.DistributionSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME46);

		}

		@Then("I load the rowise Distribution data for {string} rowname")
		public void i_load_the_rowise_Inventorychange_data_for_rowname(String row_name) {
			Globals.Inventory.DistributionrowwiseData = ReadTestData
					.getRowFilteredValueFromTable(Globals.Inventory.DistributionSheetData, row_name);
			System.out.println(Globals.Inventory.DistributionrowwiseData);
		}

		@Then("I update value to the Distribution page global Variables")
		public void i_update_value_to_the_ConsolidatedPO_page_global_Variables() {
			Globals.Inventory.ItemCode = Globals.Inventory.DistributionrowwiseData.get("ItemCode");
			Globals.Inventory.Qty = Globals.Inventory.DistributionrowwiseData.get("Qty");
			Globals.Inventory.Parentcode = Globals.Inventory.DistributionrowwiseData.get("Parentcode");
			
			
			
		}

		@Then("I fill new Distribution data page using excel data")
		public void i_fill_new_Inventorychange_data_page_using_excel_data() throws Exception {
			try {
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemCode)) {
				terpage.terminal_waitClearEnterText_css(icp.ItemCode_String, Globals.Inventory.ItemCode);
				webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtCdescription\"]")).sendKeys(Keys.RETURN);
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Qty)) {
				terpage.terminal_waitClearEnterText_css(icp.Qty_String, Globals.Inventory.Qty);
				webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtPCSQty\"]")).sendKeys(Keys.RETURN);
				webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_lnkAdd\"]")).sendKeys(Keys.RETURN);
				
			}
			
		   pass.ExcelFourData("InventoryParentChildSetting","Modules", "Actual", "Expected", "Status",
					0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
			pass.Excelcreate("InventoryParentChildSetting", "MASTERS", "PASS", 1, 0, 1, 3);
		} catch (Exception e) {
			// screen shot
			scr.Screenshots();
			System.out.println("Screen shot taken");
			// Xl sheet write
			pass.ExcelFourData("InventoryParentChildSetting","Modules", "Actual", "Expected", "Status",
					0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
			pass.Excelcreate("InventoryParentChildSetting", "MASTERS", "FAIL", 1, 0, 1, 3);

		}
		}
		@Then("I close connection  DB for Distribution")
		public void I_close_connection_to_DB() throws SQLException {

			mysqlConnect.disconnect();
			System.out.println(" closed succesfully");

			// mysqlConnect.disconnect();

		}

		MssqlConnect mysqlConnect;
		Statement st;
		@Then("I establish connection  DB for Distribution")
		public void I_establish_connection_to_DB() throws SQLException {

			mysqlConnect = new MssqlConnect();
			st = mysqlConnect.connect().createStatement();
			System.out.println(" Connected succesfully");

		}
		@Given("I read the values from Distribution table {string} in DB")
		public void i_want_to_launch_the(String tablename ) throws SQLException, IOException {
			
			
			ResultSet rs = st.executeQuery("select * from "+tablename+" where PInventoryCode='007717'");
			
			System.out.println(rs);
			//ResultSet rs = st.executeQuery("");

			while (rs.next()) {

				switch (tablename) {
				
				case "tblparentchild":
					String CategoryCode = "";
					try {
						CategoryCode = rs.getString("PInventoryCode");
						System.out.println(CategoryCode);
						Assert.assertEquals(Globals.Inventory.Bulk.trim(), CategoryCode.trim());
						pass.Excelcreate("InventoryParentChildSetting", "tblparentchild", "", 3, 0, 3, 1);
						pass.ExcelFourData("InventoryParentChildSetting", "CInventoryCode", Globals.Inventory.Bulk, CategoryCode, "Pass",
								4, 0, 4, 1, 4, 2, 4, 3);
					} catch (AssertionError e) {
						pass.Excelcreate("InventoryParentChildSetting", "tblparentchild", "", 3, 0, 3, 1);
						pass.ExcelFourData("InventoryParentChildSetting", "CInventoryCode", Globals.Inventory.Bulk, CategoryCode, "Fail",
								4, 0, 4, 1, 4, 2, 4, 3);

					}
					catch(Exception e) {
						System.out.println("null error tblparentchild column CategoryCode");
						}

				String GST="";
				try {
				GST = rs.getString("CInventoryCode");
				System.out.println(GST);
				Assert.assertEquals(Globals.Inventory.Child.trim(), GST.trim());
				pass.ExcelFourData("InventoryParentChildSetting", "PInventoryCode", Globals.Inventory.Child, GST, "Pass",
						5, 0, 5, 1, 5, 2, 5, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("InventoryParentChildSetting", "PInventoryCode", Globals.Inventory.Child, GST, "Fail",
						5, 0, 5, 1, 5, 2, 5, 3);
			}
				catch(Exception e) {
					System.out.println("null error tblparentchild column Vendor");
					}
				break;
				
				default:
					break;
				
			case "tblDistributionHeaderNew":
				String Parentcode = "";
				try {
					CategoryCode = rs.getString("ParentItemCode");
					System.out.println(Parentcode);
					Assert.assertEquals(Globals.Inventory.Bulk.trim(), Parentcode.trim());
					pass.Excelcreate("InventoryParentChildSetting", "tblDistributionHeaderNew", "", 3, 0, 3, 1);
					pass.ExcelFourData("InventoryParentChildSetting", "ParentItemCode", Globals.Inventory.Bulk, Parentcode, "Pass",
							4, 0, 4, 1, 4, 2, 4, 3);
				} catch (AssertionError e) {
					pass.Excelcreate("InventoryParentChildSetting", "tblDistributionHeaderNew", "", 3, 0, 3, 1);
					pass.ExcelFourData("InventoryParentChildSetting", "ParentItemCode", Globals.Inventory.Bulk, Parentcode, "Fail",
							4, 0, 4, 1, 4, 2, 4, 3);

				}
				catch(Exception e) {
					System.out.println("null error tblparentchild column CategoryCode");
					}
				 
				}
			
		}}

}

