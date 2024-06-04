Feature: MultiSteps Form-> Automating the form and adding ScreenShot and ScreenRecording

  Scenario: User Fills and Complete the multi step form
    Given user opens the multiStepForm
    When user fills in the first name
    And user fills in the last name
    And user clicks on the "nextBtn" button
    Then user fills in the email field
    And user fills in the phone number field
    And user clicks on the "nextBtn" button
    Then user fills in the birthday date field
    And user fills in the birthday month field
    And user fills in the birthday year field
    And user clicks on the "nextBtn" button
    Then user fills in the username field
    And user fills in the password field
    And user clicks on the "nextBtn" button
