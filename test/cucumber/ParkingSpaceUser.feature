Feature: Parking space user

	As a system user
	I want use users features
	So that I can use the features of system
 
  Scenario:Login with blank username
    Given Im at login page
    When I click in sign in with USERNAME ""
    Then the home page is loaded
    
  Scenario:Sign up with blank username
    Given Im at sign up page
    When I fill username with "" and "CIn" as prefered sector
    Then Im still in sign up page
    
  Scenario:Remove system user
    Given the system has stored the user "Kadu" with preference for parking spaces in the "CIn" sector
    When I remove user "Kadu"
    Then the systems does not have user "Kadu" storaged
  
  Scenario:Update user preferential sector
    Given the system has stored the user "Kadu" with preference for parking spaces in the "CIn" sector
    When I update user "Kadu" with "Area II" sector
    Then the system has stored the user "Kadu" with preference for parking spaces in the "Area II" sector