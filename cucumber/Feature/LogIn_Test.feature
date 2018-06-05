Feature: LogIn Action Test
Description: This feature will test a LogIn functionality with data driven

Scenario: Login feature with data driven
     Given User is on Home Page
     When User Navigate to LogIn Page
		 And User enters username and password
		| Username   | Password |
    | testuser_1 | Test@153 |
    | testuser_2 | Test@154 |
    | testuser_3 | Test@155 |
     Then Error Message displayed