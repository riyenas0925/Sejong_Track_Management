package kr.ac.sejong.domain_jpa;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    @JoinColumn(name = "univId")
    Univ univ;

    @OneToMany(mappedBy = "track")
    @JsonIgnore
    List<TrackSubject> trackSubjects;

    /*
    @OneToMany(mappedBy = "track", cascade = CascadeType.ALL)
    List<Rule> rules;
    */
}
