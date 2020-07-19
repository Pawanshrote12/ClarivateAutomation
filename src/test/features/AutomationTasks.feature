Feature: BOT 3594 Automation QA Engineer Interview Task
  @BrowserAutomation
  Scenario: Automation task 1 - Validate Google Search for Clarivate Analytics
    Given I open Chrome Browser
    When  I navigate to google.com
    And search for "Clarivate Analytics"
    Then first search result should be "https://clarivate.com/"

  @DesktopAutomation
  Scenario: Automation task 2 - Validate Calculator to perform Square Root of 65575
    Given I open Windows Calculator Application
    When  I enter number 65575
    And click on square root button
    Then the calculate result should be correct