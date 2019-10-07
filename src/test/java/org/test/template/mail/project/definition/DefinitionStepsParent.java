package org.test.template.mail.project.definition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.test.template.mail.project.hooks.Hooks;

public abstract class DefinitionStepsParent {
    static WebDriver driver;
    static WebDriverWait wait;

    DefinitionStepsParent() {
        driver = Hooks.getDriver();
        wait = Hooks.getWaiter();
    }
}
