#Author: your.email@your.domain.com

Feature: Manage todo list

Background: 
	Given user is on the todo list page
  	When the items entered by user gets added to his todo list under All tab
  
  @sanity 
  Scenario: user adds item to the list
  	Then verify the count of the items in the All reflects Active items count
  	Then end session

  @sanity
  Scenario: Marking an item complete and back to active
    	And the user marks the item as complete by selecting it 
    	Then verify that the item is moved to completed and clear completed option shows up
    	And verify the item appears under All tab as well
    	Then verify the count of the items in the All reflects Active items count
    	When the user unmarks the item back to Active by deselecting it 
    	Then verify that the item is moved back to Active
    	And verify the item appears under All tab as well 
    	And end session
         
  @sanity
  Scenario: clear the completed items
 	And the user marks the item as complete by selecting it 
   	Then verify that the item is moved to completed and clear completed option shows up
  	When the user clicks on clear completed 
  	Then verify that the completed items are removed from Completed and All tab
    	And end session
  
  
  @sanity
  Scenario: Removing the item by clicking on X icon 
  	Then the user clicks on the X icon of the item in All
  	Then the user clicks on the X icon of the item in Active
  	Then the user clicks on the X icon of the item in Completed
  	And end session
	 
  @sanity
  Scenario: Clicking on the down arrow in All tab
  	And the user clicks on the down arrow in All tab  
 	Then verify that all the items are marked as completed
  	And end session
  
  @sanity
  Scenario: Clicking on the down arrow in Active tab
  	When the user clicks on the down arrow in Active tab  
  	Then verify that the items dropdown collapses or expands
  	And end session
