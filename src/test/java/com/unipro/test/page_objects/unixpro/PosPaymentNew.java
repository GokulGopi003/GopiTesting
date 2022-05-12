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

public class PosPaymentNew extends PageObject {
	pospaymentnewtypefield icp;
	TerminalPage terPage;
	AddInventoryFormPage Category;
	ExcelWrite pass;
	Screenshot scr;
	

	public PosPaymentNew(pospaymentnewtypefield icp) {
		this.icp = icp;
		terPage = new TerminalPage();
		Category = new AddInventoryFormPage();
		pass=new ExcelWrite();
		scr = new Screenshot();
	} 
	@Then("I load the POSPaymentNew sheet data to map")
	public void i_load_the_POSPaymentNew_sheet_data_to_map() {
		Globals.Inventory.POSPaymentNewSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME86);
	}

	@Then("I load the POSPaymentNew rowise  data for {string} rowname")
	public void i_load_the_POSPaymentNew_rowise_data_for_rowname(String row_name) {
		Globals.Inventory.POSPaymentNewrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.POSPaymentNewSheetData, row_name);

		System.out.println(Globals.Inventory.POSPaymentNewrowwiseData);
	}

	@Then("I update value to the POSPaymentNew page global Variables")
	public void i_update_value_to_the_POSPaymentNew_page_global_Variables() {
		Globals.Inventory.PaymentCode = Globals.Inventory.POSPaymentNewrowwiseData.get("paymentcode");
		Globals.Inventory.PaymentDesc = Globals.Inventory.POSPaymentNewrowwiseData.get("paymentdesc");
		Globals.Inventory.TransactionType = Globals.Inventory.POSPaymentNewrowwiseData.get("transactiontype");
	}

	@Then("I fill new POSPaymentNew data page using excel data")
	public void i_fill_new_POSPaymentNew_data_page_using_excel_data() throws Exception {
		try
		{
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.PaymentCode)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.PaymentCode_String, Globals.Inventory.PaymentCode);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.PaymentDesc)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.PaymentDesc_String, Globals.Inventory.PaymentDesc);
			
			
		}
if (GenericWrappers.isNotEmpty(Globals.Inventory.TransactionType)) {
			
			webDriver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlTranType_chzn']")).click();
			
			
			WebElement TransactionValue = webDriver
					.findElement(By.cssSelector("#ContentPlaceHolder1_ddlTranType_chzn > div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_ddlTranType_chzn > div > div > input[type=text]";
			By ddlocator = By.cssSelector(css_location_dropDownValue);
			waitForExpectedElement(ddlocator);
			js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.TransactionType);
			GenericWrappers.sleepInSeconds(1);
			TransactionValue.sendKeys(Keys.SPACE);
			TransactionValue.sendKeys(Keys.SPACE);
			TransactionValue.sendKeys(Keys.ARROW_DOWN);
			GenericWrappers.sleepInSeconds(1);
			TransactionValue.sendKeys(Keys.ENTER);
		}
		pass.ExcelFourData("pospaymentnew","Modules", "Actual", "Expected", "Status",
				0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
		pass.Excelcreate("pospaymentnew", "POSPaymentNew", "Pass", 1, 0, 1, 3);
		}
		catch(Exception e) {
			
			scr.Screenshots();
			System.out.println("Screen shot taken");
			
			pass.ExcelFourData("pospaymentnew","Modules", "Actual", "Expected", "Status",
					0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
			pass.Excelcreate("pospaymentnew", "POSPaymentNew", "FAIL", 1, 0, 1, 3);
			
		}
	}
	@Then("I close connection to POSPaymentNew")
	public void i_close_connection_to_POSPaymentNew() {
		mysqlConnect.disconnect();
		System.out.println(" closed succesfully");
	}

	MssqlConnect mysqlConnect;
	Statement st; 
	
	@Then("I establish connection to POSPaymentNew")
	public void i_establish_connection_to_POSPaymentNew() throws SQLException {
		mysqlConnect = new MssqlConnect();
		st = mysqlConnect.connect().createStatement();
		System.out.println(" Connected succesfully");
	}

	@Then("I read the values from table {string} in POSPaymentNew")
	public void i_read_the_values_from_table_in_POSPaymentNew(String tablename) throws SQLException, IOException {
		ResultSet rs = st.executeQuery("select * from " + tablename + " where PaymentCode='BILLVIEW'");

		System.out.println(rs);

		while (rs.next()) {

			switch (tablename) {
			case "tblPosPaymentSub":
				String PaymentCode = "";
				try {
					PaymentCode = rs.getString("PaymentCode");
					System.out.println(PaymentCode);
					Assert.assertEquals(Globals.Inventory.PaymentCode.trim(), PaymentCode.trim());
					pass.Excelcreate("pospaymentnew", "tblPosPaymentSub", "", 3, 1, 3, 2);
					pass.ExcelFourData("pospaymentnew", "PaymentCode", Globals.Inventory.PaymentCode, PaymentCode, "Pass", 4, 0, 4, 1,
							4, 2, 4, 3);
				} catch (AssertionError e) {
					pass.Excelcreate("pospaymentnew", "tblPosPaymentSub", "", 3, 1, 3, 2);
					pass.ExcelFourData("pospaymentnew", "PaymentCode", Globals.Inventory.PaymentCode, PaymentCode, "Fail", 4, 0, 4, 1,
							4, 2, 4, 3);

				}

				String PaymentDesc = "";
				try {
					PaymentDesc = rs.getString("PaymentDesc");
					System.out.println(PaymentDesc);
					Assert.assertEquals(Globals.Inventory.PaymentDesc.trim(), PaymentDesc.trim());

					pass.ExcelFourData("pospaymentnew", "PaymentDesc", Globals.Inventory.PaymentDesc, PaymentDesc, "Pass", 5, 0,
							5, 1, 5, 2, 5, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("pospaymentnew", "PaymentDesc", Globals.Inventory.PaymentDesc, PaymentDesc, "Fail", 5, 0,
							5, 1, 5, 2, 5, 3);

				}
				String TransactionType = "";
				try {
					TransactionType = rs.getString("TranType");
					System.out.println(TransactionType);
					Assert.assertEquals(Globals.Inventory.TransactionType.trim(), TransactionType.trim());

					pass.ExcelFourData("pospaymentnew", "TransactionType", Globals.Inventory.TransactionType, TransactionType, "Pass", 6, 0,
							6, 1, 6, 2, 6, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("pospaymentnew", "TransactionType", Globals.Inventory.TransactionType, TransactionType, "Fail", 6, 0,
							6, 1, 6, 2, 6, 3);

				}

	}

	
	}

	

	}


	}

	



