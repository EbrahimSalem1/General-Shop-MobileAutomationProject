Feature: Shopping in the General Store app

  Scenario: User completes initial setup to start shopping
    Given I open the General Store app on an Android device
    When I select "Egypt" from the dropdown list
    And I enter "Ebrahim" in the text field
    And I select "Male" as my gender and Assert it
    And I click on the "Let’s Shop" button
