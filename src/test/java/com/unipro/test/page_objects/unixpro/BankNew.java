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

import cucumber.api.java.en.Then;

public class BankNew extends PageObject {
	Banknewtypefield icp;
	TerminalPage terPage;
	AddInventoryFormPage Category;
	ExcelWrite pass;
	Screenshot scr;
	TerminalPage terpage;

	public BankNew(Banknewtypefield icp) 
	{
		this.icp = icp;
		terPage = new TerminalPage();
		Category = new AddInventoryFormPage();
		pass=new ExcelWrite();
		scr = new Screenshot();
	}
	@Then("I load the BankNew sheet data to map")
	public void i_load_the_BankNew_sheet_data_to_map()
{
		Globals.Inventory.BankNewSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME80);

	}

	@Then("I load the BankNew rowise  data for {string} rowname")
	public void i_load_the_BankNew_rowise_data_for_rowname(String row_name) 
	{
		Globals.Inventory.BankNewrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.BankNewSheetData, row_name);
		System.out.println(Globals.Inventory.BankNewrowwiseData);
	}

	@Then("I update value to the BankNew page global Variables")
	public void i_update_value_to_the_BankNew_page_global_Variables() 
	{
		Globals.Inventory.BankCode = Globals.Inventory.BankNewrowwiseData.get("Bankcode");
		Globals.Inventory.BankName = Globals.Inventory.BankNewrowwiseData.get("Bankname");
		Globals.Inventory.Active = Globals.Inventory.BankNewrowwiseData.get("Active");
	}

	@Then("I fill new BankNew data page using excel data")
	public void i_fill_new_BankNew_data_page_using_excel_data() throws Exception 
	{
		try {
		if (GenericWrappers.isNotEmpty(Globals.Inventory.BankCode)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.BankCode_String, Globals.Inventory.BankCode);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.BankName)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.BankName_String, Globals.Inventory.BankName);
			webDriver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_txtBankName']"))
			.sendKeys(Keys.RETURN);
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Active)) {
			terPage.get_checkBox_element_Xpath(icp.Active_String).click();
		}
		
		pass.ExcelFourData("banknew","Modules", "Actual", "Expected", "Status",
				0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
		pass.Excelcreate("banknew", "Bank", "Pass", 1, 0, 1, 3);
		}
		catch(Exception e) {
			
			scr.Screenshots();
			System.out.println("Screen shot taken");
			
			pass.ExcelFourData("banknew","Bank", "Actual", "Expected", "Status",
					0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
			pass.Excelcreate("banknew", "Bank", "FAIL", 1, 0, 1, 3);
			
		}
		
		
		}
	@Then("I close connection to BankNew")
	public void I_close_connection_to_BankNew() throws SQLException {

		mysqlConnect.disconnect();
		System.out.println(" closed succesfully");

	}

	MssqlConnect mysqlConnect;
	Statement st;

	@Then("I establish connection to BankNew")
	public void i_establish_connection_to_BankNew() throws SQLException,IOException
	{
		mysqlConnect = new MssqlConnect();
		st = mysqlConnect.connect().createStatement();
		System.out.println(" Connected succesfully");

	}

	@Then("I read the values from table {string} in BankNew")
	public void i_read_the_values_from_table_in_BankNew(String tablename) throws SQLException, IOException {

		ResultSet rs = st.executeQuery("select * from " + tablename + " where BankName='AANDRA BANK'");

		System.out.println(rs);

		while (rs.next()) {

			switch (tablename) {
			case "tblBankCode":
				String BankCode = "";
				try {
					BankCode = rs.getString("BankCode");
					System.out.println(BankCode);
					Assert.assertEquals(Globals.Inventory.BankCode.trim(), BankCode.trim());
					pass.Excelcreate("banknew", "tblBankCode", "", 3, 1, 3, 2);
					pass.ExcelFourData("banknew", "BankCode", Globals.Inventory.BankCode, BankCode, "Pass", 4, 0, 4, 1,
							4, 2, 4, 3);
				} catch (AssertionError e) {
					pass.Excelcreate("banknew", "tblBankCode", "", 3, 1, 3, 2);
					pass.ExcelFourData("banknew", "BankCode", Globals.Inventory.BankCode, BankCode, "Fail", 4, 0, 4, 1,
							4, 2, 4, 3);

				}

				String BankName = "";
				try {
					BankName = rs.getString("BankName");
					System.out.println(BankName);
					Assert.assertEquals(Globals.Inventory.BankName.trim(), BankName.trim());

					pass.ExcelFourData("banknew", "BankName", Globals.Inventory.BankName, BankName, "Pass", 5, 0,
							5, 1, 5, 2, 5, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("banknew", "BankName", Globals.Inventory.BankName, BankName, "Fail", 5, 0,
							5, 1, 5, 2, 5, 3);

				}
				String Active = "";
				try {
					Active = rs.getString("Status");
					System.out.println(Active);
					Assert.assertEquals(Globals.Inventory.Active.trim(), Active.trim());

					pass.ExcelFourData("banknew", "Active", Globals.Inventory.Active, Active, "Pass", 6, 0,
							6, 1, 6, 2, 6, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("banknew", "Active", Globals.Inventory.Active, Active, "Fail", 6, 0,
							6, 1, 6, 2, 6, 3);

				}
			}
		}
	}
}
	



	
	


