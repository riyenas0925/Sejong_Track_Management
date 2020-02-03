package kr.ac.sejong.web.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentExcelDto {
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
}
