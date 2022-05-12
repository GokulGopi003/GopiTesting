package com.unipro.test.page_objects.unixpro;

	import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.testng.Assert;
import com.gk.test.MssqlConnect;
import com.unipro.ExcelWrite;
import com.unipro.test.framework.Globals;
	import com.unipro.test.framework.helpers.utils.GenericWrappers;
	import com.unipro.test.framework.helpers.utils.ReadTestData;
	import cucumber.api.java.en.Then;

	public class Tax { 
		AddInventoryFormPage Category;
		Taxfield icp;
        ExcelWrite pass;
		TerminalPage terPage;

		public  Tax(Taxfield icp) {
			this.icp = icp;
			terPage = new TerminalPage();
            pass=new ExcelWrite();
			Category = new AddInventoryFormPage();
		}
		
		@Then("I load the Tax sheet data to map")
		public void i_load_the_Subcategory_sheet_data_to_map() {
			Globals.Inventory.TaxSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME13);
		}
		@Then("I load the rowise Tax data for {string} rowname")
		public void i_load_the_rowise_Category_data_for_rowname(String row_name) {

			Globals.Inventory.TaxrowwiseData = ReadTestData
					.getRowFilteredValueFromTable(Globals.Inventory.TaxSheetData, row_name);

			System.out.println(Globals.Inventory.TaxSheetData);

		}

		@Then("I update value to the Tax page global Variables")
		public void i_update_value_to_the_Subcategory_page_global_Variables() {
			Globals.Inventory.Taxcode = Globals.Inventory.TaxrowwiseData.get("Taxcode");
			Globals.Inventory.SGST = Globals.Inventory.TaxrowwiseData.get("SGST");
			Globals.Inventory.CGST = Globals.Inventory.TaxrowwiseData.get("CGST");
			Globals.Inventory.IGST = Globals.Inventory.TaxrowwiseData.get("IGST");
			Globals.Inventory.Batch= Globals.Inventory.TaxrowwiseData.get("Batch");
			Globals.Inventory.Batch1= Globals.Inventory.TaxrowwiseData.get("Batch1");
			Globals.Inventory.Batch2= Globals.Inventory.TaxrowwiseData.get("Batch2");
			Globals.Inventory.Billdate= Globals.Inventory.TaxrowwiseData.get("Billdate");
			Globals.Inventory.Date= Globals.Inventory.TaxrowwiseData.get("Date");
			
			
		
			
		}

		@Then("I fill new Tax data page using excel data")
		public void i_fill_new_Subcategory_data_page_using_excel_data() {
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Taxcode)) {
				terPage.terminal_waitClearEnterText_css(icp.Taxcode_string, Globals.Inventory.Taxcode);
				

			}
			
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch)) {
				terPage.get_checkBox_element(icp.Batch_String).click();
			
			}
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch1)) {
				terPage.get_checkBox_element(icp.Batch1_String).click();
			
			}
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch2)) {
				terPage.get_checkBox_element(icp.Batch2_String).click();
			
			}
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.SGST)) {
				terPage.terminal_waitClearEnterText_css(icp.SGST_String, Globals.Inventory.SGST);
			
			}
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.CGST)) {
				terPage.terminal_waitClearEnterText_css(icp.CGST_String, Globals.Inventory.CGST);
			
			}
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.IGST)) {
				terPage.terminal_waitClearEnterText_css(icp.IGST_String, Globals.Inventory.IGST);
			
			}
		

			if (GenericWrappers.isNotEmpty(Globals.Inventory.Billdate)) {
				terPage.terminal_waitClearEnterText_css(icp.Billdate_String, Globals.Inventory.Billdate);
			
			}
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Date)) {
				terPage.terminal_waitClearEnterText_css(icp.Date_String, Globals.Inventory.Date);
			
			}
			
	}
		@Then("I close connection to Tax")
		public void i_close_connection_to_Tax() {
			mysqlConnect.disconnect();
			System.out.println(" closed succesfully");

		}

		MssqlConnect mysqlConnect;
		Statement st;

		
		@Then("I establish connection to Tax")
		public void i_establish_connection_to_Tax() throws SQLException {
			mysqlConnect = new MssqlConnect();
			st = mysqlConnect.connect().createStatement();
			System.out.println(" Connected succesfully");
		}

		@Then("I read the values from table {string} in Tax")
		public void i_read_the_values_from_table_in_Tax(String tablename) throws SQLException, IOException {
			ResultSet rs = st.executeQuery("select * from " + tablename + " where TaxCode='1'");

			System.out.println(rs);

			while (rs.next()) {

				switch (tablename) {
				case "tblTaxMaster":
					String Taxcode = "";
					try {
						Taxcode = rs.getString("TaxCode");
						System.out.println(Taxcode);
						Assert.assertEquals(Globals.Inventory.Taxcode.trim(), Taxcode.trim());
						 pass.Excelcreate("taxnew", "tblTaxMaster", "", 2, 0, 2, 1);
						pass.ExcelFourData("taxnew", "Taxcode", Globals.Inventory.Taxcode, Taxcode, "Pass", 3, 0,
								3, 1, 3, 2, 3, 3);
					} catch (AssertionError e) {
						 pass.Excelcreate("taxnew", "tblTaxMaster", "", 2, 0, 2, 1);
						pass.ExcelFourData("taxnew", "Taxcode", Globals.Inventory.Taxcode, Taxcode, "Fail", 3, 0,
								3, 1, 3, 2, 3, 3);

					}
					String SGST = "";
					try {
						SGST = rs.getString("Description");
						System.out.println(SGST);
						Assert.assertEquals(Globals.Inventory.SGST.trim(), SGST.trim());

						pass.ExcelFourData("taxnew", "SGST", Globals.Inventory.SGST, SGST, "Pass", 4, 0, 4, 1, 4, 2,
								4, 3);
					} catch (AssertionError e) {

						pass.ExcelFourData("taxnew", "SGST", Globals.Inventory.SGST, SGST, "Fail", 4, 0, 4, 1, 4, 2,
								4, 3);

					}

					String CGST = "";
					try {
						CGST = rs.getString("CGST");
						System.out.println(CGST);
						Assert.assertEquals(Globals.Inventory.CGST.trim(), CGST.trim());

						pass.ExcelFourData("taxnew", "CGST", Globals.Inventory.CGST, CGST, "Pass", 5, 0, 5,
								1, 5, 2, 5, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("taxnew", "CGST", Globals.Inventory.CGST, CGST, "Fail", 5, 0, 5,
								1, 5, 2, 5, 3);

					}

					String IGST = "";
					try {
						IGST = rs.getString("IGST");
						System.out.println(IGST);
						Assert.assertEquals(Globals.Inventory.IGST.trim(), IGST.trim());

						pass.ExcelFourData("taxnew", "IGST", Globals.Inventory.IGST, IGST, "Pass", 6, 0,
								6, 1, 6, 2, 6, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("taxnew", "IGST", Globals.Inventory.IGST, IGST, "Fail", 6, 0,
								6, 1, 6, 2, 6, 3);

					}
					String Batch = "";
					try {
						Batch = rs.getString("Batch");
						System.out.println(Batch);
						Assert.assertEquals(Globals.Inventory.Batch.trim(), Batch.trim());

						pass.ExcelFourData("taxnew", "Batch", Globals.Inventory.Batch, Batch, "Pass", 7, 0, 7, 1, 7,
								2, 7, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("taxnew", "Batch", Globals.Inventory.Batch, Batch, "Fail", 7, 0, 7, 1, 7,
								2, 7, 3);

					}
					String Batch1 = "";
					try {
						Batch1 = rs.getString("Batch1");
						System.out.println(Batch1);
						Assert.assertEquals(Globals.Inventory.Batch1.trim(), Batch1.trim());

						pass.ExcelFourData("taxnew", "Batch1", Globals.Inventory.Batch1, Batch1, "Pass", 8, 0,
								8, 1, 8, 2, 8, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("taxnew", "Batch1", Globals.Inventory.Batch1, Batch1, "Fail", 8, 0,
								8, 1, 8, 2, 8, 3);

					}
					String Batch2 = "";
					try {
						Batch2 = rs.getString("Batch2");
						System.out.println(Batch2);
						Assert.assertEquals(Globals.Inventory.Batch2.trim(), Batch2.trim());

						pass.ExcelFourData("taxnew", "Batch2", Globals.Inventory.Batch2, Batch2, "Pass", 9, 0, 9,
								1, 9, 2, 9, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("taxnew", "Batch2", Globals.Inventory.Batch2, Batch2, "Fail", 9, 0, 9,
								1, 9, 2, 9, 3);

					}
					String Billdate = "";
					try {
						Batch2 = rs.getString("Billdate");
						System.out.println(Billdate);
						Assert.assertEquals(Globals.Inventory.Billdate.trim(), Billdate.trim());

						pass.ExcelFourData("taxnew", "Billdate", Globals.Inventory.Billdate, Billdate, "Pass", 10, 0, 10,
								1, 10, 2, 10, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("taxnew", "Billdate", Globals.Inventory.Billdate, Billdate, "Fail", 10, 0, 10,
								1, 10, 2, 10, 3);

					}
					String Date = "";
					try {
						Batch2 = rs.getString("Date");
						System.out.println(Date);
						Assert.assertEquals(Globals.Inventory.Date.trim(), Date.trim());

						pass.ExcelFourData("taxnew", "Date", Globals.Inventory.Date, Date, "Pass", 11, 0, 11,
								1, 11, 2, 11, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("taxnew", "Date", Globals.Inventory.Date, Date, "Fail", 11, 0, 11,
								1, 11, 2, 11, 3);

					}
					
		
			
		}
	
			}
		}
	}
	

