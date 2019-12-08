package kr.ac.sejong.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import java.util.List;

@Data
public class TrackJudgeAllViewDto {
    private Long trackId;
    private String trackTitle;
    private Long trackNo;
    private Long univId;
    private String univTitle;
    private Long univNo;
    private Long degreeId;
    private String degreeTitle;
    private List<Long> studentCredits;
    private List<Long> ruleCredits;
    private Long percent;
    
    @QueryProjection
    public TrackJudgeAllViewDto(Long univId, String univTitle, Long univNo, 
                                Long trackId, String trackTitle, Long trackNo, 
                                Long degreeId, String degreeTitle) {
        this.univId = univId;
        this.univTitle = univTitle;
        this.univNo = univNo;
        
        this.trackId = trackId;
        this.trackTitle = trackTitle;
        this.trackNo = trackNo;
        
        this.degreeId = degreeId;
        this.degreeTitle = degreeTitle;
    }
}