Feature: Search
  Scenario Outline:: Find mobile
    Given I browse to yandex.ru for mobile
    When I click "Market for Mobile" link
    When I click "Elektronika for Mobile" link
    When I click "Mobile" link
    And I click "Advanced Search For Mobile" button
    When I enter <pricefromformobile> in pricefromformobile field
    And I click "samsung" item
    And I click "apple" item
    When I click "Apply for Mobile" button
    Then I see "48 mobile" item
    And I remember first item for mobile
    When I entered him in search field for mobile
    And I click "Search" button for mobile
    When I see result for search mobile
    Then I compare values for mobile

    Examples:
      |pricefromformobile|
      |20000|