package org.test.template.time.GIT.ui.tests;

import org.openqa.selenium.*;
import org.testng.Assert;

public class Helpers extends TestBase {

    Cookie stolenCookie;

    public void openSecoundBrowzer() {
       // WebDriverManager.chromedriver().setup();
      //  driver = new ChromeDriver();
        driver.get(MAIN_PAGE_URL);
        driver.manage().window().maximize();
    }

    public void getCookie(){
        stolenCookie =  driver.manage().getCookieNamed("user_session");
        System.out.println(stolenCookie);
    }

    public boolean changeСookie(){
        try {
        //    Cookie getCookie = new Cookie("user_session","480xD8m6B8qcSB46s6ar7LynvPACdawI4t8N6qH20v6BvVGY");
            driver.switchTo().newWindow(WindowType.WINDOW);
            driver.manage().addCookie(stolenCookie);
            driver.navigate().refresh();
            return true;
        } catch (InvalidCookieDomainException invalidCookieDomainException){
            Assert.fail(invalidCookieDomainException.getMessage() + "  It's a bad idea to steal other people's cookies");
            return false;
        }
    }
}
