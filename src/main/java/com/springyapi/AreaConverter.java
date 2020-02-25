package com.springyapi;

import com.springyapi.models.User;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.json.JsonParseException;

public class AreaConverter {

    private static final Logger log = LoggerFactory.getLogger(AreaConverter.class);
    private JSONArray filteredUsers = new JSONArray();

    public JSONArray cityRadiusCalculator(String users) {

        try {
            JSONArray fullUserJSON = new JSONArray(users);

            for (Object user : fullUserJSON) {
                if (user instanceof JSONObject) {
                    User userObj = new User(
                            ((JSONObject) user).getInt("id"),
                            ((JSONObject) user).getString("first_name"),
                            ((JSONObject) user).getString("last_name"),
                            ((JSONObject) user).getString("email"),
                            ((JSONObject) user).getString("ip_address"),
                            ((JSONObject) user).getDouble("latitude"),
                            ((JSONObject) user).getDouble("longitude"));

                    calculateDistance(userObj);
                }
            }
            return filteredUsers;
        } catch (JSONException e) {
            return null;
        }
    }



    private void calculateDistance(User user) {
        double distance = HaversineFormula.haversine(user.getLatitude(), user.getLongitude());

        if (distance <= 50) {
            filteredUsers.put(user);
        }
    }

}
