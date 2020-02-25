package com.springyapi;

import org.json.JSONArray;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringyAPIController {
    private final SpringyAPIService service;

    public SpringyAPIController(SpringyAPIService service) {
        this.service = service;
    }

    @GetMapping("/")
    public @ResponseBody
    String defaultRouteMessage() {
        return service.defaultRouteMessage();
    }

    @GetMapping("/error")
    public
    String defaultErrorRoute() {return service.defaultErrorMessage(); }

    @GetMapping("/users")
    public String getAllUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/users/london")
    public String getAllUsersInLondon() {
        return service.getAllUsersInLondon();
    }

    @GetMapping("/users/london-radius")
    public JSONArray getAllUsersNearLondon() throws ParseException {
        return service.getAllUsersNearLondon();
    }
}
