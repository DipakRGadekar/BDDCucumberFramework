Feature: Customer
Background: Steps common for all scenarios
	Given User Launch Chrome browser 
	When User opens URL "http://admin-demo.nopcommerce.com/login" 
	And User enters Email as "admin@yourstore.com" and Password as "admin" 
	And Click on Login 
	Then User can view Dashboard page 

@Regression		
Scenario: Add new customer  
	When User click on customers Menu
	And click on customers Menu Item 
	And click on Add new button
	Then Page header should be "Add a new customer"
	When User enter customer info
	And click on save button 
	Then User can view confirmation message "The new customer has been added successfully." 
	And close browser 	

@Regression	
Scenario: Search any customer using email
	When User click on customers Menu
	And click on customers Menu Item 
	Then Page Title should be "Customers / nopCommerce administration"
	And Enter customer email 
	When click on search button 
	Then User should found Email in the search table
	And close browser 	

@Regression	
Scenario: Search any customer using First Name and Last Name
	When User click on customers Menu
	And click on customers Menu Item 
	Then Page Title should be "Customers / nopCommerce administration"
	And Enter customer First Name 
	And Enter customer Last Name 
	When click on search button 
	Then User should found Name in the search table
	And close browser 