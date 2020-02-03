package kr.ac.sejong.web.dto;

import lombok.Data;

@Data
public class TrackAllViewDto {
    private Integer trackId;
    private String trackTitle;
    private String trackBasic;
    private String trackApplied;
    private String trackIndustry;
    private String trackExpert;
}
