@smoke

Feature: Test Vodafone website
  Scenario: Make order " Buy Iphone" and Deliver it to user address
    Given Choose English Language
    And Go to Shop By Brand section and select IphoneLogo
    And Select any of returned iphone mobiles

    When Press add to cart
    And Press Proceed to Checkout
    And Select Delivery Options as "Cairo" and "Ain Shams"
    And Select Deliver to My Address
    And Add address details then press continue
    And Leave Personal info Tab empty and Press continue

    Then Assert on error message returned from Full Name field