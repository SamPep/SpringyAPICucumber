package cucumber.areaCalculatorSteps;

import com.springyapi.AreaConverter;
import com.springyapi.models.User;
import cucumber.CommonSteps;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.JSONArray;

import static org.junit.Assert.assertEquals;


public class AreaCalculatorCucumberSteps {

    private User user;
    private CommonSteps commonSteps;
    private AreaConverter areaConverter;
    private JSONArray expectedUsers;

    @Before
    public void setUp() {
        this.commonSteps = new CommonSteps();
        this.areaConverter = new AreaConverter();
        this.expectedUsers = new JSONArray();
    }

    @Given("A valid set of users exists.")
    public void userExists() {
        user = commonSteps.createNewValidTestUser();
    }

    @And("The user's current location is within fifty miles of London, " +
            "with a latitude of {double} and a longitude of {double}.")
    public void theUserSCurrentLocationIsWithinFiftyMilesOfLondon(double latitude, double longitude) {
        user.setLatitude(latitude);
        user.setLongitude(longitude);
    }

    @When("The area calcuation funtion is called.")
    public void theAreaCalcuationFuntionIsCalled() {
        expectedUsers.put(areaConverter.cityRadiusCalculator(user.toString()));
    }

    @Then("The area calculation function responds positively.")
    public void theAreaCalculationFunctionResponsesCorrectly() {
        assertEquals(expectedUsers.length(), 1);
    }
}
