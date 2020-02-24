Feature: Tests for the Haversine function.
  Scenario: Test that when a longitude and latitude are supplied, the expected distance to London is returned.
    Given A point exists on the map with a valid longitude and latitude.
    When The Haversine function is called.
    Then The correct distance from London is returned.