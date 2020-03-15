package kr.ac.sejong.web.dto.course;

import kr.ac.sejong.domain.course.Course;
import kr.ac.sejong.domain.courseSchedule.CourseSchedule;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.java.Log;

@Log
@Getter
@ToString
@RequiredArgsConstructor
public class CourseRequestDto {

    private String courseNo;       //학수번호
    private String title;     //교과목명
    private String completionType;  //이수구분
    private String selectedArea;    //선택영역
    private Long credit;            //학점
    private CourseSchedule courseSchedule;

    @Builder
    public CourseRequestDto(String courseNo, String title, String completionType, String selectedArea,
                            Long credit, CourseSchedule courseSchedule) {
        this.courseNo = courseNo;
        this.title = title;
        this.completionType = completionType;
        this.selectedArea = selectedArea;
        this.credit = credit;
        this.courseSchedule = courseSchedule;
    }

    public Course toEntity() {
        return Course.builder()
                .credit(credit)
                .title(title)
                .completionType(completionType)
                .selectedArea(selectedArea)
                .courseNo(courseNo)
                .build();
    }
}
