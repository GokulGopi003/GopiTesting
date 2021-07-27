Feature: PoS Inventory > Add Inventory
@24july2021
Scenario Outline: Verifying Add Inventory Functionality Purchased by Cost
    Given Launching the valid URL
    Given I enter the username
    When I enter the password
    Then I clik on the login button
    Then I verify the page Title
    Given I want to launch the "Purchase/frmGoodsAcknowledgement.aspx"
    Then I need to click on the  element "input#ContentPlaceHolder1_rptrGA_btnGrn_0"
    Then I load the testdata form excel to table
    Then I load the GRN sheet data to map
    Then I load the rowise GRN data for "<TestcaseRowName>" rowname
    Then I update value to the GRN page global Variables
    Then I fill new GRN data page using excel data
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkAdd"  
    #Then I need to click on the  element "input#ContentPlaceHolder1_chFillGA"
    #Then I enter the value forElement "input#ContentPlaceHolder1_txtAD" as "0.00"
    #Then I need to click on the blue "Yes" button
    #When Im waiting for 2 sec
    #Then I need to click on the page
    #Then I want to click purchase order
    #When Im waiting for 2 sec
    #Then I want to minimize the browser
    #Then I need to click on the "Save" button
    #Then I need to click on the blue "Save" button 
    
    
    Examples: 
      | TestcaseRowName |
      |GRN          |
      
      
      

Scenario Outline:      
      
    Then I load the testdata form excel to table
    Then I load the GRN sheet data to map
    Then I load the rowise GRN data for "<TestcaseRowName>" rowname
    Then I update value to the GRN page global Variables
    Then I fill new GRN data page using excel data
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkAdd"  
    #Then I need to click on the  element "input#ContentPlaceHolder1_chFillGA"
    #Then I enter the value forElement "input#ContentPlaceHolder1_txtAD" as "0.00"
    #Then I need to click on the blue "Save" button 

     Examples: 
      | TestcaseRowName |
            |GRN1           |
      |GRN2           |
      |GRN3           |
      |GRN4           |
      |GRN5           |
      |GRN6           |
      |GRN7           |
      |GRN8           |
      |GRN9           | 
      |GRN10           |
      |GRN11           |
      |GRN12           |
      |GRN13           |
      |GRN14           |
      |GRN15           |
      |GRN16           |
      |GRN17           |
      |GRN18           |
      |GRN19           |
      |GRN20           |
      |GRN21           |
      |GRN22           |
      |GRN23           |
      |GRN24           |
      |GRN25           |
      |GRN26           |
      |GRN27           |
      |GRN28           |
      |GRN29           |
      |GRN30           |
      |GRN31           |
      |GRN32           |
      |GRN33           |
      |GRN34           |
      |GRN35           |
      |GRN36           |
      |GRN37           |
      |GRN38           |
      |GRN39           |
      |GRN40           |
      |GRN41           |
      |GRN42           |
      |GRN43           |
      |GRN44           |
      |GRN45           |
      |GRN46           |
      |GRN47           |
      |GRN48           |
      |GRN49           |
      |GRN50           |
      |GRN51           |
      |GRN52           |
      |GRN53           |
      |GRN54           |
      |GRN55           |
      |GRN56           |
      |GRN57           |
      |GRN58           |
      |GRN59           |
      |GRN60           |
      |GRN61           |
      |GRN62           |
      |GRN63           |
      |GRN64           |
      |GRN65           |
      |GRN66           |
      |GRN67           |
      |GRN68           |
      |GRN69           |
      |GRN70           |
      |GRN71           |
      |GRN72           |
      |GRN73           |
      |GRN74           |
      |GRN75           |
      |GRN76           |
      |GRN77           |
      |GRN78           |
      |GRN79           |
      |GRN80           |
      |GRN81           |
      |GRN82           |
      |GRN83           |
      |GRN84           |
      |GRN85           |
      |GRN86           |
      |GRN87           |
      |GRN88           |
      |GRN89           |
      |GRN90           |
      |GRN91           |
      |GRN92           |
      |GRN93           |
      |GRN94           |
      |GRN95           |
      |GRN96           |
      |GRN97           |
      |GRN98           |
      |GRN99           |
      |GRN100           |
      |GRN101           |
      |GRN102           |
      |GRN104           |
      |GRN105           |
      |GRN106           |
      |GRN107           |
      |GRN108           |
      |GRN109           |
      |GRN110           |
      |GRN111           |
      |GRN112           |
      |GRN113           |
      |GRN114          |
      |GRN115          |
      |GRN116          |
      |GRN117          |
      |GRN118          |
      |GRN120          | 
      |GRN121          |
      |GRN122          |
      |GRN123          |
      |GRN124          |
      |GRN125          |
      |GRN126          |
      |GRN128          |
      |GRN129          |
      |GRN130          |
      |GRN131          |
      |GRN132          |
      |GRN133          |
      |GRN134          |
      |GRN136          |
      |GRN137          |
      |GRN138          |
      |GRN139          |
      |GRN140          |
      |GRN141          |
      |GRN142          |
      |GRN143          |
      |GRN144          |
      |GRN145          |
      |GRN146          |
      |GRN147          |
      |GRN148          |
      |GRN149          |
      |GRN150          |
      |GRN151          |
      |GRN152          |
      |GRN153          |
      |GRN154          |
      |GRN155          |
      |GRN156          |
      |GRN157          |
      |GRN158          |
      |GRN159          |
      |GRN160          |
      |GRN161          |
      |GRN162          |
      |GRN163          |
      |GRN164          |
      |GRN165          |
      |GRN166          |
      |GRN167          |
      |GRN168          |
      |GRN169          |
      |GRN170          |
      |GRN171          |
      |GRN172          |
      |GRN173          |
      |GRN174          |
      |GRN175          |
      |GRN176          |
      |GRN177          |
      |GRN178          |
      |GRN179          |
      |GRN180          |
      |GRN181          |
      |GRN182          |
      |GRN183          |
      |GRN184          |
      |GRN185          |
      |GRN186          |
      |GRN187          |
      |GRN188          |
      |GRN189          |
      |GRN190          |
      |GRN191          |
      |GRN192          |
      |GRN193          |
      |GRN194          |
      |GRN195          |
      |GRN196          |
      |GRN197          |
      |GRN198          |


      
   Scenario Outline:      
    Then I load the testdata form excel to table
    Then I load the GRN sheet data to map
    Then I load the rowise GRN data for "<TestcaseRowName>" rowname
    Then I update value to the GRN page global Variables
    Then I fill new GRN data page using excel data
    Then I need to click on the  element "a#ContentPlaceHolder1_lnkAdd"  
    Then I need to click on the  element "input#ContentPlaceHolder1_chFillGA"
    Then I enter the value forElement "input#ContentPlaceHolder1_txtAD" as "0.00"
    Then I need to click on the blue "Save" button 
    
       Examples: 
      | TestcaseRowName |
      |GRN199           |
    