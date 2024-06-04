package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {
    @Given("^user opens the multiStepForm$")
    public static void userOpensMultiStepForm(){
        implementation.Implementation.validateUserOpensTheForm();
    }

    @When("user fills in the first name")
    public void userFillsInTheFirstName() {
        implementation.Implementation.userFillsFirstName();
    }

    @And("user fills in the last name")
    public void userFillsInTheLastName() {
        implementation.Implementation.userFillsLastname();
    }

    @And("user clicks on the {string} button")
    public void userClicksOnTheButton(String nextButton) {
        implementation.Implementation.userClicksOnNextButton(nextButton);
    }

    @Then("user fills in the email field")
    public void userFillsInTheEmailField() {
        implementation.Implementation.userFillsEmail();
    }

    @And("user fills in the phone number field")
    public void userFillsInThePhoneNumberField() {
        implementation.Implementation.userFillsPhoneNumber();
    }

    @Then("user fills in the birthday date field")
    public void userFillsInTheBirthdayDateField() {
        implementation.Implementation.userFillsBirthdayDate();
    }

    @And("user fills in the birthday month field")
    public void userFillsInTheBirthdayMonthField() {
        implementation.Implementation.userFillsBirthdayMonth();
    }

    @And("user fills in the birthday year field")
    public void userFillsInTheBirthdayYearField() {
        implementation.Implementation.userFillsBirthdayYear();
    }

    @Then("user fills in the username field")
    public void userFillsInTheUsernameField() {
        implementation.Implementation.userFillsUsernameField();
    }

    @And("user fills in the password field")
    public void userFillsInThePasswordField() {
        implementation.Implementation.userFillsPassword();
    }
}
