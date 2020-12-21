package jdev.servercore.services;

import org.apache.log4j.Appender;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ServiceTakeMsgTest {
    @Mock
    Appender mockAppender;

    @Test
    public void takeQueueMsgIntegration() {
        Logger logger = Logger.getLogger(ServiceTakeMsg.class);
        logger.addAppender(mockAppender);
//        ServiceSaveMsg
        ServiceTakeMsg serviceTakeMsg = new ServiceTakeMsg(new RestTemplate());
    }
}