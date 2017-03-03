Feature: Checking Registered User
  Scenario: The user is registered in the system
    Given the system has stored the user "fasfa" with preference for parking spaces in the "CCEN" sector
    When the user "fasfa" is typed and clicks in the sign-in button
    Then the user can use the system