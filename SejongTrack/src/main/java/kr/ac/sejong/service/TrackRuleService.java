package kr.ac.sejong.service;

import kr.ac.sejong.domain_jpa.Rule;
import kr.ac.sejong.dto.UnivTrackRuleDegreeJoinDto;

import java.util.List;

public interface TrackRuleService {

    public void save(Rule rule)throws Exception;

    public void delete(Long ruleId)throws Exception;

    public List<UnivTrackRuleDegreeJoinDto> findRules() throws Exception;

    public List<UnivTrackRuleDegreeJoinDto> findByUnivId(Long univId) throws Exception;
}
