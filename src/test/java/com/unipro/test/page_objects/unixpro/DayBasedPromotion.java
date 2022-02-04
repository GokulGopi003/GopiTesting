package com.unipro.test.page_objects.unixpro;


	import java.io.IOException;

	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.Iterator;
	import java.util.List;

import org.apache.poi.util.SystemOutLogger;
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

	import cucumber.api.java.en.Given;
	import cucumber.api.java.en.Then;
	import net.bytebuddy.agent.builder.AgentBuilder.CircularityLock.Global;

	public class DayBasedPromotion extends PageObject {
		AddInventoryFormPage Inventorychange;
		DayBasedPromotionField icp;
		CommonPages cp;
		TerminalPage terpage;
		ExcelWrite pass;
		Screenshot scr;

		public DayBasedPromotion(DayBasedPromotionField icp, CommonPages cp) {

			this.icp = icp;
			this.cp = cp;

			terpage = new TerminalPage();
			Inventorychange = new AddInventoryFormPage();
			pass = new ExcelWrite();
			scr = new Screenshot();

		}

		@Then("I load the DayBasedPromotion sheet data to map")
		public void I_load_the_Inventorychange_sheet_data_to_map() {
			Globals.Inventory.DayBasedPromotionSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME57);

		}

		@Then("I load the rowise DayBasedPromotion data for {string} rowname")
		public void i_load_the_rowise_Inventorychange_data_for_rowname(String row_name) {
			Globals.Inventory.DayBasedPromotionrowwiseData = ReadTestData
					.getRowFilteredValueFromTable(Globals.Inventory.DayBasedPromotionSheetData, row_name);
			System.out.println(Globals.Inventory.DayBasedPromotionrowwiseData);
		}

		@Then("I update value to the DayBasedPromotion page global Variables")
		public void i_update_value_to_the_ConsolidatedPO_page_global_Variables() {
			Globals.Inventory.Vendor = Globals.Inventory.DayBasedPromotionrowwiseData.get("Vendor");
			Globals.Inventory.Department = Globals.Inventory.DayBasedPromotionrowwiseData.get("Department");
			Globals.Inventory.Category = Globals.Inventory.DayBasedPromotionrowwiseData.get("Category");
			Globals.Inventory.Brand = Globals.Inventory.DayBasedPromotionrowwiseData.get("Brand");
			Globals.Inventory.SubCategory = Globals.Inventory.DayBasedPromotionrowwiseData.get("SubCategory");
			Globals.Inventory.Merchandise = Globals.Inventory.DayBasedPromotionrowwiseData.get("Merchandise");
			Globals.Inventory.Manufacture = Globals.Inventory.DayBasedPromotionrowwiseData.get("Manufacture");
			Globals.Inventory.Floorcode = Globals.Inventory.DayBasedPromotionrowwiseData.get("Floorcode");
			Globals.Inventory.Section = Globals.Inventory.DayBasedPromotionrowwiseData.get("Section");
			Globals.Inventory.Bin = Globals.Inventory.DayBasedPromotionrowwiseData.get("Bin");
			Globals.Inventory.ShelfCode = Globals.Inventory.DayBasedPromotionrowwiseData.get("ShelfCode");
			Globals.Inventory.ItemCode = Globals.Inventory.DayBasedPromotionrowwiseData.get("ItemCode");
			Globals.Inventory.ItemName = Globals.Inventory.DayBasedPromotionrowwiseData.get("ItemName");
			Globals.Inventory.Barcode = Globals.Inventory.DayBasedPromotionrowwiseData.get("Barcode");
			Globals.Inventory.Batch = Globals.Inventory.DayBasedPromotionrowwiseData.get("Batch");
			Globals.Inventory.Batch1= Globals.Inventory.DayBasedPromotionrowwiseData.get("Batch1");
			Globals.Inventory.Batch2= Globals.Inventory.DayBasedPromotionrowwiseData.get("Batch2");
			Globals.Inventory.Description= Globals.Inventory.DayBasedPromotionrowwiseData.get("Description");
			Globals.Inventory.FromDate= Globals.Inventory.DayBasedPromotionrowwiseData.get("FromDate");
			Globals.Inventory.ToDate= Globals.Inventory.DayBasedPromotionrowwiseData.get("ToDate");
			Globals.Inventory.FromTime= Globals.Inventory.DayBasedPromotionrowwiseData.get("FromTime");
			Globals.Inventory.ToTime = Globals.Inventory.DayBasedPromotionrowwiseData.get("ToTime");
			Globals.Inventory.Days = Globals.Inventory.DayBasedPromotionrowwiseData.get("Days");
			Globals.Inventory.Discount = Globals.Inventory.DayBasedPromotionrowwiseData.get("Discount");
			Globals.Inventory.Status = Globals.Inventory.DayBasedPromotionrowwiseData.get("Status");
			Globals.Inventory.Billno = Globals.Inventory.DayBasedPromotionrowwiseData.get("Billno");
			
		}

		@Then("I fill new DayBasedPromotion data page using excel data")
		public void i_fill_new_Inventorychange_data_page_using_excel_data() throws Exception {
			try {
				
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Vendor)) {
					terpage.terminal_waitClearEnterText_css(icp.Vendor_String, Globals.Inventory.Vendor);
					Inventorychange.clearAndTypeSlowly(Globals.Inventory.Vendor, "input#txtSearch");
					Inventorychange.return_td_invoke_element(Globals.Inventory.Vendor).click();
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Department)) {
					terpage.terminal_waitClearEnterText_css(icp.Department_String, Globals.Inventory.Department);
					Inventorychange.clearAndTypeSlowly(Globals.Inventory.Department, "input#txtSearch");
					Inventorychange.return_td_invoke_element(Globals.Inventory.Department).click();
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Category)) {
					terpage.terminal_waitClearEnterText_css(icp.Category_String, Globals.Inventory.Category);
					Inventorychange.clearAndTypeSlowly(Globals.Inventory.Category, "input#txtSearch");
					Inventorychange.return_td_invoke_element(Globals.Inventory.Category).click();
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Brand)) {
					terpage.terminal_waitClearEnterText_css(icp.Brand_String, Globals.Inventory.Brand);
					Inventorychange.clearAndTypeSlowly(Globals.Inventory.Brand, "input#txtSearch");
					Inventorychange.return_td_invoke_element(Globals.Inventory.Brand).click();
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.SubCategory)) {
					terpage.terminal_waitClearEnterText_css(icp.SubCategory_String, Globals.Inventory.SubCategory);
					Inventorychange.clearAndTypeSlowly(Globals.Inventory.SubCategory, "input#txtSearch");
					Inventorychange.return_td_invoke_element(Globals.Inventory.SubCategory).click();
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Merchandise)) {
					terpage.terminal_waitClearEnterText_css(icp.Merchandise_String, Globals.Inventory.Merchandise);
					Inventorychange.clearAndTypeSlowly(Globals.Inventory.Merchandise, "input#txtSearch");
					Inventorychange.return_td_invoke_element(Globals.Inventory.Merchandise).click();
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Manufacture)) {
					terpage.terminal_waitClearEnterText_css(icp.Manufacture_String, Globals.Inventory.Manufacture);
					Inventorychange.clearAndTypeSlowly(Globals.Inventory.Manufacture, "input#txtSearch");
					Inventorychange.return_td_invoke_element(Globals.Inventory.Manufacture).click();
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Floorcode)) {
					terpage.terminal_waitClearEnterText_css(icp.Floorcode_String, Globals.Inventory.Floorcode);
					Inventorychange.clearAndTypeSlowly(Globals.Inventory.Floorcode, "input#txtSearch");
					Inventorychange.return_td_invoke_element(Globals.Inventory.Floorcode).click();
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Section)) {
					terpage.terminal_waitClearEnterText_css(icp.Section_String, Globals.Inventory.Section);
					Inventorychange.clearAndTypeSlowly(Globals.Inventory.Section, "input#txtSearch");
					Inventorychange.return_td_invoke_element(Globals.Inventory.Section).click();
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Bin)) {
					terpage.terminal_waitClearEnterText_css(icp.Bin_String, Globals.Inventory.Bin);
					Inventorychange.clearAndTypeSlowly(Globals.Inventory.Bin, "input#txtSearch");
					Inventorychange.return_td_invoke_element(Globals.Inventory.Bin).click();
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.ShelfCode)) {
					terpage.terminal_waitClearEnterText_css(icp.ShelfCode_String, Globals.Inventory.ShelfCode);
					Inventorychange.clearAndTypeSlowly(Globals.Inventory.ShelfCode, "input#txtSearch");
					Inventorychange.return_td_invoke_element(Globals.Inventory.ShelfCode).click();
				}

				
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Barcode)) {
					terpage.terminal_waitClearEnterText_css(icp.Barcode_String, Globals.Inventory.Barcode);
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_searchFilterUserControl_txtBarcode")).sendKeys(Keys.RETURN);
				}
				
				if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemCode)) {
					terpage.terminal_waitClearEnterText_css(icp.ItemCode_String, Globals.Inventory.ItemCode);
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_searchFilterUserControl_txtItemCode")).sendKeys(Keys.RETURN);
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemName)) {
					terpage.terminal_waitClearEnterText_css(icp.ItemName_String, Globals.Inventory.ItemName);
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_searchFilterUserControl_txtItemName")).sendKeys(Keys.RETURN);
					webDriver.findElement(By.cssSelector("a#ContentPlaceHolder1_lnkFetch")).click();
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Description)) {
					terpage.terminal_waitClearEnterText_css(icp.Description_String, Globals.Inventory.Description);
					webDriver.findElement(By.cssSelector("textarea#ContentPlaceHolder1_txtPromoDescription")).sendKeys(Keys.RETURN);
				} 
				
				if (GenericWrappers.isNotEmpty(Globals.Inventory.FromDate)) {
					terpage.terminal_waitClearEnterText_css(icp.FromDate_String, Globals.Inventory.FromDate);
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtFromDate")).sendKeys(Keys.RETURN);
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.ToDate)) {
					terpage.terminal_waitClearEnterText_css(icp.ToDate_String, Globals.Inventory.ToDate);
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtToDate")).sendKeys(Keys.RETURN);
				} 
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch)) {
					terpage.get_checkBox_element(icp.Batch_String).click();

				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.FromTime)) {
					terpage.terminal_waitClearEnterText_css(icp.FromTime_String, Globals.Inventory.FromTime);
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtFromtime")).sendKeys(Keys.RETURN);
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.ToTime)) {
					terpage.terminal_waitClearEnterText_css(icp.ToTime_String, Globals.Inventory.ToTime);
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtTotime")).sendKeys(Keys.RETURN);
				} 
				
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch1)) {
					terpage.get_checkBox_element(icp.Batch1_String).click();

				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Days)) {
					webDriver.findElement(By.cssSelector("div#ContentPlaceHolder1_lstDays_chzn")).click();

					GenericWrappers.sleepInSeconds(1);

					icp.search_dd_valuefordaybasedpromotion(Globals.Inventory.Days);
					
					
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Discount)) {
					terpage.terminal_waitClearEnterText_css(icp.Discount_String, Globals.Inventory.Discount);
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtDiscount")).sendKeys(Keys.RETURN);
					webDriver.findElement(By.cssSelector("a#ContentPlaceHolder1_lnkAdd")).click();
				} 
				
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch2)) {
					terpage.get_checkBox_element(icp.Batch2_String).click();

				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Status)) {
					webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_ddlFilter_chzn\"]")).click();
					GenericWrappers.sleepInSeconds(1);
					// terPage.terminal_waitClearEnterText_css(icp.Vendor_String,
					// Globals.Inventory.Vendor);
					WebElement itemCodeValue = webDriver.findElement(
							By.cssSelector("#ContentPlaceHolder1_ddlFilter_chzn > div > div > input[type=text]"));
					String css_location_dropDownValue = "#ContentPlaceHolder1_ddlFilter_chzn > div > div > input[type=text]";
					By ddlocator = By.cssSelector(css_location_dropDownValue);
					waitForExpectedElement(ddlocator);
					js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.Status);
					GenericWrappers.sleepInSeconds(1);
					itemCodeValue.sendKeys(Keys.SPACE);
					itemCodeValue.sendKeys(Keys.SPACE);
					itemCodeValue.sendKeys(Keys.ARROW_DOWN);
					GenericWrappers.sleepInSeconds(1);
					itemCodeValue.sendKeys(Keys.ENTER);
				} 
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Billno)) {
					terpage.terminal_waitClearEnterText_css(icp.Billno_String, Globals.Inventory.Billno);
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtSearch")).sendKeys(Keys.RETURN);
					webDriver.findElement(By.cssSelector("a#ContentPlaceHolder1_lnkSearchGrid")).click();
				} 
			
			pass.ExcelFourData("DayBasedPromotion","Modules", "Actual", "Expected", "Status",
					0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
			pass.Excelcreate("DayBasedPromotion", "Filters", "Pass", 1, 0, 1, 3);
			
			}
			catch(Exception e) {
				// screen shot
				scr.Screenshots();
				System.out.println("Screen shot taken");
				// Xl sheet write
				pass.ExcelFourData("DayBasedPromotion","Filters", "Actual", "Expected", "Status",
						0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
				pass.Excelcreate("DayBasedPromotion", "Filters", "FAIL", 1, 0, 1, 3);
				
			}
	        
		}

		@Then("I close connection  DB for DayBasedPromotion")
		public void I_close_connection_to_DB() throws SQLException {

			mysqlConnect.disconnect();
			System.out.println(" closed succesfully");

			// mysqlConnect.disconnect();

		}

		MssqlConnect mysqlConnect;
		Statement st;
		@Then("I establish connection  DB for DayBasedPromotion")
		public void I_establish_connection_to_DB() throws SQLException {

			mysqlConnect = new MssqlConnect();
			st = mysqlConnect.connect().createStatement();
			System.out.println(" Connected succesfully");

		}
		@Given("I read the values from DayBasedPromotion table {string} in DB")
		public void i_want_to_launch_the(String tablename ) throws SQLException, IOException {
			
			
			ResultSet rs = st.executeQuery("select * from "+tablename+" where InventoryCode='000001'");
			
			System.out.println(rs);
			//ResultSet rs = st.executeQuery("");

			while (rs.next()) {

				switch (tablename) {
				
				case "tblPromotionDayBased":
					
					String Sellingprice="";
					try {
						Sellingprice = rs.getString("PromotionDescription");
						System.out.println(Sellingprice);
						Assert.assertEquals(Globals.Inventory.Description.trim(), Sellingprice.trim());
						pass.Excelcreate("DayBasedPromotion", "tblPromotionDayBased", "", 3, 0, 3, 1);
						pass.ExcelFourData("DayBasedPromotion", "Description", Globals.Inventory.Description, Sellingprice, "Pass",
								5, 0, 5, 1, 5, 2, 5, 3);
					} catch (AssertionError e) {
						pass.Excelcreate("DayBasedPromotion", "tblPromotionHeader", "", 3, 0, 3, 1);
						pass.ExcelFourData("DayBasedPromotion", "Description", Globals.Inventory.Description, Sellingprice, "Fail",
								5, 0, 5, 1, 5, 2, 5, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblPromotionDayBased column DayBasedPromotion");
					}
					String MRP="";
					try
					{
						MRP = rs.getString("FromDate");
						System.out.println(MRP);
						Assert.assertEquals(Globals.Inventory.FromDate.trim(), MRP.trim());
						pass.ExcelFourData("DayBasedPromotion", "FromDate", Globals.Inventory.FromDate, MRP, "Pass",
								6, 0, 6, 1, 6, 2, 6, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("DayBasedPromotion", "FromDate", Globals.Inventory.FromDate, MRP, "Fail",
								6, 0, 6, 1, 6, 2, 6, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblPromotionDayBased column FromDate");
					}
					String Mode="";
					try
					{
						Mode = rs.getString("ToDate");
						System.out.println(Mode);
						Assert.assertEquals(Globals.Inventory.ToDate.trim(), Mode.trim());
						pass.ExcelFourData("DayBasedPromotion", "ToDate", Globals.Inventory.ToDate, Mode, "Pass",
								7, 0, 7, 1, 7, 2, 7, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("DayBasedPromotion", "ToDate", Globals.Inventory.ToDate, Mode, "Fail",
								7, 0, 7, 1, 7, 2, 7, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblPromotionDayBased column ToDate");
					}
					String FromDate="";
					try
					{
						FromDate = rs.getString("fromtime");
						System.out.println(FromDate);
						Assert.assertEquals(Globals.Inventory.FromTime.trim(), FromDate.trim());
						pass.ExcelFourData("DayBasedPromotion", "FromTime", Globals.Inventory.FromTime, FromDate, "Pass",
								8, 0, 8, 1, 8, 2, 8, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("DayBasedPromotion", "FromTime", Globals.Inventory.FromTime, FromDate, "Fail",
								8, 0, 8, 1, 8, 2, 8, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblPromotionDayBased column fromtime");
					}
					String ToDate="";
					try
					{
						ToDate = rs.getString("totime");
						System.out.println(ToDate);
						Assert.assertEquals(Globals.Inventory.ToTime.trim(), ToDate.trim());
						pass.ExcelFourData("DayBasedPromotion", "ToTime", Globals.Inventory.ToTime, ToDate, "Pass",
								9, 0, 9, 1, 9, 2, 9, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("DayBasedPromotion", "ToTime", Globals.Inventory.ToTime, ToDate, "Fail",
								9, 0, 9, 1, 9, 2, 9, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblPromotionDayBased column totime");
					}
					
					String Discountper="";
					try
					{
						Discountper = rs.getString("Discountper");
						System.out.println(Discountper);
						Assert.assertEquals(Globals.Inventory.Discount.trim(), Discountper.trim());
						pass.ExcelFourData("DayBasedPromotion", "Discount", Globals.Inventory.Discount, Discountper, "Pass",
								10, 0, 10, 1, 10, 2, 10, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("DayBasedPromotion", "Discount", Globals.Inventory.Discount, Discountper, "Fail",
								10, 0, 10, 1, 10, 2, 10, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblPromotionDayBased column Discount");
					}
					
					
					break;
				default:
					break;
				}
			
				}
			
		}


		
			



}






