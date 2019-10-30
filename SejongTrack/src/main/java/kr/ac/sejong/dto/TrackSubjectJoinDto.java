package kr.ac.sejong.dto;

import lombok.Data;

@Data
public class TrackSubjectJoinDto {
    private Integer subjectId;
    private String subjectNo;
    private String subjectTitle;
    private Integer subjectCredit;
    private Integer subjectType;
    private Integer trackId;
}
