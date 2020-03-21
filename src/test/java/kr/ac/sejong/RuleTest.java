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
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;

@RunWith(SpringRunner.class)
@ActiveProfiles(value = {"develop-h2"})
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
        Long commonCredit = 9999L;

        Track track = trackRepository.getOne(trackId);
        Degree degree = degreeRepository.getOne(degreeId);

        Rule rule = Rule.createRule(track, degree, 
                                    basicCredit, appliedCredit,
                                    industryCredit, expertCredit,commonCredit);

        ruleRepository.save(rule);
    }
    
    @Test
    public void updateRule(){
        
    }

    @Test
    public void deleteRule(){
        ruleRepository.deleteById(2L);
    }
}
