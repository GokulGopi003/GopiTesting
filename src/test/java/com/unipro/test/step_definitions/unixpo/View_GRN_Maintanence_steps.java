package com.unipro.test.step_definitions.unixpo;

import com.unipro.test.framework.helpers.WebDriverHelper;
import com.unipro.test.page_objects.unixpro.View_GRN_Maintanence_Page;

import cucumber.api.java.en.Then;

public class View_GRN_Maintanence_steps {
	
private View_GRN_Maintanence_Page view_grn_maintanence_page;
	
	public View_GRN_Maintanence_steps(View_GRN_Maintanence_Page view_grn_maintanence_page) {
	
		this.view_grn_maintanence_page=view_grn_maintanence_page;

	}
	
	
	
	@Then("I enter {string} in GRN Entry Screen")
	public void i_enter_in_GRN_Entry_Screen(String string) {
		
		view_grn_maintanence_page.enterSearchCodeValue(string);
	
		
	}

}
