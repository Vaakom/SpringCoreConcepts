package springdata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import springdata.dao.ScanAttempt;

public interface ScanAttemptServiceRepository extends JpaRepository<ScanAttempt, Long> {

}
