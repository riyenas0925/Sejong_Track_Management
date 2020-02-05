package kr.ac.sejong.domain.subject;

import kr.ac.sejong.domain.courseSchedule.CourseSchedule;
import kr.ac.sejong.domain.tracksubject.TrackSubject;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "tbl_subject")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String courseTitle;
    private String completionType;  //이수구분
    private String selectedArea;    //선택영역
    private Long credit;
    private String courseNum;

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
    List<TrackSubject> trackSubjects;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "courseScheduleId")
    CourseSchedule courseSchedule;

    @Builder
    public Subject(String courseNum, String courseTitle, String completionType, String selectedArea,
                   Long credit, CourseSchedule courseSchedule) {
        this.courseNum = courseNum;
        this.courseTitle = courseTitle;
        this.completionType = completionType;
        this.selectedArea = selectedArea;
        this.credit = credit;
        this.courseSchedule = courseSchedule;
    }

    public void update(String courseNum, String courseTitle, String completionType, String selectedArea,
                       Long credit, CourseSchedule courseSchedule) {
        this.courseNum = courseNum;
        this.courseTitle = courseTitle;
        this.completionType = completionType;
        this.selectedArea = selectedArea;
        this.credit = credit;
        this.courseSchedule = courseSchedule;
    }
}
