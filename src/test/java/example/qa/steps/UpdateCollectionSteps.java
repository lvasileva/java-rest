package example.qa.steps;

import example.qa.enums.Context;
import example.qa.ScenarioContext;
import example.qa.data.Collection;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class UpdateCollectionSteps extends BaseCollection {

    public static ScenarioContext scenarioContext;

    public UpdateCollectionSteps(final ScenarioContext context) {
        scenarioContext = context;
    }

    @And("user's collection with name {string} is exist")
    public void userSCollectionWithNameIsExist(String collectionName) throws Exception {
        if (!isUserCollectionExistByName(InitializerSteps.username, collectionName)) {
            createCollectionWithName(collectionName);
        }
        scenarioContext.setContext(Context.COLLECTION, getUserCollectionByName(InitializerSteps.username, collectionName));
    }

    @When("user updates the collection name to {string}")
    public void userUpdatesTheCollectionNameTo(String collectionName) throws Exception {
        Collection collection = (Collection) scenarioContext.getContext(Context.COLLECTION);
        scenarioContext.setContext(Context.COLLECTION_NAME, collectionName);
        scenarioContext.setContext(Context.COLLECTION, updateCollectionNameById(collection.getId(), collectionName));
    }

    @Then("the collection name is updated")
    public void theCollectionNameIsUpdated() {
        Collection collection = (Collection) scenarioContext.getContext(Context.COLLECTION);
        String collectionName = (String) scenarioContext.getContext(Context.COLLECTION_NAME);
        assertThat(collection.getTitle()).as("Collection name was not updated to " + collectionName).isEqualTo(collectionName);
    }
}
