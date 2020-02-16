package kr.ac.sejong.domain.tracksubject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kr.ac.sejong.domain.subject.Subject;
import kr.ac.sejong.domain.track.Track;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "tbl_track_subject")
public class TrackSubject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trackSubjectId")
    private Long id;

    @Column
    @Enumerated(EnumType.STRING)
    private Type subjectType;

    @ManyToOne
    @JoinColumn(name = "trackId")
    Track track;

    @ManyToOne
    @JoinColumn(name = "subjectId")
    Subject subject;

    public enum Type {
        BASIC("basic"),
        COMMON("common"),
        EXPERT("expert"),
        INDUSTRY("industry"),
        APPLIED("applied");

        private String text;

        Type(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }
    }

    @Builder
    public TrackSubject(Track track, Subject subject, Type subjectType){
        this.track = track;
        this.subject = subject;
        this.subjectType = subjectType;
    }

    public void updateTrackSubject(Long id, Track track, Subject subject, Type subjectType){
        this.id = id;
        this.track = track;
        this.subject = subject;
        this.subjectType = subjectType;
    }

    public static TrackSubject createTrackSubject(Track track, Subject subject, Type subjectType){
        TrackSubject trackSubject = TrackSubject.builder()
                .track(track)
                .subject(subject)
                .subjectType(subjectType)
                .build();

        return trackSubject;
    }
}
