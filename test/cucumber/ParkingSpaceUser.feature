Feature: Parking space user

	As a system user
	I want use users features
	So that I can use the features of system
 
  Scenario:Login with blank username
    Given Im at login page
    When I click in sign in with username ""
    Then The home page is loaded