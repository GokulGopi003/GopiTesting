package com.unipro.test.step_definitions.unixpo;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import java.util.Scanner;

import org.openqa.selenium.By;

import com.unipro.test.page_objects.unixpro.InventoryCalculationsPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class InventoryCalculations_StepDefinitions {
	InventoryCalculationsPage icp;

	public InventoryCalculations_StepDefinitions(InventoryCalculationsPage icp) {

		this.icp = icp;
	}

	@Then("I verify default values of selling price calcualtion page for {string} as BasicCost")
	public void i_verify_default_values_of_selling_price_calcualtion_page_for_as_BasicCost(String basicCostInput) {

		// setting Basic cost price
		icp.setTextValue(icp.Basic_Cost_String, basicCostInput);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Getting the updated price
		icp.Basic_Cost = icp.getTextValue(icp.Basic_Cost_text);
		icp.Basic_Selling = icp.getTextValue(icp.Basic_Selling_text);
		icp.Net_Cost = icp.getTextValue(icp.Net_Cost_text);
		icp.WPrice1 = icp.getTextValue(icp.WPrice1_text);
		icp.WPrice2 = icp.getTextValue(icp.WPrice2_text);
		icp.WPrice3 = icp.getTextValue(icp.WPrice3_text);

		System.out
				.println("Verifying Basic cost and Basic selling price " + icp.Basic_Cost + " = " + icp.Basic_Selling);

		// Verifying with the Basic cost price
		assertEquals(icp.Basic_Cost, icp.Basic_Selling);
		assertEquals(icp.Basic_Cost, icp.Net_Cost);
		assertEquals(icp.Basic_Cost, icp.WPrice1);
		assertEquals(icp.Basic_Cost, icp.WPrice2);
		assertEquals(icp.Basic_Cost, icp.WPrice3);
		assertEquals(icp.Basic_Cost, icp.WPrice3);
		// Calculating the round off value

		icp.roundingOff(basicCostInput);

		// getting the NetSellingPrice

		double actual_NetSellingPrice_text = icp.getTextValue(icp.NetSellingPrice_text);
		assertEquals(actual_NetSellingPrice_text, icp.NetSellingPrice);

		System.out.println("Verifying Selling price after - RoundOff  " + actual_NetSellingPrice_text + " = "
				+ icp.NetSellingPrice);

	}

	@When("I enter the discout as {string} percent and i verify the GrossCost value is updated as expected")
	public void i_enter_the_discout_as_percent_and_i_verify_the_GrossCost_value_is_updated_as_expected(
			String discount1) {

		// set discount price

		icp.setTextValue(icp.Discount1_String, discount1);
		icp.setTextValue(icp.Discount2_String, discount1);
		icp.setTextValue(icp.Discount3_String, discount1);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Getting the updated price
		icp.Basic_Cost = icp.getTextValue(icp.Basic_Cost_text);
		icp.Basic_Selling = icp.getTextValue(icp.Basic_Selling_text);
		icp.Gross_Cost = icp.getTextValue(icp.Gross_Cost_text);
		icp.Net_Cost = icp.getTextValue(icp.Net_Cost_text);
		icp.WPrice1 = icp.getTextValue(icp.WPrice1_text);
		icp.WPrice2 = icp.getTextValue(icp.WPrice2_text);
		icp.WPrice3 = icp.getTextValue(icp.WPrice3_text);

		System.out
				.println("Verifying Basic cost and Basic selling price " + icp.Basic_Cost + " = " + icp.Basic_Selling);

		// Verifying with the Basic cost price
		assertNotEquals(icp.Basic_Cost, icp.Basic_Selling);
		
		//assertEquals(icp.Basic_Cost, icp.Net_Cost);
		//assertEquals(icp.Basic_Cost, icp.WPrice1);
		assertEquals(icp.Gross_Cost, icp.WPrice2);
		assertEquals(icp.Gross_Cost, icp.WPrice3);
		assertEquals(icp.Gross_Cost, icp.WPrice3);
		// Calculating the round off value
	}

	
	
		@Then("I verify the total discount offerd percentage")
		public void i_verify_the_total_discount_offerd_percentage() {
			
			
			float percentage;
			float total_marks;
			float scored;
			Scanner sc = new Scanner(System.in);
			//System.out.println("Enter Gross Cost ::");
			scored = (float) icp.Gross_Cost;

			//System.out.println("Enter Basic Cost  ::");
			total_marks = (float) icp.Basic_Cost;

			percentage = (float) ((scored / total_marks) * 100);
			System.out.println("Percentage ::" + percentage);

			float ActualdiscountOffered = 100 - percentage;
			System.out.println("ActualdiscountOffered ::" + 	Math.round(ActualdiscountOffered));
			
			
			float ExpectedtotalDiscount = (float) (icp.getTextValue(icp.Discount1_text)+icp.getTextValue(icp.Discount2_text)+icp.getTextValue(icp.Discount3_text));
			System.out.println("ExpectedtotalDiscount ::" + 	Math.round(ExpectedtotalDiscount));
			
			assertEquals(Math.round(ActualdiscountOffered), Math.round(ExpectedtotalDiscount));
		   
		}
}
