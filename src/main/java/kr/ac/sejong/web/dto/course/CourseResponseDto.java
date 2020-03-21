package kr.ac.sejong.web.dto.course;

import kr.ac.sejong.domain.course.Course;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class CourseResponseDto {
    private String courseNo;       //학수번호
    private String title;     //교과목명
    private String completionType;  //이수구분
    private String selectedArea;    //선택영역
    private Long credit;            //학점

    public CourseResponseDto(Course entity) {
        this.courseNo = entity.getCourseNo();
        this.title = entity.getTitle();
        this.completionType = entity.getCompletionType();
        this.selectedArea = entity.getSelectedArea();
        this.credit = entity.getCredit();
    }
}
