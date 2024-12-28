Feature: Shopping in the General Store app

  Scenario: User adds products to cart and navigates to cart screen
    Given I open the General Store app on an Android device
    When I select "Egypt" from the dropdown list
    And I enter "John Doe" in the text field
    And I select "Male" as my gender and Assert it
    And I click on the "Let’s Shop" button
    And I add two products to the cart
    Then I navigate to the cart screen
