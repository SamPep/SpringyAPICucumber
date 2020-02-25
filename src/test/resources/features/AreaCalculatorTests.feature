Feature: Tests for the area calculation functionality.
  Scenario: Tests to return positive when a user's current location is within 50 miles of London.
    Given A valid set of users exist "within" London.
    When The area calculation function is called.
    Then The area calculation function identifies the 3 users.

  Scenario: Test to return negative when a user's location is outside London.
    Given A valid set of users exist "outside" London.
    When The area calculation function is called.
    Then The area calculation function identifies the 0 users.

  Scenario: Test to return error when a invalid users are submitted.
    Given An invalid set of users exist.
    When The area calculation function is called.
    Then The area calculation function returns null.
