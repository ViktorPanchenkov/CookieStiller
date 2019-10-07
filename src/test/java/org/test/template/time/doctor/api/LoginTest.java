package org.test.template.time.doctor.api;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @BeforeTest
    public void setup() {
        //TODO:
        apiHelper.createUser("url", "name", "pass");
    }


    @Test
    public void invalidLoginTest() throws Exception {



    }

    @AfterTest
    public void tearDown() {
        //TODO:
    }
}
