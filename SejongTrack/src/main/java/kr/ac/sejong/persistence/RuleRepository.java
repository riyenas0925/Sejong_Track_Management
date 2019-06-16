package kr.ac.sejong.persistence;

import kr.ac.sejong.domain.Rule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RuleRepository extends JpaRepository<Rule, Long>, RuleCustomRepository {

}
