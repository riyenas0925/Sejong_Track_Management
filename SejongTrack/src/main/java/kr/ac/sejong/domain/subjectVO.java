package kr.ac.sejong.domain;

public class subjectVO {
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

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCourseNum() {
        return courseNum;
    }

    public void setCourseNum(String courseNum) {
        this.courseNum = courseNum;
    }

    public String getCompletionType() {
        return completionType;
    }

    public void setCompletionType(String completionType) {
        this.completionType = completionType;
    }

    @Override
    public String toString() {
        return "subjectVO{" +
                "courseNum='" + courseNum + '\'' +
                ", courseTitle='" + courseTitle + '\'' +
                ", completionType='" + completionType + '\'' +
                '}';
    }
}