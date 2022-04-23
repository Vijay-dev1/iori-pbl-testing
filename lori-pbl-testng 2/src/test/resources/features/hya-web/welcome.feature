@welcome
Feature: Welcome functionalities

  Background:

  Scenario: Test1
    Given user navigates to hylalori page
    When already registered user logs into the application
      | email          | password |
      | vijay.kambham@assurant.com | Test123@ |
    Then user should be able to verify following on the dashboard Page successfully
      | ObjName |
      | Your Device        |
      | Service Request        |
#   Then user clicks on Service Request button
#    Then user selects cracked screen check box
#    And user enters below text in the description box
#    | descr |
#    | cracked screen |
#    And user clicks the submit button
    And user logout successfully
