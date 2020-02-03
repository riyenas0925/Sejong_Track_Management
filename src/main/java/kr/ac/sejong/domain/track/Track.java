package kr.ac.sejong.domain.track;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kr.ac.sejong.domain.tracksubject.TrackSubject;
import kr.ac.sejong.domain.univ.Univ;
import kr.ac.sejong.domain.rule.Rule;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@Table(name = "tbl_track")
@EqualsAndHashCode(of = "trackId")
@ToString(exclude = {"univ","trackSubjects","rules"})
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trackId;

    private String trackTitle;
    private Long trackNo;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "univId")
    Univ univ;

    @OneToMany(mappedBy = "track", cascade = CascadeType.ALL)
    List<TrackSubject> trackSubjects;

    @JsonIgnore
    @OneToMany(mappedBy = "track", cascade = CascadeType.ALL)
    List<Rule> rules;

    public Track(){

    }

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
