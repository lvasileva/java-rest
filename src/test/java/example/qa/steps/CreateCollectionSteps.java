package example.qa.steps;

import example.qa.ScenarioContext;
import example.qa.data.Collection;
import example.qa.enums.Context;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.ZonedDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateCollectionSteps extends BaseCollection {

    public static ScenarioContext scenarioContext;

    public CreateCollectionSteps(final ScenarioContext context) {
        scenarioContext = context;
    }

    @When("user creates new collection")
    public void userCreatesNewCollection() throws Exception {
        scenarioContext.setContext(Context.COLLECTION, createCollectionWithName("autotest " + ZonedDateTime.now()));
    }

    @Then("new user's collection is added")
    public void newCollectionIsAdded() throws Exception {
        List<Collection> list = getAllUserCollections(InitializerSteps.username);
        assertThat(list).as("No expected collection found").contains((Collection) scenarioContext.getContext(Context.COLLECTION));
    }
}
