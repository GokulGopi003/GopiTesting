package com.unipro.test.page_objects.unixpro;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
import com.unipro.test.framework.helpers.utils.GenericWrappers;
	import com.unipro.test.framework.helpers.utils.ReadTestData;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

	public class CompanySettings extends PageObject {
	    CompanySettingsField icp;
        TerminalPage terPage;
         ExcelWrite pass;
		public  CompanySettings(CompanySettingsField  icp) {
			this.icp = icp;
			terPage = new TerminalPage();
            pass=new ExcelWrite();
		}
		
		@Then("I load the CompanySettings sheet data to map")
		public void i_load_the_CompanySettings_sheet_data_to_map() {
			Globals.Inventory.CompanySettingsSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME27);
		}
		@Then("I load the rowise CompanySettings data for {string} rowname")
		public void i_load_the_rowise_CompanySettings_data_for_rowname(String row_name) {

			Globals.Inventory.CompanySettingsrowwiseData = ReadTestData
					.getRowFilteredValueFromTable(Globals.Inventory.CompanySettingsSheetData, row_name);

			System.out.println(Globals.Inventory.CompanySettingsSheetData);

		}
		@Then("I update value to the CompanySettings page global Variables")
		public void i_update_value_to_the_GA_page_global_Variables() {
			Globals.Inventory.CompanyCode = Globals.Inventory.CompanySettingsrowwiseData.get("CompanyCode");
			Globals.Inventory.CompanyName = Globals.Inventory.CompanySettingsrowwiseData.get("CompanyName");
			Globals.Inventory.GST = Globals.Inventory.CompanySettingsrowwiseData.get("GST");
			Globals.Inventory.Date = Globals.Inventory.CompanySettingsrowwiseData.get("Date");
			Globals.Inventory.Billno = Globals.Inventory.CompanySettingsrowwiseData.get("Billno");
			Globals.Inventory.CST = Globals.Inventory.CompanySettingsrowwiseData.get("Description");
			Globals.Inventory.Remarks = Globals.Inventory.CompanySettingsrowwiseData.get("Remarks");
			Globals.Inventory.Batch = Globals.Inventory.CompanySettingsrowwiseData.get("Batch");
		}

		@Then("I fill new CompanySettings data page using excel data")
		public void i_fill_new_GA_data_page_using_excel_data() {
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.CompanyCode)) {
				terPage.terminal_waitClearEnterText_css(icp.CompanyCode_String, Globals.Inventory.CompanyCode);
				//webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtCompanyCode")).sendKeys(Keys.RETURN);
				
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.CompanyName)) {
				terPage.terminal_waitClearEnterText_css(icp.CompanyName_String, Globals.Inventory.CompanyName);

			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.GST)) {
				terPage.terminal_waitClearEnterText_css(icp.GST_String, Globals.Inventory.GST);

			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.CST)) {
				terPage.terminal_waitClearEnterText_css(icp.Description_String, Globals.Inventory.CST);

			}

			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Date)) {
				terPage.terminal_waitClearEnterText_css(icp.Date_String, Globals.Inventory.Date);
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Billno)) {
				terPage.terminal_waitClearEnterText_css(icp.Billno_String, Globals.Inventory.Billno);

			}
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Remarks)) {
				terPage.terminal_waitClearEnterText_css(icp.Remarks_String, Globals.Inventory.Remarks);


			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch)) {
				terPage.get_checkBox_element(icp.Batch_String).click();

			}
        
		}
		@Then("I close connection to CompanySettings")
		public void I_close_connection_to_CompanySettings() throws SQLException {

			mysqlConnect.disconnect();
			System.out.println(" closed succesfully");

		}

		MssqlConnect mysqlConnect;
		Statement st;

		@Then("I establish connection to CompanySettings")
		public void I_establish_connection_to_CompanySettings() throws SQLException {

			mysqlConnect = new MssqlConnect();
			st = mysqlConnect.connect().createStatement();
			System.out.println(" Connected succesfully");

		}

		@Given("I read the values from table {string} in CompanySettings")
		public void i_want_to_launch_the(String tablename) throws SQLException, IOException {

			ResultSet rs = st.executeQuery("select * from " + tablename + " where CompanyCode='a'");

			System.out.println(rs);

			while (rs.next()) {

				switch (tablename) {
				case "tblcompanyname":
					String CompanyCode = "";
					try {
						CompanyCode = rs.getString("CompanyCode");
						System.out.println(CompanyCode);
						Assert.assertEquals(Globals.Inventory.CompanyCode.trim(), CompanyCode.trim());
						pass.Excelcreate("companysettings", "tblcompanyname", "", 0, 0, 0, 0);
						pass.ExcelFourData("companysettings", "CompanyCode", Globals.Inventory.CompanyCode, CompanyCode, "Pass", 1, 0, 1, 1,
								1, 2, 1, 3);
					} catch (AssertionError e) {
						pass.Excelcreate("companysettings", "tblcompanyname", "", 0, 0, 0, 0);
						pass.ExcelFourData("companysettings", "CompanyCode", Globals.Inventory.CompanyCode, CompanyCode, "Fail", 1, 0, 1, 1,
								1, 2, 1, 3);

					}
					
					String Department = "";
					try {
						Department = rs.getString("CompanyName");
						System.out.println(Department);
						Assert.assertEquals(Globals.Inventory.CompanyName.trim(), Department.trim());

						pass.ExcelFourData("companysettings", "Department", Globals.Inventory.CompanyName, Department, "Pass", 2, 0, 2, 1,
								2, 2, 2, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("companysettings", "Department", Globals.Inventory.CompanyName, Department, "Fail", 2, 0, 2, 1,
								2, 2, 2, 3);

					}
					String Billno = "";
					try {
						Billno = rs.getString("InvoiceNo");
						System.out.println(Billno);
						Assert.assertEquals(Globals.Inventory.Billno.trim(), Billno.trim());
						
						pass.ExcelFourData("companysettings", "Billno", Globals.Inventory.Billno, Billno, "Pass",3, 0,
								3, 1, 3, 2, 3, 3);
					} catch (AssertionError e) {
						
						pass.ExcelFourData("companysettings", "Billno", Globals.Inventory.Billno, Billno, "Fail", 3, 0,
								3, 1, 3, 2, 3, 3);

					}
					String GST = "";
					try {
						GST = rs.getString("TinNo");
						System.out.println(GST);
						Assert.assertEquals(Globals.Inventory.GST.trim(), GST.trim());
						
						pass.ExcelFourData("companysettings", "GST", Globals.Inventory.GST, GST, "Pass",4, 0,
								4, 1, 4, 2, 4, 3);
					} catch (AssertionError e) {
						
						pass.ExcelFourData("companysettings", "GST", Globals.Inventory.GST, GST, "Fail", 4, 0,
								4, 1, 4, 2, 4, 3);

					}
					String Remarks = "";
					try {
						Remarks = rs.getString("Remarks");
						System.out.println(Remarks);
						Assert.assertEquals(Globals.Inventory.Remarks.trim(), Remarks.trim());
						
						pass.ExcelFourData("companysettings", "Remarks", Globals.Inventory.Remarks, Remarks, "Pass",5, 0,
								5, 1, 5, 2, 5, 3);
					} catch (AssertionError e) {
						
						pass.ExcelFourData("companysettings", "Remarks", Globals.Inventory.Remarks, Remarks, "Fail", 5, 0,
								5, 1, 5, 2, 5, 3);

					}
					/*String Date = "";
					try {
						Date = rs.getString("Date");
						System.out.println(Date);
						Assert.assertEquals(Globals.Inventory.Date.trim(), Date.trim());
						
						pass.ExcelFourData("companysettings", "Date", Globals.Inventory.Date, Date, "Pass",6, 0,
								6, 1, 6, 2, 6, 3);
					} catch (AssertionError e) {
						
						pass.ExcelFourData("companysettings", "Date", Globals.Inventory.Date, Date, "Fail", 6, 0,
								6, 1, 6, 2, 6, 3);

					}*/
				
              break;
		
}
	

			}
		}}

		
		   
		



