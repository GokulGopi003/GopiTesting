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

}