Feature: PoS Master > Sales > Sales man >Sales Man Commission Brand @done
Background: 
    As a unixpro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title

  @master
  Scenario Outline: HomeMasterSalesSales ManSales Man Commission Brand
    Given I want to launch the "Masters/frmSalesManCommissionBrand.aspx"
  Then I load the testdata form excel to table
	Then I load the BrandWiseSalesManCommission sheet data to map
  Then I load the BrandWiseSalesManCommission rowise  data for "<TestcaseRowName>" rowname
  Then I update value to the BrandWiseSalesManCommission page global Variables
  Then I fill new BrandWiseSalesManCommission data page using excel data
	Then I need to click on the "Save" button
	Then I establish connection to BrandWiseSalesManCommission
  Then I read the values from table "tblSalesManCommissionBrand" in BrandWiseSalesManCommission
  Then I close connection to BrandWiseSalesManCommission

    Examples: 
      |TestcaseRowName|
      |BrandWiseSalesManCommission|
    