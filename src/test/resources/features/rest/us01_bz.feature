@B28G5-189
Feature: As a librarian, I want to retrieve all users

@us01_BZ @B28G5-176 @B28G5-188
Scenario: Retrieve all users from the API endpoint

Given I logged Library api as a "librarian" BZ
And Accept header is "application/json" BZ
When I send GET request to "/get_all_users" endpoint BZ
Then status code should be 200 BZ
And Response Content type is "application/json; charset=utf-8" BZ
And "id" field should not be null BZ
And "name" field should not be null BZ