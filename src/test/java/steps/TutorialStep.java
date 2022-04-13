package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.util.EnvironmentVariables;
import pages.*;
import utils.Type;

import static org.assertj.core.api.Assertions.assertThat;

public class TutorialStep {
    private EnvironmentVariables env;
    private LoginPage loginPage;
    private ProfilePage profilePage;
    private NavBottomPage navBottomPage;
    private TutorialPage tutorialPage;
    private ActiveAssignmentPage activeAssignmentPage;
    private String type;


    @Given("Login to app")
    public void loginToApp() {
        String email = EnvironmentSpecificConfiguration.from(env).getProperty("username");
        String pass = EnvironmentSpecificConfiguration.from(env).getProperty("password");
        loginPage.loginToApp(email, pass);
    }

    @And("Clear tutorial")
    public void clearData(){
        activeAssignmentPage.deleteAllTutorial();
    }

    @When("Create tutorial with type = {}")
    public void createTutorialWithType(String type){
        navBottomPage.clickProfileTab();
        profilePage.clickTutorialLink();
        tutorialPage.chooseTutorialByType(type);
        this.type= type;
    }

    @Then("Create successful with message : {}")
    public void checkTutorialCreatedSuccessWithMessage(String message){
        boolean isDisplay= activeAssignmentPage.checkPageHasMessage(message);
        assertThat(isDisplay).isTrue();
    }

    @And("Check text in screen Active Assignment Title = {}, Desc = {}")
    public void checkTextInScreenActiveAssignment(String title, String desc){
        boolean isDisplayTitle= activeAssignmentPage.checkPageHasMessage(title);
        assertThat(isDisplayTitle).isTrue();
        boolean isDisplayDesc= activeAssignmentPage.checkPageHasMessage(desc);
        assertThat(isDisplayDesc).isTrue();
    }

    @When("Create tutorial with same type")
    public void createTutorialSameType(){
        navBottomPage.clickProfileTab();
        profilePage.clickTutorialLink();
        tutorialPage.chooseTutorialByType(type);
    }

    @Then("Create failed with message: {}")
    public void checkCreateTutorialFailedWithMessage(String message){
        boolean isDisplay= activeAssignmentPage.checkPageHasMessage(message);
        assertThat(isDisplay).isTrue();
    }
}
