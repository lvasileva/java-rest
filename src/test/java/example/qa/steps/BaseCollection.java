package example.qa.steps;

import example.qa.Configuration;
import example.qa.data.Collection;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.junit.Assert;

import java.util.Arrays;
import java.util.List;

public class BaseCollection {

    public Collection createCollectionWithName(String collectionName) {
        RequestSpecification request = Configuration.getRequestHeaders();
        Response response = request.param("title", collectionName).post("/collections");
        response.then().assertThat().statusCode(HttpStatus.SC_CREATED);
        return response.body().as(Collection.class);
    }

    public Collection updateCollectionNameById(String id, String collectionName) {
        RequestSpecification request = Configuration.getRequestHeaders();
        Response response = request.params("title", collectionName).put("/collections/"+id);
        response.then().assertThat().statusCode(HttpStatus.SC_OK);
        return response.body().as(Collection.class);
    }

    public void deleteCollectionById(String id) {
        RequestSpecification request = Configuration.getRequestHeaders();
        Response response = request.param("id", id).delete("/collections/"+id);
        response.then().assertThat().statusCode(HttpStatus.SC_NO_CONTENT);
    }

    public boolean isUserCollectionExistByName(String username, String collectionName) {
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

    public Collection getUserCollectionByName(String username, String collectionName) {
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

    public List<Collection> getAllUserCollections(String username) {

        RequestSpecification request = Configuration.getRequestHeaders();
        Response response = request.get("/users/" + username + "/collections");
        response.then().assertThat().statusCode(HttpStatus.SC_OK);
        return Arrays.asList(response.body().as(Collection[].class));
    }
}
