package kr.ac.sejong.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

@Data
public class UnivTrackRuleDegreeJoinDto {
    private Long univNo;
    private String univTitle;

    private Long trackId;
    private Long trackNo;
    private String trackTitle;

    private Long ruleId;
    private Long basicCredit;
    private Long appliedCredit;
    private Long industryCredit;
    private Long expertCredit;

    private Long degreeId;
    private String degreeTitle;

    @QueryProjection
    public UnivTrackRuleDegreeJoinDto(long univNo, String univTitle, long ruleId,  long trackId, String trackTitle,
                                      long trackNo, long basicCredit, long appliedCredit, long industryCredit, long expertCredit,
                                      long degreeId, String degreeTitle) {
        this.univNo = univNo;
        this.univTitle = univTitle;

        this.trackId = trackId;
        this.trackNo = trackNo;
        this.trackTitle = trackTitle;

        this.ruleId = ruleId;
        this.basicCredit = basicCredit;
        this.appliedCredit = appliedCredit;
        this.industryCredit = industryCredit;
        this.expertCredit = expertCredit;

        this.degreeTitle = degreeTitle;
        this.degreeId = degreeId;
    }
}
