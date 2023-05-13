Feature: VerifyDashboardPageAccess
  @RegTest
  Scenario: Login to ReportPortal with superadmin and verify that use is able to access dashboard page
    Given user launch the chrome browser
    When User opens the URL "http://localhost:8080/"
    And Log in to the report portal with user "superadmin" and password "erebus"
    Then Page title should be "Report Portal"
    And User closes the browser

  @SanityTest
  Scenario: Login to ReportPortal with superadmin and verify that use is able to access dashboard page
    Given user launch the chrome browser
    When User opens the URL "http://localhost:8080/"
    And Log in to the report portal with user "default" and password "1q2w3e"
    Then Page title should be "Report Portal"
    And User closes the browser

  @SmokeTest
  Scenario Outline: Login to ReportPortal with superadmin and verify that use is able to access dashboard page
    Given user launch the chrome browser
    When User opens the URL "http://localhost:8080/"
    And Log in to the report portal with user "<username>" and password "<password>"
    Then Page title should be "Report Portal"
    And User closes the browser

    Examples:
      | username   | password |
      | superadmin | erebus   |
      | default    | 1q2w3e   |
