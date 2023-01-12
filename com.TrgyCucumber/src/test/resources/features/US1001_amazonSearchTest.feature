Feature: US1001 User tests on amazon

  Scenario: TC01 The user searches for Nutella on amazon.

    Given  user get the amazon page
    Then user write on the searchbox and searches it.
    And user tests it whether the result contain Nutella or not
    Then close the page