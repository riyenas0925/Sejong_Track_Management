package kr.ac.sejong.domain.Univ;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kr.ac.sejong.domain.Track.Track;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@Table(name = "tbl_univ")
@ToString(exclude = "tracks")
public class Univ {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long univId;

    private String univTitle;
    private Long univNo;

    @JsonIgnore
    @OneToMany(mappedBy = "univ", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Track> tracks;

    public Univ() {

    }

    @Builder
    public Univ(Long univId, String univTitle, Long univNo) {
        this.univId = univId;
        this.univTitle = univTitle;
        this.univNo = univNo;
    }
}
