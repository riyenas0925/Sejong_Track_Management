package kr.ac.sejong.web.dto.course;

import kr.ac.sejong.domain.course.Course;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class CourseDto {
    private String courseNo;       //학수번호
    private String title;     //교과목명
    private String completionType;  //이수구분
    private String selectedArea;    //선택영역
    private Long credit;            //학점

    @Builder
    public CourseDto(String courseNo, String title, String completionType, String selectedArea, Long credit) {
        this.courseNo = courseNo;
        this.title = title;
        this.completionType = completionType;
        this.selectedArea = selectedArea;
        this.credit = credit;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }

        final CourseDto dto = (CourseDto) obj;

        if(this == dto) {
            return true;
        } else {
            return (this.title.equals(dto.title));
        }
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (courseNo != null ? courseNo.hashCode() : 0);
        result = 31 * result + (credit != null ? credit.hashCode() : 0);
        return result;
    }

    public boolean isContain(List<Course> standardCourse) {
        boolean bool = standardCourse.stream()
                .filter(subject -> subject.getCourseNo().equals(this.courseNo))
                .count() != 0;

        return bool;
    }
}
