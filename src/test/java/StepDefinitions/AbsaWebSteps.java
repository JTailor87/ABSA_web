package StepDefinitions;

import io.cucumber.java.en.*;
import io.cucumber.datatable.DataTable;
import org.example.factory.DriverFactory;
import org.example.pages.AbsaWebPage;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class AbsaWebSteps {
    private AbsaWebPage absaWebPage = new AbsaWebPage(DriverFactory.getDriver());

    @Given("User navigate to a URL {string}")
    public void user_navigate_to_a_url(String url) {
        DriverFactory.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        DriverFactory.getDriver().get(url);
    }
    @When("User open the url validate that you are on User List Table with page tile {string}")
    public void user_open_the_url_validate_that_you_are_on_user_list_table_with_page_tile(String title) {
        Assert.assertEquals(title, absaWebPage.validateYouAreOnUserListTable(), "Page titles are not same");
        System.out.println("User On: "+title);
    }
    @When("User click the Add User button")
    public void user_click_the_add_user_button() throws InterruptedException {
        absaWebPage.clickTheAddUser();
    }
    @When("User add the user with {string} {string} {string} {string} {string} {string} {string} {string}")
    public void user_add_the_user_with(String name, String lastName, String userName, String password, String customer, String role, String email, String cell) {
        absaWebPage.addUser(name,lastName, userName, password, customer, role, email, cell);
        absaWebPage.clickSave();
    }
    @When("User add the users")
    public void user_add_the_user_with(DataTable userDetails) throws InterruptedException {
        List<Map<String, String>> users = userDetails.asMaps(String.class, String.class);
        int numberOfRows = users.size();
        System.out.println("Number of data rows (excluding header): " + numberOfRows);
        for (int i = 0; i < numberOfRows; i++) {
            Map<String, String> user = users.get(i);

            absaWebPage.addUser(
                    user.get("FirstName"),
                    user.get("LastName"),
                    user.get("UserName"),
                    user.get("Password"),
                    user.get("Customer"),
                    user.get("Role"),
                    user.get("Email"),
                    user.get("Cell")
            );
            absaWebPage.clickSave();
            // Check if the current user is not the last one before clicking "Add User"
            if (i < numberOfRows - 1) {
                absaWebPage.clickTheAddUser();
            }
        }
    }
    @Then("validate the user is added to the list {string}")
    public void validate_the_user_is_added_to_the_list(String name) {
        Assert.assertEquals(name, absaWebPage.validateThatUserAdded(name), "User is not added on the list");
    }
    @Then("validate the users are added to the list")
    public void validate_the_users_are_added_to_the_list() {
        Assert.assertEquals("FName1", absaWebPage.validateThatUser1Added(), "User_1 is not added on the list");
        Assert.assertEquals("FName2", absaWebPage.validateThatUser2Added(), "User_2 is not added on the list");
    }
}
