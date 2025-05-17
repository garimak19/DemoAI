
# Copilot Context File – BDD Standards and Reusable Templates

## ✅ Feature File Structure

Use this format for all `.feature` files:

```gherkin
Feature: <Short description of the feature>
  As a <type of user>
  I want <goal>
  So that <reason>

  Scenario: <Clear and specific behavior>
    Given <initial state>
    When <user action>
    Then <expected outcome>
```

### ✅ Tags

Use tags for grouping and filtering tests:

- `@smoke` – for smoke tests
- `@regression` – for regression test suite
- `@auth`, `@profile`, etc. – domain-specific grouping

---

## ✅ Gherkin Style Guide

| Gherkin Word | Purpose              | Example                                      |
|--------------|----------------------|----------------------------------------------|
| Given        | Initial state         | Given the user is on the login page          |
| When         | User action           | When the user enters valid credentials       |
| Then         | Expected outcome      | Then the user should be redirected to home   |
| And / But    | Additional steps      | And the dashboard is displayed               |

---

## ✅ Reusable Java Step Template

```java
@Given("the user is on the {string} page")
public void userOnPage(String pageName) {
    // Navigate to page logic
}

@When("the user logs in with username {string} and password {string}")
public void login(String username, String password) {
    // Login logic
}

@Then("the system should display the dashboard")
public void verifyDashboard() {
    // Assertion logic
}
```

---

## ✅ ScenarioContext Class

Use this pattern to store shared data between steps.

```java
public class ScenarioContext {
    private final Map<String, Object> data = new HashMap<>();

    public void set(String key, Object value) {
        data.put(key, value);
    }

    public <T> T get(String key, Class<T> type) {
        return type.cast(data.get(key));
    }

    public boolean contains(String key) {
        return data.containsKey(key);
    }
}
```

---

## ✅ Step Naming Patterns

| Pattern                              | Recommended Format                                |
|-------------------------------------|----------------------------------------------------|
| Page navigation                     | the user is on the {string} page                  |
| Form submission                     | the user submits the login form                   |
| Data input                          | the user enters {string} in the {string} field    |
| Validation                          | the system should show a {string} message         |

---

## ✅ Examples to Train Copilot

```gherkin
Scenario: Login with locked account
  Given the user is on the login page
  When the user enters credentials for a locked account
  Then the system should notify the user their account is locked

Scenario: Login with empty fields
  Given the user is on the login page
  When the user submits the login form with empty username and password
  Then the system should display a validation error
```

---

> 🧠 **Tip:** Place this file at the root or inside your `test` folder. Copilot will use this as a pattern source while generating `.feature`, `.java`, or `.md` content in IntelliJ.
