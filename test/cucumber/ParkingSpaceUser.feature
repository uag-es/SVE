Feature:Parking space user
	As a system user
	I want to use users features
	so that I can to use the feature
	
	Scenario: list all users of the  system (GUI)
        Given I signed up as "rghgf" with preference for parking spaces in the "CCEN" sector
        And the user is logged in the system
        When the user select the option My profile
        Then the user see the list of all user stored in the system
  
	Scenario: update user's first name (Controller)
		Given I signed up as "carlos" with preference for parking spaces in the "CIn" sector
        And the user is logged in the system   
    	When I update the user "carlos", firstName "Primeiro nome" to new firstName "MDS"
   		Then the system has stored the user "carlos" wiht new firstName "MDS", lastName "Ultimo nome", pefeence sector "CIn"
   		 
    Scenario: show the user`s information
    	Given I signed up as "A" with preference for parking spaces in the "CIn" sector
        And the user is logged in the system
        When the user select the option My profile
        Then the user see the list of all user stored in the system
        And the user select userName "A"
        And the user see the user`s information