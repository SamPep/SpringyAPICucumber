package com.springyapi;

import com.springyapi.models.User;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AreaConverter {

    private static final Logger log = LoggerFactory.getLogger(AreaConverter.class);
    private JSONArray filteredUsers = new JSONArray();

    public JSONArray cityRadiusCalculator(String users)  {

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

                if (calculateDistance(userObj)) {
                    filteredUsers.put(user);
                }
            } else {
                log.error("Invalid JSON format.");
            }
        }
        return filteredUsers;
    }

    private boolean calculateDistance(User user) {
        double distance = HaversineFormula.haversine(user.getLatitude(), user.getLongitude());
        return distance <= 50;
    }
}
