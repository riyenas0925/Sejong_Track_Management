package kr.ac.sejong.domain.rule;

import kr.ac.sejong.domain.degree.QDegree;
import kr.ac.sejong.domain.track.QTrack;
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
        final QDegree degree = QDegree.degree;
        final QTrack track = QTrack.track;

        return from(rule)
                .join(rule.degree, degree).fetchJoin()
                .join(rule.track, track).fetchJoin()
                .where(rule.track.id.eq(trackId))
                .where(rule.degree.id.eq(degreeId))
                .fetch();
    }

    @Override
    public List<Rule> findByUnivIdDistinct(Long univId) {
        final QRule rule = QRule.rule;

        return from(rule)
                .where(rule.track.univ.id.eq(univId))
                .distinct()
                .fetch();
    }

    @Override
    public List<Rule> findByUnivId(Long univId) {
        final QRule rule = QRule.rule;

        return from(rule)
                .where(rule.track.univ.id.eq(univId))
                .fetch();
    }

    @Override
    public List<Rule> findByTrackId(Long trackId) {
        final QRule rule = QRule.rule;

        return from(rule)
                .where(rule.track.id.eq(trackId))
                .fetch();
    }


}
