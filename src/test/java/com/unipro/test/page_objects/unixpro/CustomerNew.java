package com.unipro.test.page_objects.unixpro;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.gk.test.MssqlConnect;
import com.unipro.ExcelWrite;
import com.unipro.test.framework.Globals;
import com.unipro.test.framework.PageObject;
import com.unipro.test.framework.helpers.screenshot_helper.Screenshot;
import com.unipro.test.framework.helpers.utils.GenericWrappers;
import com.unipro.test.framework.helpers.utils.ReadTestData;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class CustomerNew extends PageObject {
	Customernewtypefield icp;
	TerminalPage terPage;
	AddInventoryFormPage Category;
	ExcelWrite pass;
	Screenshot scr;
	TerminalPage terpage;
    //WebDriver driver;
	public CustomerNew(Customernewtypefield icp) {
		this.icp = icp;
		terPage = new TerminalPage();
		
		Category = new AddInventoryFormPage();
		pass=new ExcelWrite();
		scr = new Screenshot();
		
	} 
	@Then("I load the CustomerNew sheet data to map")
	public void i_load_the_CustomerNew_sheet_data_to_map() {
		Globals.Inventory.CustomerNewSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME77);
	}

	@Then("I load the CustomerNew rowise  data for {string} rowname")
	public void i_load_the_CustomerNew_rowise_data_for_rowname(String row_name) {
		Globals.Inventory.CustomerNewrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.CustomerNewSheetData, row_name);

		System.out.println(Globals.Inventory.CustomerNewrowwiseData);
	}

	@Then("I update value to the CustomerNew page global Variables")
	public void i_update_value_to_the_CustomerNew_page_global_Variables() {
		Globals.Inventory.Title = Globals.Inventory.CustomerNewrowwiseData.get("title");
		Globals.Inventory.CustomerName = Globals.Inventory.CustomerNewrowwiseData.get("customer");
		Globals.Inventory.IdType = Globals.Inventory.CustomerNewrowwiseData.get("IDTYPE");
		Globals.Inventory.DOB = Globals.Inventory.CustomerNewrowwiseData.get("DOB");
		Globals.Inventory.Occupation = Globals.Inventory.CustomerNewrowwiseData.get("occupation");
		Globals.Inventory.Category = Globals.Inventory.CustomerNewrowwiseData.get("category");
		Globals.Inventory.Designation = Globals.Inventory.CustomerNewrowwiseData.get("Designation");
		Globals.Inventory.Employer = Globals.Inventory.CustomerNewrowwiseData.get("employer");
		Globals.Inventory.GSTTIN = Globals.Inventory.CustomerNewrowwiseData.get("GstinNo");
		Globals.Inventory.IdNo = Globals.Inventory.CustomerNewrowwiseData.get("IDNO");
		Globals.Inventory.AgeGroup = Globals.Inventory.CustomerNewrowwiseData.get("Agegroup");
		Globals.Inventory.MaritalStatus = Globals.Inventory.CustomerNewrowwiseData.get("MaritalStatus");
		Globals.Inventory.Education = Globals.Inventory.CustomerNewrowwiseData.get("Education");
		Globals.Inventory.Class = Globals.Inventory.CustomerNewrowwiseData.get("Class");
		Globals.Inventory.Income = Globals.Inventory.CustomerNewrowwiseData.get("income");
		Globals.Inventory.MemberType = Globals.Inventory.CustomerNewrowwiseData.get("MemberType");
		Globals.Inventory.Representative = Globals.Inventory.CustomerNewrowwiseData.get("Representative");
		Globals.Inventory.Gender = Globals.Inventory.CustomerNewrowwiseData.get("Gender");
		Globals.Inventory.AnniversaryStatus = Globals.Inventory.CustomerNewrowwiseData.get("Anniversary");
		Globals.Inventory.Address1 = Globals.Inventory.CustomerNewrowwiseData.get("Address1");
		Globals.Inventory.Address2 = Globals.Inventory.CustomerNewrowwiseData.get("Address2");
		Globals.Inventory.Address3 = Globals.Inventory.CustomerNewrowwiseData.get("Address3");
		Globals.Inventory.Distance = Globals.Inventory.CustomerNewrowwiseData.get("Distance");
		Globals.Inventory.Country = Globals.Inventory.CustomerNewrowwiseData.get("Country");
		Globals.Inventory.State = Globals.Inventory.CustomerNewrowwiseData.get("STATE");
		Globals.Inventory.Pin = Globals.Inventory.CustomerNewrowwiseData.get("pin");
		Globals.Inventory.Phone = Globals.Inventory.CustomerNewrowwiseData.get("Phone");
		Globals.Inventory.Nationality = Globals.Inventory.CustomerNewrowwiseData.get("Nationality");
		Globals.Inventory.Area = Globals.Inventory.CustomerNewrowwiseData.get("Area");
		Globals.Inventory.Zone = Globals.Inventory.CustomerNewrowwiseData.get("Zone");
		Globals.Inventory.City = Globals.Inventory.CustomerNewrowwiseData.get("City");
		Globals.Inventory.MobileNo = Globals.Inventory.CustomerNewrowwiseData.get("MobileNo");
		Globals.Inventory.PhoneO = Globals.Inventory.CustomerNewrowwiseData.get("Phone");
		Globals.Inventory.Email = Globals.Inventory.CustomerNewrowwiseData.get("Email");
		Globals.Inventory.OtherDeatails = Globals.Inventory.CustomerNewrowwiseData.get("OtherDeatails");
		Globals.Inventory.LoyaltyCard = Globals.Inventory.CustomerNewrowwiseData.get("LoyaltyCard");
		Globals.Inventory.Price = Globals.Inventory.CustomerNewrowwiseData.get("Price");
		Globals.Inventory.CreditType = Globals.Inventory.CustomerNewrowwiseData.get("CreditType");
		Globals.Inventory.CreditLimit = Globals.Inventory.CustomerNewrowwiseData.get("CreditLimit");
		Globals.Inventory.CreditDays = Globals.Inventory.CustomerNewrowwiseData.get("CreditDays");
		Globals.Inventory.AllowDiscount = Globals.Inventory.CustomerNewrowwiseData.get("AllowDiscount");
		Globals.Inventory.Discount = Globals.Inventory.CustomerNewrowwiseData.get("Discount");
		
	}

	@Then("I fill new CustomerNew data page using excel data")
	public void i_fill_new_CustomerNew_data_page_using_excel_data() throws Exception {
		try {
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Title)) {
			
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_ddlTitle_chzn\"]")).click();
			GenericWrappers.sleepInSeconds(1);
			
			WebElement TitleValue = webDriver
					.findElement(By.cssSelector("#ContentPlaceHolder1_ddlTitle_chzn > div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_ddlTitle_chzn > div > div > input[type=text]";
			By ddlocator = By.cssSelector(css_location_dropDownValue);
			waitForExpectedElement(ddlocator);
			js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.Title);
			GenericWrappers.sleepInSeconds(1);
			TitleValue.sendKeys(Keys.SPACE);
			TitleValue.sendKeys(Keys.SPACE);
			TitleValue.sendKeys(Keys.ARROW_DOWN);
			GenericWrappers.sleepInSeconds(1);
			TitleValue.sendKeys(Keys.ENTER);
		}
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.CustomerName)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.CustomerName_String, Globals.Inventory.CustomerName);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.IdType)) {
			//GenericWrappers.sleepInSeconds(1);
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_ddlIDType_chzn\"]")).click();
			GenericWrappers.sleepInSeconds(1);
			
			WebElement IdValue = webDriver
					.findElement(By.cssSelector("#ContentPlaceHolder1_ddlIDType_chzn > div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_ddlIDType_chzn > div > div > input[type=text]";
			By ddlocator = By.cssSelector(css_location_dropDownValue);
			waitForExpectedElement(ddlocator);
			js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.IdType);
			GenericWrappers.sleepInSeconds(1);
			IdValue.sendKeys(Keys.SPACE);
			IdValue.sendKeys(Keys.SPACE);
			IdValue.sendKeys(Keys.ARROW_DOWN);
			GenericWrappers.sleepInSeconds(1);
			IdValue.sendKeys(Keys.ENTER);
		}
		/*if (GenericWrappers.isNotEmpty(Globals.Inventory.DOB)) {
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtDOB\"]"));
			terPage.terminal_waitClearEnterText_Xpath(icp.Dob_String, Globals.Inventory.DOB).click();
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtDOB\"]"))
					.sendKeys(Keys.RETURN);

		}
		/*if (GenericWrappers.isNotEmpty(Globals.Inventory.DOB)) {
		  webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtDOB\"]")).click();
		  terPage.terminal_waitClearEnterText_Xpath(icp.Dob_String, Globals.Inventory.DOB);
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtDOB\"]"))
					.sendKeys(Keys.RETURN);
}*/
			
		
		
		/*if (GenericWrappers.isNotEmpty(Globals.Inventory.DOB)) {
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtDOB\"]")).click();
			GenericWrappers.sleepInSeconds(1);
			
			WebElement DOBValue = webDriver.findElement(
					By.cssSelector("#ContentPlaceHolder1_txtDOB_chzn > div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_txtDOB_chzn > div > div > input[type=text]";
			By ddlocator = By.xpath(css_location_dropDownValue);
			waitForExpectedElement(ddlocator);
			js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.DOB);
			GenericWrappers.sleepInSeconds(1);
			DOBValue.sendKeys(Keys.SPACE);
			DOBValue.sendKeys(Keys.SPACE);
			DOBValue.sendKeys(Keys.ARROW_DOWN);
			GenericWrappers.sleepInSeconds(1);
			DOBValue.sendKeys(Keys.ENTER);

		}*/
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Occupation)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Occupation_String, Globals.Inventory.Occupation);
			//webDriver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_txtReasonDescription']"))
			//.sendKeys(Keys.RETURN);
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Category)) {
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_ddlCategory_chzn\"]")).click();
			GenericWrappers.sleepInSeconds(1);
			
			WebElement CategoryValue = webDriver.findElement(
					By.cssSelector("#ContentPlaceHolder1_ddlCategory_chzn > div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_ddlCategory_chzn > div > div > input[type=text]";
			By ddlocator = By.cssSelector(css_location_dropDownValue);
			waitForExpectedElement(ddlocator);
			js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.Category);
			GenericWrappers.sleepInSeconds(1);
			CategoryValue.sendKeys(Keys.SPACE);
			CategoryValue.sendKeys(Keys.SPACE);
			CategoryValue.sendKeys(Keys.ARROW_DOWN);
			GenericWrappers.sleepInSeconds(1);
			CategoryValue.sendKeys(Keys.ENTER);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Designation)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Designation_String, Globals.Inventory.Designation);

		}	
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Employer)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Employer_String, Globals.Inventory.Employer);

		}	
		if (GenericWrappers.isNotEmpty(Globals.Inventory.GSTTIN)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.GSTTIN_String, Globals.Inventory.GSTTIN);

		}	
		if (GenericWrappers.isNotEmpty(Globals.Inventory.IdNo)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.IdNo_String, Globals.Inventory.IdNo);

		}	
		if (GenericWrappers.isNotEmpty(Globals.Inventory.AgeGroup)) {
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_ddlAgeGroup_chzn\"]")).click();
			GenericWrappers.sleepInSeconds(1);
			
			WebElement AgeGroupValue = webDriver.findElement(
					By.cssSelector("#ContentPlaceHolder1_ddlAgeGroup_chzn > div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_ddlAgeGroup_chzn > div > div > input[type=text]";
			By ddlocator = By.cssSelector(css_location_dropDownValue);
			waitForExpectedElement(ddlocator);
			js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.AgeGroup);
			GenericWrappers.sleepInSeconds(1);
			AgeGroupValue.sendKeys(Keys.SPACE);
			AgeGroupValue.sendKeys(Keys.SPACE);
			AgeGroupValue.sendKeys(Keys.ARROW_DOWN);
			GenericWrappers.sleepInSeconds(1);
			AgeGroupValue.sendKeys(Keys.ENTER);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.MaritalStatus)) {
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_ddlMaritalStatus_chzn\"]")).click();
			GenericWrappers.sleepInSeconds(1);
			
			WebElement MaritalStatusValue = webDriver.findElement(
					By.cssSelector("#ContentPlaceHolder1_ddlMaritalStatus_chzn > div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_ddlMaritalStatus_chzn > div > div > input[type=text]";
			By ddlocator = By.cssSelector(css_location_dropDownValue);
			waitForExpectedElement(ddlocator);
			js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.MaritalStatus);
			GenericWrappers.sleepInSeconds(1);
			MaritalStatusValue.sendKeys(Keys.SPACE);
			MaritalStatusValue.sendKeys(Keys.SPACE);
			MaritalStatusValue.sendKeys(Keys.ARROW_DOWN);
			GenericWrappers.sleepInSeconds(1);
			MaritalStatusValue.sendKeys(Keys.ENTER);

		}
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Education)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Education_String, Globals.Inventory.Education);

		}	
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Class)) {
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_ddlClass_chzn\"]")).click();
			GenericWrappers.sleepInSeconds(1);
			
			WebElement ClassValue = webDriver.findElement(
					By.cssSelector("#ContentPlaceHolder1_ddlClass_chzn > div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_ddlClass_chzn > div > div > input[type=text]";
			By ddlocator = By.cssSelector(css_location_dropDownValue);
			waitForExpectedElement(ddlocator);
			js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.Class);
			GenericWrappers.sleepInSeconds(1);
			ClassValue.sendKeys(Keys.SPACE);
			ClassValue.sendKeys(Keys.SPACE);
			ClassValue.sendKeys(Keys.ARROW_DOWN);
			GenericWrappers.sleepInSeconds(1);
			ClassValue.sendKeys(Keys.ENTER);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Income)) {
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_ddlIncome_chzn\"]")).click();
			GenericWrappers.sleepInSeconds(1);
			
			WebElement IncomeValue = webDriver.findElement(
					By.cssSelector("#ContentPlaceHolder1_ddlIncome_chzn > div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_ddlIncome_chzn > div > div > input[type=text]";
			By ddlocator = By.cssSelector(css_location_dropDownValue);
			waitForExpectedElement(ddlocator);
			js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.Income);
			GenericWrappers.sleepInSeconds(1);
			IncomeValue.sendKeys(Keys.SPACE);
			IncomeValue.sendKeys(Keys.SPACE);
			IncomeValue.sendKeys(Keys.ARROW_DOWN);
			GenericWrappers.sleepInSeconds(1);
			IncomeValue.sendKeys(Keys.ENTER);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.MemberType)) {
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_ddlType_chzn\"]")).click();
			GenericWrappers.sleepInSeconds(1);
			
			WebElement MemberTypeValue = webDriver.findElement(
					By.cssSelector("#ContentPlaceHolder1_ddlType_chzn > div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_ddlType_chzn > div > div > input[type=text]";
			By ddlocator = By.cssSelector(css_location_dropDownValue);
			waitForExpectedElement(ddlocator);
			js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.MemberType);
			GenericWrappers.sleepInSeconds(1);
			MemberTypeValue.sendKeys(Keys.SPACE);
			MemberTypeValue.sendKeys(Keys.SPACE);
			MemberTypeValue.sendKeys(Keys.ARROW_DOWN);
			GenericWrappers.sleepInSeconds(1);
			MemberTypeValue.sendKeys(Keys.ENTER);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Representative)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Representative_String, Globals.Inventory.Representative);

		}	
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Gender)) {
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_ddlGender_chzn\"]")).click();
			GenericWrappers.sleepInSeconds(1);
			
			WebElement GenderValue = webDriver.findElement(
					By.cssSelector("#ContentPlaceHolder1_ddlGender_chzn > div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_ddlGender_chzn > div > div > input[type=text]";
			By ddlocator = By.cssSelector(css_location_dropDownValue);
			waitForExpectedElement(ddlocator);
			js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.Gender);
			GenericWrappers.sleepInSeconds(1);
			GenderValue.sendKeys(Keys.SPACE);
			GenderValue.sendKeys(Keys.SPACE);
			GenderValue.sendKeys(Keys.ARROW_DOWN);
			GenericWrappers.sleepInSeconds(1);
			GenderValue.sendKeys(Keys.ENTER);

		}/*
		if (GenericWrappers.isNotEmpty(Globals.Inventory.AnniversaryStatus)) {
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtAnnivDate\"]")).click();
			GenericWrappers.sleepInSeconds(1);
			
			WebElement CategoryValue = webDriver.findElement(
					By.cssSelector("#ContentPlaceHolder1_ddlCategory_chzn > div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_ddlCategory_chzn > div > div > input[type=text]";
			By ddlocator = By.cssSelector(css_location_dropDownValue);
			waitForExpectedElement(ddlocator);
			js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.AnniversaryStatus);
			GenericWrappers.sleepInSeconds(1);
			CategoryValue.sendKeys(Keys.SPACE);
			CategoryValue.sendKeys(Keys.SPACE);
			CategoryValue.sendKeys(Keys.ARROW_DOWN);
			GenericWrappers.sleepInSeconds(1);
			CategoryValue.sendKeys(Keys.ENTER);

		}*/
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Address1)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Address1_String, Globals.Inventory.Address1);

		}	
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Address2)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Address2_String, Globals.Inventory.Address2);

		}	
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Address3)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Address3_String, Globals.Inventory.Address3);

		}	
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Distance)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Distance_String, Globals.Inventory.Distance);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Country)) {
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_ddlCountry_chzn\"]")).click();
			GenericWrappers.sleepInSeconds(1);
			
			WebElement CountryValue = webDriver.findElement(
					By.cssSelector("#ContentPlaceHolder1_ddlCountry_chzn > div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_ddlCountry_chzn > div > div > input[type=text]";
			By ddlocator = By.cssSelector(css_location_dropDownValue);
			waitForExpectedElement(ddlocator);
			js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.Country);
			GenericWrappers.sleepInSeconds(1);
			CountryValue.sendKeys(Keys.SPACE);
			CountryValue.sendKeys(Keys.SPACE);
			CountryValue.sendKeys(Keys.ARROW_DOWN);
			GenericWrappers.sleepInSeconds(1);
			CountryValue.sendKeys(Keys.ENTER);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.State)) {
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_ddlState_chzn\"]")).click();
			GenericWrappers.sleepInSeconds(1);
			
			WebElement StateValue = webDriver.findElement(
					By.cssSelector("#ContentPlaceHolder1_ddlState_chzn > div > div > input[type=text]"));
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
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Pin)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.pin_String, Globals.Inventory.Pin);

		}	
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Phone)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Phoner_String, Globals.Inventory.Phone);

		}	
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Nationality)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Nationality_String, Globals.Inventory.Nationality);

		}
		/*
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Area)) {
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_ddlArea_chzn\"]")).click();
			GenericWrappers.sleepInSeconds(1);
			
			WebElement AreaValue = webDriver.findElement(
					By.cssSelector("#ContentPlaceHolder1_ddlArea_chzn > div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_ddlArea_chzn > div > div > input[type=text]";
			By ddlocator = By.cssSelector(css_location_dropDownValue);
			waitForExpectedElement(ddlocator);
			js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.Area);
			GenericWrappers.sleepInSeconds(1);
			AreaValue.sendKeys(Keys.SPACE);
			AreaValue.sendKeys(Keys.SPACE);
			AreaValue.sendKeys(Keys.ARROW_DOWN);
			GenericWrappers.sleepInSeconds(1);
			AreaValue.sendKeys(Keys.ENTER);

		}*/
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Zone)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.zone_String, Globals.Inventory.Zone);

		}	
		if (GenericWrappers.isNotEmpty(Globals.Inventory.City)) {
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_ddlCity_chzn\"]")).click();
			GenericWrappers.sleepInSeconds(1);
			
			WebElement CityValue = webDriver.findElement(
					By.cssSelector("#ContentPlaceHolder1_ddlCity_chzn > div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_ddlCity_chzn > div > div > input[type=text]";
			By ddlocator = By.cssSelector(css_location_dropDownValue);
			waitForExpectedElement(ddlocator);
			js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.City);
			GenericWrappers.sleepInSeconds(1);
			CityValue.sendKeys(Keys.SPACE);
			CityValue.sendKeys(Keys.SPACE);
			CityValue.sendKeys(Keys.ARROW_DOWN);
			GenericWrappers.sleepInSeconds(1);
			CityValue.sendKeys(Keys.ENTER);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.MobileNo)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.MobileNo_String, Globals.Inventory.MobileNo);

		}	
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Phone)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.PhoneNoO_String, Globals.Inventory.Phone);

		}	
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Email)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Email_String, Globals.Inventory.Email);
			GenericWrappers.sleepInSeconds(2);
		}
		pass.ExcelFourData("customernew","Modules", "Actual", "Expected", "Status",
				0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
		pass.Excelcreate("customernew", "CustomerNew", "Pass", 1, 0, 1, 3);
		}
catch(Exception e) {
			
			scr.Screenshots();
			System.out.println("Screen shot taken");
			
			pass.ExcelFourData("customernew","Modules", "Actual", "Expected", "Status",
					0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
			pass.Excelcreate("customernew", "CustomerNew", "FAIL", 1, 0, 1, 3);
			
}}
	
		@Then("I fill Other Details")
		public void i_fill_Other_Details() throws Exception {
			
		
		  
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.LoyaltyCard)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Loyalty_String, Globals.Inventory.LoyaltyCard);
			
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Price)) {
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_ddlPriceType_chzn\"]")).click();
			GenericWrappers.sleepInSeconds(1);
			
			WebElement PriceValue = webDriver.findElement(
					By.cssSelector("#ContentPlaceHolder1_ddlPriceType_chzn > div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_ddlPriceType_chzn > div > div > input[type=text]";
			By ddlocator = By.cssSelector(css_location_dropDownValue);
			waitForExpectedElement(ddlocator);
			js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.Price);
			GenericWrappers.sleepInSeconds(1);
			PriceValue.sendKeys(Keys.SPACE);
			PriceValue.sendKeys(Keys.SPACE);
			PriceValue.sendKeys(Keys.ARROW_DOWN);
			GenericWrappers.sleepInSeconds(1);
			PriceValue.sendKeys(Keys.ENTER);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.CreditType)) {
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_ddlCreditType_chzn\"]")).click();
			GenericWrappers.sleepInSeconds(1);
			
			WebElement CreditTypeValue = webDriver.findElement(
					By.cssSelector("#ContentPlaceHolder1_ddlCreditType_chzn > div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_ddlCreditType_chzn > div > div > input[type=text]";
			By ddlocator = By.cssSelector(css_location_dropDownValue);
			waitForExpectedElement(ddlocator);
			js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.CreditType);
			GenericWrappers.sleepInSeconds(1);
			CreditTypeValue.sendKeys(Keys.SPACE);
			CreditTypeValue.sendKeys(Keys.SPACE);
			CreditTypeValue.sendKeys(Keys.ARROW_DOWN);
			GenericWrappers.sleepInSeconds(1);
			CreditTypeValue.sendKeys(Keys.ENTER);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.CreditLimit)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.CreditLimit_String, Globals.Inventory.CreditLimit);

		}	
		if (GenericWrappers.isNotEmpty(Globals.Inventory.CreditDays)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.CreditDays_String, Globals.Inventory.CreditDays);
			
		}
		/*if (GenericWrappers.isNotEmpty(Globals.Inventory.AllowDiscount)) {
			terpage.get_checkBox_element(icp.AllowDis_String).click();
		}*/
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Discount)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Discount_String, Globals.Inventory.Discount);
			
		}
			}
       


		@Then("I close connection to CustomerNew")
		public void I_close_connection_to_CustomerNew() throws SQLException {

			mysqlConnect.disconnect();
			System.out.println(" closed succesfully");

		}

		MssqlConnect mysqlConnect;
		Statement st;

		@Then("I establish connection to CustomerNew")
		public void I_establish_connection_to_CustomerNew() throws SQLException {

			mysqlConnect = new MssqlConnect();
			st = mysqlConnect.connect().createStatement();
			System.out.println(" Connected succesfully");

		}

		@Given("I read the values from table {string} in CustomerNew")
		public void i_want_to_launch_the(String tablename) throws SQLException, IOException {

			ResultSet rs = st.executeQuery("select * from " + tablename + " where CUST_OCCUPATION='Employee'");

			System.out.println(rs);

			while (rs.next()) {

				switch (tablename) {
				case "TBL_CUSTOMER_MASTER":
					
					String Title = "";
					try {
						Title = rs.getString("CUST_TITLE");
						System.out.println(Title);
						Assert.assertEquals(Globals.Inventory.Title.trim(), Title.trim());
						 pass.Excelcreate("customernew", "TBL_CUSTOMER_MASTER", "", 1, 0, 1, 1);
						pass.ExcelFourData("customernew", "Title", Globals.Inventory.Title, Title, "Pass", 3, 0,
								3, 1, 3, 2, 3, 3);
					} catch (AssertionError e) {
						 pass.Excelcreate("customernew", "TBL_CUSTOMER_MASTER", "", 1, 0, 1, 1);
						pass.ExcelFourData("customernew", "Title", Globals.Inventory.Title, Title, "Fail", 3, 0,
								3, 1, 3, 2, 3, 3);

					}
					String CustomerName = "";
					try {
						CustomerName = rs.getString("CUST_NAME");
						System.out.println(CustomerName);
						Assert.assertEquals(Globals.Inventory.CustomerName.trim(), CustomerName.trim());

						pass.ExcelFourData("customernew", "CustomerName", Globals.Inventory.CustomerName, CustomerName, "Pass", 4, 0, 4, 1, 4, 2,
								4, 3);
					} catch (AssertionError e) {

						pass.ExcelFourData("customernew", "CustomerName", Globals.Inventory.CustomerName, CustomerName, "Fail", 4, 0, 4, 1, 4, 2,
								4, 3);

					}

					/*String IdType = "";
					try {
						IdType = rs.getString("ZipCode");
						System.out.println(IdType);
						Assert.assertEquals(Globals.Inventory.IdType.trim(), IdType.trim());

						pass.ExcelFourData("customernew", "IdType", Globals.Inventory.IdType, IdType, "Pass", 5, 0, 5,
								1, 5, 2, 5, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("customernew", "IdType", Globals.Inventory.IdType, IdType, "Fail", 5, 0, 5,
								1, 5, 2, 5, 3);

					}

					String DOB = "";
					try {
						DOB = rs.getString("CUST_DOB");
						System.out.println(DOB);
						Assert.assertEquals(Globals.Inventory.DOB.trim(), DOB.trim());

						pass.ExcelFourData("customernew", "DOB", Globals.Inventory.DOB, DOB, "Pass", 6, 0,
								6, 1, 6, 2, 6, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("customernew", "DOB", Globals.Inventory.DOB, DOB, "Fail", 6, 0,
								6, 1, 6, 2, 6, 3);

					}*/
					String Occupation = "";
					try {
						Occupation = rs.getString("CUST_OCCUPATION");
						System.out.println(Occupation);
						Assert.assertEquals(Globals.Inventory.Occupation.trim(), Occupation.trim());

						pass.ExcelFourData("customernew", "Occupation", Globals.Inventory.Occupation, Occupation, "Pass", 7, 0, 7, 1, 7,
								2, 7, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("customernew", "Occupation", Globals.Inventory.Occupation, Occupation, "Fail", 7, 0, 7, 1, 7,
								2, 7, 3);

					}
					String Category = "";
					try {
						Category = rs.getString("CUST_CATEGORY");
						System.out.println(Category);
						Assert.assertEquals(Globals.Inventory.Category.trim(), Category.trim());

						pass.ExcelFourData("customernew", "Category", Globals.Inventory.Category, Category, "Pass", 8, 0,
								8, 1, 8, 2, 8, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("customernew", "Category", Globals.Inventory.Category, Category, "Fail", 8, 0,
								8, 1, 8, 2, 8, 3);

					}
					String Designation = "";
					try {
						Designation = rs.getString("CUST_DESIGNATION");
						System.out.println(Designation);
						Assert.assertEquals(Globals.Inventory.Designation.trim(), Designation.trim());

						pass.ExcelFourData("customernew", "Designation", Globals.Inventory.Designation, Designation, "Pass", 9, 0, 9,
								1, 9, 2, 9, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("customernew", "Designation", Globals.Inventory.Designation, Designation, "Fail", 9, 0, 9,
								1, 9, 2, 9, 3);

					}
					String Employer = "";
					try {
						Employer = rs.getString("CUST_EMPLOYER");
						System.out.println(Employer);
						Assert.assertEquals(Globals.Inventory.Employer.trim(), Employer.trim());

						pass.ExcelFourData("customernew", "Employer", Globals.Inventory.Employer, Employer, "pass", 10, 0, 10, 1,
								10, 2, 10, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("customernew", "Employer", Globals.Inventory.Employer, Employer, "Fail", 10, 0, 10, 1,
								10, 2, 10, 3);

					}
					String GSTTIN = "";
					try {
						GSTTIN = rs.getString("GSTNO");
						System.out.println(GSTTIN);
						Assert.assertEquals(Globals.Inventory.GSTTIN.trim(), GSTTIN.trim());

						pass.ExcelFourData("customernew", "GSTTIN", Globals.Inventory.GSTTIN, GSTTIN, "Pass", 11, 0, 11, 1,
								11, 2, 11, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("customernew", "GSTTIN", Globals.Inventory.GSTTIN, GSTTIN, "Fail",  11, 0, 11, 1,
								11, 2, 11, 3);

					}
					String IdNo = "";
					try {
						IdNo = rs.getString("CUST_IDENTIFICATION_NUMBER");
						System.out.println(IdNo);
						Assert.assertEquals(Globals.Inventory.IdNo.trim(), IdNo.trim());

						pass.ExcelFourData("customernew", "IdNo", Globals.Inventory.IdNo, IdNo,
								"Pass", 12, 0, 12, 1, 12, 2,12, 3);
								

					} catch (AssertionError e) {

						pass.ExcelFourData("customernew", "IdNo", Globals.Inventory.IdNo, IdNo,
								"Fail", 12, 0, 12, 1, 12, 2,12, 3);

					}
					String AgeGroup = "";
					try {
						AgeGroup = rs.getString("CUST_AGE_GROUP");
						System.out.println(AgeGroup);
						Assert.assertEquals(Globals.Inventory.AgeGroup.trim(), AgeGroup.trim());

						pass.ExcelFourData("customernew", "AgeGroup", Globals.Inventory.AgeGroup, AgeGroup, "Pass", 13, 0, 13, 1, 13, 2, 13, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("customernew", "AgeGroup", Globals.Inventory.AgeGroup, AgeGroup, "Fail", 13, 0, 13, 1, 13, 2, 13, 3);

					}
					String MaritalStatus = "";
					try {
						MaritalStatus = rs.getString("CUST_MARITIAL_STATUS");
						System.out.println(MaritalStatus);
						Assert.assertEquals(Globals.Inventory.MaritalStatus.trim(), MaritalStatus.trim());

						pass.ExcelFourData("customernew", "MaritalStatus", Globals.Inventory.MaritalStatus,
								MaritalStatus, "Pass", 14, 0, 14, 1, 14,
								2, 14, 3);


					} catch (AssertionError e) {

						pass.ExcelFourData("customernew", "MaritalStatus", Globals.Inventory.MaritalStatus,
								MaritalStatus, "Fail", 14, 0, 14, 1, 14,
								2, 14, 3);

					}
					String Education = "";
					try {
						Education = rs.getString("CUST_EDUCATION");
						System.out.println(Education);
						Assert.assertEquals(Globals.Inventory.Education.trim(), Education.trim());

						pass.ExcelFourData("customernew", "Education", Globals.Inventory.Education, Education,
								"Pass", 15, 0, 15, 1, 15, 2, 15, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("customernew", "Education", Globals.Inventory.Education, Education,
								"Fail", 15, 0, 15, 1, 15, 2, 15, 3);

					}
					String Class = "";
					try {
						Class = rs.getString("CUST_CLASS");
						System.out.println(Class);
						Assert.assertEquals(Globals.Inventory.Class.trim(), Class.trim());

						pass.ExcelFourData("customernew", "Class", Globals.Inventory.Class, Class, "Pass", 16, 0, 16, 1, 16, 2, 16, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("customernew", "Class", Globals.Inventory.Class, Class, "Fail", 16, 0, 16, 1, 16, 2, 16, 3);


					}
					String Income = "";
					try {
						Income = rs.getString("CUST_INCOME_GROUP");
						System.out.println(Income);
						Assert.assertEquals(Globals.Inventory.Income.trim(), Income.trim());

						pass.ExcelFourData("customernew", "Income", Globals.Inventory.Income, Income, "Pass", 17, 0, 17, 1, 17, 2, 17, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("customernew", "Income", Globals.Inventory.Income, Income, "Fail",17, 0, 17, 1, 17, 2, 17, 3);
					}
					String MemberType = "";
					try {
						MemberType = rs.getString("CUST_TYPE");
						System.out.println(MemberType);
						Assert.assertEquals(Globals.Inventory.MemberType.trim(), MemberType.trim());

						pass.ExcelFourData("customernew", "MemberType", Globals.Inventory.MemberType,
								MemberType, "Pass",18, 0, 18,1, 18, 2, 18, 3);
								
								

					} catch (AssertionError e) {

						pass.ExcelFourData("customernew", "MemberType", Globals.Inventory.MemberType,
								MemberType, "Fail", 18, 0, 18,1, 18, 2, 18, 3);
								

					}
					String Representative = "";
					try {
						Representative = rs.getString("CUST_CUST_REPRESENTATIVE");
						System.out.println(Representative);
						Assert.assertEquals(Globals.Inventory.Representative.trim(), Representative.trim());

						pass.ExcelFourData("customernew", "Representative", Globals.Inventory.Representative, Representative, "Pass", 19,0, 19, 1, 19, 2, 19, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("customernew", "Representative", Globals.Inventory.Representative, Representative, "Fail", 19,0, 19, 1, 19, 2, 19, 3);

					}

					String Gender = "";
					try {
						Gender = rs.getString("CUST_GENDER");
						System.out.println(Gender);
						Assert.assertEquals(Globals.Inventory.Gender.trim(), Gender.trim());

						pass.ExcelFourData("customernew", "Gender", Globals.Inventory.Gender, Gender, "Pass",  20, 0,
								20, 1, 20, 2, 20, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("customernew", "Gender", Globals.Inventory.Gender, Gender, "Fail", 20, 0,
								20, 1, 20, 2, 20, 3);

					}
					/*String AnniversaryStatus = "";
					try {
						AnniversaryStatus = rs.getString("CUST_ANNIVERSARY_STATUS");
						System.out.println(AnniversaryStatus);
						Assert.assertEquals(Globals.Inventory.AnniversaryStatus.trim(), AnniversaryStatus.trim());

						pass.ExcelFourData("customernew", "AnniversaryStatus", Globals.Inventory.AnniversaryStatus, AnniversaryStatus, "Pass", 21, 0,
								21, 1, 21, 2, 21, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("customernew", "AnniversaryStatus", Globals.Inventory.AnniversaryStatus, AnniversaryStatus, "Fail", 21, 0,
								21, 1, 21, 2, 21, 3);

					}*/
					String Address1 = "";
					try {
						Address1 = rs.getString("CUST_ADDRESS1");
						System.out.println(Address1);
						Assert.assertEquals(Globals.Inventory.Address1.trim(), Address1.trim());

						pass.ExcelFourData("customernew", "Address1", Globals.Inventory.Address1, Address1, "Pass", 22, 0,
								22, 1, 22, 2, 22, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("customernew", "Address1", Globals.Inventory.Address1, Address1, "Fail", 22, 0,
								22, 1, 22, 2, 22, 3);

					}
					String Address2 = "";
					try {
						Address2 = rs.getString("CUST_ADDRESS2");
						System.out.println(Address2);
						Assert.assertEquals(Globals.Inventory.Address2.trim(), Address2.trim());

						pass.ExcelFourData("customernew", "Address2", Globals.Inventory.Address2, Address2, "Pass", 23, 0,
								23, 1, 23, 2, 23, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("customernew", "Address2", Globals.Inventory.Address2, Address2, "Fail", 23, 0,
								23, 1, 23, 2, 23, 3);

					}
					
					String Address3 = "";
					try {
						Address3 = rs.getString("CUST_ADDRESS3");
						System.out.println(Address3);
						Assert.assertEquals(Globals.Inventory.Address3.trim(), Address3.trim());

						pass.ExcelFourData("customernew", "Address3", Globals.Inventory.Address3, Address3, "Pass", 24, 0,
								24, 1, 24, 2, 24, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("customernew", "Address3", Globals.Inventory.Address3, Address3, "Fail", 24, 0,
								24, 1, 24, 2, 24, 3);

					}
					
					String Country = "";
					try {
						Country = rs.getString("CUST_COUNTRY_CODE");
						System.out.println(Country);
						Assert.assertEquals(Globals.Inventory.Country.trim(), Country.trim());

						pass.ExcelFourData("customernew", "Country", Globals.Inventory.Country, Country, "Pass", 25, 0,
								25, 1, 25, 2, 25, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("customernew", "Country", Globals.Inventory.Country, Country, "Fail", 25, 0,
								25, 1, 25, 2, 25, 3);

					}
					
					String State = "";
					try {
						State = rs.getString("CUST_STATE");
						System.out.println(State);
						Assert.assertEquals(Globals.Inventory.State.trim(), State.trim());

						pass.ExcelFourData("customernew", "State", Globals.Inventory.State, State, "Pass", 26, 0,
								26, 1, 26, 2, 26, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("customernew", "State", Globals.Inventory.State, State, "Fail", 26, 0,
								26, 1, 26, 2, 26, 3);

					}
					
					String Pin = "";
					try {
						Pin = rs.getString("CUST_PIN_CODE");
						System.out.println(Pin);
						Assert.assertEquals(Globals.Inventory.Pin.trim(), Pin.trim());

						pass.ExcelFourData("customernew", "Pin", Globals.Inventory.Pin, Pin, "Pass", 27, 0,
								27, 1, 27, 2, 27, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("customernew", "Pin", Globals.Inventory.Pin, Pin, "Fail", 27, 0,
								27, 1, 27, 2, 27, 3);

					}
					String Phone = "";
					try {
						Phone = rs.getString("CUST_RES_PHONE");
						System.out.println(Phone);
						Assert.assertEquals(Globals.Inventory.Phone.trim(), Phone.trim());

						pass.ExcelFourData("customernew", "Phone", Globals.Inventory.Phone, Phone, "Pass", 28, 0,
								28, 1, 28, 2, 28, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("customernew", "Phone", Globals.Inventory.Phone, Phone, "Fail", 28, 0,
								28, 1, 28, 2, 28, 3);

					}
					
					String Nationality = "";
					try {
						Nationality = rs.getString("CUST_NATIONALITY");
						System.out.println(Nationality);
						Assert.assertEquals(Globals.Inventory.Nationality.trim(), Nationality.trim());

						pass.ExcelFourData("customernew", "Nationality", Globals.Inventory.Nationality, Nationality, "Pass", 29, 0,
								29, 1, 29, 2, 29, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("customernew", "Nationality", Globals.Inventory.Nationality, Nationality, "Fail", 29, 0,
								29, 1, 29, 2, 29, 3);

					}
					
					String Zone = "";
					try {
						Pin = rs.getString("CUST_ZONE");
						System.out.println(Zone);
						Assert.assertEquals(Globals.Inventory.Zone.trim(), Zone.trim());

						pass.ExcelFourData("customernew", "Zone", Globals.Inventory.Zone, Zone, "Pass", 30, 0,
								30, 1, 30, 2, 30, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("customernew", "Zone", Globals.Inventory.Zone, Zone, "Fail", 30, 0,
								30, 1, 30, 2, 30, 3);

					}
					
					String City = "";
					try {
						City = rs.getString("CUST_CITY");
						System.out.println(City);
						Assert.assertEquals(Globals.Inventory.City.trim(), City.trim());

						pass.ExcelFourData("customernew", "City", Globals.Inventory.City, City, "Pass", 31, 0,
								31, 1, 31, 2, 31, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("customernew", "City", Globals.Inventory.City, City, "Fail", 31, 0,
								31, 1, 31, 2, 31, 3);

					}
					
					String MobileNo = "";
					try {
						MobileNo = rs.getString("CUST_MOBILE");
						System.out.println(MobileNo);
						Assert.assertEquals(Globals.Inventory.MobileNo.trim(), MobileNo.trim());

						pass.ExcelFourData("customernew", "MobileNo", Globals.Inventory.MobileNo, MobileNo, "Pass", 32, 0,
								32, 1, 32, 2, 32, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("customernew", "MobileNo", Globals.Inventory.MobileNo, MobileNo, "Fail", 32, 0,
								32, 1, 32, 2, 32, 3);

					}

					String PhoneO = "";
					try {
						PhoneO = rs.getString("CUST_OFF_PHONE");
						System.out.println(PhoneO);
						Assert.assertEquals(Globals.Inventory.PhoneO.trim(), PhoneO.trim());

						pass.ExcelFourData("customernew", "PhoneO", Globals.Inventory.PhoneO, PhoneO, "Pass", 33, 0,
								33, 1, 33, 2, 33, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("customernew", "PhoneO", Globals.Inventory.PhoneO, PhoneO, "Fail", 33, 0,
								33, 1, 33, 2, 33, 3);

					}

					String Email = "";
					try {
						Email = rs.getString("CUST_EMAIL");
						System.out.println(Email);
						Assert.assertEquals(Globals.Inventory.Email.trim(), Email.trim());

						pass.ExcelFourData("customernew", "Email", Globals.Inventory.Email, Email, "Pass", 34, 0,
								34, 1, 34, 2, 34, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("customernew", "Email", Globals.Inventory.Email, Email, "Fail", 34, 0,
								34, 1, 34, 2, 34, 3);

					}

					String LoyaltyCard = "";
					try {
						LoyaltyCard = rs.getString("CUST_LOYALTY_CARD_NO");
						System.out.println(LoyaltyCard);
						Assert.assertEquals(Globals.Inventory.LoyaltyCard.trim(), LoyaltyCard.trim());

						pass.ExcelFourData("customernew", "LoyaltyCard", Globals.Inventory.LoyaltyCard, LoyaltyCard, "Pass", 35, 0,
								35, 1, 35, 2, 35, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("customernew", "LoyaltyCard", Globals.Inventory.LoyaltyCard, LoyaltyCard, "Fail", 35, 0,
								35, 1, 35, 2, 35, 3);

					}

					String Price = "";
					try {
						Price = rs.getString("CUST_PRICE_TYPE");
						System.out.println(Price);
						Assert.assertEquals(Globals.Inventory.Price.trim(), Price.trim());

						pass.ExcelFourData("customernew", "Price", Globals.Inventory.Price, Price, "Pass", 36, 0,
								36, 1, 36, 2, 36, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("customernew", "Price", Globals.Inventory.Price, Price, "Fail", 36, 0,
								36, 1, 36, 2, 36, 3);

					}

					String CreditType = "";
					try {
						CreditType = rs.getString("CUST_CREDIT_TYPE");
						System.out.println(CreditType);
						Assert.assertEquals(Globals.Inventory.CreditType.trim(), CreditType.trim());

						pass.ExcelFourData("customernew", "CreditType", Globals.Inventory.CreditType, CreditType, "Pass", 37, 0,
								37, 1, 37, 2, 37, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("customernew", "CreditType", Globals.Inventory.CreditType, CreditType, "Fail", 37, 0,
								37, 1, 37, 2, 37, 3);

					}

					String CreditLimit = "";
					try {
						CreditLimit = rs.getString("CUST_CREDIT_LIMIT");
						System.out.println(CreditLimit);
						Assert.assertEquals(Globals.Inventory.CreditLimit.trim(), CreditLimit.trim());

						pass.ExcelFourData("customernew", "CreditLimit", Globals.Inventory.CreditLimit, CreditLimit, "Pass", 38, 0,
								38, 1, 38, 2, 38, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("customernew", "CreditLimit", Globals.Inventory.CreditLimit, CreditLimit, "Fail", 38, 0,
								38, 1, 38, 2, 38, 3);

					}

					String CreditDays = "";
					try {
						MobileNo = rs.getString("CUST_CREDIT_DAYS");
						System.out.println(CreditDays);
						Assert.assertEquals(Globals.Inventory.CreditDays.trim(), CreditDays.trim());

						pass.ExcelFourData("customernew", "CreditDays", Globals.Inventory.CreditDays, CreditDays, "Pass", 39, 0,
								39, 1, 39, 2, 39, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("customernew", "CreditDays", Globals.Inventory.CreditDays, CreditDays, "Fail", 39, 0,
								39, 1, 39, 2, 39, 3);

					}
					String Discount = "";
					try {
						Discount = rs.getString("CUST_DISCOUNT_PERCENTAGE");
						System.out.println(Discount);
						Assert.assertEquals(Globals.Inventory.Discount.trim(), Discount.trim());

						pass.ExcelFourData("customernew", "Discount", Globals.Inventory.Discount, Discount, "Pass", 40, 0,
								40, 1, 40, 2, 40, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("customernew", "Discount", Globals.Inventory.Discount, Discount, "Fail", 40, 0,
								40, 1, 40, 2, 40, 3);

					}
					
					
					
					
					
					break;
				}
			}
}
}

