package springdata.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springdata.dao.ScanAttempt;
import springdata.repositories.ScanAttemptServiceRepository;

@Service
public class ScanAttemptServiceRepositoryImpl implements ScanAttemptService {

    @Autowired
    private ScanAttemptServiceRepository repository;

    public ScanAttempt find(Long id){
        return repository.findById(id).get();
    }

    public ScanAttempt saveOrUpdate(ScanAttempt scanAttempt) {
        return repository.save(scanAttempt);
    }

}
