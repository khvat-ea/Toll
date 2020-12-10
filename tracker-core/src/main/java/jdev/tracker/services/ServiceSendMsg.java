package jdev.tracker.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import jdev.dto.PointDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.slf4j.spi.MDCAdapter;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceSendMsg {
    Logger logger = LoggerFactory.getLogger("jsonLogger");

    @Scheduled(cron = "${printToLog.cron}")
    // Отправить сообщение в лог
    void printToLog() throws InterruptedException{
        logger.info(ServiceSaveMsg.takeMsg());
    }

/*    @Scheduled(cron = "${sendToServer.cron}")
    public List<String> sendToServer(){
        List<String> l = new ArrayList<>();

        l = ServiceSaveMsg.getBlockingQueue().stream()
                .collect(Collectors.toList());

        l.stream().forEach(x -> System.out.println(x));
        System.out.println("\n");
        ServiceSaveMsg.getBlockingQueue().removeAll(l);
        return l;
    }*/
}
