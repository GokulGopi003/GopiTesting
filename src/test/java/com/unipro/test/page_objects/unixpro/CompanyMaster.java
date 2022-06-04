

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

	public class CompanyMaster  extends PageObject {
		CompanyMasterTypefield icp;
		TerminalPage terPage;
		AddInventoryFormPage Category;
		ExcelWrite pass;
		Screenshot scr;
		

		public CompanyMaster(CompanyMasterTypefield icp) {
			this.icp = icp;
			terPage = new TerminalPage();
			Category = new AddInventoryFormPage();
			pass=new ExcelWrite();
			scr = new Screenshot();
		} 
		@Then("I load the CompanyMaster sheet data to map")
		public void i_load_the_CompanyMaster_sheet_data_to_map() {
			Globals.Inventory.CompanyMasterSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME73);
		}

		@Then("I load the CompanyMaster rowise  data for {string} rowname")
		public void i_load_the_CompanyMaster_rowise_data_for_rowname(String row_name) {
			Globals.Inventory.CompanyMasterrowwiseData = ReadTestData
					.getRowFilteredValueFromTable(Globals.Inventory.CompanyMasterSheetData, row_name);

			System.out.println(Globals.Inventory.CompanyMasterrowwiseData);
		}

		@Then("I update value to the CompanyMaster page global Variables")
		public void i_update_value_to_the_CompanyMaster_page_global_Variables() {
			Globals.Inventory.Company = Globals.Inventory.CompanyMasterrowwiseData.get("Company");
			Globals.Inventory.LocationCode = Globals.Inventory.CompanyMasterrowwiseData.get("LocationCode");
			Globals.Inventory.BranchCode = Globals.Inventory.CompanyMasterrowwiseData.get("BranchCode");
			Globals.Inventory.Name = Globals.Inventory.CompanyMasterrowwiseData.get("Name");
			Globals.Inventory.Address1 = Globals.Inventory.CompanyMasterrowwiseData.get("Address1");
			Globals.Inventory.Address2 = Globals.Inventory.CompanyMasterrowwiseData.get("Address2");
			Globals.Inventory.Country = Globals.Inventory.CompanyMasterrowwiseData.get("Country");
			Globals.Inventory.City = Globals.Inventory.CompanyMasterrowwiseData.get("City");
			Globals.Inventory.State = Globals.Inventory.CompanyMasterrowwiseData.get("State");
			Globals.Inventory.PostalCode = Globals.Inventory.CompanyMasterrowwiseData.get("PostalCode");
			Globals.Inventory.Email = Globals.Inventory.CompanyMasterrowwiseData.get("Email");
			Globals.Inventory.WebPage = Globals.Inventory.CompanyMasterrowwiseData.get("WebPage");
			Globals.Inventory.Phone = Globals.Inventory.CompanyMasterrowwiseData.get("Phone");
			Globals.Inventory.Fax = Globals.Inventory.CompanyMasterrowwiseData.get("Fax");
			Globals.Inventory.Remarks = Globals.Inventory.CompanyMasterrowwiseData.get("Remarks");
			Globals.Inventory.DateFormat = Globals.Inventory.CompanyMasterrowwiseData.get("DateFormat");
			Globals.Inventory.Time = Globals.Inventory.CompanyMasterrowwiseData.get("Time");
			Globals.Inventory.DefaultCurrency = Globals.Inventory.CompanyMasterrowwiseData.get("DefaultCurrency");
			Globals.Inventory.CurencySign = Globals.Inventory.CompanyMasterrowwiseData.get("CurencySign");
			Globals.Inventory.BusinessRegNo = Globals.Inventory.CompanyMasterrowwiseData.get("BusinessRegNo");
			Globals.Inventory.TaxType = Globals.Inventory.CompanyMasterrowwiseData.get("TaxType");
			Globals.Inventory.Percentage = Globals.Inventory.CompanyMasterrowwiseData.get("Percentage");
			Globals.Inventory.GSTTIN = Globals.Inventory.CompanyMasterrowwiseData.get("GSTTIN");
			Globals.Inventory.BillMessage1 = Globals.Inventory.CompanyMasterrowwiseData.get("BillMessage1");
			Globals.Inventory.BillMessage2 = Globals.Inventory.CompanyMasterrowwiseData.get("BillMessage2");
			Globals.Inventory.DisplayMessage1 = Globals.Inventory.CompanyMasterrowwiseData.get("DisplayMessage1");
			Globals.Inventory.DisplayMessage2 = Globals.Inventory.CompanyMasterrowwiseData.get("DisplayMessage2");
			Globals.Inventory.Barcode = Globals.Inventory.CompanyMasterrowwiseData.get("Barcode");
			Globals.Inventory.NextBankTransNo = Globals.Inventory.CompanyMasterrowwiseData.get("NextBankTransNo");
			Globals.Inventory.NextMailID = Globals.Inventory.CompanyMasterrowwiseData.get("NextMailID");
			Globals.Inventory.DLNo = Globals.Inventory.CompanyMasterrowwiseData.get("DLNo");
		}

		@Then("I fill new CompanyMaster data page using excel data")
		public void i_fill_new_CompanyMaster_data_page_using_excel_data() throws Exception {
			try {
			/*if (GenericWrappers.isNotEmpty(Globals.Inventory.Company)) {
				terPage.terminal_waitClearEnterText_Xpath(icp.CompanyCode_String, Globals.Inventory.Company);

			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.LocationCode)) {
				GenericWrappers.sleepInSeconds(1);
				webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_ddlHqCode_chzn\"]/a/span")).click();
				GenericWrappers.sleepInSeconds(1);

				WebElement LocationCodeValue = webDriver
						.findElement(By.cssSelector("#ContentPlaceHolder1_ddlHqCode_chzn > div > div > input[type=text]"));
				String css_location_dropDownValue = "#ContentPlaceHolder1_ddlHqCode_chzn > div > div > input[type=text]";
				By ddlocator = By.cssSelector(css_location_dropDownValue);
				waitForExpectedElement(ddlocator);
				js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.LocationCode);
				GenericWrappers.sleepInSeconds(1);
				LocationCodeValue.sendKeys(Keys.SPACE);
				LocationCodeValue.sendKeys(Keys.SPACE);
				LocationCodeValue.sendKeys(Keys.ARROW_DOWN);
				GenericWrappers.sleepInSeconds(1);
				LocationCodeValue.sendKeys(Keys.ENTER);

			}

			if (GenericWrappers.isNotEmpty(Globals.Inventory.BranchCode)) {
				GenericWrappers.sleepInSeconds(1);
				webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_ddlBranchCode_chzn\"]")).click();
				GenericWrappers.sleepInSeconds(1);

				WebElement BranchCodeValue = webDriver
						.findElement(By.cssSelector("#ContentPlaceHolder1_ddlBranchCode_chzn > div > div > input[type=text]"));
				String css_location_dropDownValue = "#ContentPlaceHolder1_ddlBranchCode_chzn > div > div > input[type=text]";
				By ddlocator = By.cssSelector(css_location_dropDownValue);
				waitForExpectedElement(ddlocator);
				js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.BranchCode);
				GenericWrappers.sleepInSeconds(1);
				BranchCodeValue.sendKeys(Keys.SPACE);
				BranchCodeValue.sendKeys(Keys.SPACE);
				BranchCodeValue.sendKeys(Keys.ARROW_DOWN);
				GenericWrappers.sleepInSeconds(1);
				BranchCodeValue.sendKeys(Keys.ENTER);

			}

			if (GenericWrappers.isNotEmpty(Globals.Inventory.Name)) {
				terPage.terminal_waitClearEnterText_Xpath(icp.Name_String, Globals.Inventory.Name);

			}*/
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Address1)) {
				terPage.terminal_waitClearEnterText_Xpath(icp.Address1_String, Globals.Inventory.Address1);

			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Address2)) {
				terPage.terminal_waitClearEnterText_Xpath(icp.Address2_String, Globals.Inventory.Address2);

			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Country)) {
				terPage.terminal_waitClearEnterText_Xpath(icp.Country_String, Globals.Inventory.Country);

			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.City)) {
				terPage.terminal_waitClearEnterText_Xpath(icp.City_String, Globals.Inventory.City);

			}/*
			if (GenericWrappers.isNotEmpty(Globals.Inventory.State)) {
				terPage.terminal_waitClearEnterText_Xpath(icp.State_String, Globals.Inventory.State);

			}
			/*
			if (GenericWrappers.isNotEmpty(Globals.Inventory.State)) {
				GenericWrappers.sleepInSeconds(1);
				webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_ddlState_chzn\"]")).click();
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
	*/
			if (GenericWrappers.isNotEmpty(Globals.Inventory.PostalCode)) {
				terPage.terminal_waitClearEnterText_Xpath(icp.Postal_String, Globals.Inventory.PostalCode);

			}
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Email)) {
				terPage.terminal_waitClearEnterText_Xpath(icp.Email_String, Globals.Inventory.Email);

			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.WebPage)) {
				terPage.terminal_waitClearEnterText_Xpath(icp.WebPage_String, Globals.Inventory.WebPage);

			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Phone)) {
				terPage.terminal_waitClearEnterText_Xpath(icp.Phone_String, Globals.Inventory.Phone);

			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Fax)) {
				terPage.terminal_waitClearEnterText_Xpath(icp.Fax_String, Globals.Inventory.Fax);

			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Remarks)) {
				terPage.terminal_waitClearEnterText_Xpath(icp.Remarks_String, Globals.Inventory.Remarks);

			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.DateFormat)) {
				terPage.terminal_waitClearEnterText_Xpath(icp.DateFormat_String, Globals.Inventory.DateFormat);

			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Time)) {
				terPage.terminal_waitClearEnterText_Xpath(icp.Time_String, Globals.Inventory.Time);

			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.DefaultCurrency)) {
				terPage.terminal_waitClearEnterText_Xpath(icp.DefaultCurrency_String, Globals.Inventory.DefaultCurrency);

			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.CurencySign)) {
				terPage.terminal_waitClearEnterText_Xpath(icp.CurrencySign_String, Globals.Inventory.CurencySign);

			}
			

			if (GenericWrappers.isNotEmpty(Globals.Inventory.BusinessRegNo)) {
				terPage.terminal_waitClearEnterText_Xpath(icp.RegNo_String, Globals.Inventory.BusinessRegNo);

			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.TaxType)) {
				terPage.terminal_waitClearEnterText_Xpath(icp.TaxType_String, Globals.Inventory.TaxType);

			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Percentage)) {
				terPage.terminal_waitClearEnterText_Xpath(icp.Perc_String, Globals.Inventory.Percentage);

			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.GSTTIN)) {
				terPage.terminal_waitClearEnterText_Xpath(icp.GSTTIN_String, Globals.Inventory.GSTTIN);

			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.BillMessage1)) {
				terPage.terminal_waitClearEnterText_Xpath(icp.BillMessage1_String, Globals.Inventory.BillMessage1);

			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.BillMessage2)) {
				terPage.terminal_waitClearEnterText_Xpath(icp.BillMessage2_String, Globals.Inventory.BillMessage2);

			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.DisplayMessage1)) {
				terPage.terminal_waitClearEnterText_Xpath(icp.DispalyMsg1_String, Globals.Inventory.DisplayMessage1);

			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.DisplayMessage2)) {
				terPage.terminal_waitClearEnterText_Xpath(icp.DispalyMsg2_String, Globals.Inventory.DisplayMessage2);

			}
			pass.ExcelFourData("companymaster","Modules", "Actual", "Expected", "Status",
					0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
			pass.Excelcreate("companymaster", "companymaster", "Pass", 1, 0, 1, 3);
			}
			catch(Exception e) {
				
				scr.Screenshots();
				System.out.println("Screen shot taken");
				
				pass.ExcelFourData("companymaster","Modules", "Actual", "Expected", "Status",
						0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
				pass.Excelcreate("companymaster", "companymaster", "FAIL", 1, 0, 1, 3);
				
			}/*
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Barcode)) {
				terPage.terminal_waitClearEnterText_Xpath(icp.BarcodeComfort_String, Globals.Inventory.Barcode);

			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.NextBankTransNo)) {
				terPage.terminal_waitClearEnterText_Xpath(icp.NextBank_String, Globals.Inventory.NextBankTransNo);

			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.NextMailID)) {
				terPage.terminal_waitClearEnterText_Xpath(icp.NextMail_String, Globals.Inventory.NextMailID);

			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.DLNo)) {
				terPage.terminal_waitClearEnterText_Xpath(icp.DLno_String, Globals.Inventory.DLNo);

			}*/
			
			

		}
		@Then("I close connection to CompanyMaster")
		public void i_close_connection_to_CompanyMaster() {	
		mysqlConnect.disconnect();
		System.out.println(" closed succesfully");

	}

	MssqlConnect mysqlConnect;
	Statement st;

		

		@Then("I establish connection to CompanyMaster")
		public void i_establish_connection_to_CompanyMaster() throws SQLException {
			mysqlConnect = new MssqlConnect();
			st = mysqlConnect.connect().createStatement();
			System.out.println(" Connected succesfully");
		}

		@Then("I read the values from table {string} in CompanyMaster")
		public void i_read_the_values_from_table_in_CompanyMaster(String tablename) throws IOException, SQLException {

			ResultSet rs = st.executeQuery("select * from " + tablename + " where Address1='Chennai'");

			System.out.println(rs);

			while (rs.next()) {

				switch (tablename) {
				case "tblcompany":
					String Address1 = "";
					try {
						Address1 = rs.getString("Address1");
						System.out.println(Address1);
						Assert.assertEquals(Globals.Inventory.Address1.trim(), Address1.trim());
						 pass.Excelcreate("companymaster", "tblcompany", "", 2, 0, 2, 1);
						pass.ExcelFourData("companymaster", "Company", Globals.Inventory.Address1, Address1, "Pass", 3, 0,
								3, 1, 3, 2, 3, 3);
					} catch (AssertionError e) {
						 pass.Excelcreate("companymaster", "tblcompany", "", 2, 0, 2, 1);
						pass.ExcelFourData("companymaster", "Address1", Globals.Inventory.Address1, Address1, "Fail", 3, 0,
								3, 1, 3, 2, 3, 3);

					}
					String Address2 = "";
					try {
						Address2 = rs.getString("Address2");
						System.out.println(Address2);
						Assert.assertEquals(Globals.Inventory.Address2.trim(), Address2.trim());

						pass.ExcelFourData("companymaster", "Address2", Globals.Inventory.Address2, Address2, "Pass", 4, 0, 4, 1, 4, 2,
								4, 3);
					} catch (AssertionError e) {

						pass.ExcelFourData("companymaster", "Address2", Globals.Inventory.Address2, Address2, "Fail", 4, 0, 4, 1, 4, 2,
								4, 3);

					}

					String Country = "";
					try {
						Country = rs.getString("Country");
						System.out.println(Country);
						Assert.assertEquals(Globals.Inventory.Country.trim(), Country.trim());

						pass.ExcelFourData("companymaster", "Country", Globals.Inventory.Country, Country, "Pass", 5, 0, 5,
								1, 5, 2, 5, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("companymaster", "Country", Globals.Inventory.Country, Country, "Fail", 5, 0, 5,
								1, 5, 2, 5, 3);

					}

					String City = "";
					try {
						City = rs.getString("City");
						System.out.println(City);
						Assert.assertEquals(Globals.Inventory.City.trim(), City.trim());

						pass.ExcelFourData("companymaster", "City", Globals.Inventory.City, City, "Pass", 6, 0,
								6, 1, 6, 2, 6, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("companymaster", "City", Globals.Inventory.City, City, "Fail", 6, 0,
								6, 1, 6, 2, 6, 3);

					}/*
					String State = "";
					try {
						State = rs.getString("State");
						System.out.println(State);
						Assert.assertEquals(Globals.Inventory.State.trim(), State.trim());

						pass.ExcelFourData("companymaster", "State", Globals.Inventory.State, State, "Pass", 7, 0, 7, 1, 7,
								2, 7, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("companymaster", "State", Globals.Inventory.State, State, "Fail", 7, 0, 7, 1, 7,
								2, 7, 3);

					}*/
					String PostalCode = "";
					try {
						PostalCode = rs.getString("PostalCode");
						System.out.println(PostalCode);
						Assert.assertEquals(Globals.Inventory.PostalCode.trim(), PostalCode.trim());

						pass.ExcelFourData("companymaster", "PostalCode", Globals.Inventory.PostalCode, PostalCode, "Pass", 8, 0,
								8, 1, 8, 2, 8, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("companymaster", "PostalCode", Globals.Inventory.PostalCode, PostalCode, "Fail", 8, 0,
								8, 1, 8, 2, 8, 3);

					}
					String Email = "";
					try {
						Email = rs.getString("Email");
						System.out.println(Email);
						Assert.assertEquals(Globals.Inventory.Email.trim(), Email.trim());

						pass.ExcelFourData("companymaster", "Email", Globals.Inventory.Email, Email, "Pass", 9, 0, 9,
								1, 9, 2, 9, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("companymaster", "Email", Globals.Inventory.Email, Email, "Fail", 9, 0, 9,
								1, 9, 2, 9, 3);

					}
					String WebPage = "";
					try {
						WebPage = rs.getString("Url");
						System.out.println(WebPage);
						Assert.assertEquals(Globals.Inventory.WebPage.trim(), WebPage.trim());

						pass.ExcelFourData("companymaster", "WebPage", Globals.Inventory.WebPage, WebPage, "pass", 11, 0, 11, 1,
								11, 2, 11, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("companymaster", "WebPage", Globals.Inventory.WebPage, WebPage, "Fail", 11, 0, 11, 1,
								11, 2, 11, 3);

					}
					String Phone = "";
					try {
						Phone = rs.getString("Phone");
						System.out.println(Phone);
						Assert.assertEquals(Globals.Inventory.Phone.trim(), Phone.trim());

						pass.ExcelFourData("companymaster", "Phone", Globals.Inventory.Phone, Phone, "Pass", 12, 0, 12, 1,
								12, 2, 12, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("companymaster", "Phone", Globals.Inventory.Phone, Phone, "Fail",  12, 0, 12, 1,
								12, 2, 12, 3);

					}
					String Fax = "";
					try {
						Fax = rs.getString("Fax");
						System.out.println(Fax);
						Assert.assertEquals(Globals.Inventory.Fax.trim(), Fax.trim());

						pass.ExcelFourData("companymaster", "Fax", Globals.Inventory.Fax, Fax,
								"Pass", 13, 0, 13, 1, 13, 2,13, 3);
								

					} catch (AssertionError e) {

						pass.ExcelFourData("companymaster", "Fax", Globals.Inventory.Fax, Fax,
								"Fail", 13, 0, 13, 1, 13, 2,13, 3);

					}
					String Remarks = "";
					try {
						Remarks = rs.getString("Remarks");
						System.out.println(Remarks);
						Assert.assertEquals(Globals.Inventory.Remarks.trim(), Remarks.trim());

						pass.ExcelFourData("companymaster", "Remarks", Globals.Inventory.Remarks, Remarks, "Pass", 14, 0, 14, 1, 14, 2, 14, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("companymaster", "Remarks", Globals.Inventory.Remarks, Remarks, "Fail", 14, 0, 14, 1, 14, 2, 14, 3);

					}
					String DateFormat = "";
					try {
						DateFormat = rs.getString("DateFormat");
						System.out.println(DateFormat);
						Assert.assertEquals(Globals.Inventory.DateFormat.trim(), DateFormat.trim());

						pass.ExcelFourData("companymaster", "DateFormat", Globals.Inventory.DateFormat,
								DateFormat, "Pass", 15, 0, 15, 1, 15,
								2, 15, 3);


					} catch (AssertionError e) {

						pass.ExcelFourData("companymaster", "DateFormat", Globals.Inventory.DateFormat,
								DateFormat, "Fail", 15, 0, 15, 1, 15,
								2, 15, 3);

					}
					String Time = "";
					try {
						Time = rs.getString("TimeFormat");
						System.out.println(Time);
						Assert.assertEquals(Globals.Inventory.Time.trim(), Time.trim());

						pass.ExcelFourData("companymaster", "Time", Globals.Inventory.Time, Time,
								"Pass", 16, 0, 16, 1, 16, 2, 16, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("companymaster", "Time", Globals.Inventory.Time, Time,
								"Fail", 16, 0, 16, 1, 16, 2, 16, 3);

					}
					String DefaultCurrency = "";
					try {
						DefaultCurrency = rs.getString("DefaultCurrency");
						System.out.println(DefaultCurrency);
						Assert.assertEquals(Globals.Inventory.DefaultCurrency.trim(), DefaultCurrency.trim());

						pass.ExcelFourData("companymaster", "DefaultCurrency", Globals.Inventory.DefaultCurrency, DefaultCurrency, "Pass", 17, 0, 17, 1, 17, 2, 17, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("companymaster", "DefaultCurrency", Globals.Inventory.DefaultCurrency, DefaultCurrency, "Fail", 17, 0, 17, 1, 17, 2, 17, 3);


					}
					String CurencySign = "";
					try {
						CurencySign = rs.getString("CurrencySign");
						System.out.println(CurencySign);
						Assert.assertEquals(Globals.Inventory.CurencySign.trim(), CurencySign.trim());

						pass.ExcelFourData("companymaster", "CurencySign", Globals.Inventory.CurencySign, CurencySign, "Pass", 18, 0, 18,
								1, 18, 2, 18, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("companymaster", "CurencySign", Globals.Inventory.CurencySign, CurencySign, "Fail",18, 0, 18,
								1, 18, 2, 18, 3);
					}
					String BusinessRegNo = "";
					try {
						BusinessRegNo = rs.getString("BRNNo");
						System.out.println(BusinessRegNo);
						Assert.assertEquals(Globals.Inventory.BusinessRegNo.trim(), BusinessRegNo.trim());

						pass.ExcelFourData("companymaster", "BusinessRegNo", Globals.Inventory.BusinessRegNo,
								BusinessRegNo, "Pass",19,0, 19, 1, 19, 2, 19, 3);
								

					} catch (AssertionError e) {

						pass.ExcelFourData("companymaster", "BusinessRegNo", Globals.Inventory.BusinessRegNo,
								BusinessRegNo, "Fail", 19,0, 19, 1, 19, 2, 19, 3);
								

					}
					String TaxType = "";
					try {
						TaxType = rs.getString("GstType");
						System.out.println(TaxType);
						Assert.assertEquals(Globals.Inventory.TaxType.trim(), TaxType.trim());

						pass.ExcelFourData("companymaster", "TaxType", Globals.Inventory.TaxType, TaxType, "Pass", 20, 0,
								20, 1, 20, 2, 20, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("companymaster", "TaxType", Globals.Inventory.TaxType, TaxType, "Fail", 20, 0,
								20, 1, 20, 2, 20, 3);

					}

					String Percentage = "";
					try {
						Percentage = rs.getString("GstPerc");
						System.out.println(Percentage);
						Assert.assertEquals(Globals.Inventory.Percentage.trim(), Percentage.trim());

						pass.ExcelFourData("companymaster", "Percentage", Globals.Inventory.Percentage, Percentage, "Pass", 21, 0,
								21, 1, 21, 2, 21, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("companymaster", "Percentage", Globals.Inventory.Percentage, Percentage, "Fail", 21, 0,
								21, 1, 21, 2, 21, 3);

					}
					String GSTTIN = "";
					try {
						GSTTIN = rs.getString("GSTRegNo");
						System.out.println(GSTTIN);
						Assert.assertEquals(Globals.Inventory.GSTTIN.trim(), GSTTIN.trim());

						pass.ExcelFourData("companymaster", "GSTTIN", Globals.Inventory.GSTTIN, GSTTIN, "Pass", 22, 0, 22, 1,
								22, 2, 22, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("companymaster", "GSTTIN", Globals.Inventory.GSTTIN, GSTTIN, "Fail", 22, 0, 22, 1,
								22, 2, 22, 3);

					}
					String BillMessage1 = "";
					try {
						BillMessage1 = rs.getString("Message1");
						System.out.println(BillMessage1);
						Assert.assertEquals(Globals.Inventory.BillMessage1.trim(), BillMessage1.trim());

						pass.ExcelFourData("companymaster", "BillMessage1", Globals.Inventory.BillMessage1, BillMessage1, "Pass", 23, 0,
								23, 1, 23, 2, 23, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("companymaster", "BillMessage1", Globals.Inventory.BillMessage1, BillMessage1, "Fail", 23, 0,
								23, 1, 23, 2, 23, 3);

					}
					String BillMessage2 = "";
					try {
						BillMessage2 = rs.getString("Message2");
						System.out.println(BillMessage2);
						Assert.assertEquals(Globals.Inventory.BillMessage2.trim(), BillMessage2.trim());

						pass.ExcelFourData("companymaster", "BillMessage2", Globals.Inventory.BillMessage2, BillMessage2, "Pass", 24, 0,
								24, 1, 24, 2, 24, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("companymaster", "BillMessage2", Globals.Inventory.BillMessage2, BillMessage2, "Fail", 24, 0,
								24, 1, 24, 2, 24, 3);

					}
					String DisplayMessage1 = "";
					try {
						DisplayMessage1 = rs.getString("DisplayMessage1");
						System.out.println(DisplayMessage1);
						Assert.assertEquals(Globals.Inventory.DisplayMessage1.trim(), DisplayMessage1.trim());

						pass.ExcelFourData("companymaster", "DisplayMessage1", Globals.Inventory.DisplayMessage1, DisplayMessage1, "Pass", 25, 0,
								25, 1, 25, 2, 25, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("companymaster", "DisplayMessage1", Globals.Inventory.DisplayMessage1, DisplayMessage1, "Fail", 25, 0,
								25, 1, 25, 2, 25, 3);

					}
					String DisplayMessage2 = "";
					try {
						DisplayMessage2 = rs.getString("DisplayMessage2");
						System.out.println(DisplayMessage2);
						Assert.assertEquals(Globals.Inventory.DisplayMessage2.trim(), DisplayMessage2.trim());

						pass.ExcelFourData("companymaster", "DisplayMessage2", Globals.Inventory.DisplayMessage2, DisplayMessage2, "Pass", 26, 0,
								26, 1, 26, 2, 26, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("companymaster", "DisplayMessage2", Globals.Inventory.DisplayMessage2, DisplayMessage2, "Fail", 26, 0,
								26, 1, 26, 2, 26, 3);

					}/*
					String Barcode = "";
					try {
						Barcode = rs.getString("BarCodeCOMPort");
						System.out.println(Barcode);
						Assert.assertEquals(Globals.Inventory.Barcode.trim(), Barcode.trim());

						pass.ExcelFourData("companymaster", "Barcode", Globals.Inventory.Barcode, Barcode, "Pass", 27, 0,
								27, 1, 27, 2, 27, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("companymaster", "Barcode", Globals.Inventory.Barcode, Barcode, "Fail", 27, 0,
								27, 1, 27, 2, 27, 3);

					}
					String NextBankTransNo = "";
					try {
						NextBankTransNo = rs.getString("NextTransferNo");
						System.out.println(NextBankTransNo);
						Assert.assertEquals(Globals.Inventory.NextBankTransNo.trim(), BillMessage1.trim());

						pass.ExcelFourData("companymaster", "NextBankTransNo", Globals.Inventory.NextBankTransNo, NextBankTransNo, "Pass", 28, 0,
								28, 1, 28, 2, 28, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("companymaster", "NextBankTransNo", Globals.Inventory.NextBankTransNo, NextBankTransNo, "Fail", 28, 0,
								28, 1, 28, 2, 28, 3);

					}
					String NextMailID = "";
					try {
						NextMailID = rs.getString("NextMailID");
						System.out.println(NextMailID);
						Assert.assertEquals(Globals.Inventory.NextMailID.trim(), NextMailID.trim());

						pass.ExcelFourData("companymaster", "NextMailID", Globals.Inventory.NextMailID, NextMailID, "Pass", 29, 0,
								29, 1, 29, 2, 29, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("companymaster", "NextMailID", Globals.Inventory.NextMailID, NextMailID, "Fail", 28, 0,
								29, 1, 29, 2, 29, 3);

					}
					String DLNo = "";
					try {
						DLNo = rs.getString("DLNo");
						System.out.println(DLNo);
						Assert.assertEquals(Globals.Inventory.DLNo.trim(), DLNo.trim());

						pass.ExcelFourData("companymaster", "DLNo", Globals.Inventory.DLNo, DLNo, "Pass", 29, 0,
								29, 1, 29, 2, 29, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("companymaster", "DLNo", Globals.Inventory.DLNo, DLNo, "Fail", 29, 0,
								29, 1, 29, 2, 29, 3);

					}*/

					break;
			}
		}
	}

}
