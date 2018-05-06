package core.services;

import core.dao.SocialNetworkPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacebookSNObserverImpl  implements SNObserver {

    @Autowired
    private SocialNetworkPost post;

    public void checkNetwork() {
        System.out.println("Facebook. User:" + post.getUserName() + " Post:" + post.getText());
    }
}
