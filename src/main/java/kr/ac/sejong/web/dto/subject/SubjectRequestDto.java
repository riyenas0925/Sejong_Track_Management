package kr.ac.sejong.web.dto.subject;

import kr.ac.sejong.domain.courseSchedule.CourseSchedule;
import kr.ac.sejong.domain.subject.Subject;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.java.Log;

@Log
@Getter
@ToString
@RequiredArgsConstructor
public class SubjectRequestDto {

    private String courseNum;       //학수번호
    private String courseTitle;     //교과목명
    private String completionType;  //이수구분
    private String selectedArea;    //선택영역
    private Long credit;            //학점
    private CourseSchedule courseSchedule;

    @Builder
    public SubjectRequestDto(String courseNum, String courseTitle, String completionType, String selectedArea,
                             Long credit, CourseSchedule courseSchedule) {
        this.courseNum = courseNum;
        this.courseTitle = courseTitle;
        this.completionType = completionType;
        this.selectedArea = selectedArea;
        this.credit = credit;
        this.courseSchedule = courseSchedule;
    }

    public Subject toEntity() {
        return Subject.builder()
                .credit(credit)
                .courseTitle(courseTitle)
                .completionType(completionType)
                .selectedArea(selectedArea)
                .courseNum(courseNum)
                .build();
    }
}
