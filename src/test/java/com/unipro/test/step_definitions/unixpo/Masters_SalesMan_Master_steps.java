package com.unipro.test.step_definitions.unixpo;

import com.unipro.test.page_objects.unixpro.Masters_Sales_SalesMan_Master_Page;

import cucumber.api.java.en.Then;

public class Masters_SalesMan_Master_steps {
	Masters_Sales_SalesMan_Master_Page m_salesman;

	public Masters_SalesMan_Master_steps(Masters_Sales_SalesMan_Master_Page m_salesman) {

		this.m_salesman = m_salesman;
	}

	@Then("I enter the SalesMan ID {string}")
	public void i_enter_the_SalesMan_ID(String number) {
		m_salesman.get_SaleMan_ID().sendKeys(number);
	}

	@Then("I need enter the Employee Code {string}")
	public void i_need_enter_the_Employee_Code(String num) {
		m_salesman.get_Employee_Code(num).sendKeys(num);
	}

	@Then("I text the SalesMan name {string}")
	public void i_text_the_SalesMan_name(String string) {
		m_salesman.get_SaleMan_Name(string);

	}

	@Then("I need enter the commission {string}")
	public void i_need_enter_the_commission(String num) {
		m_salesman.get_SalesMan_Commission(num);
	}
}
