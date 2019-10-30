package kr.ac.sejong.persistence;

import com.querydsl.jpa.JPQLQuery;
import kr.ac.sejong.domain.QTrack;
import kr.ac.sejong.domain.Track;
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

}
