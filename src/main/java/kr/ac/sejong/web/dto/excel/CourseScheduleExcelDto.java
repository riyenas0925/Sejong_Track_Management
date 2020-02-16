package kr.ac.sejong.web.dto.excel;

import kr.ac.sejong.web.dto.subject.SubjectRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class CourseScheduleExcelDto {
    private Long no;
    private String department;
    private String major;
    private String courseNum;
    private String courseTitle;
    private String completionType;
    private String selectedArea;
    private Long year;
    private Long credit;
    private String classType;
    private String language;

    @Builder
    public CourseScheduleExcelDto(Long no, String department, String major, String courseNum, String courseTitle,
                                  String completionType, String selectedArea, Long year, Long credit,
                                  String classType, String language) {
        this.no = no;
        this.department = department;
        this.major = major;
        this.courseNum = courseNum;
        this.courseTitle = courseTitle;
        this.completionType = completionType;
        this.selectedArea = selectedArea;
        this.year = year;
        this.credit = credit;
        this.classType = classType;
        this.language = language;
    }

    public SubjectRequestDto toSubjectDto() {
        return new SubjectRequestDto().builder()
                .courseNum(this.courseNum)
                .courseTitle(this.courseTitle)
                .credit(this.credit)
                .completionType(this.completionType)
                .selectedArea(this.selectedArea)
                .build();
    }
}