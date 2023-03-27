Feature: Leasing Calculator

  Scenario: Monthly fee calculations
    Given Leasing calculator is opened
    And User enters MIN valid data
    When User clicks on Calculate button
    Then All calculations are valid
    And Close banner
    
  Scenario: Error verification
    Given Leasing calculator is opened
    And User enters invalid data to purchase field
    When User clicks on Calculate button
    Then Error appearing as per requirements
    And Close banner
    
    
    		
    
