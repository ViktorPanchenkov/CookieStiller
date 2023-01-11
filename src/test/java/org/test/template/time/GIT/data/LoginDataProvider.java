package org.test.template.time.GIT.data;

import org.testng.annotations.DataProvider;

public interface LoginDataProvider {
    @DataProvider(name = "ValidData")
    public static Object[][] ValidLoginData() {
        Object[][] ValidLoginData = {{"someEmail","SomePassword"}};
        return ValidLoginData;
    }
}
