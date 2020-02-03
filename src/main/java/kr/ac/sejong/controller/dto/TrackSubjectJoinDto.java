package kr.ac.sejong.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

@Data
public class TrackSubjectJoinDto {
    private Long subjectId;
    private String subjectNo;
    private String subjectTitle;
    private Long subjectCredit;
    private Long subjectType;
    private Long trackId;

    @QueryProjection
    public TrackSubjectJoinDto(Long subjectId, String subjectNo, String subjectTitle, Long subjectCredit, Long subjectType, Long trackId) {
        this.subjectId = subjectId;
        this.subjectNo = subjectNo;
        this.subjectTitle = subjectTitle;
        this.subjectCredit = subjectCredit;
        this.subjectType = subjectType;
        this.trackId = trackId;
    }
}
