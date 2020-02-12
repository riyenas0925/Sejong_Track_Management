package kr.ac.sejong.service;

import kr.ac.sejong.web.dto.excel.ReportCardExcelDto;
import kr.ac.sejong.web.dto.UnivTrackRuleDegreeJoinDto;
import kr.ac.sejong.web.dto.TrackSubjectJoinDto;
import kr.ac.sejong.web.dto.TrackJudgeAllViewDto;

import kr.ac.sejong.domain.track.TrackRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.inject.Inject;
import java.util.*;

@RequiredArgsConstructor
@Service
@Log
public class TrackJudgeServiceImpl implements TrackJudgeService {

    private final TrackRuleService trackRuleService;
    private final TrackRepository trackRepository;

    @Override
    public HashMap<String, List<TrackSubjectJoinDto>> resultListSub(List<ReportCardExcelDto> myList,
                                                                    List<TrackSubjectJoinDto> standardList) throws Exception{

        HashMap<String, List<TrackSubjectJoinDto>> passListSubMap = new HashMap<>();

        List<TrackSubjectJoinDto> passBasicList = new ArrayList<>();
        List<TrackSubjectJoinDto> passAppliedList = new ArrayList<>();
        List<TrackSubjectJoinDto> passIndustryList = new ArrayList<>();
        List<TrackSubjectJoinDto> passExpertList = new ArrayList<>();

        List<TrackSubjectJoinDto> nonPassBasicList = new ArrayList<>();
        List<TrackSubjectJoinDto> nonPassAppliedList = new ArrayList<>();
        List<TrackSubjectJoinDto> nonPassIndustryList = new ArrayList<>();
        List<TrackSubjectJoinDto> nonPassExpertList = new ArrayList<>();

        for(int i=0; i < standardList.size(); i++){
            if(listContains(myList, standardList.get(i).getSubjectNo())){
                switch (standardList.get(i).getSubjectType().intValue()){
                    case 1:
                        passBasicList.add(standardList.get(i));
                        break;
                    case 2:
                        passAppliedList.add(standardList.get(i));
                        break;
                    case 3:
                        passIndustryList.add(standardList.get(i));
                        break;
                    case 4:
                        passExpertList.add(standardList.get(i));
                }
            }else{
                switch (standardList.get(i).getSubjectType().intValue()){
                    case 1:
                        nonPassBasicList.add(standardList.get(i));
                        break;
                    case 2:
                        nonPassAppliedList.add(standardList.get(i));
                        break;
                    case 3:
                        nonPassIndustryList.add(standardList.get(i));
                        break;
                    case 4:
                        nonPassExpertList.add(standardList.get(i));
                }
            }
        }

        passListSubMap.put("passBasicList", passBasicList);
        passListSubMap.put("passAppliedList", passAppliedList);
        passListSubMap.put("passIndustryList",passIndustryList);
        passListSubMap.put("passExpertList",passExpertList);

        passListSubMap.put("nonPassBasicList",nonPassBasicList);
        passListSubMap.put("nonPassAppliedList",nonPassAppliedList);
        passListSubMap.put("nonPassIndustryList",nonPassIndustryList);
        passListSubMap.put("nonPassExpertList",nonPassExpertList);

        return passListSubMap;
    }

    private Boolean listContains(List<ReportCardExcelDto> myList, String standardSubjectNo){
        int cnt = 0;

        for(int i=0; i < myList.size(); i++){
            log.info(standardSubjectNo + " == " + myList.get(i).getCourseNum());

            if(standardSubjectNo.equals(myList.get(i).getCourseNum())) {
                cnt++;
                break;
            }
        }

        return cnt != 0;
    }

    @Override
    public List<TrackJudgeAllViewDto> trackJudgeList(Long univId, List<ReportCardExcelDto> studentExcel)throws Exception{
        List<TrackJudgeAllViewDto> trackJudgeList = trackRepository.findByUnivIdDTO(univId);
        
        Long degreeId = trackJudgeList.get(0).getDegreeId();
        
        trackJudgeList = trackJudge(degreeId, trackJudgeList, studentExcel);
        
        return trackJudgeList;
    }
    
    @Override
    public TrackJudgeAllViewDto trackJudgeOne(Long univId, Long trackId, Long degreeId, List<ReportCardExcelDto> studentExcel)throws Exception{
        List<TrackJudgeAllViewDto> trackJudgeOne = trackRepository.findByUnivIdAndTrackIdAndDegreeIdDto(univId, trackId, degreeId);
        
        trackJudgeOne = trackJudge(degreeId, trackJudgeOne, studentExcel);
        
        return trackJudgeOne.get(0);
    }
    
    private List<TrackJudgeAllViewDto> trackJudge(Long degreeId,
                                                  List<TrackJudgeAllViewDto> trackJudgeList,
                                                  List<ReportCardExcelDto> myList)throws Exception{
        
        for(int i=0; i < trackJudgeList.size(); i++){
            Long trackId = trackJudgeList.get(i).getTrackId();
            
            List<TrackSubjectJoinDto> standList = readSub(trackId);

            HashMap<String, List<TrackSubjectJoinDto>> resultListSub = resultListSub(myList, standList);

            UnivTrackRuleDegreeJoinDto rule = trackRuleService.findByRuleId(trackId, degreeId).get(0);
                                    
            Long ruleTotal = rule.getAppliedCredit() 
                           + rule.getBasicCredit() 
                           + rule.getIndustryCredit() 
                           + rule.getExpertCredit();

            Long basicCreditTotal = calCredit(resultListSub.get("passBasicList"));
            Long appliedCreditTotal = calCredit(resultListSub.get("passAppliedList"));
            Long expertCreditTotal = calCredit(resultListSub.get("passExpertList"));
            Long industryCreditTotal = calCredit(resultListSub.get("passIndustryList"));
            
            Long studentTotal = basicCreditTotal
                              + appliedCreditTotal
                              + expertCreditTotal
                              + industryCreditTotal;
            
            Long percent = new Long(Math.round(((float)studentTotal/ruleTotal) * 100));
            
            List<Long> studentCredits = new ArrayList<>(
                Arrays.asList(basicCreditTotal, 
                              appliedCreditTotal,
                              expertCreditTotal,
                              industryCreditTotal)
            );

            List<Long> ruleCredits = new ArrayList<>(
                Arrays.asList(rule.getBasicCredit(), 
                              rule.getAppliedCredit(),
                              rule.getExpertCredit(),
                              rule.getIndustryCredit())
            );

            trackJudgeList.get(i).setPercent(percent);
            trackJudgeList.get(i).setStudentCredits(studentCredits);
            trackJudgeList.get(i).setRuleCredits(ruleCredits);
        }
        
        return trackJudgeList;
    }

    private Long calCredit(List<TrackSubjectJoinDto> subjectList){
        Long totalCredit = 0L;
                    
        for(int i=0; i < subjectList.size(); i++){
            totalCredit += subjectList.get(i).getSubjectCredit();
        }

        return totalCredit;
    }
    
    @Override
    public List<TrackSubjectJoinDto> readSub(Long trackId) throws Exception{
        return trackRepository.standardList(trackId);
    }
}
