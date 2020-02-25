package cucumber.areaCalculatorSteps;

import com.springyapi.AreaConverter;
import cucumber.CommonSteps;
import io.cucumber.java.Before;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.JSONArray;
import org.json.simple.parser.ParseException;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class AreaCalculatorCucumberSteps {

    private final String VALID_LONDON_USERS = "src/test/resources/data/ValidUsersLondonLocation.json";
    private final String VALID_OUTSIDE_USERS = "src/test/resources/data/ValidUsersOutsideLocation.json";
    private final String INVALID_USERS = "src/test/resources/data/InvalidUsers.json";

    private CommonSteps commonSteps;
    private AreaConverter areaConverter;
    private String content;
    private JSONArray actualResults;

    @Before
    public void setUp() {
        this.commonSteps = new CommonSteps();
        this.areaConverter = new AreaConverter();
        this.actualResults = new JSONArray();
    }

    @Given("A valid set of users exist {string} London.")
    public void validUsersExist(String identifier) throws IOException {

        String path = (identifier.equals("within"))?VALID_LONDON_USERS:VALID_OUTSIDE_USERS;
        content = commonSteps.readFile(path);
    }

    @Given("An invalid set of users exist.")
    public void invalidUsersExist() throws IOException {
        content = commonSteps.readFile(INVALID_USERS);
    }

    @When("The area calculation function is called.")
    public void theAreaCalculationFunctionIsCalled() {
        actualResults = areaConverter.cityRadiusCalculator(content);
    }

    @Then("The area calculation function identifies the {int} users.")
    public void theAreaCalculationFunctionResponsesCorrectly(int expected) {
        assertEquals(expected, actualResults.length());
    }

    @Then("The area calculation function returns null.")
    public void theAreaCalculationFunctionReturnsNull() {
        assertEquals(actualResults, null);
    }

}
