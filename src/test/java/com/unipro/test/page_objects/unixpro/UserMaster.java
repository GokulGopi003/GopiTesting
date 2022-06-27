package com.unipro.test.page_objects.unixpro;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.gk.test.MssqlConnect;
import com.unipro.ExcelWrite;
import com.unipro.test.framework.Globals;
import com.unipro.test.framework.PageObject;
import com.unipro.test.framework.helpers.screenshot_helper.Screenshot;
import com.unipro.test.framework.helpers.utils.GenericWrappers;
import com.unipro.test.framework.helpers.utils.ReadTestData;

import cucumber.api.java.en.Then;

public class UserMaster extends PageObject {
	UserMastertypefield icp;
	TerminalPage terpage;
	TerminalPage terPage;
	AddInventoryFormPage Inventorychange;
	ExcelWrite pass;
	Screenshot scr;
	WebDriver driver = new ChromeDriver();

	public UserMaster(UserMastertypefield icp) {
		this.icp = icp;
		terpage = new TerminalPage();
		terPage = new TerminalPage();
		Inventorychange = new AddInventoryFormPage();
		pass=new ExcelWrite();
		scr = new Screenshot();
	}
	@Then("I load the UserMaster sheet data to map")
	public void i_load_the_UserMaster_sheet_data_to_map() {
		Globals.Inventory.UserMasterSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME138);
	}

	@Then("I load the rowise UserMaster data for {string} rowname")
	public void i_load_the_rowise_UserMaster_data_for_rowname(String row_name) {
		Globals.Inventory.UserMasterrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.UserMasterSheetData, row_name);

		System.out.println(Globals.Inventory.UserMasterrowwiseData);
	}

	@Then("I update value to the UserMaster page global Variables")
	public void i_update_value_to_the_UserMaster_page_global_Variables() {
		Globals.Inventory.Batch = Globals.Inventory.UserMasterrowwiseData.get("UserCode");
		Globals.Inventory.Batch1 = Globals.Inventory.UserMasterrowwiseData.get("UserName");
		Globals.Inventory.Batch2 = Globals.Inventory.UserMasterrowwiseData.get("LoginName");
		
		Globals.Inventory.Department = Globals.Inventory.UserMasterrowwiseData.get("PassWord");
		Globals.Inventory.Vendor = Globals.Inventory.UserMasterrowwiseData.get("ConfirmPassword");
		Globals.Inventory.Payment = Globals.Inventory.UserMasterrowwiseData.get("ExpiryDays");
		Globals.Inventory.Brand = Globals.Inventory.UserMasterrowwiseData.get("UserLevel");
		Globals.Inventory.SubCategory = Globals.Inventory.UserMasterrowwiseData.get("AuthenticationPassWord");
		
		Globals.Inventory.ReasonCode = Globals.Inventory.UserMasterrowwiseData.get("UserGroup");
		Globals.Inventory.ReasonDescription = Globals.Inventory.UserMasterrowwiseData.get("Designation");
		Globals.Inventory.Batch3 = Globals.Inventory.UserMasterrowwiseData.get("Phone");
		Globals.Inventory.Batch4 = Globals.Inventory.UserMasterrowwiseData.get("Email");
		Globals.Inventory.Location = Globals.Inventory.UserMasterrowwiseData.get("Location");
	}

	@Then("I fill new UserMaster data page using excel data")
	public void i_fill_new_UserMaster_data_page_using_excel_data() throws Exception {
		try{
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch)) {
			terpage.terminal_waitClearEnterText_css(icp.UserCode_String, Globals.Inventory.Batch);
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtUserCode\"]")).sendKeys(Keys.ENTER);
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch1)) {
			terpage.terminal_waitClearEnterText_css(icp.UserName_String, Globals.Inventory.Batch1);
			webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtUserName")).sendKeys(Keys.ENTER);
		}
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch2)) {
			terpage.terminal_waitClearEnterText_css(icp.LoginName_String, Globals.Inventory.Batch2);
			webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtLoginName")).sendKeys(Keys.ENTER);
			
		}
		
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Department)) {
			terpage.terminal_waitClearEnterText_css(icp.PassWord_String, Globals.Inventory.Department);
			webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtPassword")).sendKeys(Keys.ENTER);
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Vendor)) {
			terpage.terminal_waitClearEnterText_css(icp.ConfirmPassWord_String, Globals.Inventory.Vendor);
			
			webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtConfirmPassword")).sendKeys(Keys.ENTER);
		}
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Payment)) {
			terpage.terminal_waitClearEnterText_css(icp.ExpiryDays_String, Globals.Inventory.Payment);
			webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtExpiryDays")).sendKeys(Keys.ENTER);
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Brand)) {
			terpage.terminal_waitClearEnterText_css(icp.UserLevel_String, Globals.Inventory.Brand);
			
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtUserLevel\"]")).sendKeys(Keys.ENTER);
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.SubCategory)) {
			terpage.terminal_waitClearEnterText_css(icp.AuthenticationPassWord_String, Globals.Inventory.SubCategory);
			
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtAuthenticationPassword\"]")).sendKeys(Keys.ENTER);
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.ReasonCode)) {
			GenericWrappers.sleepInSeconds(1);
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_ddlUserGroup_chzn\"]")).click();
			GenericWrappers.sleepInSeconds(1);

			WebElement LocationValue = webDriver
					.findElement(By.cssSelector("#ContentPlaceHolder1_ddlUserGroup_chzn > div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_ddlUserGroup_chzn > div > div > input[type=text]";
			By ddlocator = By.cssSelector(css_location_dropDownValue);
			waitForExpectedElement(ddlocator);
			js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.ReasonCode);
			GenericWrappers.sleepInSeconds(1);
			LocationValue.sendKeys(Keys.SPACE);
			LocationValue.sendKeys(Keys.SPACE);
			LocationValue.sendKeys(Keys.ARROW_DOWN);
			GenericWrappers.sleepInSeconds(1);
			LocationValue.sendKeys(Keys.ENTER);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.ReasonDescription)) {
			GenericWrappers.sleepInSeconds(1);
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_ddlDesignation_chzn\"]")).click();
			GenericWrappers.sleepInSeconds(1);

			WebElement LocationValue = webDriver
					.findElement(By.cssSelector("#ContentPlaceHolder1_ddlDesignation_chzn > div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_ddlDesignation_chzn > div > div > input[type=text]";
			By ddlocator = By.cssSelector(css_location_dropDownValue);
			waitForExpectedElement(ddlocator);
			js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.ReasonDescription);
			GenericWrappers.sleepInSeconds(1);
			LocationValue.sendKeys(Keys.SPACE);
			LocationValue.sendKeys(Keys.SPACE);
			LocationValue.sendKeys(Keys.ARROW_DOWN);
			GenericWrappers.sleepInSeconds(1);
			LocationValue.sendKeys(Keys.ENTER);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch3)) {
			terpage.terminal_waitClearEnterText_css(icp.PhoneNo_String, Globals.Inventory.Batch3);
			webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtPhoneNo")).sendKeys(Keys.ENTER);
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch4)) {
			terpage.terminal_waitClearEnterText_css(icp.Email_String, Globals.Inventory.Batch4);
			
			webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtEmail")).sendKeys(Keys.ENTER);
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Location)) {
			GenericWrappers.sleepInSeconds(1);
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_lstLocation_chzn\"]")).click();
			GenericWrappers.sleepInSeconds(1);

			WebElement LocationValue = webDriver
					.findElement(By.cssSelector("#ContentPlaceHolder1_lstLocation_chzn > div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_lstLocation_chzn > div > div > input[type=text]";
			By ddlocator = By.cssSelector(css_location_dropDownValue);
			waitForExpectedElement(ddlocator);
			js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.Location);
			GenericWrappers.sleepInSeconds(1);
			LocationValue.sendKeys(Keys.SPACE);
			LocationValue.sendKeys(Keys.SPACE);
			LocationValue.sendKeys(Keys.ARROW_DOWN);
			GenericWrappers.sleepInSeconds(1);
			LocationValue.sendKeys(Keys.ENTER);

		}
		pass.ExcelFourData("Usermaster","Modules", "Actual", "Expected", "Status",
				0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
		pass.Excelcreate("Usermaster", "UserMaster", "Pass", 1, 0, 1, 3);
		}
		catch(Exception e) {
			
			scr.Screenshots();
			System.out.println("Screen shot taken");
			
			pass.ExcelFourData("Usermaster","UserMaster", "Actual", "Expected", "Status",
					0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
			pass.Excelcreate("Usermaster", "UserMaster", "FAIL", 1, 0, 1, 3);
			
		}
	}
	@Then("I close connection to UserMaster")
	public void i_close_connection_to_UserMaster() {
		mysqlConnect.disconnect();
		System.out.println(" closed succesfully");

	}

	MssqlConnect mysqlConnect;
	Statement st;
	@Then("I establish connection to UserMaster")
	public void i_establish_connection_to_UserMaster() throws SQLException {
		mysqlConnect = new MssqlConnect();
		st = mysqlConnect.connect().createStatement();
		System.out.println(" Connected succesfully");
	}

	@Then("I read the values from table {string} in UserMaster")
	public void i_read_the_values_from_table_in_UserMaster(String tablename) throws SQLException, IOException {
		ResultSet rs = st.executeQuery("select * from " + tablename + " where UM_USER_NAME='aa'");

		System.out.println(rs);

		while (rs.next()) {

			switch (tablename) {
			case "TBL_USER_MASTER":
				String UserCode = "";
				try {
					UserCode = rs.getString("UM_USER_CODE");
					System.out.println(UserCode);
					Assert.assertEquals(Globals.Inventory.Batch.trim(), UserCode.trim());
					pass.Excelcreate("Usermaster", "TBL_USER_MASTER", "", 3, 1, 3, 2);
					pass.ExcelFourData("Usermaster", "UserCode", Globals.Inventory.Batch, UserCode, "Pass", 4, 0, 4, 1,
							4, 2, 4, 3);
				} catch (AssertionError e) {
					pass.Excelcreate("Usermaster", "TBL_USER_MASTER", "", 3, 1, 3, 2);
					pass.ExcelFourData("Usermaster", "UserCode", Globals.Inventory.Batch, UserCode, "Fail", 4, 0, 4, 1,
							4, 2, 4, 3);

				}

				String UserName = "";
				try {
					UserName = rs.getString("UM_USER_NAME");
					System.out.println(UserName);
					Assert.assertEquals(Globals.Inventory.Batch1.trim(), UserName.trim());

					pass.ExcelFourData("Usermaster", "UserName", Globals.Inventory.Batch1, UserName, "Pass", 5, 0,
							5, 1, 5, 2, 5, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("Usermaster", "UserName", Globals.Inventory.Batch1, UserName, "Fail", 5, 0,
							5, 1, 5, 2, 5, 3);

				}

				String LoginName = "";
				try {
					LoginName = rs.getString("UM_LOGIN_NAME");
					System.out.println(LoginName);
					Assert.assertEquals(Globals.Inventory.Batch2.trim(), LoginName.trim());

					pass.ExcelFourData("Usermaster", "LoginName", Globals.Inventory.Batch2, LoginName, "Pass", 6,
							0, 6, 1, 6, 2, 6, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("Usermaster", "LoginName", Globals.Inventory.Batch2, LoginName, "Fail", 6, 0,
							6, 1, 6, 2, 6, 3);

				}
				String PassWord = "";
				try {
					PassWord = rs.getString("UM_LOGIN_PASSWORD");
					System.out.println(PassWord);
					Assert.assertEquals(Globals.Inventory.Department.trim(), PassWord.trim());

					pass.ExcelFourData("Usermaster", "PassWord", Globals.Inventory.Department, PassWord, "Pass", 7,
							0, 7, 1, 7, 2, 7, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("Usermaster", "PassWord", Globals.Inventory.Department, PassWord, "Fail", 7, 0,
							7, 1, 7, 2, 7, 3);

				}
				String AuthenticationPassWord = "";
				try {
					AuthenticationPassWord = rs.getString("UM_AUTH_PASSWORD");
					System.out.println(AuthenticationPassWord);
					Assert.assertEquals(Globals.Inventory.SubCategory.trim(), AuthenticationPassWord.trim());

					pass.ExcelFourData("Usermaster", "AuthenticationPassWord", Globals.Inventory.SubCategory, AuthenticationPassWord, "Pass", 8,
							0, 8, 1, 8, 2, 8, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("Usermaster", "AuthenticationPassWord", Globals.Inventory.SubCategory, AuthenticationPassWord, "Fail", 8, 0,
							8, 1, 8, 2, 8, 3);

				}
			}String UserLevel = "";
			try {
				UserLevel = rs.getString("UM_LEVEL");
				System.out.println(UserLevel);
				Assert.assertEquals(Globals.Inventory.Brand.trim(), UserLevel.trim());

				pass.ExcelFourData("Usermaster", "UserLevel", Globals.Inventory.Brand, UserLevel, "Pass", 9,
						0, 9, 1, 9, 2, 9, 3);

			} catch (AssertionError e) {

				pass.ExcelFourData("Usermaster", "UserLevel", Globals.Inventory.Brand, UserLevel, "Fail", 9, 0,
						9, 1, 9, 2, 9, 3);

			}String Designation = "";
			try {
				Designation = rs.getString("UM_DESIGNATION");
				System.out.println(Designation);
				Assert.assertEquals(Globals.Inventory.ReasonDescription.trim(), Designation.trim());

				pass.ExcelFourData("Usermaster", "Designation", Globals.Inventory.ReasonDescription, Designation, "Pass", 10,
						0, 10, 1, 10, 2, 10, 3);

			} catch (AssertionError e) {

				pass.ExcelFourData("Usermaster", "Designation", Globals.Inventory.ReasonDescription, Designation, "Fail", 10, 0,
						10, 1, 10, 2, 10, 3);

			}String Batch4 = "";
			try {
				Batch4 = rs.getString("UM_EMAIL");
				System.out.println(Batch4);
				Assert.assertEquals(Globals.Inventory.Batch4.trim(), Batch4.trim());

				pass.ExcelFourData("Usermaster", "Email", Globals.Inventory.Batch4, Batch4, "Pass", 11,
						0, 11, 1, 11, 2, 11, 3);

			} catch (AssertionError e) {

				pass.ExcelFourData("Usermaster", "Email", Globals.Inventory.Batch4, Batch4, "Fail", 11, 0,
						11, 1, 11, 2, 11, 3);

			}
			String Phone = "";
			try {
				Phone = rs.getString("UM_PHONE");
				System.out.println(Phone);
				Assert.assertEquals(Globals.Inventory.Batch3.trim(), Phone.trim());

				pass.ExcelFourData("Usermaster", "Phone", Globals.Inventory.Batch3, Phone, "Pass", 12,
						0, 12, 1, 12, 2, 12, 3);

			} catch (AssertionError e) {

				pass.ExcelFourData("Usermaster", "Phone", Globals.Inventory.Batch3, Phone, "Fail", 12, 0,
						12, 1, 12, 2, 12, 3);

			}
			String ExpiryDays = "";
			try {
				ExpiryDays = rs.getString("UM_PASSWORD_EXPIRYDAYS");
				System.out.println(ExpiryDays);
				Assert.assertEquals(Globals.Inventory.Payment.trim(), ExpiryDays.trim());

				pass.ExcelFourData("Usermaster", "ExpiryDays", Globals.Inventory.Payment, ExpiryDays, "Pass", 13,
						0, 13, 1, 13, 2, 13, 3);

			} catch (AssertionError e) {

				pass.ExcelFourData("Usermaster", "ExpiryDays", Globals.Inventory.Payment, ExpiryDays, "Fail", 13, 0,
						13, 1, 13, 2, 13, 3);

			}
			String UserGroup = "";
			try {
				UserGroup = rs.getString("UM_UGM_CODE");
				System.out.println(UserGroup);
				Assert.assertEquals(Globals.Inventory.ReasonCode.trim(), UserGroup.trim());

				pass.ExcelFourData("Usermaster", "UserGroup", Globals.Inventory.ReasonCode, UserGroup, "Pass", 14,
						0, 14, 1, 14, 2, 14, 3);

			} catch (AssertionError e) {

				pass.ExcelFourData("Usermaster", "UserGroup", Globals.Inventory.ReasonCode, UserGroup, "Fail", 14, 0,
						14, 1, 14, 2, 14, 3);

			}
	}

	
	}   	}






