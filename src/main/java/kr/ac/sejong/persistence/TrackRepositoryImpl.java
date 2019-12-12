package kr.ac.sejong.persistence;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPQLQuery;
import kr.ac.sejong.domain.*;
import kr.ac.sejong.dto.TrackSubjectJoinDto;
import kr.ac.sejong.dto.TrackJudgeAllViewDto;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class TrackRepositoryImpl extends QuerydslRepositorySupport implements TrackCustomRepository{

    public TrackRepositoryImpl() {
        super(Track.class);
    }


    @Override
    public List<Track> findByUnivId(Long univId) {
        QTrack track = QTrack.track;

        JPQLQuery query = from(track)
                .where(track.univ.univId.eq(univId));

        return query.fetch();
    }
    
    @Override
    public List<TrackJudgeAllViewDto> findByUnivIdDTO(Long univId) {
        
        QRule rule = QRule.rule;
        QDegree degree = QDegree.degree;
        QTrack track = QTrack.track;
        QUniv univ = QUniv.univ;

        JPQLQuery<TrackJudgeAllViewDto> query = from(rule)
                .innerJoin(rule.degree, degree)
                .innerJoin(rule.track, track)
                .innerJoin(track.univ, univ)
                .select(Projections.constructor(TrackJudgeAllViewDto.class,
                        univ.univId,
                        univ.univTitle,
                        univ.univNo,
                        track.trackId,
                        track.trackTitle,
                        track.trackNo,
                        degree.degreeId,
                        degree.degreeTitle))
                .where(track.univ.univId.eq(univId));
        return query.fetch();
    }
    
    @Override
    public List<TrackJudgeAllViewDto> findByTrackIdDto(Long trackId){
        QRule rule = QRule.rule;
        QDegree degree = QDegree.degree;
        QTrack track = QTrack.track;
        QUniv univ = QUniv.univ;

        JPQLQuery<TrackJudgeAllViewDto> query = from(rule)
                .innerJoin(rule.degree, degree)
                .innerJoin(rule.track, track)
                .innerJoin(track.univ, univ)
                .select(Projections.constructor(TrackJudgeAllViewDto.class,
                        univ.univId,
                        univ.univTitle,
                        univ.univNo,
                        track.trackId,
                        track.trackTitle,
                        track.trackNo,
                        degree.degreeId,
                        degree.degreeTitle))
                .where(track.trackId.eq(trackId));
        return query.fetch();
    }
    
    @Override
    public List<TrackJudgeAllViewDto> findByTrackIdAndDegreeIdDto(Long trackId, Long degreeId){
        QRule rule = QRule.rule;
        QDegree degree = QDegree.degree;
        QTrack track = QTrack.track;
        QUniv univ = QUniv.univ;

        JPQLQuery<TrackJudgeAllViewDto> query = from(rule)
                .innerJoin(rule.degree, degree)
                .innerJoin(rule.track, track)
                .innerJoin(track.univ, univ)
                .select(Projections.constructor(TrackJudgeAllViewDto.class,
                        univ.univId,
                        univ.univTitle,
                        univ.univNo,
                        track.trackId,
                        track.trackTitle,
                        track.trackNo,
                        degree.degreeId,
                        degree.degreeTitle))
                .where(track.trackId.eq(trackId)
                .and(degree.degreeId.eq(degreeId)));
        return query.fetch();
    }
    
    @Override
    public List<TrackJudgeAllViewDto> findByUnivIdAndTrackIdAndDegreeIdDto(Long univId, Long trackId, Long degreeId){
        QRule rule = QRule.rule;
        QDegree degree = QDegree.degree;
        QTrack track = QTrack.track;
        QUniv univ = QUniv.univ;

        JPQLQuery<TrackJudgeAllViewDto> query = from(rule)
                .innerJoin(rule.degree, degree)
                .innerJoin(rule.track, track)
                .innerJoin(track.univ, univ)
                .select(Projections.constructor(TrackJudgeAllViewDto.class,
                        univ.univId,
                        univ.univTitle,
                        univ.univNo,
                        track.trackId,
                        track.trackTitle,
                        track.trackNo,
                        degree.degreeId,
                        degree.degreeTitle))
                .where(track.trackId.eq(trackId)
                .and(degree.degreeId.eq(degreeId))
                .and(univ.univId.eq(univId)));
        return query.fetch();
    }

    @Override
    public List<TrackSubjectJoinDto> standardList(Long trackId) {

        QTrack track = QTrack.track;
        QTrackSubject trackSubject = QTrackSubject.trackSubject;
        QSubject subject = QSubject.subject;

        JPQLQuery<TrackSubjectJoinDto> query = from(trackSubject)
                .innerJoin(trackSubject.track, track)
                .innerJoin(trackSubject.subject, subject)
                .select(Projections.constructor(TrackSubjectJoinDto.class,
                        subject.subjectId,
                        subject.subjectNo,
                        subject.subjectTitle,
                        subject.subjectCredit,
                        trackSubject.subjectType,
                        track.trackId))
                .where(track.trackId.eq(trackId));

        return query.fetch();
    }

}
