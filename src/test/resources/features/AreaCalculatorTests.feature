Feature: Tests for the area calculation functionality.
  Scenario Outline: Tests to return positive when a user's current location is within 50 miles of London.
    Given A valid set of users exists.
    And The user's current location is within fifty miles of London, with a latitude of <latitude> and a longitude of <longitude>.
    When The area calcuation funtion is called.
    Then The area calculation function responds positively.
    Examples:
    |latitude |longitude  |
    |51.4277  |-0.2853    |
    |51.4159  |0.0970     |
    |51.2142  |-0.2163    |