package com.example.stepdefinitions;

import io.cucumber.java.en.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LoginSteps {


    private static final Properties credentials = new Properties();
    private String username;
    private String password;

    static {
        try (InputStream input = LoginSteps.class.getClassLoader()
                .getResourceAsStream("credentials.properties")) {
            if (input != null) {
                credentials.load(input);
            } else {
                throw new RuntimeException("credentials.properties not found");
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load credentials.properties", e);
        }
    }

    @Given("the user navigates to the login page")
    public void the_user_navigates_to_the_login_page() {
        System.out.println("Navigated to login page");
    }

    @When("the user enters username {string} and password {string}")
    public void the_user_enters_username_and_password(String username, String password) {
        this.username = username;
        this.password = password;
        System.out.printf("Entered username: %s and password: %s%n", username, password);
    }

    @Then("validate password is correct or not")
    public void validate_password_is_correct_or_not() {
        boolean isValid = credentials.containsKey(username) && credentials.getProperty(username).equals(password);

        // For invalid credentials scenario, assertFalse; for valid, assertTrue
        boolean expectInvalid = !isValid;
        if (expectInvalid) {
            System.out.printf("Password is incorrect for user: %s%n", username);
            assertFalse("Password should be invalid", isValid);
        } else {
            System.out.printf("Password is correct for user: %s%n", username);
            assertTrue("Password should be valid", isValid);
        }
    }
}