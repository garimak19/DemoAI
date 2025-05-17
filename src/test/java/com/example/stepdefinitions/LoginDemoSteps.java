package com.example.stepdefinitions;

import io.cucumber.java.en.*;
import static org.junit.Assert.*;

public class LoginDemoSteps {

    private String username;
    private String password;
    private String message;

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        System.out.println("User navigates to login page");
    }

    @When("the user logs in with username {string} and password {string}")
    public void the_user_logs_in_with_username_and_password(String username, String password) {
        this.username = username;
        this.password = password;
        // Simulate login logic
        if ("user1".equals(username) && "password123".equals(password)) {
            message = "dashboard";
        } else {
            message = "Invalid credentials";
        }
    }

    @Then("the system should display the dashboard")
    public void the_system_should_display_the_dashboard() {
        assertEquals("dashboard", message);
        System.out.println("Dashboard displayed");
    }

    @When("the user submits the login form with empty username and password")
    public void the_user_submits_the_login_form_with_empty_username_and_password() {
        this.username = "";
        this.password = "";
        message = "Validation error";
    }

    @Then("the system should display a validation error")
    public void the_system_should_display_a_validation_error() {
        assertEquals("Validation error", message);
        System.out.println("Validation error displayed");
    }

    @Then("the system should show a {string} message")
    public void the_system_should_show_a_message(String expectedMessage) {
        assertEquals(expectedMessage, message);
        System.out.printf("Displayed message: %s%n", message);
    }
}