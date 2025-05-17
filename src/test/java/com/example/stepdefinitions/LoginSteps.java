package com.example.stepdefinitions;

import com.example.util.Credentials;
import io.cucumber.java.en.*;
import static org.junit.Assert.*;

public class LoginSteps {

    private static final Credentials credentials = new Credentials("credentials.properties");
    private String username;
    private String password;
    private String message;

    @Given("the user navigates to the login page")
    public void the_user_navigates_to_the_login_page() {
        System.out.println("User navigates to login page");
    }

    @When("the user enters username {string} and password {string}")
    public void the_user_enters_username_and_password(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Then("validate password is correct or not")
    public void validate_password_is_correct_or_not() {
        if (credentials.isValid(username, password)) {
            message = "dashboard";
            System.out.println("Password is correct. User logged in successfully.");
        } else {
            message = "Invalid credentials";
            System.out.println("Invalid credentials. User failed to log in.");
        }

        System.out.println("Validation result: " + message);
    }
}