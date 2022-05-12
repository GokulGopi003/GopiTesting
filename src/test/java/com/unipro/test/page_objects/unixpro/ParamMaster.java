package com.unipro.test.page_objects.unixpro;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.Keys;
import org.testng.Assert;

import com.gk.test.MssqlConnect;
import com.unipro.ExcelWrite;
import com.unipro.test.framework.Globals;
import com.unipro.test.framework.PageObject;
import com.unipro.test.framework.helpers.screenshot_helper.Screenshot;
import com.unipro.test.framework.helpers.utils.GenericWrappers;
import com.unipro.test.framework.helpers.utils.ReadTestData;

import cucumber.api.java.en.Then;

public class ParamMaster extends PageObject {
	ParamMasterTypeField icp;
	TerminalPage terPage;
	AddInventoryFormPage Category;
	ExcelWrite pass;
	Screenshot scr;
	TerminalPage terpage;

	public ParamMaster(ParamMasterTypeField icp) {
		this.icp = icp;
		terPage = new TerminalPage();
		Category = new AddInventoryFormPage();
		pass=new ExcelWrite();
		scr = new Screenshot();

}
	@Then("I load the ParamMasterNew sheet data to map")
	public void i_load_the_ParamMasterNew_sheet_data_to_map() {
	
		Globals.Inventory.ParamMasterNewSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME92);
	}

	@Then("I load the ParamMasterNew rowise  data for {string} rowname")
	public void i_load_the_ParamMasterNew_rowise_data_for_rowname(String row_name) {
		
		
		Globals.Inventory.ParamMasterNewrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.ParamMasterNewSheetData, row_name);

		System.out.println(Globals.Inventory.ParamMasterNewrowwiseData);
	}

	@Then("I update value to the ParamMasterNew page global Variables")
	public void i_update_value_to_the_ParamMasterNew_page_global_Variables() {
		
		
		Globals.Inventory.ParamCode = Globals.Inventory.ParamMasterNewrowwiseData.get("paramcode");
		Globals.Inventory.Description = Globals.Inventory.ParamMasterNewrowwiseData.get("Description");
		Globals.Inventory.Value = Globals.Inventory.ParamMasterNewrowwiseData.get("Value");
		Globals.Inventory.CreatedBy = Globals.Inventory.ParamMasterNewrowwiseData.get("createdby");
	}

	@Then("I fill new ParamMasterNew data page using excel data")
	public void i_fill_new_ParamMasterNew_data_page_using_excel_data() throws Exception {
		
		try
		
		{
	
			/*	
		if (GenericWrappers.isNotEmpty(Globals.Inventory.ParamCode)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.ParamCode_String, Globals.Inventory.ParamCode);

		}*/	
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Description)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Description_String, Globals.Inventory.Description);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Value)) {
			terPage.get_checkBox_element_Xpath(icp.Value_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.CreatedBy)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Createdby_String, Globals.Inventory.CreatedBy);

		}
		pass.ExcelFourData("parammaster","Modules", "Actual", "Expected", "Status",
				0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
		pass.Excelcreate("parammaster", "parammaster", "Pass", 1, 0, 1, 3);
		}
		catch(Exception e) {
			
			scr.Screenshots();
			System.out.println("Screen shot taken");
			
			pass.ExcelFourData("parammaster","Modules", "Actual", "Expected", "Status",
					0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
			pass.Excelcreate("parammaster", "parammaster", "FAIL", 1, 0, 1, 3);
			
		}
	}
	@Then("I close connection to ParamMasterNew")
	public void i_close_connection_to_ParamMasterNew() {
		mysqlConnect.disconnect();
		System.out.println(" closed succesfully");
	}

	MssqlConnect mysqlConnect;
	Statement st; 
	
	@Then("I establish connection to ParamMasterNew")
	public void i_establish_connection_to_ParamMasterNew() throws SQLException {
		mysqlConnect = new MssqlConnect();
		st = mysqlConnect.connect().createStatement();
		System.out.println(" Connected succesfully");
	}

	@Then("I read the values from table {string} in ParamMasterNew")
	public void i_read_the_values_from_table_in_ParamMasterNew(String tablename) throws IOException, SQLException {
		ResultSet rs = st.executeQuery("select * from " + tablename + " where Description='ABC'");

		System.out.println(rs);

		while (rs.next()) {

			switch (tablename) {
			case "TBLPARAMMASTER":
				String ParamCode = "";
				try {
					ParamCode = rs.getString("ParamCode");
					System.out.println(ParamCode);
					Assert.assertEquals(Globals.Inventory.ParamCode.trim(), ParamCode.trim());
					pass.Excelcreate("parammaster", "TBLPARAMMASTER", "", 3, 1, 3, 2);
					pass.ExcelFourData("parammaster", "ParamCode", Globals.Inventory.ParamCode, ParamCode, "Pass", 4, 0, 4, 1,
							4, 2, 4, 3);
				} catch (AssertionError e) {
					pass.Excelcreate("parammaster", "TBLPARAMMASTER", "", 3, 1, 3, 2);
					pass.ExcelFourData("parammaster", "ParamCode", Globals.Inventory.ParamCode, ParamCode, "Fail", 4, 0, 4, 1,
							4, 2, 4, 3);

				}

				String Description = "";
				try {
					Description = rs.getString("Description");
					System.out.println(Description);
					Assert.assertEquals(Globals.Inventory.Description.trim(), Description.trim());

					pass.ExcelFourData("parammaster", "Description", Globals.Inventory.Description, Description, "Pass", 5, 0,
							5, 1, 5, 2, 5, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("parammaster", "Description", Globals.Inventory.Description, Description, "Fail", 5, 0,
							5, 1, 5, 2, 5, 3);

				}
				String CreatedBy = "";
				try {
					CreatedBy = rs.getString("CreatedBy");
					System.out.println(CreatedBy);
					Assert.assertEquals(Globals.Inventory.CreatedBy.trim(), CreatedBy.trim());

					pass.ExcelFourData("parammaster", "CreatedBy", Globals.Inventory.CreatedBy, CreatedBy, "Pass", 6, 0,
							6, 1, 6, 2, 6, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("parammaster", "CreatedBy", Globals.Inventory.CreatedBy, CreatedBy, "Fail", 6, 0,
							6, 1, 6, 2, 6, 3);

				}
				
	}

	
		}
	}
	}

	



