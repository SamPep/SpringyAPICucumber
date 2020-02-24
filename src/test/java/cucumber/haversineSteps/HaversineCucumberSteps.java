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
    private DecimalFormat decimalFormat = new DecimalFormat("#.####");

    private double testLatitude;
    private double testLongitude;

    private double expectedResult = 1.2736;
    private double actualResult;

    @Before
    public void setUp() {
        decimalFormat.setRoundingMode(RoundingMode.CEILING);
    }

    @Given("A point exists on the map with a valid longitude and latitude.")
    public void a_point_exists_on_the_map_with_a_valid_longitude_and_latitude() {
        testLatitude = 51.7894;
        testLongitude = 1.9282;
    }

    @When("The Haversine function is called.")
    public void the_Haversine_function_is_called() {
        double result = HaversineFormula.haversine(testLatitude, testLongitude);
        // actualResult = decimalFormat.format(result);
        log.info("Actual result from haversine formula: {}", actualResult);
    }

    @Then("The correct distance from London is returned.")
    public void the_correct_distance_from_London_is_returned() {
        assertEquals(expectedResult, actualResult);
    }

}
