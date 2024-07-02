@Automated
Feature: Automated CRUD

  Scenario Outline: Test credentials
    Given I as a user open the page "https://wave-trial.getbynder.com/login/" in browser "<browser>"
    When I login into it with username "<username>" and password "<password>"
    Then my login is "<status>"
    And text "<loginText>" is appeared
    Examples:
      | username          | password      | status | loginText                                           |
      | merle@themerle.nl | WrongPassword | failed | You have entered an incorrect username or password. |
      | wrongUser         | P@ssw0rd123   | failed | You have entered an incorrect username or password. |
      | merle@themerle.nl | P@ssw0rd123   | passed | Assets                                              |


