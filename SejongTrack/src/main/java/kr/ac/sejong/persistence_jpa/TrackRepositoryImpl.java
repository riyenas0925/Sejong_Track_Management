package kr.ac.sejong.persistence_jpa;

import com.querydsl.jpa.JPQLQuery;
import kr.ac.sejong.domain_jpa.QTrack;
import kr.ac.sejong.domain_jpa.Track;
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

}
