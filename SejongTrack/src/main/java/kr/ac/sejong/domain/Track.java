package kr.ac.sejong.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tbl_track")
@EqualsAndHashCode(of = "trackId")
@ToString(exclude = {"univ","trackSubjects"})
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trackId;

    private String trackTitle;
    private Long trackNo;

    @ManyToOne
    @JoinColumn(name = "univId")
    Univ univ;

    @OneToMany(mappedBy = "track")
    List<TrackSubject> trackSubjects;

    /*
    @OneToMany(mappedBy = "track", cascade = CascadeType.ALL)
    List<Rule> rules;
    */
}
