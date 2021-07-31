package com.unipro.test.page_objects.unixpro;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;


import com.unipro.test.framework.PageObject;
import com.unipro.test.framework.helpers.utils.GenericWrappers;

public class InventoryCalculationsPage extends PageObject {

	
	public double Basic_Cost = 0.00;
	public double Net_Cost = 0.00;
	public double Gross_Cost = 0.00;
	public double Basic_Selling = 0.00;
	public double NetSellingPrice = 0.00;
	public double WPrice1 = 0.00;
	public double WPrice2 = 0.00;
	public double WPrice3 = 0.00;
	public boolean hasRoundOff = false;
	double intermediateBasicCost = 0.0;
	double roundoff_vlaue = 0.0;

	// new inventory
	
	
	public String Category_String = "input#ContentPlaceHolder1_txtInvcategory.form-control-res";
	public String Department_String = "input#ContentPlaceHolder1_txtDepartment.form-control-res";
	public String Brand_String = "input#ContentPlaceHolder1_txtBrand.form-control-res";
	public String ItemName_String = "input#ContentPlaceHolder1_txtItemName.form-control-res.ui-autocomplete-input";
	public String ShortName_String = "input#ContentPlaceHolder1_txtShortName.form-control-res";
	public String ItemType_String = "input#ContentPlaceHolder1_txtItemType.form-control-res";
	public String Vendor_String = "input#ContentPlaceHolder1_txtVendor.form-control-res";
	public String UOMPurchase_String = "input#ContentPlaceHolder1_txtUOMPurchase.form-control-res";
	public String StockType_String = "input#ContentPlaceHolder1_txtStockType.form-control-res";
	public String SalesUOM_String = "input#ContentPlaceHolder1_txtSalesUOM.form-control-res";
	public String Batch_String = "input#ContentPlaceHolder1_chkBatch";
	
	//non mandatory fields
	public String Remarks_String = "input#ContentPlaceHolder1_txtRemarks.form-control-res";
	public String WareHouse_String = "input#ContentPlaceHolder1_txtWareHouse.form-control-res";
	public String Manufacture_String = "input#ContentPlaceHolder1_txtManafacture.form-control-res";
	public String Merchandise_String = "input#ContentPlaceHolder1_txtMerchandise.form-control-res";
	public String Style_String = "input#ContentPlaceHolder1_txtStyle.form-control-res";
	public String Size_String = "input#ContentPlaceHolder1_txtSize.form-control-res";
	public String ModelNo_String = "input#ContentPlaceHolder1_txtModelNo.form-control-res";
	public String Origin_String = "input#ContentPlaceHolder1_txtOrigin.form-control-res";
	public String SubCategory_String = "input#ContentPlaceHolder1_txtSubCategory.form-control-res";
	public String Package_String = "input#ContentPlaceHolder1_txtPackage.form-control-res";
	public String CCode_String = "input#ContentPlaceHolder1_txtCCode.form-control-res";
	public String Class_String = "input#ContentPlaceHolder1_txtClass.form-control-res";
	public String SubClass_String = "input#ContentPlaceHolder1_txtSubClass.form-control-res";
	public String Bin_String = "input#ContentPlaceHolder1_txtBin.form-control-res";
	public String Section_String = "input#ContentPlaceHolder1_txtSection.form-control-res";
	public String Shelf_String = "input#ContentPlaceHolder1_txtShelf.form-control-res";
	public String Weight_String = "input#ContentPlaceHolder1_txtWeight.form-control-res-right";
	public String Height_String = "input#ContentPlaceHolder1_txtHeight.form-control-res-right";
	public String Width_String = "input#ContentPlaceHolder1_txtWidth.form-control-res-right";
	public String Length_String = "input#ContentPlaceHolder1_txtLength.form-control-res-right";
	
	
	//public By MRP_By = By.cssSelector(MRP_String);
	
	
	public String Basic_Cost_String = "input#ContentPlaceHolder1_txtBasicCost";
	public By Basic_Cost_text = By.cssSelector(Basic_Cost_String);

	public String MRP_String = "input#ContentPlaceHolder1_txtMRP";
	public By MRP_By = By.cssSelector(MRP_String);
	
	public String Cess_String = "input#ContentPlaceHolder1_txtCESSPrc.form-control-res.text-right";
	public By Cess_By = By.cssSelector(Cess_String);
	
	public String AdlCsAmt_String = "input#ContentPlaceHolder1_txtAddCessAmt.form-control-res.text-right";
	public By AdlCsAmt_By = By.cssSelector(AdlCsAmt_String);

	public By Net_Cost_text = By.cssSelector("input#ContentPlaceHolder1_txtNetCost");
	public By Gross_Cost_text = By.cssSelector("input#ContentPlaceHolder1_txtGrossCost");
	public By Basic_Selling_text = By.cssSelector("input#ContentPlaceHolder1_txtBasicSelling");
	public By NetSellingPrice_text = By.cssSelector("input#ContentPlaceHolder1_txtSellingPrice");
	//public By WPrice1_text = By.cssSelector("input#ContentPlaceHolder1_txtWholePrice1Popup");
	//public By WPrice2_text = By.cssSelector("input#ContentPlaceHolder1_txtWholePrice2Popup");
	//public By WPrice3_text = By.cssSelector("input#ContentPlaceHolder1_txtWholePrice3Popup");
	
	public String WPrice1_String = "input#ContentPlaceHolder1_txtMarginWPrice1.form-control-res.text_right";
	public String WPrice2_String = "input#ContentPlaceHolder1_txtMarginWPrice2.form-control-res.text_right";
	public String WPrice3_String = "input#ContentPlaceHolder1_txtMarginWPrice3.form-control-res.text_right";
	
	public By WPrice1_text = By.cssSelector(WPrice1_String);
	public By WPrice2_text = By.cssSelector(WPrice2_String);
	public By WPrice3_text = By.cssSelector(WPrice3_String);
	
	public String SP_String = "input#ContentPlaceHolder1_txtFixedMargin";
	public By SP_text = By.cssSelector(SP_String);

	public String Discount1_String = "input#ContentPlaceHolder1_txtDiscountPrc1";
	public String Discount2_String = "input#ContentPlaceHolder1_txtDiscountPrc2";
	public String Discount3_String = "input#ContentPlaceHolder1_txtDiscountPrc3";
	public By Discount1_text = By.cssSelector(Discount1_String);
	public By Discount2_text = By.cssSelector(Discount2_String);
	public By Discount3_text = By.cssSelector(Discount3_String);
	public String dd_element_string = "div.chzn-search";
	public By dd_element_value = By.cssSelector(dd_element_string);
	
	public String Discount_String = "input#ContentPlaceHolder1_txtMRPMarkDown";
	public By Discount_text = By.cssSelector(Discount_String);
	
	public String AddDiscountPer_String = "input#ContentPlaceHolder1_txtAdDiscount";
	public By AddDiscountPer_text = By.cssSelector(Discount_String);

	public double getTextValue(By by) {

		WebElement element = waitForExpectedElement(by);
		String cost = element.getAttribute("value");
		return Double.parseDouble(cost);

	}

	public void setTextValue_Decimal(String by, String inputText) {
		WebElement element = waitForExpectedElement(By.cssSelector(by));

		GenericWrappers.sleepInSeconds(4);
		js_typeIntoDropDownSearchBox(by, inputText);
		String[] sliceDecimal = inputText.split("\\.");

		GenericWrappers.sleepInSeconds(4);

		pressArrowKey(sliceDecimal[1].length(), element);

		setValueBasedOnNumberPad(element, sliceDecimal[1]);

	}

	public void pressArrowKey(int noOfpress, WebElement element) {
		System.out.println("no press" + noOfpress);

		for (int i = 0; i < noOfpress; i++) {

			element.sendKeys(Keys.ARROW_LEFT);
			GenericWrappers.sleepInSeconds(1);
		}

	}

	public void setTextValue(String by, String inputText) {
		WebElement element = waitForExpectedElement(By.cssSelector(by));

		js_typeIntoDropDownSearchBox(by, inputText);
		GenericWrappers.sleepInSeconds(4);
		pressArrowKey(inputText.length(), element);

		element.sendKeys(Keys.NUMPAD0);
		GenericWrappers.sleepInSeconds(2);

		element.sendKeys(Keys.ENTER);

		// setValueBasedOnNumberPad(element, inputText);

	}

	public void search_dd_value(String textToType) {

		switch (textToType) {
		case "0":
			waitForExpectedElement(By.cssSelector("li#ContentPlaceHolder1_ddlInputIGST_chzn_o_1.active-result"))
					.click();

			break;
		case "3":
			waitForExpectedElement(By.cssSelector("li#ContentPlaceHolder1_ddlInputIGST_chzn_o_2.active-result"))
					.click();

			break;
		case "5":
			waitForExpectedElement(By.cssSelector("li#ContentPlaceHolder1_ddlInputIGST_chzn_o_3.active-result"))
					.click();

			break;
			
		case "12":
			waitForExpectedElement(By.cssSelector("li#ContentPlaceHolder1_ddlInputIGST_chzn_o_4.active-result"))
					.click();

			break;
			
		case "18":
			waitForExpectedElement(By.cssSelector("li#ContentPlaceHolder1_ddlInputIGST_chzn_o_5.active-result"))
					.click();

			break;
			
		case "28":
			waitForExpectedElement(By.cssSelector("li#ContentPlaceHolder1_ddlInputIGST_chzn_o_6.active-result"))
					.click();

			break;

		default:
			break;
		}

	}
	
	//check and click cost, MRP1, MRP2, MRP3, MRP4
	public void clickPurchasedByRadioButton(String purchaseText) {
		
		if(purchaseText.equalsIgnoreCase("cost1")) {
			waitForExpectedElement(By.cssSelector("input#ContentPlaceHolder1_rbtCost")).click();
		} else if(purchaseText.equalsIgnoreCase("mrp1")) {
			waitForExpectedElement(By.cssSelector("input#ContentPlaceHolder1_rbtMRP")).click();
		} else if(purchaseText.equalsIgnoreCase("mrp2")) {
			waitForExpectedElement(By.cssSelector("input#ContentPlaceHolder1_rbnMRP2")).click();
		} else if(purchaseText.equalsIgnoreCase("mrp3")) {
			waitForExpectedElement(By.cssSelector("input#ContentPlaceHolder1_rbnMRP3")).click();
		} else if(purchaseText.equalsIgnoreCase("mrp4")) {
			waitForExpectedElement(By.cssSelector("input#ContentPlaceHolder1_rbnMRP4")).click();
		} 

	}

	public void setValueBasedOnNumberPad(WebElement element, String inputText) {

		System.err.println(inputText);
		char[] inputarray = inputText.toCharArray();
		for (int i = 0; i < inputarray.length; i++) {

			switch (inputarray[i]) {

			case '0':
				element.sendKeys(Keys.NUMPAD0);
				GenericWrappers.sleepInSeconds(2);
				break;

			case '1':
				element.sendKeys(Keys.NUMPAD1);
				GenericWrappers.sleepInSeconds(2);

				break;
			case '2':
				element.sendKeys(Keys.NUMPAD2);
				GenericWrappers.sleepInSeconds(2);
				break;

			case '3':
				element.sendKeys(Keys.NUMPAD3);
				GenericWrappers.sleepInSeconds(2);

				break;

			case '4':
				element.sendKeys(Keys.NUMPAD4);
				GenericWrappers.sleepInSeconds(2);

				break;
			case '5':
				element.sendKeys(Keys.NUMPAD5);
				GenericWrappers.sleepInSeconds(2);

				break;

			case '6':
				element.sendKeys(Keys.NUMPAD6);
				GenericWrappers.sleepInSeconds(2);

				break;

			case '7':
				element.sendKeys(Keys.NUMPAD7);
				GenericWrappers.sleepInSeconds(2);

				break;

			case '8':
				element.sendKeys(Keys.NUMPAD8);
				GenericWrappers.sleepInSeconds(2);

				break;

			case '9':
				element.sendKeys(Keys.NUMPAD9);
				GenericWrappers.sleepInSeconds(2);

				break;
			default:
				System.err.println(i);
				break;
			}
		}

		GenericWrappers.sleepInSeconds(4);
		element.sendKeys(Keys.ENTER);
	}

	public void roundingOff(String roundingOff_userInput) {

		if (roundingOff_userInput.contains(".")) {
			hasRoundOff = true;
			System.out.println(" Round of is applicable ");
			String[] inputs = roundingOff_userInput.split("\\.");
			intermediateBasicCost = Double.parseDouble(inputs[0]);
			roundoff_vlaue = Double.parseDouble(inputs[1]);

			if (roundoff_vlaue >= 50) {
				System.out.println(" Positive Round Off " + roundoff_vlaue);

				NetSellingPrice = intermediateBasicCost + 1;
				System.out.println("The  NetSellingPrice  " + NetSellingPrice);

			} else {
				System.out.println(" Negative Round Off " + roundoff_vlaue);
				NetSellingPrice = intermediateBasicCost;
				System.out.println("The  NetSellingPrice  " + NetSellingPrice);
			}

		}
	}

}
