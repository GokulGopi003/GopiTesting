package com.unipro.test.step_definitions.unixpo;

import com.unipro.test.page_objects.unixpro.Purchase_Order_Page;

import cucumber.api.java.en.Then;

public class purchase_order_steps {

	Purchase_Order_Page pop;

	public purchase_order_steps(Purchase_Order_Page pop) {
		// TODO Auto-generated constructor stub
		this.pop = pop;
	}

	@Then("I click on the selected Item by text {string} for findElements{string}")
	public void i_click_on_the_selected_Item_by_index_for_findElements(String textValue, String elementList) {
		pop.clickOntheElementBytext(elementList, textValue);
	}

	@Then("I doubleclick on the selected Item by text {string} for findElements{string}")
	public void i_doubleclick_on_the_selected_Item_by_index_for_findElements(String textValue, String elementList) {
		pop.double_clickOntheElementBytext(elementList, textValue);
	}

}
