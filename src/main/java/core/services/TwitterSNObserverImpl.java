package core.services;

import core.annotations.LogExecutionTime;
import core.dao.SocialNetworkPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@LogExecutionTime
public class TwitterSNObserverImpl implements SNObserver {
    @Autowired
    private SocialNetworkPost post;

    @Override
    public void checkNetwork() {
        System.out.println("Twitter. User:" + post.getUserName() + " Post:" + post.getText());

    }
}
