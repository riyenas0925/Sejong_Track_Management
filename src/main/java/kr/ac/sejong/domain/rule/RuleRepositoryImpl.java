package kr.ac.sejong.domain.rule;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class RuleRepositoryImpl extends QuerydslRepositorySupport implements RuleCustomRepository {

    public RuleRepositoryImpl() {
        super(Rule.class);
    }

}
