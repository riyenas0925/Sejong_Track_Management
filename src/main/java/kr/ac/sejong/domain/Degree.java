package kr.ac.sejong.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tbl_degree")
@EqualsAndHashCode(of = "degreeId")
@ToString
public class Degree {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long degreeId;

    private String degreeTitle;

    /*
    @OneToMany(mappedBy = "degree", cascade = CascadeType.ALL)
    List<Rule> rules;
    */
}
