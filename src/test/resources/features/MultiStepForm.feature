Feature: MultiSteps Form-> Automating the form and adding ScreenShot and ScreenRecording

  Scenario: User Fills and Complete the multi step form
    Given user opens the multiStepForm
    When user fills in the field
      | firstName   | 'First name' |
      | lastName    | 'Last name'  |
      | email       | 'E-mail'     |
      | phoneNumber | 'Phone'      |
      | birthDate   | 'dd'         |
      | birthMonth  | 'mm'         |
      | birthYear   | 'yyyy'       |
      | username    | 'Username'   |
      | password    | 'Password'   |

