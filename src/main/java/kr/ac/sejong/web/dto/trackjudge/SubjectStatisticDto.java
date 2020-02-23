package kr.ac.sejong.web.dto.trackjudge;

import kr.ac.sejong.web.dto.tracksubject.TrackSubjectDto;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;

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
}