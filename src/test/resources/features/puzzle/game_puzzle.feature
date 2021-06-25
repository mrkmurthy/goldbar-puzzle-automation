Feature: Game Challenge

  Scenario: Finding the fake bar
    Given user plays the fake gold bar game
    When he solves the game puzzle
    Then he should get message that fake bar successfully found