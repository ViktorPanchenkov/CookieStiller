package org.test.template.mail.project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends BasePage {
    @FindBy(xpath = "//*[@id=\"header_overall\"]/div[1]/ul[3]/li[1]/a")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"FloatLogin\"]")
    private WebElement loginForm;

    @FindBy(xpath = "//body/div[2]/div[3]/ul[1]/li[8]/a")
    private WebElement logoutButton;

    @FindBy(xpath = "//body/div[2]/div[3]/ul[1]/li[3]/a")
    private WebElement registrationButton;

    public WebElement getRegistrationButton() {
        return registrationButton;
    }

    public WebElement getLogoutButton() {
        return logoutButton;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getLoginForm() {
        return loginForm;
    }

    public MainPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public LoginForm initLoginForm() {
        loginButton.click();
        wait.until((ExpectedConditions.visibilityOf(loginForm)));
        return new LoginForm(driver, wait);
    }
}
