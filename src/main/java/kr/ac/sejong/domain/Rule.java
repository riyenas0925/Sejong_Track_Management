package kr.ac.sejong.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tbl_rule")
@EqualsAndHashCode(of = "ruleId")
@ToString(exclude={"degree","track"})
public class Rule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ruleId;

    private Long basicCredit;
    private Long appliedCredit;
    private Long industryCredit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trackId")
    Track track;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "degreeId")
    Degree degree;
}
