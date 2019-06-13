package kr.ac.sejong.persistence_jpa;


import kr.ac.sejong.dto.UnivTrackRuleDegreeJoinDto;

import java.util.List;

public interface RuleCustomRepository {
    public List<UnivTrackRuleDegreeJoinDto> findRules();

    public List<UnivTrackRuleDegreeJoinDto> findByUnivId(Long univId);

    public List<UnivTrackRuleDegreeJoinDto> findByRuleId(Long ruleId);
}
