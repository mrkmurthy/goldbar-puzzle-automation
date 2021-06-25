Feature: Game Challenge

  Scenario: Finding the fake bar
    Given user plays the fake gold bar game
    When user solves the game puzzle
    Then user should get message that fake bar successfully found