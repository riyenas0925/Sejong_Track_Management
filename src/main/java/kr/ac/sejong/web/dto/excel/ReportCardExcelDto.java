package kr.ac.sejong.web.dto.excel;

import kr.ac.sejong.web.dto.subject.SubjectRequestDto;
import lombok.*;

@Getter
@ToString
@RequiredArgsConstructor
public class ReportCardExcelDto {
    private String year;            //년도
    private String semester;        //학기
    private String courseNum;       //학수번호
    private String courseTitle;     //교과목명
    private String completionType;  //이수구분
    private String teaching;        //교직영역
    private String selectedArea;    //선택영역
    private String credit;          //학점
    private String evaluation;      //평가방식
    private String grade;           //등급
    private String gradePoint;      //평점
    private String departmentCode;  //개설학과코드

    @Builder
    public ReportCardExcelDto(String year, String semester, String courseNum, String courseTitle, String completionType,
                              String teaching, String selectedArea, String credit, String evaluation, String grade,
                              String gradePoint, String departmentCode) {
        this.year = year;
        this.semester = semester;
        this.courseNum = courseNum;
        this.courseTitle = courseTitle;
        this.completionType = completionType;
        this.teaching = teaching;
        this.selectedArea = selectedArea;
        this.credit = credit;
        this.evaluation = evaluation;
        this.grade = grade;
        this.gradePoint = gradePoint;
        this.departmentCode = departmentCode;
    }

    public SubjectRequestDto toSubjectDto() {
        return new SubjectRequestDto().builder()
                .courseNum(this.courseNum)
                .courseTitle(this.courseTitle)
                //.credit(this.credit)
                .completionType(this.completionType)
                .selectedArea(this.selectedArea)
                .build();
    }
}
