package com.unipro.test.page_objects.unixpro;

import org.openqa.selenium.By;

import com.unipro.test.framework.PageObject;

public class DayBasedPromotionField extends PageObject {
	public String Vendor_String = "input#ContentPlaceHolder1_searchFilterUserControl_txtVendor";
	public String Department_String = "input#ContentPlaceHolder1_searchFilterUserControl_txtDepartment";
	public String Category_String = "input#ContentPlaceHolder1_searchFilterUserControl_txtCategory";
	public String Brand_String = "input#ContentPlaceHolder1_searchFilterUserControl_txtBrand";
	public String SubCategory_String = "input#ContentPlaceHolder1_searchFilterUserControl_txtSubCategory";
	public String Merchandise_String = "input#ContentPlaceHolder1_searchFilterUserControl_txtMerchandise";
	public String Manufacture_String = "input#ContentPlaceHolder1_searchFilterUserControl_txtManufacture";
	public String Floorcode_String = "input#ContentPlaceHolder1_searchFilterUserControl_txtFloor";
	public String Section_String = "input#ContentPlaceHolder1_searchFilterUserControl_txtSection";
	public String Bin_String = "input#ContentPlaceHolder1_searchFilterUserControl_txtBin";
	public String ShelfCode_String = "input#ContentPlaceHolder1_searchFilterUserControl_txtShelf";
	public String ItemCode_String = "input#ContentPlaceHolder1_searchFilterUserControl_txtItemCode";
	public String ItemName_String = "input#ContentPlaceHolder1_searchFilterUserControl_txtItemName";
	public String Barcode_String = "input#ContentPlaceHolder1_searchFilterUserControl_txtBarcode";
	public String Batch_String = "input#ContentPlaceHolder1_chIntime";
	public String Batch1_String = "input#ContentPlaceHolder1_cbSelectAll";
	public String Batch2_String = "input#ContentPlaceHolder1_chSelectAllGrid";
	public String Description_String = "textarea#ContentPlaceHolder1_txtPromoDescription";
	public String FromDate_String = "input#ContentPlaceHolder1_txtFromDate";
	public String ToDate_String = "input#ContentPlaceHolder1_txtToDate";
	public String FromTime_String = "input#ContentPlaceHolder1_txtFromtime";
	public String ToTime_String = "input#ContentPlaceHolder1_txtTotime";
	public String Days_String = "div#ContentPlaceHolder1_lstDays_chzn";
	public String Discount_String = "input#ContentPlaceHolder1_txtDiscount";
	public String Billno_String = "input#ContentPlaceHolder1_txtSearch";
	
	public void search_dd_valuefordaybasedpromotion(String textToType) {

		switch (textToType) {
		case "Sunday":
			waitForExpectedElement(By.cssSelector("li#ContentPlaceHolder1_lstDays_chzn_o_0.active-result"))
					.click();

			break;
		case "Monday":
			waitForExpectedElement(By.cssSelector("li#ContentPlaceHolder1_lstDays_chzn_o_1.active-result"))
					.click();

			break;
		case "Tuesday":
			waitForExpectedElement(By.cssSelector("li#ContentPlaceHolder1_lstDays_chzn_o_2.active-result"))
					.click();

			break;
			
		case "Wednesday":
			waitForExpectedElement(By.cssSelector("li#ContentPlaceHolder1_lstDays_chzn_o_3.active-result"))
					.click();

			break;
			
		case "Thursday":
			waitForExpectedElement(By.cssSelector("li#ContentPlaceHolder1_lstDays_chzn_o_4.active-result"))
					.click();

			break;
			
		case "Friday":
			waitForExpectedElement(By.cssSelector("li#ContentPlaceHolder1_lstDays_chzn_o_5.active-result"))
					.click();

			break;
		case "Saturday":
			waitForExpectedElement(By.cssSelector("li#ContentPlaceHolder1_lstDays_chzn_o_6.active-result"))
					.click();

			break;

		default:
			break;
		}
	}

}
