package org.test.template.mail.project.definition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.test.template.mail.project.pages.LoginForm;
import org.test.template.mail.project.pages.MainPage;
import org.testng.Assert;

public class LoginDefinitionSteps extends DefinitionStepsParent {
    private static String LOGED_USER_TITLE = "Почта - электронная почта с доменами @i.ua, @ua.fm и @email.ua";

    private MainPage mainPage = new MainPage(driver, wait);
    private LoginForm loginForm;

    @Given("Navigate login form")
    public void navigateLoginForm() {
        loginForm = mainPage.initLoginForm();
    }

    @When("User enters \"([^\"]*)\" to the login field")
    public void enterValueToLoginField(final String value) {
        loginForm.getEmailInputField().sendKeys(value);
    }

    @When("User enters \"([^\"]*)\" to the password field")
    public void enterValueToPasswordField(final String value) {
        loginForm.getPasswordInputField().sendKeys(value);
    }

    @When("User presses login button")
    public void clickLoginButton() {
        loginForm.getSubmitButton().click();
    }

    @Then("User sees \"([^\"]*)\" login")
    public void userVerifiesThatLoginFailed(String loginStatus) throws InterruptedException {
        if (loginStatus.equals("failed")) {
            Assert.assertFalse(driver.getTitle().contains(LOGED_USER_TITLE));
        } else {
            Assert.assertTrue(driver.getTitle().contains(LOGED_USER_TITLE));
        }
    }
}
