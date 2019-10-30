package kr.ac.sejong.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tbl_subject")
@EqualsAndHashCode(of = "subjectId")
@ToString
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subjectId;

    private String subjectTitle;
    private Long subjectCredit;
    private Long subjectNo;

    @OneToMany(mappedBy = "subject")
    List<TrackSubject> trackSubjects;
}
