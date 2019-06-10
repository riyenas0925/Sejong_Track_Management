package kr.ac.sejong.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

@Data
public class UnivTrackRuleDegreeJoinDto {
    private String univTitle;
    private Long ruleId;
    private String trackTitle;
    private Long trackNo;
    private Long basicCredit;
    private Long appliedCredit;
    private Long industryCredit;

    private String degreeTitle;

    @QueryProjection
    public UnivTrackRuleDegreeJoinDto(String univTitle, long ruleId, String trackTitle, long trackNo, long basicCredit,
                                  long appliedCredit, long industryCredit, String degreeTitle) {
        this.univTitle = univTitle;
        this.ruleId = ruleId;
        this.trackTitle = trackTitle;
        this.trackNo = trackNo;
        this.basicCredit = basicCredit;
        this.appliedCredit = appliedCredit;
        this.industryCredit = industryCredit;
        this.degreeTitle = degreeTitle;
    }
}
