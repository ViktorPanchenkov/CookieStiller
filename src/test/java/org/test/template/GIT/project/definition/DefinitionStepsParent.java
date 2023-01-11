package org.test.template.GIT.project.definition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.test.template.GIT.project.hooks.Hooks;
import org.test.template.time.GIT.ui.tests.TestBase;

public abstract class DefinitionStepsParent {
    static WebDriver driver;
    static WebDriverWait wait;
    public static final Logger logger = org.slf4j.LoggerFactory.getLogger(TestBase.class);

    DefinitionStepsParent() {
        driver = Hooks.getDriver();
        wait = Hooks.getWaiter();
    }

}
