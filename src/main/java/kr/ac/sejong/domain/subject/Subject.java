package kr.ac.sejong.domain.subject;

import kr.ac.sejong.domain.tracksubject.TrackSubject;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@Table(name = "tbl_subject")
@EqualsAndHashCode(of = "subjectId")
@ToString(exclude = "trackSubjects")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subjectId;

    private String subjectTitle;
    private Long subjectCredit;
    private String subjectNo;

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
    List<TrackSubject> trackSubjects;

    public Subject(){

    }

    @Builder
    public Subject(Long subjectId, String subjectTitle, Long subjectCredit, String subjectNo){
        this.subjectId = subjectId;
        this.subjectTitle = subjectTitle;
        this.subjectCredit = subjectCredit;
        this.subjectNo = subjectNo;
    }
}
