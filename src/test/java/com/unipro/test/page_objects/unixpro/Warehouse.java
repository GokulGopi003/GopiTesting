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
import com.unipro.test.framework.Globals;
import com.unipro.test.framework.PageObject;
import com.unipro.test.framework.helpers.utils.GenericWrappers;
	import com.unipro.test.framework.helpers.utils.ReadTestData;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

	public class Warehouse extends PageObject{
		AddInventoryFormPage Category;
		Warehousefield icp;
        ExcelWrite pass;
		TerminalPage terPage;

		public  Warehouse(Warehousefield  icp) {
			this.icp = icp;
			terPage = new TerminalPage();
            pass=new ExcelWrite();
			Category = new AddInventoryFormPage();
		}
		
		@Then("I load the Warehouse sheet data to map")
		public void i_load_the_Subcategory_sheet_data_to_map() {
			Globals.Inventory.WarehouseSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME19);
		}
		@Then("I load the rowise Warehouse data for {string} rowname")
		public void i_load_the_rowise_Category_data_for_rowname(String row_name) {

			Globals.Inventory.WarehouserowwiseData = ReadTestData
					.getRowFilteredValueFromTable(Globals.Inventory.WarehouseSheetData, row_name);

			System.out.println(Globals.Inventory.WarehouseSheetData);

		}

		@Then("I update value to the Warehouse page global Variables")
		public void i_update_value_to_the_Subcategory_page_global_Variables() {
			Globals.Inventory.WarehouseCode = Globals.Inventory.WarehouserowwiseData.get("WarehouseCode");
			Globals.Inventory.WarehouseName = Globals.Inventory.WarehouserowwiseData.get("WarehouseName");
			Globals.Inventory.Address = Globals.Inventory.WarehouserowwiseData.get("Address");
			Globals.Inventory.Address1 = Globals.Inventory.WarehouserowwiseData.get("Address1");
			Globals.Inventory.Address2 = Globals.Inventory.WarehouserowwiseData.get("Address2");
			Globals.Inventory.Pincode = Globals.Inventory.WarehouserowwiseData.get("Pincode");
			Globals.Inventory.Phone = Globals.Inventory.WarehouserowwiseData.get("Phone");
			Globals.Inventory.Fax = Globals.Inventory.WarehouserowwiseData.get("Fax");
			Globals.Inventory.Netcost = Globals.Inventory.WarehouserowwiseData.get("Netcost");
			Globals.Inventory.Type = Globals.Inventory.WarehouserowwiseData.get("Type");
			Globals.Inventory.NetcostPer = Globals.Inventory.WarehouserowwiseData.get("NetcostPer");

			
		}

		@Then("I fill new Warehouse data page using excel data")
		public void i_fill_new_Subcategory_data_page_using_excel_data() {
			

			if (GenericWrappers.isNotEmpty(Globals.Inventory.WarehouseCode)) {
				terPage.terminal_waitClearEnterText_css(icp.WarehouseCode_String, Globals.Inventory.WarehouseCode);
			
			}
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.WarehouseName)) {
				terPage.terminal_waitClearEnterText_css(icp.WarehouseName_String, Globals.Inventory.WarehouseName);
			
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Address)) {
				terPage.terminal_waitClearEnterText_css(icp.Address_String, Globals.Inventory.Address);
			
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Address1)) {
				terPage.terminal_waitClearEnterText_css(icp.Address1_String, Globals.Inventory.Address1);
			
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Address2)) {
				terPage.terminal_waitClearEnterText_css(icp.Address2_String, Globals.Inventory.Address2);
			
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Pincode)) {
				terPage.terminal_waitClearEnterText_css(icp.Pincode_String, Globals.Inventory.Pincode);
			
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Phone)) {
				terPage.terminal_waitClearEnterText_css(icp.Phone_String, Globals.Inventory.Phone);
			
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Fax)) {
				terPage.terminal_waitClearEnterText_css(icp.Fax_String, Globals.Inventory.Fax);
			
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.NetcostPer)) {
				terPage.terminal_waitClearEnterText_css(icp.Netcost_String, Globals.Inventory.NetcostPer);
			
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Netcost)) {
				GenericWrappers.sleepInSeconds(1);
				webDriver.findElement(By.cssSelector("div#ContentPlaceHolder1_ddlNetCost_chzn")).click();
				GenericWrappers.sleepInSeconds(1);

				WebElement LocationValue = webDriver
						.findElement(By.cssSelector("#ContentPlaceHolder1_ddlNetCost_chzn div > div > input[type=text]"));
				String css_location_dropDownValue = "#ContentPlaceHolder1_ddlNetCost_chzn div > div > input[type=text]";
				By ddlocator = By.cssSelector(css_location_dropDownValue);
				waitForExpectedElement(ddlocator);
				js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.Netcost);
				GenericWrappers.sleepInSeconds(1);
				LocationValue.sendKeys(Keys.SPACE);
				LocationValue.sendKeys(Keys.SPACE);
				LocationValue.sendKeys(Keys.ARROW_DOWN);
				GenericWrappers.sleepInSeconds(1);
				LocationValue.sendKeys(Keys.ENTER);

			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Type)) {
				GenericWrappers.sleepInSeconds(1);
				webDriver.findElement(By.cssSelector("div#ContentPlaceHolder1_ddlType_chzn")).click();
				GenericWrappers.sleepInSeconds(1);

				WebElement LocationValue = webDriver
						.findElement(By.cssSelector("#ContentPlaceHolder1_ddlType_chzn div > div > input[type=text]"));
				String css_location_dropDownValue = "#ContentPlaceHolder1_ddlType_chzn div > div > input[type=text]";
				By ddlocator = By.cssSelector(css_location_dropDownValue);
				waitForExpectedElement(ddlocator);
				js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.Type);
				GenericWrappers.sleepInSeconds(1);
				LocationValue.sendKeys(Keys.SPACE);
				LocationValue.sendKeys(Keys.SPACE);
				LocationValue.sendKeys(Keys.ARROW_DOWN);
				GenericWrappers.sleepInSeconds(1);
				LocationValue.sendKeys(Keys.ENTER);

			}
			
	}
		@Then("I close connection to Warehouse")
		public void I_close_connection_to_Warehouse() throws SQLException {

			mysqlConnect.disconnect();
			System.out.println(" closed succesfully");

		}

		MssqlConnect mysqlConnect;
		Statement st;

		@Then("I establish connection to Warehouse")
		public void I_establish_connection_to_Warehouse() throws SQLException {

			mysqlConnect = new MssqlConnect();
			st = mysqlConnect.connect().createStatement();
			System.out.println(" Connected succesfully");

		}

		@Given("I read the values from table {string} in Warehouse")
		public void i_want_to_launch_the(String tablename) throws SQLException, IOException {

			ResultSet rs = st.executeQuery("select * from " + tablename + " where Phone='1'");

			System.out.println(rs);

			while (rs.next()) {

				switch (tablename) {
				case "tblWareHouse":
					System.out.println("1");
					String WarehouseCode = "";
					try {
						System.out.println("2");
						WarehouseCode = rs.getString("WarehouseCode");
						System.out.println("3");
						System.out.println(WarehouseCode);
						Assert.assertEquals(Globals.Inventory.WarehouseCode.trim(), WarehouseCode.trim());
						pass.Excelcreate("warehouse", "tblWareHouse", "", 0, 1, 0, 2);
						pass.ExcelFourData("warehouse", "WarehouseCode", Globals.Inventory.WarehouseCode, WarehouseCode, "Pass", 1, 0, 1, 1,
								1, 2, 1, 3);
					} catch (AssertionError e) {
						pass.Excelcreate("warehouse", "tblWareHouse", "", 0, 1, 0, 2);
						pass.ExcelFourData("warehouse", "WarehouseCode", Globals.Inventory.WarehouseCode, WarehouseCode, "Fail", 1, 0, 1, 1,
								1, 2, 1, 3);

					}
					
					
					String Address1 = "";
					try {
						Address1 = rs.getString("Address1");
						System.out.println(Address1);
						Assert.assertEquals(Globals.Inventory.Address1.trim(), Address1.trim());

						pass.ExcelFourData("warehouse", "Address1", Globals.Inventory.Address1, Address1, "Pass", 3,
								0, 3, 1, 3, 2, 3, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("warehouse", "Address1", Globals.Inventory.Address1, Address1,"Fail",3,0,3, 1, 3, 2, 3, 3);

					}
					String Address2 = "";
					try {
						Address2 = rs.getString("Address2");
						System.out.println(Address2);
						Assert.assertEquals(Globals.Inventory.Address2.trim(), Address2.trim());

						pass.ExcelFourData("warehouse", "Address2", Globals.Inventory.Address2, Address2, "Pass", 4,
								0, 4, 1, 4, 2, 4, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("warehouse", "Address2", Globals.Inventory.Address2, Address2,"Fail",4,0,4, 1, 4, 2, 4, 3);

					}
					String Phone = "";
					try {
						Phone = rs.getString("Phone");
						System.out.println(Phone);
						Assert.assertEquals(Globals.Inventory.Phone.trim(), Phone.trim());

						pass.ExcelFourData("warehouse", "Phone", Globals.Inventory.Phone, Phone, "Pass", 5,
								0, 5, 1, 5, 2, 5, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("warehouse", "Phone", Globals.Inventory.Phone, Phone,"Fail",5,0,5, 1, 5, 2, 5, 3);

					}
					String Pincode = "";
					try {
						Pincode = rs.getString("Pincode");
						System.out.println(Pincode);
						Assert.assertEquals(Globals.Inventory.Pincode.trim(), Pincode.trim());

						pass.ExcelFourData("warehouse", "Pincode", Globals.Inventory.Pincode, Pincode, "Pass", 6,
								0, 6, 1, 6, 2, 6, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("warehouse", "Pincode", Globals.Inventory.Pincode, Pincode,"Fail",6,0,6, 1, 6, 2, 6, 3);

					}
					String Fax = "";
					try {
						Fax = rs.getString("Fax");
						System.out.println(Fax);
						Assert.assertEquals(Globals.Inventory.Fax.trim(), Fax.trim());

						pass.ExcelFourData("warehouse", "Fax", Globals.Inventory.Fax, Fax, "Pass", 7,
								0, 7, 1, 7, 2, 7, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("warehouse", "Fax", Globals.Inventory.Fax, Fax,"Fail",7,0,7, 1, 7, 2, 7, 3);

					}
					String WarehouseName = "";
					try {
						WarehouseName = rs.getString("Description");
						System.out.println(WarehouseName);
						Assert.assertEquals(Globals.Inventory.WarehouseName.trim(), WarehouseName.trim());

						pass.ExcelFourData("warehouse", "WarehouseName", Globals.Inventory.WarehouseName, Fax, "Pass", 8,
								0, 8, 1, 8, 2, 8, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("warehouse", "WarehouseName", Globals.Inventory.WarehouseName, WarehouseName,"Fail",8,0,8, 1, 8, 2, 8, 3);

					}
					
					String NetcostPer = "";
					try {
						NetcostPer = rs.getString("TransferPerc");
						System.out.println(NetcostPer);
						Assert.assertEquals(Globals.Inventory.NetcostPer.trim(), NetcostPer.trim());

						pass.ExcelFourData("warehouse", "NetcostPer", Globals.Inventory.NetcostPer, NetcostPer, "Pass", 9,
								0, 9, 1, 9, 2, 9, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("warehouse", "NetcostPer", Globals.Inventory.NetcostPer, NetcostPer,"Fail",9,0,9, 1, 9, 2, 9, 3);

					}
					String Netcost = "";
					try {
						Netcost = rs.getString("CostMode");
						System.out.println(Netcost);
						Assert.assertEquals(Globals.Inventory.Netcost.trim(), Netcost.trim());

						pass.ExcelFourData("warehouse", "Netcost", Globals.Inventory.Netcost, Netcost, "Pass", 10,
								0, 10, 1, 10, 2, 10, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("warehouse", "Netcost", Globals.Inventory.Netcost, Netcost,"Fail",10,0,10, 1, 10, 2, 10, 3);

					}
					String Type = "";
					try {
						Type = rs.getString("Type");
						System.out.println(Type);
						Assert.assertEquals(Globals.Inventory.Type.trim(), Type.trim());

						pass.ExcelFourData("warehouse", "Type", Globals.Inventory.Type, Type, "Pass", 11,
								0, 11, 1, 11, 2, 11, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("warehouse", "Type", Globals.Inventory.Type, Type,"Fail",11,0,11, 1, 11, 2, 11, 3);

					}
}break;
			}
		}
	}

	


