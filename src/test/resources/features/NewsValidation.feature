Feature: Validate the first article on the Guardian news feed
  As a news reader
  I want to browse the first article from the Guardian on other sources
  So I am sure that the news are not fake

  Scenario: Article title yields more than 1M Google results
    Given User is on "https://www.theguardian.com/tone/news/"
    And user clicks on "I am Happy" button
    When user searches the first article in Google
    Then more than 1000 sources are displayed

  Scenario: Article title yields in valid sources


  Scenario: Article title has 0 claims in google Fact Check
    Given User is on "https://www.theguardian.com/tone/news/"
    And user clicks on "I am Happy" button
    When user searches the first article in Fact Check
    Then results do not contain Publisher rating False



