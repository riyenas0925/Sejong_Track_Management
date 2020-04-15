package kr.ac.sejong.domain.track;

import kr.ac.sejong.domain.rule.Rule;
import kr.ac.sejong.domain.trackJudge.JudgeLog.JudgeLog;
import kr.ac.sejong.domain.trackcourse.TrackCourse;
import kr.ac.sejong.domain.univ.Univ;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "track")
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private Long trackNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "univId")
    Univ univ;

    @OneToMany(mappedBy = "track", cascade = CascadeType.ALL)
    List<TrackCourse> trackCourses;

    @OneToMany(mappedBy = "track", cascade = CascadeType.ALL)
    List<Rule> rules;

    @OneToMany(mappedBy = "track", cascade = CascadeType.ALL)
    List<JudgeLog> judgeLogs;

    @Builder
    public Track(Long id, String title, Long trackNo, Univ univ){
        this.id = id;
        this.title = title;
        this.trackNo = trackNo;
        this.univ = univ;
    }

    public static Track createTrack(String trackTitle, Long trackNo, Univ univ){
        Track track = Track.builder()
                .title(trackTitle)
                .trackNo(trackNo)
                .univ(univ)
                .build();
        return track;
    }

    public void updateTrack(String trackTitle, Long trackNo, Univ univ) {
        this.title = trackTitle;
        this.trackNo = trackNo;
        this.univ = univ;
    }
}
