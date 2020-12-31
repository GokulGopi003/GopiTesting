package com.unipro.test.step_definitions.unixpo;

import com.unipro.test.page_objects.unixpro.Management_Purchase_Page;

import cucumber.api.java.en.Then;

public class Management_Purchase_Step {

	Management_Purchase_Page Mana_Purchase;
	
	
	public Management_Purchase_Step(Management_Purchase_Page Mana_Purchase) {
		this.Mana_Purchase = Mana_Purchase;
	}
	@Then("I need to click on the {string}")
	public void i_need_to_click_on_the(String string) {
	  Mana_Purchase.Management_Vendor_Search().submit();;	}	
}
