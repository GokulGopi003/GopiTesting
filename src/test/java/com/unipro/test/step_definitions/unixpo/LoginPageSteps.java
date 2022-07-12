package com.unipro.test.step_definitions.unixpo;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.unipro.test.framework.helpers.WebDriverHelper;
import com.unipro.test.page_objects.unixpro.LoginPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginPageSteps {

	private LoginPage loginPage;

	public LoginPageSteps(LoginPage loginPage) {

		this.loginPage = loginPage;
	}

	@Given("Launching the valid URL")
	public void launching_the_valid_URL()  {

		WebDriverHelper.getWebDriver().get(loginPage.getTestURL());
		loginPage.getWebDriver().manage().window().maximize();
		
	}
	
 @Given("I enter the username")
	public void i_enter_the_username() {

		loginPage.getUsernameElement().sendKeys("aa");
		
	}

	@When("I enter the password")
	public void i_enter_the_password() {
		//loginPage.getPasswordElement().sendKeys("uniprosa");
		loginPage.getPasswordElement().sendKeys("aa");
	}
	/*@Given("I enter the username")
	public void i_enter_the_username() {

		loginPage.getUsernameElement().sendKeys("aa");
		
	}

	@When("I enter the password")
	public void i_enter_the_password() {
		//loginPage.getPasswordElement().sendKeys("uniprosa");
		loginPage.getPasswordElement().sendKeys("ups@123");
	}*/
	@Then("I clik on the login button")
	public void i_clik_on_the_login_button() {

		loginPage.getLoginButtonElement().click();

	}

	@Then("I verify the page Title")
	public void i_verify_the_page_Title()    {

		//loginPage.checkPageTitle("MISDashboard-UNIPRO");
		
		loginPage.checkPageTitle("MISDashboard-NEW SEVEN HILLS SUPER BAZAAR");
		//loginPage.checkPageTitle("MisDashBoard-NEW SEVEN HILLS SUPER BAZAAR");

		
		

	}

	@Then("I click on Add Inventory")
	public void i_click_on_Add_Inventory() {

		List<WebElement> dropdownToggleList = loginPage.getHeaderElements();

		for (Iterator<WebElement> iterator = dropdownToggleList.iterator(); iterator.hasNext();) {

			WebElement webElement = (WebElement) iterator.next();
			System.out.println(webElement.getText());

			if (webElement.getText().equalsIgnoreCase("Inventory")) {

				webElement.click();

			} else {

			}

		}

	}

	@Then("I click on Add {string}")
	public void i_click_on_Add(String string) {
		List<WebElement> dropdownToggleList = loginPage.getHeaderElements();

		for (Iterator<WebElement> iterator = dropdownToggleList.iterator(); iterator.hasNext();) {

			WebElement webElement = (WebElement) iterator.next();
			System.out.println(webElement.getText());

			if (webElement.getText().equalsIgnoreCase(string)) {

				webElement.click();

			} else {

			}

		}

	}

	@Then("I click on a dropdown value {string}")
	public void i_click_on_a_dropdown_value(String string) {
		
		List<WebElement> dropdownToggleList = loginPage.getdropDownHeaderElements();
		
		
		for (Iterator<WebElement> iterator = dropdownToggleList.iterator(); iterator.hasNext();) {

			WebElement webElement = (WebElement) iterator.next();
			System.out.println(webElement.getText());

			if (webElement.getText().equalsIgnoreCase(string)) {

				webElement.click();
				break;

			} else {

			}

		}
		

	}

}
