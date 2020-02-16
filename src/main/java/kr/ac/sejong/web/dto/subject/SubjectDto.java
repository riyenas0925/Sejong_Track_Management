package kr.ac.sejong.web.dto.subject;

import kr.ac.sejong.domain.courseSchedule.CourseSchedule;
import kr.ac.sejong.domain.subject.Subject;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class SubjectDto {
    private String courseNum;       //학수번호
    private String courseTitle;     //교과목명
    private String completionType;  //이수구분
    private String selectedArea;    //선택영역
    private Long credit;            //학점

    @Builder
    public SubjectDto(String courseNum, String courseTitle, String completionType, String selectedArea, Long credit) {
        this.courseNum = courseNum;
        this.courseTitle = courseTitle;
        this.completionType = completionType;
        this.selectedArea = selectedArea;
        this.credit = credit;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }

        final SubjectDto dto = (SubjectDto) obj;

        if(this == dto) {
            return true;
        } else {
            return (this.courseTitle.equals(dto.courseTitle));
        }
    }

    @Override
    public int hashCode() {
        int result = courseTitle != null ? courseTitle.hashCode() : 0;
        result = 31 * result + (courseNum != null ? courseNum.hashCode() : 0);
        result = 31 * result + (credit != null ? credit.hashCode() : 0);
        return result;
    }

    public boolean isContain(List<Subject> standardSubject) {
        boolean bool = standardSubject.stream()
                .filter(subject -> subject.getCourseNum().equals(this.courseNum))
                .count() != 0;

        return bool;
    }
}
