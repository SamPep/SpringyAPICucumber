package cucumber.haversineSteps;

import com.springyapi.HaversineFormula;
import com.springyapi.SpringyApiApplication;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import static org.junit.Assert.assertEquals;

public class HaversineCucumberSteps {

    private static final Logger log = LoggerFactory.getLogger(SpringyApiApplication.class);
    private DecimalFormat decimalFormat;

    private double latitude;
    private double longitude;
    private double actualResult;
    private double delta;

    @Before
    public void setUp() {
        decimalFormat = new DecimalFormat("#.####");
        decimalFormat.setRoundingMode(RoundingMode.CEILING);

        delta = 0.0002;
    }

    @Given("A point exists on the map with a valid latitude of {double} and longitude of {double}.")
    public void aPointExistsOnTheMapWithAValidLatitudeAndLongitude(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Given("An invalid latitude of <latitude> and an invalid longitude of <longitude> are supplied.")
    public void anInvalidLatitudeOfLatitudeAndAnInvalidLongitudeOfLongitudeAreSupplied() {
    }

    @When("The Haversine function is called.")
    public void the_Haversine_function_is_called() {
        double result = HaversineFormula.haversine(latitude, longitude);
        actualResult = Double.parseDouble(decimalFormat.format(result));
        log.info("Actual result from haversine formula: {}", actualResult);
    }

    @Then("The correct expected result of {double} is returned as a distance from London.")
    public void theExpectedResultIsReturnedAsADistanceFromLondon(double expectedResult) {
        assertEquals(expectedResult, actualResult, delta);
    }


}
