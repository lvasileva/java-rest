package example.qa.steps;

import example.qa.Configuration;
import example.qa.data.Collection;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.util.Arrays;
import java.util.List;

import static org.apache.http.HttpStatus.*;

public class BaseCollection {

    public Collection createCollectionWithName(String collectionName) throws Exception {
        RequestSpecification request = Configuration.getRequestHeaders();
        Response response = request.param("title", collectionName).post("/collections");
        checkIfStatus(response, SC_CREATED);
        return response.body().as(Collection.class);
    }

    public Collection updateCollectionNameById(String id, String collectionName) throws Exception {
        RequestSpecification request = Configuration.getRequestHeaders();
        Response response = request.params("title", collectionName).put("/collections/"+id);
        checkIfStatus(response, SC_OK);
        return response.body().as(Collection.class);
    }

    public void deleteCollectionById(String id) throws Exception {
        RequestSpecification request = Configuration.getRequestHeaders();
        Response response = request.param("id", id).delete("/collections/"+id);
        checkIfStatus(response, SC_NO_CONTENT);
    }

    public boolean isUserCollectionExistByName(String username, String collectionName) throws Exception {
        List<Collection> list = getAllUserCollections(username);
        boolean found = false;
        for (Collection collection : list) {
            if (collection.getTitle().equalsIgnoreCase(collectionName)) {
                found = true;
                break;
            }
        }
        return found;
    }

    public Collection getUserCollectionByName(String username, String collectionName) throws Exception {
        List<Collection> list = getAllUserCollections(username);
        Collection collection = new Collection();
        if (!isUserCollectionExistByName(username, collectionName)) {
            Assert.fail("No collection with name " + collectionName + " was found for user " + username);
        }
        for (Collection c : list) {
            if (c.getTitle().equalsIgnoreCase(collectionName)){
                collection = c;
                break;
            }
        }
        return collection;
    }

    public List<Collection> getAllUserCollections(String username) throws Exception {

        RequestSpecification request = Configuration.getRequestHeaders();
        Response response = request.get("/users/" + username + "/collections");
        checkIfStatus(response, SC_OK);
        return Arrays.asList(response.body().as(Collection[].class));
    }

    private void checkIfStatus(Response response, int status) throws Exception {
        try {
            response.then().assertThat().statusCode(status);
        } catch (AssertionError e) {
            if (response.getStatusCode() == SC_FORBIDDEN && response.getBody().prettyPrint().equals("Rate Limit Exceeded")) {
                throw new Exception("Sorry, you exceeded the Unsplash API rate limit (50 requests per hour). Please re-run tests later");
            } else throw new Exception(response.getBody().prettyPrint());
        }
    }
}
