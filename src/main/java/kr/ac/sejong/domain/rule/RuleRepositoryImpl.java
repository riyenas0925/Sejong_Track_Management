package kr.ac.sejong.domain.rule;

import kr.ac.sejong.domain.trackcourse.QTrackCourse;
import kr.ac.sejong.domain.trackcourse.TrackCourse;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class RuleRepositoryImpl extends QuerydslRepositorySupport implements RuleCustomRepository {

    public RuleRepositoryImpl() {
        super(Rule.class);
    }


    @Override
    public List<Rule> findByTrackIdAndDegreeId(Long trackId, Long degreeId) {
        final QRule rule = QRule.rule;

        return from(rule)
                .where(rule.track.id.eq(trackId))
                .where(rule.degree.id.eq(degreeId))
                .fetch();
    }
}
