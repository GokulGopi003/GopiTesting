package com.unipro.test.page_objects.unixpro;

	import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebElement;

	import com.unipro.test.framework.helpers.utils.GenericWrappers;
	  import org.openqa.selenium.By;
		import org.openqa.selenium.Keys;
		import org.openqa.selenium.WebElement;

		import com.unipro.test.framework.PageObject;
		import com.unipro.test.framework.helpers.utils.GenericWrappers;

		public class PurchasereturnReqfield  extends PageObject {
			public String LocationCode_String = "input#ContentPlaceHolder1_txtLocation";
			public String Remark_String = "input#ContentPlaceHolder1_txtRemarks";
			public String Vendor_String = "div#ContentPlaceHolder1_DropDownVendorchzn-container chzn-container-single";
			public String ItemCode_String = "input#ContentPlaceHolder1_txtInventoryCode";
			
			public String InvQty_String = "input#ContentPlaceHolder1_txtPRRQty";
			public By InvQty_By = By.cssSelector(InvQty_String);

			
			//public String Batch_String = "input#tdcbSelectPrl_0";
			
			public double getTextValue(By by) {

				WebElement element = waitForExpectedElement(by);
				String cost = element.getAttribute("value");
				return Double.parseDouble(cost);

			}

			public void setTextValue_Decimal(String by, String inputText) {
				WebElement element = waitForExpectedElement(By.cssSelector(by));

				GenericWrappers.sleepInSeconds(4);
				js_typeIntoDropDownSearchBox(by, inputText);
				String[] sliceDecimal = inputText.split("\\.");

				GenericWrappers.sleepInSeconds(4);

				pressArrowKey(sliceDecimal[1].length(), element);

				setValueBasedOnNumberPad(element, sliceDecimal[1]);

			}

			public void pressArrowKey(int noOfpress, WebElement element) {
				System.out.println("no press" + noOfpress);

				for (int i = 0; i < noOfpress; i++) {

					element.sendKeys(Keys.ARROW_LEFT);
					GenericWrappers.sleepInSeconds(1);
				}

			}

			public void setTextValue(String by, String inputText) {
				WebElement element = waitForExpectedElement(By.cssSelector(by));

				js_typeIntoDropDownSearchBox(by, inputText);
				GenericWrappers.sleepInSeconds(4);
				pressArrowKey(inputText.length(), element);

				element.sendKeys(Keys.NUMPAD0);
				GenericWrappers.sleepInSeconds(2);

				element.sendKeys(Keys.ENTER);

				// setValueBasedOnNumberPad(element, inputText);

			}

			

			public void setValueBasedOnNumberPad(WebElement element, String inputText) {

				System.err.println(inputText);
				char[] inputarray = inputText.toCharArray();
				for (int i = 0; i < inputarray.length; i++) {

					switch (inputarray[i]) {

					case '0':
						element.sendKeys(Keys.NUMPAD0);
						GenericWrappers.sleepInSeconds(2);
						break;

					case '1':
						element.sendKeys(Keys.NUMPAD1);
						GenericWrappers.sleepInSeconds(2);

						break;
					case '2':
						element.sendKeys(Keys.NUMPAD2);
						GenericWrappers.sleepInSeconds(2);
						break;

					case '3':
						element.sendKeys(Keys.NUMPAD3);
						GenericWrappers.sleepInSeconds(2);

						break;

					case '4':
						element.sendKeys(Keys.NUMPAD4);
						GenericWrappers.sleepInSeconds(2);

						break;
					case '5':
						element.sendKeys(Keys.NUMPAD5);
						GenericWrappers.sleepInSeconds(2);

						break;

					case '6':
						element.sendKeys(Keys.NUMPAD6);
						GenericWrappers.sleepInSeconds(2);

						break;

					case '7':
						element.sendKeys(Keys.NUMPAD7);
						GenericWrappers.sleepInSeconds(2);

						break;

					case '8':
						element.sendKeys(Keys.NUMPAD8);
						GenericWrappers.sleepInSeconds(2);

						break;

					case '9':
						element.sendKeys(Keys.NUMPAD9);
						GenericWrappers.sleepInSeconds(2);

						break;
					default:
						System.err.println(i);
						break;
					}
				}

				GenericWrappers.sleepInSeconds(4);
				element.sendKeys(Keys.ENTER);
			}

}
