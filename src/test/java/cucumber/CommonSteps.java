package cucumber;

import com.springyapi.models.User;

public class CommonSteps {
    //  Any common cucumber steps are to go here.

    private final int testId = 1;
    private final String testFirstName = "John";
    private final String testLastname = "Johnson";
    private final String testEmail = "johnjohnson@john.john";
    private final String TestIp = "1.1.1.1";
    private final double testLat = 0.0;
    private final double testLong = 0.0;

    public User createNewValidTestUser() {
        return new User(
                testId,
                testFirstName,
                testLastname,
                testEmail,
                TestIp,
                testLat,
                testLong
        );
    }
}
