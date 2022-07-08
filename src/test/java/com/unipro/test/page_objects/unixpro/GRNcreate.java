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
import org.openqa.selenium.interactions.Actions;
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
		 
		boolean AddButton;

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
			Globals.Inventory.VendorName = Globals.Inventory.GRNcreaterowwiseData.get("VendorName");
			Globals.Inventory.GrnNo = Globals.Inventory.GRNcreaterowwiseData.get("GrnNo");
			Globals.Inventory.InvNo = Globals.Inventory.GRNcreaterowwiseData.get("InvNo");
			Globals.Inventory.GrnDate = Globals.Inventory.GRNcreaterowwiseData.get("GrnDate");
			Globals.Inventory.InvDate = Globals.Inventory.GRNcreaterowwiseData.get("InvDate");
			Globals.Inventory.GaNumber = Globals.Inventory.GRNcreaterowwiseData.get("GaNumber");
			Globals.Inventory.GaDate = Globals.Inventory.GRNcreaterowwiseData.get("GaDate");
			Globals.Inventory.Remarks = Globals.Inventory.GRNcreaterowwiseData.get("Remarks");
			Globals.Inventory.TotalPayable = Globals.Inventory.GRNcreaterowwiseData.get("TotalPayable");
			Globals.Inventory.ItemDesc = Globals.Inventory.GRNcreaterowwiseData.get("ItemDesc");
			Globals.Inventory.WQty = Globals.Inventory.GRNcreaterowwiseData.get("WQty");
			Globals.Inventory.GrossCost = Globals.Inventory.GRNcreaterowwiseData.get("GrossCost");
			Globals.Inventory.Gst = Globals.Inventory.GRNcreaterowwiseData.get("Gst");
			Globals.Inventory.Cess = Globals.Inventory.GRNcreaterowwiseData.get("Cess");
			Globals.Inventory.AddCess = Globals.Inventory.GRNcreaterowwiseData.get("AddCess");
			Globals.Inventory.Netcost = Globals.Inventory.GRNcreaterowwiseData.get("Netcost");
			Globals.Inventory.SpFixing = Globals.Inventory.GRNcreaterowwiseData.get("SpFixing");
			Globals.Inventory.MEarned = Globals.Inventory.GRNcreaterowwiseData.get("MEarned");
			Globals.Inventory.Wuom = Globals.Inventory.GRNcreaterowwiseData.get("Wuom");
			Globals.Inventory.Luom = Globals.Inventory.GRNcreaterowwiseData.get("Luom");
			Globals.Inventory.Qty = Globals.Inventory.GRNcreaterowwiseData.get("TotQty");
			Globals.Inventory.GrBasic = Globals.Inventory.GRNcreaterowwiseData.get("GrBasic");
			Globals.Inventory.GrCost = Globals.Inventory.GRNcreaterowwiseData.get("GrCost");
			Globals.Inventory.GrDisc = Globals.Inventory.GRNcreaterowwiseData.get("GrDisc");
			Globals.Inventory.GrSchm = Globals.Inventory.GRNcreaterowwiseData.get("GrSchm");
			Globals.Inventory.GrGst = Globals.Inventory.GRNcreaterowwiseData.get("GrGst");
			Globals.Inventory.LastInQty = Globals.Inventory.GRNcreaterowwiseData.get("LastInQty");
			
			
			
			Globals.Inventory.GrcAmt = Globals.Inventory.GRNcreaterowwiseData.get("GrcAmt");
			Globals.Inventory.GrAddCess = Globals.Inventory.GRNcreaterowwiseData.get("GrAddCess");
			Globals.Inventory.Total = Globals.Inventory.GRNcreaterowwiseData.get("Total");
			Globals.Inventory.GrAmt = Globals.Inventory.GRNcreaterowwiseData.get("GrAmt");
			Globals.Inventory.GstA = Globals.Inventory.GRNcreaterowwiseData.get("GstA");
			Globals.Inventory.TotalCessAmt = Globals.Inventory.GRNcreaterowwiseData.get("TotalCessAmt");
			Globals.Inventory.GstCessAmt = Globals.Inventory.GRNcreaterowwiseData.get("GstCessAmt");
			Globals.Inventory.BillAmt = Globals.Inventory.GRNcreaterowwiseData.get("BillAmt");
			Globals.Inventory.Deduction = Globals.Inventory.GRNcreaterowwiseData.get("Deduction");
			Globals.Inventory.Addition = Globals.Inventory.GRNcreaterowwiseData.get("Addition");
			Globals.Inventory.TotalPayable = Globals.Inventory.GRNcreaterowwiseData.get("TotalPay");
			Globals.Inventory.TRow = Globals.Inventory.GRNcreaterowwiseData.get("TRow");
			Globals.Inventory.TQty = Globals.Inventory.GRNcreaterowwiseData.get("TQty");
			Globals.Inventory.TBasicCost = Globals.Inventory.GRNcreaterowwiseData.get("TBasicCost");
			Globals.Inventory.TotDisc = Globals.Inventory.GRNcreaterowwiseData.get("TotDisc");
			Globals.Inventory.TotSchmDisc = Globals.Inventory.GRNcreaterowwiseData.get("TotSchmDisc");
			Globals.Inventory.TotGrCost = Globals.Inventory.GRNcreaterowwiseData.get("TotGrCost");
			
			
			Globals.Inventory.ItemCode = Globals.Inventory.GRNcreaterowwiseData.get("ItemCode");
			Globals.Inventory.InvQty = Globals.Inventory.GRNcreaterowwiseData.get("InvQty");
			Globals.Inventory.RecvQty = Globals.Inventory.GRNcreaterowwiseData.get("RecvQty");
			Globals.Inventory.MBatch = Globals.Inventory.GRNcreaterowwiseData.get("MBatch");
			Globals.Inventory.ExpiredDate = Globals.Inventory.GRNcreaterowwiseData.get("ExpiredDate");
			Globals.Inventory.FreeItem = Globals.Inventory.GRNcreaterowwiseData.get("FreeItem");
			Globals.Inventory.MRP = Globals.Inventory.GRNcreaterowwiseData.get("MRP");
			
			Globals.Inventory.SalesNotAffectNetcost = Globals.Inventory.GRNcreaterowwiseData.get("SalesNotAffectNetcost");
			Globals.Inventory.FreeToCustomer = Globals.Inventory.GRNcreaterowwiseData.get("FreeToCustomer");
			Globals.Inventory.FocItem = Globals.Inventory.GRNcreaterowwiseData.get("FocItem");
			Globals.Inventory.BatchNo = Globals.Inventory.GRNcreaterowwiseData.get("BatchNo");
			Globals.Inventory.TotalQty = Globals.Inventory.GRNcreaterowwiseData.get("TotalQty");
			Globals.Inventory.FromDate = Globals.Inventory.GRNcreaterowwiseData.get("FromDate");
			Globals.Inventory.ToDate = Globals.Inventory.GRNcreaterowwiseData.get("ToDate");
			Globals.Inventory.BuyQty = Globals.Inventory.GRNcreaterowwiseData.get("BuyQty");
			Globals.Inventory.FreeQty = Globals.Inventory.GRNcreaterowwiseData.get("FreeQty");
			
			Globals.Inventory.AddButton = Globals.Inventory.GRNcreaterowwiseData.get("AddButton");
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
			Globals.Inventory.VendorWisePriceChangeItem = Globals.Inventory.GRNcreaterowwiseData.get("VendorWisePriceChangeItem");
			

		}



		@Then("I fill new GRN data page using excel data")
		public void i_fill_new_GA_data_page_using_excel_data() throws Exception {
			try {
				
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Vendor)) {
				
					WebElement firstName = webDriver.findElement(By.id("ContentPlaceHolder1_txtVendorCode"));
					String value = firstName.getAttribute("value");
					System.out.println(value);
					
				
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.VendorName)) {
					
					WebElement firstName = webDriver.findElement(By.id("ContentPlaceHolder1_txtVendorName"));
					String value = firstName.getAttribute("value");
					System.out.println(value);
					
				
				}
               if (GenericWrappers.isNotEmpty(Globals.Inventory.GrnNo)) {
					
					WebElement firstName = webDriver.findElement(By.id("ContentPlaceHolder1_txtGrnNo"));
					String value = firstName.getAttribute("value");
					System.out.println(value);
					
				
				}
               if (GenericWrappers.isNotEmpty(Globals.Inventory.InvNo)) {
					
					WebElement firstName = webDriver.findElement(By.id("ContentPlaceHolder1_txtInvNo"));
					String value = firstName.getAttribute("value");
					System.out.println(value);
					
				
				}
               if (GenericWrappers.isNotEmpty(Globals.Inventory.GrnDate)) {
					
					WebElement firstName = webDriver.findElement(By.id("ContentPlaceHolder1_txtgrndate"));
					String value = firstName.getAttribute("value");
					System.out.println(value);
					
				
				}
              if (GenericWrappers.isNotEmpty(Globals.Inventory.InvDate)) {
					
					WebElement firstName = webDriver.findElement(By.id("ContentPlaceHolder1_txtgrndate"));
					String value = firstName.getAttribute("value");
					System.out.println(value);
					
				
				}
               if (GenericWrappers.isNotEmpty(Globals.Inventory.GaNumber)) {
					
					WebElement firstName = webDriver.findElement(By.id("ContentPlaceHolder1_txtgaNo"));
					String value = firstName.getAttribute("value");
					System.out.println(value);
					
				
				}
               if (GenericWrappers.isNotEmpty(Globals.Inventory.GaDate)) {
					
					WebElement firstName = webDriver.findElement(By.id("ContentPlaceHolder1_txtgaDate"));
					String value = firstName.getAttribute("value");
					System.out.println(value);
					
				
				}
               if (GenericWrappers.isNotEmpty(Globals.Inventory.Remarks)) {
					
					WebElement firstName = webDriver.findElement(By.id("ContentPlaceHolder1_txtRemark"));
					String value = firstName.getAttribute("value");
					System.out.println(value);
					
				
				}
               if (GenericWrappers.isNotEmpty(Globals.Inventory.TotalPayable)) {
					
					WebElement firstName = webDriver.findElement(By.id("ContentPlaceHolder1_txttotPayable"));
					String value = firstName.getAttribute("value");
					System.out.println(value);
					
				
				}
               
			
		

                    if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch)) {
				        terPage.get_checkBox_element(icp.Batch_String).click();

			        }
					if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemName)) {
						
						terPage.terminal_waitClearEnterText_css(icp.ItemName_String, Globals.Inventory.ItemName);
						

					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemCode)) {
						terPage.terminal_waitClearEnterText_css(icp.ItemCode_String, Globals.Inventory.ItemCode);
						webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtItemCode")).sendKeys(Keys.RETURN);
						GenericWrappers.sleepInSeconds(1);
					}
					
		            if(GenericWrappers.isNotEmpty(Globals.Inventory.VendorWisePriceChangeItem))
					{
					if(Globals.Inventory.VendorWisePriceChangeItem == Globals.Inventory.AddButton)
						{
						webDriver.findElement(By.id("btnAdd")).click();
						}
							
							
					else if(Globals.Inventory.VendorWisePriceChangeItem != Globals.Inventory.AddButton) 
					{
					webDriver.findElement(By.xpath("//*[@id=\"btnClose\"]")).click();
								

					}
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
						GenericWrappers.sleepInSeconds(1);
											}

					if (GenericWrappers.isNotEmpty(Globals.Inventory.FreeItem)) {
						
						webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtLQty")).sendKeys(Keys.ALT, "f");

						
					}
                     if (GenericWrappers.isNotEmpty(Globals.Inventory.SalesNotAffectNetcost)) {
         				terPage.get_radioButton_element(icp.SalesNotAffectNetcos_string).click();
         			}
         			if (GenericWrappers.isNotEmpty(Globals.Inventory.FreeToCustomer)) {
         				terPage.get_radioButton_element(icp.FreetoCustomer_String).click();
         			}
         			if (GenericWrappers.isNotEmpty(Globals.Inventory.FocItem)) {
						terPage.terminal_waitClearEnterText_css(icp.FocItem_String, Globals.Inventory.FocItem);
						webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtFocItem")).sendKeys(Keys.RETURN);

					}
         			/*if (GenericWrappers.isNotEmpty(Globals.Inventory.BatchNo)) {
         				GenericWrappers.sleepInSeconds(1);
         				webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_ddlfocBatch_chzn\"]")).click();
         				GenericWrappers.sleepInSeconds(1);

         				WebElement LocationValue = webDriver
         						.findElement(By.cssSelector("#ContentPlaceHolder1_ddlfocBatch_chzn > div > div > input[type=text]"));
         				String css_location_dropDownValue = "#ContentPlaceHolder1_ddlfocBatch_chzn > div > div > input[type=text]";
         				By ddlocator = By.cssSelector(css_location_dropDownValue);
         				waitForExpectedElement(ddlocator);
         				js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.BatchNo);
         				GenericWrappers.sleepInSeconds(1);
         				LocationValue.sendKeys(Keys.SPACE);
         				LocationValue.sendKeys(Keys.SPACE);
         				LocationValue.sendKeys(Keys.ARROW_DOWN);
         				GenericWrappers.sleepInSeconds(1);
         				LocationValue.sendKeys(Keys.ENTER);

         			}*/

         			if (GenericWrappers.isNotEmpty(Globals.Inventory.TotalQty)) {
         				/*webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtFocTotalQty"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtFocTotalQty"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtFocTotalQty"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtFocTotalQty"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtFocTotalQty"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
         				GenericWrappers.sleepInSeconds(1);
         				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtFocTotalQty")).sendKeys(Keys.CONTROL, "a");
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtFocTotalQty"))
						.sendKeys(Keys.DELETE);
						GenericWrappers.sleepInSeconds(1);*/
						terPage.terminal_waitClearEnterText_css(icp.TotalQty_String, Globals.Inventory.TotalQty);
						webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtFocTotalQty")).sendKeys(Keys.RETURN);

					}

				
         			if (GenericWrappers.isNotEmpty(Globals.Inventory.FromDate)) {
        				terPage.terminal_waitClearEnterText_css(icp.FromDate_String, Globals.Inventory.FromDate);
        				//Inventorychange.clearAndTypeSlowly(Globals.Inventory.FromDate, "input#txtSearch");
        				//Inventorychange.return_td_invoke_element(Globals.Inventory.FromDate).click();
        				webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtfocFromDate\"]")).sendKeys(Keys.TAB);
        			}
        			if (GenericWrappers.isNotEmpty(Globals.Inventory.ToDate)) {
        				terPage.terminal_waitClearEnterText_css(icp.ToDate_String, Globals.Inventory.ToDate);
        				//Inventorychange.clearAndTypeSlowly(Globals.Inventory.ToDate, "input#txtSearch");
        				//Inventorychange.return_td_invoke_element(Globals.Inventory.ToDate).click();
        				webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_txtFocToDate\"]")).sendKeys(Keys.TAB);
        			}
        			if (GenericWrappers.isNotEmpty(Globals.Inventory.BuyQty)) {
        				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtFocBuyQty"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtFocBuyQty"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtFocBuyQty"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtFocBuyQty"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtFocBuyQty"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtFocBuyQty"))
						.sendKeys(Keys.DELETE);
						terPage.terminal_waitClearEnterText_css(icp.BuyQty_String, Globals.Inventory.BuyQty);
						webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtFocBuyQty")).sendKeys(Keys.RETURN);

					}
        			if (GenericWrappers.isNotEmpty(Globals.Inventory.FreeQty)) {
        				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtFocFreeQty"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtFocFreeQty"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtFocFreeQty"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtFocFreeQty"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtFocFreeQty"))
						.sendKeys(Keys.SHIFT, Keys.LEFT);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtFocFreeQty"))
						.sendKeys(Keys.DELETE);
						terPage.terminal_waitClearEnterText_css(icp.FreeQty_String, Globals.Inventory.FreeQty);
						webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtFocFreeQty")).sendKeys(Keys.ENTER);

					}
        								//MedicalBatch
					if (GenericWrappers.isNotEmpty(Globals.Inventory.MBatch)) {
						terPage.terminal_waitClearEnterText_css(icp.Medical_Batch_String, Globals.Inventory.MBatch);
						webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtMBatchNo")).sendKeys(Keys.RETURN);

					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.ExpiredDate)) {
						terPage.terminal_waitClearEnterText_css(icp.ExpiredDate_String, Globals.Inventory.ExpiredDate);
						//Inventorychange.clearAndTypeSlowly(Globals.Inventory.FromDate, "input#txtSearch");
						//Inventorychange.return_td_invoke_element(Globals.Inventory.FromDate).click();
						webDriver.findElement(By.xpath("input#ContentPlaceHolder1_txtExpireDate")).sendKeys(Keys.TAB);
					}
					//Free Item
					
					
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
					
					if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemDesc)) {
						
						WebElement firstName = webDriver.findElement(By.id("ContentPlaceHolder1_txtDescription"));
						String value = firstName.getAttribute("value");
						System.out.println(value);
						
					
					}
                    if (GenericWrappers.isNotEmpty(Globals.Inventory.WQty)) {
						
						WebElement firstName = webDriver.findElement(By.id("ContentPlaceHolder1_txtWQty"));
						String value = firstName.getAttribute("value");
						System.out.println(value);
						
					
					}
	               if (GenericWrappers.isNotEmpty(Globals.Inventory.GrossCost)) {
						
						WebElement firstName = webDriver.findElement(By.id("ContentPlaceHolder1_txtGrossCost"));
						String value = firstName.getAttribute("value");
						System.out.println(value);
						
					
					}
	               if (GenericWrappers.isNotEmpty(Globals.Inventory.Gst)) {
						
						WebElement firstName = webDriver.findElement(By.id("ContentPlaceHolder1_txtGST"));
						String value = firstName.getAttribute("value");
						System.out.println(value);
						
					
					}
	               if (GenericWrappers.isNotEmpty(Globals.Inventory.Cess)) {
						
						WebElement firstName = webDriver.findElement(By.id("ContentPlaceHolder1_txtcess"));
						String value = firstName.getAttribute("value");
						System.out.println(value);
						
					
					}
	               
	               if (GenericWrappers.isNotEmpty(Globals.Inventory.AddCess)) {
	   				
						WebElement firstName = webDriver.findElement(By.id("ContentPlaceHolder1_txtAddCess"));
						String value = firstName.getAttribute("value");
						System.out.println(value);
						
					
					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.Netcost)) {
						
						WebElement firstName = webDriver.findElement(By.id("ContentPlaceHolder1_txtNetCost"));
						String value = firstName.getAttribute("value");
						System.out.println(value);
						
					
					}
	              if (GenericWrappers.isNotEmpty(Globals.Inventory.SpFixing)) {
						
						WebElement firstName = webDriver.findElement(By.id("ContentPlaceHolder1_txtMFixed"));
						String value = firstName.getAttribute("value");
						System.out.println(value);
						
					
					}
	              if (GenericWrappers.isNotEmpty(Globals.Inventory.MEarned)) {
						
						WebElement firstName = webDriver.findElement(By.id("ContentPlaceHolder1_txtEarned"));
						String value = firstName.getAttribute("value");
						System.out.println(value);
						
					
					}
	              if (GenericWrappers.isNotEmpty(Globals.Inventory.Wuom)) {
						
						WebElement firstName = webDriver.findElement(By.id("ContentPlaceHolder1_txtwuom"));
						String value = firstName.getAttribute("value");
						System.out.println(value);
						
					
					}
	             if (GenericWrappers.isNotEmpty(Globals.Inventory.Luom)) {
						
						WebElement firstName = webDriver.findElement(By.id("ContentPlaceHolder1_txtluom"));
						String value = firstName.getAttribute("value");
						System.out.println(value);
						
					
					}
	              if (GenericWrappers.isNotEmpty(Globals.Inventory.Qty)) {
						
						WebElement firstName = webDriver.findElement(By.id("ContentPlaceHolder1_txtTotQty"));
						String value = firstName.getAttribute("value");
						System.out.println(value);
						
					
					}
	              if (GenericWrappers.isNotEmpty(Globals.Inventory.LastInQty)) {
						
						WebElement firstName = webDriver.findElement(By.id("ContentPlaceHolder1_txtTotQty"));
						String value = firstName.getAttribute("value");
						System.out.println(value);
						
					
					}
	              if (GenericWrappers.isNotEmpty(Globals.Inventory.GrBasic)) {
						
						WebElement firstName = webDriver.findElement(By.id("ContentPlaceHolder1_txtTotalGBCost"));
						String value = firstName.getAttribute("value");
						System.out.println(value);
						
					
					}
	              if (GenericWrappers.isNotEmpty(Globals.Inventory.GrCost)) {
						
						WebElement firstName = webDriver.findElement(By.id("ContentPlaceHolder1_txtTotalGCost"));
						String value = firstName.getAttribute("value");
						System.out.println(value);
						
					
					}
	              if (GenericWrappers.isNotEmpty(Globals.Inventory.GrDisc)) {
						
						WebElement firstName = webDriver.findElement(By.id("ContentPlaceHolder1_txtGRDisc"));
						String value = firstName.getAttribute("value");
						System.out.println(value);
						
					
					}
	              if (GenericWrappers.isNotEmpty(Globals.Inventory.GrSchm)) {
						
						WebElement firstName = webDriver.findElement(By.id("ContentPlaceHolder1_txtGRShDiscAmt"));
						String value = firstName.getAttribute("value");
						System.out.println(value);
						
					
					}
	              if (GenericWrappers.isNotEmpty(Globals.Inventory.GrGst)) {
						
						WebElement firstName = webDriver.findElement(By.id("ContentPlaceHolder1_txtGRVat"));
						String value = firstName.getAttribute("value");
						System.out.println(value);
						
					
					}
	              if (GenericWrappers.isNotEmpty(Globals.Inventory.GrcAmt)) {
						
						WebElement firstName = webDriver.findElement(By.id("ContentPlaceHolder1_txtGRCessAmt"));
						String value = firstName.getAttribute("value");
						System.out.println(value);
						
					
					}
	              if (GenericWrappers.isNotEmpty(Globals.Inventory.GrAddCess)) {
						
						WebElement firstName = webDriver.findElement(By.id("ContentPlaceHolder1_txtGRAddCess"));
						String value = firstName.getAttribute("value");
						System.out.println(value);
						
					
					}
	              if (GenericWrappers.isNotEmpty(Globals.Inventory.Total)) {
	  				
						WebElement firstName = webDriver.findElement(By.id("ContentPlaceHolder1_txtTotal"));
						String value = firstName.getAttribute("value");
						System.out.println(value);
						
					
					}
					if (GenericWrappers.isNotEmpty(Globals.Inventory.GrAmt)) {
						
						WebElement firstName = webDriver.findElement(By.id("ContentPlaceHolder1_txtNetGrossAmt"));
						String value = firstName.getAttribute("value");
						System.out.println(value);
						
					
					}
	             if (GenericWrappers.isNotEmpty(Globals.Inventory.GstA)) {
						
						WebElement firstName = webDriver.findElement(By.id("ContentPlaceHolder1_txtNetVat"));
						String value = firstName.getAttribute("value");
						System.out.println(value);
						
					
					}
	             if (GenericWrappers.isNotEmpty(Globals.Inventory.TotalCessAmt)) {
						
						WebElement firstName = webDriver.findElement(By.id("ContentPlaceHolder1_txtNetCessAmt"));
						String value = firstName.getAttribute("value");
						System.out.println(value);
						
					
					}
	             if (GenericWrappers.isNotEmpty(Globals.Inventory.GstCessAmt)) {
						
						WebElement firstName = webDriver.findElement(By.id("ContentPlaceHolder1_txtTotalGSTCessAmt"));
						String value = firstName.getAttribute("value");
						System.out.println(value);
						
					
					}
	            if (GenericWrappers.isNotEmpty(Globals.Inventory.BillAmt)) {
						
						WebElement firstName = webDriver.findElement(By.id("ContentPlaceHolder1_txtTotalBillAmt"));
						String value = firstName.getAttribute("value");
						System.out.println(value);
						
					
					}
	             if (GenericWrappers.isNotEmpty(Globals.Inventory.Deduction)) {
						
						WebElement firstName = webDriver.findElement(By.id("ContentPlaceHolder1_txtDeduction"));
						String value = firstName.getAttribute("value");
						System.out.println(value);
						
					
					}
	             if (GenericWrappers.isNotEmpty(Globals.Inventory.Addition)) {
						
						WebElement firstName = webDriver.findElement(By.id("ContentPlaceHolder1_txtAddition"));
						String value = firstName.getAttribute("value");
						System.out.println(value);
						
					
					}
	             if (GenericWrappers.isNotEmpty(Globals.Inventory.TotalPayable)) {
						
						WebElement firstName = webDriver.findElement(By.id("ContentPlaceHolder1_txtTotalPayable"));
						String value = firstName.getAttribute("value");
						System.out.println(value);
						
					
					}
	             if (GenericWrappers.isNotEmpty(Globals.Inventory.TRow)) {
						
						WebElement firstName = webDriver.findElement(By.id("ContentPlaceHolder1_txtTotalRow"));
						String value = firstName.getAttribute("value");
						System.out.println(value);
						
					
					}
	             if (GenericWrappers.isNotEmpty(Globals.Inventory.TQty)) {
						
						WebElement firstName = webDriver.findElement(By.id("ContentPlaceHolder1_txtTotalQty"));
						String value = firstName.getAttribute("value");
						System.out.println(value);
						
					
					}
	             if (GenericWrappers.isNotEmpty(Globals.Inventory.TBasicCost)) {
						
						WebElement firstName = webDriver.findElement(By.id("ContentPlaceHolder1_txtNetBasicCost"));
						String value = firstName.getAttribute("value");
						System.out.println(value);
						
					
					}
	             if (GenericWrappers.isNotEmpty(Globals.Inventory.TotDisc)) {
						
						WebElement firstName = webDriver.findElement(By.id("ContentPlaceHolder1_txtNetDiscount"));
						String value = firstName.getAttribute("value");
						System.out.println(value);
						
					
					}
	             if (GenericWrappers.isNotEmpty(Globals.Inventory.TotSchmDisc)) {
						
						WebElement firstName = webDriver.findElement(By.id("ContentPlaceHolder1_txtNetShDiscAmt"));
						String value = firstName.getAttribute("value");
						System.out.println(value);
						
					
					}
	             
	             if (GenericWrappers.isNotEmpty(Globals.Inventory.TotGrCost)) {
	 				
						WebElement firstName = webDriver.findElement(By.id("ContentPlaceHolder1_txtNetGrossCost"));
						String value = firstName.getAttribute("value");
						System.out.println(value);
						
					
					}
				

					
					pass.ExcelFourData("GRN","Modules", "Actual", "Expected", "Status",
							0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
					pass.Excelcreate("GRN", "ItemAdd", "PASS", 1, 0, 1, 3);
				 
			
			}catch (Exception e) {
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

			ResultSet rs = st.executeQuery("select * from " + tablename + " where InventoryCode='000202'");

			// ResultSet rs = st.executeQuery("");

			while (rs.next()) {

				switch (tablename) {

				case "TBLGIDDETAIL":
					String ItemCode = "";
					try {
						ItemCode = rs.getString("ItemCode");
						System.out.println(ItemCode);
						Assert.assertEquals(Globals.Inventory.ItemCode.trim(), ItemCode.trim());
						pass.Excelcreate("GRN", "TBLGIDDETAIL", "", 5, 0, 5, 1);
						pass.ExcelFourData("GRN", "ItemCode", Globals.Inventory.ItemCode, ItemCode,
								"Pass", 7, 0, 7, 1, 7, 2, 7, 3);

					} catch (AssertionError e) {
						pass.Excelcreate("GRN", "TBLGIDDETAIL", "", 5, 0, 5, 1);
						pass.ExcelFourData("GRN", "ItemCode", Globals.Inventory.ItemCode, ItemCode,
								"Fail", 7, 0, 7, 1, 7, 2, 7, 3);

					}

					

				
					String GrnNo = "";
					try {
						GrnNo = rs.getString("GidNo");
						System.out.println(GrnNo);
						Assert.assertEquals(Globals.Inventory.GrnNo.trim(), GrnNo.trim());
						//pass.Excelcreate("GRN", "tblinventory", "", 9, 0, 9, 1);
						pass.ExcelFourData("GRN", "GrnNo", Globals.Inventory.GrnNo, GrnNo, "Pass",
								8, 0, 8, 1, 8, 2, 8, 3);
					} catch (AssertionError e) {
						//pass.Excelcreate("GRN", "tblinventory", "", 9, 0, 9, 1);
						pass.ExcelFourData("GRN", "GrnNo", Globals.Inventory.GrnNo, GrnNo, "Fail",
								8, 0, 8, 1, 8, 2, 8, 3);

					}
					catch(Exception e) {
						System.out.println("null error tblinventory column CategoryCode");
						}
					String ItemDesc = "";
					try {
						ItemDesc = rs.getString("ItemDesc");
						System.out.println(ItemDesc);
						Assert.assertEquals(Globals.Inventory.ItemDesc.trim(), ItemDesc.trim());
						pass.ExcelFourData("GRN", "ItemDesc", Globals.Inventory.ItemDesc, ItemDesc, "Pass",
								9, 0, 9, 1, 9, 2, 9, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("GRN", "ItemDesc", Globals.Inventory.ItemDesc, ItemDesc, "Fail",
								9, 0, 9, 1, 9, 2, 9, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblinventory column Departmentcode");
						}
					String Luom = "";
					try {
						Luom = rs.getString("LUomCode");
						System.out.println(Luom);
						Assert.assertEquals(Globals.Inventory.Luom.trim(), Luom.trim());
						pass.ExcelFourData("GRN", "Luom", Globals.Inventory.Luom, Luom, "Fail",
								10, 0, 10, 1, 10, 2, 10, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("GRN", "Luom", Globals.Inventory.Luom, Luom, "Fail",
								10, 0, 10, 1, 10, 2, 10, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblinventory column BrandCode");
						}
					String Wuom = "";
					try {
						Wuom = rs.getString("WUomCode");
						System.out.println(Wuom);
						Assert.assertEquals(Globals.Inventory.Wuom.trim(), Wuom.trim());
						pass.ExcelFourData("GRN", "Wuom", Globals.Inventory.Wuom, Wuom, "Pass",
								11, 0, 11, 1, 11, 2, 11, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("GRN", "Wuom", Globals.Inventory.Wuom, Wuom, "Fail",
								11, 0, 11, 1, 11, 2, 11, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblinventory column Barcode");
						}
					String WQty = "";
					try {
						WQty = rs.getString("WQty");
						System.out.println(WQty);
						Assert.assertEquals(Globals.Inventory.WQty.trim(), WQty.trim());
						pass.ExcelFourData("GRN", "WQty", Globals.Inventory.WQty, WQty, "Pass",
								12, 0, 12, 1, 12, 2, 12, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("GRN", "WQty", Globals.Inventory.WQty, WQty, "Fail",
								12, 0, 12, 1, 12, 2, 12, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblinventory column Subcategorycode");
						}
					String BasicCost = "";
					try {

						BasicCost = rs.getString("UnitCost");
						System.out.println(BasicCost);
						Assert.assertEquals(Globals.Inventory.BasicCost.trim(), BasicCost.trim());
						pass.ExcelFourData("GRN", "BasicCost", Globals.Inventory.BasicCost, BasicCost, "Pass",
								13, 0, 13, 1, 13, 2,13, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("GRN", "BasicCost", Globals.Inventory.BasicCost, BasicCost, "Fail",
								13, 0, 13, 1, 13, 2,13, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblinventory column Class");
						}
					
					String GrossCost = "";
					try {
						GrossCost = rs.getString("GrossCost");
						System.out.println(GrossCost);
						Assert.assertEquals(Globals.Inventory.GrossCost.trim(), GrossCost.trim());
						pass.ExcelFourData("GRN", "GrossCost", Globals.Inventory.GrossCost, GrossCost, "Pass",
								14, 0, 14, 1, 14, 2, 14, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("GRN", "GrossCost", Globals.Inventory.GrossCost, GrossCost, "Fail",
								14, 0, 14, 1, 14, 2, 14, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblinventory column SubClass");
						}
					String Netcost="";
					try
					{
						Netcost = rs.getString("NetCost");
					System.out.println(Netcost);
					Assert.assertEquals(Globals.Inventory.Netcost.trim(), Netcost.trim());
					pass.ExcelFourData("GRN", "Netcost", Globals.Inventory.Netcost, Netcost, "Pass",
							15, 0, 15, 1, 15, 2, 15, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("GRN", "Netcost", Globals.Inventory.Netcost, Netcost, "Fail",
							15, 0, 15, 1, 15, 2, 15, 3);
				}
					catch(Exception e) {
						System.out.println("null error tblinventory column Origin");
						}
					String MRP="";
					try
					{
						MRP = rs.getString("MRP");
					System.out.println(MRP);
					Assert.assertEquals(Globals.Inventory.MRP.trim(), MRP.trim());
					pass.ExcelFourData("GRN", "MRP", Globals.Inventory.WareHouse, MRP, "Pass",
							16, 0, 16, 1, 16, 2, 16, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("GRN", "MRP", Globals.Inventory.WareHouse, MRP, "Fail",
							16, 0, 16, 1, 16, 2, 16, 3);
				}
					catch(Exception e) {
						System.out.println("null error tblinventory column Warehouse");
						}
					String WPrice1="";
					try {
						WPrice1 = rs.getString("WPrice1");
					System.out.println(WPrice1);
					Assert.assertEquals(Globals.Inventory.WPrice1.trim(), WPrice1.trim());
					pass.ExcelFourData("GRN", "WPrice1", Globals.Inventory.WPrice1, WPrice1, "Pass",
							17, 0, 17, 1, 17, 2, 17, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("GRN", "WPrice1", Globals.Inventory.WPrice1, WPrice1, "Fail",
							17, 0, 17, 1, 17, 2, 17, 3);
				}
					catch(Exception e) {
						System.out.println("null error tblinventory column UOM");
						}
					String WPrice2="";
				try {
						
					WPrice2 = rs.getString("WPrice2");
					System.out.println(WPrice2);
					Assert.assertEquals(Globals.Inventory.WPrice2.trim(), WPrice2.trim());
					pass.ExcelFourData("GRN", "WPrice2", Globals.Inventory.WPrice2, WPrice2, "Pass",
							18, 0, 18, 1, 18, 2, 18, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("GRN", "WPrice2", Globals.Inventory.WPrice2, WPrice2, "Fail",
							18, 0, 18, 1, 18, 2, 18, 3);
				}
				catch(Exception e) {
					System.out.println("null error tblinventory column Manufacturer");
					}
				String WPrice3="";
				try {
					
					WPrice3 = rs.getString("WPrice3");
					System.out.println(WPrice3);
					Assert.assertEquals(Globals.Inventory.WPrice3.trim(), WPrice3.trim());
					pass.ExcelFourData("GRN", "WPrice3", Globals.Inventory.WPrice3, WPrice3, "Pass",
							19, 0, 19, 1, 19, 2, 19, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("GRN", "WPrice3", Globals.Inventory.WPrice3, WPrice3, "Fail",
							19, 0, 19, 1, 19, 2, 19, 3);
				}
				catch(Exception e) {
					System.out.println("null error tblinventory column ItemType");
					}
				String LQty="";
				try {
					LQty = rs.getString("LQty");
					System.out.println(LQty);
					Assert.assertEquals(Globals.Inventory.TQty.trim(), LQty.trim());
					pass.ExcelFourData("GRN", "LQty", Globals.Inventory.TQty, LQty, "Pass",
							20, 0, 20, 1, 20, 2, 20, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("GRN", "LQty", Globals.Inventory.TQty, LQty, "Fail",
							20, 0, 20, 1, 20, 2, 20, 3);
				}
				catch(Exception e) {
					System.out.println("null error tblinventory column Weight");
					}
				String Tax="";
				try {
					Tax = rs.getString("Tax");
				    System.out.println(Tax);
				    Assert.assertEquals(Globals.Inventory.Gst.trim(), Tax.trim());
				    pass.ExcelFourData("GRN", "Tax", Globals.Inventory.Gst, Tax, "Pass",
							21, 0, 21, 1, 21, 2, 21, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("GRN", "Tax", Globals.Inventory.Gst, Tax, "Fail",
							21, 0, 21, 1, 21, 2, 21, 3);
				}
				catch(Exception e) {
				System.out.println("null error tblinventory column Width");
				}
				String GrGst="";
				try {
					GrGst = rs.getString("GrossTaxvalue");
					System.out.println(GrGst);
					Assert.assertEquals(Globals.Inventory.GrGst.trim(), GrGst.trim());
					pass.ExcelFourData("GRN", "GrGst", Globals.Inventory.Height, GrGst, "Pass",
							22, 0, 22, 1, 22, 2, 22, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("GRN", "GrGst", Globals.Inventory.Height, GrGst, "Fail",
							22, 0, 22, 1, 22, 2, 22, 3);
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
				break;
				case "TBLGIDHEADER":
				
				String GidNo="";
				try {
					GidNo = rs.getString("GidNo");
					System.out.println(GidNo);
					Assert.assertEquals(Globals.Inventory.GrnNo.trim(), GidNo.trim());
					pass.Excelcreate("GRN", "TBLGIDHEADER", "", 25, 0, 25, 1);
					pass.ExcelFourData("GRN", "GidNo", Globals.Inventory.GrnNo, GidNo, "Pass",
							26, 0, 26, 1, 26, 2, 26, 3);
				} catch (AssertionError e) {
					pass.Excelcreate("GRN", "TBLGIDHEADER", "", 25, 0, 25, 1);
					pass.ExcelFourData("GRN", "GidNo", Globals.Inventory.GrnNo, GidNo, "Fail",
							26, 0, 26, 1, 26, 2, 26, 3);
				}
				catch(Exception e) {
					System.out.println("null error tblinventory column VendorCode");
				}
				String InvNo ="";
				try {
					InvNo = rs.getString("DONo");
					System.out.println(InvNo);
					Assert.assertEquals(Globals.Inventory.InvNo.trim(), InvNo.trim());
					pass.ExcelFourData("GRN", "InvNo", Globals.Inventory.InvNo, InvNo, "Pass",
							27, 0, 27, 1, 27, 2, 27, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("GRN", "InvNo", Globals.Inventory.InvNo, InvNo, "Fail",
							27, 0, 27, 1, 27, 2, 27, 3);
				}
				catch(Exception e) {
					System.out.println("null error tblinventory column UnitCost");
				}
				String TotalPayable="";
				try {
					TotalPayable = rs.getString("GidTotalValue");
					System.out.println(TotalPayable);
					Assert.assertEquals(Globals.Inventory.TotalPayable.trim(), TotalPayable.trim());
					pass.ExcelFourData("GRN", "TotalPayable", Globals.Inventory.TotalPayable, TotalPayable, "Pass",
							28, 0, 28, 1, 28, 2, 28, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("GRN", "TotalPayable", Globals.Inventory.TotalPayable, TotalPayable, "Fail",
							28, 0, 28, 1, 28, 2, 28, 3);
				}
				catch(Exception e) {
					System.out.println("null error tblinventory column SellingPrice");
				}
				String Gst="";
				try
				{
					Gst = rs.getString("Gst");
					System.out.println(Gst);
					Assert.assertEquals(Globals.Inventory.Gst.trim(), Gst.trim());
					pass.ExcelFourData("GRN", "GST", Globals.Inventory.Gst, Gst, "Pass",
							29, 0, 29, 1, 29, 2, 29, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("GRN", "GST", Globals.Inventory.Gst, Gst, "Fail",
							29, 0, 29, 1, 29, 2, 29, 3);
				}
				catch(Exception e) {
					System.out.println("null error tblinventory column MRP");
				}
				String Vendor="";
				try
				{
					Vendor = rs.getString("VendorCode");
					System.out.println(Vendor);
					Assert.assertEquals(Globals.Inventory.Vendor.trim(), Vendor.trim());
					pass.ExcelFourData("GRN", "Vendor", Globals.Inventory.Vendor, Vendor, "Pass",
							30, 0, 30, 1, 30, 2, 30, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("GRN", "Vendor", Globals.Inventory.Vendor, Vendor, "Fail",
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

				case "tblinventory":
					String Inventory ="";
					try {
						Inventory = rs.getString("InventoryCode");
					System.out.println(Inventory);
					Assert.assertEquals(Globals.Inventory.ItemCode.trim(), Inventory.trim());
					pass.Excelcreate("GRN", "tblinventory", "", 34, 0, 34, 1);
					pass.ExcelFourData("GRN", "Inventory", Globals.Inventory.ItemCode, Inventory, "Pass",
							35, 0, 35, 1, 35, 2, 35, 3);
				} catch (AssertionError e) {
					pass.Excelcreate("GRN", "tblinventory", "", 34, 0, 34, 1);
					pass.ExcelFourData("GRN", "Inventory", Globals.Inventory.ItemCode, Inventory, "Fail",
							35, 0, 35, 1, 35, 2, 35, 3);
				}
					catch(Exception e) {
						System.out.println("null error tblinventorypricing column NetSellingPrice");
					}
					String Description="";
					try {
						Description = rs.getString("Description");
					System.out.println(Description);
					Assert.assertEquals(Globals.Inventory.ItemDesc.trim(), Description.trim());
					pass.ExcelFourData("GRN", "Description", Globals.Inventory.ItemDesc, Description, "Pass",
							36, 0, 36, 1, 36, 2, 36, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("GRN", "Description", Globals.Inventory.ItemDesc, Description, "Fail",
							36, 0, 36, 1, 36, 2, 36, 3);
				}
					catch(Exception e) {
						System.out.println("null error tblinventorypricing column PurchasedBy");
					}
					String UOM ="";
					try {
						UOM = rs.getString("UOM");
					System.out.println(UOM);
					Assert.assertEquals(Globals.Inventory.Luom.trim(), UOM.trim());
					pass.ExcelFourData("GRN", "UOM", Globals.Inventory.Luom, UOM, "Pass",
							37, 0, 37, 1, 37, 2, 37, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("GRN", "UOM", Globals.Inventory.Luom, UOM, "Fail",
							37, 0, 37, 1, 37, 2, 37, 3);
				}
					catch(Exception e) {
						System.out.println("null error tblinventorypricing column MRP");
					}
					String Basicost1="";
					try {
					Basicost1 = rs.getString("UnitCost");
					System.out.println(Basicost1);
					Assert.assertEquals(Globals.Inventory.BasicCost.trim(), Basicost1.trim());
					pass.ExcelFourData("GRN", "BasicCost", Globals.Inventory.BasicCost, Basicost1, "Pass",
							38, 0, 38, 1, 38, 2, 38, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("GRN", "BasicCost", Globals.Inventory.BasicCost, Basicost1, "Fail",
							38, 0, 38, 1, 38, 2, 38, 3);
				}
					catch(Exception e) {
						System.out.println("null error tblinventorypricing column BasicCost");
					}
					String Vendor1="";
					try {
						Vendor1 = rs.getString("VendorCode");
					System.out.println(Vendor1);
					Assert.assertEquals(Globals.Inventory.Vendor.trim(), Vendor1.trim());
					pass.ExcelFourData("GRN", "Vendor", Globals.Inventory.Vendor, Vendor1, "Pass",
							39, 0, 39, 1, 39, 2, 39, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("GRN", "Vendor", Globals.Inventory.Vendor, Vendor1, "Fail",
							39, 0, 39, 1, 39, 2, 39, 3);
				}
					catch(Exception e) {
						System.out.println("null error tblinventorypricing column DiscountBasicPer");
					}
					String AverageCost ="";
					try {
						AverageCost = rs.getString("AverageCost");
					System.out.println(AverageCost);
					Assert.assertEquals(Globals.Inventory.Netcost.trim(), AverageCost.trim());
					pass.ExcelFourData("GRN", "AverageCost", Globals.Inventory.Netcost, AverageCost, "Pass",
							40, 0, 40, 1, 40, 2, 40, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("GRN", "AverageCost", Globals.Inventory.Netcost, AverageCost, "Fail",
							40, 0, 40, 1, 40, 2, 40, 3);
				}
					catch(Exception e) {
						System.out.println("null error tblinventorypricing column DiscountBasicPer2");
					}
					String SellingPrice1="";
					try {
						SellingPrice1 = rs.getString("SellingPrice");
					System.out.println(SellingPrice1);
					Assert.assertEquals(Globals.Inventory.MRP.trim(), SellingPrice1.trim());
					pass.ExcelFourData("GRN", "SellingPrice", Globals.Inventory.MRP, SellingPrice1, "Pass",
							41, 0, 41, 1, 41, 2, 41, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("GRN", "SellingPrice", Globals.Inventory.MRP, SellingPrice1, "Fail",
							41, 0, 41, 1, 41, 2, 41, 3);
				}
					catch(Exception e) {
						System.out.println("null error tblinventorypricing column DiscountBasicPer3");
					}
			
					String Mrp ="";
					try {
						Mrp = rs.getString("MRP");
					System.out.println(Mrp);
					Assert.assertEquals(Globals.Inventory.MRP.trim(), Mrp.trim());
					pass.ExcelFourData("GRN", "MRP", Globals.Inventory.MRP, Mrp, "Pass",
							42, 0, 42, 1, 42, 2, 42, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("GRN", "MRP", Globals.Inventory.MRP, Mrp, "Fail",
							42, 0, 42, 1, 42, 2, 42, 3);
				}
					catch(Exception e) {
						System.out.println("null error tblinventorypricing column MPWPrice3");
					}
				
					String Qty1 ="";
					try {
						Qty1 = rs.getString("LastInQty");
					System.out.println(Qty1);
					Assert.assertEquals(Globals.Inventory.LastInQty.trim(), Qty1.trim());
					pass.ExcelFourData("GRN", "LastInQty", Globals.Inventory.LastInQty, Qty1, "Pass",
							43, 0, 43, 1, 43, 2, 43, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("GRN", "LastInQty", Globals.Inventory.LastInQty, Qty1, "Fail",
							43, 0, 43, 1, 43, 2, 43, 3);
				}
					catch(Exception e) {
						System.out.println("null error tblinventorypricing column OTaxPer3");
					}
					String Cess="";
					try {
					Cess = rs.getString("LastInCost");
					System.out.println(Cess);
					Assert.assertEquals(Globals.Inventory.Netcost.trim(), Cess.trim());
					pass.ExcelFourData("GRN", "ITaxPer4", Globals.Inventory.Netcost, Cess, "Pass",
							44, 0, 44, 1, 44, 2, 44, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("GRN", "ITaxPer4", Globals.Inventory.Netcost, Cess, "Fail",
							44, 0, 44, 1, 44, 2, 44, 3);
				}
					catch(Exception e) {
						System.out.println("null error tblinventorypricing column OTaxPer4");
					}
					/*String Cess1="";
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
					}*/

					break;

				case "tblinventorystock":
					String ItemCode2="";
					try {
						ItemCode2 = rs.getString("InventoryCode");
					System.out.println(ItemCode2);
					Assert.assertEquals(Globals.Inventory.ItemCode.trim(), ItemCode2.trim());
					pass.Excelcreate("GRN", "tblinventorystock", "", 48, 0, 48, 1);
					pass.ExcelFourData("GRN", "InventoryCode", Globals.Inventory.ItemCode, ItemCode2, "Pass",
							49, 0, 49, 1, 49, 2, 49, 3);
				} catch (AssertionError e) {
					pass.Excelcreate("GRN", "tblinventorystock", "",48, 0, 48, 1);
					pass.ExcelFourData("GRN", "InventoryCode", Globals.Inventory.ItemCode, ItemCode2, "Fail",
							49, 0, 49, 1, 49, 2, 49, 3);
				}
					catch(Exception e) {
						System.out.println("null error TBLBATCHINVENTORYCONTROL column SellingPrice");
					}
					String Desc="";
					try {
						Desc = rs.getString("Description");
					System.out.println(Desc);
					Assert.assertEquals(Globals.Inventory.ItemDesc.trim(), Desc.trim());
					pass.ExcelFourData("GRN", "Description", Globals.Inventory.ItemDesc, Desc, "Pass",
							50, 0, 50, 1, 50, 2, 50, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("GRN", "Description", Globals.Inventory.ItemDesc, Desc, "Fail",
							50, 0, 50, 1, 50, 2, 50, 3);
				}
					catch(Exception e) {
						System.out.println("null error TBLBATCHINVENTORYCONTROL column MRP");
					}
					String Basicost2="";
					try {
					Basicost2 = rs.getString("AverageCost");
					System.out.println(Basicost2);
					Assert.assertEquals(Globals.Inventory.Netcost.trim(), Basicost2.trim());
					pass.ExcelFourData("GRN", "AverageCost", Globals.Inventory.Netcost, Basicost2, "Pass",
							51, 0, 51, 1, 51, 2, 51, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("GRN", "AverageCost", Globals.Inventory.Netcost, Basicost2, "Fail",
							51, 0, 51, 1, 51, 2, 51, 3);
				}
					catch(Exception e) {
						System.out.println("null error TBLBATCHINVENTORYCONTROL column Unitcost");
					}
					String Price="";
					try {
						Price = rs.getString("Price");
					System.out.println(Price);
					Assert.assertEquals(Globals.Inventory.MRP.trim(), Price.trim());
					pass.ExcelFourData("GRN", "Price", Globals.Inventory.MRP, Price, "Pass",
							52, 0, 52, 1, 52, 2, 52, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("GRN", "Price", Globals.Inventory.MRP, Price, "Fail",
							52, 0, 52, 1, 52, 2, 52, 3);
				}
					catch(Exception e) {
						System.out.println("null error TBLBATCHINVENTORYCONTROL column WPrice1");
					}
					/*String W22="";
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
					}*/	
					break;
					
				case "tblinventorypricing":
					String Inventorycode="";
					try {
					Inventorycode = rs.getString("InventoryCode");
					System.out.println(Inventorycode);
					Assert.assertEquals(Globals.Inventory.ItemCode.trim(), Inventorycode.trim());
					pass.Excelcreate("GRN", "tblinventorypricing", "", 55, 0, 55, 1);
					pass.ExcelFourData("GRN", "ItemCode", Globals.Inventory.ItemCode, Inventorycode, "Pass",
							56, 0, 56, 1, 56, 2, 56, 3);
				} catch (AssertionError e) {
					pass.Excelcreate("GRN", "tblinventorypricing", "", 55, 0, 55, 1);
					pass.ExcelFourData("GRN", "ItemCode", Globals.Inventory.ItemCode, Inventorycode, "Fail",
							56, 0, 56, 1, 56, 2, 56, 3);
				}
					catch(Exception e) {
						System.out.println("null error tblinventorystock column InventoryCode");
					}	
					
					String mrp="";
					try {
						
						mrp = rs.getString("MRP");
					System.out.println(mrp);
					Assert.assertEquals(Globals.Inventory.MRP.trim(), mrp.trim());
					
					pass.ExcelFourData("GRN", "MRP", Globals.Inventory.MRP, mrp, "Pass",
							57, 0, 57, 1, 57, 2, 57, 3);
				} catch (AssertionError e) {
					
					pass.ExcelFourData("GRN", "MRP", Globals.Inventory.MRP, mrp, "Fail",
							57, 0, 57, 1, 57, 2, 57, 3);
				}
					catch(Exception e) {
						System.out.println("null error tblinventorystock column InventoryCode");
					}
					
				
					String Brandcode1="";
					try {
					Brandcode1 = rs.getString("BasicCost");
					System.out.println(Brandcode1);
					Assert.assertEquals(Globals.Inventory.BasicCost.trim(), Brandcode1.trim());
					
					pass.ExcelFourData("GRN", "BasicCost", Globals.Inventory.BasicCost, Brandcode1, "Pass",
							58, 0, 58, 1, 58, 2, 58, 3);
				} catch (AssertionError e) {
					
					pass.ExcelFourData("GRN", "BasicCost", Globals.Inventory.BasicCost, Brandcode1, "Fail",
							58, 0, 58, 1, 58, 2, 58, 3);
				}
					catch(Exception e) {
						System.out.println("null error tblbarcode column BarCode");
					}
					String Inventorycode11="";
					try {
					Inventorycode11 = rs.getString("GrossCost");
					System.out.println(Inventorycode11);
					Assert.assertEquals(Globals.Inventory.GrossCost.trim(), Inventorycode11.trim());
					pass.ExcelFourData("GRN", "GrossCost", Globals.Inventory.GrossCost, Inventorycode11, "Pass",
							59, 0, 59, 1, 59, 2, 59, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("GRN", "GrossCost", Globals.Inventory.GrossCost, Inventorycode11, "Fail",
							59, 0, 59, 1, 59, 2, 59, 3);
				}
					catch(Exception e) {
						System.out.println("null error tblbarcode column InventoryCode");
					}
					String NetCost="";
					try {
						NetCost = rs.getString("NetCost");
					System.out.println(NetCost);
					Assert.assertEquals(Globals.Inventory.Netcost.trim(), NetCost.trim());
					pass.ExcelFourData("GRN", "NetCost", Globals.Inventory.Netcost, NetCost, "Pass",
							60, 0, 60, 1, 60, 2, 60, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("GRN", "NetCost", Globals.Inventory.Netcost, NetCost, "Fail",
							60, 0, 60, 1, 60, 2, 60, 3);
				}
					catch(Exception e) {
						System.out.println("null error tblbarcode column InventoryCode");
					}
					String MarginPer="";
					try {
						MarginPer = rs.getString("MFPer");
					System.out.println(MarginPer);
					Assert.assertEquals(Globals.Inventory.MEarned.trim(), MarginPer.trim());
					pass.ExcelFourData("GRN", "MarginPer", Globals.Inventory.MEarned, MarginPer, "Pass",
							61, 0, 61, 1, 61, 2, 61, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("GRN", "MarginPer", Globals.Inventory.MEarned, MarginPer, "Fail",
							61, 0, 61, 1, 61, 2, 61, 3);
				}
					catch(Exception e) {
						System.out.println("null error tblbarcode column InventoryCode");
					}
					String NetSellingPrice="";
					try {
						NetSellingPrice = rs.getString("NetSellingPrice");
					System.out.println(NetSellingPrice);
					Assert.assertEquals(Globals.Inventory.MRP.trim(), NetSellingPrice.trim());
					pass.ExcelFourData("GRN", "NetSellingPrice", Globals.Inventory.MRP, NetSellingPrice, "Pass",
							62, 0, 62, 1, 62, 2, 62, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("GRN", "NetSellingPrice", Globals.Inventory.MRP, NetSellingPrice, "Fail",
							62, 0, 62, 1, 62, 2, 62, 3);
				}
					catch(Exception e) {
						System.out.println("null error tblbarcode column InventoryCode");
					}
					String EarnedMargin="";
					try {
						EarnedMargin = rs.getString("EarnedMargin");
					System.out.println(EarnedMargin);
					Assert.assertEquals(Globals.Inventory.SpFixing.trim(), EarnedMargin.trim());
					pass.ExcelFourData("GRN", "EarnedMargin", Globals.Inventory.SpFixing, EarnedMargin, "Pass",
							63, 0, 63, 1, 63, 2, 63, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("GRN", "EarnedMargin", Globals.Inventory.SpFixing, EarnedMargin, "Fail",
							63, 0, 63, 1, 63, 2, 63, 3);
				}
					catch(Exception e) {
						System.out.println("null error tblbarcode column InventoryCode");
					}
					String Wprice1="";
					try {
						Wprice1 = rs.getString("WPrice1");
					System.out.println(Wprice1);
					Assert.assertEquals(Globals.Inventory.WPrice1.trim(), Wprice1.trim());
					pass.ExcelFourData("GRN", "WPrice1", Globals.Inventory.WPrice1, Wprice1, "Pass",
							64, 0, 64, 1, 64, 2, 64, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("GRN", "WPrice1", Globals.Inventory.WPrice1, Wprice1, "Fail",
							64, 0, 64, 1, 64, 2, 64, 3);
				}
					catch(Exception e) {
						System.out.println("null error tblinventory column UOM");
						}
					String Wprice2="";
				try {
						
					Wprice2 = rs.getString("WPrice2");
					System.out.println(Wprice2);
					Assert.assertEquals(Globals.Inventory.WPrice2.trim(), Wprice2.trim());
					pass.ExcelFourData("GRN", "WPrice2", Globals.Inventory.WPrice2, Wprice2, "Pass",
							65, 0, 65, 1, 65, 2, 65, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("GRN", "WPrice2", Globals.Inventory.WPrice2, Wprice2, "Fail",
							65, 0, 65, 1, 65, 2, 65, 3);
				}
				catch(Exception e) {
					System.out.println("null error tblinventory column Manufacturer");
					}
				String Wprice3="";
				try {
					
					Wprice3 = rs.getString("WPrice3");
					System.out.println(Wprice3);
					Assert.assertEquals(Globals.Inventory.WPrice3.trim(), Wprice3.trim());
					pass.ExcelFourData("GRN", "WPrice3", Globals.Inventory.WPrice3, Wprice3, "Pass",
							66, 0, 66, 1, 66, 2, 66, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("GRN", "WPrice3", Globals.Inventory.WPrice3, Wprice3, "Fail",
							66, 0, 66, 1, 66, 2, 66, 3);
				}
				catch(Exception e) {
					System.out.println("null error tblinventory column ItemType");
					}
					break;
				case "tblBatchInventoryControl":
					String ItemCode3="";
					try {
						ItemCode3 = rs.getString("InventoryCode");
					System.out.println(ItemCode3);
					Assert.assertEquals(Globals.Inventory.ItemCode.trim(), ItemCode3.trim());
					pass.Excelcreate("GRN", "tblBatchInventoryControl", "", 69, 0, 69, 1);
					pass.ExcelFourData("GRN", "InventoryCode", Globals.Inventory.ItemCode, ItemCode3, "Pass",
							70, 0, 70, 1, 70, 2, 70, 3);
				} catch (AssertionError e) {
					pass.Excelcreate("GRN", "tblBatchInventoryControl", "",69, 0, 69, 1);
					pass.ExcelFourData("GRN", "InventoryCode", Globals.Inventory.ItemCode, ItemCode3, "Fail",
							70, 0, 70, 1, 70, 2, 70, 3);
				}
					catch(Exception e) {
						System.out.println("null error TBLBATCHINVENTORYCONTROL column SellingPrice");
					}
					String GrossCost5="";
					try {
						GrossCost5 = rs.getString("Grosscost");
					System.out.println(GrossCost5);
					Assert.assertEquals(Globals.Inventory.GrossCost.trim(), GrossCost5.trim());
					pass.ExcelFourData("GRN", "GrossCost", Globals.Inventory.GrossCost, GrossCost5, "Pass",
							71, 0, 71, 1, 71, 2, 71, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("GRN", "GrossCost", Globals.Inventory.GrossCost, GrossCost5, "Fail",
							71, 0, 71, 1, 71, 2, 71, 3);
				}
					catch(Exception e) {
						System.out.println("null error TBLBATCHINVENTORYCONTROL column MRP");
					}
					String UnitCost2="";
					try {
						UnitCost2 = rs.getString("UnitCost");
					System.out.println(UnitCost2);
					Assert.assertEquals(Globals.Inventory.GrossCost.trim(), UnitCost2.trim());
					pass.ExcelFourData("GRN", "UnitCost", Globals.Inventory.GrossCost, UnitCost2, "Pass",
							72, 0, 72, 1, 72, 2, 72, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("GRN", "UnitCost", Globals.Inventory.GrossCost, UnitCost2, "Fail",
							72, 0, 72, 1, 72, 2, 72, 3);
				}
					catch(Exception e) {
						System.out.println("null error TBLBATCHINVENTORYCONTROL column MRP");
					}
					String Basicost3="";
					try {
						Basicost3 = rs.getString("Basicost");
					System.out.println(Basicost3);
					Assert.assertEquals(Globals.Inventory.BasicCost.trim(), Basicost3.trim());
					pass.ExcelFourData("GRN", "AverageCost", Globals.Inventory.BasicCost, Basicost3, "Pass",
							73, 0, 73, 1, 73, 2, 73, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("GRN", "AverageCost", Globals.Inventory.BasicCost, Basicost3, "Fail",
							73, 0, 73, 1, 73, 2, 73, 3);
				}
					catch(Exception e) {
						System.out.println("null error TBLBATCHINVENTORYCONTROL column Unitcost");
					}
					String Price1="";
					try {
						Price1 = rs.getString("MRP");
					System.out.println(Price1);
					Assert.assertEquals(Globals.Inventory.MRP.trim(), Price1.trim());
					pass.ExcelFourData("GRN", "MRP", Globals.Inventory.MRP, Price1, "Pass",
							74, 0, 74, 1, 74, 2, 74, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("GRN", "MRP", Globals.Inventory.MRP, Price1, "Fail",
							74, 0, 74, 1, 74, 2, 74, 3);
				}
					catch(Exception e) {
						System.out.println("null error TBLBATCHINVENTORYCONTROL column WPrice1");
					}
					String sellingprice="";
					try {
						sellingprice = rs.getString("SellingPrice");
					System.out.println(sellingprice);
					Assert.assertEquals(Globals.Inventory.Netcost.trim(), sellingprice.trim());
					pass.ExcelFourData("GRN", "SellingPrice", Globals.Inventory.Netcost, sellingprice, "Pass",
							75, 0, 75, 1, 75, 2, 75, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("GRN", "SellingPrice", Globals.Inventory.Netcost, sellingprice, "Fail",
							75, 0, 75, 1, 75, 2, 75, 3);
				}
					catch(Exception e) {
						System.out.println("null error TBLBATCHINVENTORYCONTROL column WPrice1");
					}
					String wprice1="";
					try {
						wprice1 = rs.getString("WPrice1");
					System.out.println(wprice1);
					Assert.assertEquals(Globals.Inventory.WPrice1.trim(), wprice1.trim());
					pass.ExcelFourData("GRN", "WPrice1", Globals.Inventory.WPrice1, wprice1, "Pass",
							76, 0, 76, 1, 76, 2, 76, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("GRN", "WPrice1", Globals.Inventory.WPrice1, wprice1, "Fail",
							76, 0, 76, 1, 76, 2, 76, 3);
				}
					catch(Exception e) {
						System.out.println("null error tblinventory column UOM");
						}
					String wprice2="";
				try {
						
					wprice2 = rs.getString("WPrice2");
					System.out.println(wprice2);
					Assert.assertEquals(Globals.Inventory.WPrice2.trim(), wprice2.trim());
					pass.ExcelFourData("GRN", "WPrice2", Globals.Inventory.WPrice2, wprice2, "Pass",
							77, 0, 77, 1, 77, 2, 77, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("GRN", "WPrice2", Globals.Inventory.WPrice2, wprice2, "Fail",
							77, 0, 77, 1, 77, 2, 77, 3);
				}
				catch(Exception e) {
					System.out.println("null error tblinventory column Manufacturer");
					}
				String wprice3="";
				try {
					
					wprice3 = rs.getString("WPrice3");
					System.out.println(wprice3);
					Assert.assertEquals(Globals.Inventory.WPrice3.trim(), wprice3.trim());
					pass.ExcelFourData("GRN", "WPrice3", Globals.Inventory.WPrice3, wprice3, "Pass",
							78, 0, 78, 1, 78, 2, 78, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("GRN", "WPrice3", Globals.Inventory.WPrice3, wprice3, "Fail",
							78, 0, 78, 1, 78, 2, 78, 3);
				}
				catch(Exception e) {
					System.out.println("null error tblinventory column ItemType");
					}
					break;
				case "tblInventoryShelfQty":
					String ItemCode4="";
					try {
						ItemCode4 = rs.getString("InventoryCode");
					System.out.println(ItemCode4);
					Assert.assertEquals(Globals.Inventory.ItemCode.trim(), ItemCode4.trim());
					pass.Excelcreate("GRN", "tblInventoryShelfQty", "", 79, 0, 79, 1);
					pass.ExcelFourData("GRN", "InventoryCode", Globals.Inventory.ItemCode, ItemCode4, "Pass",
							80, 0, 80, 1, 80, 2, 80, 3);
				} catch (AssertionError e) {
					pass.Excelcreate("GRN", "tblInventoryShelfQty", "",79, 0, 79, 1);
					pass.ExcelFourData("GRN", "InventoryCode", Globals.Inventory.ItemCode, ItemCode4, "Fail",
							80, 0, 80, 1, 80, 2, 80, 3);
				}
					catch(Exception e) {
						System.out.println("null error TBLBATCHINVENTORYCONTROL column SellingPrice");
					}
					String QTY="";
					try {
						QTY = rs.getString("ShelfQty");
					System.out.println(QTY);
					Assert.assertEquals(Globals.Inventory.Qty.trim(), QTY.trim());
					pass.ExcelFourData("GRN", "ShelfQty", Globals.Inventory.Qty, QTY, "Pass",
							81, 0, 81, 1, 81, 2, 81, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("GRN", "ShelfQty", Globals.Inventory.Qty, QTY, "Fail",
							81, 0, 81, 1, 81, 2, 81, 3);
				}
					catch(Exception e) {
						System.out.println("null error TBLBATCHINVENTORYCONTROL column MRP");
					}
									
				default:
					break;
				}

			}

		}

		
				
			   
		   }
	
		
		




