package kr.ac.sejong.persistence_jpa;

import kr.ac.sejong.domain_jpa.Degree;
import org.springframework.data.repository.CrudRepository;

public interface DegreeRepository extends CrudRepository<Degree, Long> {

}
