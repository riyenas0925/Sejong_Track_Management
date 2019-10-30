package kr.ac.sejong.service;

import kr.ac.sejong.domain_old.resultTrackVO;
import kr.ac.sejong.domain_old.ruleVO;
import kr.ac.sejong.domain_old.trackSubjectVO;
import kr.ac.sejong.dto.StudentExcelDto;
import kr.ac.sejong.dto.TrackSubjectJoinDto;
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
public class UploadResultServiceImpl implements UploadResultService{

    @Inject
    private UploadResultDAO dao;

    @Inject
    private UploadResultService service;

    @Inject
    private TrackRuleService trackRuleService;

    @Override
    public ruleVO readRule(Integer ruleNo) throws Exception{
        return dao.readRule(ruleNo);
    }

    @Override
    public List<TrackSubjectJoinDto> readSub(Integer subType) throws Exception{
        return dao.readSub(subType);
    }

    @Override
    public List<trackSubjectVO> readTypeSub(Integer trackNo, Integer subType)throws Exception{
        return dao.readTypeSub(trackNo, subType);
    }

    @Override
    public List<StudentExcelDto> readMySub(MultipartFile excelFile) throws Exception{

        List<StudentExcelDto> mySubList = new ArrayList<StudentExcelDto>();

        HSSFWorkbook workbook = new HSSFWorkbook(excelFile.getInputStream());
        HSSFSheet sheet = workbook.getSheetAt(0);

        for(int rowindex = 0; rowindex < sheet.getPhysicalNumberOfRows(); rowindex++){
            if(rowindex != 0){
                HSSFRow row = sheet.getRow(rowindex);
                StudentExcelDto vo = new StudentExcelDto();

                vo.setCourseNum(row.getCell(2).getStringCellValue());
                vo.setCourseTitle(row.getCell(3).getStringCellValue());
                vo.setCompletionType(row.getCell(4).getStringCellValue());

                mySubList.add(vo);
            }
        }

        return mySubList;
    }

    @Override
    public HashMap<String, List<TrackSubjectJoinDto>> resultListSub(List<StudentExcelDto> myList,
                                                                    List<TrackSubjectJoinDto> standList) throws Exception{

        HashMap<String, List<TrackSubjectJoinDto>> passListSubMap = new HashMap<>();

        List<TrackSubjectJoinDto> passBasicList = new ArrayList<>();
        List<TrackSubjectJoinDto> passAppliedList = new ArrayList<>();
        List<TrackSubjectJoinDto> passIndustryList = new ArrayList<>();

        List<TrackSubjectJoinDto> nonPassBasicList = new ArrayList<>();
        List<TrackSubjectJoinDto> nonPassAppliedList = new ArrayList<>();
        List<TrackSubjectJoinDto> nonPassIndustryList = new ArrayList<>();

        for(int i=0; i < standList.size(); i++){
            if(listContains(myList, standList.get(i).getSubjectNo())){
                switch (standList.get(i).getSubjectType()){
                    case 1:
                        passBasicList.add(standList.get(i));
                        break;
                    case 2:
                        passAppliedList.add(standList.get(i));
                        break;
                    case 3:
                        passIndustryList.add(standList.get(i));
                        break;
                }
            }else{
                switch (standList.get(i).getSubjectType()){
                    case 1:
                        nonPassBasicList.add(standList.get(i));
                        break;
                    case 2:
                        nonPassAppliedList.add(standList.get(i));
                        break;
                    case 3:
                        nonPassIndustryList.add(standList.get(i));
                        break;
                }
            }
        }

        passListSubMap.put("passBasicList", passBasicList);
        passListSubMap.put("passAppliedList", passAppliedList);
        passListSubMap.put("passIndustryList",passIndustryList);

        passListSubMap.put("nonPassBasicList",nonPassBasicList);
        passListSubMap.put("nonPassAppliedList",nonPassAppliedList);
        passListSubMap.put("nonPassIndustryList",nonPassIndustryList);

        return passListSubMap;
    }

    private Boolean listContains(List<StudentExcelDto> myList, String standListNum){
        int cnt = 0;

        for(int i=0; i < myList.size(); i++){
            log.info(standListNum + " == " + myList.get(i).getCourseNum());

            if(standListNum.equals(myList.get(i).getCourseNum())) {
                log.info("test" + cnt);
                cnt++;
                break;
            }
        }

        return cnt != 0;
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
