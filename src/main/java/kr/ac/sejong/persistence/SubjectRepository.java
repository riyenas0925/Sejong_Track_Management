package kr.ac.sejong.persistence;

import kr.ac.sejong.domain.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

}
