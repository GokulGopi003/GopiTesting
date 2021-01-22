package com.unipro.test.page_objects.unixpro;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.sun.corba.se.impl.oa.poa.ActiveObjectMap.Key;
import com.unipro.test.framework.PageObject;

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

	public String Basic_Cost_String = "input#ContentPlaceHolder1_txtBasicCost";
	public By Basic_Cost_text = By.cssSelector(Basic_Cost_String);
	public By Net_Cost_text = By.cssSelector("input#ContentPlaceHolder1_txtNetCost");
	public By Gross_Cost_text = By.cssSelector("input#ContentPlaceHolder1_txtGrossCost");
	public By Basic_Selling_text = By.cssSelector("input#ContentPlaceHolder1_txtBasicSelling");
	public By NetSellingPrice_text = By.cssSelector("input#ContentPlaceHolder1_txtSellingPrice");
	public By WPrice1_text = By.cssSelector("input#ContentPlaceHolder1_txtWholePrice1Popup");
	public By WPrice2_text = By.cssSelector("input#ContentPlaceHolder1_txtWholePrice2Popup");
	public By WPrice3_text = By.cssSelector("input#ContentPlaceHolder1_txtWholePrice3Popup");

	public String Discount1_String = "input#ContentPlaceHolder1_txtDiscountPrc1";
	public String Discount2_String = "input#ContentPlaceHolder1_txtDiscountPrc2";
	public String Discount3_String = "input#ContentPlaceHolder1_txtDiscountPrc3";
	public By Discount1_text = By.cssSelector(Discount1_String);
	public By Discount2_text = By.cssSelector(Discount2_String);
	public By Discount3_text = By.cssSelector(Discount3_String);

	public double getTextValue(By by) {

		WebElement element = waitForExpectedElement(by);
		String cost = element.getAttribute("value");
		return Double.parseDouble(cost);

	}
	
	public void setTextValue(String by, String inputText) {
		WebElement element = waitForExpectedElement(By.cssSelector(by));

		js_typeIntoDropDownSearchBox(by, inputText);
		
		
		element.sendKeys(Keys.NUMPAD2);
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
