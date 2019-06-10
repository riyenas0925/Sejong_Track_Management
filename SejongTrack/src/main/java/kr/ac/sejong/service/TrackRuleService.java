package kr.ac.sejong.service;

import kr.ac.sejong.domain_jpa.Rule;
import kr.ac.sejong.dto.UnivTrackRuleDegreeJoinDto;

import java.util.List;

public interface TrackRuleService {

    /*
    public Optional<Rule> read(Long ruleNo)throws Exception;

    public ruleVO readRule(Integer degree, Integer trackNo)throws Exception;
    */

    public void regist(Rule rule)throws Exception;

    public void update(Rule rule)throws Exception;

    public void delete(Long ruleId)throws Exception;

    public List<UnivTrackRuleDegreeJoinDto> findRules() throws Exception;

    public List<UnivTrackRuleDegreeJoinDto> findByUnivId(Long univId) throws Exception;
}
