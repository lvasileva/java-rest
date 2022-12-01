package example.qa;

import example.qa.steps.InitializerSteps;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class Configuration {

    private static final String BASE_URL = "https://api.unsplash.com/";

    public static RequestSpecification getRequestHeaders(){
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();

        request.header("Authorization", "Bearer "+ InitializerSteps.token);
        request.header("Accept-Version", "v1");
        return request;
    }



}
