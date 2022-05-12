
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
	import com.unipro.test.framework.helpers.screenshot_helper.Screenshot;
	import com.unipro.test.framework.helpers.utils.GenericWrappers;
	import com.unipro.test.framework.helpers.utils.ReadTestData;

	import cucumber.api.java.en.Then;

	public class LocationNew extends PageObject {
		LocationNewtypefield icp;
		TerminalPage terPage;
		AddInventoryFormPage Category;
		ExcelWrite pass;
		Screenshot scr;
		

		public LocationNew(LocationNewtypefield icp) {
			this.icp = icp;
			terPage = new TerminalPage();
			Category = new AddInventoryFormPage();
			pass=new ExcelWrite();
			scr = new Screenshot();
		}

		@Then("I load the LocationNew sheet data to map")
		public void i_load_the_LocationNew_sheet_data_to_map() 
		{
			Globals.Inventory.LocationNewSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME74);
		}

		@Then("I load the LocationNew rowise  data for {string} rowname")
		public void i_load_the_LocationNew_rowise_data_for_rowname(String row_name) 
		{

			Globals.Inventory.LocationNewrowwiseData = ReadTestData
					.getRowFilteredValueFromTable(Globals.Inventory.LocationNewSheetData, row_name);

			System.out.println(Globals.Inventory.LocationNewrowwiseData);
		}

		@Then("I update value to the LocationNew page global Variables")
		public void i_update_value_to_the_LocationNew_page_global_Variables() 
		{
			Globals.Inventory.LocationCode = Globals.Inventory.LocationNewrowwiseData.get("Locationcode");
			Globals.Inventory.Location = Globals.Inventory.LocationNewrowwiseData.get("Name");
			Globals.Inventory.Address = Globals.Inventory.LocationNewrowwiseData.get("address");
			Globals.Inventory.Address1 = Globals.Inventory.LocationNewrowwiseData.get("address1");
			Globals.Inventory.Address2 = Globals.Inventory.LocationNewrowwiseData.get("address2");
			Globals.Inventory.Personincharge = Globals.Inventory.LocationNewrowwiseData.get("incharge");
			Globals.Inventory.Phone = Globals.Inventory.LocationNewrowwiseData.get("PHONE");
			Globals.Inventory.Fax = Globals.Inventory.LocationNewrowwiseData.get("FAX");
			Globals.Inventory.SortCode = Globals.Inventory.LocationNewrowwiseData.get("Sortcode");
			Globals.Inventory.WareHouse = Globals.Inventory.LocationNewrowwiseData.get("WareHouse");
			Globals.Inventory.WareHousecode = Globals.Inventory.LocationNewrowwiseData.get("WareHousecode");
		}

		@Then("I fill new LocationNew data page using excel data")
		public void i_fill_new_LocationNew_data_page_using_excel_data() throws Exception {
			try
			{
			if (GenericWrappers.isNotEmpty(Globals.Inventory.LocationCode)) {
				terPage.terminal_waitClearEnterText_Xpath(icp.LocationCode_String, Globals.Inventory.LocationCode);

			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Location)) {
				terPage.terminal_waitClearEnterText_Xpath(icp.LocationName_String, Globals.Inventory.Location);
				//webDriver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_txtReasonDescription']"))
				//.sendKeys(Keys.RETURN);
				
			}

			if (GenericWrappers.isNotEmpty(Globals.Inventory.Address)) {
				terPage.terminal_waitClearEnterText_Xpath(icp.Address1_String, Globals.Inventory.Address);

			}

			if (GenericWrappers.isNotEmpty(Globals.Inventory.Address1)) {
				terPage.terminal_waitClearEnterText_Xpath(icp.Address2_String, Globals.Inventory.Address1);

			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Address2)) {
				terPage.terminal_waitClearEnterText_Xpath(icp.Address3_String, Globals.Inventory.Address2);

			}

			if (GenericWrappers.isNotEmpty(Globals.Inventory.Personincharge)) {
				terPage.terminal_waitClearEnterText_Xpath(icp.Incharge_String, Globals.Inventory.Personincharge);

			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Phone)) {
				terPage.terminal_waitClearEnterText_Xpath(icp.Phone_String, Globals.Inventory.Phone);

			}

			if (GenericWrappers.isNotEmpty(Globals.Inventory.Fax)) {
				terPage.terminal_waitClearEnterText_Xpath(icp.Fax_String, Globals.Inventory.Fax);

			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.SortCode)) {
				terPage.terminal_waitClearEnterText_Xpath(icp.SortCode_String, Globals.Inventory.SortCode);

			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.WareHouse)) {
				terPage.get_checkBox_element_Xpath(icp.warehouse_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.WareHousecode)) {
				GenericWrappers.sleepInSeconds(1);
				webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_ddlWareHouse_chzn\"]")).click();
				GenericWrappers.sleepInSeconds(1);

				WebElement WareHouseValue = webDriver
						.findElement(By.cssSelector("#ContentPlaceHolder1_ddlWareHouse_chzn > div > div > input[type=text]"));
				String css_location_dropDownValue = "#ContentPlaceHolder1_ddlWareHouse_chzn > div > div > input[type=text]";
				By ddlocator = By.cssSelector(css_location_dropDownValue);
				waitForExpectedElement(ddlocator);
				js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.WareHousecode);
				GenericWrappers.sleepInSeconds(1);
				WareHouseValue.sendKeys(Keys.SPACE);
				WareHouseValue.sendKeys(Keys.SPACE);
				WareHouseValue.sendKeys(Keys.ARROW_DOWN);
				GenericWrappers.sleepInSeconds(1);
				WareHouseValue.sendKeys(Keys.ENTER);

			}
			
			
			pass.ExcelFourData("locationnew","Modules", "Actual", "Expected", "Status",
					0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
			pass.Excelcreate("locationnew", "Location", "Pass", 1, 0, 1, 3);
			}
			catch(Exception e) {
				
				scr.Screenshots();
				System.out.println("Screen shot taken");
				
				pass.ExcelFourData("locationnew","Location", "Actual", "Expected", "Status",
						0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
				pass.Excelcreate("locationnew", "Location", "FAIL", 1, 0, 1, 3);
				
			}
		}
		@Then("I close connection to LocationNew")
		public void i_close_connection_to_LocationNew() {
			mysqlConnect.disconnect();
			System.out.println(" closed succesfully");

		}

		MssqlConnect mysqlConnect;
		Statement st;
		@Then("I establish connection to LocationNew")
		public void i_establish_connection_to_LocationNew() throws SQLException {
			mysqlConnect = new MssqlConnect();
			st = mysqlConnect.connect().createStatement();
			System.out.println(" Connected succesfully");
		}

		@Then("I read the values from table {string} in LocationNew")
		public void i_read_the_values_from_table_in_LocationNew(String tablename) throws SQLException, IOException {
			ResultSet rs = st.executeQuery("select * from " + tablename + " where LocationCode='15'");

			System.out.println(rs);

			while (rs.next()) {

				switch (tablename) {
				case "tbllocation":
					String LocationCode = "";
					try {
						LocationCode = rs.getString("LocationCode");
						System.out.println(LocationCode);
						Assert.assertEquals(Globals.Inventory.LocationCode.trim(), LocationCode.trim());
						pass.Excelcreate("locationnew", "tbllocation", "", 3, 1, 3, 2);
						pass.ExcelFourData("locationnew", "LocationCode", Globals.Inventory.LocationCode, LocationCode, "Pass", 4, 0, 4, 1,
								4, 2, 4, 3);
					} catch (AssertionError e) {
						pass.Excelcreate("locationnew", "tbllocation", "", 3, 1, 3, 2);
						pass.ExcelFourData("locationnew", "LocationCode", Globals.Inventory.LocationCode, LocationCode, "Fail", 4, 0, 4, 1,
								4, 2, 4, 3);

					}

					String Location = "";
					try {
						Location = rs.getString("LocationName");
						System.out.println(Location);
						Assert.assertEquals(Globals.Inventory.Location.trim(), Location.trim());

						pass.ExcelFourData("locationnew", "Location", Globals.Inventory.Location, Location, "Pass", 5, 0,
								5, 1, 5, 2, 5, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("locationnew", "Location", Globals.Inventory.Location, Location, "Fail", 5, 0,
								5, 1, 5, 2, 5, 3);

					}

					String Address = "";
					try {
						Address = rs.getString("Address1");
						System.out.println(Address);
						Assert.assertEquals(Globals.Inventory.Address.trim(), Address.trim());

						pass.ExcelFourData("locationnew", "Address", Globals.Inventory.Address, Address, "Pass", 6,
								0, 6, 1, 6, 2, 6, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("locationnew", "Address", Globals.Inventory.Address, Address, "Fail", 6, 0,
								6, 1, 6, 2, 6, 3);

					}
					String Address1 = "";
					try {
						Address1 = rs.getString("Address2");
						System.out.println(Address1);
						Assert.assertEquals(Globals.Inventory.Address1.trim(), Address1.trim());

						pass.ExcelFourData("locationnew", "Address1", Globals.Inventory.Address1, Address1, "Pass", 7,
								0, 7, 1, 7, 2, 7, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("locationnew", "Address1", Globals.Inventory.Address1, Address1, "Fail", 7, 0,
								7, 1, 7, 2, 7, 3);

					}
					String Address2 = "";
					try {
						Address2 = rs.getString("Address3");
						System.out.println(Address2);
						Assert.assertEquals(Globals.Inventory.Address2.trim(), Address2.trim());

						pass.ExcelFourData("locationnew", "Address2", Globals.Inventory.Address2, Address2, "Pass", 8,
								0, 8, 1, 8, 2, 8, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("locationnew", "Address2", Globals.Inventory.Address2, Address2, "Fail", 8, 0,
								8, 1, 8, 2, 8, 3);

					}
				}String Personincharge = "";
				try {
					Personincharge = rs.getString("PersonIncharge");
					System.out.println(Personincharge);
					Assert.assertEquals(Globals.Inventory.Personincharge.trim(), Personincharge.trim());

					pass.ExcelFourData("locationnew", "Personincharge", Globals.Inventory.Personincharge, Personincharge, "Pass", 9,
							0, 9, 1, 9, 2, 9, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("locationnew", "Personincharge", Globals.Inventory.Personincharge, Personincharge, "Fail", 9, 0,
							9, 1, 9, 2, 9, 3);

				}String Phone = "";
				try {
					Phone = rs.getString("TelePhone");
					System.out.println(Phone);
					Assert.assertEquals(Globals.Inventory.Phone.trim(), Phone.trim());

					pass.ExcelFourData("locationnew", "Phone", Globals.Inventory.Phone, Phone, "Pass", 10,
							0, 10, 1, 10, 2, 10, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("locationnew", "Phone", Globals.Inventory.Phone, Phone, "Fail", 10, 0,
							10, 1, 10, 2, 10, 3);

				}String Fax = "";
				try {
					Fax = rs.getString("FaxNo");
					System.out.println(Fax);
					Assert.assertEquals(Globals.Inventory.Fax.trim(), Fax.trim());

					pass.ExcelFourData("locationnew", "Fax", Globals.Inventory.Fax, Fax, "Pass", 11,
							0, 11, 1, 11, 2, 11, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("locationnew", "Fax", Globals.Inventory.Fax, Fax, "Fail", 11, 0,
							11, 1, 11, 2, 11, 3);

				}
				String SortCode = "";
				try {
					SortCode = rs.getString("SortCode");
					System.out.println(SortCode);
					Assert.assertEquals(Globals.Inventory.SortCode.trim(), SortCode.trim());

					pass.ExcelFourData("locationnew", "SortCode", Globals.Inventory.SortCode, SortCode, "Pass", 8,
							0, 8, 1, 8, 2, 8, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("locationnew", "SortCode", Globals.Inventory.SortCode, SortCode, "Fail", 8, 0,
							8, 1, 8, 2, 8, 3);

				}
				String WareHouse = "";
				try {
					WareHouse = rs.getString("WareHouse");
					System.out.println(WareHouse);
					Assert.assertEquals(Globals.Inventory.WareHouse.trim(), WareHouse.trim());

					pass.ExcelFourData("locationnew", "WareHouse", Globals.Inventory.WareHouse, WareHouse, "Pass", 9,
							0, 9, 1, 9, 2, 9, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("locationnew", "WareHouse", Globals.Inventory.WareHouse, WareHouse, "Fail", 9, 0,
							9, 1, 9, 2, 9, 3);

				}
				String WareHousecode = "";
				try {
					WareHousecode = rs.getString("WarehouseCode");
					System.out.println(WareHousecode);
					Assert.assertEquals(Globals.Inventory.WareHousecode.trim(), WareHousecode.trim());

					pass.ExcelFourData("locationnew", "WareHousecode", Globals.Inventory.WareHousecode, WareHousecode, "Pass", 10,
							0, 10, 1, 10, 2, 10, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("locationnew", "WareHousecode", Globals.Inventory.WareHousecode, WareHousecode, "Fail", 10, 0,
							10, 1, 10, 2, 10, 3);

				}
			}
		}

		
		}

		



