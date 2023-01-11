package org.test.template.time.GIT.ui.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;

public class TestBase {

    public static final Logger logger = org.slf4j.LoggerFactory.getLogger(TestBase.class);


    static WebDriver driver;


    // private final static String PATH_TO_CHROMEDRIVER = "C:\\chromedriver_win32\\chromedriver.exe"; //move to properties TODO
    // private final static String PATH_TO_CHROMEDRIVER = "C:\\Users\\user\\Desktop\\chromdriver_win32";
    //final static String MAIN_PAGE_URL = "https://www.timedoctor.com/ru/about-us.html";
   // final static String MAIN_PAGE_URL = "https://mail.i.ua/";
      final static String MAIN_PAGE_URL = "https://github.com/";
    //Initialisation in constructor

    public TestBase() {
        try {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get(MAIN_PAGE_URL);
            driver.manage().window().maximize();
        } catch (Exception e) {
            //e.printStackTrace();
            logger.error("Unable to start service: " + e.getMessage());
            System.exit(1);
        }
    }








   public void loginHappyMail(String login, String password) {
        WebElement SingInFormButton = driver.findElement(By.xpath("//a[contains(text(),'Sign in')]"));
        SingInFormButton.click();
        WebElement login_el = driver.findElement(By.xpath("//input[@name='login']"));
        WebElement pass_el = driver.findElement(By.xpath("//input[@name='password']"));
        WebElement login_button = driver.findElement(By.xpath("//input[@value='Sign in']"));
        login_el.sendKeys(login);
        pass_el.sendKeys(password);
        login_button.click();



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