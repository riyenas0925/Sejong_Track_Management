package kr.ac.sejong.domain.course;

import kr.ac.sejong.domain.courseSchedule.CourseSchedule;
import kr.ac.sejong.domain.trackcourse.TrackCourse;
import lombok.*;
import lombok.extern.java.Log;

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

    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }

        final Course dto = (Course) obj;

        if(this == dto) {
            return true;
        } else {
            return (this.courseNo.equals(dto.courseNo));
        }
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (courseNo != null ? courseNo.hashCode() : 0);
        return result;
    }

    public boolean isContain(List<Course> standardCourse) {
        return standardCourse.stream()
                .filter(subject -> subject.equals(this))
                .count() != 0 ;
    }
}
