package jdev.servercore.controllers;

import jdev.servercore.services.ServiceTakeRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/routesauto")
public class ControllerTakeRoute {
    @Autowired
    ServiceTakeRoute serviceTakeRoute;

    @RequestMapping(method = RequestMethod.POST, value = "/{autoId}/{segmentLength}")
    public List<String> addListRoute(@PathVariable("autoId") String autoId, @PathVariable("segmentLength") String segmentLength) throws IOException {
        return serviceTakeRoute.takeRoute(autoId, segmentLength);
    }
}
