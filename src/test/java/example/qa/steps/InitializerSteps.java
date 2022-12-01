package example.qa.steps;

import io.cucumber.java.en.Given;

public class InitializerSteps {

    public static String token;
    public static String username;

    @Given("user is authorized")
    public void userIsAuthorized() {
        username = "lvasileva";
        token = System.getenv("UNSPLASH_TOKEN");
    }
}
