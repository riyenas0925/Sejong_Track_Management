package kr.ac.sejong.domain_jpa;

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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "trackId")
    Track track;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "degreeId")
    Degree degree;

    public static Rule createRule(Track track, Degree degree,
                                  Long basicCredit, Long appliedCredit, Long industryCredit){
        Rule rule = new Rule();

        rule.setBasicCredit(basicCredit);
        rule.setAppliedCredit(appliedCredit);
        rule.setIndustryCredit(industryCredit);

        rule.setDegree(degree);
        rule.setTrack(track);

        return rule;
    }
}
