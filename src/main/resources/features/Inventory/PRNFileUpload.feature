Feature: PoS Inventory > Add Inventory

  Background: 
    As a unipro user i want to launch the valid URL

    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
    
    @inventory
    Scenario: Verifying PRN File Upload Functionality
    Given I want to launch the "http://uniproonlineorder.ddns.net/Ent_SalesTeam_Demo/Inventory/PRNFileUpload.aspx"
    Then I need to click on the browse "Addprn" button
    Then I need to click on the browse "Browse" button
    Then I need to click on the browse "Upload" button
    
  	#cross drop down
  	#template dropdown