Feature: User Login


  @login
  Scenario: Successful login with valid credentials
    Given the user navigates to the login page
    When the user enters username "alice" and password "12345"
    Then validate password is correct or not

  @login
  Scenario Outline: Successful login with valid credentials
    Given the user navigates to the login page
    When the user enters username "<username>" and password "<password>"
    Then validate password is correct or not

    Examples:
      | username | password |
      | alice    | 12345    |
      | bob      | pass1    |
      | carol    | qwerty   |
      | dave     | secret   |
      | eve      | letmein  |


@login
Scenario Outline: Login fails with invalid credentials
  Given the user navigates to the login page
  When the user enters username "<username>" and password "<password>"
  Then validate password is correct or not

  Examples:
    | username     | password   |
    | invalidUser  | wrongPass  |
    | alice        | wrong123   |
    | unknown      | letmein    |
    | bob          | 12345      |

  @login
  Scenario Outline: Login fails with empty username or password
    Given the user navigates to the login page
    When the user enters username "<username>" and password "<password>"
    Then validate password is correct or not

    Examples:
      | username | password |
      |          | 12345   |
      | alice    |         |
      |          |         |

  @login
  Scenario Outline: Login fails with case sensitivity issues
    Given the user navigates to the login page
    When the user enters username "<username>" and password "<password>"
    Then validate password is correct or not

    Examples:
      | username | password |
      | Alice    | 12345   |
      | BOB      | pass1   |
      | carol    | QWERTY  |

  @login
  Scenario Outline: Login with special characters in username or password
    Given the user navigates to the login page
    When the user enters username "<username>" and password "<password>"
    Then validate password is correct or not

    Examples:
      | username    | password    |
      | user!@#     | pass$%^     |
      | alice       | 12345!@#    |
      | !invalid    | !invalid    |

  @login
  Scenario Outline: Login with leading/trailing whitespace
    Given the user navigates to the login page
    When the user enters username "<username>" and password "<password>"
    Then validate password is correct or not

    Examples:
      | username  | password  |
      |  alice    | 12345     |
      | bob       |  pass1    |
      | carol     | qwerty    |
      | dave      | secret    |
      | eve       | letmein   |