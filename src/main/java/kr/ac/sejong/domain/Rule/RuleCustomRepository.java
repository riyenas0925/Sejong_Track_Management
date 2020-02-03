package kr.ac.sejong.domain.Rule;


import kr.ac.sejong.web.dto.UnivTrackRuleDegreeJoinDto;

import java.util.List;

public interface RuleCustomRepository {
    public List<UnivTrackRuleDegreeJoinDto> findRules();

    public List<UnivTrackRuleDegreeJoinDto> findByUnivId(Long univId);

    public List<UnivTrackRuleDegreeJoinDto> findByRuleId(Long trackId, Long degreeId);
}
