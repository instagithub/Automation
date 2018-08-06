Feature: AccountSwitching

  # author : Kavish
  @CS-smoke @TC-116927
  Scenario: Validate the And/Or combination when launch New Phone Call
    Given cs log in to the CSR portal
    When csr selects the new phone call
    Then new phone call window is displayed with the search parameter
    When searched with valid last name
    Then corrosponding correct result should be displayed
    When searched with valid last name and valid account number
    Then corrosponding correct result should be displayed
    When searched with the valid account number
    Then corrosponding correct result should be displayed
    When searched with invalid last name and invalid account number
    Then No result should be displayed
    Then csr selected the logOut option from dropdown
