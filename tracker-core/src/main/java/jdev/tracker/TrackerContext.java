package jdev.tracker;

import jdev.tracker.services.ServiceGPS;
import jdev.tracker.services.ServiceSaveMsg;
import jdev.tracker.services.ServiceSendMsg;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
@PropertySource("classpath:/application.properties")
public class TrackerContext {
    @Bean
    public ServiceGPS serviceGPS() {return new ServiceGPS();}
}
