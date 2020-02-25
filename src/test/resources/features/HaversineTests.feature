Feature: Tests for the Haversine function.
  Scenario Outline: Test that when a valid latitude and longitude are supplied, the expected distance to London is returned.
    Given A point exists on the map with a valid latitude of <latitude> and longitude of <longitude>.
    When The Haversine function is called.
    Then The correct expected result of <expectedResult> is returned as a distance from London.
    Examples:
    |latitude |longitude  |expectedResult |
    |72.9232  |26.19525   |1669.7306      |
    |4.7829   |-53.65266  |4451.1225      |
    |61.6045  |-163.9843  |4572.7743      |
    |-35.7584 |-5.7382    |6040.0329      |
    |-21.7717 |147.3782   |9737.847       |
    |51.5074  |0.1278     |0              |