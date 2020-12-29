package jdev.servercore.services;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;

public class ServiceTakeRouteTest {

    @Test
    public void takeRoute() {
        ServiceTakeRoute serviceTakeRoute = new ServiceTakeRoute(new RestTemplate());
        String actual = serviceTakeRoute.takeRoute("a123bc99RU", "2").get(0);

    }
}