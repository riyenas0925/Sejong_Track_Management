package kr.ac.sejong.domain.track;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPQLQuery;
import kr.ac.sejong.domain.course.QCourse;
import kr.ac.sejong.domain.degree.QDegree;
import kr.ac.sejong.domain.rule.QRule;
import kr.ac.sejong.domain.trackcourse.QTrackCourse;
import kr.ac.sejong.domain.univ.QUniv;
import kr.ac.sejong.web.dto.TrackJudgeAllViewDto;
import kr.ac.sejong.web.dto.TrackSubjectJoinDto;
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
                .where(track.univ.id.eq(univId));

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
                        univ.id,
                        univ.title,
                        univ.univNo,
                        track.id,
                        track.title,
                        track.trackNo,
                        degree.id,
                        degree.title))
                .where(track.univ.id.eq(univId));
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
                        univ.id,
                        univ.title,
                        univ.univNo,
                        track.id,
                        track.title,
                        track.trackNo,
                        degree.id,
                        degree.title))
                .where(track.id.eq(trackId));
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
                        univ.id,
                        univ.title,
                        univ.univNo,
                        track.id,
                        track.title,
                        track.trackNo,
                        degree.id,
                        degree.title))
                .where(track.id.eq(trackId)
                .and(degree.id.eq(degreeId)));
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
                        univ.id,
                        univ.title,
                        univ.univNo,
                        track.id,
                        track.title,
                        track.trackNo,
                        degree.id,
                        degree.title))
                .where(track.id.eq(trackId)
                .and(degree.id.eq(degreeId))
                .and(univ.id.eq(univId)));
        return query.fetch();
    }

    @Override
    public List<TrackSubjectJoinDto> standardList(Long trackId) {

        QTrack track = QTrack.track;
        QTrackCourse trackCourse = QTrackCourse.trackCourse;
        QCourse course = QCourse.course;

        JPQLQuery<TrackSubjectJoinDto> query = from(trackCourse)
                .innerJoin(trackCourse.track, track)
                .innerJoin(trackCourse.course, course)
                .select(Projections.constructor(TrackSubjectJoinDto.class,
                        course.id,
                        course.courseNo,
                        course.title,
                        course.credit,
                        trackCourse.courseType,
                        track.id))
                .where(track.id.eq(trackId));

        return query.fetch();
    }

}
