Feature: VerifyDashboardPageAccess

  Scenario: Login to ReportPortal with superadmin and verify that use is able to access dashboard page

    Given user launch the chrome browser
    When User opens the URL "http://localhost:8080/"
    And Log in to the report portal with user "superadmin" and password "erebus"
    Then Page title should be "Report Portal"
    And User closes the browser