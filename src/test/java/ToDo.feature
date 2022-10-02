#Author: your.email@your.domain.com

Feature: Manage todo list
	
Background:
 Given user is on the todo list page  
   
@sanity
Scenario Outline: user adds item to the list
    When user enters his todo list items 
    Then verify that the item gets added to his todo list under All tab
    And verify the count of the items in the All reflects Active items count
    Then end session
	
@sanity
Scenario: Marking an item complete
    When the user marks the item as complete by selecting it 
    Then verify that the item is moved to completed and clear completed option shows up
    And verify the item appears under All tab as well
    Then verify the count of the items in the All reflects Active items count
    And end session
    
@sanity
Scenario: Marking an item back to acitve 
    When the user unmarks the item back to Active by deselecting it 
    Then verify that the item is moved back to Active 
    And verify the item appears under All tab as well
    Then verify the count of the items in the All reflects Active items count
    And end session
    
@sanity
Scenario: clear the completed items
   When the user clicks on clear completed 
   Then verify that the completed items are removed from completed tab
   And verify the item does not appears under All tab as well
   Then verify the count of the items in the All reflects Active items count
   And end session

@sanity
Scenario Outline: Removing the item by clicking on X icon 
   When the user clicks on the X icon of the item in <tab> 
   Then verify that the item is removed from the <tab> tab
   And end session
Examples: 
      |   tab    | 
      |All       |
      |Active    |
      |Completed |
   
  @sanity
  Scenario: Clicking on the down arrow in All tab
     When the user clicks on the down arrow in All tab  
     Then verify that all the items are marked as completed
     And end session
  
  @sanity
  Scenario: Clicking on the down arrow in Active tab
      When the user clicks on the down arrow in Active tab  
      Then verify that the items dropdown collapses or expands
      And end session
