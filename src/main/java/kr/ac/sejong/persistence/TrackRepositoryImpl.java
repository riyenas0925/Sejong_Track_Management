package kr.ac.sejong.persistence;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPQLQuery;
import kr.ac.sejong.domain.*;
import kr.ac.sejong.dto.TrackSubjectJoinDto;
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
