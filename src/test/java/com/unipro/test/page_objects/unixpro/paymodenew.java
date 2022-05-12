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

public class paymodenew extends PageObject {
	paymodenewtypefield icp;
	TerminalPage terPage;
	AddInventoryFormPage Category;
	ExcelWrite pass;
	Screenshot scr;
	

	public paymodenew(paymodenewtypefield icp) {
		this.icp = icp;
		terPage = new TerminalPage();
		Category = new AddInventoryFormPage();
		pass=new ExcelWrite();
		scr = new Screenshot();
	} 
	
	@Then("I load the PaymodeNew sheet data to map")
	public void i_load_the_PaymodeNew_sheet_data_to_map() {
		Globals.Inventory.PaymodeNewSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME87);
	}

	@Then("I load the PaymodeNew rowise  data for {string} rowname")
	public void i_load_the_PaymodeNew_rowise_data_for_rowname(String row_name) {
		Globals.Inventory.PaymodeNewrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.PaymodeNewSheetData, row_name);

		System.out.println(Globals.Inventory.PaymodeNewrowwiseData);
	}

	@Then("I update value to the PaymodeNew page global Variables")
	public void i_update_value_to_the_PaymodeNew_page_global_Variables() {
		Globals.Inventory.Position = Globals.Inventory.PaymodeNewrowwiseData.get("position");
		Globals.Inventory.Paymode = Globals.Inventory.PaymodeNewrowwiseData.get("paymode");
		Globals.Inventory.Description = Globals.Inventory.PaymodeNewrowwiseData.get("Description");
		Globals.Inventory.Commission = Globals.Inventory.PaymodeNewrowwiseData.get("commission");
		Globals.Inventory.ServiceCharge = Globals.Inventory.PaymodeNewrowwiseData.get("charge");
		Globals.Inventory.GlAccountCode = Globals.Inventory.PaymodeNewrowwiseData.get("Accode");
		Globals.Inventory.Discount = Globals.Inventory.PaymodeNewrowwiseData.get("Discount");
		Globals.Inventory.Active = Globals.Inventory.PaymodeNewrowwiseData.get("Active");
		Globals.Inventory.Denamination = Globals.Inventory.PaymodeNewrowwiseData.get("Denamination");
	}

	@Then("I fill new PaymodeNew data page using excel data")
	public void i_fill_new_PaymodeNew_data_page_using_excel_data() throws Exception {
		try
		{
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Position)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Position_String, Globals.Inventory.Position);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Paymode)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Paymode_String, Globals.Inventory.Paymode);
			
			
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Description)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Description_String, Globals.Inventory.Description);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Commission)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Commission_String, Globals.Inventory.Commission);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.ServiceCharge)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.ServiceCharge_String, Globals.Inventory.ServiceCharge);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.GlAccountCode)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Glaccountcode_String, Globals.Inventory.GlAccountCode);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Discount)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Discount_String, Globals.Inventory.Discount);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Active)) {
			terPage.get_checkBox_element_Xpath(icp.Active_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Denamination)) {
			terPage.get_checkBox_element_Xpath(icp.Denamination_String).click();
		}

		pass.ExcelFourData("paymodenew","Modules", "Actual", "Expected", "Status",
				0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
		pass.Excelcreate("paymodenew", "paymode", "Pass", 1, 0, 1, 3);
		}
		catch(Exception e) {
			
			scr.Screenshots();
			System.out.println("Screen shot taken");
			
			pass.ExcelFourData("paymodenew","Modules", "Actual", "Expected", "Status",
					0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
			pass.Excelcreate("paymodenew", "paymode", "FAIL", 1, 0, 1, 3);
			
		}
	}
	@Then("I close connection to PaymodeNew")
	public void i_close_connection_to_PaymodeNew() {
		mysqlConnect.disconnect();
		System.out.println(" closed succesfully");

	}

	MssqlConnect mysqlConnect;
	Statement st;

	
	@Then("I establish connection to PaymodeNew")
	public void i_establish_connection_to_PaymodeNew() throws SQLException {
		mysqlConnect = new MssqlConnect();
		st = mysqlConnect.connect().createStatement();
		System.out.println(" Connected succesfully");
	}

	@Then("I read the values from table {string} in PaymodeNew")
	public void i_read_the_values_from_table_in_PaymodeNew(String tablename) throws SQLException, IOException {
		ResultSet rs = st.executeQuery("select * from " + tablename + " where Position='29'");

		System.out.println(rs);

		while (rs.next()) {

			switch (tablename) {
			case "tblPaymode":
				String Position = "";
				try {
					Position = rs.getString("Position");
					System.out.println(Position);
					Assert.assertEquals(Globals.Inventory.Position.trim(), Position.trim());
					 pass.Excelcreate("paymodenew", "tblPaymode", "", 2, 0, 2, 1);
					pass.ExcelFourData("paymodenew", "Position", Globals.Inventory.Position, Position, "Pass", 3, 0,
							3, 1, 3, 2, 3, 3);
				} catch (AssertionError e) {
					 pass.Excelcreate("paymodenew", "tblPaymode", "", 2, 0, 2, 1);
					pass.ExcelFourData("paymodenew", "Position", Globals.Inventory.Position, Position, "Fail", 3, 0,
							3, 1, 3, 2, 3, 3);

				}
				String Paymode = "";
				try {
					Paymode = rs.getString("Paymode");
					System.out.println(Paymode);
					Assert.assertEquals(Globals.Inventory.Paymode.trim(), Paymode.trim());

					pass.ExcelFourData("paymodenew", "Paymode", Globals.Inventory.Paymode, Paymode, "Pass", 4, 0, 4, 1, 4, 2,
							4, 3);
				} catch (AssertionError e) {

					pass.ExcelFourData("paymodenew", "Paymode", Globals.Inventory.Paymode, Paymode, "Fail", 4, 0, 4, 1, 4, 2,
							4, 3);

				}

				String Description = "";
				try {
					Description = rs.getString("Description");
					System.out.println(Description);
					Assert.assertEquals(Globals.Inventory.Description.trim(), Description.trim());

					pass.ExcelFourData("paymodenew", "Description", Globals.Inventory.Description, Description, "Pass", 5, 0, 5,
							1, 5, 2, 5, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("paymodenew", "Description", Globals.Inventory.Description, Description, "Fail", 5, 0, 5,
							1, 5, 2, 5, 3);

				}

				String Commission = "";
				try {
					Commission = rs.getString("Commission");
					System.out.println(Commission);
					Assert.assertEquals(Globals.Inventory.Commission.trim(), Commission.trim());

					pass.ExcelFourData("paymodenew", "Commission", Globals.Inventory.Commission, Commission, "Pass", 6, 0,
							6, 1, 6, 2, 6, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("paymodenew", "Commission", Globals.Inventory.Commission, Commission, "Fail", 6, 0,
							6, 1, 6, 2, 6, 3);

				}
				String ServiceCharge = "";
				try {
					ServiceCharge = rs.getString("ServiceCharge");
					System.out.println(ServiceCharge);
					Assert.assertEquals(Globals.Inventory.ServiceCharge.trim(), ServiceCharge.trim());

					pass.ExcelFourData("paymodenew", "ServiceCharge", Globals.Inventory.ServiceCharge, ServiceCharge, "Pass", 7, 0, 7, 1, 7,
							2, 7, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("paymodenew", "ServiceCharge", Globals.Inventory.ServiceCharge, ServiceCharge, "Fail", 7, 0, 7, 1, 7,
							2, 7, 3);

				}
				String GlAccountCode = "";
				try {
					GlAccountCode = rs.getString("GlAccountCode");
					System.out.println(GlAccountCode);
					Assert.assertEquals(Globals.Inventory.GlAccountCode.trim(), GlAccountCode.trim());

					pass.ExcelFourData("paymodenew", "GlAccountCode", Globals.Inventory.GlAccountCode, GlAccountCode, "Pass", 8, 0,
							8, 1, 8, 2, 8, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("paymodenew", "GlAccountCode", Globals.Inventory.GlAccountCode, GlAccountCode, "Fail", 8, 0,
							8, 1, 8, 2, 8, 3);

				}
				String Discount = "";
				try {
					Discount = rs.getString("Discount");
					System.out.println(Discount);
					Assert.assertEquals(Globals.Inventory.Discount.trim(), Discount.trim());

					pass.ExcelFourData("paymodenew", "Discount", Globals.Inventory.Discount, Discount, "Pass", 9, 0, 9,
							1, 9, 2, 9, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("paymodenew", "Discount", Globals.Inventory.Discount, Discount, "Fail", 9, 0, 9,
							1, 9, 2, 9, 3);

				}
				String Active = "";
				try {
					Active = rs.getString("Active");
					System.out.println(Active);
					Assert.assertEquals(Globals.Inventory.Active.trim(), Active.trim());

					pass.ExcelFourData("paymodenew", "Active", Globals.Inventory.Active, Active, "Pass", 10, 0, 10,
							1, 10, 2, 10, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("paymodenew", "Active", Globals.Inventory.Active, Active, "Fail", 10, 0, 10,
							1, 10, 2, 10, 3);

				}
				String Denamination = "";
				try {
					Denamination = rs.getString("Denamination");
					System.out.println(Denamination);
					Assert.assertEquals(Globals.Inventory.Denamination.trim(), Denamination.trim());

					pass.ExcelFourData("paymodenew", "Denamination", Globals.Inventory.Denamination, Denamination, "Pass", 11, 0, 11,
							1, 11, 2, 11, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("paymodenew", "Denamination", Globals.Inventory.Denamination, Denamination, "Fail", 11, 0, 11,
							1, 11, 2, 11, 3);

				}
				
	}

	


}
	}
}
