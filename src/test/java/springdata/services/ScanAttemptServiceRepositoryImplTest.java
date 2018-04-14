package springdata.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import springdata.config.JpaConfig;
import springdata.dao.ScanAttempt;


import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = JpaConfig.class)
public class ScanAttemptServiceRepositoryImplTest {

    @Autowired
    ScanAttemptService scanAttemptService;

    @Test
    public void createAndFind(){
        ScanAttempt scanAttempt1 = createNewScanAttempt("Facebook", true);
        scanAttemptService.saveOrUpdate(scanAttempt1);

        ScanAttempt scanAttempt2 = createNewScanAttempt("Twitter", false);
        scanAttemptService.saveOrUpdate(scanAttempt2);

        ScanAttempt scanAttempt3 = scanAttemptService.find(scanAttempt1.getId());
        assertTrue(scanAttempt1.getNetwork().compareTo(scanAttempt3.getNetwork()) == 0);
    }

    private ScanAttempt createNewScanAttempt(String network, boolean success){
       ScanAttempt scanAttempt = new ScanAttempt();
       scanAttempt.setNetwork(network);
       scanAttempt.setSuccess(success);

       return scanAttempt;
    }
}