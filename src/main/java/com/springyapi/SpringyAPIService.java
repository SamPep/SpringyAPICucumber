package com.springyapi;

import org.json.JSONArray;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SpringyAPIService {

    private static final Logger log = LoggerFactory.getLogger(SpringyAPIService.class);

    private final RestTemplate restTemplate;
    private final AreaConverter areaConverter;

    public SpringyAPIService() {
        this.restTemplate = new RestTemplate();
        this.areaConverter = new AreaConverter();
    }

    private final String BASE_URL = "https://bpdts-test-app.herokuapp.com";
    private final String LONDON_URL = "/city/London/users";
    private final String USER_URL = "/users";

    public String defaultRouteMessage() {
        return "Welcome to the SpringyAPI!";
    }

    public String defaultErrorMessage() {
        return "Looks like there was an error... Sorry about that.";
    }

    public String getAllUsers() {
        log.info("Retrieving all users.");
        String result = restTemplate.getForObject(BASE_URL + USER_URL, String.class);

        return result;
    }

    public String getAllUsersInLondon() {
        log.info("Retrieving users with a city tag of London.");
        String result = restTemplate.getForObject(BASE_URL + LONDON_URL, String.class);

        return result;
    }

    public JSONArray getAllUsersNearLondon() throws ParseException {
        log.info("Retrieving located within 50 miles of London.");
        String result = restTemplate.getForObject(BASE_URL + USER_URL, String.class);
        JSONArray filteredResult = areaConverter.cityRadiusCalculator(result);

        return filteredResult;
    }
}
