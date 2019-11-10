package kr.ac.sejong.service;

import kr.ac.sejong.domain_old.resultTrackVO;
import kr.ac.sejong.domain_old.ruleVO;
import kr.ac.sejong.domain_old.trackSubjectVO;
import kr.ac.sejong.dto.StudentExcelDto;
import kr.ac.sejong.dto.TrackSubjectJoinDto;
import kr.ac.sejong.persistence.TrackRepository;
import kr.ac.sejong.persistence_old.UploadResultDAO;
import lombok.extern.java.Log;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.inject.Inject;
import java.util.*;

@Service
@Log
public class TrackJudgeServiceImpl implements TrackJudgeService {

    @Inject private UploadResultDAO dao;
    @Inject private TrackJudgeService service;
    @Inject private TrackRuleService trackRuleService;
    @Inject private TrackRepository trackRepository;

    @Override
    public List<StudentExcelDto> readMySubject(MultipartFile excelFile) throws Exception{

        List<StudentExcelDto> mySubjectList = new ArrayList<>();

        HSSFWorkbook workbook = new HSSFWorkbook(excelFile.getInputStream());
        HSSFSheet sheet = workbook.getSheetAt(0);

        for(int rowindex = 0; rowindex < sheet.getPhysicalNumberOfRows(); rowindex++){
            if(rowindex != 0){
                HSSFRow row = sheet.getRow(rowindex);
                StudentExcelDto vo = StudentExcelDto.builder()
                        .year(row.getCell(2).getStringCellValue())
                        .semester(row.getCell(2).getStringCellValue())
                        .courseNum(row.getCell(2).getStringCellValue())
                        .courseTitle(row.getCell(3).getStringCellValue())
                        .completionType(row.getCell(4).getStringCellValue())
                        .teaching(row.getCell(5).getStringCellValue())
                        .selectedArea(row.getCell(6).getStringCellValue())
                        .credit(row.getCell(7).getStringCellValue())
                        .evaluation(row.getCell(8).getStringCellValue())
                        .grade(row.getCell(9).getStringCellValue())
                        .gradePoint(row.getCell(10).getStringCellValue())
                        .departmentCode(row.getCell(11).getStringCellValue())
                        .build();

                mySubjectList.add(vo);
            }
        }

        return mySubjectList;
    }

    @Override
    public HashMap<String, List<TrackSubjectJoinDto>> resultListSub(List<StudentExcelDto> myList,
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

    private Boolean listContains(List<StudentExcelDto> myList, String standardSubjectNo){
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
    public List<TrackSubjectJoinDto> readSub(Long trackId) throws Exception{
        //return dao.readSub(subType);
        return trackRepository.standardList(trackId);
    }

    @Override
    public ruleVO readRule(Integer ruleNo) throws Exception{
        return dao.readRule(ruleNo);
    }

    @Override
    public List<trackSubjectVO> readTypeSub(Integer trackNo, Integer subType)throws Exception{
        return dao.readTypeSub(trackNo, subType);
    }

    @Override
    public List<resultTrackVO> resultTrackList(Integer univNo, List<StudentExcelDto> myList)throws Exception{
        List<resultTrackVO> resultTrackList = dao.trackList(univNo);

        /*

        for(int i=0; i < resultTrackList.size(); i++){
            HashMap<String, List<trackSubjectVO>> standList = service.resultListSub(myList, service.readSub(resultTrackList.get(i).getTrackNo()));
            ruleVO rule = trackRuleService.readRule(1, resultTrackList.get(i).getTrackNo());

            Integer totalPercent = 0;
            Integer ruleTotal = rule.getApplied() + rule.getBasic();

            if(rule.getIndustry() == null){
                ruleTotal += 0;
            }else{
                ruleTotal += rule.getIndustry();
            }

            totalPercent += calCredit(standList.get("passBasicList"))
                         + calCredit(standList.get("passAppliedList"))
                         + calCredit(standList.get("passIndustryList"));

            resultTrackList.get(i).setPercent(Math.round(((float)totalPercent/ ruleTotal) * 100));
        }

        */
        return resultTrackList;
    }

    private Integer calCredit(List<trackSubjectVO> standList){
        Integer totalCredit = 0;

        for(int i=0; i < standList.size(); i++){
            totalCredit += standList.get(i).getCredit();
        }

        return totalCredit;
    }
}
