package kr.ac.sejong.domain.rule;

import kr.ac.sejong.domain.track.Track;
import kr.ac.sejong.domain.degree.Degree;
import lombok.*;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "rule")
@ToString(exclude = {"degree", "track"})
@NoArgsConstructor
public class Rule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long basicCredit;
    private Long appliedCredit;
    private Long industryCredit;
    private Long expertCredit;
    private Long commonCredit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trackId")
    Track track;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "degreeId")
    Degree degree;

    @Builder
    public Rule(Track track, Degree degree,
                Long id, Long basicCredit, Long appliedCredit,
                Long industryCredit, Long expertCredit, Long commonCredit) {
        this.track = track;
        this.degree = degree;
        this.id = id;
        this.basicCredit = basicCredit;
        this.appliedCredit = appliedCredit;
        this.industryCredit = industryCredit;
        this.expertCredit = expertCredit;
        this.commonCredit = commonCredit;
    }

    public static Rule createRule(Track track, Degree degree,
                                  Long basicCredit, Long appliedCredit,
                                  Long industryCredit, Long expertCredit, Long commonCredit) {
        Rule rule = Rule.builder()
                .track(track)
                .degree(degree)
                .basicCredit(basicCredit)
                .appliedCredit(appliedCredit)
                .industryCredit(industryCredit)
                .expertCredit(expertCredit)
                .commonCredit(commonCredit)
                .build();

        return rule;
    }
}
