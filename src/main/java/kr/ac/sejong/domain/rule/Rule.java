package kr.ac.sejong.domain.rule;

import kr.ac.sejong.domain.track.Track;
import kr.ac.sejong.domain.degree.Degree;
import kr.ac.sejong.domain.trackcourse.TrackCourse;
import lombok.*;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "rule")
@NoArgsConstructor
public class Rule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long credit;

    @Column
    @Enumerated(EnumType.STRING)
    private TrackCourse.Type courseType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trackId")
    Track track;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "degreeId")
    Degree degree;

    @Builder
    public Rule(Long credit, TrackCourse.Type courseType, Track track, Degree degree) {
        this.degree = degree;
        this.track = track;
        this.courseType = courseType;
        this.credit = credit;
    }
}
