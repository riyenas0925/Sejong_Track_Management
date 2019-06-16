package kr.ac.sejong.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tbl_univ")
@EqualsAndHashCode(of = "univId")
@ToString
public class Univ {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long univId;

    private String univTitle;
    private Long univNo;

    /*
    @OneToMany(mappedBy = "univ", fetch = FetchType.EAGER)
    List<Track> tracks;
    */
}
