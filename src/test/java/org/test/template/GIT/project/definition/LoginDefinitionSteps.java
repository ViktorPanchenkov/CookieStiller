package org.test.template.GIT.project.definition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.test.template.GIT.project.pages.LoginForm;
import org.test.template.time.GIT.ui.tests.Helpers;
import org.test.template.time.GIT.ui.tests.TestBase;
import org.testng.Assert;

public class LoginDefinitionSteps  {
   WebDriver driver;
    private static String LOGED_USER_TITLE = "Почта - электронная почта с доменами @i.ua, @ua.fm и @email.ua";
  //  private MainPage mainPage = new MainPage(driver, wait);
    private LoginForm loginForm;
    final static String MAIN_PAGE_URL = "https://github.com/";
    public static final Logger logger = org.slf4j.LoggerFactory.getLogger(TestBase.class);
    Helpers helpers = new Helpers();
    Cookie stolenCookie;

    @Given("User navigate to the site")
    public void userNavigatesToSite() {
        try {
            //  WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get(MAIN_PAGE_URL);
            driver.manage().window().maximize();
        } catch (Exception e) {
            //e.printStackTrace();
            logger.error("Unable to start service: " + e.getMessage());
            System.exit(1);
        }
    }

    @When("User logs In with valid userName  and  password")
    public void login(){
        String login = "braumak@gmail.com";
        String password = "Evgeny@123";
        WebElement SingInFormButton = driver.findElement(By.xpath("//a[contains(text(),'Sign in')]"));
        SingInFormButton.click();
        WebElement login_el = driver.findElement(By.xpath("//input[@name='login']"));
        WebElement pass_el = driver.findElement(By.xpath("//input[@name='password']"));
        WebElement login_button = driver.findElement(By.xpath("//input[@value='Sign in']"));
        login_el.sendKeys(login);
        pass_el.sendKeys(password);
        login_button.click();
    }
    @And("User opens second browzer")
    public void openSecondBrowzer(){
       // WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(MAIN_PAGE_URL);
        driver.manage().window().maximize();
    }
    @And("User still cookie from first browzer")
    public void StillCookie(){
        stolenCookie =  driver.manage().getCookieNamed("user_session");
        System.out.println(stolenCookie);
    }
    @And("User change a cookie on new browzer window")
    public void ChangeCookie(){
        driver.manage().addCookie(stolenCookie);
        driver.navigate().refresh();
    }
    @And("User not able to still other people's cookies")
    public void changeСookie() {
        Assert.assertTrue(helpers.changeСookie());
    }

    @Given("Navigate login form")
    public void navigateLoginForm() {
     //   loginForm = mainPage.initLoginForm();
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
