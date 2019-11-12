package kr.ac.sejong;

import kr.ac.sejong.domain.Degree;
import kr.ac.sejong.domain.Rule;
import kr.ac.sejong.persistence.RuleRepository;
import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
@Commit
public class RuleTest {

    @Inject
    private RuleRepository ruleRepository;

    @Test
    public void createRule(){
        Rule rule = new Rule();
        rule.setBasicCredit(1L);
        rule.setAppliedCredit(2L);
        rule.setIndustryCredit(3L);

        /*
        Track track = new Track();
        track.setTrackId(1L);
        track.setTrackTitle("test Track");
        track.setTrackNo(9999L);

*/
        Degree degree = new Degree();
        degree.setDegreeId(1L);
        degree.setDegreeTitle("test Degree");

        rule.setDegree(degree);
        //rule.setTrack(track);

        ruleRepository.save(rule);
    }

    @Test
    public void updateRule(){
        Rule rule = new Rule();
        rule.setRuleId(1L);
        rule.setBasicCredit(9L);
        rule.setAppliedCredit(9L);
        rule.setIndustryCredit(9L);

        /*
        Track track = new Track();
        track.setTrackId(1L);
        track.setTrackTitle("test Track");
        track.setTrackNo(9999L);

*/
        Degree degree = new Degree();
        degree.setDegreeId(1L);
        degree.setDegreeTitle("test Degree");

        rule.setDegree(degree);
        //rule.setTrack(track);

        ruleRepository.save(rule);
    }

    @Test
    @Transactional
    public void findOne(){

        Rule rule = ruleRepository.findById(1L).get();

        log.info(rule.toString() + rule.getTrack().toString() + rule.getDegree().toString());
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
        log.info(ruleRepository.findByUnivId(2L).toString());
    }

    @Test
    public void findByRuleId(){
        log.info(ruleRepository.findByRuleId(2L).toString());
    }
}
