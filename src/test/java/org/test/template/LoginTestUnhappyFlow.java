package org.test.template;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTestUnhappyFlow extends TestBase {

    @BeforeTest
    public void setupPage() throws InterruptedException {
        logger.info("Begin test");
        //moveToStartPage();
        Assert.assertEquals(driver.getTitle(), "Мониторинг персонала. Узнайте о нас - Тайм Доктор");
        WebElement el = driver.findElement(By.id("sign-in"));
        click(el);
        Assert.assertEquals(driver.getTitle(), "Login to Time Doctor");
    }

    @BeforeMethod
    public void returnToLoginPage() {
        logger.info("Return login Page");
        //moveToLoginPage();
    }

    @DataProvider(name = "provideCredentials")
    public Object[][] provideData() {

        return new Object[][] {
                { "angeleclipse3@gmail.com", "angele_clip_3" },
                { "Angel", "angele_clip_3" },
                { "Angel", "testpass" },
                { "", "testpass" },
                { "angeleclipse3@gmail.com", "" },
                { "angeleclipse3@gmail.com", "“[|]’~<!--@/*$%^&#*/()?>,.*/\\" },
                { "angeleclipse3@gmail.com",
                        "asafsfsddddddddddddddddddddkkkkkkkkkkkkkkkkkkkkkkkkkkkkkeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee3333333333333333344444444444" },
                { "angeleclipse3@gmail.com",
                        "testpassssssssssssssssssssssssSSSSSSSSSSSSSSSSSSSSSSSsssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss" },
                { "angeleclipse3@gmail.com", "s" },
                { "angeleclipse3@gmail.com", "пароль" },
                { "angeleclipse3@gmail.com", "null" },
                { "angeleclipse3@gmail.com", "12312" },
                { "testpass", "angeleclipse3@gmail.com" },
                { "DROP TABLE user;", "testpass" } //Depends on DB

        };
    }

    @Test(dataProvider = "provideCredentials")
    public void loginOnDoctorPage(String login, String password) throws Exception {

        logger.info("login = " + login + " password = " + password);
        loginHappy(login, password);

        //WAIT Till CAPTCHA Reset

        Assert.assertNotEquals(driver.getTitle(), "Angel's Company - Dashboard");
        // TODO link check
    }

    //For example one method for check error message
    @Test
    public void invalidLoginPasswordAlertMessage() throws Exception {

        loginHappy(TestBase.INVALID_LOGIN, TestBase.INVALID_PASSWORD);
        WebElement messageBox_el = driver.findElement(By.id("messageBox"));
        String message = messageBox_el.getText();
        Assert.assertEquals(message, "Invalid Email or Password");

    }

    @AfterMethod
    public static void quitLoginPage() {
        //logger.info("Quit from login Page");
        //"Login to Time Doctor"
        driver.navigate().refresh();

        WebElement myDynamicElement = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("signinFormMiddle")));

    }

    @AfterTest
    public static void tearDown() {
        logger.info("End test");
        driver.quit();
        service.stop();
    }
}
