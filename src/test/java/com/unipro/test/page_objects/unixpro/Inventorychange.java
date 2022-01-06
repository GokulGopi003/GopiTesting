package com.unipro.test.page_objects.unixpro;

import java.io.IOException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;

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

public class Inventorychange extends PageObject {
	AddInventoryFormPage Inventorychange;
	InventorychangeField icp;
	CommonPages cp;
	TerminalPage terpage;
	ExcelWrite pass;
	Screenshot scr;

	public Inventorychange(InventorychangeField icp, CommonPages cp) {

		this.icp = icp;
		this.cp = cp;

		terpage = new TerminalPage();
		Inventorychange = new AddInventoryFormPage();
		pass = new ExcelWrite();
		scr = new Screenshot();

	}

	@Then("I load the Inventorychange sheet data to map")
	public void I_load_the_Inventorychange_sheet_data_to_map() {
		Globals.Inventory.InventorychangeSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME37);

	}

	@Then("I load the rowise Inventorychange data for {string} rowname")
	public void i_load_the_rowise_Inventorychange_data_for_rowname(String row_name) {
		Globals.Inventory.InventorychangerowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.InventorychangeSheetData, row_name);
		System.out.println(Globals.Inventory.InventorychangerowwiseData);
	}

	@Then("I update value to the Inventorychange page global Variables")
	public void i_update_value_to_the_ConsolidatedPO_page_global_Variables() {
		Globals.Inventory.Vendor = Globals.Inventory.InventorychangerowwiseData.get("Vendor");
		Globals.Inventory.Department = Globals.Inventory.InventorychangerowwiseData.get("Department");
		Globals.Inventory.Category = Globals.Inventory.InventorychangerowwiseData.get("Category");
		Globals.Inventory.Brand = Globals.Inventory.InventorychangerowwiseData.get("Brand");
		Globals.Inventory.SubCategory = Globals.Inventory.InventorychangerowwiseData.get("SubCategory");
		Globals.Inventory.Merchandise = Globals.Inventory.InventorychangerowwiseData.get("Merchandise");
		Globals.Inventory.Manufacture = Globals.Inventory.InventorychangerowwiseData.get("Manufacture");
		Globals.Inventory.Floorcode = Globals.Inventory.InventorychangerowwiseData.get("Floorcode");
		Globals.Inventory.Section = Globals.Inventory.InventorychangerowwiseData.get("Section");
		Globals.Inventory.Bin = Globals.Inventory.InventorychangerowwiseData.get("Bin");
		Globals.Inventory.ShelfCode = Globals.Inventory.InventorychangerowwiseData.get("ShelfCode");
		Globals.Inventory.ItemCode = Globals.Inventory.InventorychangerowwiseData.get("ItemCode");
		Globals.Inventory.ItemName = Globals.Inventory.InventorychangerowwiseData.get("ItemName");
		Globals.Inventory.Class = Globals.Inventory.InventorychangerowwiseData.get("Class");
		Globals.Inventory.SubClass = Globals.Inventory.InventorychangerowwiseData.get("SubClass");
		Globals.Inventory.WareHouse = Globals.Inventory.InventorychangerowwiseData.get("WareHouse");
		Globals.Inventory.ItemType = Globals.Inventory.InventorychangerowwiseData.get("ItemType");
		Globals.Inventory.Price = Globals.Inventory.InventorychangerowwiseData.get("Price");
		Globals.Inventory.GST = Globals.Inventory.InventorychangerowwiseData.get("GST");
		Globals.Inventory.Batch = Globals.Inventory.InventorychangerowwiseData.get("Batch");
		Globals.Inventory.Batch1 = Globals.Inventory.InventorychangerowwiseData.get("Batch1");
		Globals.Inventory.Batch2 = Globals.Inventory.InventorychangerowwiseData.get("Batch2");
		Globals.Inventory.Batch3 = Globals.Inventory.InventorychangerowwiseData.get("Batch3");
		Globals.Inventory.Selectfield = Globals.Inventory.InventorychangerowwiseData.get("Selectfield");
		Globals.Inventory.Changefield = Globals.Inventory.InventorychangerowwiseData.get("Changefield");
		Globals.Inventory.Billdate = Globals.Inventory.InventorychangerowwiseData.get("Billdate");
		Globals.Inventory.Date = Globals.Inventory.InventorychangerowwiseData.get("Date");
		Globals.Inventory.EarnedMargin = Globals.Inventory.InventorychangerowwiseData.get("EarnedMargin");
		Globals.Inventory.MRP = Globals.Inventory.InventorychangerowwiseData.get("MRP");
		Globals.Inventory.Netcost = Globals.Inventory.InventorychangerowwiseData.get("Netcost");
		Globals.Inventory.FromDate = Globals.Inventory.InventorychangerowwiseData.get("FromDate");
		Globals.Inventory.ToDate = Globals.Inventory.InventorychangerowwiseData.get("ToDate");
		Globals.Inventory.Earnedmarginclick = Globals.Inventory.InventorychangerowwiseData.get("Earnedmarginclick");
		Globals.Inventory.MRPclick = Globals.Inventory.InventorychangerowwiseData.get("MRPclick");
		Globals.Inventory.Netcostclick = Globals.Inventory.InventorychangerowwiseData.get("Netcostclick");
		Globals.Inventory.NewFromDate = Globals.Inventory.InventorychangerowwiseData.get("NewFromDate");
		Globals.Inventory.NewToDate = Globals.Inventory.InventorychangerowwiseData.get("NewToDate");
		Globals.Inventory.Selectall = Globals.Inventory.InventorychangerowwiseData.get("Selectall");
		Globals.Inventory.AverageCost = Globals.Inventory.InventorychangerowwiseData.get("AverageCost");
		
		
		
	}

	@Then("I fill new Inventorychange data page using excel data")
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
		if (GenericWrappers.isNotEmpty(Globals.Inventory.WareHouse)) {
			terpage.terminal_waitClearEnterText_css(icp.WareHouse_String, Globals.Inventory.WareHouse);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.WareHouse, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.WareHouse).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemCode)) {
			terpage.terminal_waitClearEnterText_css(icp.ItemCode_String, Globals.Inventory.ItemCode);
			webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_searchFilterUserControl_txtItemCode")).sendKeys(Keys.RETURN);
		}

		if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemName)) {
			terpage.terminal_waitClearEnterText_css(icp.ItemName_String, Globals.Inventory.ItemName);
			webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_searchFilterUserControl_txtItemName")).sendKeys(Keys.RETURN);

		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.GST)) {
			terpage.terminal_waitClearEnterText_css(icp.GST_String, Globals.Inventory.GST);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.GST, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.GST).click();
		}
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Selectfield)) {
			terpage.terminal_waitClearEnterText_css(icp.Selectfield_String, Globals.Inventory.Selectfield);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Selectfield, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Selectfield).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Changefield)) {
			terpage.terminal_waitClearEnterText_css(icp.Changefield_String, Globals.Inventory.Changefield);
			Inventorychange.clearAndTypeSlowly(Globals.Inventory.Changefield, "input#txtSearch");
			Inventorychange.return_td_invoke_element(Globals.Inventory.Changefield).click();
		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch)) {
			terpage.get_checkBox_element(icp.Batch_String).click();
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Earnedmarginclick)) {
			terpage.get_checkBox_element(icp.Earnedmarginclick_String).click();
			terpage.terminal_waitClearEnterText_css(icp.EarnedMargin_String, Globals.Inventory.EarnedMargin);
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.MRPclick)) {
				terpage.get_checkBox_element(icp.MRPclick_String).click();
				terpage.terminal_waitClearEnterText_css(icp.MRP_String, Globals.Inventory.MRP);
				}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Netcostclick)) {
				terpage.get_checkBox_element(icp.Netcostclick_String).click();
				terpage.terminal_waitClearEnterText_css(icp.Netcost_String, Globals.Inventory.Netcost);
				}


		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch1)) {
			terpage.get_checkBox_element(icp.Batch1_String).click();
			if (GenericWrappers.isNotEmpty(Globals.Inventory.FromDate)) {
				terpage.terminal_waitClearEnterText_css(icp.FromDate_String, Globals.Inventory.FromDate);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtSalesFromDate")).sendKeys(Keys.RETURN);

				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.ToDate)) {
					terpage.terminal_waitClearEnterText_css(icp.ToDate_String, Globals.Inventory.ToDate);
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtSalesToDate")).sendKeys(Keys.RETURN);
					}
			

	    }
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch2)) {
			terpage.get_checkBox_element(icp.Batch2_String).click();
			if (GenericWrappers.isNotEmpty(Globals.Inventory.NewFromDate)) {
				terpage.terminal_waitClearEnterText_css(icp.NewFromDate_String, Globals.Inventory.NewFromDate);
				webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtNewFromDate")).sendKeys(Keys.RETURN);

				}
				if (GenericWrappers.isNotEmpty(Globals.Inventory.NewToDate)) {
					terpage.terminal_waitClearEnterText_css(icp.NewToDate_String, Globals.Inventory.NewToDate);
					webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtNewToDate")).sendKeys(Keys.RETURN);
					}

	    }
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch3)) {
			terpage.get_checkBox_element(icp.Batch3_String).click();
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Selectall)) {
			terpage.get_checkBox_element(icp.Selectall_String).click();
			try {
				List<WebElement> weList = getWebDriver().findElements(By.tagName("button"));
				for (Iterator iterator = weList.iterator(); iterator.hasNext();) {
					WebElement button = (WebElement) iterator.next();
					if (button.getText().equalsIgnoreCase("confirm")) {
						button.click();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			}

	    }
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Billdate)) {
			terpage.terminal_waitClearEnterText_css(icp.Billdate_String, Globals.Inventory.Billdate);
			webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtFromDate")).sendKeys(Keys.RETURN);


		}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Date)) {
			terpage.terminal_waitClearEnterText_css(icp.Date_String, Globals.Inventory.Date);
			webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtToDate")).sendKeys(Keys.RETURN);


		}
		pass.ExcelFourData("InventoryChange","Modules", "Actual", "Expected", "Status",
				0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
		pass.Excelcreate("InventoryChange", "Filters", "Pass", 1, 0, 1, 3);
		}
		catch(Exception e) {
			// screen shot
			scr.Screenshots();
			System.out.println("Screen shot taken");
			// Xl sheet write
			pass.ExcelFourData("InventoryChange","Filters", "Actual", "Expected", "Status",
					0 ,0 ,0 ,1 ,0 ,2 ,0 , 3);
			pass.Excelcreate("InventoryChange", "Filters", "FAIL", 1, 0, 1, 3);
			
		}
	}

	@Then("I click filter")
	public void i_click_filter() {
		
		webDriver.findElement(By.cssSelector("a#ContentPlaceHolder1_searchFilterUserControl_lnkFilter.button-red")).click();
		webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_checkAll")).click();
		
		
	}
	@Then("I close connection  DB for InventoryChange")
	public void I_close_connection_to_DB() throws SQLException {

		mysqlConnect.disconnect();
		System.out.println(" closed succesfully");

		// mysqlConnect.disconnect();

	}

	MssqlConnect mysqlConnect;
	Statement st;
	@Then("I establish connection  DB for InventoryChange")
	public void I_establish_connection_to_DB() throws SQLException {

		mysqlConnect = new MssqlConnect();
		st = mysqlConnect.connect().createStatement();
		System.out.println(" Connected succesfully");

	}
	@Given("I read the values from InventoryChange table {string} in DB")
	public void i_want_to_launch_the(String tablename ) throws SQLException, IOException {
		
		
		ResultSet rs = st.executeQuery("select * from "+tablename+" where InventoryCode='000001'");
		
		System.out.println(rs);
		//ResultSet rs = st.executeQuery("");

		while (rs.next()) {

			switch (tablename) {
			
			case "tblinventory":
				String CategoryCode = "";
				try {
					CategoryCode = rs.getString("CategoryCode");
					System.out.println(CategoryCode);
					Assert.assertEquals(Globals.Inventory.Changefield.trim(), CategoryCode.trim());
					pass.Excelcreate("InventoryChange", "tblinventory", "", 2, 0, 2, 1);
					pass.ExcelFourData("InventoryChange", "CategoryCode", Globals.Inventory.Changefield, CategoryCode, "Pass",
							3, 0, 3, 1, 3, 2, 3, 3);
				} catch (AssertionError e) {
					pass.Excelcreate("InventoryChange", "tblinventory", "", 2, 0, 2, 1);
					pass.ExcelFourData("InventoryChange", "CategoryCode", Globals.Inventory.Changefield, CategoryCode, "Fail",
							3, 0, 3, 1, 3, 2, 3, 3);

				}
				catch(Exception e) {
					System.out.println("null error tblinventory column CategoryCode");
					}
				String Departmentcode = "";
				try {
					Departmentcode = rs.getString("Departmentcode");
					System.out.println(Departmentcode);
					Assert.assertEquals(Globals.Inventory.Changefield.trim(), Departmentcode.trim());
					pass.ExcelFourData("Inventory", "Departmentcode", Globals.Inventory.Changefield, Departmentcode, "Pass",
							4, 0, 4, 1, 4, 2, 4, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("Inventory", "Departmentcode", Globals.Inventory.Changefield, Departmentcode, "Fail",
							4, 0, 4, 1, 4, 2, 4, 3);
				}
				catch(Exception e) {
					System.out.println("null error tblinventory column Departmentcode");
					}
				String Brandcode = "";
				try {
					Brandcode = rs.getString("BrandCode");
					System.out.println(Brandcode);
					Assert.assertEquals(Globals.Inventory.Changefield.trim(), Brandcode.trim());
					pass.ExcelFourData("Inventory", "BrandCode", Globals.Inventory.Changefield, Brandcode, "Fail",
							5, 0, 5, 1, 5, 2, 5, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("Inventory", "BrandCode", Globals.Inventory.Changefield, Brandcode, "Fail",
							5, 0, 5, 1, 5, 2, 5, 3);
				}
				catch(Exception e) {
					System.out.println("null error tblinventory column BrandCode");
					}
				
				String Subcategory = "";
				try {
					Subcategory = rs.getString("Subcategorycode");
					System.out.println(Subcategory);
					Assert.assertEquals(Globals.Inventory.Changefield.trim(), Subcategory.trim());
					pass.ExcelFourData("Inventory", "Subcategory", Globals.Inventory.Changefield, Subcategory, "Pass",
							6, 0, 6, 1, 6, 2, 6, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("Inventory", "Subcategory", Globals.Inventory.Changefield, Subcategory, "Fail",
							6, 0, 6, 1, 6, 2, 6, 3);
				}
				catch(Exception e) {
					System.out.println("null error tblinventory column Subcategorycode");
					}
				String Class = "";
				try {

					Class = rs.getString("Class");
					System.out.println(Class);
					Assert.assertEquals(Globals.Inventory.Changefield.trim(), Class.trim());
					pass.ExcelFourData("Inventory", "Class", Globals.Inventory.Changefield, Class, "Pass",
							7, 0, 7, 1, 7, 2,7, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("Inventory", "Class", Globals.Inventory.Changefield, Class, "Fail",
							7, 0, 7, 1, 7, 2,7, 3);
				}
				catch(Exception e) {
					System.out.println("null error tblinventory column Class");
					}
				
				String SubClass = "";
				try {
					SubClass = rs.getString("SubClass");
					System.out.println(SubClass);
					Assert.assertEquals(Globals.Inventory.Changefield.trim(), SubClass.trim());
					pass.ExcelFourData("Inventory", "SubClass", Globals.Inventory.Changefield, SubClass, "Pass",
							8, 0, 8, 1, 8, 2, 8, 3);
				} catch (AssertionError e) {
					pass.ExcelFourData("Inventory", "Actual,Expected", Globals.Inventory.Changefield, SubClass, "Fail",
							8, 0, 8, 1, 8, 2, 8, 3);
				}
				catch(Exception e) {
					System.out.println("null error tblinventory column SubClass");
					}
				String Origion="";
				try
				{
			    Origion = rs.getString("Origin");
				System.out.println(Origion);
				Assert.assertEquals(Globals.Inventory.Changefield.trim(), Origion.trim());
				pass.ExcelFourData("Inventory", "Origin", Globals.Inventory.Changefield, Origion, "Pass",
						9, 0, 9, 1, 9, 2, 9, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory", "Origin", Globals.Inventory.Changefield, Origion, "Fail",
						9, 0, 9, 1, 9, 2, 9, 3);
			}
				catch(Exception e) {
					System.out.println("null error tblinventory column Origin");
					}
				String Warehouse="";
				try
				{
			    Warehouse = rs.getString("Warehouse");
				System.out.println(Warehouse);
				Assert.assertEquals(Globals.Inventory.Changefield.trim(), Warehouse.trim());
				pass.ExcelFourData("Inventory", "Warehouse", Globals.Inventory.Changefield, Warehouse, "Pass",
						10, 0, 10, 1, 10, 2, 10, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory", "Warehouse", Globals.Inventory.Changefield, Warehouse, "Fail",
						10, 0, 10, 1, 10, 2, 10, 3);
			}
				catch(Exception e) {
					System.out.println("null error tblinventory column Warehouse");
					}
				String UOM="";
				try {
			    UOM = rs.getString("UOM");
				System.out.println(UOM);
				Assert.assertEquals(Globals.Inventory.Changefield.trim(), UOM.trim());
				pass.ExcelFourData("Inventory", "UOM", Globals.Inventory.Changefield, UOM, "Pass",
						11, 0, 11, 1, 11, 2, 11, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory", "UOM", Globals.Inventory.Changefield, UOM, "Fail",
						11, 0, 11, 1, 11, 2, 11, 3);
			}
				catch(Exception e) {
					System.out.println("null error tblinventory column UOM");
					}
				String Manufacture="";
			try {
					
				Manufacture = rs.getString("Manufacturer");
				System.out.println(Manufacture);
				Assert.assertEquals(Globals.Inventory.Changefield.trim(), Manufacture.trim());
				pass.ExcelFourData("Inventory", "Manufacturer", Globals.Inventory.Changefield, Manufacture, "Pass",
						12, 0, 12, 1, 12, 2, 12, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory", "Manufacturer", Globals.Inventory.Changefield, Manufacture, "Fail",
						12, 0, 12, 1, 12, 2, 12, 3);
			}
			catch(Exception e) {
				System.out.println("null error tblinventory column Manufacturer");
				}
			String ItemType="";
			try {
				
			    ItemType = rs.getString("ItemType");
				System.out.println(ItemType);
				Assert.assertEquals(Globals.Inventory.Changefield.trim(), ItemType.trim());
				pass.ExcelFourData("Inventory", "ItemType", Globals.Inventory.Changefield, ItemType, "Pass",
						13, 0, 13, 1, 13, 2, 13, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory", "ItemType", Globals.Inventory.Changefield, ItemType, "Fail",
						13, 0, 13, 1, 13, 2, 13, 3);
			}
			catch(Exception e) {
				System.out.println("null error tblinventory column ItemType");
				}
			
			String Vendorcode="";
			try {
				Vendorcode = rs.getString("VendorCode");
				System.out.println(Vendorcode);
				Assert.assertEquals(Globals.Inventory.Changefield.trim(), Vendorcode.trim());
				pass.ExcelFourData("Inventory", "VendorCode", Globals.Inventory.Changefield, Vendorcode, "Pass",
						14, 0, 14, 1, 14, 2, 14, 3);
			} catch (AssertionError e) {
				pass.ExcelFourData("Inventory", "VendorCode", Globals.Inventory.Changefield, Vendorcode, "Fail",
						14, 0, 14, 1, 14, 2, 14, 3);
			}
			catch(Exception e) {
				System.out.println("null error tblinventory column Vendor");
				}

				break;
			
			default:
				break;
			
		case "tblinventorypricing":
			String GST="";
			try {
			GST = rs.getString("ITaxPer3");
			System.out.println(GST);
			Assert.assertEquals(Globals.Inventory.Changefield.trim(), GST.trim());
			pass.Excelcreate("InventoryChange", "tblinventorypricing", "", 16, 0, 16, 1);
			pass.ExcelFourData("InventoryChange", "ITaxPer3", Globals.Inventory.Changefield, GST, "Pass",
					17, 0, 17, 1, 17, 2, 17, 3);
		} catch (AssertionError e) {
			pass.Excelcreate("InventoryChange", "tblinventorypricing", "", 16, 0, 16, 1);
			pass.ExcelFourData("InventoryChange", "ITaxPer3", Globals.Inventory.Changefield, GST, "Fail",
					17, 0, 17, 1, 17, 2, 17, 3);
		}
			catch(Exception e) {
				System.out.println("null error tblinventory column Vendor");
				}
			String GST1 ="";
			try {
			GST1 = rs.getString("OTaxPer3");
			System.out.println(GST1);
			Assert.assertEquals(Globals.Inventory.Changefield.trim(), GST1.trim());
			pass.ExcelFourData("InventoryChange", "OTaxPer3", Globals.Inventory.Changefield, GST1, "Pass",
					18, 0, 18, 1, 18, 2, 18, 3);
		} catch (AssertionError e) {
			pass.ExcelFourData("InventoryChange", "OTaxPer3", Globals.Inventory.Changefield, GST1, "Fail",
					18, 0, 18, 1, 18, 2, 18, 3);
		}
			catch(Exception e) {
				System.out.println("null error tblinventory column Vendor");
				}
		case "tblinventorymaster":
			String Vendorcode1="";
			try {
				Vendorcode = rs.getString("VendorCode");
				System.out.println(Vendorcode1);
				Assert.assertEquals(Globals.Inventory.Changefield.trim(), Vendorcode.trim());
				pass.Excelcreate("InventoryChange", "tblinventorymaster", "", 20, 0, 20, 1);
				pass.ExcelFourData("InventoryChange", "VendorCode", Globals.Inventory.Changefield, Vendorcode1, "Pass",
						21, 0, 21, 1, 21, 2, 21, 3);
			} catch (AssertionError e) {
				pass.Excelcreate("InventoryChange", "tblinventorymaster", "", 20, 0, 20, 1);
				pass.ExcelFourData("InventoryChange", "VendorCode", Globals.Inventory.Changefield, Vendorcode1, "Fail",
						21, 0, 21, 1, 21, 2, 21, 3);
			}
			catch(Exception e) {
				System.out.println("null error tblinventory column Vendor");
				}
			String Inventorycode11="";
			try {
			Inventorycode11 = rs.getString("InventoryCode");
			System.out.println(Inventorycode11);
			Assert.assertEquals(Globals.Inventory.Changefield.trim(), Inventorycode11.trim());
			pass.ExcelFourData("InventoryChange", "InventoryCode", Globals.Inventory.Changefield, Inventorycode11, "Pass",
					22, 0, 22, 1, 22, 2, 22, 3);
		} catch (AssertionError e) {
			pass.ExcelFourData("InventoryChange", "InventoryCode", Globals.Inventory.Changefield, Inventorycode11, "Fail",
					22, 0, 22, 1, 22, 2, 22, 3);
		}
			catch(Exception e) {
				System.out.println("null error tblinventory column Vendor");
				}
		}
		}
	}
	}
		

