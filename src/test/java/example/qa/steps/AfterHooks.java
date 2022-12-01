package example.qa.steps;

import example.qa.ScenarioContext;
import example.qa.data.Collection;
import example.qa.enums.Context;
import io.cucumber.java.After;

public class AfterHooks extends BaseCollection {

    public static ScenarioContext scenarioContext;

    public AfterHooks(final ScenarioContext context) {
        scenarioContext = context;
    }

    @After("@collections")
    public void deleteCollection() {
        Collection collection = (Collection) scenarioContext.getContext(Context.COLLECTION);

        if (isUserCollectionExistByName(InitializerSteps.username, collection.getTitle())) {
            deleteCollectionById(collection.getId());
        }
    }
}
