package kr.ac.sejong.web.dto.trackjudge;

import kr.ac.sejong.web.dto.subject.SubjectDto;
import kr.ac.sejong.web.dto.tracksubject.TrackSubjectDto;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@ToString
@Getter
public class SubjectStatisticDto {
    private List<TrackSubjectDto> trackSubjectDtos;
    private Long sumCredit;

    @Builder
    public SubjectStatisticDto(List<TrackSubjectDto> trackSubjectDtos, Long sumCredit) {
        this.trackSubjectDtos = trackSubjectDtos;
        this.sumCredit = sumCredit;
    }

    public List<SubjectDto> toSubjectDto() {
        return trackSubjectDtos.stream()
                .map(trackSubjectDto -> {
                    return trackSubjectDto.getSubject().toSubjectDto();
                })
                .collect(Collectors.toList());

    }
}
