package springdata.services;

import springdata.dao.ScanAttempt;

public interface ScanAttemptService {
    ScanAttempt find(Long id);

    ScanAttempt saveOrUpdate(ScanAttempt scanAttempt);

}
