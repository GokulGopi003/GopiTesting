package com.unipro.test.step_definitions.unixpo;



import com.unipro.test.page_objects.unixpro.Masters_CategoryAtttributeMapping_Page;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Masters_CategoryAttributeMapping_steps {

	Masters_CategoryAtttributeMapping_Page m_cap;

	public Masters_CategoryAttributeMapping_steps(Masters_CategoryAtttributeMapping_Page m_cap) {

		this.m_cap = m_cap;

	}

	@Given("I want to launch the {string}")
	public void i_want_to_launch_the(String string) {

		m_cap.get_Masters_CategoryAtttributeMapping_Url(string);

	}

	@Then("I Need to clear the default values if any")
	public void i_Need_to_clear_the_default_values_if_any() {

		m_cap.get_clearButton().click();

	}

	@Then("I need to select the dropdown value as {string} for poduct name")
	public void i_need_to_select_the_dropdown_value_as_for_poduct_name(String string) {

		// click
		m_cap.product_NameElement().click();

		m_cap.get_DropDownSearchValue().click();

	}

	@Then("I need to enter the product cost as {string}")
	public void i_need_to_enter_the_product_cost_as(String string) {
		m_cap.get_productCost(string);
	}

	@Then("I need to enter the Miscelenious cost as{string}")
	public void i_need_to_enter_the_Miscelenious_cost_as(String string) {
		
		m_cap.get_Miscelanious(string);

	}

	@Then("I need to enter the margin as {string}")
	public void i_need_to_enter_the_margin_as(String string) {
		m_cap.get_Margin(string);
		
		//document.querySelectorAll('input#DESIGN')[0].offsetParent.parentElement.innerText
	}
	
	
	
	@Then("I select the  required attributes{string}")
	public void i_select_the_required_attributes(String string) {
	   
		m_cap.select_AttributeName(string);
	}

}