package com.unipro.test.page_objects.unixpro;

	import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
    import org.openqa.selenium.Keys;
    import org.openqa.selenium.WebElement;
    import org.testng.Assert;
import com.gk.test.MssqlConnect;
import com.unipro.ExcelWrite;
import com.unipro.test.framework.Globals;
import com.unipro.test.framework.PageObject;
import com.unipro.test.framework.helpers.utils.GenericWrappers;
	import com.unipro.test.framework.helpers.utils.ReadTestData;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

	public class Style extends PageObject {
		AddInventoryFormPage Category;
		Stylefield icp;
		TerminalPage terPage;
        ExcelWrite pass;
		public  Style(Stylefield  icp) {
			this.icp = icp;
			terPage = new TerminalPage();
			Category = new AddInventoryFormPage();
			pass=new ExcelWrite();
		}
		
		@Then("I load the Style sheet data to map")
		public void i_load_the_Subcategory_sheet_data_to_map() {
			Globals.Inventory.StyleSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME21);
		}
		@Then("I load the rowise Style data for {string} rowname")
		public void i_load_the_rowise_Category_data_for_rowname(String row_name) {

			Globals.Inventory.StylerowwiseData = ReadTestData
					.getRowFilteredValueFromTable(Globals.Inventory.StyleSheetData, row_name);

			System.out.println(Globals.Inventory.StyleSheetData);

		}

		@Then("I update value to the Style page global Variables")
		public void i_update_value_to_the_Subcategory_page_global_Variables() {
			Globals.Inventory.StyleCode = Globals.Inventory.StylerowwiseData.get("StyleCode");
			Globals.Inventory.Description = Globals.Inventory.StylerowwiseData.get("Description");
			Globals.Inventory.Brand = Globals.Inventory.StylerowwiseData.get("Brand");
			Globals.Inventory.ItemType = Globals.Inventory.StylerowwiseData.get("ItemType");
			Globals.Inventory.Manufacture = Globals.Inventory.StylerowwiseData.get("Manufacture");
			Globals.Inventory.Department = Globals.Inventory.StylerowwiseData.get("Department");
			Globals.Inventory.Origion = Globals.Inventory.StylerowwiseData.get("Origion");
			Globals.Inventory.Category = Globals.Inventory.StylerowwiseData.get("Category");
			Globals.Inventory.Vendor = Globals.Inventory.StylerowwiseData.get("Vendor");
			Globals.Inventory.WarehouseCode = Globals.Inventory.StylerowwiseData.get("WarehouseCode");
			Globals.Inventory.Merchandise = Globals.Inventory.StylerowwiseData.get("Merchandise");
			Globals.Inventory.CCode = Globals.Inventory.StylerowwiseData.get("CCode");
			Globals.Inventory.Taxcode = Globals.Inventory.StylerowwiseData.get("Taxcode");
			Globals.Inventory.Floorcode = Globals.Inventory.StylerowwiseData.get("Floorcode");
			Globals.Inventory.Bin = Globals.Inventory.StylerowwiseData.get("Bin");
			Globals.Inventory.Uomcode = Globals.Inventory.StylerowwiseData.get("Uomcode");
			Globals.Inventory.StockType = Globals.Inventory.StylerowwiseData.get("StockType");
			Globals.Inventory.Package = Globals.Inventory.StylerowwiseData.get("Package");
			Globals.Inventory.Section = Globals.Inventory.StylerowwiseData.get("Section");
			Globals.Inventory.Shelf = Globals.Inventory.StylerowwiseData.get("Shelf");
			Globals.Inventory.SalesUOM = Globals.Inventory.StylerowwiseData.get("SalesUOM");
			Globals.Inventory.Batch = Globals.Inventory.StylerowwiseData.get("Batch");
			Globals.Inventory.Batch1 = Globals.Inventory.StylerowwiseData.get("Batch1");

			
		}

		@Then("I fill new Style data page using excel data")
		public void i_fill_new_Subcategory_data_page_using_excel_data() {
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.StyleCode)) {
				   terPage.terminal_waitClearEnterText_css(icp.StyleCode_String, Globals.Inventory.StyleCode);
			
                }
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Description)) {
				   terPage.terminal_waitClearEnterText_css(icp.Description_String, Globals.Inventory.Description);
			
             }
			

			if (GenericWrappers.isNotEmpty(Globals.Inventory.Department)) {
				webDriver.findElement(By.cssSelector("div#ContentPlaceHolder1_ddlDepartment_chzn")).click();
				GenericWrappers.sleepInSeconds(1);
				//terPage.terminal_waitClearEnterText_css(icp.Vendor_String, Globals.Inventory.Vendor);
				WebElement itemCodeValue = webDriver.findElement(By.cssSelector("#ContentPlaceHolder1_ddlDepartment_chzn > div > div > input[type=text]"));
				String css_location_dropDownValue = "#ContentPlaceHolder1_ddlDepartment_chzn > div > div > input[type=text]";
				By ddlocator = By.cssSelector(css_location_dropDownValue);
				waitForExpectedElement(ddlocator);
				js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.Department);
				GenericWrappers.sleepInSeconds(1);
				itemCodeValue.sendKeys(Keys.SPACE);
				itemCodeValue.sendKeys(Keys.SPACE);
				itemCodeValue.sendKeys(Keys.ARROW_DOWN);
				GenericWrappers.sleepInSeconds(1);
				itemCodeValue.sendKeys(Keys.ENTER);
               
			}
									

				
			
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Brand)) {
				webDriver.findElement(By.cssSelector("div#ContentPlaceHolder1_ddlBrand_chzn")).click();
				GenericWrappers.sleepInSeconds(1);
				//terPage.terminal_waitClearEnterText_css(icp.Vendor_String, Globals.Inventory.Vendor);
				WebElement itemCodeValue = webDriver.findElement(By.cssSelector("#ContentPlaceHolder1_ddlBrand_chzn > div > div > input[type=text]"));
				String css_location_dropDownValue = "#ContentPlaceHolder1_ddlBrand_chzn > div > div > input[type=text]";
				By ddlocator = By.cssSelector(css_location_dropDownValue);
				waitForExpectedElement(ddlocator);
				js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.Brand);
				GenericWrappers.sleepInSeconds(1);
				itemCodeValue.sendKeys(Keys.SPACE);
				itemCodeValue.sendKeys(Keys.SPACE);
				itemCodeValue.sendKeys(Keys.ARROW_DOWN);
				GenericWrappers.sleepInSeconds(1);
				itemCodeValue.sendKeys(Keys.ENTER);
               
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.ItemType)) {
				webDriver.findElement(By.cssSelector("div#ContentPlaceHolder1_ddlItemType_chzn")).click();
				GenericWrappers.sleepInSeconds(1);
				//terPage.terminal_waitClearEnterText_css(icp.Vendor_String, Globals.Inventory.Vendor);
				WebElement itemCodeValue = webDriver.findElement(By.cssSelector("#ContentPlaceHolder1_ddlItemType_chzn > div > div > input[type=text]"));
				String css_location_dropDownValue = "#ContentPlaceHolder1_ddlItemType_chzn > div > div > input[type=text]";
				By ddlocator = By.cssSelector(css_location_dropDownValue);
				waitForExpectedElement(ddlocator);
				js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.ItemType);
				GenericWrappers.sleepInSeconds(1);
				itemCodeValue.sendKeys(Keys.SPACE);
				itemCodeValue.sendKeys(Keys.SPACE);
				itemCodeValue.sendKeys(Keys.ARROW_DOWN);
				GenericWrappers.sleepInSeconds(1);
				itemCodeValue.sendKeys(Keys.ENTER);
               
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Manufacture)) {
				webDriver.findElement(By.cssSelector("div#ContentPlaceHolder1_ddlManufauture_chzn")).click();
				GenericWrappers.sleepInSeconds(1);
				//terPage.terminal_waitClearEnterText_css(icp.Vendor_String, Globals.Inventory.Vendor);
				WebElement itemCodeValue = webDriver.findElement(By.cssSelector("#ContentPlaceHolder1_ddlManufauture_chzn > div > div > input[type=text]"));
				String css_location_dropDownValue = "#ContentPlaceHolder1_ddlManufauture_chzn > div > div > input[type=text]";
				By ddlocator = By.cssSelector(css_location_dropDownValue);
				waitForExpectedElement(ddlocator);
				js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.Manufacture);
				GenericWrappers.sleepInSeconds(1);
				itemCodeValue.sendKeys(Keys.SPACE);
				itemCodeValue.sendKeys(Keys.SPACE);
				itemCodeValue.sendKeys(Keys.ARROW_DOWN);
				GenericWrappers.sleepInSeconds(1);
				itemCodeValue.sendKeys(Keys.ENTER);
               
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Origion)) {
				webDriver.findElement(By.cssSelector("div#ContentPlaceHolder1_ddlOrigin_chzn")).click();
				GenericWrappers.sleepInSeconds(1);
				//terPage.terminal_waitClearEnterText_css(icp.Vendor_String, Globals.Inventory.Vendor);
				WebElement itemCodeValue = webDriver.findElement(By.cssSelector("#ContentPlaceHolder1_ddlOrigin_chzn > div > div > input[type=text]"));
				String css_location_dropDownValue = "#ContentPlaceHolder1_ddlOrigin_chzn > div > div > input[type=text]";
				By ddlocator = By.cssSelector(css_location_dropDownValue);
				waitForExpectedElement(ddlocator);
				js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.Origion);
				GenericWrappers.sleepInSeconds(1);
				itemCodeValue.sendKeys(Keys.SPACE);
				itemCodeValue.sendKeys(Keys.SPACE);
				itemCodeValue.sendKeys(Keys.ARROW_DOWN);
				GenericWrappers.sleepInSeconds(1);
				itemCodeValue.sendKeys(Keys.ENTER);
               
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Category)) {
				webDriver.findElement(By.cssSelector("div#ContentPlaceHolder1_ddlCategory_chzn")).click();
				GenericWrappers.sleepInSeconds(1);
				//terPage.terminal_waitClearEnterText_css(icp.Vendor_String, Globals.Inventory.Vendor);
				WebElement itemCodeValue = webDriver.findElement(By.cssSelector("#ContentPlaceHolder1_ddlCategory_chzn > div > div > input[type=text]"));
				String css_location_dropDownValue = "#ContentPlaceHolder1_ddlCategory_chzn > div > div > input[type=text]";
				By ddlocator = By.cssSelector(css_location_dropDownValue);
				waitForExpectedElement(ddlocator);
				js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.Category);
				GenericWrappers.sleepInSeconds(1);
				itemCodeValue.sendKeys(Keys.SPACE);
				itemCodeValue.sendKeys(Keys.SPACE);
				itemCodeValue.sendKeys(Keys.ARROW_DOWN);
				GenericWrappers.sleepInSeconds(1);
				itemCodeValue.sendKeys(Keys.ENTER);
               
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Vendor)) {
				webDriver.findElement(By.cssSelector("div#ContentPlaceHolder1_ddlVendor_chzn")).click();
				GenericWrappers.sleepInSeconds(1);
				//terPage.terminal_waitClearEnterText_css(icp.Vendor_String, Globals.Inventory.Vendor);
				WebElement itemCodeValue = webDriver.findElement(By.cssSelector("#ContentPlaceHolder1_ddlVendor_chzn > div > div > input[type=text]"));
				String css_location_dropDownValue = "#ContentPlaceHolder1_ddlVendor_chzn > div > div > input[type=text]";
				By ddlocator = By.cssSelector(css_location_dropDownValue);
				waitForExpectedElement(ddlocator);
				js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.Vendor);
				GenericWrappers.sleepInSeconds(1);
				itemCodeValue.sendKeys(Keys.SPACE);
				itemCodeValue.sendKeys(Keys.SPACE);
				itemCodeValue.sendKeys(Keys.ARROW_DOWN);
				GenericWrappers.sleepInSeconds(1);
				itemCodeValue.sendKeys(Keys.ENTER);
               
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.WarehouseCode)) {
				webDriver.findElement(By.cssSelector("div#ContentPlaceHolder1_ddlWareHouse_chzn")).click();
				GenericWrappers.sleepInSeconds(1);
				//terPage.terminal_waitClearEnterText_css(icp.Vendor_String, Globals.Inventory.Vendor);
				WebElement itemCodeValue = webDriver.findElement(By.cssSelector("#ContentPlaceHolder1_ddlWareHouse_chzn > div > div > input[type=text]"));
				String css_location_dropDownValue = "#ContentPlaceHolder1_ddlWareHouse_chzn > div > div > input[type=text]";
				By ddlocator = By.cssSelector(css_location_dropDownValue);
				waitForExpectedElement(ddlocator);
				js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.WarehouseCode);
				GenericWrappers.sleepInSeconds(1);
				itemCodeValue.sendKeys(Keys.SPACE);
				itemCodeValue.sendKeys(Keys.SPACE);
				itemCodeValue.sendKeys(Keys.ARROW_DOWN);
				GenericWrappers.sleepInSeconds(1);
				itemCodeValue.sendKeys(Keys.ENTER);
               
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Merchandise)) {
				webDriver.findElement(By.cssSelector("div#ContentPlaceHolder1_ddlMerchandise_chzn")).click();
				GenericWrappers.sleepInSeconds(1);
				//terPage.terminal_waitClearEnterText_css(icp.Vendor_String, Globals.Inventory.Vendor);
				WebElement itemCodeValue = webDriver.findElement(By.cssSelector("#ContentPlaceHolder1_ddlMerchandise_chzn > div > div > input[type=text]"));
				String css_location_dropDownValue = "#ContentPlaceHolder1_ddlMerchandise_chzn > div > div > input[type=text]";
				By ddlocator = By.cssSelector(css_location_dropDownValue);
				waitForExpectedElement(ddlocator);
				js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.Merchandise);
				GenericWrappers.sleepInSeconds(1);
				itemCodeValue.sendKeys(Keys.SPACE);
				itemCodeValue.sendKeys(Keys.SPACE);
				itemCodeValue.sendKeys(Keys.ARROW_DOWN);
				GenericWrappers.sleepInSeconds(1);
				itemCodeValue.sendKeys(Keys.ENTER);
               
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.CCode)) {
				webDriver.findElement(By.cssSelector("div#ContentPlaceHolder1_ddlccode_chzn")).click();
				GenericWrappers.sleepInSeconds(1);
				//terPage.terminal_waitClearEnterText_css(icp.Vendor_String, Globals.Inventory.Vendor);
				WebElement itemCodeValue = webDriver.findElement(By.cssSelector("#ContentPlaceHolder1_ddlccode_chzn > div > div > input[type=text]"));
				String css_location_dropDownValue = "#ContentPlaceHolder1_ddlccode_chzn > div > div > input[type=text]";
				By ddlocator = By.cssSelector(css_location_dropDownValue);
				waitForExpectedElement(ddlocator);
				js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.CCode);
				GenericWrappers.sleepInSeconds(1);
				itemCodeValue.sendKeys(Keys.SPACE);
				itemCodeValue.sendKeys(Keys.SPACE);
				itemCodeValue.sendKeys(Keys.ARROW_DOWN);
				GenericWrappers.sleepInSeconds(1);
				itemCodeValue.sendKeys(Keys.ENTER);
               
			}if (GenericWrappers.isNotEmpty(Globals.Inventory.Taxcode)) {
				webDriver.findElement(By.cssSelector("div#ContentPlaceHolder1_ddlVat_chzn")).click();
				GenericWrappers.sleepInSeconds(1);
				//terPage.terminal_waitClearEnterText_css(icp.Vendor_String, Globals.Inventory.Vendor);
				WebElement itemCodeValue = webDriver.findElement(By.cssSelector("#ContentPlaceHolder1_ddlVat_chzn > div > div > input[type=text]"));
				String css_location_dropDownValue = "#ContentPlaceHolder1_ddlVat_chzn > div > div > input[type=text]";
				By ddlocator = By.cssSelector(css_location_dropDownValue);
				waitForExpectedElement(ddlocator);
				js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.Taxcode);
				GenericWrappers.sleepInSeconds(1);
				itemCodeValue.sendKeys(Keys.SPACE);
				itemCodeValue.sendKeys(Keys.SPACE);
				itemCodeValue.sendKeys(Keys.ARROW_DOWN);
				GenericWrappers.sleepInSeconds(1);
				itemCodeValue.sendKeys(Keys.ENTER);
               
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Floorcode)) {
				webDriver.findElement(By.cssSelector("div#ContentPlaceHolder1_ddlFloor_chzn")).click();
				GenericWrappers.sleepInSeconds(1);
				//terPage.terminal_waitClearEnterText_css(icp.Vendor_String, Globals.Inventory.Vendor);
				WebElement itemCodeValue = webDriver.findElement(By.cssSelector("#ContentPlaceHolder1_ddlFloor_chzn > div > div > input[type=text]"));
				String css_location_dropDownValue = "#ContentPlaceHolder1_ddlFloor_chzn > div > div > input[type=text]";
				By ddlocator = By.cssSelector(css_location_dropDownValue);
				waitForExpectedElement(ddlocator);
				js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.Floorcode);
				GenericWrappers.sleepInSeconds(1);
				itemCodeValue.sendKeys(Keys.SPACE);
				itemCodeValue.sendKeys(Keys.SPACE);
				itemCodeValue.sendKeys(Keys.ARROW_DOWN);
				GenericWrappers.sleepInSeconds(1);
				itemCodeValue.sendKeys(Keys.ENTER);
               
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Bin)) {
				webDriver.findElement(By.cssSelector("div#ContentPlaceHolder1_ddlBin_chzn")).click();
				GenericWrappers.sleepInSeconds(1);
				//terPage.terminal_waitClearEnterText_css(icp.Vendor_String, Globals.Inventory.Vendor);
				WebElement itemCodeValue = webDriver.findElement(By.cssSelector("#ContentPlaceHolder1_ddlBin_chzn > div > div > input[type=text]"));
				String css_location_dropDownValue = "#ContentPlaceHolder1_ddlBin_chzn > div > div > input[type=text]";
				By ddlocator = By.cssSelector(css_location_dropDownValue);
				waitForExpectedElement(ddlocator);
				js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.Bin);
				GenericWrappers.sleepInSeconds(1);
				itemCodeValue.sendKeys(Keys.SPACE);
				itemCodeValue.sendKeys(Keys.SPACE);
				itemCodeValue.sendKeys(Keys.ARROW_DOWN);
				GenericWrappers.sleepInSeconds(1);
				itemCodeValue.sendKeys(Keys.ENTER);
               
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Uomcode)) {
				webDriver.findElement(By.cssSelector("div#ContentPlaceHolder1_ddluompurchase_chzn")).click();
				GenericWrappers.sleepInSeconds(1);
				//terPage.terminal_waitClearEnterText_css(icp.Vendor_String, Globals.Inventory.Vendor);
				WebElement itemCodeValue = webDriver.findElement(By.cssSelector("#ContentPlaceHolder1_ddluompurchase_chzn > div > div > input[type=text]"));
				String css_location_dropDownValue = "#ContentPlaceHolder1_ddluompurchase_chzn > div > div > input[type=text]";
				By ddlocator = By.cssSelector(css_location_dropDownValue);
				waitForExpectedElement(ddlocator);
				js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.Uomcode);
				GenericWrappers.sleepInSeconds(1);
				itemCodeValue.sendKeys(Keys.SPACE);
				itemCodeValue.sendKeys(Keys.SPACE);
				itemCodeValue.sendKeys(Keys.ARROW_DOWN);
				GenericWrappers.sleepInSeconds(1);
				itemCodeValue.sendKeys(Keys.ENTER);
               
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.StockType)) {
				webDriver.findElement(By.cssSelector("div#ContentPlaceHolder1_ddlstocktype_chzn")).click();
				GenericWrappers.sleepInSeconds(1);
				//terPage.terminal_waitClearEnterText_css(icp.Vendor_String, Globals.Inventory.Vendor);
				WebElement itemCodeValue = webDriver.findElement(By.cssSelector("#ContentPlaceHolder1_ddlstocktype_chzn > div > div > input[type=text]"));
				String css_location_dropDownValue = "#ContentPlaceHolder1_ddlstocktype_chzn > div > div > input[type=text]";
				By ddlocator = By.cssSelector(css_location_dropDownValue);
				waitForExpectedElement(ddlocator);
				js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.StockType);
				GenericWrappers.sleepInSeconds(1);
				itemCodeValue.sendKeys(Keys.SPACE);
				itemCodeValue.sendKeys(Keys.SPACE);
				itemCodeValue.sendKeys(Keys.ARROW_DOWN);
				GenericWrappers.sleepInSeconds(1);
				itemCodeValue.sendKeys(Keys.ENTER);
               
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Package)) {
				   terPage.terminal_waitClearEnterText_css(icp.Package_String, Globals.Inventory.Package);
			
             }
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Section)) {
				webDriver.findElement(By.cssSelector("div#ContentPlaceHolder1_ddlSection_chzn")).click();
				GenericWrappers.sleepInSeconds(1);
				//terPage.terminal_waitClearEnterText_css(icp.Vendor_String, Globals.Inventory.Vendor);
				WebElement itemCodeValue = webDriver.findElement(By.cssSelector("#ContentPlaceHolder1_ddlSection_chzn > div > div > input[type=text]"));
				String css_location_dropDownValue = "#ContentPlaceHolder1_ddlSection_chzn > div > div > input[type=text]";
				By ddlocator = By.cssSelector(css_location_dropDownValue);
				waitForExpectedElement(ddlocator);
				js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.Section);
				GenericWrappers.sleepInSeconds(1);
				itemCodeValue.sendKeys(Keys.SPACE);
				itemCodeValue.sendKeys(Keys.SPACE);
				itemCodeValue.sendKeys(Keys.ARROW_DOWN);
				GenericWrappers.sleepInSeconds(1);
				itemCodeValue.sendKeys(Keys.ENTER);
               
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Shelf)) {
				webDriver.findElement(By.cssSelector("div#ContentPlaceHolder1_ddlShelf_chzn")).click();
				GenericWrappers.sleepInSeconds(1);
				//terPage.terminal_waitClearEnterText_css(icp.Vendor_String, Globals.Inventory.Vendor);
				WebElement itemCodeValue = webDriver.findElement(By.cssSelector("#ContentPlaceHolder1_ddlShelf_chzn > div > div > input[type=text]"));
				String css_location_dropDownValue = "#ContentPlaceHolder1_ddlShelf_chzn > div > div > input[type=text]";
				By ddlocator = By.cssSelector(css_location_dropDownValue);
				waitForExpectedElement(ddlocator);
				js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.Shelf);
				GenericWrappers.sleepInSeconds(1);
				itemCodeValue.sendKeys(Keys.SPACE);
				itemCodeValue.sendKeys(Keys.SPACE);
				itemCodeValue.sendKeys(Keys.ARROW_DOWN);
				GenericWrappers.sleepInSeconds(1);
				itemCodeValue.sendKeys(Keys.ENTER);
               
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.SalesUOM)) {
				webDriver.findElement(By.cssSelector("div#ContentPlaceHolder1_ddlSales_chzn")).click();
				GenericWrappers.sleepInSeconds(1);
				//terPage.terminal_waitClearEnterText_css(icp.Vendor_String, Globals.Inventory.Vendor);
				WebElement itemCodeValue = webDriver.findElement(By.cssSelector("#ContentPlaceHolder1_ddlSales_chzn > div > div > input[type=text]"));
				String css_location_dropDownValue = "#ContentPlaceHolder1_ddlSales_chzn > div > div > input[type=text]";
				By ddlocator = By.cssSelector(css_location_dropDownValue);
				waitForExpectedElement(ddlocator);
				js_typeIntoDropDownSearchBox(css_location_dropDownValue, Globals.Inventory.SalesUOM);
				GenericWrappers.sleepInSeconds(1);
				itemCodeValue.sendKeys(Keys.SPACE);
				itemCodeValue.sendKeys(Keys.SPACE);
				itemCodeValue.sendKeys(Keys.ARROW_DOWN);
				GenericWrappers.sleepInSeconds(1);
				itemCodeValue.sendKeys(Keys.ENTER);
               
			}
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch)) {
		        terPage.get_checkBox_element(icp.Batch_String).click();

	        }
			if (GenericWrappers.isNotEmpty(Globals.Inventory.Batch1)) {
		        terPage.get_checkBox_element(icp.Batch1_String).click();

	        }
			
	}
		@Then("I close connection to Style")
		public void I_close_connection_to_Style() throws SQLException {

			mysqlConnect.disconnect();
			System.out.println(" closed succesfully");

		}

		MssqlConnect mysqlConnect;
		Statement st;

		@Then("I establish connection to Style")
		public void I_establish_connection_to_Style() throws SQLException {

			mysqlConnect = new MssqlConnect();
			st = mysqlConnect.connect().createStatement();
			System.out.println(" Connected succesfully");

		}

		@Given("I read the values from table {string} in Style")
		public void i_want_to_launch_the(String tablename) throws SQLException, IOException {

			ResultSet rs = st.executeQuery("select * from " + tablename + " where StyleCode='5'");

			System.out.println(rs);

			while (rs.next()) {

				switch (tablename) {
				case "tblInventoryStyle":
					String StyleCode = "";
					try {
						StyleCode = rs.getString("StyleCode");
						System.out.println(StyleCode);
						Assert.assertEquals(Globals.Inventory.StyleCode.trim(), StyleCode.trim());
						pass.Excelcreate("style", "tblInventoryStyle", "", 0, 0, 0, 0);
						pass.ExcelFourData("style", "StyleCode", Globals.Inventory.StyleCode, StyleCode, "Pass", 1, 0, 1, 1,
								1, 2, 1, 3);
					} catch (AssertionError e) {
						pass.Excelcreate("style", "tblInventoryStyle", "", 0, 0, 0, 0);
						pass.ExcelFourData("style", "StyleCode", Globals.Inventory.StyleCode, StyleCode, "Fail", 1, 0, 1, 1,
								1, 2, 1, 3);

					}
					
					String Description = "";
					try {
						Description = rs.getString("Description");
						System.out.println(Description);
						Assert.assertEquals(Globals.Inventory.Description.trim(), Description.trim());

						pass.ExcelFourData("style", "Description", Globals.Inventory.Description, Description, "Pass", 2, 0, 2, 1,
								2, 2, 2, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("style", "Description", Globals.Inventory.Description, Description, "Fail", 2, 0, 2, 1,
								2, 2, 2, 3);

					}
					String Brand = "";
					try {
						Brand = rs.getString("BrandCode");
						System.out.println(Brand);
						Assert.assertEquals(Globals.Inventory.Brand.trim(), Brand.trim());
						//pass.Excelcreate("style", "tblInventoryStyle", "", 1, 0, 1, 1);
						pass.ExcelFourData("style", "Brand", Globals.Inventory.Brand, Brand, "Pass",3, 0,
								3, 1, 3, 2, 3, 3);
					} catch (AssertionError e) {
						//pass.Excelcreate("style", "tblInventoryStyle", "", 1, 0, 1, 1);
						pass.ExcelFourData("style", "Brand", Globals.Inventory.Brand, Brand, "Fail", 3, 0,
								3, 1, 3, 2, 3, 3);

					}
					String Manufacture = "";
					try {
						Manufacture = rs.getString("Manufacturer");
						System.out.println(Manufacture);
						Assert.assertEquals(Globals.Inventory.Manufacture.trim(), Manufacture.trim());
						
						pass.ExcelFourData("style", "Manufacture", Globals.Inventory.Manufacture, Manufacture, "Pass",4, 0,
								4, 1, 4, 2, 4, 3);
					} catch (AssertionError e) {
						
						pass.ExcelFourData("style", "Manufacture", Globals.Inventory.Manufacture, Manufacture, "Fail", 4, 0,
								4, 1, 4, 2, 4, 3);

					}
				
					String ItemType = "";
					try {
						ItemType = rs.getString("ItemType");
						System.out.println(ItemType);
						Assert.assertEquals(Globals.Inventory.ItemType.trim(), ItemType.trim());

						pass.ExcelFourData("style", "ItemType", Globals.Inventory.ItemType, ItemType, "Pass", 5,
								0, 5, 1, 5, 2, 5, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("style", "ItemType", Globals.Inventory.ItemType, ItemType, "Fail", 5, 0,
								5, 1, 5, 2, 5, 3);

					}
					
					String Origion = "";
					try {
						Description = rs.getString("Origin");
						System.out.println(Origion);
						Assert.assertEquals(Globals.Inventory.Origion.trim(), Origion.trim());

						pass.ExcelFourData("style", "Origion", Globals.Inventory.Origion, Origion, "Pass", 8,
								0, 8, 1, 8, 2, 8, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("style", "Origion", Globals.Inventory.Origion, Origion, "Fail", 8, 0,
								8, 1, 8, 2, 8, 3);

					}
					String Category = "";
					try {
						Category = rs.getString("Categorycode");
						System.out.println(Category);
						Assert.assertEquals(Globals.Inventory.Category.trim(), Category.trim());

						pass.ExcelFourData("style", "Category", Globals.Inventory.Category, Category, "Pass", 9,
								0, 9, 1, 9, 2, 9, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("style", "Category", Globals.Inventory.Category, Category, "Fail", 9, 0,
								9, 1, 9, 2, 9, 3);

					}
					String Vendor = "";
					try {
						Vendor = rs.getString("VendorCode");
						System.out.println(Vendor);
						Assert.assertEquals(Globals.Inventory.Vendor.trim(), Vendor.trim());

						pass.ExcelFourData("style", "Vendor", Globals.Inventory.Vendor, Vendor, "Pass", 10,
								0, 10, 1, 10, 2, 10, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("style", "Vendor", Globals.Inventory.Vendor, Vendor, "Fail", 10, 0,
								10, 1, 10, 2, 10, 3);

					}
					String WarehouseCode = "";
					try {
						WarehouseCode = rs.getString("Warehouse");
						System.out.println(WarehouseCode);
						Assert.assertEquals(Globals.Inventory.WarehouseCode.trim(), WarehouseCode.trim());

						pass.ExcelFourData("style", "WarehouseCode", Globals.Inventory.WarehouseCode, WarehouseCode, "Pass", 11,
								0, 11, 1, 11, 2, 11, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("style", "WarehouseCode", Globals.Inventory.WarehouseCode, WarehouseCode, "Fail", 11, 0,
								11, 1, 11, 2, 11, 3);

					}
					String Merchandise = "";
					try {
						Merchandise = rs.getString("MerchandiseCode");
						System.out.println(Merchandise);
						Assert.assertEquals(Globals.Inventory.Merchandise.trim(), Merchandise.trim());

						pass.ExcelFourData("style", "Merchandise", Globals.Inventory.Merchandise, Merchandise, "Pass", 12,
								0, 12, 1, 12, 2, 12, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("style", "Merchandise", Globals.Inventory.Merchandise, Merchandise, "Fail", 12, 0,
								12, 1, 12, 2, 12, 3);

					}
					String CCode = "";
					try {
						CCode = rs.getString("companyCode");
						System.out.println(CCode);
						Assert.assertEquals(Globals.Inventory.CCode.trim(), CCode.trim());

						pass.ExcelFourData("style", "CCode", Globals.Inventory.CCode, CCode, "Pass", 13,
								0, 13, 1, 13, 2, 13, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("style", "CCode", Globals.Inventory.CCode, CCode, "Fail", 13, 0,
								13, 1, 13, 2, 13, 3);

					}
					String Taxcode = "";
					try {
						Taxcode = rs.getString("Tax");
						System.out.println(Taxcode);
						Assert.assertEquals(Globals.Inventory.Taxcode.trim(), Taxcode.trim());

						pass.ExcelFourData("style", "Taxcode", Globals.Inventory.Taxcode, Taxcode, "Pass", 14,
								0, 14, 1, 14, 2, 14, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("style", "Taxcode", Globals.Inventory.Taxcode, Taxcode, "Fail", 14, 0,
								14, 1, 14, 2, 14, 3);

					}
					String Bin = "";
					try {
						Bin = rs.getString("BinNo");
						System.out.println(Bin);
						Assert.assertEquals(Globals.Inventory.Bin.trim(), Bin.trim());

						pass.ExcelFourData("style", "Bin", Globals.Inventory.Bin, Bin, "Pass", 15,
								0, 15, 1, 15, 2, 15, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("style", "Bin", Globals.Inventory.Bin, Bin, "Fail", 15, 0,
								15, 1, 15, 2, 15, 3);

					}
					String Floorcode = "";
					try {
						Floorcode = rs.getString("Floor");
						System.out.println(Floorcode);
						Assert.assertEquals(Globals.Inventory.Floorcode.trim(), Floorcode.trim());

						pass.ExcelFourData("style", "Floorcode", Globals.Inventory.Floorcode, Floorcode, "Pass", 16,
								0, 16, 1, 16, 2, 16, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("style", "Floorcode", Globals.Inventory.Floorcode, Floorcode, "Fail", 16, 0,
								16, 1, 16, 2, 16, 3);

					}
					String Uomcode = "";
					try {
						Uomcode = rs.getString("Uom");
						System.out.println(Uomcode);
						Assert.assertEquals(Globals.Inventory.Uomcode.trim(), Uomcode.trim());

						pass.ExcelFourData("style", "Uomcode", Globals.Inventory.Uomcode, Uomcode, "Pass", 17,
								0, 17, 1, 17, 2, 17, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("style", "Uomcode", Globals.Inventory.Uomcode, Uomcode, "Fail", 17, 0,
								17, 1, 17, 2, 17, 3);

					}
					String StockType = "";
					try {
						StockType = rs.getString("StockType");
						System.out.println(StockType);
						Assert.assertEquals(Globals.Inventory.StockType.trim(), StockType.trim());

						pass.ExcelFourData("style", "StockType", Globals.Inventory.StockType, StockType, "Pass", 18,
								0, 18, 1, 18, 2, 18, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("style", "StockType", Globals.Inventory.StockType, StockType, "Fail", 18, 0,
								18, 1, 18, 2, 18, 3);

					}
					String Package = "";
					try {
						Package = rs.getString("PackageItem");
						System.out.println(Package);
						Assert.assertEquals(Globals.Inventory.Package.trim(), Package.trim());

						pass.ExcelFourData("style", "Package", Globals.Inventory.Package, Package, "Pass", 19,
								0, 19, 1, 19, 2, 19, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("style", "Package", Globals.Inventory.Package, Package, "Fail", 19, 0,
								19, 1, 19, 2, 19, 3);

					}
					String Section = "";
					try {
						Section = rs.getString("FSection");
						System.out.println(Section);
						Assert.assertEquals(Globals.Inventory.Section.trim(), Section.trim());

						pass.ExcelFourData("style", "Section", Globals.Inventory.Section, Section, "Pass", 20,
								0, 20, 1, 20, 2, 20, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("style", "Section", Globals.Inventory.Section, Section, "Fail", 20, 0,
								20, 1, 20, 2, 20, 3);

					}
					String Shelf = "";
					try {
						Shelf = rs.getString("Shelf");
						System.out.println(Shelf);
						Assert.assertEquals(Globals.Inventory.Shelf.trim(), Shelf.trim());

						pass.ExcelFourData("style", "Shelf", Globals.Inventory.Shelf, Shelf, "Pass", 21,
								0, 21, 1, 21, 2, 21, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("style", "Shelf", Globals.Inventory.Shelf, Shelf, "Fail", 21, 0,
								21, 1, 21, 2, 21, 3);

					}
					
					String Batch = "";
					try {
						Batch = rs.getString("Batch");
						System.out.println(Batch);
						Assert.assertEquals(Globals.Inventory.Batch.trim(), Batch.trim());

						pass.ExcelFourData("style", "Batch", Globals.Inventory.Batch, Batch, "Pass", 23,
								0, 23, 1, 23, 2, 23, 3);

					} catch (AssertionError e) {

						pass.ExcelFourData("style", "Batch", Globals.Inventory.Batch, Batch, "Fail", 23, 0,
								23, 1, 23, 2, 23, 3);

					}
					
					

					break;
				}
			}
		}
	}




	



