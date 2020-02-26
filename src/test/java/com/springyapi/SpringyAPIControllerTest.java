package com.springyapi;

import org.easymock.EasyMockRule;
import org.easymock.EasyMockSupport;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.json.simple.parser.ParseException;
import org.junit.Rule;
import org.junit.jupiter.api.Test;

class SpringyAPIControllerTest extends EasyMockSupport {

    @Rule
    public EasyMockRule rule = new EasyMockRule(this);

    @Mock
    private SpringyAPIService service = new SpringyAPIService();

    @TestSubject
    private SpringyAPIController controller = new SpringyAPIController(service);

    @Test
    public void getAllUsers() {
        service.getAllUsers();
        replayAll();
        controller.getAllUsers();
        verifyAll();
    }

    @Test
    public void getAllUsersInLondon() {
        service.getAllUsersInLondon();
        replayAll();
        controller.getAllUsersInLondon();
        verifyAll();
    }

    @Test
    public void getAllUsersNearLondon() throws ParseException {
        service.getAllUsersNearLondon();
        replayAll();
        controller.getAllUsersNearLondon();
        verifyAll();
    }
}