package kr.ac.sejong.domain.degree;

import kr.ac.sejong.domain.rule.Rule;
import kr.ac.sejong.domain.rule.RuleCustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DegreeRepository extends JpaRepository<Degree, Long>, DegreeCustomRepository {


}
