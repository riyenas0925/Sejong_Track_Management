package kr.ac.sejong.domain.TrackSubject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kr.ac.sejong.domain.Subject.Subject;
import kr.ac.sejong.domain.Track.Track;
import lombok.*;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "tbl_track_subject")
@EqualsAndHashCode(of = "id")
@ToString
public class TrackSubject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trackSubjectId")
    private Long id;

    private Long subjectType;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "trackId")
    Track track;

    @ManyToOne
    @JoinColumn(name = "subjectId")
    @JsonIgnore
    Subject subject;

    public TrackSubject(){

    }

    @Builder
    public TrackSubject(Track track, Subject subject, Long subjectType){
        this.track = track;
        this.subject = subject;
        this.subjectType = subjectType;
    }

    public static TrackSubject createTrackSubject(Track track, Subject subject, Long subjectType){
        TrackSubject trackSubject = TrackSubject.builder()
                .track(track)
                .subject(subject)
                .subjectType(subjectType)
                .build();

        return trackSubject;
    }

    public void updateTrackSubject(Long id, Track track, Subject subject, Long subjectType){
        this.id = id;
        this.track = track;
        this.subject = subject;
        this.subjectType = subjectType;
    }
}
