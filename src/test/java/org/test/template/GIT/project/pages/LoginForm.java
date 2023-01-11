package org.test.template.GIT.project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginForm extends BasePage {


    @FindBy(xpath = "//input[@name='login']")
    private WebElement loginInput;

    @FindBy(xpath = "//input[@name='pass']")
    private WebElement passwordInputField;

    @FindBy(xpath = "//input[@value='Увійти']")
    private WebElement submitButton;

    public WebElement getEmailInputField() {
        return loginInput;
    }


    public WebElement getPasswordInputField() {
        return passwordInputField;
    }

    public void setPasswordInputField(WebElement passwordInputField) {
        this.passwordInputField = passwordInputField;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    LoginForm(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
}
