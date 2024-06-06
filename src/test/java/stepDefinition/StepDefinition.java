package stepDefinition;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class StepDefinition {
    @Given("^user opens the multiStepForm$")
    public static void userOpensMultiStepForm() {
        implementation.Implementation.validateUserOpensTheForm();
    }

    @When("user fills in the field")
    public void userFillsInTheField(DataTable dataTable) throws IOException {
        Map<String, String> dataElements;
        dataElements = dataTable.asMap();
        implementation.Implementation.userFillsInTheField(dataElements);
    }
}
