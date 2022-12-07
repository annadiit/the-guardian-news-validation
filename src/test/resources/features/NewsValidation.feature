Feature: Find the first article

  Scenario: Article title yields more than 1M Google results
    Given User is on "https://www.theguardian.com/tone/news/"
    And user clicks on "I am Happy" button
    When user searches the first article in Google
    Then more than 1000 sources are displayed

  Scenario: Article title yields in valid sources
  Scenario: Article title yields in google Fact Check



