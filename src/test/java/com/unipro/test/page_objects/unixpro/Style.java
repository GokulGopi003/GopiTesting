package com.unipro.test.page_objects.unixpro;

	import org.openqa.selenium.By;
    import org.openqa.selenium.Keys;
    import org.openqa.selenium.WebElement;
    import com.unipro.test.framework.Globals;
import com.unipro.test.framework.PageObject;
import com.unipro.test.framework.helpers.utils.GenericWrappers;
	import com.unipro.test.framework.helpers.utils.ReadTestData;
	import cucumber.api.java.en.Then;

	public class Style extends PageObject {
		AddInventoryFormPage Category;
		Stylefield icp;
		TerminalPage terPage;

		public  Style(Stylefield  icp) {
			this.icp = icp;
			terPage = new TerminalPage();
			Category = new AddInventoryFormPage();
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
	
}


