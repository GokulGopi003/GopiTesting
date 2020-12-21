package com.unipro.test.step_definitions.unixpo;


import org.testng.Assert;

import com.unipro.test.page_objects.unixpro.ShortcutsPage;

import cucumber.api.java.en.Then;

public class ShortcutsPageSteps {
	
	private ShortcutsPage shortcutsPage;

	
	public ShortcutsPageSteps(ShortcutsPage  shortcutsPage) {
		// TODO Auto-generated constructor stub
		this.shortcutsPage = shortcutsPage;
	}
	

	
	@Then("Im launching Url {string}")
	public void im_launching_Url(String string) {
	
		shortcutsPage.getGRN_URL(string);
		Assert.assertEquals("Purchase-UNIPRO TECH SOLUTION PVT Ltd",shortcutsPage.getCurrentPageTitle() );
	}
	
	
	@Then("I need to click on a GoButton")
	public void i_need_to_click_on_a_GoButton() {
		
		
		shortcutsPage.returnnGoButton().click();

	}



}
