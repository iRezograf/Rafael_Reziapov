Feature: EPAM Test site elements using feature

  Scenario: EPAM test URL. User login test.
    Given EPAM test site URL is opened
    When I click on image User button
    And I input the 'Roman' into field Login
    And I input the 'Jdi1234' into field Password
    And I click 'Enter' button on the top right corner of the Home Page

    Then Full 'ROMAN IOVLEV' should be displayed on the top right corner of the Home Page





