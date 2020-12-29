package jdev.servercore.services;

import jdev.servercore.db.PointDevice;
import jdev.servercore.db.repo.PointDeviceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@EnableJpaRepositories("jdev.servercore.db")
@EntityScan(basePackageClasses = jdev.servercore.db.PointDevice.class)
@Service
public class ServiceTakeRoute {
    private static final Logger LOG_COORDS = LoggerFactory.getLogger("takeCoords.ServerCore");
    private static final Logger LOG_ERRORS = LoggerFactory.getLogger("allError.ServerCore");
    private static final Logger LOG_TRACE = LoggerFactory.getLogger("allTrace.ServerCore");

    private final RestTemplate restTemplate;

    public ServiceTakeRoute(@Autowired RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Autowired
    PointDeviceRepository pointDeviceRepository;


    public List<String> takeRoute(String autoId, String segmentLength){
        final String url = "http://localhost:8081/routesauto/{autoId}/{segmentLength}";  // Адрес сервера хранения точек трекера (tracker-core)
        List<String> listOfPoints = new ArrayList<>();

        Map<String, String> map = new HashMap<>();
        map.put("autoId", autoId);
        map.put("segmentLength", segmentLength);

        try {
            listOfPoints = restTemplate.postForObject(
                    url,
                    listOfPoints,
                    List.class,
                    map);

            LOG_TRACE.trace(String.valueOf("Получен маршрут от '" + autoId + '\''));
            listOfPoints.stream()
                    .forEach(coord -> LOG_TRACE.trace(coord));

        }
        catch (HttpClientErrorException e)
        {
            LOG_ERRORS.error(e.getResponseBodyAsString());
        }
        catch(Exception e)
        {
            LOG_ERRORS.error(e.getMessage());
        }

        return listOfPoints;
    }
}
