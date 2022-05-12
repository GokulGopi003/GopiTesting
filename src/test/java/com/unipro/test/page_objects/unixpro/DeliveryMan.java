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

public class DeliveryMan extends PageObject {
	Deliverymantypefield icp;
	TerminalPage terPage;
	AddInventoryFormPage Category;
	ExcelWrite pass;
	Screenshot scr;
	

	public DeliveryMan(Deliverymantypefield icp) {
		this.icp = icp;
		terPage = new TerminalPage();
		Category = new AddInventoryFormPage();
		pass=new ExcelWrite();
		scr = new Screenshot();
	}

	@Then("I load the DeliveryManNew sheet data to map")
	public void i_load_the_DeliveryManNew_sheet_data_to_map() {
		Globals.Inventory.DeliveryManNewSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME82);
	}

	@Then("I load the DeliveryManNew rowise  data for {string} rowname")
	public void i_load_the_DeliveryManNew_rowise_data_for_rowname(String row_name) {
		Globals.Inventory.DeliveryManNewrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.DeliveryManNewSheetData, row_name);

		System.out.println(Globals.Inventory.DeliveryManNewrowwiseData);
	}

	@Then("I update value to the DeliveryManNew page global Variables")
	public void i_update_value_to_the_DeliveryManNew_page_global_Variables() {
		Globals.Inventory.DeliveryManId = Globals.Inventory.DeliveryManNewrowwiseData.get("Deliverymanid");
		Globals.Inventory.DeliveryMan = Globals.Inventory.DeliveryManNewrowwiseData.get("Name");
		Globals.Inventory.Active = Globals.Inventory.DeliveryManNewrowwiseData.get("Active");
	}

	@Then("I fill new DeliveryManNew data page using excel data")
	public void i_fill_new_DeliveryManNew_data_page_using_excel_data() throws Exception {
		try
		{
		if (GenericWrappers.isNotEmpty(Globals.Inventory.DeliveryManId)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.deliverymanid_String, Globals.Inventory.DeliveryManId);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.DeliveryMan)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.deliveryName_String, Globals.Inventory.DeliveryMan);
			webDriver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_txtDeliveryManName']"))
			.sendKeys(Keys.RETURN);
		}
			
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Active)) {
			terPage.get_checkBox_element_Xpath(icp.Active_String).click();
		}
		pass.ExcelFourData("deliverymannew","Modules", "Actual", "Expected", "Status",
				0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
		pass.Excelcreate("deliverymannew", "DeliveryMan", "Pass", 1, 0, 1, 3);
		}
		catch(Exception e) {
			
			scr.Screenshots();
			System.out.println("Screen shot taken");
			
			pass.ExcelFourData("deliverymannew","DeliveryMan", "Actual", "Expected", "Status",
					0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
			pass.Excelcreate("deliverymannew", "DeliveryMan", "FAIL", 1, 0, 1, 3);
			
		}
	}
	@Then("I close connection to DeliveryManNew")
	public void i_close_connection_to_DeliveryManNew() {
		mysqlConnect.disconnect();
		System.out.println(" closed succesfully");
	}

	MssqlConnect mysqlConnect;
	Statement st;
	@Then("I establish connection to DeliveryManNew")
	public void i_establish_connection_to_DeliveryManNew() throws SQLException {
		mysqlConnect = new MssqlConnect();
		st = mysqlConnect.connect().createStatement();
		System.out.println(" Connected succesfully");
	}

	@Then("I read the values from table {string} in DeliveryManNew")
	public void i_read_the_values_from_table_in_DeliveryManNew(String tablename) throws SQLException, IOException {
		ResultSet rs = st.executeQuery("select * from " + tablename + " where DeliveryManId='10'");

		System.out.println(rs);

		while (rs.next()) {

			switch (tablename) {
			case "tblDeliveryMan":
				String DeliveryManId = "";
				try {
					DeliveryManId = rs.getString("DeliveryManId");
					System.out.println(DeliveryManId);
					Assert.assertEquals(Globals.Inventory.DeliveryManId.trim(), DeliveryManId.trim());
					pass.Excelcreate("deliverymannew", "tblDeliveryMan", "", 3, 1, 3, 2);
					pass.ExcelFourData("deliverymannew", "DeliveryManId", Globals.Inventory.DeliveryManId, DeliveryManId, "Pass", 4, 0, 4, 1,
							4, 2, 4, 3);
				} catch (AssertionError e) {
					pass.Excelcreate("deliverymannew", "tblDeliveryMan", "", 3, 1, 3, 2);
					pass.ExcelFourData("deliverymannew", "DeliveryManId", Globals.Inventory.DeliveryManId, DeliveryManId, "Fail", 4, 0, 4, 1,
							4, 2, 4, 3);

				}

				String DeliveryMan = "";
				try {
					DeliveryMan = rs.getString("DeliveryManName");
					System.out.println(DeliveryMan);
					Assert.assertEquals(Globals.Inventory.DeliveryMan.trim(), DeliveryMan.trim());

					pass.ExcelFourData("deliverymannew", "DeliveryMan", Globals.Inventory.DeliveryMan, DeliveryMan, "Pass", 5, 0,
							5, 1, 5, 2, 5, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("deliverymannew", "DeliveryMan", Globals.Inventory.DeliveryMan, DeliveryMan, "Fail", 5, 0,
							5, 1, 5, 2, 5, 3);

				}
				String Active = "";
				try {
					Active = rs.getString("Active");
					System.out.println(Active);
					Assert.assertEquals(Globals.Inventory.Active.trim(), Active.trim());

					pass.ExcelFourData("deliverymannew", "Active", Globals.Inventory.Active, Active, "Pass", 6, 0,
							6, 1, 6, 2, 6, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("deliverymannew", "Active", Globals.Inventory.Active, Active, "Fail", 6, 0,
							6, 1, 6, 2, 6, 3);

				}


	}

	


}
}
}
