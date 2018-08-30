package org.test.template;

import io.restassured.response.ValidatableResponse;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.test.template.data.TestData;
import sun.security.util.PendingException;

import static io.restassured.RestAssured.given;

import java.util.Map;

public class ApiHelper {

    static final Logger logger = LogManager.getLogger(ApiHelper.class);

    public void createUser(String url, String username, String pass) {
        Map<String, String> user = TestData.getUser();
        user.put("email", username);
        user.put("password", pass);
        user.put("debug", "1fdsgfghrt45364t");
        ValidatableResponse response = null;
        try {
            response = sendPostRequest(user, url);
            if (response != null) {
                String link = response.extract().body().jsonPath().getString("confirmation_link");
                if (link != null) {
                    sendGetRequest(null, link);
                }
            }
        } catch (PendingException ex) {

        }
    }

    public ValidatableResponse sendPostRequest(Map<String, String> body, String url) throws PendingException {
        ValidatableResponse response;

        response = given().contentType("application/json").body(body).post(url).then();

        logger.debug("header = " + response.extract().response().getStatusCode());

        if (response.extract().response().getStatusCode() > 299) {
            throw new PendingException(
                    "POST request is not successful: " + "Status:" + response.extract().response().getStatusCode() + " Body: " + response.extract().body()
                            .asString());
        }
        return response;
    }

    public ValidatableResponse sendPostRequestWithToken(Map<String, String> body, String url, String token) throws PendingException {
        ValidatableResponse response;

        response = given().contentType("application/json").header("authorization", "Bearer " + token).body(body).post(url).then();

        if (response.extract().response().getStatusCode() > 299) {
            throw new PendingException(
                    "POST request is not successful: " + "Status:" + response.extract().response().getStatusCode() + " Body: " + response.extract().body()
                            .asString());
        }
        return response;
    }

    public ValidatableResponse sendGetRequest(Map<String, String> body, String url) throws PendingException {

        ValidatableResponse response;

        if (body == null) {
            response = given().contentType("application/json").get(url).then();
        } else {
            response = given().contentType("application/json").body(body).get(url).then();
        }

        if (response.extract().response().getStatusCode() > 299) {
            throw new PendingException(
                    "GET request is not successful: " + "Status:" + response.extract().response().getStatusCode() + " Body: " + response.extract().body()
                            .asString());
        }
        return response;
    }

    public ValidatableResponse sendGetRequestWithToken(Map<String, String> body, String url, String token) throws PendingException {
        ValidatableResponse response;

        if (body == null) {
            response = given().contentType("application/json").header("authorization", "Bearer " + token).get(url).then();
        } else {
            response = given().contentType("application/json").header("authorization", "Bearer " + token).body(body).get(url).then();
        }

        if (response.extract().response().getStatusCode() > 299) {
            throw new PendingException(
                    "GET request is not successful: " + "Status:" + response.extract().response().getStatusCode() + " Body: " + response.extract().body()
                            .asString());
        }
        return response;
    }
}
