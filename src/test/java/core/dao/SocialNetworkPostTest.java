package core.dao;

import core.config.CoreConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = CoreConfig.class)
public class SocialNetworkPostTest {

    @Autowired
    private SocialNetworkPost post1;

    @Autowired
    private SocialNetworkPost post2;

    @Test
    public void init() {
        assertFalse(post1.equals(post2));
    }
}