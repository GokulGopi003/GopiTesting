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

	public class InventoryParameter  extends PageObject{
		AddInventoryFormPage Inventorychange;
		InventoryParameterField icp;
		CommonPages cp;
		TerminalPage terpage;
		ExcelWrite pass;
		Screenshot scr;
		public InventoryParameter(InventoryParameterField icp, CommonPages cp) {

			this.icp = icp;
			this.cp = cp;
			scr = new Screenshot();
			pass = new ExcelWrite();
			terpage = new TerminalPage();
			Inventorychange = new AddInventoryFormPage();

		}
		

		@Then("I load the InventoryParameter sheet data to map")
		public void I_load_the_Inventorychange_sheet_data_to_map() {
			Globals.Inventory.InventoryParameterSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME47);

		}

		@Then("I load the rowise InventoryParameter data for {string} rowname")
		public void i_load_the_rowise_Inventorychange_data_for_rowname(String row_name) {
			Globals.Inventory.InventoryParameterrowwiseData = ReadTestData
					.getRowFilteredValueFromTable(Globals.Inventory.InventoryParameterSheetData, row_name);
			System.out.println(Globals.Inventory.InventoryParameterrowwiseData);
		}

		@Then("I update value to the InventoryParameter page global Variables")
		public void i_update_value_to_the_ConsolidatedPO_page_global_Variables() {
			Globals.Inventory.ItemCode = Globals.Inventory.InventoryParameterrowwiseData.get("ItemCode");
			Globals.Inventory.Qty = Globals.Inventory.InventoryParameterrowwiseData.get("Qty");
			Globals.Inventory.WQty = Globals.Inventory.InventoryParameterrowwiseData.get("WQty");
			
			
			
		}

		@Then("I fill new InventoryParameter data page using excel data")
		public void i_fill_new_Inventorychange_data_page_using_excel_data() throws Exception {
			try {
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemCode)) {
				terpage.terminal_waitClearEnterText_css(icp.ItemCode_String, Globals.Inventory.ItemCode);
				webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtdescription\"]")).sendKeys(Keys.RETURN);
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Qty)) {
				terpage.terminal_waitClearEnterText_css(icp.Qty_String, Globals.Inventory.Qty);
				webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtBWQuantity\"]")).sendKeys(Keys.RETURN);
				
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.WQty)) {
				terpage.terminal_waitClearEnterText_css(icp.WQty_String, Globals.Inventory.WQty);
				webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtWastageQty\"]")).sendKeys(Keys.RETURN);
				
				
			}
			
		   pass.ExcelFourData("InventoryParameter","Modules", "Actual", "Expected", "Status",
					0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
			pass.Excelcreate("InventoryParameter", "MASTERS", "PASS", 1, 0, 1, 3);
		} catch (Exception e) {
			// screen shot
			scr.Screenshots();
			System.out.println("Screen shot taken");
			// Xl sheet write
			pass.ExcelFourData("InventoryParameter","Modules", "Actual", "Expected", "Status",
					0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
			pass.Excelcreate("InventoryParameter", "MASTERS", "FAIL", 1, 0, 1, 3);

		}
		}
		@Then("I close connection  DB for InventoryParameter")
		public void I_close_connection_to_DB() throws SQLException {

			mysqlConnect.disconnect();
			System.out.println(" closed succesfully");

			// mysqlConnect.disconnect();

		}

		MssqlConnect mysqlConnect;
		Statement st;
		@Then("I establish connection  DB for InventoryParameter")
		public void I_establish_connection_to_DB() throws SQLException {

			mysqlConnect = new MssqlConnect();
			st = mysqlConnect.connect().createStatement();
			System.out.println(" Connected succesfully");

		}
		@Given("I read the values from InventoryParameter table {string} in DB")
		public void i_want_to_launch_the(String tablename ) throws SQLException, IOException {
			
			
			ResultSet rs = st.executeQuery("select * from "+tablename+" where PInventoryCode='007717'");
			
			System.out.println(rs);
			//ResultSet rs = st.executeQuery("");

			while (rs.next()) {

				switch (tablename) {
				
				case "tblinventorybulkstock":
					String CategoryCode = "";
					try {
						CategoryCode = rs.getString("AWqty");
						System.out.println(CategoryCode);
						Assert.assertEquals(Globals.Inventory.WQty.trim(), CategoryCode.trim());
						pass.Excelcreate("InventoryParameter", "tblinventorybulkstock", "", 3, 0, 3, 1);
						pass.ExcelFourData("InventoryParameter", "BWqty", Globals.Inventory.WQty, CategoryCode, "Pass",
								4, 0, 4, 1, 4, 2, 4, 3);
					} catch (AssertionError e) {
						pass.Excelcreate("InventoryParameter", "tblinventorybulkstock", "", 3, 0, 3, 1);
						pass.ExcelFourData("InventoryParameter", "BWqty", Globals.Inventory.WQty, CategoryCode, "Fail",
								4, 0, 4, 1, 4, 2, 4, 3);

					}
					catch(Exception e) {
						System.out.println("null error tblparentchild column CategoryCode");
						}
					String Itemcode = "";
					try {
						Itemcode = rs.getString("Inventorycode");
						System.out.println(Itemcode);
						Assert.assertEquals(Globals.Inventory.ItemCode.trim(), Itemcode.trim());
						pass.Excelcreate("InventoryParameter", "tblinventorybulkstock", "", 3, 0, 3, 1);
						pass.ExcelFourData("InventoryParameter", "Inventorycode", Globals.Inventory.ItemCode, Itemcode, "Pass",
								4, 0, 4, 1, 4, 2, 4, 3);
					} catch (AssertionError e) {
						pass.Excelcreate("InventoryParameter", "tblparentchild", "", 3, 0, 3, 1);
						pass.ExcelFourData("InventoryParameter", "Inventorycode", Globals.Inventory.ItemCode, Itemcode, "Fail",
								4, 0, 4, 1, 4, 2, 4, 3);

					}
					catch(Exception e) {
						System.out.println("null error tblparentchild column CategoryCode");
						}
				break;
				
				
			case "tblinventorybulk":
				String Parentcode = "";
				try {
					CategoryCode = rs.getString("TakenQty");
					System.out.println(Parentcode);
					Assert.assertEquals(Globals.Inventory.Qty.trim(), Parentcode.trim());
					pass.Excelcreate("InventoryParameter", "tblDistributionHeaderNew", "", 3, 0, 3, 1);
					pass.ExcelFourData("InventoryParameter", "Qty", Globals.Inventory.Qty, Parentcode, "Pass",
							4, 0, 4, 1, 4, 2, 4, 3);
				} catch (AssertionError e) {
					pass.Excelcreate("InventoryParameter", "tblDistributionHeaderNew", "", 3, 0, 3, 1);
					pass.ExcelFourData("InventoryParameter", "Qty", Globals.Inventory.Qty, Parentcode, "Fail",
							4, 0, 4, 1, 4, 2, 4, 3);

				}
				catch(Exception e) {
					System.out.println("null error tblparentchild column CategoryCode");
					}
				String Itemcode1 = "";
				try {
					Itemcode = rs.getString("Inventorycode");
					System.out.println(Itemcode1);
					Assert.assertEquals(Globals.Inventory.ItemCode.trim(), Itemcode1.trim());
					pass.Excelcreate("InventoryParameter", "tblinventorybulkstock", "", 3, 0, 3, 1);
					pass.ExcelFourData("InventoryParameter", "Inventorycode", Globals.Inventory.ItemCode, Itemcode1, "Pass",
							4, 0, 4, 1, 4, 2, 4, 3);
				} catch (AssertionError e) {
					pass.Excelcreate("InventoryParameter", "tblparentchild", "", 3, 0, 3, 1);
					pass.ExcelFourData("InventoryParameter", "Inventorycode", Globals.Inventory.ItemCode, Itemcode1, "Fail",
							4, 0, 4, 1, 4, 2, 4, 3);

				}
				catch(Exception e) {
					System.out.println("null error tblparentchild column Inventorycode");
					}
				break;
			default:
				break;
				}
			
		}}

}



