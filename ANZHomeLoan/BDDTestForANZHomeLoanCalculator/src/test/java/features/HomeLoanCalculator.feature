Feature: HomeLoanCalculator
    
Scenario: Verify borrowing capacity 
Given the customer in on the Borrowing Power Calcuator page
    	And enters the following details in Your details section
      	| Application Type  | Number of Depends | Property you would like to buy  |
      	| Single						| 0									|	Home to live in									|
      And enters the following details in Your earnings section
      	| Your income (before tax)  | Your other income  | 
      	| 80000										  | 10000							 |
      And enters the following details in Your expenses section
      	| Living expense | Current home loan repayments  | Other loan repayments |	Other loan repayment	|	Other commitments	|	Total credit card limits|
      	| 500						 | 0														 | 100									 |	0											|	0								  | 10000                   |      	     
 When the customer submits the details to calculate the borrowing capacity     
    	Then the borrowing capacity of cusomter is calculated as "$479,000"
    