Feature: login feature
  I want to use this template for my feature file

  Scenario Outline: login scenario
    Given user has the payload of login api with "<userEmail>" and "<userPassword>"
    When user calls the login api with post request
    Then user gets response code 200
    And response body has token
	Examples:
	| userEmail								  | userPassword | 
	| apitesting@mailinator.com | apiTesting5# |
	
	