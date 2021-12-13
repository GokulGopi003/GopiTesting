package com.unipro.test.page_objects.unixpro;




	import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;

import com.gk.test.MssqlConnect;
import com.unipro.test.framework.Globals;
import com.unipro.test.framework.helpers.screenshot_helper.Screenshot;
import com.unipro.test.framework.helpers.utils.GenericWrappers;
	import com.unipro.test.framework.helpers.utils.ReadTestData;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

	public class Class {
		AddInventoryFormPage Class;
		Classfield icp;
		TerminalPage terPage;
        Screenshot scr;
		public  Class(Classfield icp) {
			this.icp = icp;
			terPage = new TerminalPage();
			scr =new Screenshot();
			Class = new AddInventoryFormPage();
		}
			
		@Then("I load the Class sheet data to map")
		public void i_load_the_Subcategory_sheet_data_to_map() {
			Globals.Inventory.ClassSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME9);
		}
		@Then("I load the rowise Class data for {string} rowname")
		public void i_load_the_rowise_Category_data_for_rowname(String row_name) {

			Globals.Inventory.ClassrowwiseData = ReadTestData
					.getRowFilteredValueFromTable(Globals.Inventory.ClassSheetData, row_name);

			System.out.println(Globals.Inventory.ClassSheetData);

		}

		@Then("I update value to the Class page global Variables")
		public void i_update_value_to_the_Subcategory_page_global_Variables() {
			Globals.Inventory.Classcode = Globals.Inventory.ClassrowwiseData.get("Classcode");
			Globals.Inventory.Description = Globals.Inventory.ClassrowwiseData.get("Description");
			
		
			
		}

		@Then("I fill new Class data page using excel data")
		public void i_fill_new_Subcategory_data_page_using_excel_data() throws Exception {
			try {
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Classcode)) {
				terPage.terminal_waitClearEnterText_css(icp.Classcode_string, Globals.Inventory.Classcode);
				

			}
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Description)) {
				terPage.terminal_waitClearEnterText_css(icp.Description_String, Globals.Inventory.Description);
			
			}
			
			File file = new File("/Users/macpc/Documents/GitHub/GopiTesting/testdata/sample inventory all.xlsx");
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook xs = new XSSFWorkbook(fis);
			XSSFSheet sh = xs.getSheet(Globals.Inventory.SHEETNAME1);
			int row= sh.getLastRowNum()+1;
			sh.createRow(row).createCell(3).setCellValue("passed");
			FileOutputStream fos = new FileOutputStream(file);
			xs.write(fos);
	}
	catch (Exception e) {
		// screen shot
		scr.Screenshots();
		System.out.println("Screen shot ");
		// Xl sheet write
		File file = new File("/Users/macpc/Documents/GitHub/GopiTesting/testdata/sample inventory all.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook xs = new XSSFWorkbook(fis);
		XSSFSheet sh = xs.getSheet(Globals.Inventory.SHEETNAME1);
		int row= sh.getLastRowNum()+1;
		sh.createRow(row).createCell(3).setCellValue("failed");
		FileOutputStream fos = new FileOutputStream(file);
		xs.write(fos);
		

	}

		}
		@Then("I close connection  DB for ClassMaster")
		public void I_close_connection_to_DB() throws SQLException {

			mysqlConnect.disconnect();
			System.out.println(" closed succesfully");

			// mysqlConnect.disconnect();

		}
		MssqlConnect mysqlConnect;
		Statement st;
		 
		@Then("I establish connection  DB for ClassMaster")
		public void I_establish_connection_to_DB() throws SQLException {

			mysqlConnect = new MssqlConnect();
			st = mysqlConnect.connect().createStatement();
			System.out.println(" Connected succesfully");

		}
		@Given("I read the values from Class table {string} in DB")
		public void i_want_to_launch_the(String tablename ) throws SQLException {
			
			
			ResultSet rs = st.executeQuery("select * from "+tablename+" where ClassCode='class'");
			
			System.out.println(rs);
			//ResultSet rs = st.executeQuery("");

			while (rs.next()) {

				switch (tablename) {
				
				case "tblclass":
					    String classCode = rs.getString("Description");
					    System.out.println(classCode);
					    Assert.assertEquals(Globals.Inventory.Description.trim(), classCode.trim());
					break;
				case "tblinventorypricing":
					String BasicSelling = rs.getString("BasicSelling");
					  System.out.println(BasicSelling);
					   Assert.assertEquals(Globals.Inventory.NetSellingPrice.trim(), BasicSelling.trim());
					 
					break;
				default:
					break;
				}}
			}
		
		
	}
