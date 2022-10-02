package StepDefinitions;

import java.net.MalformedURLException;

import Pages.ToDoPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ToDoSteps {
	private final ToDoPage toDoPage = new ToDoPage();
	
@Given("user is on the todo list page")
public void user_is_on_the_todo_list_page() throws MalformedURLException {
	toDoPage.launchUI();
   
}

@When("user enters his todo list items")
public void user_enters_his_todo_list_items() {
    toDoPage.enterItem();
}

@Then("verify that the develop gets added to his todo list under All tab")
public void verify_that_the_develop_gets_added_to_his_todo_list_under_All_tab() {
	
}

@Then("verify the count of the items in the All reflects Active items count")
public void verify_the_count_of_the_items_in_the_All_reflects_Active_items_count() {
  
}

@Then("verify that the test gets added to his todo list under All tab")
public void verify_that_the_test_gets_added_to_his_todo_list_under_All_tab() {
    
}

@Then("verify that the deploy gets added to his todo list under All tab")
public void verify_that_the_deploy_gets_added_to_his_todo_list_under_All_tab() {
    
}

@Then("verify that the maintenance gets added to his todo list under All tab")
public void verify_that_the_maintenance_gets_added_to_his_todo_list_under_All_tab() {
   
}

@Then("verify that the support gets added to his todo list under All tab")
public void verify_that_the_support_gets_added_to_his_todo_list_under_All_tab() {
    
}

@When("the user marks the item as complete by selecting it")
public void the_user_marks_the_item_as_complete_by_selecting_it() {
   
}

@Then("verify that the item is moved to completed and clear completed option shows up")
public void verify_that_the_item_is_moved_to_completed_and_clear_completed_option_shows_up() {
   
}

@Then("verify the item appears under All tab as well")
public void verify_the_item_appears_under_All_tab_as_well() {
   
}

@When("the user unmarks the item back to Active by deselecting it")
public void the_user_unmarks_the_item_back_to_Active_by_deselecting_it() {
    
}

@Then("verify that the item is moved back to Active")
public void verify_that_the_item_is_moved_back_to_Active() {
   
}

@When("the user clicks on clear completed")
public void the_user_clicks_on_clear_completed() {

}

@Then("verify that the completed items are removed from completed tab")
public void verify_that_the_completed_items_are_removed_from_completed_tab() {
   
}

@Then("verify the item does not appears under All tab as well")
public void verify_the_item_does_not_appears_under_All_tab_as_well() {
    
}

@When("the user clicks on the X icon of the item in All")
public void the_user_clicks_on_the_X_icon_of_the_item_in_All() {
    
}

@Then("verify that the item is removed from the All tab")
public void verify_that_the_item_is_removed_from_the_All_tab() {
    
}

@When("the user clicks on the X icon of the item in Active")
public void the_user_clicks_on_the_X_icon_of_the_item_in_Active() {
   
}

@Then("verify that the item is removed from the Active tab")
public void verify_that_the_item_is_removed_from_the_Active_tab() {
   
}

@When("the user clicks on the X icon of the item in Completed")
public void the_user_clicks_on_the_X_icon_of_the_item_in_Completed() {
   
}

@Then("verify that the item is removed from the Completed tab")
public void verify_that_the_item_is_removed_from_the_Completed_tab() {
   
}

@When("the user clicks on the down arrow in All tab")
public void the_user_clicks_on_the_down_arrow_in_All_tab() {

}

@Then("verify that all the items are marked as completed")
public void verify_that_all_the_items_are_marked_as_completed() {
    
}

@When("the user clicks on the down arrow in Active tab")
public void the_user_clicks_on_the_down_arrow_in_Active_tab() {
  
}

@Then("verify that the items dropdown collapses or expands")
public void verify_that_the_items_dropdown_collapses_or_expands() {
      
}

@Then("end session")
public void closeBrowser() {
	toDoPage.closeBrowser();
}
}
