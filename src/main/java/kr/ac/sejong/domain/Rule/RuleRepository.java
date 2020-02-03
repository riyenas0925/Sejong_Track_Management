package kr.ac.sejong.domain.Rule;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RuleRepository extends JpaRepository<Rule, Long>, RuleCustomRepository {

}
