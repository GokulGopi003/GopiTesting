package com.unipro.test.page_objects.unixpro;




	import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebElement;

	import com.unipro.test.framework.PageObject;
	import com.unipro.test.framework.helpers.utils.GenericWrappers;

	public class CreateGRN extends PageObject {

		public String Batch_String = "input#ContentPlaceHolder1_cbVendorItem";
		public String ItemName_String = "input#ContentPlaceHolder1_txtItemCode";
		public String ItemCode_String = "input#ContentPlaceHolder1_txtItemCode";
		
		public String InvQty_String = "input#ContentPlaceHolder1_txtInvQty";
		public By InvQty_By = By.cssSelector(InvQty_String);

		public String RecvQty_String = "input#ContentPlaceHolder1_txtLQty";
		public By RecvQty_By = By.cssSelector(RecvQty_String);

		public String MRP_String = "input#ContentPlaceHolder1_txtMRP";
		public By MRP_By = By.cssSelector(MRP_String);

		public String BasicCost_String = "input#ContentPlaceHolder1_txtBCost";
		public By BasicCost_By = By.cssSelector(BasicCost_String);
		
		public String DiscP_String = "input#ContentPlaceHolder1_txtDiscPer";
		public By DiscP_By = By.cssSelector(DiscP_String);
		
		public String DiscA_String = "input#ContentPlaceHolder1_txtDiscAmt";
		public By DiscA_By = By.cssSelector(DiscA_String);
		
		public String SDP_String = "input#ContentPlaceHolder1_txtSDPer";
		public By SDP_By = By.cssSelector(SDP_String);

		public String SDA_String = "input#ContentPlaceHolder1_txtSchemeAmt";
		public By SDA_By = By.cssSelector(SDP_String);
		
		public String spfixing_String = "input#ContentPlaceHolder1_txtSPrice";
		public By spfixing_By = By.cssSelector(spfixing_String);
		
		public String D1_String = "input#ContentPlaceHolder1_txtDisPer1";
		public By D1_By = By.cssSelector(D1_String);
		
		public String D2_String = "input#ContentPlaceHolder1_txtDiscPer2";
		public By D2_By = By.cssSelector(D2_String);
		
		public String D3_String = "input#ContentPlaceHolder1_txtDiscper3";
		public By D3_By = By.cssSelector(D3_String);
		
		public String WPrice1_String = "input#ContentPlaceHolder1_txtWpirce1";
		public By WPrice1_By = By.cssSelector(WPrice1_String);
		
		public String WPrice2_String = "input#ContentPlaceHolder1_txtWpirce2";
		public By WPrice2_By = By.cssSelector(WPrice2_String);
		
		public String WPrice3_String = "input#ContentPlaceHolder1_txtWpirce3";
		public By WPrice3_By = By.cssSelector(WPrice3_String);
		
		public String GrossAmount_String = "input#ContentPlaceHolder1_txtBasicAmt";
		public By GrossAmount_By = By.cssSelector(GrossAmount_String);
		
		public String GST_String = "input#ContentPlaceHolder1_txtVatAmt";
		public By GST_String_By = By.cssSelector(GST_String);
		
		public String BillAmt_String = "input#ContentPlaceHolder1_txtBillAmt";
		public By BillAmt_By = By.cssSelector(BillAmt_String);
		
		public String AddDed_String = "input#ContentPlaceHolder1_txtAD";
		public By AddDed_By = By.cssSelector(AddDed_String);
		
		public String Medical_Batch_String="input#ContentPlaceHolder1_txtMBatchNo";
		public String ExpiredDate_String="input#ContentPlaceHolder1_txtExpireDate";
		
		public String SalesNotAffectNetcos_string="input#ContentPlaceHolder1_cbSalesNotAffectNetCost";
		public String FreetoCustomer_String="input#ContentPlaceHolder1_cbFreetoCustomer";
		public String FocItem_String="input#ContentPlaceHolder1_txtFocItem";
		public String TotalQty_String="input#ContentPlaceHolder1_txtFocTotalQty";
		public String FromDate_String="input#ContentPlaceHolder1_txtfocFromDate";
		public String ToDate_String="input#ContentPlaceHolder1_txtFocToDate";
		public String BuyQty_String="input#ContentPlaceHolder1_txtFocBuyQty";
		public String FreeQty_String="input#ContentPlaceHolder1_txtFocFreeQty";
		
		public String Batch2_String = "input#ContentPlaceHolder1_chFillGA";
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





