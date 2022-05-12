package com.unipro.test.framework.helpers.utils;



	
import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebElement;
	import com.unipro.test.framework.Globals;
	import com.unipro.test.framework.PageObject;
	import com.unipro.test.framework.helpers.utils.GenericWrappers;
	import com.unipro.test.framework.helpers.utils.ReadTestData;
import com.unipro.test.page_objects.unixpro.AddInventoryFormPage;
import com.unipro.test.page_objects.unixpro.Origionfield;
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

import com.unipro.test.page_objects.unixpro.TerminalPage;

import cucumber.api.java.en.Then;

	public class Transport  extends PageObject {
		AddInventoryFormPage Category;
		Transportfield icp;
		TerminalPage terPage;
        ExcelWrite pass;
		public Transport(Transportfield icp) {
			this.icp = icp;
			terPage = new TerminalPage();
			Category = new AddInventoryFormPage();
			pass=new ExcelWrite();
		}

		@Then("I load the Transport sheet data to map")
		public void i_load_the_Subcategory_sheet_data_to_map() {
			Globals.Inventory.TransportSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME41);
		}

		@Then("I load the rowise Transport data for {string} rowname")
		public void i_load_the_rowise_Category_data_for_rowname(String row_name) {

			Globals.Inventory.TransportrowwiseData = ReadTestData
					.getRowFilteredValueFromTable(Globals.Inventory.TransportSheetData, row_name);

			System.out.println(Globals.Inventory.TransportSheetData);

		}

		@Then("I update value to the Transport page global Variables")
		public void i_update_value_to_the_Subcategory_page_global_Variables() {
			Globals.Inventory.Transportname = Globals.Inventory.TransportrowwiseData.get("Transportname");
			Globals.Inventory.Person = Globals.Inventory.TransportrowwiseData.get("Person");
			Globals.Inventory.Address = Globals.Inventory.TransportrowwiseData.get("Address");
			Globals.Inventory.Address1 = Globals.Inventory.TransportrowwiseData.get("Address1");
			Globals.Inventory.Phone = Globals.Inventory.TransportrowwiseData.get("Phone");
			Globals.Inventory.ModelNo = Globals.Inventory.TransportrowwiseData.get("ModelNo");
			Globals.Inventory.Fax = Globals.Inventory.TransportrowwiseData.get("Fax");
			Globals.Inventory.Email = Globals.Inventory.TransportrowwiseData.get("Email");
			Globals.Inventory.URL = Globals.Inventory.TransportrowwiseData.get("URL");
			Globals.Inventory.Batch = Globals.Inventory.TransportrowwiseData.get("Batch");
		}

		@Then("I fill new Transport data page using excel data")
		public void i_fill_new_Subcategory_data_page_using_excel_data() {

			if (GenericWrappers.isNotEmpty(Globals.Inventory.Transportname)) {
				terPage.terminal_waitClearEnterText_Xpath(icp.Transportname_String, Globals.Inventory.Transportname);

			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Person)) {
				terPage.terminal_waitClearEnterText_Xpath(icp.Person_String, Globals.Inventory.Person);

			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Address)) {
				terPage.terminal_waitClearEnterText_Xpath(icp.Address_String, Globals.Inventory.Address);

			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Address1)) {
				terPage.terminal_waitClearEnterText_Xpath(icp.Address1_String, Globals.Inventory.Address1);

			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Phone)) {
				terPage.terminal_waitClearEnterText_Xpath(icp.Phone_String, Globals.Inventory.Phone);

			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.ModelNo)) {
				terPage.terminal_waitClearEnterText_Xpath(icp.ModelNo_String, Globals.Inventory.ModelNo);

			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Fax)) {
				terPage.terminal_waitClearEnterText_Xpath(icp.Fax_String, Globals.Inventory.Fax);

			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Email)) {
				terPage.terminal_waitClearEnterText_Xpath(icp.Email_String, Globals.Inventory.Email);

			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.URL)) {
				terPage.terminal_waitClearEnterText_Xpath(icp.URL_String, Globals.Inventory.URL);

			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch)) {
				terPage.get_checkBox_element_Xpath(icp.Batch_String).click();

			}
			

		}
		@Then("I close connection to Transport")
		public void I_close_connection_to_Transport() throws SQLException {

			mysqlConnect.disconnect();
			System.out.println(" closed succesfully");

		}

		MssqlConnect mysqlConnect;
		Statement st;

		@Then("I establish connection to Transport")
		public void I_establish_connection_to_Transport() throws SQLException {

			mysqlConnect = new MssqlConnect();
			st = mysqlConnect.connect().createStatement();
			System.out.println(" Connected succesfully");

		}

		@Given("I read the values from table {string} in Transport")
		public void i_want_to_launch_the(String tablename) throws SQLException, IOException {

			ResultSet rs = st.executeQuery("select * from " + tablename + " where TransportName ='Gopi'");

			System.out.println(rs);

			while (rs.next()) {

				switch (tablename) {
				case "tblTransport":
					System.out.println("1");
					String Transportname = "";
					try {
						System.out.println("2");
						Transportname = rs.getString("TransportName");
						System.out.println("3");
						System.out.println(Transportname);
						Assert.assertEquals(Globals.Inventory.Transportname.trim(), Transportname.trim());
						pass.Excelcreate("transportmaster", "tblTransport", "", 1, 0, 1, 1);
						pass.ExcelFourData("transportmaster", "Transportname", Globals.Inventory.Transportname, Transportname, "Pass", 2, 0, 2, 1,
								2, 2, 2, 3);
					} catch (AssertionError e) {
						pass.Excelcreate("transportmaster", "tblTransport", "", 1, 0, 1, 1);
						pass.ExcelFourData("transportmaster", "Transportname", Globals.Inventory.Transportname, Transportname, "Fail", 2, 0, 2, 1,
								2, 2, 2, 3);

					}

					String Person = "";
					try {
						Person = rs.getString("ContactPerson");
						System.out.println(Person);
						Assert.assertEquals(Globals.Inventory.Person.trim(), Person.trim());

						pass.ExcelFourData("transportmaster", "Person", Globals.Inventory.Person, Person, "Pass", 3,
								0, 3, 1, 3, 2, 3, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("transportmaster", "Person", Globals.Inventory.Person, Person,"Fail",3,0,3, 1, 3, 2, 3, 3);

					}
					String Address = "";
					try {
						Person = rs.getString("Address1");
						System.out.println(Address);
						Assert.assertEquals(Globals.Inventory.Address.trim(), Address.trim());

						pass.ExcelFourData("transportmaster", "Address", Globals.Inventory.Address, Address, "Pass", 4,
								0, 4, 1, 4, 2, 4, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("transportmaster", "Address", Globals.Inventory.Address, Address,"Fail",4,0,4, 1, 4, 2, 4, 3);

					}
					String Address1 = "";
					try {
						Address1 = rs.getString("Address2");
						System.out.println(Address1);
						Assert.assertEquals(Globals.Inventory.Address1.trim(), Address1.trim());

						pass.ExcelFourData("transportmaster", "Address1", Globals.Inventory.Address1, Address1, "Pass", 5,
								0, 5, 1, 5, 2, 5, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("transportmaster", "Address1", Globals.Inventory.Address1, Address1,"Fail",5,0,5, 1, 5, 2, 5, 3);

					}
					String Phone = "";
					try {
						Person = rs.getString("Phone");
						System.out.println(Phone);
						Assert.assertEquals(Globals.Inventory.Phone.trim(), Phone.trim());

						pass.ExcelFourData("transportmaster", "Phone", Globals.Inventory.Phone, Phone, "Pass", 6,
								0, 6, 1, 6, 2, 6, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("transportmaster", "Phone", Globals.Inventory.Phone, Phone,"Fail",6,0,6, 1, 6, 2, 6, 3);

					}
					String ModelNo = "";
					try {
						Person = rs.getString("Mobile");
						System.out.println(ModelNo);
						Assert.assertEquals(Globals.Inventory.ModelNo.trim(), ModelNo.trim());

						pass.ExcelFourData("transportmaster", "ModelNo", Globals.Inventory.ModelNo, ModelNo, "Pass", 7,
								0, 7, 1, 7, 2, 7, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("transportmaster", "ModelNo", Globals.Inventory.ModelNo, ModelNo,"Fail",7,0,7, 1, 7, 2, 7, 3);

					}
					String Fax = "";
					try {
						Person = rs.getString("Fax");
						System.out.println(Fax);
						Assert.assertEquals(Globals.Inventory.Fax.trim(), Fax.trim());

						pass.ExcelFourData("transportmaster", "Fax", Globals.Inventory.Fax, Fax, "Pass", 8,
								0, 8, 1, 8, 2, 8, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("transportmaster", "Fax", Globals.Inventory.Fax, Fax,"Fail",8,0,8, 1, 8, 2, 8, 3);

					}String Email = "";
					try {
						Person = rs.getString("EMail");
						System.out.println(Email);
						Assert.assertEquals(Globals.Inventory.Email.trim(), Email.trim());

						pass.ExcelFourData("transportmaster", "Email", Globals.Inventory.Email, Email, "Pass", 9,
								0, 9, 1, 9, 2, 9, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("transportmaster", "Email", Globals.Inventory.Email, Email,"Fail",9,0,9, 1, 9, 2, 9, 3);

					}String URL = "";
					try {
						Person = rs.getString("Url");
						System.out.println(URL);
						Assert.assertEquals(Globals.Inventory.URL.trim(), URL.trim());

						pass.ExcelFourData("transportmaster", "URL", Globals.Inventory.URL, ModelNo, "Pass", 10,
								0, 10, 1, 10, 2, 10, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("transportmaster", "URL", Globals.Inventory.URL, URL,"Fail",10,0,10, 1, 10, 2, 10, 3);

					}
	

	}

			}
		}


	}





