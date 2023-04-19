@B28G5-191
Feature: Default

	@B28G5-190
	Scenario Outline: US185AC1 As a user, I want to view my own user information using the API so that I can see what information is stored about me
		Given I logged Library api with credentials "<email>" and "<password>" DB
		    And Accept header is "application/json" DB
		    And Request Content Type header is "application/x-www-form-urlencoded" DB
		    And I send token information as request body DB
		    When I send POST request to "/decode" endpoint DB
		    Then status code should be 200 DB
		    And Response Content type is "application/json; charset=utf-8" DB
		    And the field value for "user_group_id" path should be equal to "<user_group_id>" DB
		    And the field value for "email" path should be equal to "<email>" DB
		    And "full_name" field should not be null DB
		    And "id" field should not be null DB
		
		
		    Examples:
		      | email                | password    | user_group_id |
		      | student5@library     | libraryUser | 3             |
		      | librarian10@library  | libraryUser | 2             |
		      | student10@library    | libraryUser | 3             |
		      | librarian13@library  | libraryUser | 2             |