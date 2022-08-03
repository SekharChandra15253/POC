Feature: Automate Product Booking from Amazon

  Scenario: Add a product into cart

    Given User is on HomePage
    When User Enters a required product in main search
    Then user selects a product and click on AddToCart
    And Verify Product is added to the cart