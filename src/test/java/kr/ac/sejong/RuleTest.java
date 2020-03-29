package kr.ac.sejong;

import kr.ac.sejong.domain.degree.Degree;
import kr.ac.sejong.domain.rule.Rule;
import kr.ac.sejong.domain.track.Track;
import kr.ac.sejong.domain.rule.RuleRepository;
import kr.ac.sejong.domain.track.TrackRepository;
import kr.ac.sejong.domain.degree.DegreeRepository;
import kr.ac.sejong.domain.trackcourse.TrackCourse;
import kr.ac.sejong.web.dto.degree.DegreeResponseDto;
import lombok.extern.java.Log;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.BeforeMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@ActiveProfiles(value = {"develop-h2"})
@SpringBootTest
@Log
@Commit
public class RuleTest {

    @Autowired
    private RuleRepository ruleRepository;

    @Autowired
    private TrackRepository trackRepository;

    @Autowired
    private DegreeRepository degreeRepository;

    @Test
    public void createRule(){
        Track track = trackRepository.getOne(1L);
        Degree degree = degreeRepository.getOne(1L);

        List<Rule> rules = Arrays.asList(
                Rule.builder()
                        .track(track)
                        .degree(degree)
                        .courseType(TrackCourse.Type.APPLIED)
                        .credit(9L)
                        .build(),
                Rule.builder()
                        .track(track)
                        .degree(degree)
                        .courseType(TrackCourse.Type.APPLIED)
                        .credit(18L)
                        .build()
                );

        ruleRepository.saveAll(rules);

        log.info(ruleRepository.findAll().toString());
    }

    @Test
    public void readRuleByTrack() {
        Track track = trackRepository.getOne(1L);
        Degree degree = degreeRepository.getOne(1L);

        List<Rule> rules = Arrays.asList(
                Rule.builder()
                        .track(track)
                        .degree(degree)
                        .courseType(TrackCourse.Type.BASIC)
                        .credit(9L)
                        .build(),
                Rule.builder()
                        .track(track)
                        .degree(degree)
                        .courseType(TrackCourse.Type.APPLIED)
                        .credit(18L)
                        .build()
        );

        ruleRepository.saveAll(rules);

        List<Rule> ruleList = ruleRepository.findByTrackIdAndDegreeId(1L,1L);

        Map<TrackCourse.Type, Rule> trackRule = new HashMap<>();

        for(Rule rule : ruleList) {
            trackRule.put(rule.getCourseType(), rule);
        }

        log.info(trackRule.toString());
    }

    @Test
    @Transactional
    public void RuleFindByUnivId (){

        List<Rule> rules = ruleRepository.findByUnivId(2L);

        log.info(rules.toString());

        List<DegreeResponseDto> degrees = rules.stream()
                .map(Rule::getDegree)
                .distinct()
                .map(DegreeResponseDto::new)
                .collect(Collectors.toList());

        log.info(degrees.toString());

    }
}
