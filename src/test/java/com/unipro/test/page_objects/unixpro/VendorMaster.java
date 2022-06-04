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
import com.unipro.test.framework.helpers.utils.GenericWrappers;
import com.unipro.test.framework.helpers.utils.ReadTestData;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class VendorMaster extends PageObject {
	vendormastertypefield icp;
	TerminalPage terPage;
	AddInventoryFormPage Category;
	ExcelWrite pass;
	TerminalPage terpage;
	public VendorMaster(vendormastertypefield icp) {
		this.icp = icp;
		terPage = new TerminalPage();
		Category = new AddInventoryFormPage();
		pass = new ExcelWrite();
		terpage=new TerminalPage();
	}

	@Then("I load the VendorMaster sheet data to map")
	public void i_load_the_VendorMaster_sheet_data_to_map() {
		Globals.Inventory.VendorMasterSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME93);
	}

	@Then("I load the VendorMaster rowise  data for {string} rowname")
	public void i_load_the_VendorMaster_rowise_data_for_rowname(String row_name) {
		Globals.Inventory.VendorMasterrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.VendorMasterSheetData, row_name);

		System.out.println(Globals.Inventory.VendorMasterrowwiseData);

	}

	@Then("I update value to the VendorMaster page global Variables")
	public void i_update_value_to_the_VendorMaster_page_global_Variables() {
		Globals.Inventory.Vendor = Globals.Inventory.VendorMasterrowwiseData.get("VendorName");
		Globals.Inventory.Address1 = Globals.Inventory.VendorMasterrowwiseData.get("Address1");
		Globals.Inventory.Address2 = Globals.Inventory.VendorMasterrowwiseData.get("Address2");
		Globals.Inventory.City = Globals.Inventory.VendorMasterrowwiseData.get("City");
		Globals.Inventory.ZipCode = Globals.Inventory.VendorMasterrowwiseData.get("ZipCode");
		Globals.Inventory.MobileNo = Globals.Inventory.VendorMasterrowwiseData.get("MobileNo");
		Globals.Inventory.State = Globals.Inventory.VendorMasterrowwiseData.get("State");
		Globals.Inventory.PhoneNo = Globals.Inventory.VendorMasterrowwiseData.get("PhoneNo");
		Globals.Inventory.Country = Globals.Inventory.VendorMasterrowwiseData.get("Country");
		Globals.Inventory.Email = Globals.Inventory.VendorMasterrowwiseData.get("Email");
		Globals.Inventory.URL = Globals.Inventory.VendorMasterrowwiseData.get("URL");
		Globals.Inventory.PurchaseLimit = Globals.Inventory.VendorMasterrowwiseData.get("PurchaseLimit");
		Globals.Inventory.Attn = Globals.Inventory.VendorMasterrowwiseData.get("Attn");
		Globals.Inventory.PurchaseProfit = Globals.Inventory.VendorMasterrowwiseData.get("PurchaseProfit");
		Globals.Inventory.SellingMargin = Globals.Inventory.VendorMasterrowwiseData.get("SellingMargin");
		Globals.Inventory.Remarks = Globals.Inventory.VendorMasterrowwiseData.get("Remarks");
		Globals.Inventory.PORemarks = Globals.Inventory.VendorMasterrowwiseData.get("PORemarks");
		Globals.Inventory.ChequePrintName = Globals.Inventory.VendorMasterrowwiseData.get("ChequePrintName");
		Globals.Inventory.BankCode = Globals.Inventory.VendorMasterrowwiseData.get("BankCode");
		Globals.Inventory.BankACNo = Globals.Inventory.VendorMasterrowwiseData.get("BankACNo");
		Globals.Inventory.GSTTIN = Globals.Inventory.VendorMasterrowwiseData.get("GSTTIN");
		Globals.Inventory.IFSCCode = Globals.Inventory.VendorMasterrowwiseData.get("IFSCCode");
		Globals.Inventory.HoldBills = Globals.Inventory.VendorMasterrowwiseData.get("HoldBills");
		Globals.Inventory.HoldBill = Globals.Inventory.VendorMasterrowwiseData.get("HoldBill");
		Globals.Inventory.CrLimit = Globals.Inventory.VendorMasterrowwiseData.get("CrLimit");
		Globals.Inventory.CRLIMIT = Globals.Inventory.VendorMasterrowwiseData.get("CRLIMIT");
		Globals.Inventory.CrDays = Globals.Inventory.VendorMasterrowwiseData.get("CrDays");
		Globals.Inventory.StopPayment = Globals.Inventory.VendorMasterrowwiseData.get("StopPayment");
		Globals.Inventory.StopPurchase = Globals.Inventory.VendorMasterrowwiseData.get("StopPurchase");
		Globals.Inventory.StopReason = Globals.Inventory.VendorMasterrowwiseData.get("StopReason");
		Globals.Inventory.Sunday = Globals.Inventory.VendorMasterrowwiseData.get("Sunday");
		Globals.Inventory.Monday = Globals.Inventory.VendorMasterrowwiseData.get("Monday");
		Globals.Inventory.Tuesday = Globals.Inventory.VendorMasterrowwiseData.get("Tuesday");
		Globals.Inventory.Wednesday = Globals.Inventory.VendorMasterrowwiseData.get("Wednesday");
		Globals.Inventory.Thursday = Globals.Inventory.VendorMasterrowwiseData.get("Thursday");
		Globals.Inventory.Friday = Globals.Inventory.VendorMasterrowwiseData.get("Friday");
		Globals.Inventory.Saturday=Globals.Inventory.VendorMasterrowwiseData.get("Saturday");

		
	}

	@Then("I fill new VendorMaster data page using excel data")
	public void i_fill_new_VendorMaster_data_page_using_excel_data() {
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Vendor)) {
			terPage.terminal_waitClearEnterText_css(icp.VendorName_String, Globals.Inventory.Vendor);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Address1)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Address1_String, Globals.Inventory.Address1);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Address2)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Address2_String, Globals.Inventory.Address2);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.City)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.City_String, Globals.Inventory.City);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.ZipCode)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.ZipCode_String, Globals.Inventory.ZipCode);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.MobileNo)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.MobileNo_String, Globals.Inventory.MobileNo);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.State)) {// *[@id="ContentPlaceHolder1_ddlState_chzn"]
			GenericWrappers.sleepInSeconds(1);
			webDriver.findElement(By.cssSelector("div#ContentPlaceHolder1_ddlState_chzn")).click();
			GenericWrappers.sleepInSeconds(1);

			WebElement StateValue = webDriver
					.findElement(By.cssSelector("#ContentPlaceHolder1_ddlState_chzn > div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_ddlState_chzn > div > div > input[type=text]";
			By ddlocator = By.cssSelector(css_location_dropDownValue);
			waitForExpectedElement(ddlocator);
			js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.State);
			GenericWrappers.sleepInSeconds(1);
			StateValue.sendKeys(Keys.SPACE);
			StateValue.sendKeys(Keys.SPACE);
			StateValue.sendKeys(Keys.ARROW_DOWN);
			GenericWrappers.sleepInSeconds(1);
			StateValue.sendKeys(Keys.ENTER);

		}

		if (GenericWrappers.isNotEmpty(Globals.Inventory.PhoneNo)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.PhoneNo_String, Globals.Inventory.PhoneNo);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Country)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Country_String, Globals.Inventory.Country);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Email)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Email_String, Globals.Inventory.Email);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.URL)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.URL_String, Globals.Inventory.URL);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.PurchaseLimit)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.PurchaseLimit_String, Globals.Inventory.PurchaseLimit);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Attn)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Attn_String, Globals.Inventory.Attn);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.PurchaseProfit)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.PurchaseProfit_String, Globals.Inventory.PurchaseProfit);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.SellingMargin)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.SellingMargin_String, Globals.Inventory.SellingMargin);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Remarks)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Remarks_String, Globals.Inventory.Remarks);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.PORemarks)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.PORemarks_String, Globals.Inventory.PORemarks);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.ChequePrintName)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.ChequePrintName_String, Globals.Inventory.ChequePrintName);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.BankCode)) {
			GenericWrappers.sleepInSeconds(1);
			webDriver.findElement(By.cssSelector("div#ContentPlaceHolder1_ddlBankCode_chzn")).click();
			GenericWrappers.sleepInSeconds(1);
			WebElement BankCodeValue = webDriver.findElement(
					By.cssSelector("#ContentPlaceHolder1_ddlBankCode_chzn >  div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_ddlBankCode_chzn > div > div > input[type=text]";
			By ddlocator = By.cssSelector(css_location_dropDownValue);
			waitForExpectedElement(ddlocator);
			js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.BankCode);
			GenericWrappers.sleepInSeconds(1);
			BankCodeValue.sendKeys(Keys.SPACE);
			BankCodeValue.sendKeys(Keys.SPACE);
			BankCodeValue.sendKeys(Keys.ARROW_DOWN);
			GenericWrappers.sleepInSeconds(1);
			BankCodeValue.sendKeys(Keys.ENTER);

		}
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.BankACNo)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.BankACNo_String, Globals.Inventory.BankACNo);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.GSTTIN)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.GSTTIN_String, Globals.Inventory.GSTTIN);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.IFSCCode)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.IFSCCode_String, Globals.Inventory.IFSCCode);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.HoldBills)) {
			terPage.get_checkBox_element_Xpath(icp.HoldBills_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.HoldBill)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.HoldBill_String, Globals.Inventory.HoldBill);

		}
		/*if (GenericWrappers.isNotEmpty(Globals.Inventory.CrLimit)) {
			terPage.get_checkBox_element_Xpath(icp.CrLimit_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.CRLIMIT)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.CRLIMIT_String, Globals.Inventory.CRLIMIT);

		}*/
		if (GenericWrappers.isNotEmpty(Globals.Inventory.CrDays)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.crDays_String, Globals.Inventory.CrDays);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.StopPayment)) {
			terPage.get_checkBox_element_Xpath(icp.StopPayment_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.StopPurchase)) {
			terPage.get_checkBox_element_Xpath(icp.StopPurchase_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.StopReason)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.StopReason_String, Globals.Inventory.StopReason);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Sunday)) {
			terPage.get_checkBox_element_Xpath(icp.Sunday_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Monday)) {
			terPage.get_checkBox_element_Xpath(icp.Monday_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Tuesday)) {
			terPage.get_checkBox_element_Xpath(icp.Tuesday_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Wednesday)) {
			terPage.get_checkBox_element_Xpath(icp.Wednesday_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Thursday)) {
			terPage.get_checkBox_element_Xpath(icp.Thursday_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Friday)) {
			terPage.get_checkBox_element_Xpath(icp.Friday_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Saturday)) {
			terPage.get_checkBox_element_Xpath(icp.Saturday_String).click();
		}

	
	}
	@Then("I close connection to VendorMaster")
	public void I_close_connection_to_VendorMaster() throws SQLException {

		mysqlConnect.disconnect();
		System.out.println(" closed succesfully");

	}

	MssqlConnect mysqlConnect;
	Statement st;

	@Then("I establish connection to VendorMaster")
	public void I_establish_connection_to_VendorMaster() throws SQLException {

		mysqlConnect = new MssqlConnect();
		st = mysqlConnect.connect().createStatement();
		System.out.println(" Connected succesfully");

	}

	@Given("I read the values from table {string} in VendorMaster")
	public void i_want_to_launch_the(String tablename) throws SQLException, IOException {

		ResultSet rs = st.executeQuery("select * from " + tablename + " where VendorName='Rajesh123'");

		System.out.println(rs);

		while (rs.next()) {

			switch (tablename) {
			case "tblvendor":
				String Vendor = "";
				try {
					Vendor = rs.getString("VendorName");
					System.out.println(Vendor);
					Assert.assertEquals(Globals.Inventory.Vendor.trim(), Vendor.trim());
					pass.Excelcreate("vendormaster", "tblvendor", "", 0, 1, 0, 2);
					pass.ExcelFourData("vendormaster", "Vendor", Globals.Inventory.Vendor, Vendor, "Pass", 1, 0, 1, 1,
							1, 2, 1, 3);
				} catch (AssertionError e) {
					pass.Excelcreate("vendormaster", "tblvendor", "", 0, 1, 0, 2);
					pass.ExcelFourData("vendormaster", "Vendor", Globals.Inventory.Vendor, Vendor, "Fail", 1, 0, 1, 1,
							1, 2, 1, 3);

				}

				String Address1 = "";
				try {
					Address1 = rs.getString("Address1");
					System.out.println(Address1);
					Assert.assertEquals(Globals.Inventory.Address1.trim(), Address1.trim());

					pass.ExcelFourData("vendormaster", "Address1", Globals.Inventory.Address1, Address1, "Pass", 2, 0,
							2, 1, 2, 2, 2, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("vendormaster", "Address1", Globals.Inventory.Address1, Address1, "Fail", 2, 0,
							2, 1, 2, 2, 2, 3);

				}
				String Address2 = "";
				try {
					Address2 = rs.getString("Address2");
					System.out.println(Address2);
					Assert.assertEquals(Globals.Inventory.Address2.trim(), Address2.trim());
					// pass.Excelcreate("style", "tblInventoryStyle", "", 1, 0, 1, 1);
					pass.ExcelFourData("vendormaster", "Address2", Globals.Inventory.Address2, Address2, "Pass", 3, 0,
							3, 1, 3, 2, 3, 3);
				} catch (AssertionError e) {
					// pass.Excelcreate("style", "tblInventoryStyle", "", 1, 0, 1, 1);
					pass.ExcelFourData("vendormaster", "Address2", Globals.Inventory.Address2, Address2, "Fail", 3, 0,
							3, 1, 3, 2, 3, 3);

				}
				String City = "";
				try {
					City = rs.getString("City");
					System.out.println(City);
					Assert.assertEquals(Globals.Inventory.City.trim(), City.trim());

					pass.ExcelFourData("vendormaster", "City", Globals.Inventory.City, City, "Pass", 4, 0, 4, 1, 4, 2,
							4, 3);
				} catch (AssertionError e) {

					pass.ExcelFourData("vendormaster", "City", Globals.Inventory.City, City, "Fail", 4, 0, 4, 1, 4, 2,
							4, 3);

				}

				String ZipCode = "";
				try {
					ZipCode = rs.getString("ZipCode");
					System.out.println(ZipCode);
					Assert.assertEquals(Globals.Inventory.ZipCode.trim(), ZipCode.trim());

					pass.ExcelFourData("vendormaster", "ZipCode", Globals.Inventory.ZipCode, ZipCode, "Pass", 5, 0, 5,
							1, 5, 2, 5, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("vendormaster", "ZipCode", Globals.Inventory.ZipCode, ZipCode, "Fail", 5, 0, 5,
							1, 5, 2, 5, 3);

				}

				String MobileNo = "";
				try {
					MobileNo = rs.getString("MobileNo");
					System.out.println(MobileNo);
					Assert.assertEquals(Globals.Inventory.MobileNo.trim(), MobileNo.trim());

					pass.ExcelFourData("vendormaster", "MobileNo", Globals.Inventory.MobileNo, MobileNo, "Pass", 6, 0,
							6, 1, 6, 2, 6, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("vendormaster", "MobileNo", Globals.Inventory.MobileNo, MobileNo, "Fail", 6, 0,
							6, 1, 6, 2, 6, 3);

				}
				String State = "";
				try {
					State = rs.getString("VendorState");
					System.out.println(State);
					Assert.assertEquals(Globals.Inventory.State.trim(), State.trim());

					pass.ExcelFourData("vendormaster", "State", Globals.Inventory.State, State, "Pass", 7, 0, 7, 1, 7,
							2, 7, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("vendormaster", "State", Globals.Inventory.State, State, "Fail", 7, 0, 7, 1, 7,
							2, 7, 3);

				}
				String PhoneNo = "";
				try {
					PhoneNo = rs.getString("Phone");
					System.out.println(PhoneNo);
					Assert.assertEquals(Globals.Inventory.PhoneNo.trim(), PhoneNo.trim());

					pass.ExcelFourData("vendormaster", "PhoneNo", Globals.Inventory.PhoneNo, PhoneNo, "Pass", 8, 0,
							8, 1, 8, 2, 8, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("vendormaster", "PhoneNo", Globals.Inventory.PhoneNo, PhoneNo, "Fail", 8, 0,
							8, 1, 8, 2, 8, 3);

				}
				String Country = "";
				try {
					Country = rs.getString("Country");
					System.out.println(Country);
					Assert.assertEquals(Globals.Inventory.Country.trim(), Country.trim());

					pass.ExcelFourData("vendormaster", "Country", Globals.Inventory.Country, Country, "Pass", 9, 0, 9,
							1, 9, 2, 9, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("vendormaster", "Country", Globals.Inventory.Country, Country, "Fail", 9, 0, 9,
							1, 9, 2, 9, 3);

				}
				String Email = "";
				try {
					Email = rs.getString("Email");
					System.out.println(Email);
					Assert.assertEquals(Globals.Inventory.Email.trim(), Email.trim());

					pass.ExcelFourData("vendormaster", "Email", Globals.Inventory.Email, Email, "pass", 11, 0, 11, 1,
							11, 2, 11, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("vendormaster", "Email", Globals.Inventory.Email, Email, "Fail", 11, 0, 11, 1,
							11, 2, 11, 3);

				}
				String URL = "";
				try {
					URL = rs.getString("Url");
					System.out.println(URL);
					Assert.assertEquals(Globals.Inventory.URL.trim(), URL.trim());

					pass.ExcelFourData("vendormaster", "URL", Globals.Inventory.URL, URL, "Pass", 12, 0, 12, 1,
							12, 2, 12, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("vendormaster", "URL", Globals.Inventory.URL, URL, "Fail",  12, 0, 12, 1,
							12, 2, 12, 3);

				}
				String PurchaseLimit = "";
				try {
					PurchaseLimit = rs.getString("PurchaseLimit");
					System.out.println(PurchaseLimit);
					Assert.assertEquals(Globals.Inventory.PurchaseLimit.trim(), PurchaseLimit.trim());

					pass.ExcelFourData("vendormaster", "PurchaseLimit", Globals.Inventory.PurchaseLimit, PurchaseLimit,
							"Pass", 13, 0, 13, 1, 13, 2,13, 3);
							

				} catch (AssertionError e) {

					pass.ExcelFourData("vendormaster", "PurchaseLimit", Globals.Inventory.PurchaseLimit, PurchaseLimit,
							"Fail", 13, 0, 13, 1, 13, 2,13, 3);

				}
				String Attn = "";
				try {
					Attn = rs.getString("Attn");
					System.out.println(Attn);
					Assert.assertEquals(Globals.Inventory.Attn.trim(), Attn.trim());

					pass.ExcelFourData("vendormaster", "Attn", Globals.Inventory.Attn, Attn, "Pass", 14, 0, 14, 1, 14, 2, 14, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("vendormaster", "Attn", Globals.Inventory.Attn, Attn, "Fail", 14, 0, 14, 1, 14, 2, 14, 3);

				}
				String PurchaseProfit = "";
				try {
					PurchaseProfit = rs.getString("PurchaseProfit1");
					System.out.println(PurchaseProfit);
					Assert.assertEquals(Globals.Inventory.PurchaseProfit.trim(), PurchaseProfit.trim());

					pass.ExcelFourData("vendormaster", "PurchaseProfit", Globals.Inventory.PurchaseProfit,
							PurchaseProfit, "Pass", 15, 0, 15, 1, 15,
							2, 15, 3);


				} catch (AssertionError e) {

					pass.ExcelFourData("vendormaster", "PurchaseProfit", Globals.Inventory.PurchaseProfit,
							PurchaseProfit, "Fail", 15, 0, 15, 1, 15,
							2, 15, 3);

				}
				String SellingMargin = "";
				try {
					SellingMargin = rs.getString("SellingMargin1");
					System.out.println(SellingMargin);
					Assert.assertEquals(Globals.Inventory.SellingMargin.trim(), SellingMargin.trim());

					pass.ExcelFourData("vendormaster", "SellingMargin", Globals.Inventory.SellingMargin, SellingMargin,
							"Pass", 16, 0, 16, 1, 16, 2, 16, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("vendormaster", "SellingMargin", Globals.Inventory.SellingMargin, SellingMargin,
							"Fail", 16, 0, 16, 1, 16, 2, 16, 3);

				}
				String Remarks = "";
				try {
					Remarks = rs.getString("Remarks");
					System.out.println(Remarks);
					Assert.assertEquals(Globals.Inventory.Remarks.trim(), Remarks.trim());

					pass.ExcelFourData("vendormaster", "Remarks", Globals.Inventory.Remarks, Remarks, "Pass", 17, 0, 17, 1, 17, 2, 17, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("vendormaster", "Remarks", Globals.Inventory.Remarks, Remarks, "Fail", 17, 0, 17, 1, 17, 2, 17, 3);


				}
				String PORemarks = "";
				try {
					PORemarks = rs.getString("PoRemarks");
					System.out.println(PORemarks);
					Assert.assertEquals(Globals.Inventory.PORemarks.trim(), PORemarks.trim());

					pass.ExcelFourData("vendormaster", "PORemarks", Globals.Inventory.PORemarks, PORemarks, "Pass", 18, 0, 18,
							1, 18, 2, 18, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("vendormaster", "PORemarks", Globals.Inventory.PORemarks, PORemarks, "Fail",18, 0, 18,
							1, 18, 2, 18, 3);
				}
				String ChequePrintName = "";
				try {
					ChequePrintName = rs.getString("ChequePrintName");
					System.out.println(ChequePrintName);
					Assert.assertEquals(Globals.Inventory.ChequePrintName.trim(), ChequePrintName.trim());

					pass.ExcelFourData("vendormaster", "ChequePrintName", Globals.Inventory.ChequePrintName,
							ChequePrintName, "Pass",19,0, 19, 1, 19, 2, 19, 3);
							

				} catch (AssertionError e) {

					pass.ExcelFourData("vendormaster", "ChequePrintName", Globals.Inventory.ChequePrintName,
							ChequePrintName, "Fail", 19,0, 19, 1, 19, 2, 19, 3);
							

				}
				String BankCode = "";
				try {
					BankCode = rs.getString("BankCode");
					System.out.println(BankCode);
					Assert.assertEquals(Globals.Inventory.BankCode.trim(), BankCode.trim());

					pass.ExcelFourData("vendormaster", "BankCode", Globals.Inventory.BankCode, BankCode, "Pass", 20, 0,
							20, 1, 20, 2, 20, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("vendormaster", "BankCode", Globals.Inventory.BankCode, BankCode, "Fail", 20, 0,
							20, 1, 20, 2, 20, 3);

				}

				String BankACNo = "";
				try {
					BankACNo = rs.getString("BankAccountNo");
					System.out.println(BankACNo);
					Assert.assertEquals(Globals.Inventory.BankACNo.trim(), BankACNo.trim());

					pass.ExcelFourData("vendormaster", "BankACNo", Globals.Inventory.BankACNo, BankACNo, "Pass", 21, 0,
							21, 1, 21, 2, 21, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("vendormaster", "BankACNo", Globals.Inventory.BankACNo, BankACNo, "Fail", 21, 0,
							21, 1, 21, 2, 21, 3);

				}
				String GSTTIN = "";
				try {
					GSTTIN = rs.getString("GSTNo");
					System.out.println(GSTTIN);
					Assert.assertEquals(Globals.Inventory.GSTTIN.trim(), GSTTIN.trim());

					pass.ExcelFourData("vendormaster", "GSTTIN", Globals.Inventory.GSTTIN, GSTTIN, "Pass", 22, 0, 22, 1,
							22, 2, 22, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("vendormaster", "GSTTIN", Globals.Inventory.GSTTIN, GSTTIN, "Fail", 22, 0, 22, 1,
							22, 2, 22, 3);

				}
				String IFSCCode = "";
				try {
					IFSCCode = rs.getString("IFSCcode");
					System.out.println(IFSCCode);
					Assert.assertEquals(Globals.Inventory.IFSCCode.trim(), IFSCCode.trim());

					pass.ExcelFourData("vendormaster", "IFSCCode", Globals.Inventory.IFSCCode, IFSCCode, "Pass", 23, 0,
							23, 1, 23, 2, 23, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("vendormaster", "IFSCCode", Globals.Inventory.IFSCCode, IFSCCode, "Fail", 23, 0,
							23, 1, 23, 2, 23, 3);

				}
				String HoldBills = "";
				try {
					HoldBills = rs.getString("HoldBillActive");
					System.out.println(HoldBills);
					Assert.assertEquals(Globals.Inventory.HoldBills.trim(), HoldBills.trim());

					pass.ExcelFourData("vendormaster", "HoldBills", Globals.Inventory.HoldBills, HoldBills, "Pass", 24, 0, 24, 1,
							24, 2, 24, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("vendormaster", "HoldBills", Globals.Inventory.HoldBills, HoldBills, "Fail", 24, 0, 24, 1,
							24, 2, 24, 3);

				}
				String HoldBill = "";
				try {
					HoldBill = rs.getString("HoldBill");
					System.out.println(HoldBill);
					Assert.assertEquals(Globals.Inventory.HoldBill.trim(), HoldBill.trim());

					pass.ExcelFourData("vendormaster", "HoldBill", Globals.Inventory.HoldBill, HoldBill, "Pass", 25, 0, 25, 1,
							25, 2, 25, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("vendormaster", "HoldBill", Globals.Inventory.HoldBill, HoldBill, "Fail", 25, 0, 25, 1,
							25, 2, 25, 3);

				}
				String CrLimit = "";
				try {
					CrLimit = rs.getString("CrLimitActive");
					System.out.println(CrLimit);
					Assert.assertEquals(Globals.Inventory.CrLimit.trim(), CrLimit.trim());

					pass.ExcelFourData("vendormaster", "CrLimit", Globals.Inventory.CrLimit, CrLimit, "Pass", 26, 0, 26, 1,
							26, 2, 26, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("vendormaster", "CrLimit", Globals.Inventory.CrLimit, CrLimit, "Fail", 26, 0, 26, 1,
							26, 2, 26, 3);

				}
				String CRLIMIT = "";
				try {
					CRLIMIT = rs.getString("CrLimit");
					System.out.println(CRLIMIT);
					Assert.assertEquals(Globals.Inventory.CRLIMIT.trim(), CRLIMIT.trim());

					pass.ExcelFourData("vendormaster", "CRLIMIT", Globals.Inventory.CRLIMIT, CRLIMIT, "Pass", 27, 0, 27, 1,
							27, 2, 27, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("vendormaster", "CRLIMIT", Globals.Inventory.CRLIMIT, CRLIMIT, "Fail", 27, 0, 27, 1,
							27, 2, 27, 3);

				}
				String CrDays = "";
				try {
					CrDays = rs.getString("CrDays");
					System.out.println(CrDays);
					Assert.assertEquals(Globals.Inventory.CrDays.trim(), CrDays.trim());

					pass.ExcelFourData("vendormaster", "CrDays", Globals.Inventory.CrDays, CrDays, "Pass", 28, 0, 28, 1,
							28, 2, 28, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("vendormaster", "CrDays", Globals.Inventory.CrDays, CrDays, "Fail", 28, 0, 28, 1,
							28, 2, 28, 3);

				}
				String StopPayment = "";
				try {
					StopPayment = rs.getString("StopPayment");
					System.out.println(StopPayment);
					Assert.assertEquals(Globals.Inventory.StopPayment.trim(), StopPayment.trim());

					pass.ExcelFourData("vendormaster", "StopPayment", Globals.Inventory.StopPayment, StopPayment, "Pass", 29, 0, 29, 1,
							29, 2, 29, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("vendormaster", "StopPayment", Globals.Inventory.StopPayment, StopPayment, "Fail", 29, 0, 29, 1,
							29, 2, 29, 3);

				}
				String StopPurchase = "";
				try {
					GSTTIN = rs.getString("StopPurchase");
					System.out.println(StopPurchase);
					Assert.assertEquals(Globals.Inventory.StopPurchase.trim(), StopPurchase.trim());

					pass.ExcelFourData("vendormaster", "StopPurchase", Globals.Inventory.StopPurchase, StopPurchase, "Pass", 30, 0, 30, 1,
							30, 2, 30, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("vendormaster", "StopPurchase", Globals.Inventory.StopPurchase, StopPurchase, "Fail", 30, 0, 30, 1,
							30, 2, 30, 3);

				}
				
				
				break;
			}
		}
	}
}
