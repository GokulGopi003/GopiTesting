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
			Globals.Inventory.Date = Globals.Inventory.NormalPromotionrowwiseData.get("Date");
			Globals.Inventory.ToDate = Globals.Inventory.NormalPromotionrowwiseData.get("ToDate");
			Globals.Inventory.ItemCode = Globals.Inventory.NormalPromotionrowwiseData.get("ItemCode");
			Globals.Inventory.Batchno = Globals.Inventory.NormalPromotionrowwiseData.get("Batchno");
			Globals.Inventory.Batch = Globals.Inventory.NormalPromotionrowwiseData.get("Batch");
			Globals.Inventory.Batch1 = Globals.Inventory.NormalPromotionrowwiseData.get("Batch1");
			Globals.Inventory.Batch2 = Globals.Inventory.NormalPromotionrowwiseData.get("Batch2");
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
					terpage.terminal_waitClearEnterText_css(icp.ItemCode1_String, Globals.Inventory.ItemCode);
					Inventorychange.clearAndTypeSlowly(Globals.Inventory.ItemCode, "input#txtSearch");
					Inventorychange.return_td_invoke_element(Globals.Inventory.ItemCode).click();
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
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtItemCode")).sendKeys(Keys.RETURN);
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
			
			
			ResultSet rs = st.executeQuery("select * from "+tablename+" where GroupCode='12'");
			
			System.out.println(rs);
			//ResultSet rs = st.executeQuery("");

			while (rs.next()) {

				switch (tablename) {
				
				case "tblFreeItemGroup":
						
					String Sellingprice="";
					try {
						Sellingprice = rs.getString("GroupCode");
						System.out.println(Sellingprice);
						Assert.assertEquals(Globals.Inventory.GrpCode.trim(), Sellingprice.trim());
						pass.Excelcreate("FreeItem", "tblGroup", "", 3, 0, 3, 1);
						pass.ExcelFourData("FreeItem", "GroupCode", Globals.Inventory.GrpCode, Sellingprice, "Pass",
								5, 0, 5, 1, 5, 2, 5, 3);
					} catch (AssertionError e) {
						pass.Excelcreate("FreeItem", "tblGroup", "", 3, 0, 3, 1);
						pass.ExcelFourData("FreeItem", "GroupCode", Globals.Inventory.GrpCode, Sellingprice, "Fail",
								5, 0, 5, 1, 5, 2, 5, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblinventory column GrpCode");
					}
					String MRP="";
					try
					{
						MRP = rs.getString("Description");
						System.out.println(MRP);
						Assert.assertEquals(Globals.Inventory.Description.trim(), MRP.trim());
						pass.ExcelFourData("FreeItem", "Description", Globals.Inventory.Description, MRP, "Pass",
								6, 0, 6, 1, 6, 2, 6, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("FreeItem", "Description", Globals.Inventory.Description, MRP, "Fail",
								6, 0, 6, 1, 6, 2, 6, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblinventory column MRP");
					}
					String Mode="";
					try
					{
						Mode = rs.getString("Fmode");
						System.out.println(Mode);
						Assert.assertEquals(Globals.Inventory.Mode.trim(), Mode.trim());
						pass.ExcelFourData("FreeItem", "Mode", Globals.Inventory.Mode, Mode, "Pass",
								7, 0, 7, 1, 7, 2, 7, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("FreeItem", "Mode", Globals.Inventory.Mode, Mode, "Fail",
								7, 0, 7, 1, 7, 2, 7, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblinventory column Mode");
					}
					String Qty="";
					try
					{
						Qty = rs.getString("BuyQty");
						System.out.println(Qty);
						Assert.assertEquals(Globals.Inventory.Qty.trim(), Qty.trim());
						pass.ExcelFourData("FreeItem", "Qty", Globals.Inventory.Qty, Qty, "Pass",
								8, 0, 8, 1, 8, 2, 8, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("FreeItem", "Qty", Globals.Inventory.Qty, Qty, "Fail",
								8, 0, 8, 1, 8, 2, 8, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblinventory column Qty");
					}
					String Qty1="";
					try
					{
						Qty1 = rs.getString("OfferedQty");
						System.out.println(Qty1);
						Assert.assertEquals(Globals.Inventory.Qty1.trim(), Qty1.trim());
						pass.ExcelFourData("FreeItem", "Qty1", Globals.Inventory.Qty1, Qty1, "Pass",
								9, 0, 9, 1, 9, 2, 9, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("FreeItem", "Qty1", Globals.Inventory.Qty1, Qty1, "Fail",
								9, 0, 9, 1, 9, 2, 9, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblinventory column Qty1");
					}
					String FromDate="";
					try
					{
						FromDate = rs.getString("ValidFrom");
						System.out.println(Qty1);
						Assert.assertEquals(Globals.Inventory.Date.trim(), FromDate.trim());
						pass.ExcelFourData("FreeItem", "Date", Globals.Inventory.Date, FromDate, "Pass",
								10, 0, 10, 1, 10, 2, 10, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("FreeItem", "Date", Globals.Inventory.Date, FromDate, "Fail",
								10, 0, 10, 1, 10, 2, 10, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblinventory column Date");
					}
					String ToDate="";
					try
					{
						ToDate = rs.getString("ValidTo");
						System.out.println(ToDate);
						Assert.assertEquals(Globals.Inventory.ToDate.trim(), ToDate.trim());
						pass.ExcelFourData("FreeItem", "Date", Globals.Inventory.ToDate, ToDate, "Pass",
								6, 0, 6, 1, 6, 2, 6, 3);
					} catch (AssertionError e) {
						pass.ExcelFourData("FreeItem", "Date", Globals.Inventory.ToDate, ToDate, "Fail",
								6, 0, 6, 1, 6, 2, 6, 3);
					}
					catch(Exception e) {
						System.out.println("null error tblinventory column ToDate");
					}
					
					break;
					
				case "tblQualifyingItemsForFree":
					String BasicSelling ="";
					try {
					BasicSelling = rs.getString("GroupCode");
					System.out.println(BasicSelling);
					Assert.assertEquals(Globals.Inventory.GrpCode.trim(), BasicSelling.trim());
					pass.Excelcreate("FreeItem", "tblQualifingitemforfree", "", 12, 0, 12, 1);
					pass.ExcelFourData("FreeItem", "GrpCode", Globals.Inventory.GrpCode, BasicSelling, "Pass",
							13, 0, 13, 1, 13, 2, 13, 3);
				} catch (AssertionError e) {
					pass.Excelcreate("FreeItem", "tblQualifingitemforfree", "", 12, 0, 12, 1);
					pass.ExcelFourData("FreeItem", "GrpCode", Globals.Inventory.GrpCode, BasicSelling, "Fail",
							13, 0, 13, 1, 13, 2, 13, 3);
				}
					catch(Exception e) {
						System.out.println("null error tblQualifingitemforfree column GrpCode");
					}
					String MRP1="";
					try {
					MRP1= rs.getString("itemcode");
					System.out.println(MRP1);
					Assert.assertEquals(Globals.Inventory.ItemCode.trim(), MRP1.trim());
					pass.ExcelFourData("FreeItem", "ItemCode", Globals.Inventory.ItemCode, MRP1, "Pass",
							14, 0, 14, 1, 14, 2, 14, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("FreeItem", "ItemCode", Globals.Inventory.ItemCode, MRP1, "Fail",
							14, 0, 14, 1, 14, 2, 14, 3);
				}
					catch(Exception e) {
						System.out.println("null error tblQualifingitemforfree column ItemCode");
					}
			
					String W1="";
					try {
				    W1 = rs.getString("BuyQty");
					System.out.println(W1);
					Assert.assertEquals(Globals.Inventory.Qty.trim(), W1.trim());
					pass.ExcelFourData("FreeItem", "Qty", Globals.Inventory.Qty, W1, "Pass",
							15, 0, 15, 1, 15, 2,15, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("FreeItem", "Qty", Globals.Inventory.Qty, W1, "Fail",
							15, 0, 15, 1, 15, 2,15, 3);
				}
					catch(Exception e) {
						System.out.println("null error tblQualifingitemforfree column Qty");
					}
				
					break;
				case "tblfreeitemslist":
						String BasicSelling1 ="";
						try {
						BasicSelling1 = rs.getString("GroupCode");
						System.out.println(BasicSelling1);
						Assert.assertEquals(Globals.Inventory.GrpCode.trim(), BasicSelling1.trim());
						pass.Excelcreate("FreeItem", "tblslist", "", 16, 0, 16, 1);
						pass.ExcelFourData("FreeItem", "GrpCode", Globals.Inventory.GrpCode, BasicSelling1, "Pass",
								17, 0, 17, 1, 17, 2, 17, 3);
					} catch (AssertionError e) {
						pass.Excelcreate("FreeItem", "tblslist", "", 16, 0, 16, 1);
						pass.ExcelFourData("FreeItem", "GrpCode", Globals.Inventory.GrpCode, BasicSelling1, "Fail",
								17, 0, 17, 1, 17, 2, 17, 3);
					}
						catch(Exception e) {
							System.out.println("null error tblslist column NetSellingPrice");
						}
						String Itemcode ="";
						try {
							Itemcode = rs.getString("Itemcode");
						System.out.println(Itemcode);
						Assert.assertEquals(Globals.Inventory.ItemCode.trim(), Itemcode.trim());
					
						pass.ExcelFourData("FreeItem", "ItemCode", Globals.Inventory.ItemCode, Itemcode, "Pass",
								18, 0, 18, 1, 18, 2, 18, 3);
					} catch (AssertionError e) {
						
						pass.ExcelFourData("FreeItem", "ItemCode", Globals.Inventory.ItemCode, Itemcode, "Fail",
								18, 0, 18, 1, 18, 2, 18, 3);
					}
						catch(Exception e) {
							System.out.println("null error tblslist column NetSellingPrice");
						}
						String Itemcode1 ="";
						try {
							Itemcode1 = rs.getString("Itemcode");
						System.out.println(Itemcode1);
						Assert.assertEquals(Globals.Inventory.ItemCode.trim(), Itemcode1.trim());
					
						pass.ExcelFourData("FreeItem", "ItemCode", Globals.Inventory.ItemCode, Itemcode1, "Pass",
								19, 0, 19, 1, 19, 2, 19, 3);
					} catch (AssertionError e) {
						
						pass.ExcelFourData("FreeItem", "ItemCode", Globals.Inventory.ItemCode, Itemcode1, "Fail",
								19, 0, 19, 1, 19, 2, 19, 3);
					}
						catch(Exception e) {
							System.out.println("null error tblslist column NetSellingPrice");
						}
						String Qty11 ="";
						try {
							Qty11 = rs.getString("FreeQty");
						System.out.println(Qty11);
						Assert.assertEquals(Globals.Inventory.Qty.trim(), Qty11.trim());
					
						pass.ExcelFourData("FreeItem", "Qty", Globals.Inventory.Qty, Qty11, "Pass",
								20, 0, 20, 1, 20, 2, 20, 3);
					} catch (AssertionError e) {
						
						pass.ExcelFourData("FreeItem", "Qty", Globals.Inventory.Qty, Qty11, "Fail",
								20, 0, 20, 1, 20, 2, 20, 3);
					}
						catch(Exception e) {
							System.out.println("null error tblslist column NetSellingPrice");
						}
						String EligibilityQty ="";
						try {
							EligibilityQty = rs.getString("InputQty");
						System.out.println(EligibilityQty);
						Assert.assertEquals(Globals.Inventory.EligibilityQty.trim(), EligibilityQty.trim());
					
						pass.ExcelFourData("FreeItem", "EligibilityQty", Globals.Inventory.EligibilityQty, EligibilityQty, "Pass",
								21, 0, 21, 1, 21, 2, 21, 3);
					} catch (AssertionError e) {
						
						pass.ExcelFourData("FreeItem", "EligibilityQty", Globals.Inventory.EligibilityQty, EligibilityQty, "Fail",
								21, 0, 21, 1, 21, 2, 21, 3);
					}
						catch(Exception e) {
							System.out.println("null error tblslist column EligibilityQty");
						}
				default:
					break;
				}
			
				}
			
		}
			



}




