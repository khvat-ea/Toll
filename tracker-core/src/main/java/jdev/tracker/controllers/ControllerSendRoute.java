package jdev.tracker.controllers;

import jdev.tracker.services.ServiceSendMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/routesauto")
public class ControllerSendRoute {
    @Autowired
    private ServiceSendMsg serviceSendMsg;

    @RequestMapping(method = RequestMethod.POST, value = "/{autoId}/{segmentLength}")
    @ResponseBody
    public List<String> addRoute(@PathVariable("autoId") String autoId, @PathVariable("segmentLength") String segmentLength) {
        return serviceSendMsg.sendRoute(autoId, segmentLength);
    }
}
