package org.test.template.mail.project.definition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class BaseDefinitionSteps extends DefinitionStepsParent {
    private final static String MAIN_PAGE_URL = "https://mail.i.ua/";

    @Given("User navigate to the site")
    public void userNavigatesToSite() {
        driver.get(MAIN_PAGE_URL);
    }

    @When("User presses Enter key")
    public void userPressesEnterKey() {
    }

}
