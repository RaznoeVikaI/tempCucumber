Feature: Search
  Scenario Outline: Find headphones
    Given I browse to yandex.ru for headphones
    When I click "Market for Headphones" link
    When I click "Elektronika for Headphones" link
    When I click "Headphones" link
    And I click "Advanced Search for Headphones" button
    When I enter <pricefromforheadphones> in pricefromforheadphones field
    And I click "beats" item
    When I click "Apply for Headphones" button
    Then I see "48 headphones" item
    And I remember first item for headphones
    When I entered him in search field for headphones
    And I click "Search" button for headphones
    When I see result for search headphones
    Then I compare values for headphones


    Examples:
      |pricefromforheadphones|
      |5000|