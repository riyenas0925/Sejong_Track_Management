package kr.ac.sejong.web.dto.subject;

import kr.ac.sejong.domain.subject.Subject;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.stream.Stream;

@Getter
@ToString
public class SubjectResponseDto {
    private String courseNum;       //학수번호
    private String courseTitle;     //교과목명
    private String completionType;  //이수구분
    private String selectedArea;    //선택영역
    private Long credit;            //학점

    public SubjectResponseDto(Subject entity) {
        this.courseNum = entity.getCourseNum();
        this.courseTitle = entity.getCourseTitle();
        this.completionType = entity.getCompletionType();
        this.selectedArea = entity.getSelectedArea();
        this.credit = entity.getCredit();
    }

    public SubjectDto toSubjectDto() {
        return SubjectDto.builder()
                .courseNum(this.courseNum)
                .courseTitle(this.courseTitle)
                .completionType(this.completionType)
                .selectedArea(this.selectedArea)
                .credit(this.credit)
                .build();
    }
}
