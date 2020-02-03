package kr.ac.sejong.service;

import kr.ac.sejong.domain.Rule.Rule;
import kr.ac.sejong.web.dto.UnivTrackRuleDegreeJoinDto;
import kr.ac.sejong.domain.Rule.RuleRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class TrackRuleServiceImpl implements TrackRuleService {
    
    @Inject
    private RuleRepository ruleRepository;
    
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
    
    @Override
    public List<UnivTrackRuleDegreeJoinDto> findByRuleId(Long trackId, Long degreeId) throws Exception{
        return ruleRepository.findByRuleId(trackId, degreeId);
    }
    
    /***************************완성된 메소드*******************************/

    @Override
    public void save(Rule rule) throws Exception{
        ruleRepository.save(rule);
    }
}
