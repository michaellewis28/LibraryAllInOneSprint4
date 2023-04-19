@B28G5-189
Feature: Default

	
	@B28G5-188
	Scenario: US01_BZ AC01 As a librarian, I want to retrieve all users
		Given I logged Library api as a "librarian" BZ
		And Accept header is "application/json" BZ
		When I send GET request to "/get_all_users" endpoint BZ
		Then status code should be 200 BZ
		And Response Content type is "application/json; charset=utf-8" BZ
		And "id" field should not be null BZ
		And "name" field should not be null BZ