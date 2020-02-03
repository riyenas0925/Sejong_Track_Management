package kr.ac.sejong.persistence;

import kr.ac.sejong.domain.Degree;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DegreeRepository extends JpaRepository<Degree, Long> {

}
