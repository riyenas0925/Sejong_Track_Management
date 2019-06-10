package kr.ac.sejong.service;

import kr.ac.sejong.domain_jpa.Rule;
import kr.ac.sejong.dto.UnivTrackRuleDegreeJoinDto;
import kr.ac.sejong.persistence_jpa.RuleRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class TrackRuleServiceImpl implements TrackRuleService {

    @Inject
    private RuleRepository ruleRepository;

    /*
    @Override
    public Optional<Rule> read(Long ruleId) throws Exception{
        return ruleRepository.findById(ruleId);
    }

    @Override
    public ruleVO readRule(Integer degree, Integer trackNo)throws Exception{
        return ruleRepository.findByRuleId(ruleId);
    }
    */

    @Override
    public void regist(Rule rule) throws Exception{

    }

    @Override
    public void update(Rule rule) throws Exception{

    }

    @Override
    public void delete(Long ruleId) throws Exception{
        ruleRepository.deleteById(ruleId);
    }

    @Override
    public List<UnivTrackRuleDegreeJoinDto> findRules() throws Exception{
        return ruleRepository.findRules();
    }

    @Override
    public List<UnivTrackRuleDegreeJoinDto> findByUnivId(Long univId) throws Exception{
        return ruleRepository.findByUnivId(univId);
    }
}
