package com.unipro.test.page_objects.unixpro;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.unipro.test.framework.PageObject;
import com.unipro.test.framework.helpers.Props;

public class LoginPage extends PageObject {

	private By username = By.cssSelector("input#txtUserName.form-control");
	private By password = By.cssSelector("input#txtPassword.form-control");
	private By loginButtton = By.cssSelector("input#btnSignIn.log-btn");

	public void validLogin() {

		waitForExpectedElement(username).sendKeys("aa");
		waitForExpectedElement(password).sendKeys("aa");
		waitForExpectedElement(loginButtton).click();

	}

	public String getTestURL() {
		return Props.getProp("site.url");
	}

	public WebElement getUsernameElement() {
		return waitForExpectedElement(username);
	}

	public WebElement getPasswordElement() {
		return waitForExpectedElement(password);
	}

	public WebElement getLoginButtonElement() {
		return waitForExpectedElement(loginButtton);
	}

	public List<WebElement> getHeaderElements() {

		return presenceOfAllElementsLocatedBy(By.cssSelector("a.dropdown-toggle"));
	}

	public List<WebElement> getdropDownHeaderElements() {

		return presenceOfAllElementsLocatedBy(By.tagName("a"));
	}

}
