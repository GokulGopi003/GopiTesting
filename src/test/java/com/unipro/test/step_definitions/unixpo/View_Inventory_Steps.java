package com.unipro.test.step_definitions.unixpo;

import org.testng.Assert;

import com.unipro.test.page_objects.unixpro.ViewInventoryPage;

import cucumber.api.java.en.Then;

public class View_Inventory_Steps {
	ViewInventoryPage vip;

	public View_Inventory_Steps(ViewInventoryPage vip) {

		this.vip = vip;
		// TODO Auto-generated constructor stub
	}

	@Then("I need to enter {string} search text")
	public void i_need_to_enter_search_text(String string) {

		vip.search_viewInventory(string);

	}

	@Then("I click on search button")
	public void i_click_on_search_button() {

		vip.retrun_searchButton_viewInventory().click();

	}

	@Then("I need to click on Edit Icon")
	public void i_need_to_click_on_Edit_Icon() {

		vip.retrun_editIcon_viewInventory().click();
		Assert.assertEquals(vip.get_Current_Tile(), "Inventory-UNIPRO TECH SOLUTION PVT Ltd");

	}

}
