package example.qa.steps;

import example.qa.enums.Context;
import example.qa.ScenarioContext;
import example.qa.data.Collection;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DeleteCollectionSteps extends BaseCollection {

    public static ScenarioContext scenarioContext;

    public DeleteCollectionSteps(final ScenarioContext context) {
        scenarioContext = context;
    }

    @When("user deletes the collection")
    public void userDeletesTheCollection() throws Exception {
        Collection collection = (Collection) scenarioContext.getContext(Context.COLLECTION);
        deleteCollectionById(collection.getId());
    }

    @Then("the collection is deleted")
    public void theCollectionIsDeleted() throws Exception {
        Collection collection = (Collection) scenarioContext.getContext(Context.COLLECTION);
        List<Collection> collectionList = getAllUserCollections(InitializerSteps.username);
        assertThat(collectionList).as("User's " + InitializerSteps.username + " collection list contains the collection " + collection.getTitle()).doesNotContain(collection);
    }
}
