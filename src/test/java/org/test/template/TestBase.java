package org.test.template;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class TestBase {

    public static final Logger logger = org.slf4j.LoggerFactory.getLogger(TestBase.class);

    static ChromeDriverService service;
    static WebDriver driver;
    private final static String PATH_TO_CHROMEDRIVER = "c:\\work\\chromedrv\\chromedriver_2_31.exe"; //move to properties TODO

    final static String VALID_LOGIN = "angeleclipse3@gmail.com";
    final static String VALID_PASSWORD = "testpass";

    final static String INVALID_LOGIN = "323angee3@gmail.com";
    final static String INVALID_PASSWORD = "Afsdfwe";
    //Initialisation in constructor

    public TestBase() {
        try {
            service = new ChromeDriverService.Builder()
                    .usingDriverExecutable(new File(PATH_TO_CHROMEDRIVER))
                    .usingAnyFreePort()
                    .build();
            service.start();
            driver = new RemoteWebDriver(service.getUrl(), DesiredCapabilities.chrome());
        } catch (Exception e) {
            //e.printStackTrace();
            logger.error("Unable to start service: " + e.getMessage());
            System.exit(1);
        }
    }

    public Map setTestCaseStatus(boolean testResult) {
        Map data = new HashMap();
        int i = 0;
        if (testResult == true) {
            i = 1;
            data.put("comment", "This tests worked fine!");
        } else {
            i = 5;
            data.put("comment", "This tests failed!");
        }
        data.put("status_id", new Integer(i));
        return data;
    }

    void click(WebElement el) throws InterruptedException {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(el));
        el.click();
    }

    void loginHappy(String login, String password) {
        WebElement login_el = driver.findElement(By.id("email"));
        WebElement pass_el = driver.findElement(By.id("password"));

        login_el.sendKeys(login);
        pass_el.sendKeys(password);

        WebElement signIn_el = driver.findElement(By.id("signinFormButton"));

        signIn_el.click();

    }

    //Managing CAPTCHA
    void loginUnHappy(String login, String password) {

        WebElement login_el = driver.findElement(By.id("email"));
        WebElement pass_el = driver.findElement(By.id("password"));

        login_el.sendKeys(login);
        pass_el.sendKeys(password);

        WebElement signIn_el = driver.findElement(By.id("signinFormButton"));

        if (driver.findElement(By.xpath("//div[@class='g-recaptcha']")).isDisplayed()) {
            driver.switchTo().frame(driver.findElement(By.xpath(
                    "//iframe[contains(@sandbox ,'allow-forms allow-popups allow-same-origin allow-scripts allow-top-navigation allow-modals allow-popups-to-escape-sandbox')]")));
            WebElement recaptcha_el = driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-checkmark']"));

            if (recaptcha_el.isDisplayed()) {
                recaptcha_el.click();
            }
            driver.switchTo().defaultContent();
        }

        signIn_el.click();
    }
}