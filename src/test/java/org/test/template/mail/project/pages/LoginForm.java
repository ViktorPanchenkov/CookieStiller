package org.test.template.mail.project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginForm extends BasePage {

    @FindBy(xpath = "//*[@id=\"FloatLogin\"]//p[1]/input")
    private WebElement emailInputField;

    @FindBy(xpath = "//*[@id=\"FloatLogin\"]//p[2]/input")
    private WebElement passwordInputField;

    @FindBy(xpath = "//*[@id=\"FloatLogin\"]//input[6]")
    private WebElement submitButton;

    public WebElement getEmailInputField() {
        return emailInputField;
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
