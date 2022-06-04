package com.unipro.test.page_objects.unixpro;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;

import com.gk.test.MssqlConnect;
import com.unipro.ExcelWrite;
import com.unipro.test.framework.Globals;
import com.unipro.test.framework.PageObject;
import com.unipro.test.framework.helpers.screenshot_helper.Screenshot;
import com.unipro.test.framework.helpers.utils.GenericWrappers;
import com.unipro.test.framework.helpers.utils.ReadTestData;

import cucumber.api.java.en.Then;

public class BarcodeMaster extends PageObject {
	Barcodemasternewtypefield icp;
	TerminalPage terPage;
	AddInventoryFormPage Category;
	ExcelWrite pass;
	Screenshot scr;
	

	public BarcodeMaster(Barcodemasternewtypefield icp) {
		this.icp = icp;
		terPage = new TerminalPage();
		Category = new AddInventoryFormPage();
		pass=new ExcelWrite();
		scr = new Screenshot();

}
	@Then("I load the BarCodePrinterNew sheet data to map")
	public void i_load_the_BarCodePrinterNew_sheet_data_to_map() {
		Globals.Inventory.BarCodePrinterNewSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME90);
	}

	@Then("I load the BarCodePrinterNew rowise  data for {string} rowname")
	public void i_load_the_BarCodePrinterNew_rowise_data_for_rowname(String row_name) {
		Globals.Inventory.BarCodePrinterNewrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.BarCodePrinterNewSheetData, row_name);

		System.out.println(Globals.Inventory.BarCodePrinterNewrowwiseData);

	}

	@Then("I update value to the BarCodePrinterNew page global Variables")
	public void i_update_value_to_the_BarCodePrinterNew_page_global_Variables() {
		Globals.Inventory.PrinterCode = Globals.Inventory.BarCodePrinterNewrowwiseData.get("printercode");
		Globals.Inventory.Printername = Globals.Inventory.BarCodePrinterNewrowwiseData.get("Name");
	}

	@Then("I fill new BarCodePrinterNew data page using excel data")
	public void i_fill_new_BarCodePrinterNew_data_page_using_excel_data() throws Exception {
		try
		{
		if (GenericWrappers.isNotEmpty(Globals.Inventory.PrinterCode)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Printercode_String, Globals.Inventory.PrinterCode);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Printername)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.PrinterName_String, Globals.Inventory.Printername);
			
			
		}
		pass.ExcelFourData("barcodeprinter","Modules", "Actual", "Expected", "Status",
				0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
		pass.Excelcreate("barcodeprinter", "VehicleMaster", "Pass", 1, 0, 1, 3);
		}
		catch(Exception e) {
			
			scr.Screenshots();
			System.out.println("Screen shot taken");
			
			pass.ExcelFourData("barcodeprinter","Modules", "Actual", "Expected", "Status",
					0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
			pass.Excelcreate("barcodeprinter", "VehicleMaster", "FAIL", 1, 0, 1, 3);
			
		}
	}
	@Then("I close connection to BarCodePrinterNew")
	public void i_close_connection_to_BarCodePrinterNew() {
		mysqlConnect.disconnect();
		System.out.println(" closed succesfully");
	}

	MssqlConnect mysqlConnect;
	Statement st; 
	
	
	@Then("I establish connection to BarCodePrinterNew")
	public void i_establish_connection_to_BarCodePrinterNew() throws SQLException {
		mysqlConnect = new MssqlConnect();
		st = mysqlConnect.connect().createStatement();
		System.out.println(" Connected succesfully");
	}

	@Then("I read the values from table {string} in BarCodePrinterNew")
	public void i_read_the_values_from_table_in_BarCodePrinterNew(String tablename) throws SQLException, IOException {
		ResultSet rs = st.executeQuery("select * from " + tablename + " where PrintCode='7686'");

		System.out.println(rs);

		while (rs.next()) {

			switch (tablename) {
			case "tblPrinterMaster":
				String PrinterCode = "";
				try {
					PrinterCode = rs.getString("PrintCode");
					System.out.println(PrinterCode);
					Assert.assertEquals(Globals.Inventory.PrinterCode.trim(), PrinterCode.trim());
					pass.Excelcreate("barcodeprinter", "tblPrinterMaster", "", 3, 1, 3, 2);
					pass.ExcelFourData("barcodeprinter", "PrinterCode", Globals.Inventory.PrinterCode, PrinterCode, "Pass", 4, 0, 4, 1,
							4, 2, 4, 3);
				} catch (AssertionError e) {
					pass.Excelcreate("barcodeprinter", "tblPrinterMaster", "", 3, 1, 3, 2);
					pass.ExcelFourData("barcodeprinter", "PrinterCode", Globals.Inventory.PrinterCode, PrinterCode, "Fail", 4, 0, 4, 1,
							4, 2, 4, 3);

				}

				String Printername = "";
				try {
					Printername = rs.getString("PrinterName");
					System.out.println(Printername);
					Assert.assertEquals(Globals.Inventory.Printername.trim(), Printername.trim());

					pass.ExcelFourData("barcodeprinter", "Printername", Globals.Inventory.Printername, Printername, "Pass", 5, 0,
							5, 1, 5, 2, 5, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("barcodeprinter", "Printername", Globals.Inventory.Printername, Printername, "Fail", 5, 0,
							5, 1, 5, 2, 5, 3);

				}
	}

	
		}
	}
	




}
