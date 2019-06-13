package kr.ac.sejong.persistence_jpa;

import kr.ac.sejong.domain_jpa.Rule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RuleRepository extends JpaRepository<Rule, Long>, RuleCustomRepository {

}
