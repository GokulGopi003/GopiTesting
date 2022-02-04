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

	public class NormalPromotion  extends PageObject {
		AddInventoryFormPage Inventorychange;
		NormalPromotionField icp;
		CommonPages cp;
		TerminalPage terpage;
		ExcelWrite pass;
		Screenshot scr;

		public NormalPromotion(NormalPromotionField icp, CommonPages cp) {

			this.icp = icp;
			this.cp = cp;

			terpage = new TerminalPage();
			Inventorychange = new AddInventoryFormPage();
			pass = new ExcelWrite();
			scr = new Screenshot();

		}

		@Then("I load the NormalPromotion sheet data to map")
		public void I_load_the_Inventorychange_sheet_data_to_map() {
			Globals.Inventory.NormalPromotionSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME55);

		}

		@Then("I load the rowise NormalPromotion data for {string} rowname")
		public void i_load_the_rowise_Inventorychange_data_for_rowname(String row_name) {
			Globals.Inventory.NormalPromotionrowwiseData = ReadTestData
					.getRowFilteredValueFromTable(Globals.Inventory.NormalPromotionSheetData, row_name);
			System.out.println(Globals.Inventory.NormalPromotionrowwiseData);
		}

		@Then("I update value to the NormalPromotion page global Variables")
		public void i_update_value_to_the_ConsolidatedPO_page_global_Variables() {
			Globals.Inventory.FromDate = Globals.Inventory.NormalPromotionrowwiseData.get("FromDate");
			Globals.Inventory.NewToDate = Globals.Inventory.NormalPromotionrowwiseData.get("NewToDate");
			Globals.Inventory.Vendor = Globals.Inventory.NormalPromotionrowwiseData.get("Vendor");
			Globals.Inventory.Department = Globals.Inventory.NormalPromotionrowwiseData.get("Department");
			Globals.Inventory.Category = Globals.Inventory.NormalPromotionrowwiseData.get("Category");
			Globals.Inventory.Brand = Globals.Inventory.NormalPromotionrowwiseData.get("Brand");
			Globals.Inventory.Vendor = Globals.Inventory.NormalPromotionrowwiseData.get("Vendor");
			Globals.Inventory.Date = Globals.Inventory.NormalPromotionrowwiseData.get("Date");
			Globals.Inventory.ToDate = Globals.Inventory.NormalPromotionrowwiseData.get("ToDate");
			Globals.Inventory.ItemCode = Globals.Inventory.NormalPromotionrowwiseData.get("ItemCode");
			Globals.Inventory.ItemCode1 = Globals.Inventory.NormalPromotionrowwiseData.get("ItemCode1");
			Globals.Inventory.Batchno = Globals.Inventory.NormalPromotionrowwiseData.get("Batchno");
			Globals.Inventory.Batchno1 = Globals.Inventory.NormalPromotionrowwiseData.get("Batchno1");
			Globals.Inventory.Batch = Globals.Inventory.NormalPromotionrowwiseData.get("Batch");
			Globals.Inventory.Batch1 = Globals.Inventory.NormalPromotionrowwiseData.get("Batch1");
			Globals.Inventory.Batch2 = Globals.Inventory.NormalPromotionrowwiseData.get("Batch2");
			Globals.Inventory.Batch3 = Globals.Inventory.NormalPromotionrowwiseData.get("Batch3");
			Globals.Inventory.Batch4 = Globals.Inventory.NormalPromotionrowwiseData.get("Batch4");
			Globals.Inventory.EligibilityQty = Globals.Inventory.NormalPromotionrowwiseData.get("EligibilityQty");
			Globals.Inventory.DiscountPer = Globals.Inventory.NormalPromotionrowwiseData.get("DiscountPer");
			Globals.Inventory.Discount = Globals.Inventory.NormalPromotionrowwiseData.get("Discount");
			Globals.Inventory.FromTime = Globals.Inventory.NormalPromotionrowwiseData.get("FromTime");
			Globals.Inventory.ToTime = Globals.Inventory.NormalPromotionrowwiseData.get("ToTime");
			Globals.Inventory.Price = Globals.Inventory.NormalPromotionrowwiseData.get("Price");
			Globals.Inventory.DiscountPer1 = Globals.Inventory.NormalPromotionrowwiseData.get("DiscountPer1");
			Globals.Inventory.Qty = Globals.Inventory.NormalPromotionrowwiseData.get("Qty");
			Globals.Inventory.Qty1 = Globals.Inventory.NormalPromotionrowwiseData.get("Qty1");
												
		}

		@Then("I fill new NormalPromotion data page using excel data")
		public void i_fill_new_Inventorychange_data_page_using_excel_data() throws Exception {
			try {
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch2)) {
					terpage.get_checkBox_element(icp.Batch2_String).click();

				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.FromDate)) {
					terpage.terminal_waitClearEnterText_css(icp.FromDate_String, Globals.Inventory.FromDate);
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtFrom")).sendKeys(Keys.RETURN);
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.NewToDate)) {
					terpage.terminal_waitClearEnterText_css(icp.NewToDate_String, Globals.Inventory.NewToDate);
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtToDate")).sendKeys(Keys.RETURN);
				} 
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
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtSubcategory")).sendKeys(Keys.RETURN);
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemCode1)) {
					terpage.terminal_waitClearEnterText_css(icp.ItemCode1_String, Globals.Inventory.ItemCode1);
					Inventorychange.clearAndTypeSlowly(Globals.Inventory.ItemCode1, "input#txtSearch");
					Inventorychange.return_td_invoke_element(Globals.Inventory.ItemCode1).click();
					webDriver.findElement(By.cssSelector("a#ContentPlaceHolder1_lnkFetch")).click();
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Price)) {
					terpage.terminal_waitClearEnterText_css(icp.Price_String, Globals.Inventory.Price);
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtItemCode")).sendKeys(Keys.RETURN);
					
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.DiscountPer1)) {
					terpage.terminal_waitClearEnterText_css(icp.DiscountPer1_String, Globals.Inventory.DiscountPer1);
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtpromotionprice")).sendKeys(Keys.RETURN);
					
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Qty)) {
					terpage.terminal_waitClearEnterText_css(icp.Qty_String, Globals.Inventory.Qty);
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtBProQty")).sendKeys(Keys.RETURN);
					
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Qty1)) {
					terpage.terminal_waitClearEnterText_css(icp.Qty1_String, Globals.Inventory.Qty);
					//webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtItemCode")).sendKeys(Keys.RETURN);
					
					
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch3)) {
					terpage.get_checkBox_element(icp.Batch3_String).click();

				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch4)) {
					terpage.get_checkBox_element(icp.Batch4_String).click();
					List<WebElement> weList = getWebDriver().findElements(By.tagName("button"));
					for (Iterator iterator = weList.iterator(); iterator.hasNext();) {
						WebElement button = (WebElement) iterator.next();
						if (button.getText().equalsIgnoreCase("Yes")) {
							button.click();
						}}
					webDriver.findElement(By.cssSelector("a#ContentPlaceHolder1_lnkapply")).click();
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemCode)) {
					terpage.terminal_waitClearEnterText_css(icp.ItemCode_String, Globals.Inventory.ItemCode);
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txteligibleqtyfilteration")).sendKeys(Keys.RETURN);
					
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Batchno)) {
					try {
						GenericWrappers.sleepInSeconds(1);
						webDriver.findElement(By.xpath(
								"//*[@id=\"dataGridBatchTable_master_row" + Globals.Inventory.Batchno + "\"]"))
								.click();

					} catch (Exception e) {
						System.out.println("Element  not found");
					}

				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Date)) {
					terpage.terminal_waitClearEnterText_css(icp.Date_String, Globals.Inventory.Date);
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtFrom")).sendKeys(Keys.RETURN);
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.ToDate)) {
					terpage.terminal_waitClearEnterText_css(icp.ToDate_String, Globals.Inventory.ToDate);
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtToDate")).sendKeys(Keys.RETURN);
				}                                              
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Discount)) {
					terpage.terminal_waitClearEnterText_css(icp.Discount_String, Globals.Inventory.Discount);
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtPPrice")).sendKeys(Keys.RETURN);
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.DiscountPer)) {
					terpage.terminal_waitClearEnterText_css(icp.DiscountPer_String, Globals.Inventory.DiscountPer);
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtDiscountPerc")).sendKeys(Keys.RETURN);
					
				}
				
				
				if (GenericWrappers.isNotEmpty(Globals.Inventory.EligibilityQty)) {
					terpage.terminal_waitClearEnterText_css(icp.EligibilityQty_String, Globals.Inventory.EligibilityQty);
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtEligibleQty")).sendKeys(Keys.RETURN);
					webDriver.findElement(By.cssSelector("a#ContentPlaceHolder1_lnkAdd")).click();
				}
				
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch)) {
					terpage.get_checkBox_element(icp.Batch_String).click();

				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch1)) {
					terpage.get_checkBox_element(icp.Batch1_String).click();

				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.FromTime)) {
					terpage.terminal_waitClearEnterText_css(icp.FromTime_String, Globals.Inventory.FromTime);
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtFrom")).sendKeys(Keys.RETURN);
				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.ToTime)) {
					terpage.terminal_waitClearEnterText_css(icp.ToTime_String, Globals.Inventory.ToTime);
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtToDate")).sendKeys(Keys.RETURN);
				}
			
			pass.ExcelFourData("NormalPromotion","Modules", "Actual", "Expected", "Status",
					0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
			pass.Excelcreate("NormalPromotion", "Filters", "Pass", 1, 0, 1, 3);
			
			}
			catch(Exception e) {
				// screen shot
				scr.Screenshots();
				System.out.println("Screen shot taken");
				// Xl sheet write
				pass.ExcelFourData("NormalPromotion","Filters", "Actual", "Expected", "Status",
						0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
				pass.Excelcreate("NormalPromotion", "Filters", "FAIL", 1, 0, 1, 3);
				
			}
	        
		}

		@Then("I close connection  DB for NormalPromotion")
		public void I_close_connection_to_DB() throws SQLException {

			mysqlConnect.disconnect();
			System.out.println(" closed succesfully");

			// mysqlConnect.disconnect();

		}

		MssqlConnect mysqlConnect;
		Statement st;
		@Then("I establish connection  DB for NormalPromotion")
		public void I_establish_connection_to_DB() throws SQLException {

			mysqlConnect = new MssqlConnect();
			st = mysqlConnect.connect().createStatement();
			System.out.println(" Connected succesfully");

		}
		@Given("I read the values from NormalPromotion table {string} in DB")
		public void i_want_to_launch_the(String tablename ) throws SQLException, IOException {
			
			
			ResultSet rs = st.executeQuery("select * from "+tablename+" where inventorycode='000001'");
			
			System.out.println(rs);
			//ResultSet rs = st.executeQuery("");

			while (rs.next()) {

				switch (tablename) {
				
				case "tblPromotionPriceChange":
						
					String Sellingprice="";
					try {
						Sellingprice = rs.getString("BatchNo");
						System.out.println(Sellingprice);
						Assert.assertEquals(Globals.Inventory.Batchno1.trim(), Sellingprice.trim());
						pass.Excelcreate("NormalPromotion", "tblPromotionPriceChange", "", 3, 0, 3, 1);
						pass.ExcelFourData("NormalPromotion", "BatchNo", Globals.Inventory.Batchno1, Sellingprice, "Pass",
								5, 0, 5, 1, 5, 2, 5, 3);
					} catch (AssertionError e) {
						pass.Excelcreate("NormalPromotion", "tblPromotionPriceChange", "", 3, 0, 3, 1);
						pass.ExcelFourData("NormalPromotion", "BatchNo", Globals.Inventory.Batchno1, Sellingprice, "Fail",
								5, 0, 5, 1, 5, 2, 5, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblPromotionPriceChange column BatchNo");
					}
					String MRP="";
					try
					{
						MRP = rs.getString("EligibleQty");
						System.out.println(MRP);
						Assert.assertEquals(Globals.Inventory.EligibilityQty.trim(), MRP.trim());
						pass.ExcelFourData("NormalPromotion", "EligibilityQty", Globals.Inventory.EligibilityQty, MRP, "Pass",
								6, 0, 6, 1, 6, 2, 6, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("NormalPromotion", "EligibilityQty", Globals.Inventory.EligibilityQty, MRP, "Fail",
								6, 0, 6, 1, 6, 2, 6, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblPromotionPriceChange column EligibilityQty");
					}
					String Mode="";
					try
					{
						Mode = rs.getString("DiscountPerc");
						System.out.println(Mode);
						Assert.assertEquals(Globals.Inventory.DiscountPer.trim(), Mode.trim());
						pass.ExcelFourData("NormalPromotion", "DiscountPerc", Globals.Inventory.DiscountPer, Mode, "Pass",
								7, 0, 7, 1, 7, 2, 7, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("NormalPromotion", "DiscountPerc", Globals.Inventory.DiscountPer, Mode, "Fail",
								7, 0, 7, 1, 7, 2, 7, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblPromotionPriceChange column DiscountPerc");
					}
					String Qty="";
					try
					{
						Qty = rs.getString("Promotionfromdate");
						System.out.println(Qty);
						Assert.assertEquals(Globals.Inventory.Date.trim(), Qty.trim());
						pass.ExcelFourData("NormalPromotion", "Promotionfromdate", Globals.Inventory.Date, Qty, "Pass",
								8, 0, 8, 1, 8, 2, 8, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("NormalPromotion", "Promotionfromdate", Globals.Inventory.Date, Qty, "Fail",
								8, 0, 8, 1, 8, 2, 8, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblPromotionPriceChange column NormalPromotion");
					}
					String Qty1="";
					try
					{
						Qty1 = rs.getString("Promotiontodate");
						System.out.println(Qty1);
						Assert.assertEquals(Globals.Inventory.ToDate.trim(), Qty1.trim());
						pass.ExcelFourData("NormalPromotion", "Promotiontodate", Globals.Inventory.ToDate, Qty1, "Pass",
								9, 0, 9, 1, 9, 2, 9, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("NormalPromotion", "Promotiontodate", Globals.Inventory.ToDate, Qty1, "Fail",
								9, 0, 9, 1, 9, 2, 9, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblPromotionPriceChange column Promotiontodate");
					}
					String FromDate="";
					try
					{
						FromDate = rs.getString("Promotionfromtime");
						System.out.println(FromDate);
						Assert.assertEquals(Globals.Inventory.FromTime.trim(), FromDate.trim());
						pass.ExcelFourData("NormalPromotion", "FromTime", Globals.Inventory.FromTime, FromDate, "Pass",
								10, 0, 10, 1, 10, 2, 10, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("NormalPromotion", "FromTime", Globals.Inventory.FromTime, FromDate, "Fail",
								10, 0, 10, 1, 10, 2, 10, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblPromotionPriceChange column Promotionfromtime");
					}
					String ToDate="";
					try
					{
						ToDate = rs.getString("Promotiontotime");
						System.out.println(ToDate);
						Assert.assertEquals(Globals.Inventory.ToTime.trim(), ToDate.trim());
						pass.ExcelFourData("NormalPromotion", "ToTime", Globals.Inventory.ToTime, ToDate, "Pass",
								11, 0, 11, 1, 11, 2, 11, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("NormalPromotion", "ToTime", Globals.Inventory.ToTime, ToDate, "Fail",
								11, 0, 11, 1, 11, 2, 11, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblPromotionPriceChange column Promotiontotime");
					}
					
					break;
					
				case "tblPromotionHistory":
					String Promotionfromdate="";
					try
					{
						Promotionfromdate = rs.getString("Promotionfromdate");
						System.out.println(Promotionfromdate);
						Assert.assertEquals(Globals.Inventory.Date.trim(), Promotionfromdate.trim());
						pass.Excelcreate("NormalPromotion", "tblQualifingitemforfree", "", 12, 0, 12, 1);
						pass.ExcelFourData("NormalPromotion", "Promotionfromdate", Globals.Inventory.Date, Promotionfromdate, "Pass",
								13, 0, 13, 1, 13, 2, 13, 3);
					} catch (AssertionError e) {
						pass.Excelcreate("NormalPromotion", "tblQualifingitemforfree", "", 12, 0, 12, 1);
						pass.ExcelFourData("NormalPromotion", "Promotionfromdate", Globals.Inventory.Date, Promotionfromdate, "Fail",
								13, 0, 13, 1, 13, 2, 13, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblPromotionHistory column Promotionfromdate");
					}
					String Promotiontodate="";
					try
					{
						Promotiontodate = rs.getString("Promotiontodate");
						System.out.println(Promotiontodate);
						Assert.assertEquals(Globals.Inventory.ToDate.trim(), Promotiontodate.trim());
						pass.ExcelFourData("NormalPromotion", "Promotiontodate", Globals.Inventory.ToDate, Promotiontodate, "Pass",
								14, 0, 14, 1, 14, 2, 14, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("NormalPromotion", "Promotiontodate", Globals.Inventory.ToDate, Promotiontodate, "Fail",
								14, 0, 14, 1, 14, 2, 14, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblPromotionHistory column Promotiontodate");
					}
					String Promotionfromtime="";
					try
					{
						Promotionfromtime = rs.getString("Promotionfromtime");
						System.out.println(Promotionfromtime);
						Assert.assertEquals(Globals.Inventory.FromTime.trim(), Promotionfromtime.trim());
						pass.ExcelFourData("NormalPromotion", "Promotionfromtime", Globals.Inventory.FromTime, Promotionfromtime, "Pass",
								15, 0, 15, 1, 15, 2,15, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("NormalPromotion", "Promotionfromtime", Globals.Inventory.FromTime, Promotionfromtime, "Fail",
								15, 0, 15, 1, 15, 2,15, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblPromotionPriceChange column Promotionfromtime");
					}
					String Promotiontotime="";
					try
					{
						Promotiontotime = rs.getString("Promotiontotime");
						System.out.println(Promotiontotime);
						Assert.assertEquals(Globals.Inventory.ToTime.trim(), Promotiontotime.trim());
						pass.ExcelFourData("NormalPromotion", "ToTime", Globals.Inventory.ToTime, Promotiontotime, "Pass",
								16, 0, 16, 1, 16, 2, 16, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("NormalPromotion", "ToTime", Globals.Inventory.ToTime, Promotiontotime, "Fail",
								16, 0, 16, 1, 16, 2, 16, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblPromotionPriceChange column Promotiontotime");
					}
					String EligibilityQty="";
					try
					{
						EligibilityQty = rs.getString("EligibleQty");
						System.out.println(EligibilityQty);
						Assert.assertEquals(Globals.Inventory.EligibilityQty.trim(), EligibilityQty.trim());
						pass.ExcelFourData("NormalPromotion", "EligibilityQty", Globals.Inventory.EligibilityQty, EligibilityQty, "Pass",
								17, 0, 17, 1, 17, 2, 17, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("NormalPromotion", "EligibilityQty", Globals.Inventory.EligibilityQty, EligibilityQty, "Fail",
								17, 0, 17, 1, 17, 2, 17, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblPromotionHistory column EligibilityQty");
					}
					String MRP1="";
					try {
					MRP1= rs.getString("Promotionqty");
					System.out.println(MRP1);
					Assert.assertEquals(Globals.Inventory.Qty1.trim(), MRP1.trim());
					pass.ExcelFourData("NormalPromotion", "Promotionqty", Globals.Inventory.Qty1, MRP1, "Pass",
							18, 0, 18, 1, 18, 2, 18, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("NormalPromotion", "Promotionqty", Globals.Inventory.Qty1, MRP1, "Fail",
							18, 0, 18, 1, 18, 2, 18, 3);
				}
					catch(Exception e) {
						System.out.println("null error tblPromotionHistory column Promotionqty");
					}
			
				
				
					break;
				case "tblRevokePromotionPrice":
					String BatchNo="";
					try {
						BatchNo = rs.getString("BatchNo");
						System.out.println(BatchNo);
						Assert.assertEquals(Globals.Inventory.Batchno1.trim(), BatchNo.trim());
						pass.Excelcreate("NormalPromotion", "tblRevokePromotionPrice", "", 19, 0, 19, 1);
						pass.ExcelFourData("NormalPromotion", "BatchNo", Globals.Inventory.Batchno1, BatchNo, "Pass",
								20, 0, 20, 1, 20, 2, 20, 3);
					} catch (AssertionError e) {
						pass.Excelcreate("NormalPromotion", "tblRevokePromotionPrice", "", 19, 0, 19, 1);
						pass.ExcelFourData("NormalPromotion", "BatchNo", Globals.Inventory.Batchno1, BatchNo, "Fail",
								20, 0, 20, 1, 20, 2, 20, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblPromotionPriceChange column BatchNo");
					}
					String EligibilityQty1="";
					try
					{
						EligibilityQty1 = rs.getString("EligibleQty");
						System.out.println(EligibilityQty1);
						Assert.assertEquals(Globals.Inventory.EligibilityQty.trim(), EligibilityQty1.trim());
						pass.ExcelFourData("NormalPromotion", "EligibilityQty", Globals.Inventory.EligibilityQty, EligibilityQty1, "Pass",
								21, 0, 21, 1, 21, 2, 21, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("NormalPromotion", "EligibilityQty", Globals.Inventory.EligibilityQty, EligibilityQty1, "Fail",
								21, 0, 21, 1, 21, 2, 21, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblPromotionPriceChange column EligibilityQty");
					}
					String DiscountPerc="";
					try
					{
						DiscountPerc = rs.getString("DiscountPerc");
						System.out.println(DiscountPerc);
						Assert.assertEquals(Globals.Inventory.DiscountPer.trim(), DiscountPerc.trim());
						pass.ExcelFourData("NormalPromotion", "DiscountPerc", Globals.Inventory.DiscountPer, DiscountPerc, "Pass",
								22, 0, 22, 1, 22, 2, 22, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("NormalPromotion", "DiscountPerc", Globals.Inventory.DiscountPer, DiscountPerc, "Fail",
								22, 0, 22, 1, 22, 2, 22, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblPromotionPriceChange column DiscountPerc");
					}
					String Promotionfromdate1="";
					try
					{
						Promotionfromdate1 = rs.getString("Promotionfromdate");
						System.out.println(Promotionfromdate1);
						Assert.assertEquals(Globals.Inventory.Date.trim(), Promotionfromdate1.trim());
						pass.ExcelFourData("NormalPromotion", "Promotionfromdate", Globals.Inventory.Date,Promotionfromdate1, "Pass",
								23, 0, 23, 1, 23, 2, 23, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("NormalPromotion", "Promotionfromdate", Globals.Inventory.Date, Promotionfromdate1, "Fail",
								23, 0, 23, 1, 23, 2, 23, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblPromotionPriceChange column NormalPromotion");
					}
					String Promotiontodate1="";
					try
					{
						Promotiontodate1 = rs.getString("Promotiontodate");
						System.out.println(Promotiontodate1);
						Assert.assertEquals(Globals.Inventory.ToDate.trim(), Promotiontodate1.trim());
						pass.ExcelFourData("NormalPromotion", "Promotiontodate", Globals.Inventory.ToDate, Promotiontodate1, "Pass",
								24, 0, 24, 1, 24, 2, 24, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("NormalPromotion", "Promotiontodate", Globals.Inventory.ToDate, Promotiontodate1, "Fail",
								24, 0, 24, 1, 24, 2, 24, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblPromotionPriceChange column Promotiontodate");
					}
					String Promotionfromtime1="";
					try
					{
						Promotionfromtime1 = rs.getString("Promotionfromtime");
						System.out.println(Promotionfromtime1);
						Assert.assertEquals(Globals.Inventory.FromTime.trim(), Promotionfromtime1.trim());
						pass.ExcelFourData("NormalPromotion", "FromTime", Globals.Inventory.FromTime, Promotionfromtime1, "Pass",
								25, 0, 25, 1, 25, 2, 25, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("NormalPromotion", "FromTime", Globals.Inventory.FromTime, Promotionfromtime1, "Fail",
								25, 0, 25, 1, 25, 2, 25, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblPromotionPriceChange column Promotionfromtime");
					}
					String Promotiontotime1="";
					try
					{
						Promotiontotime1 = rs.getString("Promotiontotime");
						System.out.println(Promotiontotime1);
						Assert.assertEquals(Globals.Inventory.ToTime.trim(), Promotiontotime1.trim());
						pass.ExcelFourData("NormalPromotion", "ToTime", Globals.Inventory.ToTime, Promotiontotime1, "Pass",
								26, 0, 26, 1, 26, 2, 26, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("NormalPromotion", "ToTime", Globals.Inventory.ToTime, Promotiontotime1, "Fail",
								26, 0, 26, 1, 26, 2, 26, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblPromotionPriceChange column Promotiontotime");
					}
				default:
					break;
				}
			
				}
			
		}
			



}




