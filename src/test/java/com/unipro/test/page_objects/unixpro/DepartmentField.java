package com.unipro.test.page_objects.unixpro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.unipro.test.framework.PageObject;

public class DepartmentField extends PageObject{
	
	public String Departmentcode_string = "input#ContentPlaceHolder1_txtDeptCode.form-control-res";
	public String Departmentname_String = "input#ContentPlaceHolder1_txtDeptName.form-control-res";
	public String Personincharge_String = "input#ContentPlaceHolder1_txtPerInChrg.form-control-res";
	public String Discount_String = "input#ContentPlaceHolder1_txtDiscount";
	public String Remark_String = "input#ContentPlaceHolder1_txtRemarks.form-control-res";
	public String search_String = "input#ContentPlaceHolder1_txtSearch";
	
	private By DeleteButtton = By.xpath("//*[text()='YES']");
	public WebElement getDeleteButtonElement() {
		return waitForExpectedElement(DeleteButtton);
	}
	

}
