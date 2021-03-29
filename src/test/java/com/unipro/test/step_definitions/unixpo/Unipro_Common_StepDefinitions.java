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

	@Then("I need to click on the blue {string} button")
	public void i_need_to_click_on_the_blue_button(String buttonName) {

		cp.clickonBlueButton(buttonName);

	}

	@Then("I need to click on the red {string} button")
	public void i_need_to_click_on_the_red_button(String buttonName) {

		cp.clickonRedButton(buttonName);

	}

	@Then("I need to click on the browse {string} button")
	public void i_need_to_click_on_the_browse_button(String buttonName) {

		cp.clickonBrowseButton(buttonName);

	}

	@Then("I need to click on the filter {string} button")
	public void i_need_to_click_on_the_filter_button(String buttonName) {

		cp.clickonFilterButton(buttonName);

	}

	@Then("I need to click on the dialogbox {string} button")
	public void i_need_to_click_on_the_dialogbox_button(String buttonName) {

		cp.clickonDialogFilterButton(buttonName);

	}

	@Then("I need to click on the link {string} button")
	public void i_need_to_click_on_the_link_button(String buttonName) {

		cp.clickonLinkButton(buttonName);
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

	@Then("I need to click on OK button {string}")
	public void i_need_to_click_on_OK_button(String string) {
		cp.confirmOK(string);
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

	@Then("I want to maxmize the browser")
	public void i_want_to_maxmize_the_browser() {

		cp.maxmize_browser_window();
	}

	@Given("I need to click on the  element {string} in index {int}")
	public void i_need_to_click_on_the_element_in_index(String ele, Integer index) {

		cp.clickOnElementByIndex(ele, index);
	}

	@Then("I need to click alert ok")
	public void i_need_to_click_alert_ok() {
		cp.getWebDriver().switchTo().alert().accept();
	}

	@Then("I need to press the Enter key at {string}")
	public void i_need_to_press_the_Enter_key_at(String string) {

		WebElement ele = cp.waitForExpectedElement(By.cssSelector(string), 10);
		ele.sendKeys(Keys.ENTER);
	}

	
	@Then("I need to click on table forelement {string}")
	public void i_need_to_click_on_table_forelement(String element) {
		if (element.equalsIgnoreCase("View")) {
			WebElement we = cp.elementToBeClickable((By.xpath(
					"//*[@id=\"ContentPlaceHolder1_grdDistributionlist\"]/tbody/tr/td[3]/input[contains(@value, 'View')]")));
			we.click();
		} else if (element.equalsIgnoreCase("Delete")) {
			WebElement we = cp.elementToBeClickable((By.xpath(
					"//*[@id=\"ContentPlaceHolder1_grdDistribution\"]/tbody/tr[2]/td[1]/input[contains(@value, 'Delete')]")));
			we.click();

		} else if (element.equalsIgnoreCase("Select")) {
			
			WebElement we = cp.elementToBeClickable((By.xpath(
					"//*[@id=\"ContentPlaceHolder1_gvCustomerReceipts\"]/tbody/tr[1]/td[1]/input[contains(@value, 'Select')]")));
			
			we.click();
		} else {
			WebElement we = cp.elementToBeClickable((By.xpath(
					"//*[@id=\"ContentPlaceHolder1_gvPackageInv\"]/tbody/tr[1]/td[1]/input[contains(@value, 'Remove')]")));
			we.click();
		} 
	}

	@Then("I click on the Active button")
	public void i_click_on_the_Active_button() {
		WebElement action = cp.waitForExpectedElement(By.cssSelector("input#ContentPlaceHolder1_chkActive"), 10);
		action.click();
	}
	@Then("I need to click on DropDown forElement {string}")
	public void i_need_to_click_on_DropDown_forElement(String string) throws InterruptedException {
	    cp.elementToBeClickable(By.cssSelector(string)).click();
	}

@Then("I need to click on DropDown value forElement {string}")
public void i_need_to_click_on_DropDown_value_forElement(String string) throws InterruptedException {
    cp.elementToBeClickable(By.cssSelector(string)).click();

}
@Then("I need to click DropDown value {string}")
public void i_need_to_click_DropDown_value(String string) {
    
}
	@Then("I need to find and click on the element {string} with multiple indexs")
	public void i_need_to_find_and_click_on_the_element_with_multiple_indexs(String webelement) {
		
		for (Integer index = 0; index < 7; index++) {
			
			try {
				String locatorStirng = webelement+index.toString();
				By locator = By.cssSelector(locatorStirng);
				WebElement element = cp.waitForExpectedElement(locator, 2);
				
				element.click();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.err.println(index +"not avilable");
				
			}
			
		}
		
	
		
		
		
	
		
	   
	}

}
