package kr.ac.sejong;

import kr.ac.sejong.domain.degree.Degree;
import kr.ac.sejong.domain.rule.Rule;
import kr.ac.sejong.domain.track.Track;
import kr.ac.sejong.domain.rule.RuleRepository;
import kr.ac.sejong.domain.track.TrackRepository;
import kr.ac.sejong.domain.degree.DegreeRepository;
import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
@Commit
public class RuleTest {

    @Inject private RuleRepository ruleRepository;
    @Inject private TrackRepository trackRepository;
    @Inject private DegreeRepository degreeRepository;

    @Test
    public void createRule(){
        Long degreeId = 1L;
        Long trackId = 10L;
        Long basicCredit = 9999L;
        Long appliedCredit = 9999L;
        Long industryCredit = 9999L;
        Long expertCredit = 9999L;
        Long commoncredit = 9999L;

        Track track = trackRepository.getOne(trackId);
        Degree degree = degreeRepository.getOne(degreeId);

        Rule rule = Rule.createRule(track, degree, 
                                    basicCredit, appliedCredit,
                                    industryCredit, expertCredit,commoncredit);

        ruleRepository.save(rule);
    }
    
    @Test
    public void updateRule(){
        
    }

    @Test
    public void deleteRule(){
        ruleRepository.deleteById(2L);
    }

    @Test
    public void findRules(){
        log.info(ruleRepository.findRules().toString());        
    }

    @Test
    public void findByUnivId(){
        //대학 이름으로 규칙 조회하는 메소드
        log.info(ruleRepository.findByUnivId(2L).toString());
    }

    @Test
    public void findByRuleId(){
        //ruleId(Primary Key)로 조회하는 메소드
        log.info("test : " + ruleRepository.findByRuleId(4L, 1L).toString());
    }
}
