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

import cucumber.api.java.en.Then;

public class Terminal extends PageObject {
	Terminaltypefield icp;
	TerminalPage terPage;
	AddInventoryFormPage Category;
	ExcelWrite pass;
	Screenshot scr;
	TerminalPage terpage;
    //WebDriver driver;
	public Terminal(Terminaltypefield icp) 
	{
		this.icp = icp;
		terPage = new TerminalPage();
		Category = new AddInventoryFormPage();
		pass=new ExcelWrite();
		scr = new Screenshot();
	}
	@Then("I load the TerminalNew sheet data to map")
	public void i_load_the_TerminalNew_sheet_data_to_map() {
		Globals.Inventory.TerminalNewSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME76);
	}

	@Then("I load the TerminalNew rowise  data for {string} rowname")
	public void i_load_the_TerminalNew_rowise_data_for_rowname(String row_name) {
		Globals.Inventory.TerminalNewrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.TerminalNewSheetData, row_name);
		System.out.println(Globals.Inventory.TerminalNewrowwiseData);
	}

	@Then("I update value to the TerminalNew page global Variables")
	public void i_update_value_to_the_TerminalNew_page_global_Variables() {
		Globals.Inventory.Location = Globals.Inventory.TerminalNewrowwiseData.get("Location");
		Globals.Inventory.SystemName = Globals.Inventory.TerminalNewrowwiseData.get("SystemName");
		Globals.Inventory.Floor = Globals.Inventory.TerminalNewrowwiseData.get("Floor");
		Globals.Inventory.PosScreenType = Globals.Inventory.TerminalNewrowwiseData.get("PosScreenType");
		Globals.Inventory.TillType = Globals.Inventory.TerminalNewrowwiseData.get("TillType");
		Globals.Inventory.TillCode = Globals.Inventory.TerminalNewrowwiseData.get("TillCode");
		Globals.Inventory.TillDesc = Globals.Inventory.TerminalNewrowwiseData.get("TillDesc");
		Globals.Inventory.IsPharmacyter = Globals.Inventory.TerminalNewrowwiseData.get("IsPharmacyter");
		Globals.Inventory.ItemDelAllowed = Globals.Inventory.TerminalNewrowwiseData.get("ItemDelAllowed");
		Globals.Inventory.SpecialCounter = Globals.Inventory.TerminalNewrowwiseData.get("SpecialCounter");
		Globals.Inventory.OpticalTerminal = Globals.Inventory.TerminalNewrowwiseData.get("OpticalTerminal");
		Globals.Inventory.AutoLoginPos = Globals.Inventory.TerminalNewrowwiseData.get("AutoLoginPos");
		Globals.Inventory.NegStock = Globals.Inventory.TerminalNewrowwiseData.get("NegStock");
		Globals.Inventory.PriceChangeAllowed = Globals.Inventory.TerminalNewrowwiseData.get("PriceChangeAllowed");
		Globals.Inventory.AllowDisCoupon = Globals.Inventory.TerminalNewrowwiseData.get("AllowDisCoupon");
		Globals.Inventory.AmazonPayMin = Globals.Inventory.TerminalNewrowwiseData.get("AmazonPayMin");
		Globals.Inventory.AmazonPayMax = Globals.Inventory.TerminalNewrowwiseData.get("AmazonPayMax");
		Globals.Inventory.CardsMin = Globals.Inventory.TerminalNewrowwiseData.get("CardsMin");
		Globals.Inventory.CardsMax = Globals.Inventory.TerminalNewrowwiseData.get("CardsMax");
		Globals.Inventory.CashMin = Globals.Inventory.TerminalNewrowwiseData.get("CashMin");
		Globals.Inventory.CashMax = Globals.Inventory.TerminalNewrowwiseData.get("CashMax");

		Globals.Inventory.ChequeMin = Globals.Inventory.TerminalNewrowwiseData.get("ChequeMin");
		Globals.Inventory.ChequeMax = Globals.Inventory.TerminalNewrowwiseData.get("ChequeMax");
		Globals.Inventory.CreditMin = Globals.Inventory.TerminalNewrowwiseData.get("CreditMin");
		Globals.Inventory.CreditMax = Globals.Inventory.TerminalNewrowwiseData.get("CreditMax");
		Globals.Inventory.CreditNoteMin = Globals.Inventory.TerminalNewrowwiseData.get("CreditNoteMin");
		Globals.Inventory.CreditNoteMax = Globals.Inventory.TerminalNewrowwiseData.get("CreditNoteMax");
		Globals.Inventory.DueMin = Globals.Inventory.TerminalNewrowwiseData.get("DueMin");
		Globals.Inventory.DueMax = Globals.Inventory.TerminalNewrowwiseData.get("DueMax");
		Globals.Inventory.FCouponsMin = Globals.Inventory.TerminalNewrowwiseData.get("FCouponsMin");
		Globals.Inventory.FCouponsMax = Globals.Inventory.TerminalNewrowwiseData.get("FCouponsMax");
		Globals.Inventory.FcurrencyMin = Globals.Inventory.TerminalNewrowwiseData.get("FcurrencyMin");
		Globals.Inventory.FcurrencyMax = Globals.Inventory.TerminalNewrowwiseData.get("FcurrencyMax");
		Globals.Inventory.GpayMin = Globals.Inventory.TerminalNewrowwiseData.get("GpayMin");
		Globals.Inventory.GpayMax = Globals.Inventory.TerminalNewrowwiseData.get("GpayMax");
		Globals.Inventory.GVmin = Globals.Inventory.TerminalNewrowwiseData.get("GVmin");
		Globals.Inventory.GvMax = Globals.Inventory.TerminalNewrowwiseData.get("GvMax");
		Globals.Inventory.LoyaltyMin = Globals.Inventory.TerminalNewrowwiseData.get("LoyaltyMin");
		Globals.Inventory.LoyaltyMax = Globals.Inventory.TerminalNewrowwiseData.get("LoyaltyMax");
		Globals.Inventory.OthersMin = Globals.Inventory.TerminalNewrowwiseData.get("OthersMin");
		Globals.Inventory.OthersMax = Globals.Inventory.TerminalNewrowwiseData.get("OthersMax");
		Globals.Inventory.PaytmMin = Globals.Inventory.TerminalNewrowwiseData.get("PaytmMin");
		Globals.Inventory.PaytmMax = Globals.Inventory.TerminalNewrowwiseData.get("PaytmMax");
		Globals.Inventory.PaytmsMin = Globals.Inventory.TerminalNewrowwiseData.get("PaytmsMin");
		Globals.Inventory.PaytmsMax = Globals.Inventory.TerminalNewrowwiseData.get("PaytmsMax");
		Globals.Inventory.Phonepemin = Globals.Inventory.TerminalNewrowwiseData.get("Phonepemin");
		Globals.Inventory.Phonepemax = Globals.Inventory.TerminalNewrowwiseData.get("Phonepemax");
		Globals.Inventory.SOadvmin = Globals.Inventory.TerminalNewrowwiseData.get("SOadvmin");
		Globals.Inventory.SOadvMax = Globals.Inventory.TerminalNewrowwiseData.get("SOadvMax");
		Globals.Inventory.SOdexoMin = Globals.Inventory.TerminalNewrowwiseData.get("SOdexoMin");
		Globals.Inventory.SOdexoMax = Globals.Inventory.TerminalNewrowwiseData.get("SOdexoMax");
		Globals.Inventory.UnPaidMin = Globals.Inventory.TerminalNewrowwiseData.get("UnPaidMin");
		Globals.Inventory.UnPaidMax = Globals.Inventory.TerminalNewrowwiseData.get("UnPaidMax");
		Globals.Inventory.WalletMin = Globals.Inventory.TerminalNewrowwiseData.get("WalletMin");
		Globals.Inventory.WalletMax = Globals.Inventory.TerminalNewrowwiseData.get("WalletMax");
		Globals.Inventory.Tender0 = Globals.Inventory.TerminalNewrowwiseData.get("Tender0");
		Globals.Inventory.Refund0 = Globals.Inventory.TerminalNewrowwiseData.get("Refund0");
		Globals.Inventory.Allow = Globals.Inventory.TerminalNewrowwiseData.get("Allow");
		Globals.Inventory.IsPrePrint = Globals.Inventory.TerminalNewrowwiseData.get("IsPrePrint");
		Globals.Inventory.Template0 = Globals.Inventory.TerminalNewrowwiseData.get("Template0");
		Globals.Inventory.print = Globals.Inventory.TerminalNewrowwiseData.get("print");
		Globals.Inventory.PrinterAttached = Globals.Inventory.TerminalNewrowwiseData.get("PrinterAttached");
		Globals.Inventory.LocDeviceName = Globals.Inventory.TerminalNewrowwiseData.get("LocDeviceName");
		Globals.Inventory.BarcodePrinter = Globals.Inventory.TerminalNewrowwiseData.get("BarcodePrinter");
		Globals.Inventory.PoleDisAttached = Globals.Inventory.TerminalNewrowwiseData.get("PoleDisAttached");
		Globals.Inventory.Port = Globals.Inventory.TerminalNewrowwiseData.get("Port");
		Globals.Inventory.PoleDisLogName = Globals.Inventory.TerminalNewrowwiseData.get("PoleDisLogName");
		Globals.Inventory.CashDrawerAttached = Globals.Inventory.TerminalNewrowwiseData.get("CashDrawerAttached");
		Globals.Inventory.CashDrawerLogDisName = Globals.Inventory.TerminalNewrowwiseData.get("CashDrawerLogDisName");
		Globals.Inventory.WeighingMachineAttached = Globals.Inventory.TerminalNewrowwiseData.get("WeighingMachineAttached");
		Globals.Inventory.SystemPort = Globals.Inventory.TerminalNewrowwiseData.get("SystemPort");
		Globals.Inventory.SystemAllow = Globals.Inventory.TerminalNewrowwiseData.get("SystemAllow");
		
		Globals.Inventory.BBill = Globals.Inventory.TerminalNewrowwiseData.get("Bbill");
		Globals.Inventory.CashBill = Globals.Inventory.TerminalNewrowwiseData.get("CashBill");
		Globals.Inventory.CashBill = Globals.Inventory.TerminalNewrowwiseData.get("CashBill");
		Globals.Inventory.CreditBill = Globals.Inventory.TerminalNewrowwiseData.get("CreditBill");
		Globals.Inventory.CustomerAdvance = Globals.Inventory.TerminalNewrowwiseData.get("CustomerAdvance");
		Globals.Inventory.CustomerReceivable = Globals.Inventory.TerminalNewrowwiseData.get("CustomerReceivable");
		Globals.Inventory.DeliveryChallan = Globals.Inventory.TerminalNewrowwiseData.get("DeliveryChallan");
		Globals.Inventory.DeliverySheet = Globals.Inventory.TerminalNewrowwiseData.get("DeliverySheet");
		Globals.Inventory.Estimation = Globals.Inventory.TerminalNewrowwiseData.get("Estimation");
		Globals.Inventory.GiftVoucher = Globals.Inventory.TerminalNewrowwiseData.get("GiftVoucher");
		Globals.Inventory.InterCompanySales = Globals.Inventory.TerminalNewrowwiseData.get("InterCompanySales");
		Globals.Inventory.Payment = Globals.Inventory.TerminalNewrowwiseData.get("Payment");
		Globals.Inventory.PreBill = Globals.Inventory.TerminalNewrowwiseData.get("PreBill");
		Globals.Inventory.Receipt = Globals.Inventory.TerminalNewrowwiseData.get("Receipt");
		Globals.Inventory.Refund = Globals.Inventory.TerminalNewrowwiseData.get("Refund");
		Globals.Inventory.SalesOrder = Globals.Inventory.TerminalNewrowwiseData.get("SalesOrder");
		Globals.Inventory.SalesReturnRequest = Globals.Inventory.TerminalNewrowwiseData.get("SRR");
		Globals.Inventory.ServiceBill = Globals.Inventory.TerminalNewrowwiseData.get("ServiceBill");
		Globals.Inventory.Settlement = Globals.Inventory.TerminalNewrowwiseData.get("Settlement");
		Globals.Inventory.StaffSales = Globals.Inventory.TerminalNewrowwiseData.get("StaffSales");
		Globals.Inventory.TradeIn = Globals.Inventory.TerminalNewrowwiseData.get("TradeIn");
		Globals.Inventory.VendorOrder = Globals.Inventory.TerminalNewrowwiseData.get("VendorOrder");
		
		
	
		
		
		
		
		
		
	}

	@Then("I fill new TerminalNew data page using excel data")
	public void i_fill_new_TerminalNew_data_page_using_excel_data() throws Exception {
		try {
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Location)) {
			GenericWrappers.sleepInSeconds(1);
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_ddlLocation_chzn\"]")).click();
			GenericWrappers.sleepInSeconds(1);

			WebElement LocationValue = webDriver
					.findElement(By.cssSelector("#ContentPlaceHolder1_ddlLocation_chzn > div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_ddlLocation_chzn > div > div > input[type=text]";
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
		/*if (GenericWrappers.isNotEmpty(Globals.Inventory.SystemName)) {
			terPage.terminal_waitClearEnterText_css(icp.SystemName_String, Globals.Inventory.SystemName);

		}*/
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Floor)) {
			GenericWrappers.sleepInSeconds(1);
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_ddlFloor_chzn\"]")).click();
			

			WebElement FloorValue = webDriver
					.findElement(By.cssSelector("#ContentPlaceHolder1_ddlFloor_chzn > div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_ddlFloor_chzn > div > div > input[type=text]";
			By ddlocator = By.cssSelector(css_location_dropDownValue);
			waitForExpectedElement(ddlocator);
			js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.Floor);
			GenericWrappers.sleepInSeconds(1);
			FloorValue.sendKeys(Keys.SPACE);
			FloorValue.sendKeys(Keys.SPACE);
			FloorValue.sendKeys(Keys.ARROW_DOWN);
			GenericWrappers.sleepInSeconds(1);
			FloorValue.sendKeys(Keys.ENTER);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.PosScreenType)) {
			GenericWrappers.sleepInSeconds(1);
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_ddlPosScreen_chzn\"]")).click();
		
			WebElement PosScreenTypeValue = webDriver
					.findElement(By.cssSelector("#ContentPlaceHolder1_ddlPosScreen_chzn > div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_ddlPosScreen_chzn > div > div > input[type=text]";
			By ddlocator = By.cssSelector(css_location_dropDownValue);
			waitForExpectedElement(ddlocator);
			js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.PosScreenType);
			GenericWrappers.sleepInSeconds(1);
			PosScreenTypeValue.sendKeys(Keys.SPACE);
			PosScreenTypeValue.sendKeys(Keys.SPACE);
			PosScreenTypeValue.sendKeys(Keys.ARROW_DOWN);
			GenericWrappers.sleepInSeconds(1);
			PosScreenTypeValue.sendKeys(Keys.ENTER);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.TillType)) {
			GenericWrappers.sleepInSeconds(1);
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_ddlTillType_chzn\"]/a/span")).click();
		
			WebElement TillTypeValue = webDriver
					.findElement(By.cssSelector("#ContentPlaceHolder1_ddlTillType_chzn > div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_ddlTillType_chzn > div > div > input[type=text]";
			By ddlocator = By.cssSelector(css_location_dropDownValue);
			waitForExpectedElement(ddlocator);
			js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.TillType);
			GenericWrappers.sleepInSeconds(1);
			TillTypeValue.sendKeys(Keys.SPACE);
			TillTypeValue.sendKeys(Keys.SPACE);
			TillTypeValue.sendKeys(Keys.ARROW_DOWN);
			GenericWrappers.sleepInSeconds(1);
			TillTypeValue.sendKeys(Keys.ENTER);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.TillCode)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.TillCode_String, Globals.Inventory.TillCode);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.TillDesc)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.TillDesc_String, Globals.Inventory.TillDesc);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.IsPharmacyter)) {
			terPage.get_checkBox_element_Xpath(icp.Pharmacy_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemDelAllowed)) {
			terPage.get_checkBox_element_Xpath(icp.ItemDelAllowed_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.SpecialCounter)) {
			terPage.get_checkBox_element_Xpath(icp.SpecialCounter_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.OpticalTerminal)) {
			terPage.get_checkBox_element_Xpath(icp.OpticalTerminal_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.AutoLoginPos)) {
			terPage.get_checkBox_element_Xpath(icp.AutoLoginPos_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.NegStock)) {
			terPage.get_checkBox_element_Xpath(icp.NegStock_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.PriceChangeAllowed)) {
			terPage.get_checkBox_element_Xpath(icp.PriceChangeAllowed_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.AllowDisCoupon)) {
			terPage.get_checkBox_element_Xpath(icp.AllowDis_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.AmazonPayMin)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.AmazonPayMin_String, Globals.Inventory.AmazonPayMin);
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.AmazonPayMax)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.AmazonPayMax_String, Globals.Inventory.AmazonPayMax);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Tender0)) {
			terPage.get_checkBox_element_Xpath(icp.Tender0_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Refund0)) {
			terPage.get_checkBox_element_Xpath(icp.Refund0_String).click();
		}
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.CardsMin)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Cardmin_String, Globals.Inventory.CardsMin);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.CardsMax)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.CardMax_String, Globals.Inventory.CardsMax);

		}	
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Tender0)) {
			terPage.get_checkBox_element_Xpath(icp.Tender1_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Refund0)) {
			terPage.get_checkBox_element_Xpath(icp.Refund1_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.CashMin)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Cashmin_String, Globals.Inventory.CashMin);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.CashMax)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Cashmax_String, Globals.Inventory.CashMax);

		}	
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Tender0)) {
			terPage.get_checkBox_element_Xpath(icp.Tender2_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Refund0)) {
			terPage.get_checkBox_element_Xpath(icp.Refund2_String).click();
		}
		
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.ChequeMin)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Chequemin_String, Globals.Inventory.ChequeMin);

		}	
		 
		if (GenericWrappers.isNotEmpty(Globals.Inventory.ChequeMax)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.ChequeMax_String, Globals.Inventory.ChequeMax);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Tender0)) {
			terPage.get_checkBox_element_Xpath(icp.Tender3_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Refund0)) {
			terPage.get_checkBox_element_Xpath(icp.Refund3_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.CreditMin)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.CreditMin_String, Globals.Inventory.CreditMin);

		}	
		if (GenericWrappers.isNotEmpty(Globals.Inventory.CreditMax)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Creditmax_String, Globals.Inventory.CreditMax);

		}	
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Tender0)) {
			terPage.get_checkBox_element_Xpath(icp.Tender4_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Refund0)) {
			terPage.get_checkBox_element_Xpath(icp.Refund4_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.CreditNoteMin)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.CreditNotemin_String, Globals.Inventory.CreditNoteMin);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.CreditNoteMax)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.CreditNoteMax_String, Globals.Inventory.CreditNoteMax);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Tender0)) {
			terPage.get_checkBox_element_Xpath(icp.Tender5_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Refund0)) {
			terPage.get_checkBox_element_Xpath(icp.Refund5_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.DueMin)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Duemin_String, Globals.Inventory.DueMin);

		}	
		 
		if (GenericWrappers.isNotEmpty(Globals.Inventory.DueMax)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Duemax_String, Globals.Inventory.DueMax);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Tender0)) {
			terPage.get_checkBox_element_Xpath(icp.Tender6_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Refund0)) {
			terPage.get_checkBox_element_Xpath(icp.Refund6_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.FCouponsMin)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Fcouponsmin_String, Globals.Inventory.FCouponsMin);

		}	
		if (GenericWrappers.isNotEmpty(Globals.Inventory.FCouponsMax)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.FcouponsMax_String, Globals.Inventory.FCouponsMax);

		}	
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Tender0)) {
			terPage.get_checkBox_element_Xpath(icp.Tender7_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Refund0)) {
			terPage.get_checkBox_element_Xpath(icp.Refund7_String).click();
		} 
		if (GenericWrappers.isNotEmpty(Globals.Inventory.FcurrencyMin)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.FcouponsCurrencymin_String, Globals.Inventory.FcurrencyMin);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.FcurrencyMax)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.FcouponCurrencymax_String, Globals.Inventory.FcurrencyMax);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Tender0)) {
			terPage.get_checkBox_element_Xpath(icp.Tender8_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Refund0)) {
			terPage.get_checkBox_element_Xpath(icp.Refund8_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.GpayMin)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Gpaymin_String, Globals.Inventory.GpayMin);

		}	
		 
		if (GenericWrappers.isNotEmpty(Globals.Inventory.GpayMax)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.GpayMax_String, Globals.Inventory.GpayMax);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Tender0)) {
			terPage.get_checkBox_element_Xpath(icp.Tender9_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Refund0)) {
			terPage.get_checkBox_element_Xpath(icp.Refund9_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.GVmin)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.GVMin_String, Globals.Inventory.GVmin);

		}	
		if (GenericWrappers.isNotEmpty(Globals.Inventory.GvMax)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.GVMAX_String, Globals.Inventory.GvMax);

		}	
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Tender0)) {
			terPage.get_checkBox_element_Xpath(icp.Tender10_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Refund0)) {
			terPage.get_checkBox_element_Xpath(icp.Refund10_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.LoyaltyMin)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Loyaltymin_String, Globals.Inventory.LoyaltyMin);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.LoyaltyMax)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.LoyaltyMax_String, Globals.Inventory.LoyaltyMax);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Tender0)) {
			terPage.get_checkBox_element_Xpath(icp.Tender11_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Refund0)) {
			terPage.get_checkBox_element_Xpath(icp.Refund11_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.OthersMin)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.OthersMin_String, Globals.Inventory.OthersMin);

		}	
		 
		if (GenericWrappers.isNotEmpty(Globals.Inventory.OthersMax)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.OthersMax_String, Globals.Inventory.OthersMax);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Tender0)) {
			terPage.get_checkBox_element_Xpath(icp.Tender12_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Refund0)) {
			terPage.get_checkBox_element_Xpath(icp.Refund12_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.PaytmMin)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Paytmmin_String, Globals.Inventory.PaytmMin);

		}	
		
		 
		if (GenericWrappers.isNotEmpty(Globals.Inventory.PaytmMax)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.PaytmMax_String, Globals.Inventory.PaytmMax);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Tender0)) {
			terPage.get_checkBox_element_Xpath(icp.Tender13_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Refund0)) {
			terPage.get_checkBox_element_Xpath(icp.Refund13_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.PaytmsMin)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Paytmsmin_String, Globals.Inventory.PaytmsMin);

		}	
		
		 
		if (GenericWrappers.isNotEmpty(Globals.Inventory.PaytmsMax)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Paytmsmax_String, Globals.Inventory.PaytmsMax);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Tender0)) {
			terPage.get_checkBox_element_Xpath(icp.Tender14_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Refund0)) {
			terPage.get_checkBox_element_Xpath(icp.Refund14_String).click();
		}
	
		 
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Phonepemin)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Phonepemin_String, Globals.Inventory.Phonepemin);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Phonepemax)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.PhonepeMax_String, Globals.Inventory.Phonepemax);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Tender0)) {
			terPage.get_checkBox_element_Xpath(icp.Tender15_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Refund0)) {
			terPage.get_checkBox_element_Xpath(icp.Refund15_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.SOadvmin)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.SOadvMin_String, Globals.Inventory.SOadvmin);

		}	
		 
		if (GenericWrappers.isNotEmpty(Globals.Inventory.SOadvMax)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.soadvmax_String, Globals.Inventory.SOadvMax);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Tender0)) {
			terPage.get_checkBox_element_Xpath(icp.Tender16_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Refund0)) {
			terPage.get_checkBox_element_Xpath(icp.Refund16_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.SOdexoMin)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.SOdexomin_String, Globals.Inventory.SOdexoMin);

		}	
		if (GenericWrappers.isNotEmpty(Globals.Inventory.SOdexoMax)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.SOdexoMax_String, Globals.Inventory.SOdexoMax);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Tender0)) {
			terPage.get_checkBox_element_Xpath(icp.Tender17_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Refund0)) {
			terPage.get_checkBox_element_Xpath(icp.Refund17_String).click();
		}
		 
		if (GenericWrappers.isNotEmpty(Globals.Inventory.UnPaidMin)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.UnpaidMin_String, Globals.Inventory.UnPaidMin);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.UnPaidMax)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.UnpaidMax_String, Globals.Inventory.UnPaidMax);

		}	
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Tender0)) {
			terPage.get_checkBox_element_Xpath(icp.Tender18_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Refund0)) {
			terPage.get_checkBox_element_Xpath(icp.Refund18_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.WalletMin)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Walletmin_String, Globals.Inventory.WalletMin);

		}	
		 
		if (GenericWrappers.isNotEmpty(Globals.Inventory.WalletMax)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.WalletMax_String, Globals.Inventory.WalletMax);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Tender0)) {
			terPage.get_checkBox_element_Xpath(icp.Tender19_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Refund0)) {
			terPage.get_checkBox_element_Xpath(icp.Refund19_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Allow)) {
			terPage.get_checkBox_element_Xpath(icp.Allow_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.IsPrePrint)) {
			terPage.get_checkBox_element_Xpath(icp.Ispreprint_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.BBill)) {
			GenericWrappers.sleepInSeconds(1);
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_grdTransaction_ddlTemplate_0_chzn\"]")).click();
			GenericWrappers.sleepInSeconds(1);

			WebElement Template0Value = webDriver
					.findElement(By.cssSelector("#ContentPlaceHolder1_grdTransaction_ddlTemplate_0_chzn > div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_grdTransaction_ddlTemplate_0_chzn > div > div > input[type=text]";
			By ddlocator = By.cssSelector(css_location_dropDownValue);
			waitForExpectedElement(ddlocator);
			js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.BBill);
			GenericWrappers.sleepInSeconds(1);
			Template0Value.sendKeys(Keys.SPACE);
			Template0Value.sendKeys(Keys.SPACE);
			Template0Value.sendKeys(Keys.ARROW_DOWN);
			GenericWrappers.sleepInSeconds(1);
			Template0Value.sendKeys(Keys.ENTER);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.print)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Print0_String, Globals.Inventory.print);

		}	
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Allow)) {
			terPage.get_checkBox_element_Xpath(icp.Allow1_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.IsPrePrint)) {
			terPage.get_checkBox_element_Xpath(icp.Ispreprint1_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.CashBill)) {
			GenericWrappers.sleepInSeconds(1);
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_grdTransaction_ddlTemplate_1_chzn\"]")).click();
			GenericWrappers.sleepInSeconds(1);

			WebElement Template0Value = webDriver
					.findElement(By.cssSelector("#ContentPlaceHolder1_grdTransaction_ddlTemplate_1_chzn > div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_grdTransaction_ddlTemplate_1_chzn > div > div > input[type=text]";
			By ddlocator = By.cssSelector(css_location_dropDownValue);
			waitForExpectedElement(ddlocator);
			js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.CashBill);
			GenericWrappers.sleepInSeconds(1);
			Template0Value.sendKeys(Keys.SPACE);
			Template0Value.sendKeys(Keys.SPACE);
			Template0Value.sendKeys(Keys.ARROW_DOWN);
			GenericWrappers.sleepInSeconds(1);
			Template0Value.sendKeys(Keys.ENTER);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.print)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Print1_String, Globals.Inventory.print);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Allow)) {
			terPage.get_checkBox_element_Xpath(icp.Allow2_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.IsPrePrint)) {
			terPage.get_checkBox_element_Xpath(icp.Ispreprint2_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.CashBill)) {
			GenericWrappers.sleepInSeconds(1);
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_grdTransaction_ddlTemplate_2_chzn\"]")).click();
			GenericWrappers.sleepInSeconds(1);

			WebElement Template0Value = webDriver
					.findElement(By.cssSelector("#ContentPlaceHolder1_grdTransaction_ddlTemplate_2_chzn > div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_grdTransaction_ddlTemplate_2_chzn > div > div > input[type=text]";
			By ddlocator = By.cssSelector(css_location_dropDownValue);
			waitForExpectedElement(ddlocator);
			js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.CashBill);
			GenericWrappers.sleepInSeconds(1);
			Template0Value.sendKeys(Keys.SPACE);
			Template0Value.sendKeys(Keys.SPACE);
			Template0Value.sendKeys(Keys.ARROW_DOWN);
			GenericWrappers.sleepInSeconds(1);
			Template0Value.sendKeys(Keys.ENTER);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.print)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Print2_String, Globals.Inventory.print);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Allow)) {
			terPage.get_checkBox_element_Xpath(icp.Allow3_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.IsPrePrint)) {
			terPage.get_checkBox_element_Xpath(icp.Ispreprint3_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.CreditBill)) {
			GenericWrappers.sleepInSeconds(1);
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_grdTransaction_ddlTemplate_3_chzn\"]")).click();
			GenericWrappers.sleepInSeconds(1);

			WebElement Template0Value = webDriver
					.findElement(By.cssSelector("#ContentPlaceHolder1_grdTransaction_ddlTemplate_3_chzn > div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_grdTransaction_ddlTemplate_3_chzn > div > div > input[type=text]";
			By ddlocator = By.cssSelector(css_location_dropDownValue);
			waitForExpectedElement(ddlocator);
			js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.CreditBill);
			GenericWrappers.sleepInSeconds(1);
			Template0Value.sendKeys(Keys.SPACE);
			Template0Value.sendKeys(Keys.SPACE);
			Template0Value.sendKeys(Keys.ARROW_DOWN);
			GenericWrappers.sleepInSeconds(1);
			Template0Value.sendKeys(Keys.ENTER);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.print)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Print3_String, Globals.Inventory.print);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Allow)) {
			terPage.get_checkBox_element_Xpath(icp.Allow4_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.IsPrePrint)) {
			terPage.get_checkBox_element_Xpath(icp.Ispreprint4_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.CustomerAdvance)) {
			GenericWrappers.sleepInSeconds(1);
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_grdTransaction_ddlTemplate_4_chzn\"]")).click();
			GenericWrappers.sleepInSeconds(1);

			WebElement Template0Value = webDriver
					.findElement(By.cssSelector("#ContentPlaceHolder1_grdTransaction_ddlTemplate_4_chzn > div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_grdTransaction_ddlTemplate_4_chzn > div > div > input[type=text]";
			By ddlocator = By.cssSelector(css_location_dropDownValue);
			waitForExpectedElement(ddlocator);
			js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.CustomerAdvance);
			GenericWrappers.sleepInSeconds(1);
			Template0Value.sendKeys(Keys.SPACE);
			Template0Value.sendKeys(Keys.SPACE);
			Template0Value.sendKeys(Keys.ARROW_DOWN);
			GenericWrappers.sleepInSeconds(1);
			Template0Value.sendKeys(Keys.ENTER);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.print)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Print4_String, Globals.Inventory.print);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Allow)) {
			terPage.get_checkBox_element_Xpath(icp.Allow5_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.IsPrePrint)) {
			terPage.get_checkBox_element_Xpath(icp.Ispreprint5_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.CustomerReceivable)) {
			GenericWrappers.sleepInSeconds(1);
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_grdTransaction_ddlTemplate_5_chzn\"]")).click();
			GenericWrappers.sleepInSeconds(1);

			WebElement Template0Value = webDriver
					.findElement(By.cssSelector("#ContentPlaceHolder1_grdTransaction_ddlTemplate_5_chzn > div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_grdTransaction_ddlTemplate_5_chzn > div > div > input[type=text]";
			By ddlocator = By.cssSelector(css_location_dropDownValue);
			waitForExpectedElement(ddlocator);
			js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.CustomerReceivable);
			GenericWrappers.sleepInSeconds(1);
			Template0Value.sendKeys(Keys.SPACE);
			Template0Value.sendKeys(Keys.SPACE);
			Template0Value.sendKeys(Keys.ARROW_DOWN);
			GenericWrappers.sleepInSeconds(1);
			Template0Value.sendKeys(Keys.ENTER);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.print)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Print5_String, Globals.Inventory.print);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Allow)) {
			terPage.get_checkBox_element_Xpath(icp.Allow6_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.IsPrePrint)) {
			terPage.get_checkBox_element_Xpath(icp.Ispreprint6_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.DeliveryChallan)) {
			GenericWrappers.sleepInSeconds(1);
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_grdTransaction_ddlTemplate_6_chzn\"]")).click();
			GenericWrappers.sleepInSeconds(1);

			WebElement Template0Value = webDriver
					.findElement(By.cssSelector("#ContentPlaceHolder1_grdTransaction_ddlTemplate_6_chzn > div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_grdTransaction_ddlTemplate_6_chzn > div > div > input[type=text]";
			By ddlocator = By.cssSelector(css_location_dropDownValue);
			waitForExpectedElement(ddlocator);
			js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.DeliveryChallan);
			GenericWrappers.sleepInSeconds(1);
			Template0Value.sendKeys(Keys.SPACE);
			Template0Value.sendKeys(Keys.SPACE);
			Template0Value.sendKeys(Keys.ARROW_DOWN);
			GenericWrappers.sleepInSeconds(1);
			Template0Value.sendKeys(Keys.ENTER);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.print)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Print6_String, Globals.Inventory.print);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Allow)) {
			terPage.get_checkBox_element_Xpath(icp.Allow7_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.IsPrePrint)) {
			terPage.get_checkBox_element_Xpath(icp.Ispreprint7_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.DeliverySheet)) {
			GenericWrappers.sleepInSeconds(1);
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_grdTransaction_ddlTemplate_7_chzn\"]")).click();
			GenericWrappers.sleepInSeconds(1);

			WebElement Template0Value = webDriver
					.findElement(By.cssSelector("#ContentPlaceHolder1_grdTransaction_ddlTemplate_7_chzn > div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_grdTransaction_ddlTemplate_7_chzn > div > div > input[type=text]";
			By ddlocator = By.cssSelector(css_location_dropDownValue);
			waitForExpectedElement(ddlocator);
			js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.DeliverySheet);
			GenericWrappers.sleepInSeconds(1);
			Template0Value.sendKeys(Keys.SPACE);
			Template0Value.sendKeys(Keys.SPACE);
			Template0Value.sendKeys(Keys.ARROW_DOWN);
			GenericWrappers.sleepInSeconds(1);
			Template0Value.sendKeys(Keys.ENTER);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.print)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Print7_String, Globals.Inventory.print);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Allow)) {
			terPage.get_checkBox_element_Xpath(icp.Allow15_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.IsPrePrint)) {
			terPage.get_checkBox_element_Xpath(icp.Ispreprint15_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Estimation)) {
			GenericWrappers.sleepInSeconds(1);
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_grdTransaction_ddlTemplate_15_chzn\"]")).click();
			GenericWrappers.sleepInSeconds(1);

			WebElement Template0Value = webDriver
					.findElement(By.cssSelector("#ContentPlaceHolder1_grdTransaction_ddlTemplate_15_chzn > div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_grdTransaction_ddlTemplate_15_chzn > div > div > input[type=text]";
			By ddlocator = By.cssSelector(css_location_dropDownValue);
			waitForExpectedElement(ddlocator);
			js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.Estimation);
			GenericWrappers.sleepInSeconds(1);
			Template0Value.sendKeys(Keys.SPACE);
			Template0Value.sendKeys(Keys.SPACE);
			Template0Value.sendKeys(Keys.ARROW_DOWN);
			GenericWrappers.sleepInSeconds(1);
			Template0Value.sendKeys(Keys.ENTER);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.print)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Print15_String, Globals.Inventory.print);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Allow)) {
			terPage.get_checkBox_element_Xpath(icp.Allow16_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.IsPrePrint)) {
			terPage.get_checkBox_element_Xpath(icp.Ispreprint16_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.GiftVoucher)) {
			GenericWrappers.sleepInSeconds(1);
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_grdTransaction_ddlTemplate_16_chzn\"]/a/span")).click();
			GenericWrappers.sleepInSeconds(1);

			WebElement Template0Value = webDriver
					.findElement(By.cssSelector("#ContentPlaceHolder1_grdTransaction_ddlTemplate_16_chzn > div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_grdTransaction_ddlTemplate_16_chzn > div > div > input[type=text]";
			By ddlocator = By.cssSelector(css_location_dropDownValue);
			waitForExpectedElement(ddlocator);
			js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.GiftVoucher);
			GenericWrappers.sleepInSeconds(1);
			Template0Value.sendKeys(Keys.SPACE);
			Template0Value.sendKeys(Keys.SPACE);
			Template0Value.sendKeys(Keys.ARROW_DOWN);
			GenericWrappers.sleepInSeconds(1);
			Template0Value.sendKeys(Keys.ENTER);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.print)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Print16_String, Globals.Inventory.print);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Allow)) {
			terPage.get_checkBox_element_Xpath(icp.Allow17_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.IsPrePrint)) {
			terPage.get_checkBox_element_Xpath(icp.Ispreprint17_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.InterCompanySales)) {
			GenericWrappers.sleepInSeconds(1);
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_grdTransaction_ddlTemplate_17_chzn\"]")).click();
			GenericWrappers.sleepInSeconds(1);

			WebElement Template0Value = webDriver
					.findElement(By.cssSelector("#ContentPlaceHolder1_grdTransaction_ddlTemplate_17_chzn > div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_grdTransaction_ddlTemplate_17_chzn > div > div > input[type=text]";
			By ddlocator = By.cssSelector(css_location_dropDownValue);
			waitForExpectedElement(ddlocator);
			js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.InterCompanySales);
			GenericWrappers.sleepInSeconds(1);
			Template0Value.sendKeys(Keys.SPACE);
			Template0Value.sendKeys(Keys.SPACE);
			Template0Value.sendKeys(Keys.ARROW_DOWN);
			GenericWrappers.sleepInSeconds(1);
			Template0Value.sendKeys(Keys.ENTER);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.print)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Print17_String, Globals.Inventory.print);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Allow)) {
			terPage.get_checkBox_element_Xpath(icp.Allow18_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.IsPrePrint)) {
			terPage.get_checkBox_element_Xpath(icp.Ispreprint18_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Payment)) {
			GenericWrappers.sleepInSeconds(1);
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_grdTransaction_ddlTemplate_18_chzn\"]")).click();
			GenericWrappers.sleepInSeconds(1);

			WebElement Template0Value = webDriver
					.findElement(By.cssSelector("#ContentPlaceHolder1_grdTransaction_ddlTemplate_18_chzn > div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_grdTransaction_ddlTemplate_18_chzn > div > div > input[type=text]";
			By ddlocator = By.cssSelector(css_location_dropDownValue);
			waitForExpectedElement(ddlocator);
			js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.Payment);
			GenericWrappers.sleepInSeconds(1);
			Template0Value.sendKeys(Keys.SPACE);
			Template0Value.sendKeys(Keys.SPACE);
			Template0Value.sendKeys(Keys.ARROW_DOWN);
			GenericWrappers.sleepInSeconds(1);
			Template0Value.sendKeys(Keys.ENTER);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.print)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Print18_String, Globals.Inventory.print);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Allow)) {
			terPage.get_checkBox_element_Xpath(icp.Allow19_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.IsPrePrint)) {
			terPage.get_checkBox_element_Xpath(icp.Ispreprint19_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.PreBill)) {
			GenericWrappers.sleepInSeconds(1);
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_grdTransaction_ddlTemplate_19_chzn\"]")).click();
			GenericWrappers.sleepInSeconds(1);

			WebElement Template0Value = webDriver
					.findElement(By.cssSelector("#ContentPlaceHolder1_grdTransaction_ddlTemplate_19_chzn > div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_grdTransaction_ddlTemplate_19_chzn > div > div > input[type=text]";
			By ddlocator = By.cssSelector(css_location_dropDownValue);
			waitForExpectedElement(ddlocator);
			js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.PreBill);
			GenericWrappers.sleepInSeconds(1);
			Template0Value.sendKeys(Keys.SPACE);
			Template0Value.sendKeys(Keys.SPACE);
			Template0Value.sendKeys(Keys.ARROW_DOWN);
			GenericWrappers.sleepInSeconds(1);
			Template0Value.sendKeys(Keys.ENTER);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.print)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Print19_String, Globals.Inventory.print);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Allow)) {
			terPage.get_checkBox_element_Xpath(icp.Allow22_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.IsPrePrint)) {
			terPage.get_checkBox_element_Xpath(icp.Ispreprint22_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Receipt)) {
			GenericWrappers.sleepInSeconds(1);
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_grdTransaction_ddlTemplate_22_chzn\"]")).click();
			GenericWrappers.sleepInSeconds(1);

			WebElement Template0Value = webDriver
					.findElement(By.cssSelector("#ContentPlaceHolder1_grdTransaction_ddlTemplate_22_chzn > div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_grdTransaction_ddlTemplate_22_chzn > div > div > input[type=text]";
			By ddlocator = By.cssSelector(css_location_dropDownValue);
			waitForExpectedElement(ddlocator);
			js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.Receipt);
			GenericWrappers.sleepInSeconds(1);
			Template0Value.sendKeys(Keys.SPACE);
			Template0Value.sendKeys(Keys.SPACE);
			Template0Value.sendKeys(Keys.ARROW_DOWN);
			GenericWrappers.sleepInSeconds(1);
			Template0Value.sendKeys(Keys.ENTER);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.print)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Print22_String, Globals.Inventory.print);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Allow)) {
			terPage.get_checkBox_element_Xpath(icp.Allow23_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.IsPrePrint)) {
			terPage.get_checkBox_element_Xpath(icp.Ispreprint23_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Refund)) {
			GenericWrappers.sleepInSeconds(1);
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_grdTransaction_ddlTemplate_23_chzn\"]")).click();
			GenericWrappers.sleepInSeconds(1);

			WebElement Template0Value = webDriver
					.findElement(By.cssSelector("#ContentPlaceHolder1_grdTransaction_ddlTemplate_23_chzn > div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_grdTransaction_ddlTemplate_23_chzn > div > div > input[type=text]";
			By ddlocator = By.cssSelector(css_location_dropDownValue);
			waitForExpectedElement(ddlocator);
			js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.Refund);
			GenericWrappers.sleepInSeconds(1);
			Template0Value.sendKeys(Keys.SPACE);
			Template0Value.sendKeys(Keys.SPACE);
			Template0Value.sendKeys(Keys.ARROW_DOWN);
			GenericWrappers.sleepInSeconds(1);
			Template0Value.sendKeys(Keys.ENTER);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.print)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Print23_String, Globals.Inventory.print);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Allow)) {
			terPage.get_checkBox_element_Xpath(icp.Allow24_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.IsPrePrint)) {
			terPage.get_checkBox_element_Xpath(icp.Ispreprint24_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.SalesOrder)) {
			GenericWrappers.sleepInSeconds(1);
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_grdTransaction_ddlTemplate_24_chzn\"]")).click();
			GenericWrappers.sleepInSeconds(1);

			WebElement Template0Value = webDriver
					.findElement(By.cssSelector("#ContentPlaceHolder1_grdTransaction_ddlTemplate_24_chzn > div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_grdTransaction_ddlTemplate_24_chzn > div > div > input[type=text]";
			By ddlocator = By.cssSelector(css_location_dropDownValue);
			waitForExpectedElement(ddlocator);
			js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.SalesOrder);
			GenericWrappers.sleepInSeconds(1);
			Template0Value.sendKeys(Keys.SPACE);
			Template0Value.sendKeys(Keys.SPACE);
			Template0Value.sendKeys(Keys.ARROW_DOWN);
			GenericWrappers.sleepInSeconds(1);
			Template0Value.sendKeys(Keys.ENTER);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.print)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Print24_String, Globals.Inventory.print);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Allow)) {
			terPage.get_checkBox_element_Xpath(icp.Allow25_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.IsPrePrint)) {
			terPage.get_checkBox_element_Xpath(icp.Ispreprint25_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.SalesReturnRequest)) {
			GenericWrappers.sleepInSeconds(1);
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_grdTransaction_ddlTemplate_25_chzn\"]")).click();
			GenericWrappers.sleepInSeconds(1);

			WebElement Template0Value = webDriver
					.findElement(By.cssSelector("#ContentPlaceHolder1_grdTransaction_ddlTemplate_25_chzn > div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_grdTransaction_ddlTemplate_25_chzn > div > div > input[type=text]";
			By ddlocator = By.cssSelector(css_location_dropDownValue);
			waitForExpectedElement(ddlocator);
			js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.SalesReturnRequest);
			GenericWrappers.sleepInSeconds(1);
			Template0Value.sendKeys(Keys.SPACE);
			Template0Value.sendKeys(Keys.SPACE);
			Template0Value.sendKeys(Keys.ARROW_DOWN);
			GenericWrappers.sleepInSeconds(1);
			Template0Value.sendKeys(Keys.ENTER);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.print)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Print25_String, Globals.Inventory.print);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Allow)) {
			terPage.get_checkBox_element_Xpath(icp.Allow26_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.IsPrePrint)) {
			terPage.get_checkBox_element_Xpath(icp.Ispreprint26_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.ServiceBill)) {
			GenericWrappers.sleepInSeconds(1);
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_grdTransaction_ddlTemplate_26_chzn\"]")).click();
			GenericWrappers.sleepInSeconds(1);

			WebElement Template0Value = webDriver
					.findElement(By.cssSelector("#ContentPlaceHolder1_grdTransaction_ddlTemplate_26_chzn > div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_grdTransaction_ddlTemplate_26_chzn > div > div > input[type=text]";
			By ddlocator = By.cssSelector(css_location_dropDownValue);
			waitForExpectedElement(ddlocator);
			js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.ServiceBill);
			GenericWrappers.sleepInSeconds(1);
			Template0Value.sendKeys(Keys.SPACE);
			Template0Value.sendKeys(Keys.SPACE);
			Template0Value.sendKeys(Keys.ARROW_DOWN);
			GenericWrappers.sleepInSeconds(1);
			Template0Value.sendKeys(Keys.ENTER);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.print)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Print26_String, Globals.Inventory.print);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Allow)) {
			terPage.get_checkBox_element_Xpath(icp.Allow27_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.IsPrePrint)) {
			terPage.get_checkBox_element_Xpath(icp.Ispreprint27_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Settlement)) {
			GenericWrappers.sleepInSeconds(1);
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_grdTransaction_ddlTemplate_27_chzn\"]")).click();
			GenericWrappers.sleepInSeconds(1);

			WebElement Template0Value = webDriver
					.findElement(By.cssSelector("#ContentPlaceHolder1_grdTransaction_ddlTemplate_27_chzn > div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_grdTransaction_ddlTemplate_27_chzn > div > div > input[type=text]";
			By ddlocator = By.cssSelector(css_location_dropDownValue);
			waitForExpectedElement(ddlocator);
			js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.Settlement);
			GenericWrappers.sleepInSeconds(1);
			Template0Value.sendKeys(Keys.SPACE);
			Template0Value.sendKeys(Keys.SPACE);
			Template0Value.sendKeys(Keys.ARROW_DOWN);
			GenericWrappers.sleepInSeconds(1);
			Template0Value.sendKeys(Keys.ENTER);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.print)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Print27_String, Globals.Inventory.print);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Allow)) {
			terPage.get_checkBox_element_Xpath(icp.Allow28_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.IsPrePrint)) {
			terPage.get_checkBox_element_Xpath(icp.Ispreprint28_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.StaffSales)) {
			GenericWrappers.sleepInSeconds(1);
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_grdTransaction_ddlTemplate_28_chzn\"]")).click();
			GenericWrappers.sleepInSeconds(1);

			WebElement Template0Value = webDriver
					.findElement(By.cssSelector("#ContentPlaceHolder1_grdTransaction_ddlTemplate_28_chzn > div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_grdTransaction_ddlTemplate_28_chzn > div > div > input[type=text]";
			By ddlocator = By.cssSelector(css_location_dropDownValue);
			waitForExpectedElement(ddlocator);
			js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.StaffSales);
			GenericWrappers.sleepInSeconds(1);
			Template0Value.sendKeys(Keys.SPACE);
			Template0Value.sendKeys(Keys.SPACE);
			Template0Value.sendKeys(Keys.ARROW_DOWN);
			GenericWrappers.sleepInSeconds(1);
			Template0Value.sendKeys(Keys.ENTER);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.print)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Print28_String, Globals.Inventory.print);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Allow)) {
			terPage.get_checkBox_element_Xpath(icp.Allow29_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.IsPrePrint)) {
			terPage.get_checkBox_element_Xpath(icp.Ispreprint29_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.TradeIn)) {
			GenericWrappers.sleepInSeconds(1);//*[@id="ContentPlaceHolder1_grdTransaction_ddlTemplate_29_chzn"]
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_grdTransaction_ddlTemplate_29_chzn\"]")).click();
			GenericWrappers.sleepInSeconds(1);

			WebElement Template0Value = webDriver
					.findElement(By.cssSelector("#ContentPlaceHolder1_grdTransaction_ddlTemplate_29_chzn > div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_grdTransaction_ddlTemplate_29_chzn > div > div > input[type=text]";
			By ddlocator = By.cssSelector(css_location_dropDownValue);
			waitForExpectedElement(ddlocator);
			js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.TradeIn);
			GenericWrappers.sleepInSeconds(1);
			Template0Value.sendKeys(Keys.SPACE);
			Template0Value.sendKeys(Keys.SPACE);
			Template0Value.sendKeys(Keys.ARROW_DOWN);
			GenericWrappers.sleepInSeconds(1);
			Template0Value.sendKeys(Keys.ENTER);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.print)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Print29_String, Globals.Inventory.print);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Allow)) {
			terPage.get_checkBox_element_Xpath(icp.Allow30_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.IsPrePrint)) {
			terPage.get_checkBox_element_Xpath(icp.Ispreprint30_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.VendorOrder)) {
			GenericWrappers.sleepInSeconds(1);
			webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_grdTransaction_ddlTemplate_30_chzn\"]")).click();
			GenericWrappers.sleepInSeconds(1);

			WebElement Template0Value = webDriver
					.findElement(By.cssSelector("#ContentPlaceHolder1_grdTransaction_ddlTemplate_30_chzn > div > div > input[type=text]"));
			String css_location_dropDownValue = "#ContentPlaceHolder1_grdTransaction_ddlTemplate_30_chzn > div > div > input[type=text]";
			By ddlocator = By.cssSelector(css_location_dropDownValue);
			waitForExpectedElement(ddlocator);
			js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.VendorOrder);
			GenericWrappers.sleepInSeconds(1);
			Template0Value.sendKeys(Keys.SPACE);
			Template0Value.sendKeys(Keys.SPACE);
			Template0Value.sendKeys(Keys.ARROW_DOWN);
			GenericWrappers.sleepInSeconds(1);
			Template0Value.sendKeys(Keys.ENTER);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.print)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Print30_String, Globals.Inventory.print);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.PrinterAttached)) {
			terPage.get_checkBox_element_Xpath(icp.PrinterAttached_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.LocDeviceName)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.LocalDevice_String, Globals.Inventory.LocDeviceName);

		}	
		if (GenericWrappers.isNotEmpty(Globals.Inventory.BarcodePrinter)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.BarcodePrinter_String, Globals.Inventory.BarcodePrinter);
		}
		pass.ExcelFourData("terminalnew","Modules", "Actual", "Expected", "Status",
				0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
		pass.Excelcreate("terminalnew", "TerminalNew", "Pass", 1, 0, 1, 3);
		}
       catch(Exception e) {
			
			scr.Screenshots();
			System.out.println("Screen shot taken");
			
			pass.ExcelFourData("terminalnew","Modules", "Actual", "Expected", "Status",
					0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
			pass.Excelcreate("terminalnew", "TerminalNew", "FAIL", 1, 0, 1, 3);
}
		}	
		@Then("I fill Pole Display\\/Cash Drawer")
		public void i_fill_Pole_Display_Cash_Drawer() {
		   
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.PoleDisAttached)) {
			terPage.get_checkBox_element_Xpath(icp.PolDisAttached_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Port)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.Port_String, Globals.Inventory.Port);

		}	
		if (GenericWrappers.isNotEmpty(Globals.Inventory.PoleDisLogName)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.LogDisName_String, Globals.Inventory.PoleDisLogName);

		}	
		if (GenericWrappers.isNotEmpty(Globals.Inventory.CashDrawerAttached)) {
			terPage.get_checkBox_element_Xpath(icp.CashDrawerAttached_String).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.CashDrawerLogDisName)) {
			terPage.terminal_waitClearEnterText_Xpath(icp.CashDrawerLogDisName_String, Globals.Inventory.CashDrawerLogDisName);

		}
	}
		@Then("I fill Pole Weighing Machine")
		public void i_fill_Pole_Weighing_Machine() {
			if (GenericWrappers.isNotEmpty(Globals.Inventory.WeighingMachineAttached)) {
				terPage.get_checkBox_element_Xpath(icp.WeighingMachine_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.SystemPort)) {
				terPage.terminal_waitClearEnterText_Xpath(icp.Port1_String, Globals.Inventory.SystemPort);

			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.SystemAllow)) {
				terPage.get_checkBox_element_Xpath(icp.DeptAllow0_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.SystemAllow)) {
				terPage.get_checkBox_element_Xpath(icp.DeptAllow3_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.SystemAllow)) {
				terPage.get_checkBox_element_Xpath(icp.DeptAllow5_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.SystemAllow)) {
				terPage.get_checkBox_element_Xpath(icp.DeptAllow7_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.SystemAllow)) {
				terPage.get_checkBox_element_Xpath(icp.DeptAllow8_String).click();
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.SystemAllow)) {
				terPage.get_checkBox_element_Xpath(icp.DeptAllow10_String).click();
			}
		}

		@Then("I close connection to TerminalNew")
		public void i_close_connection_to_TerminalNew() {
			mysqlConnect.disconnect();
			System.out.println(" closed succesfully");

		}	

		MssqlConnect mysqlConnect;
		Statement st;
		
	
	@Then("I establish connection to TerminalNew")
	public void i_establish_connection_to_TerminalNew() throws SQLException {
		mysqlConnect = new MssqlConnect();
		st = mysqlConnect.connect().createStatement();
		System.out.println(" Connected succesfully");

	}

	@Then("I read the values from table {string} in TerminalNew")
	public void i_read_the_values_from_table_in_TerminalNew(String tablename) throws SQLException, IOException {

		ResultSet rs = st.executeQuery("select * from " + tablename + " where PTM_POS_SCREEN='Standard'");

		System.out.println(rs);

		while (rs.next()) {

			switch (tablename) {
			case "TBL_POS_TERMINAL_MASTER":
				
				String Location = "";
				try {
					Location = rs.getString("PTM_LOCATION");
					System.out.println(Location);
					Assert.assertEquals(Globals.Inventory.Location.trim(), Location.trim());
					 pass.Excelcreate("terminalnew", "TBL_POS_TERMINAL_MASTER", "", 2, 0, 2, 1);
					pass.ExcelFourData("terminalnew", "Location", Globals.Inventory.Location, Location, "Pass", 3, 0,
							3, 1, 3, 2, 3, 3);
				} catch (AssertionError e) {
					 pass.Excelcreate("terminalnew", "TBL_POS_TERMINAL_MASTER", "", 2, 0, 2, 1);
					pass.ExcelFourData("terminalnew", "Location", Globals.Inventory.Location, Location, "Fail", 3, 0,
							3, 1, 3, 2, 3, 3);

				}
				/*String City = "";
				try {
					City = rs.getString("City");
					System.out.println(City);
					Assert.assertEquals(Globals.Inventory.City.trim(), City.trim());

					pass.ExcelFourData("vendormaster", "City", Globals.Inventory.City, City, "Pass", 4, 0, 4, 1, 4, 2,
							4, 3);
				} catch (AssertionError e) {

					pass.ExcelFourData("vendormaster", "City", Globals.Inventory.City, City, "Fail", 4, 0, 4, 1, 4, 2,
							4, 3);

				}*/

				String Floor = "";
				try {
					Floor = rs.getString("PTM_FLOOR");
					System.out.println(Floor);
					Assert.assertEquals(Globals.Inventory.Floor.trim(), Floor.trim());

					pass.ExcelFourData("terminalnew", "Floor", Globals.Inventory.Floor, Floor, "Pass", 5, 0, 5,
							1, 5, 2, 5, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("terminalnew", "Floor", Globals.Inventory.Floor, Floor, "Fail", 5, 0, 5,
							1, 5, 2, 5, 3);

				}

				String PosScreenType = "";
				try {
					PosScreenType = rs.getString("PTM_POS_SCREEN");
					System.out.println(PosScreenType);
					Assert.assertEquals(Globals.Inventory.PosScreenType.trim(), PosScreenType.trim());

					pass.ExcelFourData("terminalnew", "PosScreenType", Globals.Inventory.PosScreenType, PosScreenType, "Pass", 6, 0,
							6, 1, 6, 2, 6, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("terminalnew", "PosScreenType", Globals.Inventory.PosScreenType, PosScreenType, "Fail", 6, 0,
							6, 1, 6, 2, 6, 3);

				}
				String TillType = "";
				try {
					TillType = rs.getString("PTM_TERMINAL_TYPE");
					System.out.println(TillType);
					Assert.assertEquals(Globals.Inventory.TillType.trim(), TillType.trim());

					pass.ExcelFourData("terminalnew", "TillType", Globals.Inventory.TillType, TillType, "Pass", 7, 0, 7, 1, 7,
							2, 7, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("terminalnew", "TillType", Globals.Inventory.TillType, TillType, "Fail", 7, 0, 7, 1, 7,
							2, 7, 3);

				}
				String TillCode = "";
				try {
					TillCode = rs.getString("PTM_TERMINAL_CODE");
					System.out.println(TillCode);
					Assert.assertEquals(Globals.Inventory.TillCode.trim(), TillCode.trim());

					pass.ExcelFourData("terminalnew", "TillCode", Globals.Inventory.TillCode, TillCode, "Pass", 8, 0,
							8, 1, 8, 2, 8, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("terminalnew", "TillCode", Globals.Inventory.TillCode, TillCode, "Fail", 8, 0,
							8, 1, 8, 2, 8, 3);

				}
				String TillDesc = "";
				try {
					TillDesc = rs.getString("PTM_DESCRIPTION");
					System.out.println(TillDesc);
					Assert.assertEquals(Globals.Inventory.TillDesc.trim(), TillDesc.trim());

					pass.ExcelFourData("terminalnew", "TillDesc", Globals.Inventory.TillDesc, TillDesc, "Pass", 9, 0, 9,
							1, 9, 2, 9, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("terminalnew", "TillDesc", Globals.Inventory.TillDesc, TillDesc, "Fail", 9, 0, 9,
							1, 9, 2, 9, 3);

				}
				String IsPharmacyter = "";
				try {
					IsPharmacyter = rs.getString("PTM_IS_PHARMACY_TILL");
					System.out.println(IsPharmacyter);
					Assert.assertEquals(Globals.Inventory.IsPharmacyter.trim(), IsPharmacyter.trim());

					pass.ExcelFourData("terminalnew", "IsPharmacyter", Globals.Inventory.IsPharmacyter, IsPharmacyter, "pass", 11, 0, 11, 1,
							11, 2, 11, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("terminalnew", "IsPharmacyter", Globals.Inventory.IsPharmacyter, IsPharmacyter, "Fail", 11, 0, 11, 1,
							11, 2, 11, 3);

				}
				String ItemDelAllowed = "";
				try {
					ItemDelAllowed = rs.getString("PTM_ITEM_DELETE");
					System.out.println(ItemDelAllowed);
					Assert.assertEquals(Globals.Inventory.ItemDelAllowed.trim(), ItemDelAllowed.trim());

					pass.ExcelFourData("terminalnew", "ItemDelAllowed", Globals.Inventory.ItemDelAllowed, ItemDelAllowed, "Pass", 12, 0, 12, 1,
							12, 2, 12, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("terminalnew", "ItemDelAllowed", Globals.Inventory.ItemDelAllowed, ItemDelAllowed, "Fail",  12, 0, 12, 1,
							12, 2, 12, 3);

				}
				String SpecialCounter = "";
				try {
					SpecialCounter = rs.getString("PTM_SPECIAL_COUNTER");
					System.out.println(SpecialCounter);
					Assert.assertEquals(Globals.Inventory.SpecialCounter.trim(), SpecialCounter.trim());

					pass.ExcelFourData("terminalnew", "SpecialCounter", Globals.Inventory.SpecialCounter, SpecialCounter,
							"Pass", 13, 0, 13, 1, 13, 2,13, 3);
							

				} catch (AssertionError e) {

					pass.ExcelFourData("terminalnew", "SpecialCounter", Globals.Inventory.SpecialCounter, SpecialCounter,
							"Fail", 13, 0, 13, 1, 13, 2,13, 3);

				}
				String OpticalTerminal = "";
				try {
					OpticalTerminal = rs.getString("PTM_OPTICAL_TERMINAL");
					System.out.println(OpticalTerminal);
					Assert.assertEquals(Globals.Inventory.OpticalTerminal.trim(), OpticalTerminal.trim());

					pass.ExcelFourData("terminalnew", "OpticalTerminal", Globals.Inventory.OpticalTerminal, OpticalTerminal, "Pass", 14, 0, 14, 1, 14, 2, 14, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("terminalnew", "OpticalTerminal", Globals.Inventory.OpticalTerminal, OpticalTerminal, "Fail", 14, 0, 14, 1, 14, 2, 14, 3);

				}
				String AutoLoginPos = "";
				try {
					AutoLoginPos = rs.getString("PTM_IS_AUTO_LOGIN");
					System.out.println(AutoLoginPos);
					Assert.assertEquals(Globals.Inventory.AutoLoginPos.trim(), AutoLoginPos.trim());

					pass.ExcelFourData("terminalnew", "AutoLoginPos", Globals.Inventory.AutoLoginPos,
							AutoLoginPos, "Pass", 15, 0, 15, 1, 15,
							2, 15, 3);


				} catch (AssertionError e) {

					pass.ExcelFourData("terminalnew", "AutoLoginPos", Globals.Inventory.AutoLoginPos,
							AutoLoginPos, "Fail", 15, 0, 15, 1, 15,
							2, 15, 3);

				}
				String NegStock = "";
				try {
					NegStock = rs.getString("PTM_NEGATIVE_STOCK");
					System.out.println(NegStock);
					Assert.assertEquals(Globals.Inventory.NegStock.trim(), NegStock.trim());

					pass.ExcelFourData("terminalnew", "NegStock", Globals.Inventory.NegStock, NegStock,
							"Pass", 16, 0, 16, 1, 16, 2, 16, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("terminalnew", "NegStock", Globals.Inventory.NegStock, NegStock,
							"Fail", 16, 0, 16, 1, 16, 2, 16, 3);

				}
				String PriceChangeAllowed = "";
				try {
					PriceChangeAllowed = rs.getString("PTM_PRICE_CHANGE");
					System.out.println(PriceChangeAllowed);
					Assert.assertEquals(Globals.Inventory.PriceChangeAllowed.trim(), PriceChangeAllowed.trim());

					pass.ExcelFourData("terminalnew", "PriceChangeAllowed", Globals.Inventory.PriceChangeAllowed, PriceChangeAllowed, "Pass", 17, 0, 17, 1, 17, 2, 17, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("terminalnew", "PriceChangeAllowed", Globals.Inventory.PriceChangeAllowed, PriceChangeAllowed, "Fail", 17, 0, 17, 1, 17, 2, 17, 3);


				}
				String AllowDisCoupon = "";
				try {
					AllowDisCoupon = rs.getString("PTM_DISCOUPON_ALLOWED");
					System.out.println(AllowDisCoupon);
					Assert.assertEquals(Globals.Inventory.AllowDisCoupon.trim(), AllowDisCoupon.trim());

					pass.ExcelFourData("terminalnew", "AllowDisCoupon", Globals.Inventory.AllowDisCoupon, AllowDisCoupon, "Pass", 18, 0, 18,
							1, 18, 2, 18, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("terminalnew", "AllowDisCoupon", Globals.Inventory.AllowDisCoupon, AllowDisCoupon, "Fail",18, 0, 18,
							1, 18, 2, 18, 3);
				}
				String PrinterAttached = "";
				try {
					PrinterAttached = rs.getString("PTM_PRINTER_ATTACHED");
					System.out.println(PrinterAttached);
					Assert.assertEquals(Globals.Inventory.PrinterAttached.trim(), PrinterAttached.trim());

					pass.ExcelFourData("terminalnew", "PrinterAttached", Globals.Inventory.PrinterAttached,
							PrinterAttached, "Pass",19,0, 19, 1, 19, 2, 19, 3);
							

				} catch (AssertionError e) {

					pass.ExcelFourData("terminalnew", "PrinterAttached", Globals.Inventory.PrinterAttached,
							PrinterAttached, "Fail", 19,0, 19, 1, 19, 2, 19, 3);
							

				}
				String LocDeviceName = "";
				try {
					LocDeviceName = rs.getString("PTM_PRINTER_OPOS_NAME");
					System.out.println(LocDeviceName);
					Assert.assertEquals(Globals.Inventory.LocDeviceName.trim(), LocDeviceName.trim());

					pass.ExcelFourData("terminalnew", "LocDeviceName", Globals.Inventory.LocDeviceName, LocDeviceName, "Pass", 20, 0,
							20, 1, 20, 2, 20, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("terminalnew", "LocDeviceName", Globals.Inventory.LocDeviceName, LocDeviceName, "Fail", 20, 0,
							20, 1, 20, 2, 20, 3);

				}

				String print = "";
				try {
					print = rs.getString("PTM_PRINT_COUNT");
					System.out.println(print);
					Assert.assertEquals(Globals.Inventory.print.trim(), print.trim());

					pass.ExcelFourData("terminalnew", "print", Globals.Inventory.print, print, "Pass", 21, 0,
							21, 1, 21, 2, 21, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("terminalnew", "print", Globals.Inventory.print, print, "Fail", 21, 0,
							21, 1, 21, 2, 21, 3);

				}
				String PoleDisAttached = "";
				try {
					PoleDisAttached = rs.getString("PTM_POLE_DISPLAY_ATTACHED");
					System.out.println(PoleDisAttached);
					Assert.assertEquals(Globals.Inventory.PoleDisAttached.trim(), PoleDisAttached.trim());

					pass.ExcelFourData("terminalnew", "PoleDisAttached", Globals.Inventory.PoleDisAttached, PoleDisAttached, "Pass", 22, 0, 22, 1,
							22, 2, 22, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("terminalnew", "PoleDisAttached", Globals.Inventory.PoleDisAttached, PoleDisAttached, "Fail", 22, 0, 22, 1,
							22, 2, 22, 3);

				}
				String PoleDisLogName = "";
				try {
					PoleDisLogName = rs.getString("PTM_POLE_DISPLAY_NAME");
					System.out.println(PoleDisLogName);
					Assert.assertEquals(Globals.Inventory.PoleDisLogName.trim(), PoleDisLogName.trim());

					pass.ExcelFourData("terminalnew", "PoleDisLogName", Globals.Inventory.PoleDisLogName, PoleDisLogName, "Pass", 23, 0,
							23, 1, 23, 2, 23, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("terminalnew", "PoleDisLogName", Globals.Inventory.PoleDisLogName, PoleDisLogName, "Fail", 23, 0,
							23, 1, 23, 2, 23, 3);

				}
				String CashDrawerAttached = "";
				try {
					CashDrawerAttached = rs.getString("PTM_CASH_DRAWER_ATTACHED");
					System.out.println(CashDrawerAttached);
					Assert.assertEquals(Globals.Inventory.CashDrawerAttached.trim(), PoleDisLogName.trim());

					pass.ExcelFourData("terminalnew", "CashDrawerAttached", Globals.Inventory.CashDrawerAttached, CashDrawerAttached, "Pass", 24, 0,
							24, 1, 24, 2, 24, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("terminalnew", "CashDrawerAttached", Globals.Inventory.CashDrawerAttached, CashDrawerAttached, "Fail", 24, 0,
							24, 1, 24, 2, 24, 3);

				}
				String CashDrawerLogDisName = "";
				try {
					CashDrawerLogDisName = rs.getString("PTM_CASH_DRAWER_NAME");
					System.out.println(CashDrawerLogDisName);
					Assert.assertEquals(Globals.Inventory.CashDrawerLogDisName.trim(), CashDrawerLogDisName.trim());

					pass.ExcelFourData("terminalnew", "CashDrawerLogDisName", Globals.Inventory.CashDrawerLogDisName, CashDrawerLogDisName, "Pass", 25, 0,
							25, 1, 25, 2, 25, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("terminalnew", "CashDrawerLogDisName", Globals.Inventory.CashDrawerLogDisName, CashDrawerLogDisName, "Fail", 25, 0,
							25, 1, 25, 2, 25, 3);

				}
				String WeighingMachineAttached = "";
				try {
					WeighingMachineAttached = rs.getString("PTM_WEIGHING_MACHINE_ATTACHED");
					System.out.println(WeighingMachineAttached);
					Assert.assertEquals(Globals.Inventory.WeighingMachineAttached.trim(), WeighingMachineAttached.trim());

					pass.ExcelFourData("terminalnew", "WeighingMachineAttached", Globals.Inventory.WeighingMachineAttached, WeighingMachineAttached, "Pass", 26, 0,
							26, 1, 26, 2, 26, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("terminalnew", "WeighingMachineAttached", Globals.Inventory.WeighingMachineAttached, WeighingMachineAttached, "Fail", 26, 0,
							26, 1, 26, 2, 26, 3);

				}
				String BarcodePrinter = "";
				try {
					BarcodePrinter = rs.getString("PTM_BARCODE_PRINTER");
					System.out.println(BarcodePrinter);
					Assert.assertEquals(Globals.Inventory.BarcodePrinter.trim(), BarcodePrinter.trim());

					pass.ExcelFourData("terminalnew", "BarcodePrinter", Globals.Inventory.BarcodePrinter, PoleDisLogName, "Pass", 27, 0,
							27, 1, 27, 2, 27, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("terminalnew", "BarcodePrinter", Globals.Inventory.BarcodePrinter, PoleDisLogName, "Fail", 27, 0,
							27, 1, 27, 2, 27, 3);

				}
				String Port = "";
				try {
					Port = rs.getString("PTM_POLE_DISPLAY_PORT");
					System.out.println(Port);
					Assert.assertEquals(Globals.Inventory.Port.trim(), Port.trim());

					pass.ExcelFourData("terminalnew", "Port", Globals.Inventory.Port, Port, "Pass", 28, 0,
							28, 1, 28, 2, 28, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("terminalnew", "Port", Globals.Inventory.Port, Port, "Fail", 28, 0,
							28, 1, 28, 2, 28, 3);

				}
				String SystemAllow = "";
				try {
					SystemAllow = rs.getString("PTM_DEPARTMENT_TILL");
					System.out.println(SystemAllow);
					Assert.assertEquals(Globals.Inventory.SystemAllow.trim(), SystemAllow.trim());

					pass.ExcelFourData("terminalnew", "SystemAllow", Globals.Inventory.SystemAllow, SystemAllow, "Pass", 29, 0,
							29, 1, 29, 2, 29, 3);

				} catch (AssertionError e) {

					pass.ExcelFourData("terminalnew", "SystemAllow", Globals.Inventory.SystemAllow, SystemAllow, "Fail", 29, 0,
							29, 1, 29, 2, 29, 3);

				}
				
	}

	

		}
	}
}
