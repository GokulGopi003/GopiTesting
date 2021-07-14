package com.unipro.test.page_objects.unixpro;
import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.server.handler.SendKeys;

import com.unipro.test.framework.Globals;
import com.unipro.test.framework.PageObject;
import com.unipro.test.framework.helpers.utils.GenericWrappers;
import com.unipro.test.framework.helpers.utils.ReadTestData;
import com.unipro.test.framework.helpers.utils.ReadXLSXFile;
import com.unipro.test.step_definitions.unixpo.Unipro_Common_StepDefinitions;

import cucumber.api.java.en.Then;

public class GRNcreate extends PageObject {

		AddInventoryFormPage add_inventory;
		CreateGRN icp;
		CommonPages cp;
		
		

		TerminalPage terPage;
		

		public GRNcreate(CreateGRN icp,CommonPages cp) {
			this.icp = icp;
			terPage = new TerminalPage();
			
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
		public void i_fill_new_GA_data_page_using_excel_data() {
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
						if (Globals.Inventory.InvQty.contains(".")) {
							icp.setTextValue_Decimal(icp.InvQty_String, Globals.Inventory.InvQty);
						} else {
							icp.setTextValue(icp.InvQty_String, Globals.Inventory.InvQty);
						}
					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.RecvQty)) {
						if (Globals.Inventory.RecvQty.contains(".")) {
							icp.setTextValue_Decimal(icp.RecvQty_String, Globals.Inventory.RecvQty);
						} else {
							icp.setTextValue(icp.RecvQty_String, Globals.Inventory.RecvQty);
						}
					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.MRP)) {
						if (Globals.Inventory.MRP.contains(".")) {
							icp.setTextValue_Decimal(icp.MRP_String, Globals.Inventory.MRP);
						} else {
							icp.setTextValue(icp.MRP_String, Globals.Inventory.MRP);
						}
					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.BasicCost)) {
						if (Globals.Inventory.BasicCost.contains(".")) {
							icp.setTextValue_Decimal(icp.BasicCost_String, Globals.Inventory.BasicCost);
						} else {
							icp.setTextValue(icp.BasicCost_String, Globals.Inventory.BasicCost);
						}
					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.DiscP)) {
						if (Globals.Inventory.DiscP.contains(".")) {
							icp.setTextValue_Decimal(icp.DiscP_String, Globals.Inventory.DiscP);
						} else {
							icp.setTextValue(icp.DiscP_String, Globals.Inventory.DiscP);
						}
					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.DiscA)) {
						if (Globals.Inventory.DiscA.contains(".")) {
							icp.setTextValue_Decimal(icp.DiscA_String, Globals.Inventory.DiscA);
						} else {
							icp.setTextValue(icp.DiscA_String, Globals.Inventory.DiscA);
						}
					}		
					if (GenericWrappers.isNotEmpty(Globals.Inventory.SDP)) {
						if (Globals.Inventory.SDP.contains(".")) {
							icp.setTextValue_Decimal(icp.SDP_String, Globals.Inventory.SDP);
						} else {
							icp.setTextValue(icp.SDP_String, Globals.Inventory.SDP);
						}
					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.SDA)) {
						if (Globals.Inventory.SDA.contains(".")) {
							icp.setTextValue_Decimal(icp.SDA_String, Globals.Inventory.SDA);
						} else {
							icp.setTextValue(icp.SDA_String, Globals.Inventory.SDA);
						}
					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.spfixing)) {
						if (Globals.Inventory.spfixing.contains(".")) {
							icp.setTextValue_Decimal(icp.spfixing_String, Globals.Inventory.spfixing);
						} else {
							icp.setTextValue(icp.spfixing_String, Globals.Inventory.spfixing);
						}
						//webDriver.findElement(By.xpath("/html/body/div[9]/div[1]/button/span[1]")).click();
						
					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.D1)) {
						if (Globals.Inventory.D1.contains(".")) {
							icp.setTextValue_Decimal(icp.D1_String, Globals.Inventory.D1);
						} else {
							icp.setTextValue(icp.D1_String, Globals.Inventory.D1);
						}
					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.D2)) {
						if (Globals.Inventory.D2.contains(".")) {
							icp.setTextValue_Decimal(icp.D2_String, Globals.Inventory.D2);
						} else {
							icp.setTextValue(icp.D2_String, Globals.Inventory.D2);
						}
					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.D3)) {
						if (Globals.Inventory.D3.contains(".")) {
							icp.setTextValue_Decimal(icp.D3_String, Globals.Inventory.D3);
						} else {
							icp.setTextValue(icp.D3_String, Globals.Inventory.D3);
						}
					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.WPrice1)) {
						if (Globals.Inventory.WPrice1.contains(".")) {
							icp.setTextValue_Decimal(icp.WPrice1_String, Globals.Inventory.WPrice1);
						} else {
							icp.setTextValue(icp.WPrice1_String, Globals.Inventory.WPrice1);
						}
					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.WPrice2)) {
						if (Globals.Inventory.WPrice2.contains(".")) {
							icp.setTextValue_Decimal(icp.WPrice2_String, Globals.Inventory.WPrice2);
						} else {
							icp.setTextValue(icp.WPrice2_String, Globals.Inventory.WPrice2);
						}
					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.WPrice3)) {
						if (Globals.Inventory.WPrice3.contains(".")) {
							icp.setTextValue_Decimal(icp.WPrice3_String, Globals.Inventory.WPrice3);
						} else {
							icp.setTextValue(icp.WPrice3_String, Globals.Inventory.WPrice3);
						}
						//webDriver.findElement(By.xpath("/html/body/div[10]/div[1]/button/span[1]")).click();
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
		}
		
		  
				
			   
		   }
	
		
		




