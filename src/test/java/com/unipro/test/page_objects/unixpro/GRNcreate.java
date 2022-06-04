package com.unipro.test.page_objects.unixpro;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.gk.test.MssqlConnect;
import com.unipro.ExcelWrite;
import com.unipro.test.framework.Globals;
import com.unipro.test.framework.PageObject;
import com.unipro.test.framework.helpers.screenshot_helper.Screenshot;
import com.unipro.test.framework.helpers.utils.GenericWrappers;
import com.unipro.test.framework.helpers.utils.ReadTestData;
import com.unipro.test.framework.helpers.utils.ReadXLSXFile;
import com.unipro.test.step_definitions.unixpo.Unipro_Common_StepDefinitions;

import bsh.Console;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class GRNcreate extends PageObject {

		AddInventoryFormPage add_inventory;
		CreateGRN icp;
		CommonPages cp;
		ExcelWrite pass;
		Screenshot scr;
		TerminalPage terPage;
		

		public GRNcreate(CreateGRN icp,CommonPages cp) {
			this.icp = icp;
			terPage = new TerminalPage();
			pass = new ExcelWrite();
			scr = new Screenshot();
			this.cp = cp;
			add_inventory = new AddInventoryFormPage();

		}
		

		@Then("I load the GRN sheet data to map")
		public void i_load_the_GA_sheet_data_to_map() {

			//Globals.Inventory.inventorySheetData1 = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME_DATA);

			Globals.Inventory.GRNcreateSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME6);

		}
		@Then("I load the rowise GRN data for {string} rowname")
		public void i_load_the_rowise_GA_data_for_rowname(String row_name) {

			Globals.Inventory.GRNcreaterowwiseData = ReadTestData
					.getRowFilteredValueFromTable(Globals.Inventory.GRNcreateSheetData, row_name);

			System.out.println(Globals.Inventory.GRNcreaterowwiseData);

		}
		@Then("I update value to the GRN page global Variables")
		public void i_update_value_to_the_GA_page_global_Variables() {
			Globals.Inventory.Batch = Globals.Inventory.GRNcreaterowwiseData.get("Batch");
			Globals.Inventory.ItemName = Globals.Inventory.GRNcreaterowwiseData.get("ItemName");
			Globals.Inventory.Vendor = Globals.Inventory.GRNcreaterowwiseData.get("Vendor");
			Globals.Inventory.ItemCode = Globals.Inventory.GRNcreaterowwiseData.get("ItemCode");
			Globals.Inventory.InvQty = Globals.Inventory.GRNcreaterowwiseData.get("InvQty");
			Globals.Inventory.RecvQty = Globals.Inventory.GRNcreaterowwiseData.get("RecvQty");
			Globals.Inventory.MRP = Globals.Inventory.GRNcreaterowwiseData.get("MRP");
			Globals.Inventory.BasicCost = Globals.Inventory.GRNcreaterowwiseData.get("BasicCost");
			Globals.Inventory.DiscP = Globals.Inventory.GRNcreaterowwiseData.get("DiscP");
			Globals.Inventory.DiscA = Globals.Inventory.GRNcreaterowwiseData.get("DiscA");
			Globals.Inventory.SDP = Globals.Inventory.GRNcreaterowwiseData.get("SDP");
			Globals.Inventory.SDA = Globals.Inventory.GRNcreaterowwiseData.get("SDA");
			Globals.Inventory.spfixing = Globals.Inventory.GRNcreaterowwiseData.get("spfixing");
			Globals.Inventory.D1 = Globals.Inventory.GRNcreaterowwiseData.get("D1");
			Globals.Inventory.D2 = Globals.Inventory.GRNcreaterowwiseData.get("D2");
			Globals.Inventory.D3 = Globals.Inventory.GRNcreaterowwiseData.get("D3");
			Globals.Inventory.WPrice1 = Globals.Inventory.GRNcreaterowwiseData.get("WPrice1");
			Globals.Inventory.WPrice2 = Globals.Inventory.GRNcreaterowwiseData.get("WPrice2");
			Globals.Inventory.WPrice3 = Globals.Inventory.GRNcreaterowwiseData.get("WPrice3");
			Globals.Inventory.GrossAmount = Globals.Inventory.GRNcreaterowwiseData.get("GrossAmount");
			Globals.Inventory.GST = Globals.Inventory.GRNcreaterowwiseData.get("GST");
			Globals.Inventory.BillAmt = Globals.Inventory.GRNcreaterowwiseData.get("BillAmt");
			Globals.Inventory.AddDed = Globals.Inventory.GRNcreaterowwiseData.get("AddDed");
			Globals.Inventory.Batch2 = Globals.Inventory.GRNcreaterowwiseData.get("Batch2");
		}

		@Then("I fill new GRN data page using excel data")
		public void i_fill_new_GA_data_page_using_excel_data() throws Exception {
			try {

			       if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch)) {
				        terPage.get_checkBox_element(icp.Batch_String).click();

			        }
					if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemName)) {
						terPage.terminal_waitClearEnterText_css(icp.ItemName_String, Globals.Inventory.ItemName);
						

					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemCode)) {
						terPage.terminal_waitClearEnterText_css(icp.ItemCode_String, Globals.Inventory.ItemCode);
						webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtItemCode")).sendKeys(Keys.RETURN);

					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.InvQty)) {
						webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtInvQty"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtInvQty"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtInvQty"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtInvQty"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtInvQty"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtInvQty"))
						.sendKeys(Keys.DELETE);
						terPage.terminal_waitClearEnterText_css(icp.InvQty_String, Globals.Inventory.InvQty);
						webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtInvQty"))
						.sendKeys(Keys.RETURN);
						//if (Globals.Inventory.InvQty.contains(".")) {
							//icp.setTextValue_Decimal(icp.InvQty_String, Globals.Inventory.InvQty);
						//} else {
							//icp.setTextValue(icp.InvQty_String, Globals.Inventory.InvQty);
						//}
					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.RecvQty)) {
						webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtLQty"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtLQty"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtLQty"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtLQty"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtLQty"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtLQty"))
						.sendKeys(Keys.DELETE);
						terPage.terminal_waitClearEnterText_css(icp.RecvQty_String, Globals.Inventory.RecvQty);
						webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtLQty"))
						.sendKeys(Keys.RETURN);
						//if (Globals.Inventory.RecvQty.contains(".")) {
							//icp.setTextValue_Decimal(icp.RecvQty_String, Globals.Inventory.RecvQty);
						//} else {
							//icp.setTextValue(icp.RecvQty_String, Globals.Inventory.RecvQty);
						//}
					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.MRP)) {
						webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtMRP"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtMRP"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtMRP"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtMRP"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtMRP"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtMRP"))
						.sendKeys(Keys.DELETE);
						terPage.terminal_waitClearEnterText_css(icp.MRP_String, Globals.Inventory.MRP);
						webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtMRP"))
						.sendKeys(Keys.RETURN);
						//if (Globals.Inventory.MRP.contains(".")) {
							//icp.setTextValue_Decimal(icp.MRP_String, Globals.Inventory.MRP);
						//} else {
							//icp.setTextValue(icp.MRP_String, Globals.Inventory.MRP);
						//}
					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.BasicCost)) {
						webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtBCost"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtBCost"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtBCost"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtBCost"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtBCost"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtBCost"))
						.sendKeys(Keys.DELETE);
						terPage.terminal_waitClearEnterText_css(icp.BasicCost_String, Globals.Inventory.BasicCost);
						webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtBCost"))
						.sendKeys(Keys.RETURN);
						//if (Globals.Inventory.BasicCost.contains(".")) {
							//icp.setTextValue_Decimal(icp.BasicCost_String, Globals.Inventory.BasicCost);
						//} else {
							//icp.setTextValue(icp.BasicCost_String, Globals.Inventory.BasicCost);
						//}
					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.DiscP)) {
						webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtDiscPer"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtDiscPer"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtDiscPer"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtDiscPer"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtDiscPer"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtDiscPer"))
						.sendKeys(Keys.DELETE);
				terPage.terminal_waitClearEnterText_css(icp.DiscP_String, Globals.Inventory.DiscP);
						webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtDiscPer"))
						.sendKeys(Keys.RETURN);
						//if (Globals.Inventory.DiscP.contains(".")) {
							//icp.setTextValue_Decimal(icp.DiscP_String, Globals.Inventory.DiscP);
						//} else {
							//icp.setTextValue(icp.DiscP_String, Globals.Inventory.DiscP);
						//}
					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.DiscA)) {
						webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtDiscAmt"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtDiscAmt"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtDiscAmt"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtDiscAmt"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtDiscAmt"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtDiscAmt"))
						.sendKeys(Keys.DELETE);
						terPage.terminal_waitClearEnterText_css(icp.DiscA_String, Globals.Inventory.DiscA);
						webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtDiscAmt"))
						.sendKeys(Keys.RETURN);
						//if (Globals.Inventory.DiscA.contains(".")) {
							//icp.setTextValue_Decimal(icp.DiscA_String, Globals.Inventory.DiscA);
						//} else {
							//icp.setTextValue(icp.DiscA_String, Globals.Inventory.DiscA);
						//}
					}		
					if (GenericWrappers.isNotEmpty(Globals.Inventory.SDP)) {
						webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtSDPer"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtSDPer"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtSDPer"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtSDPer"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtSDPer"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtSDPer"))
						.sendKeys(Keys.DELETE);
						terPage.terminal_waitClearEnterText_css(icp.SDP_String, Globals.Inventory.SDP);
						webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtSDPer"))
						.sendKeys(Keys.RETURN);
						//if (Globals.Inventory.SDP.contains(".")) {
							//icp.setTextValue_Decimal(icp.SDP_String, Globals.Inventory.SDP);
						//} else {
							//icp.setTextValue(icp.SDP_String, Globals.Inventory.SDP);
						//}
					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.SDA)) {
						webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtSchemeAmt"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtSchemeAmt"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtSchemeAmt"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtSchemeAmt"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtSchemeAmt"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtSchemeAmt"))
						.sendKeys(Keys.DELETE);
						terPage.terminal_waitClearEnterText_css(icp.SDA_String, Globals.Inventory.SDA);
						webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtSchemeAmt"))
						.sendKeys(Keys.RETURN);
						//if (Globals.Inventory.SDA.contains(".")) {
							//icp.setTextValue_Decimal(icp.SDA_String, Globals.Inventory.SDA);
						//} else {
							//icp.setTextValue(icp.SDA_String, Globals.Inventory.SDA);
						//}
					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.spfixing)) {
						webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtSPrice"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtSPrice"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtSPrice"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtSPrice"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtSPrice"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtSPrice"))
						.sendKeys(Keys.DELETE);
						terPage.terminal_waitClearEnterText_css(icp.spfixing_String, Globals.Inventory.spfixing);
						webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtSPrice"))
						.sendKeys(Keys.RETURN);
						//if (Globals.Inventory.spfixing.contains(".")) {
							//icp.setTextValue_Decimal(icp.spfixing_String, Globals.Inventory.spfixing);
						//} else {
							//icp.setTextValue(icp.spfixing_String, Globals.Inventory.spfixing);
						//}
						
						    
						     try {

						    	 webDriver.findElement(By.xpath("/html/body/div[9]/div[1]/button/span[1]")).click();
								} catch (Exception e) {
									System.out.println("Element  not found");
								}
						     

							}
						
						
					
					if (GenericWrappers.isNotEmpty(Globals.Inventory.D1)) {
						webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtDisPer1"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtDisPer1"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtDisPer1"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtDisPer1"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtDisPer1"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtDisPer1"))
						.sendKeys(Keys.DELETE);
						terPage.terminal_waitClearEnterText_css(icp.D1_String, Globals.Inventory.D1);
						webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtDisPer1"))
						.sendKeys(Keys.RETURN);
						//if (Globals.Inventory.D1.contains(".")) {
							//icp.setTextValue_Decimal(icp.D1_String, Globals.Inventory.D1);
						//} else {
							//icp.setTextValue(icp.D1_String, Globals.Inventory.D1);
						//}
					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.D2)) {
						webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtDiscPer2"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtDiscPer2"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtDiscPer2"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtDiscPer2"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtDiscPer2"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtDiscPer2"))
						.sendKeys(Keys.DELETE);
						terPage.terminal_waitClearEnterText_css(icp.D2_String, Globals.Inventory.D2);
						webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtDiscPer2"))
						.sendKeys(Keys.RETURN);
						//if (Globals.Inventory.D2.contains(".")) {
							//icp.setTextValue_Decimal(icp.D2_String, Globals.Inventory.D2);
						//} else {
							//icp.setTextValue(icp.D2_String, Globals.Inventory.D2);
						//}
					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.D3)) {
						webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtDiscper3"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtDiscper3"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtDiscper3"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtDiscper3"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtDiscper3"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtDiscper3"))
						.sendKeys(Keys.DELETE);
						terPage.terminal_waitClearEnterText_css(icp.D3_String, Globals.Inventory.D3);
						webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtDiscper3"))
						.sendKeys(Keys.RETURN);
						//if (Globals.Inventory.D3.contains(".")) {
							//icp.setTextValue_Decimal(icp.D3_String, Globals.Inventory.D3);
						//} else {
							//icp.setTextValue(icp.D3_String, Globals.Inventory.D3);
						//}
					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.WPrice1)) {
						webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtWpirce1"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtWpirce1"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtWpirce1"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtWpirce1"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtWpirce1"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtWpirce1"))
						.sendKeys(Keys.DELETE);
						terPage.terminal_waitClearEnterText_css(icp.WPrice1_String, Globals.Inventory.WPrice1);
						webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtWpirce1"))
						.sendKeys(Keys.RETURN);
						//if (Globals.Inventory.WPrice1.contains(".")) {
							//icp.setTextValue_Decimal(icp.WPrice1_String, Globals.Inventory.WPrice1);
						//} else {
							//icp.setTextValue(icp.WPrice1_String, Globals.Inventory.WPrice1);
						//}
					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.WPrice2)) {
						webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtWpirce2"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtWpirce2"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtWpirce2"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtWpirce2"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtWpirce2"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtWpirce2"))
						.sendKeys(Keys.DELETE);
						terPage.terminal_waitClearEnterText_css(icp.WPrice2_String, Globals.Inventory.WPrice2);
						webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtWpirce2"))
						.sendKeys(Keys.RETURN);
						//if (Globals.Inventory.WPrice2.contains(".")) {
							//icp.setTextValue_Decimal(icp.WPrice2_String, Globals.Inventory.WPrice2);
						//} else {
							//icp.setTextValue(icp.WPrice2_String, Globals.Inventory.WPrice2);
						//}
					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.WPrice3)) {
						webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtWpirce3"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtWpirce3"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtWpirce3"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtWpirce3"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtWpirce3"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtWpirce3"))
						.sendKeys(Keys.DELETE);
						terPage.terminal_waitClearEnterText_css(icp.WPrice3_String, Globals.Inventory.WPrice3);
						webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtWpirce3"))
						.sendKeys(Keys.RETURN);
						//if (Globals.Inventory.WPrice3.contains(".")) {
							//icp.setTextValue_Decimal(icp.WPrice3_String, Globals.Inventory.WPrice3);
						//} else {
							//icp.setTextValue(icp.WPrice3_String, Globals.Inventory.WPrice3);
						//}
						 try {

							 webDriver.findElement(By.xpath("/html/body/div[10]/div[1]/button/span[1]")).click();
							} catch (Exception e) {
								System.out.println("Element  not found");
							}
						
						
						
						
					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.GrossAmount)) {
						if (Globals.Inventory.GrossAmount.contains(".")) {
							icp.setTextValue_Decimal(icp.GrossAmount_String, Globals.Inventory.GrossAmount);
						} else {
							icp.setTextValue(icp.GrossAmount_String, Globals.Inventory.GrossAmount);
						}
					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.GST)) {
						if (Globals.Inventory.GST.contains(".")) {
							icp.setTextValue_Decimal(icp.GST_String, Globals.Inventory.GST);
						} else {
							icp.setTextValue(icp.GST_String, Globals.Inventory.GST);
						}
					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.BillAmt)) {
						if (Globals.Inventory.BillAmt.contains(".")) {
							icp.setTextValue_Decimal(icp.BillAmt_String, Globals.Inventory.BillAmt);
						} else {
							icp.setTextValue(icp.BillAmt_String, Globals.Inventory.BillAmt);
						}
					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.AddDed)) {
						 {
							
							 terPage.terminal_waitClearEnterText_css(icp.AddDed_String, Globals.Inventory.AddDed);
						}
					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch2)) {
				        terPage.get_checkBox_element(icp.Batch2_String).click();

			        }
					pass.ExcelFourData("GRN","Modules", "Actual", "Expected", "Status",
							0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
					pass.Excelcreate("GRN", "ItemAdd", "PASS", 1, 0, 1, 3);
				} catch (Exception e) {
					// screen shot
					scr.Screenshots();
					System.out.println("Screen shot taken");
					// Xl sheet write
					pass.ExcelFourData("GRN","Modules", "Actual", "Expected", "Status",
							0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
					pass.Excelcreate("GRN", "ItemAdd", "FAIL", 1, 0, 1, 3);

				}
		}
		@Then("I close connection GRN to DB")
		public void I_close_connection_to_DB() throws SQLException {

			mysqlConnect.disconnect();
			System.out.println(" closed succesfully");

			// mysqlConnect.disconnect();

		}

		MssqlConnect mysqlConnect;
		Statement st;

		@Then("I establish connection GRN to DB")
		public void I_establish_connection_to_DB() throws SQLException {

			mysqlConnect = new MssqlConnect();
			st = mysqlConnect.connect().createStatement();
			System.out.println(" Connected succesfully");

		}

		@Given("I read the values GRN from table {string} in DB")
		public void i_want_to_launch_the(String tablename) throws SQLException, IOException {

			System.out.println(tablename);
			// ResultSet rs =st.executeQuery("select * from "+tablename+" where
			// DeptCode='Gopi'");

			ResultSet rs = st.executeQuery("select * from " + tablename + " where inventorycode="+Globals.Inventory.ItemCode);

			// ResultSet rs = st.executeQuery("");

			while (rs.next()) {

				switch (tablename) {

				case "TblGidheader":
					String DepartmentCode = "";
					try {
						DepartmentCode = rs.getString("DeptCode");
						System.out.println(DepartmentCode);
						Assert.assertEquals(Globals.Inventory.Department.trim(), DepartmentCode.trim());
						pass.Excelcreate("Inventory", "tbldepartment", "", 7, 0, 7, 1);
						pass.ExcelFourData("Inventory", "Department", Globals.Inventory.Department, DepartmentCode,
								"Pass", 8, 0, 8, 1, 8, 2, 8, 3);

					} catch (AssertionError e) {
						pass.Excelcreate("Inventory", "tbldepartment", "", 7, 0, 7, 1);
						pass.ExcelFourData("Inventory", "Department", Globals.Inventory.Department, DepartmentCode,
								"Fail", 8, 0, 8, 1, 8, 2, 8, 3);

					}

					break;

				case "tblinventory":
					String CategoryCode = "";
					try {
						CategoryCode = rs.getString("CategoryCode");
						System.out.println(CategoryCode);
						Assert.assertEquals(Globals.Inventory.Category.trim(), CategoryCode.trim());
						pass.Excelcreate("Inventory", "tblinventory", "", 9, 0, 9, 1);
						pass.ExcelFourData("Inventory", "CategoryCode", Globals.Inventory.Category, CategoryCode, "Pass",
								10, 0, 10, 1, 10, 2, 10, 3);
					} catch (AssertionError e) {
						pass.Excelcreate("Inventory", "tblinventory", "", 9, 0, 9, 1);
						pass.ExcelFourData("Inventory", "CategoryCode", Globals.Inventory.Category, CategoryCode, "Fail",
								10, 0, 10, 1, 10, 2, 10, 3);

					}
					catch(Exception e) {
						System.out.println("null error tblinventory column CategoryCode");
						}
					String Departmentcode = "";
					try {
						Departmentcode = rs.getString("Departmentcode");
						System.out.println(Departmentcode);
						Assert.assertEquals(Globals.Inventory.Department.trim(), Departmentcode.trim());
						pass.ExcelFourData("Inventory", "Departmentcode", Globals.Inventory.Department, Departmentcode, "Pass",
								11, 0, 11, 1, 11, 2, 11, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("Inventory", "Departmentcode", Globals.Inventory.Department, Departmentcode, "Fail",
								11, 0, 11, 1, 11, 2, 11, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblinventory column Departmentcode");
						}
					String Brandcode = "";
					try {
						Brandcode = rs.getString("BrandCode");
						System.out.println(Brandcode);
						Assert.assertEquals(Globals.Inventory.Brand.trim(), Brandcode.trim());
						pass.ExcelFourData("Inventory", "BrandCode", Globals.Inventory.Brand, Brandcode, "Fail",
								12, 0, 12, 1, 12, 2, 12, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("Inventory", "BrandCode", Globals.Inventory.Brand, Brandcode, "Fail",
								12, 0, 12, 1, 12, 2, 12, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblinventory column BrandCode");
						}
					String Barcode = "";
					try {
						Barcode = rs.getString("Barcode");
						System.out.println(Barcode);
						Assert.assertEquals(Globals.Inventory.Barcode.trim(), Barcode.trim());
						pass.ExcelFourData("Inventory", "Barcode", Globals.Inventory.Barcode, Barcode, "Pass",
								13, 0, 13, 1, 13, 2, 13, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("Inventory", "Barcode", Globals.Inventory.Barcode, Barcode, "Fail",
								13, 0, 13, 1, 13, 2, 13, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblinventory column Barcode");
						}
					String Subcategory = "";
					try {
						Subcategory = rs.getString("Subcategorycode");
						System.out.println(Subcategory);
						Assert.assertEquals(Globals.Inventory.SubCategory.trim(), Subcategory.trim());
						pass.ExcelFourData("Inventory", "Subcategory", Globals.Inventory.SubCategory, Subcategory, "Pass",
								14, 0, 14, 1, 14, 2, 14, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("Inventory", "Subcategory", Globals.Inventory.SubCategory, Subcategory, "Fail",
								14, 0, 14, 1, 14, 2, 14, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblinventory column Subcategorycode");
						}
					String Class = "";
					try {

						Class = rs.getString("Class");
						System.out.println(Class);
						Assert.assertEquals(Globals.Inventory.Class.trim(), Class.trim());
						pass.ExcelFourData("Inventory", "Class", Globals.Inventory.Class, Class, "Pass",
								15, 0, 15, 1, 15, 2,15, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("Inventory", "Class", Globals.Inventory.Class, Class, "Fail",
								15, 0, 15, 1, 15, 2,15, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblinventory column Class");
						}
					
					String SubClass = "";
					try {
						SubClass = rs.getString("SubClass");
						System.out.println(SubClass);
						Assert.assertEquals(Globals.Inventory.SubClass.trim(), SubClass.trim());
						pass.ExcelFourData("Inventory", "SubClass", Globals.Inventory.SubClass, SubClass, "Pass",
								16, 0, 16, 1, 16, 2, 16, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("Inventory", "Actual,Expected", Globals.Inventory.SubClass, SubClass, "Fail",
								16, 0, 16, 1, 16, 2, 16, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblinventory column SubClass");
						}
					String Origion="";
					try
					{
				    Origion = rs.getString("Origin");
					System.out.println(Origion);
					Assert.assertEquals(Globals.Inventory.Origin.trim(), Origion.trim());
					pass.ExcelFourData("Inventory", "Origin", Globals.Inventory.Origin, Origion, "Pass",
							17, 0, 17, 1, 17, 2, 17, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("Inventory", "Origin", Globals.Inventory.Origin, Origion, "Fail",
							17, 0, 17, 1, 17, 2, 17, 3);
				}
					catch(Exception e) {
						System.out.println("null error tblinventory column Origin");
						}
					String Warehouse="";
					try
					{
				    Warehouse = rs.getString("Warehouse");
					System.out.println(Warehouse);
					Assert.assertEquals(Globals.Inventory.WareHouse.trim(), Warehouse.trim());
					pass.ExcelFourData("Inventory", "Warehouse", Globals.Inventory.WareHouse, Warehouse, "Pass",
							18, 0, 18, 1, 18, 2, 18, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("Inventory", "Warehouse", Globals.Inventory.WareHouse, Warehouse, "Fail",
							18, 0, 18, 1, 18, 2, 18, 3);
				}
					catch(Exception e) {
						System.out.println("null error tblinventory column Warehouse");
						}
					String UOM="";
					try {
				    UOM = rs.getString("UOM");
					System.out.println(UOM);
					Assert.assertEquals(Globals.Inventory.UOMPurchase.trim(), UOM.trim());
					pass.ExcelFourData("Inventory", "UOM", Globals.Inventory.UOMPurchase, UOM, "Pass",
							19, 0, 19, 1, 19, 2, 19, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("Inventory", "UOM", Globals.Inventory.UOMPurchase, UOM, "Fail",
							19, 0, 19, 1, 19, 2, 19, 3);
				}
					catch(Exception e) {
						System.out.println("null error tblinventory column UOM");
						}
					String Manufacture="";
				try {
						
					Manufacture = rs.getString("Manufacturer");
					System.out.println(Manufacture);
					Assert.assertEquals(Globals.Inventory.Manufacture.trim(), Manufacture.trim());
					pass.ExcelFourData("Inventory", "Manufacturer", Globals.Inventory.Manufacture, Manufacture, "Pass",
							20, 0, 20, 1, 20, 2, 20, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("Inventory", "Manufacturer", Globals.Inventory.Manufacture, Manufacture, "Fail",
							20, 0, 20, 1, 20, 2, 20, 3);
				}
				catch(Exception e) {
					System.out.println("null error tblinventory column Manufacturer");
					}
				String ItemType="";
				try {
					
				    ItemType = rs.getString("ItemType");
					System.out.println(ItemType);
					Assert.assertEquals(Globals.Inventory.ItemType.trim(), ItemType.trim());
					pass.ExcelFourData("Inventory", "ItemType", Globals.Inventory.ItemType, ItemType, "Pass",
							21, 0, 21, 1, 21, 2, 21, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("Inventory", "ItemType", Globals.Inventory.ItemType, ItemType, "Fail",
							21, 0, 21, 1, 21, 2, 21, 3);
				}
				catch(Exception e) {
					System.out.println("null error tblinventory column ItemType");
					}
				String Weight="";
				try {
					Weight = rs.getString("Weight");
					System.out.println(Weight);
					Assert.assertEquals(Globals.Inventory.Weight.trim(), Weight.trim());
					pass.ExcelFourData("Inventory", "Weight", Globals.Inventory.Weight, Weight, "Pass",
							22, 0, 22, 1, 22, 2, 22, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("Inventory", "Weight", Globals.Inventory.Weight, Weight, "Fail",
							22, 0, 22, 1, 22, 2, 22, 3);
				}
				catch(Exception e) {
					System.out.println("null error tblinventory column Weight");
					}
				String Width="";
				try {
				    Width = rs.getString("Width");
				    System.out.println(Width);
				    Assert.assertEquals(Globals.Inventory.Width.trim(), Width.trim());
				    pass.ExcelFourData("Inventory", "Width", Globals.Inventory.Width, Width, "Pass",
							23, 0, 23, 1, 23, 2, 23, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("Inventory", "Width", Globals.Inventory.Width, Width, "Fail",
							23, 0, 23, 1, 23, 2, 23, 3);
				}
				catch(Exception e) {
				System.out.println("null error tblinventory column Width");
				}
				String Height="";
				try {
					Height = rs.getString("Height");
					System.out.println(Height);
					Assert.assertEquals(Globals.Inventory.Height.trim(), Height.trim());
					pass.ExcelFourData("Inventory", "Height", Globals.Inventory.Height, Height, "Pass",
							24, 0, 24, 1, 24, 2, 24, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("Inventory", "Height", Globals.Inventory.Height, Height, "Fail",
							24, 0, 24, 1, 24, 2, 24, 3);
				}
				catch(Exception e) {
					System.out.println("null error tblinventory column Height");
				}
				String Length="";
				try {
				    Length = rs.getString("Length");
					System.out.println(Length);
					Assert.assertEquals(Globals.Inventory.Length.trim(), Length.trim());
					pass.ExcelFourData("Inventory", "Length", Globals.Inventory.Length, Length, "Pass",
							25, 0, 25, 1, 25, 2, 25, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("Inventory", "Length", Globals.Inventory.Length, Length, "Fail",
							25, 0, 25, 1, 25, 2, 25, 3);
				}
				catch(Exception e) {
					System.out.println("null error tblinventory column Length");
				}
				String Vendorcode="";
				try {
					Vendorcode = rs.getString("VendorCode");
					System.out.println(Vendorcode);
					Assert.assertEquals(Globals.Inventory.Vendor.trim(), Vendorcode.trim());
					pass.ExcelFourData("Inventory", "VendorCode", Globals.Inventory.Vendor, Vendorcode, "Pass",
							26, 0, 26, 1, 26, 2, 26, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("Inventory", "VendorCode", Globals.Inventory.Vendor, Vendorcode, "Fail",
							26, 0, 26, 1, 26, 2, 26, 3);
				}
				catch(Exception e) {
					System.out.println("null error tblinventory column VendorCode");
				}
				String Basicost ="";
				try {
					Basicost = rs.getString("UnitCost");
					System.out.println(Basicost);
					Assert.assertEquals(Globals.Inventory.BasicCost.trim(), Basicost.trim());
					pass.ExcelFourData("Inventory", "BasicCost", Globals.Inventory.BasicCost, Basicost, "Pass",
							27, 0, 27, 1, 27, 2, 27, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("Inventory", "BasicCost", Globals.Inventory.BasicCost, Basicost, "Fail",
							27, 0, 27, 1, 27, 2, 27, 3);
				}
				catch(Exception e) {
					System.out.println("null error tblinventory column UnitCost");
				}
				String Sellingprice="";
				try {
					Sellingprice = rs.getString("SellingPrice");
					System.out.println(Sellingprice);
					Assert.assertEquals(Globals.Inventory.NetSellingPrice.trim(), Sellingprice.trim());
					pass.ExcelFourData("Inventory", "SellingPrice", Globals.Inventory.NetSellingPrice, Sellingprice, "Pass",
							28, 0, 28, 1, 28, 2, 28, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("Inventory", "SellingPrice", Globals.Inventory.NetSellingPrice, Sellingprice, "Fail",
							28, 0, 28, 1, 28, 2, 28, 3);
				}
				catch(Exception e) {
					System.out.println("null error tblinventory column SellingPrice");
				}
				String MRP="";
				try
				{
					MRP = rs.getString("MRP");
					System.out.println(MRP);
					Assert.assertEquals(Globals.Inventory.MRP.trim(), MRP.trim());
					pass.ExcelFourData("Inventory", "MRP", Globals.Inventory.MRP, MRP, "Pass",
							29, 0, 29, 1, 29, 2, 29, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("Inventory", "MRP", Globals.Inventory.MRP, MRP, "Fail",
							29, 0, 29, 1, 29, 2, 29, 3);
				}
				catch(Exception e) {
					System.out.println("null error tblinventory column MRP");
				}
				String MinQty="";
				try
				{
					MinQty = rs.getString("MinimumQtyLevel");
					System.out.println(MinQty);
					Assert.assertEquals(Globals.Inventory.MinQty.trim(), MinQty.trim());
					pass.ExcelFourData("Inventory", "MinQty", Globals.Inventory.MinQty, MinQty, "Pass",
							30, 0, 30, 1, 30, 2, 30, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("Inventory", "MinQty", Globals.Inventory.MinQty, MinQty, "Fail",
							30, 0, 30, 1, 30, 2, 30, 3);
				}
				catch(Exception e) {
					System.out.println("null error tblinventory column MinimumQtyLevel");
				}
				String MaxQty="";
				try {
					MaxQty = rs.getString("MaximumQtyLevel");
					System.out.println(MaxQty);
					Assert.assertEquals(Globals.Inventory.MaxQty.trim(), MaxQty.trim());
					pass.ExcelFourData("Inventory", "MaxQty", Globals.Inventory.MaxQty, MaxQty, "Pass",
							31, 0, 31, 1, 31, 2, 31, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("Inventory", "MaxQty", Globals.Inventory.MaxQty, MaxQty, "Fail",
							31, 0, 31, 1, 31, 2, 31, 3);
				}
				catch(Exception e) {
					System.out.println("null error tblinventory column MaximumQtyLevel");
				}
				String ReorderQty="";
				try {
					ReorderQty = rs.getString("ReOrderLevel");
					System.out.println(ReorderQty);
					Assert.assertEquals(Globals.Inventory.ReorderQty.trim(), ReorderQty.trim());
					pass.ExcelFourData("Inventory", "ReorderQty", Globals.Inventory.ReorderQty, ReorderQty, "Pass",
							32, 0, 32, 1, 32, 2, 32, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("Inventory", "ReorderQty", Globals.Inventory.ReorderQty, ReorderQty, "Fail",
							32, 0, 32, 1, 32, 2, 32, 3);
				}
				catch(Exception e) {
					System.out.println("null error tblinventory column ReOrderLevel");
				}
				String Cycledays="";
				try {
					Cycledays = rs.getString("ReOrderDays");
					System.out.println(Cycledays);
					Assert.assertEquals(Globals.Inventory.Cycledays.trim(), Cycledays.trim());
					pass.ExcelFourData("Inventory", "Cycledays", Globals.Inventory.Cycledays, Cycledays, "Pass",
							33, 0, 33, 1, 33, 2, 33, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("Inventory", "Cycledays", Globals.Inventory.Cycledays, Cycledays, "Fail",
							33, 0, 33, 1, 33, 2, 33, 3);
				}
				catch(Exception e) {
					System.out.println("null error tblinventory column ReOrderDays");
				}
				String Orderby="";
				try {
					Orderby = rs.getString("AutoPOReqBy");
					System.out.println(Orderby);
					Assert.assertEquals(Globals.Inventory.Orderby.trim(), Orderby.trim());
					pass.ExcelFourData("Inventory", "Orderby", Globals.Inventory.Orderby, Orderby, "Pass",
							34, 0, 34, 1, 34, 2, 34, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("Inventory", "Orderby", Globals.Inventory.Orderby, Orderby, "Fail",
							34, 0, 34, 1, 34, 2, 34, 3);
				}
				catch(Exception e) {
					System.out.println("null error tblinventory column AutoPOReqBy");
				}
				String CheckBox1="";
				try {
				    CheckBox1 = rs.getString("MinQtycalBy");
					System.out.println(CheckBox1);
					Assert.assertEquals(Globals.Inventory.CheckBox1.trim(), CheckBox1.trim());
					pass.ExcelFourData("Inventory", "MinQtycalBy", Globals.Inventory.CheckBox1, CheckBox1, "Pass",
							35, 0, 35, 1, 35, 2, 35, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("Inventory", "MinQtycalBy", Globals.Inventory.CheckBox1, CheckBox1, "Fail",
							35, 0, 35, 1, 35, 2, 35, 3);
				}
				catch(Exception e) {
					System.out.println("null error tblinventory column MinQtycalBy");
				}
				String CheckBox2="";
				try {
					CheckBox2 = rs.getString("ReOrderBy");
					System.out.println(CheckBox2);
					Assert.assertEquals(Globals.Inventory.CheckBox2.trim(), CheckBox2.trim());
					pass.ExcelFourData("Inventory", "ReOrderBy", Globals.Inventory.CheckBox2, CheckBox2, "Pass",
							36, 0, 36, 1, 36, 2, 36, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("Inventory", "ReOrderBy", Globals.Inventory.CheckBox2, CheckBox2, "Fail",
							36, 0, 36, 1, 36, 2, 36, 3);
				}
				catch(Exception e) {
					System.out.println("null error tblinventory column ReOrderBy");
				}
					break;

				case "tblinventorypricing":
					String BasicSelling ="";
					try {
					BasicSelling = rs.getString("NetSellingPrice");
					System.out.println(BasicSelling);
					Assert.assertEquals(Globals.Inventory.NetSellingPrice.trim(), BasicSelling.trim());
					pass.Excelcreate("Inventory", "tblinventorypricing", "", 38, 0, 38, 1);
					pass.ExcelFourData("Inventory", "NetSellingPrice", Globals.Inventory.NetSellingPrice, BasicSelling, "Pass",
							39, 0, 39, 1, 39, 2, 39, 3);
				} catch (AssertionError e) {
					pass.Excelcreate("Inventory", "tblinventorypricing", "", 38, 0, 38, 1);
					pass.ExcelFourData("Inventory", "NetSellingPrice", Globals.Inventory.NetSellingPrice, BasicSelling, "Fail",
							39, 0, 39, 1, 39, 2, 39, 3);
				}
					catch(Exception e) {
						System.out.println("null error tblinventorypricing column NetSellingPrice");
					}
					String Purchasetype="";
					try {
				    Purchasetype = rs.getString("PurchasedBy");
					System.out.println(Purchasetype);
					Assert.assertEquals(Globals.Inventory.Purchasetype.trim(), Purchasetype.trim());
					pass.ExcelFourData("Inventory", "Purchasetype", Globals.Inventory.Purchasetype, Purchasetype, "Pass",
							40, 0, 40, 1, 40, 2, 40, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("Inventory", "Purchasetype", Globals.Inventory.Purchasetype, Purchasetype, "Fail",
							40, 0, 40, 1, 40, 2, 40, 3);
				}
					catch(Exception e) {
						System.out.println("null error tblinventorypricing column PurchasedBy");
					}
					String MRP1 ="";
					try {
					MRP1 = rs.getString("MRP");
					System.out.println(MRP1);
					Assert.assertEquals(Globals.Inventory.MRP.trim(), MRP1.trim());
					pass.ExcelFourData("Inventory", "MRP", Globals.Inventory.MRP, MRP1, "Pass",
							41, 0, 41, 1, 41, 2, 41, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("Inventory", "MRP", Globals.Inventory.MRP, MRP1, "Fail",
							41, 0, 41, 1, 41, 2, 41, 3);
				}
					catch(Exception e) {
						System.out.println("null error tblinventorypricing column MRP");
					}
					String Basicost1="";
					try {
					Basicost1 = rs.getString("BasicCost");
					System.out.println(Basicost1);
					Assert.assertEquals(Globals.Inventory.BasicCost.trim(), Basicost1.trim());
					pass.ExcelFourData("Inventory", "BasicCost", Globals.Inventory.BasicCost, Basicost1, "Pass",
							42, 0, 42, 1, 42, 2, 42, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("Inventory", "BasicCost", Globals.Inventory.BasicCost, Basicost1, "Fail",
							42, 0, 42, 1, 42, 2, 42, 3);
				}
					catch(Exception e) {
						System.out.println("null error tblinventorypricing column BasicCost");
					}
					String DiscountPer1="";
					try {
					DiscountPer1 = rs.getString("DiscountBasicPer");
					System.out.println(DiscountPer1);
					Assert.assertEquals(Globals.Inventory.DiscountPer1.trim(), DiscountPer1.trim());
					pass.ExcelFourData("Inventory", "DiscountPer1", Globals.Inventory.DiscountPer1, DiscountPer1, "Pass",
							43, 0, 43, 1, 43, 2, 43, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("Inventory", "DiscountPer1", Globals.Inventory.DiscountPer1, DiscountPer1, "Fail",
							43, 0, 43, 1, 43, 2, 43, 3);
				}
					catch(Exception e) {
						System.out.println("null error tblinventorypricing column DiscountBasicPer");
					}
					String DiscountPer2 ="";
					try {
					DiscountPer2 = rs.getString("DiscountBasicPer2");
					System.out.println(DiscountPer2);
					Assert.assertEquals(Globals.Inventory.DiscountPer2.trim(), DiscountPer2.trim());
					pass.ExcelFourData("Inventory", "DiscountPer2", Globals.Inventory.DiscountPer2, DiscountPer2, "Pass",
							44, 0, 44, 1, 44, 2, 44, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("Inventory", "DiscountPer2", Globals.Inventory.DiscountPer2, DiscountPer2, "Fail",
							44, 0, 44, 1, 44, 2, 44, 3);
				}
					catch(Exception e) {
						System.out.println("null error tblinventorypricing column DiscountBasicPer2");
					}
					String DiscountPer3="";
					try {
					DiscountPer3 = rs.getString("DiscountBasicPer3");
					System.out.println(DiscountPer3);
					Assert.assertEquals(Globals.Inventory.DiscountPer3.trim(), DiscountPer3.trim());
					pass.ExcelFourData("Inventory", "DiscountPer3", Globals.Inventory.DiscountPer3, DiscountPer3, "Pass",
							45, 0, 45, 1, 45, 2, 45, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("Inventory", "DiscountPer3", Globals.Inventory.DiscountPer3, DiscountPer3, "Fail",
							45, 0, 45, 1, 45, 2, 45, 3);
				}
					catch(Exception e) {
						System.out.println("null error tblinventorypricing column DiscountBasicPer3");
					}
			
					String W3 ="";
					try {
					W3 = rs.getString("MPWPrice3");
					System.out.println(W3);
					Assert.assertEquals(Globals.Inventory.WPrice3.trim(), W3.trim());
					pass.ExcelFourData("Inventory", "WPrice3", Globals.Inventory.WPrice3, W3, "Pass",
							46, 0, 46, 1, 46, 2, 46, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("Inventory", "WPrice3", Globals.Inventory.WPrice3, W3, "Fail",
							46, 0, 46, 1, 46, 2, 46, 3);
				}
					catch(Exception e) {
						System.out.println("null error tblinventorypricing column MPWPrice3");
					}
				
					String GST1 ="";
					try {
					GST1 = rs.getString("OTaxPer3");
					System.out.println(GST1);
					Assert.assertEquals(Globals.Inventory.GSTPer.trim(), GST1.trim());
					pass.ExcelFourData("Inventory", "OTaxPer3", Globals.Inventory.GSTPer, GST1, "Pass",
							47, 0, 47, 1, 47, 2, 47, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("Inventory", "OTaxPer3", Globals.Inventory.GSTPer, GST1, "Fail",
							47, 0, 47, 1, 47, 2, 47, 3);
				}
					catch(Exception e) {
						System.out.println("null error tblinventorypricing column OTaxPer3");
					}
					String Cess="";
					try {
					Cess = rs.getString("ITaxPer4");
					System.out.println(Cess);
					Assert.assertEquals(Globals.Inventory.Cess.trim(), Cess.trim());
					pass.ExcelFourData("Inventory", "ITaxPer4", Globals.Inventory.Cess, Cess, "Pass",
							48, 0, 48, 1, 48, 2, 48, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("Inventory", "ITaxPer4", Globals.Inventory.Cess, Cess, "Fail",
							48, 0, 48, 1, 48, 2, 48, 3);
				}
					catch(Exception e) {
						System.out.println("null error tblinventorypricing column OTaxPer4");
					}
					String Cess1="";
					try {
					Cess1 = rs.getString("OTaxPer4");
					System.out.println(Cess1);
					Assert.assertEquals(Globals.Inventory.Cess.trim(), Cess1.trim());
					pass.ExcelFourData("Inventory", "OTaxPer4", Globals.Inventory.Cess, Cess1, "Pass",
							49, 0, 49, 1, 49, 2, 49, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("Inventory", "OTaxPer4", Globals.Inventory.Cess, Cess1, "Fail",
							49, 0, 49, 1, 49, 2, 49, 3);
				}
					catch(Exception e) {
						System.out.println("null error tblinventorypricing column OTaxPer4");
					}
					String AdlCsAmt="";
					try {
					AdlCsAmt = rs.getString("ITaxamt5");
					System.out.println(AdlCsAmt);
					Assert.assertEquals(Globals.Inventory.AdlCsAmt.trim(), AdlCsAmt.trim());
					pass.ExcelFourData("Inventory", "ITaxamt5", Globals.Inventory.AdlCsAmt, AdlCsAmt, "Pass",
							50, 0, 50, 1, 50, 2, 50, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("Inventory", "ITaxamt5", Globals.Inventory.AdlCsAmt, AdlCsAmt, "Fail",
							50, 0, 50, 1, 50, 2, 50, 3);
				}
					catch(Exception e) {
						System.out.println("null error tblinventorypricing column ITaxamt5");
					}
					String AdlCsAmt1="";
					try {
					AdlCsAmt1 = rs.getString("ITaxamt5");
					System.out.println(AdlCsAmt1);
					Assert.assertEquals(Globals.Inventory.AdlCsAmt.trim(), AdlCsAmt1.trim());
					pass.ExcelFourData("Inventory", "OTaxamt5", Globals.Inventory.AdlCsAmt, AdlCsAmt, "Pass",
							51, 0, 51, 1, 51, 2, 51, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("Inventory", "OTaxamt5", Globals.Inventory.AdlCsAmt, AdlCsAmt, "Fail",
							51, 0, 51, 1, 51, 2, 51, 3);
				}
					catch(Exception e) {
						System.out.println("null error tblinventorypricing column OTaxamt5");
					}
					String GST="";
					try {
					GST = rs.getString("ITaxPer3");
					System.out.println(GST);
					Assert.assertEquals(Globals.Inventory.GSTPer.trim(), GST.trim());
					pass.ExcelFourData("Inventory", "ITaxPer3", Globals.Inventory.GSTPer, GST, "Pass",
							52, 0, 52, 1, 52, 2, 52, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("Inventory", "ITaxPer3", Globals.Inventory.GSTPer, GST, "Fail",
							52, 0, 52, 1, 52, 2, 52, 3);
				}
					catch(Exception e) {
						System.out.println("null error tblinventorypricing column ITaxPer3");
					}
					String W1="";
					try {
				    W1 = rs.getString("MPWPrice1");
					System.out.println(W1);
					Assert.assertEquals(Globals.Inventory.WPrice1.trim(), W1.trim());
					pass.ExcelFourData("Inventory", "WPrice1", Globals.Inventory.WPrice1, W1, "Pass",
							53, 0, 53, 1, 53, 2, 53, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("Inventory", "Actual,Expected", Globals.Inventory.WPrice1, W1, "Fail",
							53, 0, 53, 1, 53, 2, 53, 3);
				}
					catch(Exception e) {
						System.out.println("null error tblinventorypricing column MPWPrice1");
					}
					String W2="";
					try {
				 W2 = rs.getString("MPWPrice2");
					System.out.println(W2);
					Assert.assertEquals(Globals.Inventory.WPrice2.trim(), W2.trim());
					pass.ExcelFourData("Inventory", "WPrice2", Globals.Inventory.WPrice2, W2, "Pass",
							54, 0, 54, 1, 54, 2, 54, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("Inventory", "WPrice2", Globals.Inventory.WPrice2, W2, "Fail",
							54, 0, 54, 1, 54, 2, 54, 3);
				}
					catch(Exception e) {
						System.out.println("null error tblinventorypricing column MPWPrice2");
					}

					break;

				case "TBLBATCHINVENTORYCONTROL":
					String SellingPrice="";
					try {
					SellingPrice = rs.getString("SellingPrice");
					System.out.println(SellingPrice);
					Assert.assertEquals(Globals.Inventory.NetSellingPrice.trim(), SellingPrice.trim());
					pass.Excelcreate("Inventory", "TBLBATCHINVENTORYCONTROL", "", 56, 0, 56, 1);
					pass.ExcelFourData("Inventory", "NetSellingPrice", Globals.Inventory.NetSellingPrice, SellingPrice, "Pass",
							57, 0, 57, 1, 57, 2, 57, 3);
				} catch (AssertionError e) {
					pass.Excelcreate("Inventory", "TBLBATCHINVENTORYCONTROL", "",56, 0, 56, 1);
					pass.ExcelFourData("Inventory", "NetSellingPrice", Globals.Inventory.NetSellingPrice, SellingPrice, "Fail",
							57, 0, 57, 1, 57, 2, 57, 3);
				}
					catch(Exception e) {
						System.out.println("null error TBLBATCHINVENTORYCONTROL column SellingPrice");
					}
					String MRP2="";
					try {
					MRP2 = rs.getString("MRP");
					System.out.println(MRP2);
					Assert.assertEquals(Globals.Inventory.MRP.trim(), MRP2.trim());
					pass.ExcelFourData("Inventory", "MRP", Globals.Inventory.MRP, MRP2, "Pass",
							58, 0, 58, 1, 58, 2, 58, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("Inventory", "MRP", Globals.Inventory.MRP, MRP2, "Fail",
							58, 0, 58, 1, 58, 2, 58, 3);
				}
					catch(Exception e) {
						System.out.println("null error TBLBATCHINVENTORYCONTROL column MRP");
					}
					String Basicost2="";
					try {
					Basicost2 = rs.getString("Unitcost");
					System.out.println(Basicost2);
					Assert.assertEquals(Globals.Inventory.BasicCost.trim(), Basicost2.trim());
					pass.ExcelFourData("Inventory", "Unitcost", Globals.Inventory.BasicCost, Basicost2, "Pass",
							59, 0, 59, 1, 59, 2, 59, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("Inventory", "Unitcost", Globals.Inventory.BasicCost, Basicost2, "Fail",
							59, 0, 59, 1, 59, 2, 59, 3);
				}
					catch(Exception e) {
						System.out.println("null error TBLBATCHINVENTORYCONTROL column Unitcost");
					}
					String W11="";
					try {
					W11 = rs.getString("WPrice1");
					System.out.println(W11);
					Assert.assertEquals(Globals.Inventory.WAPrice1.trim(), W11.trim());
					pass.ExcelFourData("Inventory", "WPrice1", Globals.Inventory.WAPrice1, W11, "Pass",
							60, 0, 60, 1, 60, 2, 60, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("Inventory", "WPrice1", Globals.Inventory.WAPrice1, W11, "Fail",
							60, 0, 60, 1, 60, 2, 60, 3);
				}
					catch(Exception e) {
						System.out.println("null error TBLBATCHINVENTORYCONTROL column WPrice1");
					}
					String W22="";
					try {
				    W22 = rs.getString("WPrice2");
					System.out.println(W22);
					Assert.assertEquals(Globals.Inventory.WAPrice2.trim(), W22.trim());
					pass.ExcelFourData("Inventory", "WAPrice2", Globals.Inventory.WAPrice2, W22, "Pass",
							61, 0, 61, 1, 61, 2, 61, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("Inventory", "WAPrice2", Globals.Inventory.WAPrice2, W22, "Fail",
							61, 0, 61, 1, 61, 2, 61, 3);
				}
					catch(Exception e) {
						System.out.println("null error TBLBATCHINVENTORYCONTROL column WPrice2");
					}
					String W33="";
					try {
						
					W33 = rs.getString("WPrice3");
					System.out.println(W33);
					Assert.assertEquals(Globals.Inventory.WAPrice3.trim(), W33.trim());
					pass.ExcelFourData("Inventory", "WAPrice3", Globals.Inventory.WAPrice3, W33, "Pass",
							62, 0, 62, 1, 62, 2, 62, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("Inventory", "WAPrice3", Globals.Inventory.WAPrice3, W33, "Fail",
							62, 0, 62, 1, 62, 2, 62, 3);
				}
					catch(Exception e) {
						System.out.println("null error TBLBATCHINVENTORYCONTROL column WPrice3");
					}
					String Batchno="";
					try {
					Batchno = rs.getString("BatchNo");
					System.out.println(Batchno);
					Assert.assertEquals(Globals.Inventory.Batchno.trim(), Batchno.trim());
					pass.ExcelFourData("Inventory", "Batchno", Globals.Inventory.Batchno, Batchno, "Pass",
							63, 0, 63, 1, 63, 2, 63, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("Inventory", "Batchno", Globals.Inventory.Batchno, Batchno, "Fail",
							63, 0, 63, 1, 63, 2, 63, 3);
				}
					catch(Exception e) {
						System.out.println("null error TBLBATCHINVENTORYCONTROL column BatchNo");
					}	
					break;
					
				case "tblInventoryShelfQty":
					String Inventorycode="";
					try {
					Inventorycode = rs.getString("InventoryCode");
					System.out.println(Inventorycode);
					Assert.assertEquals(Globals.Inventory.ItemCode.trim(), Inventorycode.trim());
					pass.Excelcreate("Inventory", "tblInventoryShelfQty", "", 64, 0, 64, 1);
					pass.ExcelFourData("Inventory", "ItemCode", Globals.Inventory.ItemCode, Inventorycode, "Pass",
							65, 0, 65, 1, 65, 2, 65, 3);
				} catch (AssertionError e) {
					pass.Excelcreate("Inventory", "tblInventoryShelfQty", "", 64, 0, 64, 1);
					pass.ExcelFourData("Inventory", "ItemCode", Globals.Inventory.ItemCode, Inventorycode, "Fail",
							65, 0, 65, 1, 65, 2, 65, 3);
				}
					catch(Exception e) {
						System.out.println("null error tblinventorystock column InventoryCode");
					}	
					break;

				case "tblinventorystock":
					// String SellingPrice1 = rs.getString("Price");
					// System.out.println(SellingPrice1);
					// Assert.assertEquals(Globals.Inventory.NetSellingPrice.trim(),
					// SellingPrice1.trim());
					String Inventorycode1="";
					try {
						
					Inventorycode1 = rs.getString("InventoryCode");
					System.out.println(Inventorycode1);
					Assert.assertEquals(Globals.Inventory.ItemCode.trim(), Inventorycode1.trim());
					pass.Excelcreate("Inventory", "tblinventorystock", "", 67, 0, 67, 1);
					pass.ExcelFourData("Inventory", "ItemCode", Globals.Inventory.ItemCode, Inventorycode1, "Pass",
							68, 0, 68, 1, 68, 2, 68, 3);
				} catch (AssertionError e) {
					pass.Excelcreate("Inventory", "tblinventorystock", "", 67, 0, 67, 1);
					pass.ExcelFourData("Inventory", "ItemCode", Globals.Inventory.ItemCode, Inventorycode1, "Fail",
							68, 0, 68, 1, 68, 2, 68, 3);
				}
					catch(Exception e) {
						System.out.println("null error tblinventorystock column InventoryCode");
					}
					break;
				case "tblbarcode":
					String Brandcode1="";
					try {
					Brandcode1 = rs.getString("BarCode");
					System.out.println(Brandcode1);
					Assert.assertEquals(Globals.Inventory.Barcode.trim(), Brandcode1.trim());
					pass.Excelcreate("Inventory", "tblbarcode", "", 70, 0, 70, 1);
					pass.ExcelFourData("Inventory", "BarCode", Globals.Inventory.Barcode, Brandcode1, "Pass",
							71, 0, 71, 1, 71, 2, 71, 3);
				} catch (AssertionError e) {
					pass.Excelcreate("Inventory", "tblbarcode", "",  70, 0, 70, 1);
					pass.ExcelFourData("Inventory", "BarCode", Globals.Inventory.Barcode, Brandcode1, "Fail",
							71, 0, 71, 1, 71, 2, 71, 3);
				}
					catch(Exception e) {
						System.out.println("null error tblbarcode column BarCode");
					}
					String Inventorycode11="";
					try {
					Inventorycode11 = rs.getString("InventoryCode");
					System.out.println(Inventorycode11);
					Assert.assertEquals(Globals.Inventory.ItemCode.trim(), Inventorycode11.trim());
					pass.ExcelFourData("Inventory", "InventoryCode", Globals.Inventory.ItemCode, Inventorycode11, "Pass",
							72, 0, 72, 1, 72, 2, 72, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("Inventory", "InventoryCode", Globals.Inventory.ItemCode, Inventorycode11, "Fail",
							72, 0, 72, 1, 72, 2, 72, 3);
				}
					catch(Exception e) {
						System.out.println("null error tblbarcode column InventoryCode");
					}
					
					break;
					

				default:
					break;
				}

			}

		}

		
				
			   
		   }
	
		
		




