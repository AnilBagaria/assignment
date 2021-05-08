Feature: View all the results on Coin Market Cap home page
  As an end user of the coinmarketcap website
  I should be able to click view all button
  And confirm the results are displaying appropriately

  @ui_task1 @uiTask
  Scenario: Launch home page and see 100 results
    
    Given the user navigate to home page
    And verify the page displays 100 records by default

