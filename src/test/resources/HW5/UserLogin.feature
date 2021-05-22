Feature: EPAM Test site elements using feature

  Scenario: EPAM test URL. User login test.
    Given EPAM test site URL is opened
    When I click on image User button
    And I input the 'name' into field Login
    And I input the 'password' into field Password
    And I click 'Enter' button on the top right corner of the Home Page

    Then Full 'username' should be displayed on the top right corner of the Home Page





