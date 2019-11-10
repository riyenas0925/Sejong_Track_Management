package kr.ac.sejong;

import kr.ac.sejong.domain.Track;
import kr.ac.sejong.domain.Univ;
import kr.ac.sejong.persistence.TrackRepository;
import kr.ac.sejong.persistence.UnivRepository;
import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
@Commit
public class TrackTest {

    @Inject
    private TrackRepository trackRepository;

    @Inject
    private UnivRepository univRepository;

    @Test
    public void createTrack(){

        Long univId = 1L;
        String trackTitle = "test";
        Long trackNo = 1000L;

        Univ univ = univRepository.getOne(univId);

        Track track = Track.createTrack(trackTitle, trackNo, univ);

        trackRepository.save(track);
    }

    @Test
    @Transactional
    public void updateTrack(){
        Long trackId = 10L;

        Track track = trackRepository.getOne(trackId);
        track.updateTrack("test", 1000L, track.getUniv());

        trackRepository.save(track);
    }

    @Test
    public void deleteTrack(){
        trackRepository.deleteById(10L);
    }

    @Test
    @Transactional
    public void trackList(){
        trackRepository.findByUnivId(2L).forEach(track -> {
            log.info(track.toString() + " : " + track.getUniv().toString());
        });
    }

    @Test
    public void standList(){
        log.info(trackRepository.standardList(1L).toString());
    }
}
