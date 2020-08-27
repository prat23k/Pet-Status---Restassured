Feature: Get Pet status
  Scenario: User calls web service to get pets by its status
	Given a pets available with status of available
	When user retrieves the pets by status
	Then status code is 200
    And validate how many pets have the name doggie

