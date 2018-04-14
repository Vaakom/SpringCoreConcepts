package core.main;

import core.services.SNObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SocialNetworkChecker {

    @Autowired
    List<SNObserver> observerList;

    @Scheduled(fixedDelay = 1000)
    public void checkNetworks(){
        observerList.stream().forEach((snObserver)->{snObserver.checkNetwork();});
    }
}
