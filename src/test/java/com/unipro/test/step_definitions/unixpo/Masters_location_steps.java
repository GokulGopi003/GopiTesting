package com.unipro.test.step_definitions.unixpo;

import com.unipro.test.page_objects.unixpro.Masters_Location_Page;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Masters_location_steps {
	Masters_Location_Page m_location;

	public Masters_location_steps(Masters_Location_Page m_location) {
		this.m_location = m_location;
	}

	@Given("I want to launch the{string}")
	public void i_want_to_launch_the(String string) {
		m_location.get_Masters_location_Url(string);
	}

	@Given("I need to enter the location code {string}")
	public void i_need_to_enter_the_location_code(String string) {

	}

	@Then("I text the location name {string}")
	public void i_text_the_location_name(String string) {
		m_location.Location_Name().sendKeys(string);
	}

	@Then("I text the incharge name {string}")
	public void i_text_the_incharge_name(String string) {

		m_location.type_inchargeName(string);

	}

	@Then("I enter the SortCode {string}")
	public void i_enter_the_SortCode(String string) {

		m_location.ShortCode(string);
	}

	@Then("I click on the warehouse button")
	public void i_click_on_the_warehouse_button() {
		m_location.get_warehouse().click();

	}

	@Then("I need to select the dropdown value as {string} for warehouse")
	public void i_need_to_select_the_dropdown_value_as_for_warehouse(String string) {
		m_location.get_WarehouseSearch().click();
		m_location.get_Warehouse_Search_Name().click();
	}

	@Then("I click on the save button")
	public void i_click_on_the_save_button() {
		m_location.get_save_button().click();
	}
}
