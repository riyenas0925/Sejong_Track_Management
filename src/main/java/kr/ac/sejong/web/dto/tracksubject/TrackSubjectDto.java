package kr.ac.sejong.web.dto.tracksubject;

import kr.ac.sejong.domain.tracksubject.TrackSubject;
import kr.ac.sejong.web.dto.subject.SubjectResponseDto;
import kr.ac.sejong.web.dto.track.TrackResponseDto;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class TrackSubjectDto {
    private Long id;
    private TrackSubject.Type subjectType;
    private TrackResponseDto track;
    private SubjectResponseDto subject;

    @Builder
    public TrackSubjectDto(Long id, TrackSubject.Type subjectType, TrackResponseDto track, SubjectResponseDto subject) {
        this.id = id;
        this.subjectType = subjectType;
        this.track = track;
        this.subject = subject;
    }
}
