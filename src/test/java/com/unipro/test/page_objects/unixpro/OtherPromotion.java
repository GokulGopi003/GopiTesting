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

	public class OtherPromotion  extends PageObject {
		AddInventoryFormPage Inventorychange;
		OtherPromotionField icp;
		CommonPages cp;
		TerminalPage terpage;
		ExcelWrite pass;
		Screenshot scr;

		public OtherPromotion(OtherPromotionField icp, CommonPages cp) {

			this.icp = icp;
			this.cp = cp;

			terpage = new TerminalPage();
			Inventorychange = new AddInventoryFormPage();
			pass = new ExcelWrite();
			scr = new Screenshot();

		}

		@Then("I load the OtherPromotion sheet data to map")
		public void I_load_the_Inventorychange_sheet_data_to_map() {
			Globals.Inventory.OtherPromotionSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME56);

		}

		@Then("I load the rowise OtherPromotion data for {string} rowname")
		public void i_load_the_rowise_Inventorychange_data_for_rowname(String row_name) {
			Globals.Inventory.OtherPromotionrowwiseData = ReadTestData
					.getRowFilteredValueFromTable(Globals.Inventory.OtherPromotionSheetData, row_name);
			System.out.println(Globals.Inventory.OtherPromotionrowwiseData);
		}

		@Then("I update value to the OtherPromotion page global Variables")
		public void i_update_value_to_the_ConsolidatedPO_page_global_Variables() {
			Globals.Inventory.FromDate = Globals.Inventory.OtherPromotionrowwiseData.get("FromDate");
			Globals.Inventory.ToDate = Globals.Inventory.OtherPromotionrowwiseData.get("ToDate");
			Globals.Inventory.Description = Globals.Inventory.OtherPromotionrowwiseData.get("Description");
			Globals.Inventory.Batch = Globals.Inventory.OtherPromotionrowwiseData.get("Batch");
			Globals.Inventory.Department = Globals.Inventory.OtherPromotionrowwiseData.get("Department");
			Globals.Inventory.Category = Globals.Inventory.OtherPromotionrowwiseData.get("Category");
			Globals.Inventory.Brand = Globals.Inventory.OtherPromotionrowwiseData.get("Brand");
			Globals.Inventory.SubCategory = Globals.Inventory.OtherPromotionrowwiseData.get("SubCategory");
			Globals.Inventory.Class = Globals.Inventory.OtherPromotionrowwiseData.get("Class");
			Globals.Inventory.SubClass = Globals.Inventory.OtherPromotionrowwiseData.get("SubClass");
			Globals.Inventory.Basis = Globals.Inventory.OtherPromotionrowwiseData.get("Basis");
			Globals.Inventory.Type = Globals.Inventory.OtherPromotionrowwiseData.get("Type");
			Globals.Inventory.Mode = Globals.Inventory.OtherPromotionrowwiseData.get("Mode");
			Globals.Inventory.RangeFrom = Globals.Inventory.OtherPromotionrowwiseData.get("RangeFrom");
			Globals.Inventory.RangeTo = Globals.Inventory.OtherPromotionrowwiseData.get("RangeTo");
			Globals.Inventory.Discount = Globals.Inventory.OtherPromotionrowwiseData.get("Discount");
			Globals.Inventory.Qty= Globals.Inventory.OtherPromotionrowwiseData.get("Qty");
			Globals.Inventory.DiscountPer = Globals.Inventory.OtherPromotionrowwiseData.get("DiscountPer");
			Globals.Inventory.Batch1 = Globals.Inventory.OtherPromotionrowwiseData.get("Batch1");
			Globals.Inventory.ItemCode = Globals.Inventory.OtherPromotionrowwiseData.get("ItemCode");			
			Globals.Inventory.Batchno = Globals.Inventory.OtherPromotionrowwiseData.get("Batchno");
			Globals.Inventory.Qty1 = Globals.Inventory.OtherPromotionrowwiseData.get("Qty1");
			Globals.Inventory.EligibilityQty = Globals.Inventory.OtherPromotionrowwiseData.get("EligibilityQty");
			Globals.Inventory.Status = Globals.Inventory.OtherPromotionrowwiseData.get("Status");
		
												
		}

		@Then("I fill new OtherPromotion data page using excel data")
		public void i_fill_new_Inventorychange_data_page_using_excel_data() throws Exception {
			try {
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Description)) {
					terpage.terminal_waitClearEnterText_css(icp.Description_String, Globals.Inventory.Description);
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtPromoDescription")).sendKeys(Keys.RETURN);
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
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Class)) {
					terpage.terminal_waitClearEnterText_css(icp.Class_String, Globals.Inventory.Class);
					Inventorychange.clearAndTypeSlowly(Globals.Inventory.Class, "input#txtSearch");
					Inventorychange.return_td_invoke_element(Globals.Inventory.Class).click();
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.SubClass)) {
					terpage.terminal_waitClearEnterText_css(icp.SubClass_String, Globals.Inventory.SubClass);
					Inventorychange.clearAndTypeSlowly(Globals.Inventory.SubClass, "input#txtSearch");
					Inventorychange.return_td_invoke_element(Globals.Inventory.SubClass).click();
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Basis)) {
					webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_ddlBasis_chzn\"]")).click();
					GenericWrappers.sleepInSeconds(1);
					// terPage.terminal_waitClearEnterText_css(icp.Vendor_String,
					// Globals.Inventory.Vendor);
					WebElement itemCodeValue = webDriver.findElement(
							By.cssSelector("#ContentPlaceHolder1_ddlBasis_chzn > div > div > input[type=text]"));
					String css_location_dropDownValue = "#ContentPlaceHolder1_ddlBasis_chzn > div > div > input[type=text]";
					By ddlocator = By.cssSelector(css_location_dropDownValue);
					waitForExpectedElement(ddlocator);
					js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.Basis);
					GenericWrappers.sleepInSeconds(1);
					itemCodeValue.sendKeys(Keys.SPACE);
					itemCodeValue.sendKeys(Keys.SPACE);
					itemCodeValue.sendKeys(Keys.ARROW_DOWN);
					GenericWrappers.sleepInSeconds(1);
					itemCodeValue.sendKeys(Keys.ENTER);

				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Type)) {
					webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_ddlType_chzn\"]")).click();
					GenericWrappers.sleepInSeconds(1);
					// terPage.terminal_waitClearEnterText_css(icp.Vendor_String,
					// Globals.Inventory.Vendor);
					WebElement itemCodeValue = webDriver.findElement(
							By.cssSelector("#ContentPlaceHolder1_ddlType_chzn > div > div > input[type=text]"));
					String css_location_dropDownValue = "#ContentPlaceHolder1_ddlType_chzn > div > div > input[type=text]";
					By ddlocator = By.cssSelector(css_location_dropDownValue);
					waitForExpectedElement(ddlocator);
					js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.Type);
					GenericWrappers.sleepInSeconds(1);
					itemCodeValue.sendKeys(Keys.SPACE);
					itemCodeValue.sendKeys(Keys.SPACE);
					itemCodeValue.sendKeys(Keys.ARROW_DOWN);
					GenericWrappers.sleepInSeconds(1);
					itemCodeValue.sendKeys(Keys.ENTER);
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Mode)) {
					webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_ddlMode_chzn\"]")).click();
					GenericWrappers.sleepInSeconds(1);
					// terPage.terminal_waitClearEnterText_css(icp.Vendor_String,
					// Globals.Inventory.Vendor);
					WebElement itemCodeValue = webDriver.findElement(
							By.cssSelector("#ContentPlaceHolder1_ddlMode_chzn > div > div > input[type=text]"));
					String css_location_dropDownValue = "#ContentPlaceHolder1_ddlMode_chzn > div > div > input[type=text]";
					By ddlocator = By.cssSelector(css_location_dropDownValue);
					waitForExpectedElement(ddlocator);
					js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.Mode);
					GenericWrappers.sleepInSeconds(1);
					itemCodeValue.sendKeys(Keys.SPACE);
					itemCodeValue.sendKeys(Keys.SPACE);
					itemCodeValue.sendKeys(Keys.ARROW_DOWN);
					GenericWrappers.sleepInSeconds(1);
					itemCodeValue.sendKeys(Keys.ENTER);
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.RangeFrom))  {
					webDriver
					.findElement(By.cssSelector("input#ContentPlaceHolder1_txtRangeFrom"))
					.sendKeys(Keys.RIGHT);
					webDriver
							.findElement(By.cssSelector("input#ContentPlaceHolder1_txtRangeFrom"))
							.sendKeys(Keys.SHIFT, Keys.LEFT);
					webDriver
							.findElement(By.cssSelector("input#ContentPlaceHolder1_txtRangeFrom"))
							.sendKeys(Keys.SHIFT, Keys.LEFT);
					webDriver
							.findElement(By.cssSelector("input#ContentPlaceHolder1_txtRangeFrom"))
							.sendKeys(Keys.SHIFT, Keys.LEFT);
					webDriver
							.findElement(By.cssSelector("input#ContentPlaceHolder1_txtRangeFrom"))
							.sendKeys(Keys.SHIFT, Keys.LEFT);
					GenericWrappers.sleepInSeconds(1);
					webDriver
							.findElement(By.cssSelector("input#ContentPlaceHolder1_txtRangeFrom"))
							.sendKeys(Keys.DELETE);
					terpage.terminal_waitClearEnterText_css(icp.RangeFrom_String, Globals.Inventory.RangeFrom);
					//webDriver
						//	.findElement(By.cssSelector("input#ContentPlaceHolder1_txtRangeFrom"))
							//.sendKeys(Keys.RETURN);
				}
				
				if (GenericWrappers.isNotEmpty(Globals.Inventory.RangeTo)) {
					webDriver
					.findElement(By.cssSelector("input#ContentPlaceHolder1_txtRangeTo"))
					.sendKeys(Keys.SHIFT, Keys.LEFT);
			webDriver
					.findElement(By.cssSelector("input#ContentPlaceHolder1_txtRangeTo"))
					.sendKeys(Keys.SHIFT, Keys.LEFT);
			webDriver
					.findElement(By.cssSelector("input#ContentPlaceHolder1_txtRangeTo"))
					.sendKeys(Keys.SHIFT, Keys.LEFT);
			webDriver
					.findElement(By.cssSelector("input#ContentPlaceHolder1_txtRangeTo"))
					.sendKeys(Keys.SHIFT, Keys.LEFT);
			GenericWrappers.sleepInSeconds(1);
			webDriver
					.findElement(By.cssSelector("input#ContentPlaceHolder1_txtRangeTo"))
					.sendKeys(Keys.DELETE);
					terpage.terminal_waitClearEnterText_css(icp.RangeTo_String, Globals.Inventory.RangeTo);
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtRangeTo")).sendKeys(Keys.RETURN);
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Discount)) {
					webDriver
					.findElement(By.cssSelector("input#ContentPlaceHolder1_txtDiscountAdd"))
					.sendKeys(Keys.SHIFT, Keys.LEFT);
			webDriver
					.findElement(By.cssSelector("input#ContentPlaceHolder1_txtDiscountAdd"))
					.sendKeys(Keys.SHIFT, Keys.LEFT);
			webDriver
					.findElement(By.cssSelector("input#ContentPlaceHolder1_txtDiscountAdd"))
					.sendKeys(Keys.SHIFT, Keys.LEFT);
			webDriver
					.findElement(By.cssSelector("input#ContentPlaceHolder1_txtDiscountAdd"))
					.sendKeys(Keys.SHIFT, Keys.LEFT);
			GenericWrappers.sleepInSeconds(1);
			webDriver
					.findElement(By.cssSelector("input#ContentPlaceHolder1_txtDiscountAdd"))
					.sendKeys(Keys.DELETE);
					terpage.terminal_waitClearEnterText_css(icp.Discount_String, Globals.Inventory.Discount);
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtDiscountAdd")).sendKeys(Keys.RETURN);
					webDriver.findElement(By.cssSelector("a#ContentPlaceHolder1_lnkRangeAdd")).click();
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Qty)) {
					webDriver
					.findElement(By.cssSelector("input#ContentPlaceHolder1_txtBillValue"))
					.sendKeys(Keys.SHIFT, Keys.LEFT);
			webDriver
					.findElement(By.cssSelector("input#ContentPlaceHolder1_txtBillValue"))
					.sendKeys(Keys.SHIFT, Keys.LEFT);
			webDriver
					.findElement(By.cssSelector("input#ContentPlaceHolder1_txtBillValue"))
					.sendKeys(Keys.SHIFT, Keys.LEFT);
			webDriver
					.findElement(By.cssSelector("input#ContentPlaceHolder1_txtBillValue"))
					.sendKeys(Keys.SHIFT, Keys.LEFT);
			GenericWrappers.sleepInSeconds(1);
			webDriver
					.findElement(By.cssSelector("input#ContentPlaceHolder1_txtBillValue"))
					.sendKeys(Keys.DELETE);
					terpage.terminal_waitClearEnterText_css(icp.Qty_String, Globals.Inventory.Qty);
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtBillValue")).sendKeys(Keys.RETURN);
					
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.DiscountPer)) {
					webDriver
					.findElement(By.cssSelector("input#ContentPlaceHolder1_txtDiscount"))
					.sendKeys(Keys.SHIFT, Keys.LEFT);
			webDriver
					.findElement(By.cssSelector("input#ContentPlaceHolder1_txtDiscount"))
					.sendKeys(Keys.SHIFT, Keys.LEFT);
			webDriver
					.findElement(By.cssSelector("input#ContentPlaceHolder1_txtDiscount"))
					.sendKeys(Keys.SHIFT, Keys.LEFT);
			webDriver
					.findElement(By.cssSelector("input#ContentPlaceHolder1_txtDiscount"))
					.sendKeys(Keys.SHIFT, Keys.LEFT);
			GenericWrappers.sleepInSeconds(1);
			webDriver
					.findElement(By.cssSelector("input#ContentPlaceHolder1_txtDiscount"))
					.sendKeys(Keys.DELETE);
					terpage.terminal_waitClearEnterText_css(icp.DiscountPer_String, Globals.Inventory.DiscountPer);
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtDiscount")).sendKeys(Keys.RETURN);
					
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch1)) {
					terpage.get_checkBox_element(icp.Batch1_String).click();

				}
				
			
				if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemCode)) {
					terpage.terminal_waitClearEnterText_css(icp.ItemCode_String, Globals.Inventory.ItemCode);
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtItemcode")).sendKeys(Keys.RETURN);
					
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Batchno)) {
					GenericWrappers.sleepInSeconds(1);
					webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_ddlBactno_chzn\"]")).click();
					GenericWrappers.sleepInSeconds(1);
					// terPage.terminal_waitClearEnterText_css(icp.Vendor_String,
					// Globals.Inventory.Vendor);
					WebElement itemCodeValue = webDriver.findElement(
							By.cssSelector("#ContentPlaceHolder1_ddlBactno_chzn > div > div > input[type=text]"));
					String css_location_dropDownValue = "#ContentPlaceHolder1_ddlBactno_chzn > div > div > input[type=text]";
					By ddlocator = By.cssSelector(css_location_dropDownValue);
					waitForExpectedElement(ddlocator);
					js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.Batchno);
					GenericWrappers.sleepInSeconds(1);
					itemCodeValue.sendKeys(Keys.SPACE);
					itemCodeValue.sendKeys(Keys.SPACE);
					itemCodeValue.sendKeys(Keys.ARROW_DOWN);
					GenericWrappers.sleepInSeconds(1);
					itemCodeValue.sendKeys(Keys.ENTER);
				}
			
				
				
				if (GenericWrappers.isNotEmpty(Globals.Inventory.EligibilityQty)) {
					terpage.terminal_waitClearEnterText_css(icp.EligibilityQty_String, Globals.Inventory.EligibilityQty);
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtQty")).sendKeys(Keys.RETURN);
					webDriver.findElement(By.cssSelector("a#ContentPlaceHolder1_lnkAdd")).click();
				}
				
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Status)) {
					webDriver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_ddlMode_chzn\"]")).click();
					GenericWrappers.sleepInSeconds(1);
					// terPage.terminal_waitClearEnterText_css(icp.Vendor_String,
					// Globals.Inventory.Vendor);
					WebElement itemCodeValue = webDriver.findElement(
							By.cssSelector("#ContentPlaceHolder1_ddlMode_chzn > div > div > input[type=text]"));
					String css_location_dropDownValue = "#ContentPlaceHolder1_ddlMode_chzn > div > div > input[type=text]";
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
			pass.ExcelFourData("OtherPromotion","Modules", "Actual", "Expected", "Status",
					0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
			pass.Excelcreate("OtherPromotion", "Filters", "Pass", 1, 0, 1, 3);
			
			}
			catch(Exception e) {
				// screen shot
				scr.Screenshots();
				System.out.println("Screen shot taken");
				// Xl sheet write
				pass.ExcelFourData("OtherPromotion","Filters", "Actual", "Expected", "Status",
						0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
				pass.Excelcreate("OtherPromotion", "Filters", "FAIL", 1, 0, 1, 3);
				
			}
	        
		}

		@Then("I close connection  DB for OtherPromotion")
		public void I_close_connection_to_DB() throws SQLException {

			mysqlConnect.disconnect();
			System.out.println(" closed succesfully");

			// mysqlConnect.disconnect();

		}

		MssqlConnect mysqlConnect;
		Statement st;
		@Then("I establish connection  DB for OtherPromotion")
		public void I_establish_connection_to_DB() throws SQLException {

			mysqlConnect = new MssqlConnect();
			st = mysqlConnect.connect().createStatement();
			System.out.println(" Connected succesfully");

		}
		@Given("I read the values from OtherPromotion table {string} in DB")
		public void i_want_to_launch_the(String tablename ) throws SQLException, IOException {
			
			
			ResultSet rs = st.executeQuery("select * from "+tablename+" order by createddate desc");
			
			System.out.println(rs);
			//ResultSet rs = st.executeQuery("");

			while (rs.next()) {

				switch (tablename) {
				
				case "tblPromotionHeader":
						
					String Sellingprice="";
					try {
						Sellingprice = rs.getString("PromotionDescription");
						System.out.println(Sellingprice);
						Assert.assertEquals(Globals.Inventory.Description.trim(), Sellingprice.trim());
						pass.Excelcreate("OtherPromotion", "tblPromotionHeader", "", 3, 0, 3, 1);
						pass.ExcelFourData("OtherPromotion", "Description", Globals.Inventory.Description, Sellingprice, "Pass",
								5, 0, 5, 1, 5, 2, 5, 3);
					} catch (AssertionError e) {
						pass.Excelcreate("OtherPromotion", "tblPromotionHeader", "", 3, 0, 3, 1);
						pass.ExcelFourData("OtherPromotion", "Description", Globals.Inventory.Description, Sellingprice, "Fail",
								5, 0, 5, 1, 5, 2, 5, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblPromotionHeader column PromotionDescription");
					}
					String MRP="";
					try
					{
						MRP = rs.getString("FromDate");
						System.out.println(MRP);
						Assert.assertEquals(Globals.Inventory.FromDate.trim(), MRP.trim());
						pass.ExcelFourData("OtherPromotion", "FromDate", Globals.Inventory.FromDate, MRP, "Pass",
								6, 0, 6, 1, 6, 2, 6, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("OtherPromotion", "FromDate", Globals.Inventory.FromDate, MRP, "Fail",
								6, 0, 6, 1, 6, 2, 6, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblPromotionHeader column FromDate");
					}
					String Mode="";
					try
					{
						Mode = rs.getString("ToDate");
						System.out.println(Mode);
						Assert.assertEquals(Globals.Inventory.ToDate.trim(), Mode.trim());
						pass.ExcelFourData("OtherPromotion", "ToDate", Globals.Inventory.ToDate, Mode, "Pass",
								7, 0, 7, 1, 7, 2, 7, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("OtherPromotion", "ToDate", Globals.Inventory.ToDate, Mode, "Fail",
								7, 0, 7, 1, 7, 2, 7, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblPromotionHeader column ToDate");
					}
					String Qty="";
					try
					{
						Qty = rs.getString("Department");
						System.out.println(Qty);
						Assert.assertEquals(Globals.Inventory.Department.trim(), Qty.trim());
						pass.ExcelFourData("OtherPromotion", "Department", Globals.Inventory.Department, Qty, "Pass",
								8, 0, 8, 1, 8, 2, 8, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("OtherPromotion", "Department", Globals.Inventory.Department, Qty, "Fail",
								8, 0, 8, 1, 8, 2, 8, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblPromotionHeader column Department");
					}
					String Qty1="";
					try
					{
						Qty1 = rs.getString("Category");
						System.out.println(Qty1);
						Assert.assertEquals(Globals.Inventory.Category.trim(), Qty1.trim());
						pass.ExcelFourData("OtherPromotion", "Category", Globals.Inventory.Category, Qty1, "Pass",
								9, 0, 9, 1, 9, 2, 9, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("OtherPromotion", "Category", Globals.Inventory.Category, Qty1, "Fail",
								9, 0, 9, 1, 9, 2, 9, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblPromotionHeader column Category");
					}
					String FromDate="";
					try
					{
						FromDate = rs.getString("Brand");
						System.out.println(Qty1);
						Assert.assertEquals(Globals.Inventory.Brand.trim(), FromDate.trim());
						pass.ExcelFourData("OtherPromotion", "Brand", Globals.Inventory.Brand, FromDate, "Pass",
								10, 0, 10, 1, 10, 2, 10, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("OtherPromotion", "Brand", Globals.Inventory.Brand, FromDate, "Fail",
								10, 0, 10, 1, 10, 2, 10, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblPromotionHeader column Brand");
					}
					String ToDate="";
					try
					{
						ToDate = rs.getString("SubCategory");
						System.out.println(ToDate);
						Assert.assertEquals(Globals.Inventory.SubCategory.trim(), ToDate.trim());
						pass.ExcelFourData("OtherPromotion", "SubCategory", Globals.Inventory.SubCategory, ToDate, "Pass",
								6, 0, 6, 1, 6, 2, 6, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("OtherPromotion", "SubCategory", Globals.Inventory.SubCategory, ToDate, "Fail",
								6, 0, 6, 1, 6, 2, 6, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblPromotionHeader column SubCategory");
					}
					String Class="";
					try
					{
						Class = rs.getString("Class");
						System.out.println(Class);
						Assert.assertEquals(Globals.Inventory.Class.trim(), Class.trim());
						pass.ExcelFourData("OtherPromotion", "Class", Globals.Inventory.Class, Class, "Pass",
								7, 0, 7, 1, 7, 2, 7, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("OtherPromotion", "Class", Globals.Inventory.Class, Class, "Fail",
								7, 0, 7, 1, 7, 2, 7, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblPromotionHeader column Class");
					}
					String SubClass="";
					try
					{
						SubClass = rs.getString("Class");
						System.out.println(SubClass);
						Assert.assertEquals(Globals.Inventory.SubClass.trim(), SubClass.trim());
						pass.ExcelFourData("OtherPromotion", "SubClass", Globals.Inventory.SubClass, SubClass, "Pass",
								8, 0, 8, 1, 8, 2, 8, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("OtherPromotion", "SubClass", Globals.Inventory.SubClass, SubClass, "Fail",
								8, 0, 8, 1, 8, 2, 8, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblPromotionHeader column SubClass");
					}
					String Basis="";
					try
					{
						Basis = rs.getString("PromotionBasis");
						System.out.println(Basis);
						Assert.assertEquals(Globals.Inventory.Basis.trim(), Basis.trim());
						pass.ExcelFourData("OtherPromotion", "Basis", Globals.Inventory.Basis, Basis, "Pass",
								9, 0, 9, 1, 9, 2, 9, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("OtherPromotion", "Basis", Globals.Inventory.Basis, Basis, "Fail",
								9, 0, 9, 1, 9, 2, 9, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblPromotionHeader column Basis");
					}
					String PromotionType="";
					try
					{
						PromotionType = rs.getString("PromotionType");
						System.out.println(PromotionType);
						Assert.assertEquals(Globals.Inventory.Type.trim(), PromotionType.trim());
						pass.ExcelFourData("OtherPromotion", "Type", Globals.Inventory.Type, PromotionType, "Pass",
								10, 0, 10, 1, 10, 2, 10, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("OtherPromotion", "Type", Globals.Inventory.Type, PromotionType, "Fail",
								10, 0, 10, 1, 10, 2, 10, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblPromotionHeader column Type");
					}
					String Mode1="";
					try
					{
						Mode1 = rs.getString("PromotionType");
						System.out.println(Mode1);
						Assert.assertEquals(Globals.Inventory.Mode.trim(), Mode1.trim());
						pass.ExcelFourData("OtherPromotion", "Mode", Globals.Inventory.Mode, Mode1, "Pass",
								11, 0, 11, 1, 11, 2, 11, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("OtherPromotion", "Mode", Globals.Inventory.Mode, Mode1, "Fail",
								11, 0, 11, 1, 11, 2, 11, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblPromotionHeader column Mode");
					}
					
					break;
					
				case "tblPromotionDetail":
					String Promotionfromdate="";
					try
					{
						Promotionfromdate = rs.getString("RangeFrom");
						System.out.println(Promotionfromdate);
						Assert.assertEquals(Globals.Inventory.RangeFrom.trim(), Promotionfromdate.trim());
						pass.Excelcreate("OtherPromotion", "tblPromotionDetail", "", 12, 0, 12, 1);
						pass.ExcelFourData("OtherPromotion", "RangeFrom", Globals.Inventory.RangeFrom, Promotionfromdate, "Pass",
								13, 0, 13, 1, 13, 2, 13, 3);
					} catch (AssertionError e) {
						pass.Excelcreate("OtherPromotion", "tblPromotionDetail", "", 12, 0, 12, 1);
						pass.ExcelFourData("OtherPromotion", "RangeFrom", Globals.Inventory.RangeFrom, Promotionfromdate, "Fail",
								13, 0, 13, 1, 13, 2, 13, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblPromotionDetail column RangeFrom");
					}
					String Promotiontodate="";
					try
					{
						Promotiontodate = rs.getString("RangeTo");
						System.out.println(Promotiontodate);
						Assert.assertEquals(Globals.Inventory.RangeTo.trim(), Promotiontodate.trim());
						pass.ExcelFourData("OtherPromotion", "RangeTo", Globals.Inventory.RangeTo, Promotiontodate, "Pass",
								14, 0, 14, 1, 14, 2, 14, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("OtherPromotion", "RangeTo", Globals.Inventory.RangeTo, Promotiontodate, "Fail",
								14, 0, 14, 1, 14, 2, 14, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblPromotionDetail column Promotiontodate");
					}
					String Promotionfromtime="";
					try
					{
						Promotionfromtime = rs.getString("Discount");
						System.out.println(Promotionfromtime);
						Assert.assertEquals(Globals.Inventory.Discount.trim(), Promotionfromtime.trim());
						pass.ExcelFourData("OtherPromotion", "Discount", Globals.Inventory.Discount, Promotionfromtime, "Pass",
								15, 0, 15, 1, 15, 2,15, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("OtherPromotion", "Discount", Globals.Inventory.Discount, Promotionfromtime, "Fail",
								15, 0, 15, 1, 15, 2,15, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblPromotionDetail column Discount");
					}
					
					break;
				case "tblFreeItemDetail":
					String BatchNo="";
					try {
						BatchNo = rs.getString("ItemCode");
						System.out.println(BatchNo);
						Assert.assertEquals(Globals.Inventory.ItemCode.trim(), BatchNo.trim());
						pass.Excelcreate("OtherPromotion", "tblFreeItemDetail", "", 19, 0, 19, 1);
						pass.ExcelFourData("OtherPromotion", "ItemCode", Globals.Inventory.ItemCode, BatchNo, "Pass",
								20, 0, 20, 1, 20, 2, 20, 3);
					} catch (AssertionError e) {
						pass.Excelcreate("OtherPromotion", "tblFreeItemDetail", "", 19, 0, 19, 1);
						pass.ExcelFourData("OtherPromotion", "ItemCode", Globals.Inventory.ItemCode, BatchNo, "Fail",
								20, 0, 20, 1, 20, 2, 20, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblFreeItemDetail column ItemCode");
					}
					String EligibilityQty1="";
					try
					{
						EligibilityQty1 = rs.getString("EligibleQty");
						System.out.println(EligibilityQty1);
						Assert.assertEquals(Globals.Inventory.EligibilityQty.trim(), EligibilityQty1.trim());
						pass.ExcelFourData("OtherPromotion", "EligibilityQty", Globals.Inventory.EligibilityQty, EligibilityQty1, "Pass",
								21, 0, 21, 1, 21, 2, 21, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("OtherPromotion", "EligibilityQty", Globals.Inventory.EligibilityQty, EligibilityQty1, "Fail",
								21, 0, 21, 1, 21, 2, 21, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblPromotionPriceChange column EligibilityQty");
					}
					String DiscountPerc="";
					try
					{
						DiscountPerc = rs.getString("FreeBatchno");
						System.out.println(DiscountPerc);
						Assert.assertEquals(Globals.Inventory.Batchno.trim(), DiscountPerc.trim());
						pass.ExcelFourData("OtherPromotion", "Batchno", Globals.Inventory.Batchno, DiscountPerc, "Pass",
								22, 0, 22, 1, 22, 2, 22, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("OtherPromotion", "Batchno", Globals.Inventory.Batchno, DiscountPerc, "Fail",
								22, 0, 22, 1, 22, 2, 22, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblPromotionPriceChange column Batchno");
					}
					
				default:
					break;
				}
			
				}
			
		}
			



}




