Feature: JDI GitHub site elements test

  Scenario: User login test

    Given I open JDI GitHub site

    When I click on image User button
    And I input the 'Roman' into field Login
    And I input the 'Jdi1234' into field Password
    And I click 'Enter' button on the top right corner of the Home Page

    Then Full 'ROMAN IOVLEV' should be displayed on the top right corner of the Home Page

  Scenario: Different Element Page Test

    Given I open JDI GitHub site
    And   I login as user "Roman Iovlev"

    When I click on "Service" button in Header
    And I click on Different Elements" button in Service dropdown

    And I click checkbox "Water"
    And I click checkbox "Wind"
    And I click radio "Selen"
    And I click dropdown button
    And I select "Yellow"

    Then  checkbox "Water" should be selected
    And   checkbox "Wind" should be selected
    And   radio "Selen" should be selected
    And   dropdown "Yellow" should be selected
    And   log rows should displayed their names, status and values are corresponding to selected




