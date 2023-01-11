package org.test.template.time.GIT.ui.tests;

import org.openqa.selenium.Cookie;
import org.test.template.time.GIT.data.LoginDataProvider;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTestUnhappyFlow extends Helpers implements LoginDataProvider {

    Cookie userTokenCookie;

    @BeforeClass
    public void setupPage() throws InterruptedException {
        logger.info("Begin test");


        // Assert.assertEquals(driver.getTitle(), "Пошта - електронна пошта з доменами @i.ua, @ua.fm і @email.ua, створіть собі e-mail адресу на нашому порталі");

        //  Assert.assertEquals(driver.getTitle(), "Пошта - електронна пошта з доменами @i.ua, @ua.fm і @email.ua, створіть собі e-mail адресу на нашому порталі");
    }
    @Test(dataProvider = "ValidData")
    public void loginWithValidCreds(String userName, String password){
        logger.info("login = " + userName + " password = " + password);
        loginHappyMail(userName,password);
        userTokenCookie = driver.manage().getCookieNamed("I");
        System.out.println(userTokenCookie);

    }

    @Test(dataProvider = "ValidData")
    public void openSecondBrowzerAndLoginByCookie(String userName, String password){

        logger.info("login = " + userName + " password = " + password);
        loginHappyMail(userName,password);
        getCookie();
        openSecoundBrowzer();

        Assert.assertFalse(changeСookie());


    }
    @Test
    public void LoginwithCokieGithab(){
        Cookie getCookie = new Cookie("user_session","v4K1AiWTUgILS3EZk2dAh4nlyIAr0KFax3nNiZ_Ckq4l9YQZ");
        driver.manage().addCookie(getCookie);
        driver.navigate().refresh();

    }

}
