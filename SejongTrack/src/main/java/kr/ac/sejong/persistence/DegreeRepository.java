package kr.ac.sejong.persistence;

import kr.ac.sejong.domain.Degree;
import org.springframework.data.repository.CrudRepository;

public interface DegreeRepository extends CrudRepository<Degree, Long> {

}
