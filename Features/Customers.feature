Feature: Customer

Background: Common steps for all scenario
     Given User Launch Chrome browser 
	   When User opens URL "http://admin-demo.nopcommerce.com/login" 
	   And User enters Email as "admin@yourstore.com" and Password as "admin" 
	   And Click on Login 
	   Then User can view Dashboad 


@Regression
Scenario:  Search Customer by Email
	
	   When User click on customers Menu 
	   And click on customers Menu Item 
   	And Enter customer EMail
   	When Click on search button
  	Then User should found Email in the Search table
	  And close browser 

#Scenario:  Search Customer by Name
#
  #When User click on customers Menu 
#	And click on customers Menu Item 
#	When Enter customer FirstName
#	When Enter customer LastName
#	When Click on search button
#	Then User should found Name in the Search table
#	And close browser 
