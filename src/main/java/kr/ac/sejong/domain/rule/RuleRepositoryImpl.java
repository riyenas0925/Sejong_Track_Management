package kr.ac.sejong.domain.rule;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPQLQuery;
import kr.ac.sejong.domain.degree.QDegree;
import kr.ac.sejong.domain.track.QTrack;
import kr.ac.sejong.domain.univ.QUniv;
import kr.ac.sejong.web.dto.UnivTrackRuleDegreeJoinDto;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class RuleRepositoryImpl extends QuerydslRepositorySupport implements RuleCustomRepository {

    public RuleRepositoryImpl() {
        super(Rule.class);
    }

    @Override
    public List<UnivTrackRuleDegreeJoinDto> findRules() {
        QRule rule = QRule.rule;
        QDegree degree = QDegree.degree;
        QTrack track = QTrack.track;
        QUniv univ = QUniv.univ;

        JPQLQuery<UnivTrackRuleDegreeJoinDto> query = from(rule)
                .innerJoin(rule.degree, degree)
                .innerJoin(rule.track, track)
                .innerJoin(track.univ, univ)
                .select(Projections.constructor(UnivTrackRuleDegreeJoinDto.class,
                        univ.univNo,
                        univ.univTitle,
                        rule.ruleId,
                        track.trackId,
                        track.trackTitle,
                        track.trackNo,
                        rule.basicCredit,
                        rule.appliedCredit,
                        rule.industryCredit,
                        rule.expertCredit,
                        degree.degreeId,
                        degree.degreeTitle));

        return query.fetch();
    }


    @Override
    public List<UnivTrackRuleDegreeJoinDto> findByUnivId(Long univId){
        QRule rule = QRule.rule;
        QDegree degree = QDegree.degree;
        QTrack track = QTrack.track;
        QUniv univ = QUniv.univ;

        JPQLQuery<UnivTrackRuleDegreeJoinDto> query = from(rule)
                .innerJoin(rule.degree, degree)
                .innerJoin(rule.track, track)
                .innerJoin(track.univ, univ)
                .select(Projections.constructor(UnivTrackRuleDegreeJoinDto.class,
                        univ.univNo,
                        univ.univTitle,
                        rule.ruleId,
                        track.trackId,
                        track.trackTitle,
                        track.trackNo,
                        rule.basicCredit,
                        rule.appliedCredit,
                        rule.industryCredit,
                        rule.expertCredit,
                        degree.degreeId,
                        degree.degreeTitle))
                .where(univ.univId.eq(univId));

        return query.fetch();
    }

    @Override
    public List<UnivTrackRuleDegreeJoinDto> findByRuleId(Long trackId, Long degreeId){
        QRule rule = QRule.rule;
        QDegree degree = QDegree.degree;
        QTrack track = QTrack.track;
        QUniv univ = QUniv.univ;

        JPQLQuery<UnivTrackRuleDegreeJoinDto> query = from(rule)
                .innerJoin(rule.degree, degree)
                .innerJoin(rule.track, track)
                .innerJoin(track.univ, univ)
                .select(Projections.constructor(UnivTrackRuleDegreeJoinDto.class,
                        univ.univNo,
                        univ.univTitle,
                        rule.ruleId,
                        track.trackId,
                        track.trackTitle,
                        track.trackNo,
                        rule.basicCredit,
                        rule.appliedCredit,
                        rule.industryCredit,
                        rule.expertCredit,
                        degree.degreeId,
                        degree.degreeTitle))
                .where(track.trackId.eq(trackId))
                .where(degree.degreeId.eq(degreeId));

        return query.fetch();
    }
}
