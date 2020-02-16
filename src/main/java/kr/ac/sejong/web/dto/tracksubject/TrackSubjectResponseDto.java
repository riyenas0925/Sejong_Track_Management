package kr.ac.sejong.web.dto.tracksubject;

import kr.ac.sejong.domain.tracksubject.TrackSubject;
import kr.ac.sejong.web.dto.subject.SubjectResponseDto;
import kr.ac.sejong.web.dto.track.TrackResponseDto;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class TrackSubjectResponseDto {
    private Long id;
    private TrackSubject.Type subjectType;
    private TrackResponseDto track;
    private SubjectResponseDto subject;

    public TrackSubjectResponseDto(TrackSubject entity) {
        this.id = entity.getId();
        this.subjectType = entity.getSubjectType();
        this.subject = new SubjectResponseDto(entity.getSubject());
        this.track = new TrackResponseDto(entity.getTrack());
    }

    public TrackSubjectDto toTrackSubjectDto() {
        return TrackSubjectDto.builder()
                .id(this.id)
                .subject(this.subject)
                .subjectType(this.subjectType)
                .track(this.track)
                .build();
    }
}
