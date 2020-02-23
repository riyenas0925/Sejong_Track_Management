package kr.ac.sejong.domain.trackJudge;

import kr.ac.sejong.domain.subject.Subject;
import kr.ac.sejong.domain.tracksubject.TrackSubject;
import kr.ac.sejong.web.dto.excel.ReportCardExcelDto;
import kr.ac.sejong.web.dto.subject.SubjectRequestDto;
import kr.ac.sejong.web.dto.trackjudge.SubjectStatisticDto;
import kr.ac.sejong.web.dto.tracksubject.TrackSubjectDto;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.java.Log;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@ToString
@Log
public class TrackStatistic {
    private Map<TrackSubject.Type, Map<TrackStatistic.PNP, SubjectStatisticDto>> trackStatistic;

    public TrackStatistic(List<ReportCardExcelDto> reportCardExcelSubjects, List<TrackSubjectDto> standardSubjects){

        List<Subject> reportCardSubjects = reportCardExcelSubjects.stream()
                .map(ReportCardExcelDto::toSubjectDto)
                .map(SubjectRequestDto::toEntity)
                .collect(Collectors.toList());


        Map<TrackSubject.Type, Map<TrackStatistic.PNP, SubjectStatisticDto>> classifySubjects = standardSubjects.stream()
                .collect(
                        Collectors.groupingBy(TrackSubjectDto::getSubjectType,
                                Collectors.groupingBy(trackSubjectDto -> {
                                            if(trackSubjectDto.getSubject().toSubjectDto().isContain(reportCardSubjects)){
                                                return PNP.PASS;
                                            } else {
                                                return PNP.NON_PASS;
                                            }
                                        }
                                        ,Collectors.collectingAndThen(Collectors.toList(), list -> {
                                            return new SubjectStatisticDto(
                                                    list.stream().collect(Collectors.toList()),
                                                    list.stream().collect(Collectors.summingLong(test -> {
                                                        return test.getSubject().getCredit();
                                                    }))
                                            );
                                        })
                                )
                        )
                );

        this.trackStatistic = classifySubjects;
    }

    public enum PNP{
        PASS("pass"),
        NON_PASS("non pass");

        private String text;

        PNP(String text){
            this.text = text;
        }

        public String getText() {
            return text;
        }
    }
}