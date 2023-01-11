package org.test.template.GIT.project.definition;

import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.test.template.time.GIT.ui.tests.TestBase;

public class BaseDefinitionSteps {
    WebDriver driver;

    public static final Logger logger = org.slf4j.LoggerFactory.getLogger(TestBase.class);
    private final static String MAIN_PAGE_URL = "https://github.com/";




    @When("User enter a userName")
    public void userPressesEnterKey() {
    }

}
