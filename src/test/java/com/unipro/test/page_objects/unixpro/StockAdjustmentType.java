package com.unipro.test.page_objects.unixpro;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
    import org.openqa.selenium.Keys;
    import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.gk.test.MssqlConnect;
import com.unipro.ExcelWrite;

	import org.openqa.selenium.By;
    import org.openqa.selenium.Keys;
    import org.openqa.selenium.WebElement;
    import com.unipro.test.framework.Globals;
    import com.unipro.test.framework.PageObject;
    import com.unipro.test.framework.helpers.utils.GenericWrappers;
	import com.unipro.test.framework.helpers.utils.ReadTestData;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

	public class StockAdjustmentType  extends PageObject {
		AddInventoryFormPage Category;
		StockAdjustmentTypefield icp;
		TerminalPage terPage;
        ExcelWrite pass;
		public  StockAdjustmentType(StockAdjustmentTypefield  icp) {
			this.icp = icp;
			terPage = new TerminalPage();
			Category = new AddInventoryFormPage();
			pass=new ExcelWrite();
		}
		
		@Then("I load the StockAdjustmentType sheet data to map")
		public void i_load_the_Subcategory_sheet_data_to_map() {
			Globals.Inventory.StockAdjustmentTypeSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME29);
		}
		@Then("I load the rowise StockAdjustmentType data for {string} rowname")
		public void i_load_the_rowise_Category_data_for_rowname(String row_name) {

			Globals.Inventory.StockAdjustmentTyperowwiseData = ReadTestData
					.getRowFilteredValueFromTable(Globals.Inventory.StockAdjustmentTypeSheetData, row_name);

			System.out.println(Globals.Inventory.StockAdjustmentTypeSheetData);

		}

		@Then("I update value to the StockAdjustmentType page global Variables")
		public void i_update_value_to_the_Subcategory_page_global_Variables() {
			Globals.Inventory.AdjtypeCode = Globals.Inventory.StockAdjustmentTyperowwiseData.get("AdjtypeCode");
			Globals.Inventory.AdjtypeName = Globals.Inventory.StockAdjustmentTyperowwiseData.get("AdjtypeName");
			Globals.Inventory.Batch = Globals.Inventory.StockAdjustmentTyperowwiseData.get("Batch");
			Globals.Inventory.Batch1 = Globals.Inventory.StockAdjustmentTyperowwiseData.get("Batch1");
			Globals.Inventory.Description = Globals.Inventory.StockAdjustmentTyperowwiseData.get("Description");
	
		}

		@Then("I fill new StockAdjustmentType data page using excel data")
		public void i_fill_new_Subcategory_data_page_using_excel_data() {
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.AdjtypeName)) {
				   terPage.terminal_waitClearEnterText_css(icp.AdjtypeName_String, Globals.Inventory.AdjtypeName);
			
          }
			if (GenericWrappers.isNotEmpty(Globals.Inventory.AdjtypeCode)) {
				   terPage.terminal_waitClearEnterText_css(icp.AdjtypeCode_String, Globals.Inventory.AdjtypeCode);
			
          }
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch)) {
		        terPage.get_checkBox_element(icp.Batch_String).click();

	        }
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch1)) {
		        terPage.get_checkBox_element(icp.Batch1_String).click();

	        }
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Description)) {
				   terPage.terminal_waitClearEnterText_css(icp.Description_String, Globals.Inventory.Description);
			
          }
			
	}
		@Then("I close connection to StockAdjustmentType")
		public void I_close_connection_to_StockAdjustmentType() throws SQLException {

			mysqlConnect.disconnect();
			System.out.println(" closed succesfully");

		}

		MssqlConnect mysqlConnect;
		Statement st;

		@Then("I establish connection to StockAdjustmentType")
		public void I_establish_connection_to_StockAdjustmentType() throws SQLException {

			mysqlConnect = new MssqlConnect();
			st = mysqlConnect.connect().createStatement();
			System.out.println(" Connected succesfully");

		}

		@Given("I read the values from table {string} in StockAdjustmentType")
		public void i_want_to_launch_the(String tablename) throws SQLException, IOException {

			ResultSet rs = st.executeQuery("select * from " + tablename + " where StkAdjTypeCode='7'");

			System.out.println(rs);

			while (rs.next()) {

				switch (tablename) {
				case "tblStockAdjType":
					String AdjtypeCode = "";
					try {
						AdjtypeCode = rs.getString("StkAdjTypeCode");
						System.out.println(AdjtypeCode);
						Assert.assertEquals(Globals.Inventory.AdjtypeCode.trim(), AdjtypeCode.trim());
						pass.Excelcreate("stockadjustmenttype", "tblStockAdjType", "", 0, 0, 0, 0);
						pass.ExcelFourData("stockadjustmenttype", "AdjtypeCode", Globals.Inventory.AdjtypeCode, AdjtypeCode, "Pass", 1, 0, 1, 1,
								1, 2, 1, 3);
					} catch (AssertionError e) {
						pass.Excelcreate("stockadjustmenttype", "tblStockAdjType", "", 0, 0, 0, 0);
						pass.ExcelFourData("stockadjustmenttype", "AdjtypeCode", Globals.Inventory.AdjtypeCode, AdjtypeCode, "Fail", 1, 0, 1, 1,
								1, 2, 1, 3);

					}
					
					String AdjtypeName = "";
					try {
						AdjtypeName = rs.getString("StkAdjTypeName");
						System.out.println(AdjtypeName);
						Assert.assertEquals(Globals.Inventory.AdjtypeName.trim(), AdjtypeName.trim());

						pass.ExcelFourData("stockadjustmenttype", "AdjtypeName", Globals.Inventory.AdjtypeName, AdjtypeName, "Pass", 2, 0, 2, 1,
								2, 2, 2, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("stockadjustmenttype", "AdjtypeName", Globals.Inventory.AdjtypeName, AdjtypeName, "Fail", 2, 0, 2, 1,
								2, 2, 2, 3);

					}
					break;

		
	
}

			}
		}
	}


	






