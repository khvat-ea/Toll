package jdev.tracker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

@Service
public class ServiceSendMsg {
    @Autowired
    RestTemplate restTemplate;

    public List<String> getQueueMsg(){
        BlockingQueue bq = ServiceSaveMsg.getBlockingQueue();
        List<String> list = new ArrayList<>(bq);
        return list;
    }

//    @Scheduled(cron = "${sendToServer.cron}")
    public void sendQueueMsg() throws IOException {
        final String url = "http://localhost:8081/point/";
        RestTemplate restTemplate_1 = new RestTemplate();
        BlockingQueue bq = ServiceSaveMsg.getBlockingQueue();
        List<String> listOfPoints = new ArrayList<>(bq);

        restTemplate.postForObject(
                url,
                listOfPoints,
                ResponseEntity.class);
//        System.out.println(re.getStatusCode().getReasonPhrase());
    }
}
