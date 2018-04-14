package core.services;

import core.dao.SocialNetworkPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TwitterSNObserverImpl implements SNObserver {
    @Autowired
    private SocialNetworkPost post;

    @Override
    public void checkNetwork() {
        System.out.println("Twitter: " + post.getUserName() + " " + post.getText());

    }
}
