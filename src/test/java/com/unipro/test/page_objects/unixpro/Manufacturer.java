package com.unipro.test.page_objects.unixpro;

	import com.unipro.test.framework.Globals;
	import com.unipro.test.framework.helpers.utils.GenericWrappers;
	import com.unipro.test.framework.helpers.utils.ReadTestData;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
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


	public class Manufacturer  {
		AddInventoryFormPage Category;
		ManufacturerField icp;
        ExcelWrite pass;
		TerminalPage terPage;

		public  Manufacturer(ManufacturerField  icp) {
			this.icp = icp;
			terPage = new TerminalPage();
            pass=new ExcelWrite();
			Category = new AddInventoryFormPage();
		}
		
		@Then("I load the Manufacturer sheet data to map")
		public void i_load_the_Subcategory_sheet_data_to_map() {
			Globals.Inventory.ManufacturerSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME33);
		}
		@Then("I load the rowise Manufacturer data for {string} rowname")
		public void i_load_the_rowise_Category_data_for_rowname(String row_name) {

			Globals.Inventory.ManufacturerrowwiseData = ReadTestData
					.getRowFilteredValueFromTable(Globals.Inventory.ManufacturerSheetData, row_name);

			System.out.println(Globals.Inventory.ManufacturerSheetData);

		}

		@Then("I update value to the Manufacturer page global Variables")
		public void i_update_value_to_the_Subcategory_page_global_Variables() {
			Globals.Inventory.ManufacturerCode = Globals.Inventory.ManufacturerrowwiseData.get("Manufacturercode");
			Globals.Inventory.ManufacturerName = Globals.Inventory.ManufacturerrowwiseData.get("ManufacturerName");
			Globals.Inventory.Address = Globals.Inventory.ManufacturerrowwiseData.get("Address");
			Globals.Inventory.Address1 = Globals.Inventory.ManufacturerrowwiseData.get("Address1");
			Globals.Inventory.Address2 = Globals.Inventory.ManufacturerrowwiseData.get("Address2");
			Globals.Inventory.Pincode = Globals.Inventory.ManufacturerrowwiseData.get("Pincode");
			Globals.Inventory.Email = Globals.Inventory.ManufacturerrowwiseData.get("Email");
			Globals.Inventory.Phone = Globals.Inventory.ManufacturerrowwiseData.get("Phone");
			Globals.Inventory.Fax = Globals.Inventory.ManufacturerrowwiseData.get("Fax");

			
		}

		@Then("I fill new Manufacturer data page using excel data")
		public void i_fill_new_Subcategory_data_page_using_excel_data() {
			

			if (GenericWrappers.isNotEmpty(Globals.Inventory.ManufacturerCode)) {
				terPage.terminal_waitClearEnterText_css(icp.Manufacturercode_String, Globals.Inventory.ManufacturerCode);
			
			}
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.ManufacturerName)) {
				terPage.terminal_waitClearEnterText_css(icp.ManufacturerName_String, Globals.Inventory.ManufacturerName);
			
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Address)) {
				terPage.terminal_waitClearEnterText_css(icp.Address_String, Globals.Inventory.Address);
			
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Address1)) {
				terPage.terminal_waitClearEnterText_css(icp.Address1_String, Globals.Inventory.Address1);
			
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Address2)) {
				terPage.terminal_waitClearEnterText_css(icp.Address2_String, Globals.Inventory.Address2);
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Pincode)) {
			}
				terPage.terminal_waitClearEnterText_css(icp.Pincode_String, Globals.Inventory.Pincode);
			
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Email)) {
				terPage.terminal_waitClearEnterText_css(icp.Email_String, Globals.Inventory.Email);
			
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Phone)) {
				terPage.terminal_waitClearEnterText_css(icp.Phone_String, Globals.Inventory.Phone);
			
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Fax)) {
				terPage.terminal_waitClearEnterText_css(icp.Fax_String, Globals.Inventory.Fax);
			
			}
			
		
			
		
	}
		@Then("I close connection to Manufacturer")
		public void I_close_connection_to_Manufacturer() throws SQLException {

			mysqlConnect.disconnect();
			System.out.println(" closed succesfully");

			// mysqlConnect.disconnect();

		}

		MssqlConnect mysqlConnect;
		Statement st;


		@Then("I establish connection to Manufacturer")
		public void I_establish_connection_to_Manufacturer() throws SQLException {

			mysqlConnect = new MssqlConnect();
			st = mysqlConnect.connect().createStatement();
			System.out.println(" Connected succesfully");


		}	

		@Given("I read the values from table {string} in Manufacturer")
		public void i_want_to_launch_the(String tablename) throws SQLException, IOException {
			
			
			ResultSet rs = st.executeQuery("select * from "+tablename+" where ManufacturerCode='1'");
			
			System.out.println(rs);
			//ResultSet rs = st.executeQuery("");

			while (rs.next()) {

				switch (tablename) {
				case "tblManufacturer":
				System.out.println("1");
				String ManufacturerCode="";
				try {
					System.out.println("2");
					ManufacturerCode = rs.getString("ManufacturerCode");
					System.out.println("3");
					System.out.println(ManufacturerCode);
					Assert.assertEquals(Globals.Inventory.ManufacturerCode.trim(), ManufacturerCode.trim());
					pass.Excelcreate("manufacturer", "tblManufacturer", "",1, 0, 1, 1);
					pass.ExcelFourData("manufacturer", "ManufacturerCode", Globals.Inventory.ManufacturerCode, ManufacturerCode, "Pass",
							2, 0, 2, 1, 2, 2, 2, 3);
				} catch (AssertionError e) {
					pass.Excelcreate("manufacturer", "tblManufacturer", "", 1, 0, 1, 1);
					pass.ExcelFourData("manufacturer", "ManufacturerCode",  Globals.Inventory.ManufacturerCode, ManufacturerCode, "Fail",
							2, 0, 2, 1, 2, 2, 2, 3);

				}
				
				String ManufacturerName="";
				try {
					ManufacturerName = rs.getString("ManufacturerName");
					System.out.println(ManufacturerName);
					Assert.assertEquals(Globals.Inventory.ManufacturerName.trim(), ManufacturerName.trim());
					
					pass.ExcelFourData("manufacturer", "ManufacturerName", Globals.Inventory.ManufacturerName, ManufacturerName,
							"Pass", 3, 0, 3, 1, 3, 2, 3, 3);

				} catch (AssertionError e) {
					
					pass.ExcelFourData("manufacturer", "ManufacturerName", Globals.Inventory.ManufacturerName, ManufacturerName,
							"Fail", 3, 0, 3, 1, 3, 2, 3, 3);

				}
				String Address = "";
				try {
					Address = rs.getString("Address1");
					System.out.println(Address);
					Assert.assertEquals(Globals.Inventory.Address.trim(), Address.trim());
					
					pass.ExcelFourData("manufacturer", "Address", Globals.Inventory.Address, Address,
							"Pass", 4, 0, 4, 1, 4, 2, 4, 3);

				} catch (AssertionError e) {
					
					pass.ExcelFourData("manufacturer", "Address", Globals.Inventory.Address, Address,
							"Fail", 4, 0, 4, 1, 4, 2, 4, 3);

				}
				String Address1 = "";
				try {
					Address1 = rs.getString("Address2");
					System.out.println(Address1);
					Assert.assertEquals(Globals.Inventory.Address1.trim(), Address1.trim());
			
					pass.ExcelFourData("manufacturer", "Address1", Globals.Inventory.Address1, Address1,
							"Pass", 5, 0, 5, 1, 5, 2, 5, 3);

				} catch (AssertionError e) {
			
					pass.ExcelFourData("manufacturer", "Address1", Globals.Inventory.Address1, Address1,
							"Fail", 5, 0, 5, 1, 5, 2, 5, 3);

				}
				
				String Pincode = "";
				try {
					Pincode = rs.getString("PinCode");
					System.out.println(Pincode);
					Assert.assertEquals(Globals.Inventory.Pincode.trim(), Pincode.trim());
					
					pass.ExcelFourData("manufacturer", "Pincode", Globals.Inventory.Pincode, Pincode,
							"Pass", 7, 0, 7, 1, 7, 2, 7, 3);

				} catch (AssertionError e) {
			
					pass.ExcelFourData("manufacturer", "Pincode", Globals.Inventory.Pincode, Pincode,
							"Fail", 7, 0, 7, 1, 7, 2, 7, 3);

				}
				String Email = "";
				try {
					Email = rs.getString("EMail");
					System.out.println(Email);
					Assert.assertEquals(Globals.Inventory.Email.trim(), Email.trim());
					
					pass.ExcelFourData("manufacturer", "Email", Globals.Inventory.Email, Email,
							"Pass", 8, 0, 8, 1, 8, 2, 8, 3);

				} catch (AssertionError e) {
					
					pass.ExcelFourData("manufacturer", "Email", Globals.Inventory.Email, Email,
							"Fail", 8, 0, 8, 1, 8, 2, 8, 3);

				}
				String Phone = "";
				try {
					Address = rs.getString("Phone");
					System.out.println(Address);
					Assert.assertEquals(Globals.Inventory.Phone.trim(), Phone.trim());
				
					pass.ExcelFourData("manufacturer", "Phone", Globals.Inventory.Phone, Phone,
							"Pass", 9, 0, 9, 1, 9, 2, 9, 3);

				} catch (AssertionError e) {
					
					pass.ExcelFourData("manufacturer", "Phone", Globals.Inventory.Phone, Phone,
							"Fail", 9, 0, 9, 1, 9, 2, 9, 3);

				}
				String Fax = "";
				try {
					Address = rs.getString("Fax");
					System.out.println(Fax);
					Assert.assertEquals(Globals.Inventory.Fax.trim(), Fax.trim());
					
					pass.ExcelFourData("manufacturer", "Fax", Globals.Inventory.Fax, Fax,
							"Pass", 10, 0, 10, 1, 10, 2, 10, 3);

				} catch (AssertionError e) {
					
					pass.ExcelFourData("manufacturer", "Fax", Globals.Inventory.Fax, Fax,
							"Fail", 10, 0, 10, 1, 10, 2, 10, 3);

				}
				break;
				
				default:
					break;
				}
			
		
	
	



}
		}
	}
	

	






