package kr.ac.sejong.persistence;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPQLQuery;
import kr.ac.sejong.domain.*;
import kr.ac.sejong.dto.UnivTrackRuleDegreeJoinDto;
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
                        degree.degreeId,
                        degree.degreeTitle))
                .where(univ.univId.eq(univId));

        return query.fetch();
    }

    @Override
    public List<UnivTrackRuleDegreeJoinDto> findByRuleId(Long ruleId){
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
                        degree.degreeId,
                        degree.degreeTitle))
                .where(rule.ruleId.eq(ruleId));

        return query.fetch();
    }
}
