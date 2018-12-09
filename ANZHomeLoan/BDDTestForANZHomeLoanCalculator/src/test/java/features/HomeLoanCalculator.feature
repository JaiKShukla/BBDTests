Feature: HomeLoanCalculator
Description Verify the borrowing capacity and start over functionality of a customer
    
Scenario: Verify borrowing capacity 
Given the customer in on the Borrowing Power Calcuator page
    	And enters the following details in Your details section
      	| Application Type  | Number of Dependents | Property you would like to buy  |
      	| Single						| 0									|	Home to live in									|
      And enters the following details in Your earnings section
      	| Your income (before tax)  | Your other income  | 
      	| 80000										  | 10000							 |
      And enters the following details in Your expenses section
      	| Living expense | Current home loan repayments  | Other loan repayments |	Other loan repayment	|	Other commitments	|	Total credit card limits|
      	| 500						 | 0														 | 100									 |	0											|	0								  | 10000                   |      	     
 When the customer submits the details to calculate the borrowing capacity     
    	Then the borrowing capacity of cusomter is calculated as "$479,000"
    
Scenario: Verify on selecting the Start Over button the default values are populated
Given the customer in on the Borrowing Power Calcuator page
    	And enters the following details in Your details section
      	| Application Type  | Number of Depends | Property you would like to buy  |
      	| Single						| 0									|	Home to live in									|
      And enters the following details in Your earnings section
      	| Your income (before tax)  | Your other income  | 
      	| 80000										  | 10000							 |
      And enters the following details in Your expenses section
      	| Living expense | Current home loan repayments  | Other loan repayments |	Other loan repayment	|	Other commitments	|	Total credit card limits|
      	| 500						 | 0														 | 100									 |	0											|	0								  | 0                  			|      	     
 When the customer submits the details to calculate the borrowing capacity     
    	Then the borrowing capacity of cusomter is calculated as "$479,000"   
    	And the customer clicks on Start over to restart the application
    	Then the following details are displayed in Your details section
    		| Application Type  | Number of Depends | Property you would like to buy  |
      	| Single						| 0									|	Home to live in									|
      And the following details are displayed in Your earnings section
      	| Your income (before tax)  | Your other income  | 
      	| 0									  			| 0						 |
      And the following details are displayed in Your expenses section
      	| Living expense | Current home loan repayments  | Other loan repayments |	Other loan repayment	|	Other commitments	|	Total credit card limits|
      	| 0							 | 0														 | 0 									   |	0											|	0								  | 0                       |

Scenario: Verify that the borrowing capacity is not displayed on entering only one dollor in living expenses
Given the customer in on the Borrowing Power Calcuator page
    	And enters the following details in Your details section
      	| Application Type  | Number of Depends | Property you would like to buy  |
      	| Single						| 0									|	Home to live in									|
      And enters the following details in Your earnings section
      	| Your income (before tax)  | Your other income  | 
      	| 0										  | 0							 |
      And enters the following details in Your expenses section
      	| Living expense | Current home loan repayments  | Other loan repayments |	Other loan repayment	|	Other commitments	|	Total credit card limits|
      	| 1							 | 0														 | 0									 	 |	0											|	0								  | 0                  			|      	     
 When the customer submits the details to calculate the borrowing capacity     
    	Then the following message is displayed in the borrowing capacity section
    		|	Based on the details you've entered, we are unable to give you an estimate of your borrowing power with this calculator. For questions, call us on 1800 100641.																	|  
    	