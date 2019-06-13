package kr.ac.sejong.service;

import kr.ac.sejong.domain.resultTrackVO;
import kr.ac.sejong.domain.ruleVO;
import kr.ac.sejong.domain.subjectVO;
import kr.ac.sejong.domain.trackSubjectVO;
import kr.ac.sejong.persistence.UploadFormDAO;
import kr.ac.sejong.persistence.UploadResultDAO;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.inject.Inject;
import java.io.File;
import java.io.FileInputStream;
import java.util.*;

@Service
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
    public List<trackSubjectVO> readSub(Integer subType) throws Exception{
        return dao.readSub(subType);
    }

    @Override
    public List<trackSubjectVO> readTypeSub(Integer trackNo, Integer subType)throws Exception{
        return dao.readTypeSub(trackNo, subType);
    }

    @Override
    public List<subjectVO> readMySub(MultipartFile file) throws Exception{

        List<subjectVO> mySubList = new ArrayList<subjectVO>();

        File convFile = new File(file.getOriginalFilename());
        file.transferTo(convFile);

        FileInputStream fileInputStream = new FileInputStream(convFile);

        HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
        HSSFSheet sheet = workbook.getSheetAt(0);

        for(int rowindex = 0; rowindex < sheet.getPhysicalNumberOfRows(); rowindex++){
            if(rowindex != 0){
                HSSFRow row = sheet.getRow(rowindex);
                subjectVO vo = new subjectVO();

                vo.setCourseNum(row.getCell(2).getStringCellValue());
                vo.setCourseTitle(row.getCell(3).getStringCellValue());
                vo.setCompletionType(row.getCell(4).getStringCellValue());

                mySubList.add(vo);
            }
        }

        return mySubList;
    }

    @Override
    public HashMap<String, List<trackSubjectVO>> resultListSub(List<subjectVO> myList, List<trackSubjectVO> standList) throws Exception{
        HashMap<String, List<trackSubjectVO>> passListSubMap = new HashMap<>();

        List<trackSubjectVO> passBasicList = new ArrayList<>();
        List<trackSubjectVO> passAppliedList = new ArrayList<>();
        List<trackSubjectVO> passIndustryList = new ArrayList<>();

        List<trackSubjectVO> nonPassBasicList = new ArrayList<>();
        List<trackSubjectVO> nonPassAppliedList = new ArrayList<>();
        List<trackSubjectVO> nonPassIndustryList = new ArrayList<>();

        for(int i=0; i < standList.size(); i++){
            if(listContains(myList, standList.get(i).getCourseNum())){
                switch (standList.get(i).getSubType()){
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
                switch (standList.get(i).getSubType()){
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

    private Boolean listContains(List<subjectVO> myList, String standListNum){
        int cnt = 0;
        for(int i=0; i < myList.size(); i++){
            if(standListNum.equals(myList.get(i).getCourseNum())) {
                cnt++;
                break;
            }
        }

        return cnt != 0;
    }

    @Override
    public List<resultTrackVO> resultTrackList(Integer univNo, List<subjectVO> myList)throws Exception{
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
