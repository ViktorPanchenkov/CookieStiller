package org.test.template.data;

import java.util.HashMap;
import java.util.Map;

public abstract class TestData {

    private static final Map<String, String> user;

    public static Map<String, String> getUser() {
        return user;
    }

    static {
        user = new HashMap<>();
        //user.put("email", "technicaluser121@gmail.com");
        //user.put("password", "1234567");
        user.put("first_name", "Nick");
        user.put("last_name", "");

        user.put("phone", "222222222222222");
        user.put("company_phone", "");
        user.put("company_email", "");

    }
}
