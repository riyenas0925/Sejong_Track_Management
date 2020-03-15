package kr.ac.sejong.domain.course;

import kr.ac.sejong.domain.courseSchedule.CourseSchedule;
import kr.ac.sejong.domain.trackcourse.TrackCourse;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String completionType;  //이수구분
    private String selectedArea;    //선택영역
    private Long credit;
    private String courseNo;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    List<TrackCourse> trackCourses;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "courseScheduleId")
    CourseSchedule courseSchedule;

    @Builder
    public Course(String courseNo, String title, String completionType, String selectedArea,
                  Long credit, CourseSchedule courseSchedule) {
        this.courseNo = courseNo;
        this.title = title;
        this.completionType = completionType;
        this.selectedArea = selectedArea;
        this.credit = credit;
        this.courseSchedule = courseSchedule;
    }

    public void update(String courseNum, String courseTitle, String completionType, String selectedArea,
                       Long credit, CourseSchedule courseSchedule) {
        this.courseNo = courseNum;
        this.title = courseTitle;
        this.completionType = completionType;
        this.selectedArea = selectedArea;
        this.credit = credit;
        this.courseSchedule = courseSchedule;
    }
}
