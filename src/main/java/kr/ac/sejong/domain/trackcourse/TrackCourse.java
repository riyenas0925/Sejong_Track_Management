package kr.ac.sejong.domain.trackcourse;

import kr.ac.sejong.domain.course.Course;
import kr.ac.sejong.domain.track.Track;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "track_course")
public class TrackCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Enumerated(EnumType.STRING)
    private Type courseType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "trackId")
    Track track;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "courseId")
    Course course;

    public enum Type {
        BASIC("기초 교과"),
        COMMON("공통 교과"),
        EXPERT("심화 교과"),
        INDUSTRY("산학 연계"),
        APPLIED("응용 교과");

        private String text;

        Type(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }
    }

    @Builder
    public TrackCourse(Track track, Course course, Type courseType){
        this.track = track;
        this.course = course;
        this.courseType = courseType;
    }

    public void updateTrackCourse(Long id, Track track, Course course, Type courseType){
        this.id = id;
        this.track = track;
        this.course = course;
        this.courseType = courseType;
    }

    public static TrackCourse createTrackCourse(Track track, Course course, Type courseType){
        TrackCourse trackCourse = TrackCourse.builder()
                .track(track)
                .course(course)
                .courseType(courseType)
                .build();

        return trackCourse;
    }
}