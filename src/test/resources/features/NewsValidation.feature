Feature: Validate the first article on the Guardian news feed
  As a news reader
  I want to browse the first article from the Guardian on other sources
  So I am sure that the news are not fake

  Scenario: Article title yields more than 1K Google results
    Given User is on "https://www.theguardian.com/tone/news/"
    When user searches the first article in Google
    Then more than 1000 sources are displayed

  Scenario: Article title has 0 claims in google Fact Check
    Given User is on "https://www.theguardian.com/tone/news/"
    When user searches the first article in Fact Check
    Then results contain 0 claims

  Scenario: The fake article yields on Fact Check with rating False
    When User searches the fake article titled "Fluctuating Georgia U.S. Senate runoff vote count is evidence of election fraud." on Fact Check source
    Then results contain Publisher rating not True

  Scenario: Article title yields in valid sources
    Given User is on "https://www.theguardian.com/tone/news/"
    When user searches the first article in Google
    Then results contain trusted sources

  Scenario: Title does not yield on satire sources
    Given User is on "https://www.theguardian.com/tone/news/"
    When user searches the first article in Fact Check
    Then results do not contain satire sources

