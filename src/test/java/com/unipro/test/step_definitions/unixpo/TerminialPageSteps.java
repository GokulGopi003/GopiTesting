package com.unipro.test.step_definitions.unixpo;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.MaximizeWindow;

import com.unipro.test.page_objects.unixpro.TerminalPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TerminialPageSteps {

	TerminalPage ter_Page;

	public TerminialPageSteps(TerminalPage ter_Page) {

		this.ter_Page = ter_Page;
	}

	@Then("I need to click on the new button for creating a Terminal")
	public void i_need_to_click_on_the_new_button_for_creating_a_Terminal() {

		ter_Page.return_new_button().click();

	}

	@Then("I need to invoke the DD elements if text matching {string}")
	public void i_need_to_invoke_the_DD_elements_if_text_matching(String string) {

		ter_Page.return_dd_invoke_element(string, 0).click();

	}

	@Then("I need to invoke the DropDown by Index {int} if text matching {string}")
	public void i_need_to_invoke_the_DropDown_by_Index_if_text_matching(Integer index, String string) {

		ter_Page.return_dd_invoke_element(string, index).click();
	}

	@Then("I need to select the dropdown {string} value using Javascript")
	public void i_need_to_select_the_dropdown_value_using_Javascript(String string) {

		ter_Page.selectingDropDownUsingSerachBox(string);
	}

	@Then("I need to select the dropdown {string} value forLabel {string} using Javascript")
	public void i_need_to_select_the_dropdown_value_forLabel_using_Javascript(String value, String forLabel) {

		WebElement dd_element = ter_Page.waitAndSelectDropDownUsingSerachBox(value, forLabel);

		dd_element.sendKeys(Keys.SPACE);
		dd_element.sendKeys(Keys.SPACE);
		dd_element.sendKeys(Keys.ARROW_DOWN);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		dd_element.sendKeys(Keys.ENTER);

	}

	@Then("I need to select the dropdown {string} value forElement {string} using Javascript")
	public void i_need_to_select_the_dropdown_value_forElement_using_Javascript(String value, String forElement) {

		WebElement dd_element = ter_Page.waitAndSelectDropDownUsingSerachBox_Dynamic(value, forElement);

		dd_element.sendKeys(Keys.SPACE);
		dd_element.sendKeys(Keys.SPACE);
		dd_element.sendKeys(Keys.ARROW_DOWN);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		dd_element.sendKeys(Keys.ENTER);
	}

	@Then("Im press the sapce bar and enter key")
	public void im_press_the_sapce_bar_and_enter_key() {

		ter_Page.retrun_location_dropDownValue().sendKeys(Keys.SPACE);
		ter_Page.retrun_location_dropDownValue().sendKeys(Keys.SPACE);
		ter_Page.retrun_location_dropDownValue().sendKeys(Keys.ARROW_DOWN);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ter_Page.retrun_location_dropDownValue().sendKeys(Keys.ENTER);

	}

	@Then("typing system name as {string}")
	public void typing_system_name_as(String string) {

		ter_Page.type_terminal_system_name(string);

	}

	@Then("I enter the value forElement {string} as {string}")
	public void i_enter_the_value_forElement_as(String webele, String textToType) {

		ter_Page.terminal_waitClearEnterText_css(webele, textToType);
		
	}

	@Then("I enter the value forElement {string} as FCNew")
	public void i_enter_the_value_forElement_as_FCNew(String string) {

	}

	@Then("I click on the checkBox forElement {string}")
	public void i_click_on_the_checkBox_forElement(String webele) {

		WebElement element = ter_Page.get_checkBox_element(webele);
		if (!element.isSelected()) {

			element.click();
		}

	}

	@When("I select radio button forElement {string}")
	public void i_select_radio_button_forElement(String webele) {

		WebElement element = ter_Page.get_radioButton_element(webele);

		element.click();
	}

}
