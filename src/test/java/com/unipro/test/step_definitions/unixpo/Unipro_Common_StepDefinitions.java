package com.unipro.test.step_definitions.unixpo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.unipro.test.page_objects.unixpro.CommonPages;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Unipro_Common_StepDefinitions {

	CommonPages cp;

	public Unipro_Common_StepDefinitions(CommonPages cp) {

		this.cp = cp;

	}

	@Given("I need to click on the {string} button")
	public void i_need_to_click_on_the_button(String buttonName) {

		cp.clickonButton(buttonName);

	}

	@When("I click dynamically on {string} button")
	public void i_click_dynamically_on_button(String buttonName) {

		cp.clickonButton_Dynamic(buttonName);

	}

	@When("I click on button tag with value {string}")
	public void i_click_on_button_tag_with_value(String buttonName) {

		cp.clickUsingButtonTag(buttonName);

	}

	@When("Im waiting for {int} sec")
	public void im_waiting_for_sec(Integer seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("I click on the {string} of {string} icon")
	public void i_click_on_the_of_icon(String element, String string2) {

		cp.clickonElement(element);
	}

	@When("I press downArrow from element {string}  and click enter key")
	public void i_press_downArrow_from_element_and_click_enter_key(String string) {

		WebElement ele = cp.waitForExpectedElement(By.cssSelector(string), 3);
		ele.sendKeys(Keys.ARROW_DOWN);
		ele.sendKeys(Keys.ENTER);

	}

	@Then("I confirm delete operation by clicking on {string}")
	public void i_confirm_delete_operation_by_clicking_on(String string) {

		cp.confirmDelete(string);
	}

	@When("I click on on element {string} in {string} alert box")
	public void i_click_on_on_element_in_alert_box(String element, String forBox) {

		cp.clickon_element_inAlertBox(element);

	}

	@Then("I need to type the textvalue forElement {string} value as {string} using Javascript")
	public void i_need_to_type_the_textvalue_forElement_value_as_using_Javascript(String string, String string2) {
		cp.js_waitAndTypeTextinsideTextBox(string2, string);
	}

	@Then("I need to press the BackSpace key forElement {string}")
	public void i_need_to_press_the_BackSpace_key_forElement(String element) {
		WebElement ele = cp.waitForExpectedElement(By.cssSelector(element), 3);
		ele.sendKeys(Keys.BACK_SPACE);
	}

	@Given("I need to click on the  element {string}")
	public void i_need_to_click_on_the_element(String element) {
		WebElement ele = cp.waitForExpectedElement(By.cssSelector(element), 3);
		ele.click();
		
	}

}
