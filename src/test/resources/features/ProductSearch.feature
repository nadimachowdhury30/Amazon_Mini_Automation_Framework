Feature: Feature to test Amazon product search functionalitiesty

	Scenario: Amazon product search
		Given the user is logged in in amazon account
		When the user searches for the product name in the search bar
		And the user clicks the search button
		Then the product should be visible in the search result
		
		