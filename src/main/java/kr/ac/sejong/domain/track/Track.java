package kr.ac.sejong.domain.track;

import kr.ac.sejong.domain.tracksubject.TrackSubject;
import kr.ac.sejong.domain.univ.Univ;
import kr.ac.sejong.domain.rule.Rule;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "tbl_track")
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trackId;

    private String trackTitle;
    private Long trackNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "univId")
    Univ univ;

    @OneToMany(mappedBy = "track", cascade = CascadeType.ALL)
    List<TrackSubject> trackSubjects;

    @OneToMany(mappedBy = "track", cascade = CascadeType.ALL)
    List<Rule> rules;

    @Builder
    public Track(Long trackId, String trackTitle, Long trackNo, Univ univ){
        this.trackId = trackId;
        this.trackTitle = trackTitle;
        this.trackNo = trackNo;
        this.univ = univ;
    }

    public static Track createTrack(String trackTitle, Long trackNo, Univ univ){
        Track track = Track.builder()
                .trackTitle(trackTitle)
                .trackNo(trackNo)
                .univ(univ)
                .build();
        return track;
    }

    public void updateTrack(String trackTitle, Long trackNo, Univ univ) {
        this.trackTitle = trackTitle;
        this.trackNo = trackNo;
        this.univ = univ;
    }
}
