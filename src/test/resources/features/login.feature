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

