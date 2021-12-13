package com.unipro.test.page_objects.unixpro;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.testng.Assert;

import java.awt.AWTException;

import com.gk.test.MssqlConnect;
import com.unipro.test.framework.Globals;
import com.unipro.test.framework.PageObject;
import com.unipro.test.framework.helpers.screenshot_helper.Screenshot;
import com.unipro.test.framework.helpers.utils.GenericWrappers;
import com.unipro.test.framework.helpers.utils.ReadTestData;
import com.unipro.test.framework.helpers.utils.ReadXLSXFile;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Department  extends PageObject  {
	AddInventoryFormPage Department;
	DepartmentField icp;
	CommonPages cp;
	TerminalPage terPage;
	TerminalPage ter_Page;
	Screenshot scr;

	public  Department(DepartmentField icp) {
		this.icp = icp;
		terPage = new TerminalPage();
		scr =new Screenshot();
		Department = new AddInventoryFormPage();
		this.ter_Page = ter_Page;
		this.cp = cp;
            
	}
	@Then("I load the testdataa form excel to table")
	public void i_load_the_testdata_form_excel_to_table() {

		// Globals.excelSheetData = ReadXLSXFile.getExcelAsMapTable("./testdata/sample
		// mrp.xlsx");
		Globals.excelSheetData = ReadXLSXFile.getExcelAsMapTable("./testdata/sample inventory all.xlsx");

	}
	@Then("I load the Department sheet data to map")
	public void i_load_the_inventory_sheet_data_to_map() {

		//Globals.Inventory.inventorySheetData1 = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME_DATA);

		Globals.Inventory.DepartmentSheetData = Globals.excelSheetData.get(Globals.Inventory.SHEETNAME1);

	}
	@Then("I load the rowise Department data for {string} rowname")
	public void i_load_the_rowise_inventory_data_for_rowname(String row_name) {

		Globals.Inventory.DepartmentrowwiseData = ReadTestData
				.getRowFilteredValueFromTable(Globals.Inventory.DepartmentSheetData, row_name);

		System.out.println(Globals.Inventory.DepartmentrowwiseData);

	}
	@Then("I update value to the Department page global Variables")
	public void i_update_value_to_the_Department_page_global_Variables() {

		Globals.Inventory.Departmentcode = Globals.Inventory.DepartmentrowwiseData.get("Departmentcode");
		Globals.Inventory.Departmentname = Globals.Inventory.DepartmentrowwiseData.get("Departmentname");
		Globals.Inventory.Personincharge = Globals.Inventory.DepartmentrowwiseData.get("Personincharge");
		Globals.Inventory.Discount = Globals.Inventory.DepartmentrowwiseData.get("Discount");
		Globals.Inventory.Remark = Globals.Inventory.DepartmentrowwiseData.get("Remark");
		Globals.Inventory.search = Globals.Inventory.DepartmentrowwiseData.get("search");
		
	}
	@Then("I fill new Department data page using excel data")
	public void i_fill_new_Department_data_page_using_excel_data() throws Exception {
try {
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Departmentcode)) {
			terPage.terminal_waitClearEnterText_css(icp.Departmentcode_string, Globals.Inventory.Departmentcode);
			

		}
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Departmentname)) {
			terPage.terminal_waitClearEnterText_css(icp.Departmentname_String, Globals.Inventory.Departmentname);
		
		}
		
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Personincharge)) {
			terPage.terminal_waitClearEnterText_css(icp.Personincharge_String, Globals.Inventory.Personincharge);
			      
	

	}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Discount)) {
			terPage.terminal_waitClearEnterText_css(icp.Discount_String, Globals.Inventory.Discount);
			
			
}
		if (GenericWrappers.isNotEmpty(Globals.Inventory.Remark)) {
			terPage.terminal_waitClearEnterText_css(icp.Remark_String, Globals.Inventory.Remark);
		
		}
		File file = new File("/Users/macpc/Documents/GitHub/GopiTesting/testdata/sample inventory all.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook xs = new XSSFWorkbook(fis);
		XSSFSheet sh = xs.getSheet(Globals.Inventory.SHEETNAME1);
		int row= sh.getLastRowNum()+1;
		sh.createRow(row).createCell(7).setCellValue("passed");
		FileOutputStream fos = new FileOutputStream(file);
		xs.write(fos);
}
catch (Exception e) {
	// screen shot
	scr.Screenshots();
	System.out.println("Screen shot ");
	// Xl sheet write
	File file = new File("/Users/macpc/Documents/GitHub/GopiTesting/testdata/sample inventory all.xlsx");
	FileInputStream fis = new FileInputStream(file);
	XSSFWorkbook xs = new XSSFWorkbook(fis);
	XSSFSheet sh = xs.getSheet(Globals.Inventory.SHEETNAME1);
	int row= sh.getLastRowNum()+1;
	sh.createRow(row).createCell(7).setCellValue("failed");
	FileOutputStream fos = new FileOutputStream(file);
	xs.write(fos);
	

}
		//if (GenericWrappers.isNotEmpty(Globals.Inventory.search)) {
			//terPage.terminal_waitClearEnterText_css(icp.search_String, Globals.Inventory.search);
			//Department.clearAndTypeSlowly(Globals.Inventory.search, "input#txtSearch");
			//Department.return_td_invoke_element(Globals.Inventory.search).click();
			//WebElement dd_element = ter_Page.waitAndSelectDropDownUsingSerachBox(icp.search_String, Globals.Inventory.search);

		    
			//dd_element.sendKeys(Keys.SPACE);
			//dd_element.sendKeys(Keys.SPACE);
			//dd_element.sendKeys(Keys.ARROW_DOWN);
			//try {
				//Thread.sleep(1000);
			//} catch (InterruptedException e) {
				// TODO Auto-generated catch block
			//	e.printStackTrace();
			//}

			//dd_element.sendKeys(Keys.ENTER);

		}
	@Then("I close connection  DB")
	public void I_close_connection_to_DB() throws SQLException {

		mysqlConnect.disconnect();
		System.out.println(" closed succesfully");

		// mysqlConnect.disconnect();

	}
	MssqlConnect mysqlConnect;
	Statement st;
	 
	@Then("I establish connection  DB")
	public void I_establish_connection_to_DB() throws SQLException {

		mysqlConnect = new MssqlConnect();
		st = mysqlConnect.connect().createStatement();
		System.out.println(" Connected succesfully");

	}
	@Given("I read the values from department table {string} in DB")
	public void i_want_to_launch_the(String tablename ) throws SQLException {
		
		
		ResultSet rs = st.executeQuery("select * from "+tablename+" where DeptCode='Gopi'");
		
		System.out.println(rs);
		//ResultSet rs = st.executeQuery("");

		while (rs.next()) {

			switch (tablename) {
			
			case "tbldepartment":
				String DepartmentCode = rs.getString("DeptCode");
				    System.out.println(DepartmentCode);
				    Assert.assertEquals(Globals.Inventory.Departmentcode.trim(), DepartmentCode.trim());
				break;
			case "tblinventorypricing":
				String BasicSelling = rs.getString("BasicSelling");
				  System.out.println(BasicSelling);
				   Assert.assertEquals(Globals.Inventory.NetSellingPrice.trim(), BasicSelling.trim());
				 
				break;
			default:
				break;
			}}
		}
	
	
	
	@Then("I search the value forElement {string} as {string}")
	public void i_enter_the_value_forElement_as(String webele, String textToType) {

		try {

			ter_Page.terminal_waitClearEnterText_css(webele, textToType);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}
	@Then("I need to click on the YES button")
	public void Then_I_eed_to_click_on_the_YES_button(String buttonName) {
		icp.getDeleteButtonElement().click();
	}
	@Then ("i send to enter key")
	public void i_send_to_enter_key()  {
		
		webDriver.findElement(By.cssSelector("input#ContentPlaceHolder1_txtSearch")).sendKeys(Keys.RETURN);
		

			 
		 
		
	}
		
	}


