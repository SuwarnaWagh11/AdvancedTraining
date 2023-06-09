Feature: VerifyDashboardWidgetVisible

  @Test11
  Scenario Outline: Verify that Dashboard page contains all given widgets
    Given user launch the chrome browser
    When User opens the URL "http://localhost:8080/"
    And Log in to the report portal with user "superadmin" and password "erebus"
    Then Page title should be "Report Portal"
    And User clicks on DemoDashboard and get the total widget present in the dashboard page
    And Verify that DemoDashboard page contains "<widget>"
    And User closes the browser

    Examples:
      | widget                              |
      | LAUNCH STATISTICS BAR               |

  @Test12
  Scenario Outline: Verify that Widget contains all given items
    Given user launch the chrome browser
    When User opens the URL "http://localhost:8080/"
    And Log in to the report portal with user "superadmin" and password "erebus"
    Then Page title should be "Report Portal"
    And User clicks on DemoDashboard and get the total widget present in the dashboard page
    And Verify that DemoDashboard page contains "<widget>"
    And User closes the browser

    Examples:
      | widget                              |
      | LAUNCH STATISTICS AREA              |